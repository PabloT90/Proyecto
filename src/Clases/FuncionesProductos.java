package Clases;

import Enums.EnumTipo;
import java.io.*;
public class FuncionesProductos {
    /*
     * Interfaz
     * Nombre: insertarProducto (Funciona)
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
            //fw = new FileWriter("F:\\Proyecto\\Proyecto\\src\\Ficheros\\Movimientos.txt", true);
            fw = new FileWriter("src\\Ficheros\\Movimientos.txt", true);
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
     **/
    /**
     * Obtiene un tipo ImplStockProducto del fichero AlmacenProductos.
     * @param id ID del producto.
     * @return Asociado al nombre devuelve un tipo ImplStockProducto si se ha encontrado un producto con la
     * misma ID en el almacén, en caso contrario devuelve null.
     */
    public ImplStockProducto obtenerProductoAlmacen(int id){
        ImplStockProducto producto = null;

        //Buscamos en el fichero de movimientos
        producto = buscarEnMovimientos(id);
        //Si el producto no se encontraba en el fichero de movimientos se buscará en el almacén de productos.
        if(producto == null && !productoEliminado(id)) //Si no se ha encontrado en el fichero de mov y no se ha marcado como eliminado.
            producto = buscarEnAlmacen(id);

        return producto;
    }

