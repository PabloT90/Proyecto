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
            //fw = new FileWriter("F:\\Proyecto\\Proyecto\\src\\Ficheros\\FicheroMovimientoNuevosProductos.txt", true);
            fw = new FileWriter("src\\Ficheros\\FicheroMovimientoNuevosProductos.txt", true);
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

    /**
     * Obtiene un tipo ImplStockProducto del fichero AlmacenProductos.
     * @param id ID del producto.
     * @return Asociado al nombre devuelve un tipo ImplStockProducto si se ha encontrado un producto con la
     * misma ID en el almacén, en caso contrario devuelve null.
     */
    public ImplStockProducto obtenerProductoAlmacen(int id){
        ImplStockProducto producto = null;
        //Buscamos el producto en el almacén.
        producto = buscarEnAlmacen(id,"src\\Ficheros\\AlmacenProductos.txt");

        //Si el producto no se encontraba en el almacén se buscará en el fichero de movimientos de productos.
        if(producto == null)
            producto = buscarEnAlmacen(id,"src\\Ficheros\\FicheroMovimientoNuevosProductos.txt");

        return producto;
    }

    /*
     * Interfaz
     * Nombre: buscarEnAlmacen
     * Comentario: La función nos permite obtener un tipo ImplStockProducto un directorio dado.
     * Se pasará por parámetros un número de id y una direccion.
     * si no existe un producto con la misma id en el almacen la función devuelve null.
     * Cabecera: public ImplStockProducto buscarEnAlmacen(int ID, String direccion)
     * Entrada:
     *   -entero ID
     *   -direccion String
     * Salida:
     *   -ImplStockProducto producto
     * Precondiciones:
     *   -id debe ser mayor o igual que 0.
     *   -direccion el fichero debe existir.
     * Postcondiciones: La función devuelve un tipo ImplStockProducto asociado al nombre, si
     * se ha encontrado un producto con la misma id en el almacén, en caso contrario la función
     * devuelve null.
     * */
    /**
     * Obtiene un tipo ImplStockProducto de un directorio.
     * @param ID ID del producto.
     * @param direccion Dirección del directorio donde vamos a buscar el producto.
     * @return Asociado al nombre devuelve un tipo ImplStockProducto si se ha encontrado un producto con el mismo ID
     * en el almacén y null en caso contrario.
     */
    public ImplStockProducto buscarEnAlmacen(int ID, String direccion){
        ImplStockProducto producto = null;
        int stock = 0;
        double precio = 0.0;
        boolean vegano;
        EnumTipo tipo = null;
        FileReader fr1 = null;
        BufferedReader br1 = null;
        String registro = " ";
        String[] separador = null;

        try{
            //fr2 = new FileReader("src\\Ficheros\\FicheroMovimientoNuevosProductos.txt");
            fr1 = new FileReader(direccion);
            br1 = new BufferedReader(fr1);
            registro = br1.readLine();

            while (registro != null && producto == null) {//Mientras no sea fin de fichero y no se haya encontrado el producto
                separador = registro.split(",");//Separamos el registro en campos

                if (Integer.parseInt(separador[0]) == ID && separador[3].charAt(0) != '*') {//Si los id's coinciden
                    tipo = EnumTipo.valueOf(separador[1]);
                    precio = Double.parseDouble(separador[2]);
                    vegano = Boolean.parseBoolean(separador[5]);
                    stock = Integer.parseInt(separador[6]);
                    producto = new ImplStockProducto(ID, tipo, precio, separador[3], separador[4], vegano, stock);
                } else {
                    registro = br1.readLine();
                }
            }
        }catch(FileNotFoundException error1){
            error1.printStackTrace();
        }catch(IOException error2){
            error2.printStackTrace();
        }finally{
            try{
                br1.close();
                fr1.close();
            }catch (IOException error){
                error.printStackTrace();
            }
        }
        return producto;
    }

    /*
    * Interfaz
    * Nombre: mostrarProductosAlmacen
    * Comentario: Esta función nos permite mostrar por pantalla los productos del
    * almacén.
    * Cabecera: public void mostrarProductosAlmacen()
    * Postcondiciones: Nada, solo se muestra por pantalla los productos del almacén.
    * */

    /**
     * Permite mostrar todos los productos del almacen
     * Postcondiciones: nada, solo se muestran todos los productos del almacen.
     */
    public void mostrarProductosAlmacen(){
        //Se muestran los productos del almacén.
        mostrarProductosAlmacen("src\\Ficheros\\AlmacenProductos.txt");
        //Se muestran los productos del fichero de movimiento.
        mostrarProductosAlmacen("src\\Ficheros\\FicheroMovimientoNuevosProductos.txt");
    }

    /*
     * Interfaz
     * Nombre: mostrarProductosAlmacen
     * Comentario: Esta función nos permite mostrar por pantalla los productos del
     * almacén.
     * Entrada:
     *  -direccion String
     * Cabecera: public void mostrarProductosAlmacen()
     * Postcondiciones: Nada, solo se muestra por pantalla los productos del almacén.
     * */

    /**
     * Muestra en pantalla los productos del fichero AlmacenProductos
     * @param direccion Dirección en la que se guarda el fichero a leer.
     */
    public void mostrarProductosAlmacen(String direccion){
        FileReader fr1 = null;
        BufferedReader br1 = null;
        String[] partesRegistro = null;
        String registro = " ";

        try{
            fr1 = new FileReader(direccion);
            br1 = new BufferedReader(fr1);

            registro = br1.readLine();
            if(registro != null){
                partesRegistro = registro.split(",");//Separamos el registro en campos
            }
            while(registro != null){
                if(partesRegistro[3].charAt(0) != '*'){
                    System.out.println(registro);
                }

                registro = br1.readLine();
                if(registro != null){
                    partesRegistro = registro.split(",");//Separamos el registro en campos
                }
            }
        }catch (FileNotFoundException error1){
            error1.printStackTrace();
        }catch (IOException error2){
            error2.printStackTrace();
        }finally{
            try{ //Cerramos los streams
                br1.close();
                fr1.close();
            }catch (IOException error){
                error.printStackTrace();
            }
        }
    }

    /*
     * Interfaz
     * Nombre: mostrarProductosVeganos
     * Comentario: Esta función nos permite mostrar por pantalla los productos veganos del
     * almacén.
     * Cabecera: public void mostrarProductosVeganos()
     * Postcondiciones: Nada, solo se muestra por pantalla los productos veganos del almacén.
     * */

    /**
     * Muestra por pantalla todos los productos veganos
     * Postcondiciones: nada, solo se muestra por pantalla los productos veganos del almacen.
     */
    public void mostrarProductosVeganos(){
        mostrarProductosVeganos("src\\Ficheros\\AlmacenProductos.txt");
        mostrarProductosVeganos("src\\Ficheros\\FicheroMovimientoNuevosProductos.txt");
    }

    /*
     * Interfaz
     * Nombre: mostrarProductosVeganosAlmacen
     * Comentario: Esta función muestra por pantalla todos los productos veganos del
     * almacén.
     * Cabecera: public void mostrarProductosVeganosAlmacen()
     * Postcondiciones: Nada, solo se muestra por pantalla todos los productos veganos
     * del almacén.
     * */
    /**
     * Muestra los productos veganos del almacén.
     * @param direccion Dirección en la que se encuentra el fichero en que realizamos la busqueda.
     */
    public void mostrarProductosVeganos(String direccion){
        FileReader fr1 = null;
        BufferedReader br1 = null;
        String registro = " ";
        String[] partesRegistro = null;

        try{
            fr1 = new FileReader(direccion);
            br1 = new BufferedReader(fr1);

            registro = br1.readLine();
            if(registro != null){
                partesRegistro = registro.split(",");//Separamos el registro en campos
            }
            while(registro != null) {
                if(partesRegistro[3].charAt(0) != '*' && Boolean.parseBoolean(partesRegistro[5]) == true){
                    System.out.println(registro);
                }

                registro = br1.readLine();
                if(registro != null){
                    partesRegistro = registro.split(",");//Separamos el registro en campos
                }
            }
        }catch (FileNotFoundException error1){
            error1.printStackTrace();
        }catch (IOException error2){
            error2.printStackTrace();
        }finally{
            try{ //Cerramos los streams
                br1.close();
                fr1.close();
            }catch (IOException error){
                error.printStackTrace();
            }
        }
    }

}
