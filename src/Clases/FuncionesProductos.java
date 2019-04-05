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
        producto = buscarEnAlmacen(id);
        
        //Si el producto no se encontraba en el almacén se buscará en el fichero de movimientos de productos.
        if(producto == null)
            producto = buscarEnFicheroMovimiento(id);

        return producto;
    }

    /*
     * Interfaz
     * Nombre: buscarEnAlmacen
     * Comentario: La función nos permite obtener un tipo ImplStockProducto
     * del fichero AlmacenProductos. Se pasará por parámetros un número de id,
     * si no existe un producto con la misma id en el almacen la función devuelve null.
     * Cabecera: public ImplStockProducto buscarEnAlmacen(int id)
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
     * Obtiene un tipo ImplStockProducto del fichero AlmacenProductos
     * @param id ID del producto.
     * @return Asociado al nombre devuelve un tipo ImplStockProducto si se ha encontrado un producto con el mismo ID
     * en el almacén y null en caso contrario.
     */
    public ImplStockProducto buscarEnAlmacen(int id){
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
            //fr1 = new FileReader("F:\\Proyecto\\Proyecto\\src\\Ficheros\\AlmacenProductos.txt");
            fr1 = new FileReader("src\\Ficheros\\AlmacenProductos.txt");
            br1 = new BufferedReader(fr1);

            //Buscamos el producto en el almacén
            registro = br1.readLine();

            if(registro != null){
                separador = registro.split(",");//Separamos el registro en campos
            }
            //Mientras no sea fin de fichero, no se haya encontrado el producto y sea posible encontrar el producto
            while(registro != null && producto == null && Integer.parseInt(separador[0]) <= id){
                if(Integer.parseInt(separador[0]) == id){//Si los id's coinciden
                    tipo = EnumTipo.valueOf(separador[1]);
                    precio = Double.parseDouble(separador[2]);
                    vegano = Boolean.parseBoolean(separador[5]);
                    stock = Integer.parseInt(separador[6]);
                    producto = new ImplStockProducto(id, tipo, precio, separador[3], separador[4], vegano, stock);
                }else{
                    registro = br1.readLine();
                    if(registro != null){
                        separador = registro.split(",");//Separamos el registro en campos
                    }
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
     * Nombre: buscarEnFicheroMovimiento
     * Comentario: La función nos permite obtener un tipo ImplStockProducto
     * del fichero AlmacenProductos. Se pasará por parámetros un número de id,
     * si no existe un producto con la misma id en el fichero de movimiento la función devuelve null.
     * Cabecera: public ImplStockProducto buscarEnFicheroMovimiento(int id)
     * Entrada:
     *   -entero id
     * Salida:
     *   -ImplStockProducto producto
     * Precondiciones:
     *   -id debe ser mayor o igual que 0.
     * Postcondiciones: La función devuelve un tipo ImplStockProducto asociado al nombre, si
     * se ha encontrado un producto con la misma id en el fichero de movimiento, en caso contrario la función
     * devuelve null.
     * */

    /**
     * Obtiene un tipo ImplStockProducto del fichero AlmacenProductos.
     * @param id ID del producto.
     * @return Asociado al nombre devuelve un tipo ImplStockProducto si se ha encontrado algun producto con el mismo ID
     * pasado por parametro, en caso contrario devuelve null.
     */
    public ImplStockProducto buscarEnFicheroMovimiento(int id) {
        ImplStockProducto producto = null;
        int stock = 0;
        double precio = 0.0;
        boolean vegano;
        EnumTipo tipo = null;
        FileReader fr2 = null;
        BufferedReader br2 = null;
        String registro = " ";
        String[] separador = null;

        try{
            //fr2 = new FileReader("F:\\Proyecto\\Proyecto\\src\\Ficheros\\FicheroMovimientoNuevosProductos.txt");
            fr2 = new FileReader("src\\Ficheros\\FicheroMovimientoNuevosProductos.txt");
            br2 = new BufferedReader(fr2);
            registro = br2.readLine();

            while (registro != null && producto == null) {//Mientras no sea fin de fichero y no se haya encontrado el producto
                separador = registro.split(",");//Separamos el registro en campos

                if (Integer.parseInt(separador[0]) == id) {//Si los id's coinciden
                    tipo = EnumTipo.valueOf(separador[1]);
                    precio = Double.parseDouble(separador[2]);
                    vegano = Boolean.parseBoolean(separador[5]);
                    stock = Integer.parseInt(separador[6]);
                    producto = new ImplStockProducto(id, tipo, precio, separador[3], separador[4], vegano, stock);
                } else {
                    registro = br2.readLine();
                }
            }
        }catch(FileNotFoundException error1){
                error1.printStackTrace();
        }catch(IOException error2){
                error2.printStackTrace();
        }finally{
            try{
                br2.close();
                fr2.close();
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
        mostrarAlmacenProductos();
        //Se muestran los productos del fichero de movimiento.
        mostrarFicheroMov();
    }

    /*
     * Interfaz
     * Nombre: mostrarAlmacenProductos
     * Comentario: Esta función nos permite mostrar por pantalla los productos del
     * almacén.
     * Cabecera: public void mostrarAlmacenProductos()
     * Postcondiciones: Nada, solo se muestra por pantalla los productos del almacén.
     * */

    /**
     * Muestra en pantalla los productos del fichero AlmacenProductos
     */
    public void mostrarAlmacenProductos(){
        FileReader fr1 = null;
        BufferedReader br1 = null;
        String registro = " ";

        try{
            fr1 = new FileReader("src\\Ficheros\\AlmacenProductos.txt");
            br1 = new BufferedReader(fr1);

            registro = br1.readLine();

            while(registro != null){
                System.out.println(registro);
                registro = br1.readLine();
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
     * Nombre: mostrarFicheroMov
     * Comentario: Esta función nos permite mostrar por pantalla los productos del
     * almacén.
     * Cabecera: public void mostrarFicheroMov()
     * Postcondiciones: Nada, solo se muestra por pantalla los productos que se encuentran en el fichero de movimiento.
     * */
    /**
     * Muestra los productos del fichero FicheroMovimientoNuevosProductos.
     */
    public void mostrarFicheroMov(){
        FileReader fr1 = null;
        BufferedReader br1 = null;
        String registro = " ";

        try{
            fr1 = new FileReader("src\\Ficheros\\FicheroMovimientoNuevosProductos.txt");
            br1 = new BufferedReader(fr1);

            registro = br1.readLine();

            while(registro != null) {
                System.out.println(registro);
                registro = br1.readLine();
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
        System.out.println("mostrarProductosVeganos en resguardo.");
    }
}