    /*
     * Interfaz
     * Nombre: buscarEnAlmacen
     * Comentario: La función nos permite obtener un tipo ImplStockProducto del fichero
     * AlmacenProductos.txt.
     * Se pasará por parámetros un número de id.
     * Si no existe un producto con la misma id en el almacen la función devuelve null.
     * Cabecera: public ImplStockProducto buscarEnAlmacen(int ID)
     * Entrada:
     *   -entero ID
     * Salida:
     *   -ImplStockProducto producto
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
    public ImplStockProducto buscarEnAlmacen(int ID){
        ImplStockProducto producto = null;
        int stock = 0;
        double precio = 0.0;
        boolean vegano, rangoValido = true;
        EnumTipo tipo = null;
        FileReader fr1 = null;
        BufferedReader br1 = null;
        String registro = " ";
        String[] separador = null;

        try{
            fr1 = new FileReader("src\\Ficheros\\AlmacenProductos.txt");
            br1 = new BufferedReader(fr1);
            registro = br1.readLine();
            //Mientras no sea fin de fichero, no se haya encontrado el producto y sea posible encontrarlo aún.
            while (registro != null && producto == null && rangoValido == true) {
                separador = registro.split(",");//Separamos el registro en campos

                if (Integer.parseInt(separador[0]) == ID) {//Si los id's coinciden
                    tipo = EnumTipo.valueOf(separador[1]);
                    precio = Double.parseDouble(separador[2]);
                    vegano = Boolean.parseBoolean(separador[5]);
                    stock = Integer.parseInt(separador[6]);
                    producto = new ImplStockProducto(ID, tipo, precio, separador[3], separador[4], vegano, stock);
                } else {
                    if(Integer.parseInt(separador[0]) > ID){
                        rangoValido = false;
                    }else{
                        registro = br1.readLine();
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
     * Nombre: buscarEnMovimientos
     * Comentario: La función nos permite obtener un tipo ImplStockProducto del fichero
     * Movimientos.txt.
     * Se pasará por parámetros un número de id.
     * Si no existe un producto con la misma id en el almacen la función devuelve null.
     * Cabecera: public ImplStockProducto buscarEnMovimientos(int ID)
     * Entrada:
     *   -entero ID
     * Salida:
     *   -ImplStockProducto producto
     * Postcondiciones: La función devuelve un tipo ImplStockProducto asociado al nombre, si
     * se ha encontrado un producto con la misma id en el fichero de movimientos, en caso
     * contrario la función devuelve null.
     * */
    public ImplStockProducto buscarEnMovimientos(int id){
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
            fr1 = new FileReader("src\\Ficheros\\Movimientos.txt");
            br1 = new BufferedReader(fr1);
            registro = br1.readLine();
            //Mientras no sea fin de fichero.
            while (registro != null) {
                separador = registro.split(",");//Separamos el registro en campos

                if (Integer.parseInt(separador[0]) == id) {//Si los id's coinciden
                    tipo = EnumTipo.valueOf(separador[1]);
                    precio = Double.parseDouble(separador[2]);
                    vegano = Boolean.parseBoolean(separador[5]);
                    stock = Integer.parseInt(separador[6]);
                    producto = new ImplStockProducto(id, tipo, precio, separador[3], separador[4], vegano, stock);
                }
                    registro = br1.readLine();
            }
            //Si el producto no es nulo y el último registro del producto fue una eliminación
            if(producto != null && productoEliminado(id)){
                producto = null;
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
    * Comentario: Esta función nos permite mostrar por pantalla todos los productos del
    * almacén. Tanto de fichero de movimiento como de almacen.
    * Cabecera: public void mostrarProductosAlmacen()
    * Postcondiciones: Nada, solo se muestra por pantalla los productos del almacén.
    * */

    /**
     * Permite mostrar todos los productos del almacen.
     * Postcondiciones: nada, solo se muestran todos los productos del almacen.
     */
    public void mostrarProductosAlmacen(){
        ImplStockProducto producto = null;
        FileReader fr1 = null;
        BufferedReader br1 = null;
        FileReader fr2 = null;
        BufferedReader br2 = null;
        String registro1, registro2;
        String[] separador1 = null, separador2 = null;

        try{
            fr1 = new FileReader("src\\Ficheros\\AlmacenProductos.txt");
            br1 = new BufferedReader(fr1);
            fr2 = new FileReader("src\\Ficheros\\Movimientos.txt");
            br2 = new BufferedReader(fr2);

            registro1 = br1.readLine();
            registro2 = br2.readLine();
            while(registro1 != null && registro2 != null){//Mientras no haya ningún fin de fichero
                separador1 = registro1.split(",");
                separador2 = registro2.split(",");
                if(Integer.parseInt(separador1[0]) < Integer.parseInt(separador2[0])){
                    System.out.println(registro1);
                    registro1 = br1.readLine();
                }else{
                    if(Integer.parseInt(separador1[0]) > Integer.parseInt(separador2[0])){
                        System.out.println(registro2);
                        registro2 = br2.readLine();
                    }else{
                        //Buscamos el movimiento más reciente del producto
                        producto = buscarEnMovimientos(Integer.parseInt(separador2[0]));
                        //Si el último movimiento no es una eliminación
                        if(producto != null){
                            System.out.println(producto);
                        }
                        registro1 = br1.readLine();
                        registro2 = br2.readLine();
                    }
                }
            }
            if(registro1 != null){
                while((registro1 = br1.readLine()) != null){
                    System.out.println(registro1);
                }
            }

            if(registro2 != null){
                while((registro2 = br2.readLine()) != null){
                    System.out.println(registro2);
                }
            }
        }catch (FileNotFoundException error1){
            error1.printStackTrace();
        }catch (IOException error2){
            error2.printStackTrace();
        }finally {
            try{
                br1.close();
                fr1.close();
                br2.close();
                fr2.close();
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
     * Permite mostrar todos los productos veganos del almacen
     * Postcondiciones: nada, solo se muestran todos los productos veganos del almacen.
     */
    public void mostrarProductosVeganos(){ //No funciona bien.
        ImplStockProducto producto = null;
        FileReader fr1 = null;
        BufferedReader br1 = null;
        FileReader fr2 = null;
        BufferedReader br2 = null;
        String registro1, registro2;
        String[] separador1 = null, separador2 = null;

        try{
            fr1 = new FileReader("src\\Ficheros\\AlmacenProductos.txt");
            br1 = new BufferedReader(fr1);
            fr2 = new FileReader("src\\Ficheros\\Movimientos.txt");
            br2 = new BufferedReader(fr2);

            registro1 = br1.readLine();
            registro2 = br2.readLine();
            while(registro1 != null && registro2 != null){//Mientras no haya ningún fin de fichero
                separador1 = registro1.split(",");
                separador2 = registro2.split(",");
                if(Integer.parseInt(separador1[0]) < Integer.parseInt(separador2[0]) && Boolean.parseBoolean(separador1[5]) == true){
                    System.out.println(registro1);
                    registro1 = br1.readLine();
                }else{
                    if(Integer.parseInt(separador1[0]) > Integer.parseInt(separador2[0]) && Boolean.parseBoolean(separador2[5]) == true){
                        System.out.println(registro2);
                        registro2 = br2.readLine();
                    }else{
                        //Buscamos el movimiento más reciente del producto
                        producto = buscarEnMovimientos(Integer.parseInt(separador2[0]));
                        //Si el último movimiento no es una eliminación
                        if(producto != null && Boolean.parseBoolean(separador2[5]) == true){
                            System.out.println(producto);
                        }
                        registro1 = br1.readLine();
                        registro2 = br2.readLine();
                    }
                }
            }
            if(registro1 != null){
                while((registro1 = br1.readLine()) != null && Boolean.parseBoolean(separador1[5]) == true){
                    System.out.println(registro1);
                }
            }

            if(registro2 != null){
                while((registro2 = br2.readLine()) != null && Boolean.parseBoolean(separador2[5]) == true){
                    System.out.println(registro2);
                }
            }
        }catch (FileNotFoundException error1){
            error1.printStackTrace();
        }catch (IOException error2){
            error2.printStackTrace();
        }finally {
            try{
                br1.close();
                fr1.close();
                br2.close();
                fr2.close();
            }catch (IOException error){
                error.printStackTrace();
            }
        }
    }

    /*
    * ProductoEliminado
    * Comentario: comprueba si un producto esta marcado como eliminado o no.
    * Entrada: entero ID.
    * Precondiciones: no hay.
    * Salida: boolean ret.
    * Postcondiciones: Asociado al nombre devuelve un boolean. True en caso que el ultimo registro con esa ID sea marcado
    * como eliminado. False en caso contrario.
    * Cabecera: public boolean productoEliminado(int ID)
    * */
    public boolean productoEliminado(int ID){
        boolean ret = false;

        //Recorremos el fichero de movimiento buscando si el ultimo registro con ese ID se encuentra en estado de borrado.
        FileReader fr1 = null;
        BufferedReader br1 = null;
        String registro = " ";
        String[] partesRegistro = null;

        try{
            fr1 = new FileReader("src\\Ficheros\\Movimientos.txt");
            br1 = new BufferedReader(fr1);

            //Recorremos el fichero de movimiento.
            while((registro = br1.readLine()) != null) {
                partesRegistro = registro.split(",");//Separamos el registro en campos
                if(partesRegistro[3].charAt(0) == '*' && Integer.parseInt(partesRegistro[0]) == ID){ //Comprueba que este marcado como eliminado ('*')
                    ret = true;
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
        return ret;
    }

    /*
    * Interfaz
    * Nombre: eliminarProducto (Actu) (Funciona)
    * Comentario: Esta función nos permite eliminar un producto del almacén.
    * Cabecera: public int eliminarProducto(int id)
    * Entrada:
    *   -entero id
    * Salida:
    *   -entero validez
    * Postcondiciones: La función devuelve un número entero asociado al nombre, 0 si se
    * ha conseguido eliminar el producto o -1 si no se encuentre el producto en el almacén.
    * */
    public int eliminarProducto(int id){
        int validez = -1;
        ImplStockProducto producto = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        //Si el producto existe
        if((producto = obtenerProductoAlmacen(id)) != null){
            validez = 0;
            producto.setProductoNombre("*"+producto.getProductoNombre());

            try{
                fw = new FileWriter("src\\Ficheros\\Movimientos.txt", true);
                bw = new BufferedWriter(fw);

                bw.write(producto.toString());
                bw.newLine();
                bw.flush();
            }catch (IOException error1){
                error1.printStackTrace();
            }finally {
                try{
                    bw.close();
                    fw.close();
                }catch (IOException error){
                    error.printStackTrace();
                }
            }
        }
        return validez;
    }
}