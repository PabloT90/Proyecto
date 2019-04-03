package Clases;

import Enums.EnumTipo;

import java.io.*;

public class FuncionesProductos {

    /*
     * Interfaz
     * Nombre: insertarProducto
     * Comentario: Esta función permite insertar un producto en el almacen.
     * Cabecera: public void insertarProducto(ImplStockProducto producto)
     * Entrada:
     *   -ImplStockProducto producto
     * Postcondiciones: La función inserta un tipo ImplStockProducto en el fichero
     * del almacén.
     * */

    /**
     * Inserta un producto en el almacen.
     * @param producto Producto que se quiere insertar.
     * Postcondiciones: La función inserta un tipo ImplStockProducto en el fichero del almacen.
     * Cabecera: public void insertarProducto(ImplStockProducto producto)
     */
    public void insertarProducto(ImplStockProducto producto){
        FileWriter fw = null;
        BufferedWriter bw = null;

        try{
            fw = new FileWriter("F:\\Proyecto\\Proyecto\\src\\Ficheros\\FicheroMovimientoNuevosProductos.txt", true);
            bw = new BufferedWriter(fw);
            //Insertamos el nuevo producto en el almacén
            bw.write(producto.toString());
            bw.newLine();
            bw.flush();

        } catch(IOException error){
            error.printStackTrace();
        }finally {
            try{
                bw.close();
                fw.close();
            }catch (IOException error){
                error.printStackTrace();
            }
        }
    }

    /*
    * Interfaz
    * Nombre: obtenerProductoAlmacen
    * Comentario: La función nos permite obtener un tipo ImplStockProducto
    * del fichero AlmacenProductos. Se pasará por parámetros un número de id,
    * si no existe un producto con la misma id en el almacen la función devuelve null.
    * Cabecera: public ImplStockProducto obtenerProductoAlmacen(int id)
    * Entrada:
    *   -entero id
    * Salida:
    *   -ImplStockProducto producto
    * Precondiciones:
    *   -id debe ser mayor o igual que 0.
    * Postcondiciones: La función devuelve un tipo ImplStockProducto asociado al nombre, si
    * se ha encontrado un producto con la misma id en el almacén, en caso contrario la función
    * devuelve null.
    * */
    public ImplStockProducto obtenerProductoAlmacen(int id){
        ImplStockProducto producto = null;
        int stock = 0;
        double precio = 0.0;
        boolean vegano;
        EnumTipo tipo = null;
        FileReader fr1 = null, fr2 = null;
        BufferedReader br1 = null, br2 = null;
        String registro = " ";
        String[] separador;

        try{
            fr1 = new FileReader("F:\\Proyecto\\Proyecto\\src\\Ficheros\\AlmacenProductos.txt");
            br1 = new BufferedReader(fr1);
            //Buscamos el producto en el almacén
            registro = br1.readLine();
            while(registro != null && producto == null){//Mientras no sea fin de fichero y no se haya encontrado el producto
                separador = registro.split(",");//Separamos el registro en campos

                if(Integer.parseInt(separador[0]) == id){//Si los id's coinciden
                    tipo = EnumTipo.valueOf(separador[1]);
                    precio = Double.parseDouble(separador[2]);
                    vegano = Boolean.parseBoolean(separador[5]);
                    stock = Integer.parseInt(separador[6]);
                    producto = new ImplStockProducto(id, tipo, precio, separador[3], separador[4], vegano, stock);
                }else{
                    registro = br1.readLine();
                }
            }
            br1.close();//Cerramos los dos streams
            fr1.close();
            //Si el producto no se encontraba en el almacén se buscará en el fichero de movimientos de productos.
            if(producto == null){
                fr2 = new FileReader("F:\\Proyecto\\Proyecto\\src\\Ficheros\\FicheroMovimientoNuevosProductos.txt");
                br2 = new BufferedReader(fr2);

                registro = br2.readLine();
                while(registro != null && producto == null){//Mientras no sea fin de fichero y no se haya encontrado el producto
                    separador = registro.split(",");//Separamos el registro en campos

                    if(Integer.parseInt(separador[0]) == id){//Si los id's coinciden
                        tipo = EnumTipo.valueOf(separador[1]);
                        precio = Double.parseDouble(separador[2]);
                        vegano = Boolean.parseBoolean(separador[5]);
                        stock = Integer.parseInt(separador[6]);
                        producto = new ImplStockProducto(id, tipo, precio, separador[3], separador[4], vegano, stock);
                    }else{
                        registro = br2.readLine();
                    }
                }
                br2.close();//Cerramos ambos streams
                fr2.close();
            }
        }catch(FileNotFoundException error1){
            error1.printStackTrace();
        }catch(IOException error2){
            error2.printStackTrace();
        }
        return producto;
    }
}
