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
            while (registro != null && producto == null && rangoValido) {
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
    /**
     * Busca un producto en el archivo de movimientos que coincida con la ID recibida.
     * @param id ID que queremos buscar.
     * @return Null en caso de no encontrarlo. ImplProducto en caso contrario.
     */
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
        FuncionesOrdenacionFicheros ordenacion = new FuncionesOrdenacionFicheros();
        ordenacion.mezclaDirecta("src\\Ficheros\\Movimientos.txt");
        int idActual;

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
                        //Buscamos el movimiento más reciente del producto
                        producto = obtenerProductoAlmacen(Integer.parseInt(separador2[0]));
                        //Si el último movimiento no es una eliminación
                        if(producto != null){
                            System.out.println(producto);
                        }
                        idActual = Integer.parseInt(separador2[0]);
                        while(registro2 != null && Integer.parseInt(separador2[0]) == idActual) {
                            registro2 = br2.readLine();
                            if(registro2 != null) {
                                separador2 = registro2.split(",");
                            }
                        }
                    }else{
                        //Buscamos el movimiento más reciente del producto
                        producto = obtenerProductoAlmacen(Integer.parseInt(separador2[0]));
                        //Si el último movimiento no es una eliminación
                        if(producto != null){
                            System.out.println(producto);
                        }

                        while(registro2 != null && Integer.parseInt(separador2[0]) == Integer.parseInt(separador1[0])) {
                            registro2 = br2.readLine();
                            if(registro2 != null) {
                                separador2 = registro2.split(",");
                            }
                        }
                        registro1 = br1.readLine();
                    }
                }
            }

            while(registro1 != null){
                System.out.println(registro1);
                registro1 = br1.readLine();
            }

            while(registro2 != null){
                //Buscamos el movimiento más reciente del producto
                producto = obtenerProductoAlmacen(Integer.parseInt(separador2[0]));
                //Si el último movimiento no es una eliminación
                if(producto != null){
                    System.out.println(producto);
                }
                idActual = Integer.parseInt(separador2[0]); //Esto lo he añadido yo
                while(registro2 != null && Integer.parseInt(separador2[0]) == idActual) { //== idActual lo he añadido yo.
                    registro2 = br2.readLine();
                    if(registro2 != null) {
                        separador2 = registro2.split(",");
                    }
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
        FuncionesOrdenacionFicheros ordenacion = new FuncionesOrdenacionFicheros();
        ordenacion.mezclaDirecta("src\\Ficheros\\Movimientos.txt");
        int idActual;

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
                    if(Boolean.parseBoolean(separador1[5])) {
                        System.out.println(registro1);
                    }
                    registro1 = br1.readLine();

                }else{
                    if(Integer.parseInt(separador1[0]) > Integer.parseInt(separador2[0])){
                        //Buscamos el movimiento más reciente del producto
                        producto = obtenerProductoAlmacen(Integer.parseInt(separador2[0]));
                        //Si el último movimiento no es una eliminación y es vegano.
                        if(producto != null && Boolean.parseBoolean(separador2[5])){
                            System.out.println(producto);
                        }
                        idActual = Integer.parseInt(separador2[0]);
                        do{
                            registro2 = br2.readLine();
                            if(registro2 != null){
                                separador2 = registro2.split(",");
                            }
                        }while(registro2 != null && Integer.parseInt(separador2[0]) == idActual);
                    }else{
                        //Buscamos el movimiento más reciente del producto
                        producto = obtenerProductoAlmacen(Integer.parseInt(separador2[0]));
                        //Si el último movimiento no es una eliminación y es vegano.
                        if(producto != null && Boolean.parseBoolean(separador2[5])){
                            System.out.println(producto);
                        }

                        do{
                            registro2 = br2.readLine();
                            if(registro2 != null){
                                separador2 = registro2.split(",");
                            }
                        }while(registro2 != null && Integer.parseInt(separador2[0]) == Integer.parseInt(separador1[0]));
                        registro1 = br1.readLine();
                    }
                }
            }
            while(registro1 != null){
                separador1 = registro1.split(",");
                if(Boolean.parseBoolean(separador1[5] )) {
                    System.out.println(registro1);
                }
                registro1 = br1.readLine();
            }

            while(registro2 != null){
                separador2 = registro2.split(",");

                if(Boolean.parseBoolean(separador2[5]) && separador2[3].charAt(0) != '*'){
                    System.out.println(registro2);
                }
                registro2 = br2.readLine();
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
    /**
     * Comprueba si un producto está marcado como eliminado o no.
     * @param ID ID del producto a comprobar.
     * @return True en caso de estar eliminado. False en caso contrario.
     */
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
                if (Integer.parseInt(partesRegistro[0]) == ID) {//Comprueba que este marcado como eliminado ('*')
                    if (partesRegistro[3].charAt(0) == '*') {
                        ret = true;
                    } else {
                        ret = false;
                    }
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
    /**
     * Elimina un producto del almacén.
     * @param id ID del producto a eliminar.
     * @return 0 si se ha eliminado. -1 si no se ha podido eliminar.
     */
    public int eliminarProducto(int id){
        int validez = -1;
        ImplStockProducto producto;

        //Si el producto existe
        if((producto = obtenerProductoAlmacen(id)) != null){
            validez = 0;
            producto.setProductoNombre("*"+producto.getProductoNombre());

            //Insertamos el producto con la marca de eliminado
            insertarProducto(producto);
        }
        return validez;
    }

    /*
    * Interfaz
    * Nombre: sincronizarAlmacen
    * Comentario: Esta función permite sincronizar el fichero maestro AlmacenProductos.txt con
    * el fichero de movimientos Movimientos.txt. Esta función permite reorganizar el almacén
    * de productos.
    * Cabecera: public void sincronizarAlmacen()
    * Postcondiciones: La función sincroniza dos ficheros que almacenan productos, dejando al
    * maestro actualizado.
    * */
    public void sincronizarAlmacen(){
        ImplStockProducto producto = null;
        File ficheroMovimiento = new File("src\\Ficheros\\Movimientos.txt");
        File ficheroMaestro = new File("src\\Ficheros\\AlmacenProductos.txt");
        File ficheroMaestroActualizado = new File("src\\Ficheros\\MaestroActualizado.txt");
        FileReader fr1 = null, fr2 = null;
        BufferedReader br1 = null, br2 = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        int idActual = 0;
        String registro1, registro2;
        String[] separador1 = null, separador2 = null;
        FuncionesOrdenacionFicheros ordenacion = new FuncionesOrdenacionFicheros();
        ordenacion.mezclaDirecta("src\\Ficheros\\Movimientos.txt");

        try{
            fr1 = new FileReader(ficheroMaestro);
            br1 = new BufferedReader(fr1);
            fr2 = new FileReader(ficheroMovimiento);
            br2 = new BufferedReader(fr2);
            fw = new FileWriter(ficheroMaestroActualizado);
            bw = new BufferedWriter(fw);

            registro1 = br1.readLine();
            registro2 = br2.readLine();
            while(registro1 != null && registro2 != null){//Mientras no haya ningún fin de fichero
                separador1 = registro1.split(",");
                separador2 = registro2.split(",");
                if(Integer.parseInt(separador1[0]) < Integer.parseInt(separador2[0])){
                    bw.write(registro1);
                    bw.newLine();
                    bw.flush();
                    registro1 = br1.readLine();
                }else{
                    if(Integer.parseInt(separador1[0]) > Integer.parseInt(separador2[0])){
                        //Si el producto no sufre una posterior eliminación
                        if((producto = obtenerProductoAlmacen(Integer.parseInt(separador2[0]))) != null) {
                            bw.write(producto.toString());//Almacenamos el último movimiento del producto
                            bw.newLine();
                            bw.flush();
                        }
                        idActual =  Integer.parseInt(separador2[0]);//Almacemos la id del producto actual
                        do{
                            registro2 = br2.readLine();
                            if(registro2 != null){
                                separador2 = registro2.split(",");
                            }
                        }while(registro2 != null && Integer.parseInt(separador2[0]) == idActual);
                    }else{
                        //Buscamos el movimiento más reciente del producto
                        //Si el último movimiento no es una eliminación y es vegano.
                        if((producto = buscarEnMovimientos(Integer.parseInt(separador2[0]))) != null){
                            bw.write(producto.toString());
                            bw.newLine();
                            bw.flush();
                        }
                        idActual = Integer.parseInt(separador2[0]);//Almacemos la id del producto actual
                        do{
                            registro2 = br2.readLine();
                            if(registro2 != null){
                                separador2 = registro2.split(",");
                            }
                        }while(registro2 != null && Integer.parseInt(separador2[0]) == idActual);
                        registro1 = br1.readLine();
                    }
                }
            }

            while(registro1 != null){
                bw.write(registro1);
                bw.newLine();
                bw.flush();
                registro1 = br1.readLine();
            }

            while(registro2 != null){
                separador2 = registro2.split(",");
                if((producto = obtenerProductoAlmacen(Integer.parseInt(separador2[0]))) != null) {
                    bw.write(producto.toString());//Almacenamos el último movimiento del producto
                    bw.newLine();
                    bw.flush();
                }
                idActual =  Integer.parseInt(separador2[0]);//Almacemos la id del producto actual
                do{
                    registro2 = br2.readLine();
                    if(registro2 != null){
                        separador2 = registro2.split(",");
                    }
                }while(registro2 != null && Integer.parseInt(separador2[0]) == idActual);
            }
            br1.close();//Cerramos los streams
            fr1.close();
            br2.close();
            fr2.close();
            fw.close();
            bw.close();

            //Eliminamos los ficheros del maestro y el de movimientos
            ficheroMaestro.delete();
            ficheroMovimiento.delete();
            ficheroMaestroActualizado.renameTo(new File ("src\\Ficheros\\AlmacenProductos.txt"));
        }catch (FileNotFoundException error1){
            error1.printStackTrace();
        }catch (IOException error2){
            error2.printStackTrace();
        }
    }



    /*
     * Interfaz
     * Nombre: mostrarProductosPorTipo
     * Comentario: Esta función nos permite mostrar por pantalla los productos
     * de un tipo determinado.
     * Cabecera: public void mostrarProductosPorTipo(EnumTipo tipo)
     * Entrada:
     *   -EnumTipo tipo
     * Postcondiciones: Nada, solo se muestra por pantalla los productos de un tipo
     * determinado del almacén.
     * */
    /**
     * Muestra los productos de un tipo determinado.
     * @param tipo Tipo del que queremos hacer una busqueda.
     */
    public void mostrarProductosPorTipo(EnumTipo tipo){
        ImplStockProducto producto = null;
        FileReader fr1 = null;
        BufferedReader br1 = null;
        FileReader fr2 = null;
        BufferedReader br2 = null;
        String registro1, registro2;
        String[] separador1 = null, separador2 = null;
        FuncionesOrdenacionFicheros ordenacion = new FuncionesOrdenacionFicheros();
        ordenacion.mezclaDirecta("src\\Ficheros\\Movimientos.txt");
        int idActual = 0;

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
                    if(separador1[1].equals(tipo.toString())) {
                        System.out.println(registro1);
                    }
                    registro1 = br1.readLine();

                }else{
                    if(Integer.parseInt(separador1[0]) > Integer.parseInt(separador2[0])){
                        //Buscamos el movimiento más reciente del producto
                        producto = obtenerProductoAlmacen(Integer.parseInt(separador2[0]));
                        //Si el último movimiento no es una eliminación y es vegano.
                        if(producto != null && producto.getProductoTipo() == tipo){
                            System.out.println(producto);
                        }

                        while(registro2 != null && Integer.parseInt(separador2[0]) == Integer.parseInt(separador1[0])) {
                            registro2 = br2.readLine();
                            if(registro2 != null)
                                separador2 = registro2.split(",");
                        }
                    }else{
                        //Buscamos el movimiento más reciente del producto
                        producto = obtenerProductoAlmacen(Integer.parseInt(separador2[0]));
                        //Si el último movimiento no es una eliminación y es vegano.
                        if(producto != null && producto.getProductoTipo() == tipo){
                            System.out.println(producto);
                        }

                        while(registro2 != null && Integer.parseInt(separador2[0]) == Integer.parseInt(separador1[0])) {
                            registro2 = br2.readLine();
                            if(registro2 != null)
                                separador2 = registro2.split(",");
                        }
                        registro1 = br1.readLine();
                    }
                }
            }

            while(registro1 != null){
                separador1 = registro1.split(",");
                if(separador1[1].equals(tipo.toString())) {
                    System.out.println(registro1);
                }
                registro1 = br1.readLine();
            }

            while(registro2 != null){
                //Buscamos el movimiento más reciente del producto
                producto = obtenerProductoAlmacen(Integer.parseInt(separador2[0]));
                //Si el último movimiento no es una eliminación y es vegano.
                if(producto != null && producto.getProductoTipo() == tipo){
                    System.out.println(producto);
                }
                idActual = Integer.parseInt(separador2[0]);
                while(registro2 != null && Integer.parseInt(separador2[0]) == idActual) {
                    registro2 = br2.readLine();
                    if(registro2 != null)
                        separador2 = registro2.split(",");
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
     * Nombre: incrementarStock
     * Comentario: Esta función permite incrementar el stock de un producto.
     * Cabecera: public int incrementarStock(int idProducto, int incremento)
     * Entrada:
     *   -entero idProducto
     *   -entero incremento
     * Salida:
     *   -entero validez
     * Precondiciones:
     *   -incremento debe ser mayor que 0.
     * Postcondiciones: La función devuelve un número entero asociado al nombre, 0 si se
     * ha conseguido incrementar el stock del producto o -1 si no se ha encontrado el
     * producto en el almacén.
     * */
    /**
     * Incrementa el stock de un producto.
     * @param idProducto ID del producto a incrementar.
     * @param incremento Unidades a sumar.
     * @return 0 si se ha conseguido incrementar. -1 en caso contrario.
     */
    public int incrementarStock(int idProducto, int incremento){
        int validez = -1;
        ImplStockProducto producto = null;

        if((producto = obtenerProductoAlmacen(idProducto)) != null){
            validez = 0;
            producto.setStock(producto.getStock() + incremento);
            insertarProducto(producto);
        }
        return validez;
    }

    /*
     * Interfaz
     * Nombre: decrementarStock
     * Comentario: Esta función permite decrementar el stock de un producto.
     * Cabecera: public int decrementarStock(int idProducto, int decremento)
     * Entrada:
     *   -entero idProducto
     *   -entero decremento
     * Salida:
     *   -entero validez
     * Precondiciones:
     *   -incremento debe ser mayor que 0.
     * Postcondiciones: La función devuelve un número entero asociado al nombre, 0 si se
     * ha conseguido decrementar el stock del producto, -1 si no se ha encontrado el
     * producto en el almacén o -2 si decremento es mayor que el stock actual del producto.
     * */
    /**
     * Decrementa el stock de un producto.
     * @param idProducto ID del producto a decrementar.
     * @param decremento Numero de unidades a restar.
     * @return 0 si se ha conseguido decrementar.
     *        -1 si no se ha encontrado el producto.
     *        -2 si el decremento en mayor que el stock actual del producto.
     */
    public int decrementarStock(int idProducto, int decremento){
        int validez = -1;
        ImplStockProducto producto = null;

        if((producto = obtenerProductoAlmacen(idProducto)) != null){
            if(producto.getStock() >= decremento){
                validez = 0;
                producto.setStock(producto.getStock() - decremento);
                insertarProducto(producto);
            }else{
                validez = -2;
            }
        }
        return validez;
    }

    /*
    * Interfaz
    * Nombre: existenProductos
    * Comentario: Esta función nos permite saber si en el almacén existen productos
    * de un tipo determinado.
    * Cabecera: public boolean existenProductos(EnumTipo tipo)
    * Entrada:
    *   -EnumTipo tipo
    * Salida:
    *   -booleano resultado
    * Postcondiciones: La función devuelve un valor booleano asociado al nombre, verdadero
    * si en el almacén existen productos de ese tipo determinado o -1 en caso contrario.
    * */
    /**
     * Permite conocer ei en el almacén existen productos de un tipo determinado.
     * @param tipo Tipo del que queremos saber si existen productos.
     * @return True en caso de que existan. False en caso contrario.
     */
    public boolean existenProductos(EnumTipo tipo){
        boolean resultado = false;
        ImplStockProducto producto = null;
        FileReader fr1 = null;
        BufferedReader br1 = null;
        FileReader fr2 = null;
        BufferedReader br2 = null;
        String registro1, registro2;
        String[] separador1 = null, separador2 = null;
        FuncionesOrdenacionFicheros ordenacion = new FuncionesOrdenacionFicheros();
        ordenacion.mezclaDirecta("src\\Ficheros\\Movimientos.txt");
        int idActual = 0;

        try{
            fr1 = new FileReader("src\\Ficheros\\AlmacenProductos.txt");
            br1 = new BufferedReader(fr1);
            fr2 = new FileReader("src\\Ficheros\\Movimientos.txt");
            br2 = new BufferedReader(fr2);

            registro1 = br1.readLine();
            registro2 = br2.readLine();
            //Mientras no haya ningún fin de fichero y no se haya encontrado un producto del tipo especificado
            while(registro1 != null && registro2 != null && !resultado){
                separador1 = registro1.split(",");
                separador2 = registro2.split(",");
                if(Integer.parseInt(separador1[0]) < Integer.parseInt(separador2[0])){
                    if(separador1[1].equals(tipo.toString())) {
                        resultado = true;
                    }else{
                        registro1 = br1.readLine();
                    }
                }else{
                    if(Integer.parseInt(separador1[0]) > Integer.parseInt(separador2[0])){
                        if(separador2[1].equals(tipo.toString()) && separador2[3].charAt(0) != '*') {
                            resultado = true;
                        }else{
                            registro2 = br2.readLine();
                        }
                    }else{
                        //Buscamos el movimiento más reciente del producto
                        producto = buscarEnMovimientos(Integer.parseInt(separador2[0]));
                        //Si el último movimiento no es una eliminación y es del mismo tipo.
                        if(producto != null && producto.getProductoTipo() == tipo){
                            resultado = true;
                        }else{
                            while(registro2 != null && Integer.parseInt(separador2[0]) == Integer.parseInt(separador1[0])) {
                                registro2 = br2.readLine();
                                if(registro2 != null)
                                    separador2 = registro2.split(",");
                            }
                            registro1 = br1.readLine();
                        }
                    }
                }
            }
            if(!resultado) {//Si aún no se ha encontrado un producto del tipo especificado
                while (registro1 != null && !resultado) {
                    separador1 = registro1.split(",");
                    if (separador1[1].equals(tipo.toString())) {
                        resultado = true;
                    }else{
                        registro1 = br1.readLine();
                    }
                }

                while (registro2 != null && !resultado) {
                    //Buscamos el movimiento más reciente del producto
                    producto = buscarEnMovimientos(Integer.parseInt(separador2[0]));
                    //Si el último movimiento no es una eliminación y es vegano.
                    if (producto != null && producto.getProductoTipo() == tipo) {
                        resultado = true;
                    }else{
                        idActual = Integer.parseInt(separador2[0]);
                        while (registro2 != null && Integer.parseInt(separador2[0]) == idActual) {
                            registro2 = br2.readLine();
                            if (registro2 != null)
                                separador2 = registro2.split(",");
                        }
                    }
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
        return resultado;
    }

    /*
    * Interfaz
    * Nombre: almacenVacio
    * Comentario: Esta función nos permite verificar si el almacén no contiene
    * ningún producto.
    * Cabecera: public boolean almacenVacio()
    * Salida:
    *   -booleano vacio
    * Postcondiciones: La función devuelve un valor booleano asociado al nombre, verdadero
    * si el almacén se encuentra vacío o falso en caso contrario.
    * */
    /**
     * Permite saber si el almacén está vacío o no.
     * @return True en caso de estar vacio. False en caso contrario.
     */
    public boolean almacenVacio(){
        boolean vacio = true;
        ImplStockProducto producto = null;
        FileReader fr1 = null, fr2 = null;
        BufferedReader br1 = null, br2 = null;
        String registro = " ";
        String[] separador = null;
        int idActual = 0;

        try{
            fr1 = new FileReader("src\\Ficheros\\AlmacenProductos.txt");
            br1 = new BufferedReader(fr1);
            fr2 = new FileReader("src\\Ficheros\\Movimientos.txt");
            br2 = new BufferedReader(fr2);
            //Si el fichero maestro no se encuentra vacío
            if(br1.readLine() != null){
                vacio = false;
            }else{
                if((registro = br2.readLine()) != null){//Si el fichero de movimientos no se encuentra vacío
                    while(registro != null && vacio){
                        separador = registro.split(",");
                        //Buscamos el movimiento más reciente del producto
                        producto = buscarEnMovimientos(Integer.parseInt(separador[0]));
                        //Si el último movimiento no es una eliminación.
                        if(producto != null){
                            vacio = false;
                        }else{
                            idActual = Integer.parseInt(separador[0]);
                            while(registro != null && Integer.parseInt(separador[0]) == idActual) {
                                registro = br2.readLine();
                                if(registro != null)
                                    separador = registro.split(",");
                            }
                        }
                    }
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
        return vacio;
    }
}