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
        if(producto == null)//Modificar
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
    public ImplStockProducto buscarEnMovimientos(int ID){
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

                if (Integer.parseInt(separador[0]) == ID) {//Si los id's coinciden
                    tipo = EnumTipo.valueOf(separador[1]);
                    precio = Double.parseDouble(separador[2]);
                    vegano = Boolean.parseBoolean(separador[5]);
                    stock = Integer.parseInt(separador[6]);
                    producto = new ImplStockProducto(ID, tipo, precio, separador[3], separador[4], vegano, stock);
                }
                    registro = br1.readLine();
            }

            if(producto != null && producto.getProductoNombre().charAt(0) == '*'){
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
     * Muestra por pantalla todos los productos veganos
     * Postcondiciones: nada, solo se muestra por pantalla los productos veganos del almacen.
     */
    public void mostrarProductosVeganos(){
        mostrarProductosVeganos("src\\Ficheros\\AlmacenProductos.txt");
        mostrarProductosVeganos("src\\Ficheros\\Movimientos.txt");
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

            //Recorremos el fichero
            while((registro = br1.readLine()) != null) {
                partesRegistro = registro.split(",");//Separamos el registro en campos
                if(partesRegistro[3].charAt(0) != '*' && Boolean.parseBoolean(partesRegistro[5]) == true){
                    System.out.println(registro);
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
    * Nombre: eliminarProducto
    * Comentario: Esta función permite eliminar un producto del almacén.
    * Cabecera: public int eliminarProducto(int id)
    * Entrada:
    *   -entero id
    * Salida:
    *   -entero validez
    * Postcondiciones: La función devuelve un número entero asociado al nombre, 0 si se
    * ha conseguido eliminar el producto o -1 si no se ha encontrado el producto en el
    * almacén.
    * */
    public int eliminarProducto(int id){
        int validez = 0, eliminacion = 0;
        //Si el producto no se encontraba en el fichero AlmacenProductos.txt
        if(eliminarProductoFichero("src\\Ficheros\\AlmacenProductos.txt", id) == -1){
            if(eliminarProductoFichero("src\\Ficheros\\Movimientos.txt", id) == -1){
                validez = -1;
            }
        }

        return validez;
    }

    /*
    * Interfaz
    * Nombre: eliminarProductoFichero
    * Comentario: Esta función permite eliminar un registro de producto de un fichero.
    * Cabecera: public int eliminarProductoFichero(String direccionArchivo, int id)
    * Entrada:
    *   -Cadena direccionArchivo
    *   -entero id
    * Salida:
    *   -entero validez
    * Precondiciones:
    *   -direccionArchivo debe apuntar a un fichero de texto existente.
    * Postcondiciones: La función devuelve un número entero asociado al nombre, 0 si se ha
    * conseguido eliminar el producto o -1 si no se ha encontrado el producto en el almacén.
    * */
    public int eliminarProductoFichero(String direccionArchivo, int id){
        int validez = -1, posicionRegistro = 0;
        RandomAccessFile raf = null;
        ImplStockProducto producto = null;

        posicionRegistro = posicionProducto(direccionArchivo, id);

        if(posicionRegistro != -1){//Si se encontró el producto
            validez = 0;
            producto = obtenerProductoAlmacen(id);
            try{
                raf = new RandomAccessFile(direccionArchivo, "rw");
                raf.skipBytes(posicionRegistro + 4 + (producto.getProductoTipo().toString().length()));
                raf.writeBytes("*");
            }catch (FileNotFoundException error1){
                error1.printStackTrace();
            }catch (IOException error2){
                error2.printStackTrace();
            }finally {
                try{
                    raf.close();
                }catch(IOException error){
                    error.printStackTrace();
                }
            }
        }

        return validez;
    }

    /*
    * Interfaz
    * Nombre: posicionProducto
    * Comentario: Esta función nos permite obtener la posición en bytes de un registro de producto en
    * un archivo.
    * Cabecera: public int posicionProducto(String direccionArchivo, int id)
    * Entrada:
    *   -Cadena direccionArchivo
    *   -entero id
    * Salida:
    *   -entero posicionBytes
    * Precondiciones:
    *   -direccionArchivo debe apuntar a un fichero de texto existente.
    * Postcondiciones: La función devuelve un número entero asociado al nombre, que es la posición
    * en bytes que ocupa el registro en el fichero o -1 si no se ha encontrado un registro que tenga
    * la misma id de producto.
    * */
    public int posicionProducto(String direccionArchivo, int id){
        int posicionBytes = -1, cantidadBytes = 0;
        FileReader fr = null;
        BufferedReader br = null;
        String registro = " ";
        String[] partesRegistro;

        try{
            fr = new FileReader(direccionArchivo);
            br = new BufferedReader(fr);
            //Mientras no sea fin de fichero y aún no se haya encontrado el producto
            while((registro = br.readLine()) != null && posicionBytes == -1){
                partesRegistro = registro.split(",");
                if(Integer.parseInt(partesRegistro[0]) == id && partesRegistro[3].charAt(0) != '*'){
                    posicionBytes = cantidadBytes;
                }else{
                    cantidadBytes += registro.length() + 2;
                }
            }
        }catch(FileNotFoundException error1){
            error1.printStackTrace();
        }catch(IOException error2){
            error2.printStackTrace();
        }finally {
            try{
                br.close();
                fr.close();
            }catch (IOException error){
                error.printStackTrace();
            }
        }

        return posicionBytes;
    }

    /*
    * Interfaz
    * Nombre: modificarProducto
    * Comentario: Esta función nos permite modificar un producto del almacén. En realidad la
    * función elimina un producto para después insertar otro actualizado.
    * Cabecera: public int modificarProducto(ImplStockProducto producto)
    * Entrada:
    *   -ImplStockProducto producto
    * Salida:
    *   -entero validez
    * Postcondiciones: La función devuelve un número entero asociado al nombre, 0 si no se
    * ha cometido errores, modificando el producto o -1 si no se ha encontrado el producto en el almecén.
    * */
    public int modificarProducto(ImplStockProducto producto){
        int validez = -1;

        if(obtenerProductoAlmacen(producto.getProductoId()) != null){//Si el producto existe en el almacén
            validez = 0;
            eliminarProducto(producto.getProductoId());//Eliminamos el producto
            insertarProducto(producto);//Insertamos el nuevo producto actualizado
        }

        return validez;
    }

    /*
    * Interfaz
    * Nombre: eliminarProducto (Actu)
    * Comentario: Esta función nos permite eliminar un producto del almacén.
    * Cabecera: public int eliminarProducto(int id)
    * Entrada:
    *   -entero id
    * Salida:
    *   -entero validez
    * Postcondiciones: La función devuelve un número entero asociado al nombre, 0 si se
    * ha conseguido eliminar el producto o -1 si no se encuentre el producto en el almacén.
    * */


}