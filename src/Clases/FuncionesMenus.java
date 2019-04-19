package Clases;

import java.io.*;
import java.util.ArrayList;

public class FuncionesMenus {
    /*
     * Interfaz
     * Nombre: insertarMenu
     * Comentario: Esta función permite insertar un menú en el archivo de movimiento de menús.
     * Cabecera: public void insertarMenu(ImplMenu menu)
     * Entrada:
     *   -ImplMenu menu
     * Postcondiciones: El menú es insertado en el fichero de movimiento de los menús.
     * */
    /**
     * Inserta un menú en el archivo de movimiento de los menús.
     * @param menu Menú que queremos insertar.
     */
    public void insertarMenu(ImplMenu menu){
        MyObjectOutputStream moos = null;
        FileOutputStream fos = null;
        File fichero = new File("src\\Ficheros\\MovimientosMenu.dat");
        try{
            fos = new FileOutputStream(fichero, true);
            moos = new MyObjectOutputStream(fos);
            moos.writeObject(menu);//Insertamos el nuevo producto en el almacén
        } catch(IOException error){
            error.printStackTrace();
        }finally {
            try {
                moos.close();
                fos.close();
            }catch (IOException error){
                error.printStackTrace();
            }
        }
    }

    /*
    * Interfaz
    * Nombre: obtenerMenu
    * Comentario: Esta función nos permite obtener un menú de la lista de menús.
    * Cabecera: public ImplMenu obtenerMenu(int idMenu)
    * Entrada:
    *   -entero idMenu
    * Precondiciones:
    *   - Debe existir el fichero maestro y de movimientos de menús.
    *   - El fichero ListaMenus.dat debe tener una cabecera valida.
    *   - El fichero MovimientosMenu.dat debe tener una cabecera valida.
    * Salida:
    *   -ImplMenu menu
    * Postcondiciones: La función devuelve un tipo ImplMenu asociado al nombre, que es
    * el menú con misma id en la lista o null si el menú con esa id no se encuentra en la lista.
    * */
    /**
     * Obtiene un menú de la lista de menús.
     * @param idMenu id del menú que queremos obtener.
     * @return Devuelve un menú en caso de encontrar alguno que concuerde con la id recibida. NULL en caso conttrario.
     */
    public ImplMenu obtenerMenu(int idMenu){
        ImplMenu menu = null;

        menu = buscarEnMovimientos(idMenu);//Buscamos en el fichero de movimientos
        //Si no se ha encontrado en el fichero de movimientos y no se ha marcado como eliminado
        if(menu == null && !menuEliminado(idMenu)){
            menu = buscarEnListaMenus(idMenu);
        }
        return menu;
    }

    /*
     * Interfaz
     * Nombre: buscarEnListaMenus
     * Comentario: La función nos permite obtener un tipo ImplMenu del fichero
     * ListaMenus.dat.
     * Cabecera: public ImplMenu buscarEnListaMenus(int id)
     * Entrada:
     *   -entero id
     * Salida:
     *   -ImplMenu menu
     * Precondiciones:
     *   -El fichero ListaMenus.dat debe tener una cabecera de la clase ObjectStream.
     * Postcondiciones: La función devuelve un tipo ImplMenu asociado al nombre, si se ha
     * encontrado un menú con la misma id en el fichero, en caso contrario la función
     * devuelve null.
     * */
    /**
     * Obtiene un tipo ImplMenu del fichero ListaMenus.dat
     * @param id id del menú a buscar.
     * @return Devuelve un menú en caso de encontrar alguno que coincida con la id recibida. NULL en caso contrario.
     */
    public ImplMenu buscarEnListaMenus(int id){
        ImplMenu menu = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try{
            fis = new FileInputStream("src\\Ficheros\\ListaMenus.dat");
            ois = new ObjectInputStream(fis);
            do{ //Repetir mientras no sea fin de fichero y sea posible encontrarlo
                menu = (ImplMenu) ois.readObject();
            }while(menu.getId() <= id);
        }catch(FileNotFoundException error1){
            error1.printStackTrace();
        }catch (EOFException error){
        }catch (IOException error2){
            error2.printStackTrace();
        }catch(ClassNotFoundException error3){
            error3.printStackTrace();
        }finally{
            try{
                ois.close();
                fis.close();
            }catch (IOException error){
                error.printStackTrace();
            }
        }
        if(menu != null && menu.getId() != id){
            menu = null;
        }

        return menu;
    }

    /*
     * Interfaz
     * Nombre: buscarEnMovimientos
     * Comentario: La función nos permite obtener un tipo ImplMenu del fichero
     * MovimientosMenus.dat.
     * Cabecera: public ImplMenu buscarEnMovimientos(int id)
     * Entrada:
     *   -entero id
     * Salida:
     *   -ImplMenu menu
     * Precondiciones:
     *   -El fichero movimientoMenu.dat debe tener una cabecera de la clase ObjectStream.
     * Postcondiciones: La función devuelve un tipo ImplMenu asociado al nombre, si
     * se ha encontrado un menú con misma id en el fichero de movimientos, en caso
     * contrario la función devuelve null.
     * */
    /**
     * Obtiene un tipo ImplMenu del fichero MovimientosMenus.dat.
     * @param id id del Menú a buscar.
     * @return Devuelve un menú en caso de coincidir con la id recibida. NULL en caso contrario.
     */
    public ImplMenu buscarEnMovimientos(int id){
        ImplMenu menu = null, registro = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try{
            fis = new FileInputStream("src\\Ficheros\\MovimientosMenu.dat");
            ois = new ObjectInputStream(fis);

            while (true) {//Mientras no sea fin de fichero
                registro = (ImplMenu) ois.readObject();
                if(registro.getId() == id){
                    if(registro.getNombre().charAt(0) != '*'){//Si el movimiento no es de eliminación
                        menu = registro;
                    }else{
                        menu = null;
                    }
                }
            }
        }catch(FileNotFoundException error1) {
            error1.printStackTrace();
        }catch(EOFException error4) {
        }catch(IOException error2){
            error2.printStackTrace();
        }catch(ClassNotFoundException error3){
            error3.printStackTrace();
        }finally{
            try{
                ois.close();
                fis.close();
            }catch (IOException error){
                error.printStackTrace();
            }
        }
        return menu;
    }

    /*
     * Interfaz
     * Nombre: menuEliminado
     * Comentario: Comprueba si un menú está marcado como eliminado o no.
     * Cabecera: public boolean menuEliminado(int id)
     * Entrada:
     *  -entero id
     * Salida:
     *  -booleano ret
     * Precondiciones:
     *  -El fichero MovimientosMenu.dat debe tener una cabecera de la clase ObjectStream.
     * Postcondiciones: Asociado al nombre devuelve un boolean. True en caso de que el último
     * registro con esa id sea marcado como eliminado. False en caso contrario.
     * */
    /**
     * Comprueba si un menú está marcado como eliminado o no.
     * @param id id del menú a comprobar.
     * @return True en caso de estar marcado como eliminado. False en caso contrario.
     */
    public boolean menuEliminado(int id){
        boolean ret = false;
        ImplMenu menu = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try{
            fis = new FileInputStream("src\\Ficheros\\MovimientosMenu.dat");
            ois = new ObjectInputStream(fis);

            while(true) {//Recorremos el fichero de movimientos
                menu = (ImplMenu)ois.readObject();
                if(menu.getId() == id){
                   if(menu.getNombre().charAt(0) == '*'){
                       ret = true;
                   }else{
                       ret = false;
                   }
                }
            }
        }catch (ClassNotFoundException error1) {
            error1.printStackTrace();
        }catch(EOFException error){
        }catch (IOException error2){
            error2.printStackTrace();
        }finally{
            try{ //Cerramos los streams
                ois.close();
                fis.close();
            }catch (IOException error){
                error.printStackTrace();
            }
        }
        return ret;
    }

    /*
     * Interfaz
     * Nombre: eliminarMenu
     * Comentario: Esta función nos permite eliminar un menú de la lista de menús.
     * Cabecera: public int eliminarMenu(int id)
     * Entrada:
     *   -entero id
     * Salida:
     *   -entero validez
     * Postcondiciones: La función devuelve un número entero asociado al nombre, 0 si se
     * ha conseguido eliminar el menú o -1 si no se encuentra el menú en la lista de menús.
     * */
    /**
     * Elimina un menú de la lista de menús.
     * @param id id del menú a eliminar.
     * @return 0 si se ha conseguido eliminar. -1 si no se encuentra el menú en la lista de menús.
     */
    public int eliminarMenu(int id){
        int validez = -1;
        ImplMenu menu = null;
        FileOutputStream fos = null;
        MyObjectOutputStream oos = null;

        if((menu = obtenerMenu(id)) != null){ //Si el menú existe.
            validez = 0;
            menu.setNombre("*"+menu.getNombre());
            try{
                fos = new FileOutputStream("src\\Ficheros\\MovimientosMenu.dat", true);
                oos = new MyObjectOutputStream(fos);
                oos.writeObject(menu);
            }catch (IOException error1){
                error1.printStackTrace();
            }finally {
                try{
                    oos.close();
                    fos.close();
                }catch (IOException error){
                    error.printStackTrace();
                }
            }
        }
        return validez;
    }

    /*
    * Interfaz
    * Nombre: sincronizarListaMenus
    * Comentario: Esta función permite sincronizar el fichero maestro(ListaMenus) y de movimientos
    * (MovimientosMenu) en un maestro actualizado, que será nombrado como el maestro.
    * Cabecera: public void sincronizarListaMenus()
    * Precondiciones:
    *   - El fichero ListaMenus.dat debe tener una cabecera de la clase ObjectStream.
    *   - El fichero MovimientosMenu.dat debe tener una cabecera de la clase ObjectStream.
    * Postcondiciones: Los ficheros quedan sincronizados en uno solo. El maestro actualizado se renombra
    * a Maestro, se borra el maestro desactualizado y se vacía el fichero de movimientos.
    * */
    /**
     * Sincroniza el fichero maestro y el de movimientos en un maestro actualizado. El maestro actualizado se renombra
     * a Maestro, se borra el maestro desactualizado y se vacía el fichero de movimientos.
     */
    public void sincronizarListaMenus() {
        ImplMenu menu1 = null, menu2 = null;
        FileInputStream fis1 = null, fis2 = null;
        ObjectInputStream ois1 = null, ois2 = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File maestroActualizado = new File("src\\Ficheros\\MaestroActualizado.dat");
        File maestro = new File("src\\Ficheros\\ListaMenus.dat");
        int idActual = 0, saltoExcepcion = 1;
        FuncionesOrdenacionFicheros ordenacion = new FuncionesOrdenacionFicheros();
        ordenacion.mezclaDirecta2("src\\Ficheros\\MovimientosMenu.dat");

        try {
            fos = new FileOutputStream(maestroActualizado);
            oos = new ObjectOutputStream(fos);
            fis2 = new FileInputStream("src\\Ficheros\\MovimientosMenu.dat");
            ois2 = new ObjectInputStream(fis2);
            fis1 = new FileInputStream(maestro);
            ois1 = new ObjectInputStream(fis1);

            menu1 = (ImplMenu) ois1.readObject();
            saltoExcepcion = 2;
            menu2 = (ImplMenu) ois2.readObject();
            while (true) {//Mientras no haya ningún fin de fichero
                if (menu1.getId() < menu2.getId()) {
                    oos.writeObject(menu1);
                    saltoExcepcion = 1;
                    menu1 = (ImplMenu) ois1.readObject();
                }else{
                    if (menu1.getId() > menu2.getId()) {
                        //Si el producto no sufre una posterior eliminación
                        idActual = menu2.getId();//Almacemos la id del producto actual
                        if ((menu2 = obtenerMenu(menu2.getId())) != null) {
                            oos.writeObject(menu2);
                        }
                        saltoExcepcion = 2;
                        do {
                            menu2 = (ImplMenu) ois2.readObject();
                        } while (menu2.getId() == idActual);//Mientras sea un registro con el mismo id
                    }else {
                        //Buscamos el movimiento más reciente del producto
                        //Si el último movimiento no es una eliminación.
                        idActual = menu2.getId();//Almacemos la id del producto actual
                        if ((menu2 = buscarEnMovimientos(menu2.getId())) != null) {
                            oos.writeObject(menu2);
                        }
                        saltoExcepcion = 2;
                        do {
                            menu2 = (ImplMenu) ois2.readObject();
                        } while (menu2.getId() == idActual);//Mientras sea un registro con el mismo id
                        saltoExcepcion = 1;
                        menu1 = (ImplMenu) ois1.readObject();
                    }
                }
            }
        } catch (FileNotFoundException error1) {
            error1.printStackTrace();
        }catch (EOFException error){
            try{
                if(saltoExcepcion == 1){//Si la excepcion saltó en el fichero maestro.
                    if(menu2 == null){
                        menu2 = (ImplMenu)ois2.readObject();
                    }
                    while (true) {
                        idActual = menu2.getId();//Almacemos la id del producto actual
                        if ((menu2 = buscarEnMovimientos(menu2.getId())) != null) {
                            oos.writeObject(menu2);
                        }
                        do {
                            menu2 = (ImplMenu) ois2.readObject();
                        } while (menu2.getId() == idActual);//Mientras sea un registro con el mismo id
                    }
                }else{
                    while(true){
                        oos.writeObject(menu1);
                        menu1 = (ImplMenu)ois1.readObject();
                    }
                }
            }catch (FileNotFoundException error1) {
                error1.printStackTrace();
            }catch (EOFException error4){
            }catch (IOException error2){
                error2.printStackTrace();
            }catch (ClassNotFoundException error3){
                error3.printStackTrace();
            }
        }catch (IOException error2){
            error2.printStackTrace();
        }catch (ClassNotFoundException error3){
            error3.printStackTrace();
        }finally {
            try{
                ois1.close();
                fis1.close();
                ois2.close();
                fis2.close();
                oos.close();
                fos.close();

                limpiarFichero("src\\Ficheros\\MovimientosMenu.dat");//Vaciamos el fichero de movimientos
                maestro.delete();//Eliminamos el fichero maestro
                maestroActualizado.renameTo(new File ("src\\Ficheros\\ListaMenus.dat"));//Renombramos el maestro actualizado
            }catch (IOException error){
                error.printStackTrace();
            }
        }
    }

    /*
    * Interfaz
    * Nombre: limpiarFichero
    * Comentario: Esta función vacia los datos del fichero recibido como parametro.
    * Cabecera: public void limpiarFichero(String direccionFichero)
    * Entrada:
    *   -Cadena direccionFichero
    * Precondiciones:
    *   -direccionFichero debe apuntar a un fichero existente.
    * Postcondiciones: los ficheros quedan vacios de los datos que contenia anteriormente.
    * */
    /**
     * Vacía los datos del fichero recibido como parametro.
     * @param direccionFichero Path del fichero.
     */
    public void limpiarFichero(String direccionFichero){
        File fichero = new File(direccionFichero);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        fichero.delete();//Borramos el fichero
        try{//Creamos el fichero.
            fos = new FileOutputStream(fichero);
            oos = new ObjectOutputStream(fos);
        }catch(FileNotFoundException error){
            error.printStackTrace();
        }catch(IOException error2){
            error2.printStackTrace();
        }
    }

    /*
     * Interfaz
     * Permite conocer si un fichero está vacío, no existe o si tiene algún registro.
     * Cabecera: public int ficheroMovimientoVacio(String direccion)
     * Entrada: String direccion.
     * Salida: entero ret.
     * Postcondiciones: Asociado al nombre devuelve 0 si está vacío, -1 si tiene algún registro o -2 si no existe.
     * */
    /**
     * Permite conocer si un fichero está vacío, no existe o si tiene algún registro.
     * @param direccion Path del fichero.
     * @return 0 si está vacio. -1 si tiene algún registro. - 2 si no existe.
     */
    /*public int ficheroVacio(String direccion){
        int ret = -1;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        File fichero = new File(direccion);

        if(!fichero.exists()){
            ret = -2;
        }else{
            try {
                fis = new FileInputStream(fichero);
                ois = new ObjectInputStream(fis);
            }catch(FileNotFoundException error1) {
                error1.printStackTrace();
            }catch(EOFException error2){
                ret = 0;
            }catch(IOException error){
                error.printStackTrace();
            }finally{
                try {
                    if(ret != 0) {
                        ois.close();
                    }
                    fis.close();
                }catch(IOException error4){
                    error4.printStackTrace();
                }
            }
        }
        return ret;
    }*/

    /*
     * Interfaz
     * Nombre: mostrarListaMenus
     * Comentario: Esta función permite mostrar todo el almacén de menús.
     * Cabecera: public void mostrarListaMenus()
     * Precondiciones:
     *  -El fichero ListaMenus.dat debe tener una cabecera de la clase ObjectStream.
     *  -El fichero MovimientosMenu.dat debe tener una cabecera de la clase ObjectStream
     * Postcondiciones: El fichero de movimiento queda ordenado y muestra en pantalla todo el almacén.
     * */
    /**
     * Muestra todo el almacén de menús.
     */
    public void mostrarListaMenus() {
        ImplMenu menu1 = null, menu2 = null;
        FileInputStream fis1 = null, fis2 = null;
        ObjectInputStream ois1 = null, ois2 = null;
        int idActual = 0, saltoExcepcion = 1;
        FuncionesOrdenacionFicheros ordenacion = new FuncionesOrdenacionFicheros();
        ordenacion.mezclaDirecta2("src\\Ficheros\\MovimientosMenu.dat");

        try {
            fis2 = new FileInputStream("src\\Ficheros\\MovimientosMenu.dat");
            ois2 = new ObjectInputStream(fis2);
            fis1 = new FileInputStream("src\\Ficheros\\ListaMenus.dat");
            ois1 = new ObjectInputStream(fis1);

            menu1 = (ImplMenu) ois1.readObject();
            saltoExcepcion = 2;
            menu2 = (ImplMenu) ois2.readObject();
            while (true) {//Mientras no haya ningún fin de fichero
                if (menu1.getId() < menu2.getId()) {
                    System.out.println(menu1);
                    saltoExcepcion = 1;
                    menu1 = (ImplMenu) ois1.readObject();
                } else {
                    if (menu1.getId() > menu2.getId()) {
                        //Si el producto no sufre una posterior eliminación
                        idActual = menu2.getId();//Almacemos la id del producto actual
                        if ((menu2 = obtenerMenu(menu2.getId())) != null) {
                            System.out.println(menu2);
                        }
                        saltoExcepcion = 2;
                        do {
                            menu2 = (ImplMenu) ois2.readObject();
                        } while (menu2.getId() == idActual);//Mientras sea un registro con el mismo id
                    } else {
                        //Buscamos el movimiento más reciente del producto
                        //Si el último movimiento no es una eliminación.
                        idActual = menu2.getId();//Almacemos la id del producto actual
                        if ((menu2 = buscarEnMovimientos(menu2.getId())) != null) {
                            System.out.println(menu2);
                        }
                        saltoExcepcion = 2;
                        do {
                            menu2 = (ImplMenu) ois2.readObject();
                        } while (menu2.getId() == idActual);//Mientras sea un registro con el mismo id
                        saltoExcepcion = 1;
                        menu1 = (ImplMenu) ois1.readObject();
                    }
                }
            }
        } catch (FileNotFoundException error1) {
            error1.printStackTrace();
        }catch (EOFException error){
            try{
                if(saltoExcepcion == 1){//Si la excepcion saltó en el fichero maestro
                    if(menu2 == null){
                        menu2 = (ImplMenu)ois2.readObject();
                    }
                    while (true) {
                        idActual = menu2.getId();//Almacemos la id del producto actual
                        if ((menu2 = buscarEnMovimientos(menu2.getId())) != null) {
                            System.out.println(menu2);
                        }
                        do {
                            menu2 = (ImplMenu) ois2.readObject();
                        } while (menu2.getId() == idActual);//Mientras sea un registro con el mismo id
                    }
                }else{
                    while(true){
                        System.out.println(menu1);
                        menu1 = (ImplMenu)ois1.readObject();
                    }
                }
            }catch (FileNotFoundException error1) {
                error1.printStackTrace();
            }catch (EOFException error4){
            }catch (IOException error2){
                error2.printStackTrace();
            }catch (ClassNotFoundException error3){
                error3.printStackTrace();
            }
        }catch (IOException error2){
            error2.printStackTrace();
        }catch (ClassNotFoundException error3){
            error3.printStackTrace();
        }finally {
            try{
                ois1.close();
                fis1.close();
                ois2.close();
                fis2.close();
            }catch (IOException error){
                error.printStackTrace();
            }
        }
    }

    /*
    * Interfaz
    * Nombre: menuContieneProducto
    * Comentario: Esta función nos permite verificar si un menú contiene un determinado
    * producto.
    * Cabecera: public boolean menuContieneProducto(ImplMenu menu, int id)
    * Entrada:
    *   -ImplMenu menu
    *   -entero id
    * Salida:
    *   -booleano resultado
    * Postcondiciones: La función devuelve un valor booleano asociado al nombre, verdadero
    * si el menú contiene el producto y falso en caso contrario.
    * */
    /**
     * Verifica si un menu contiene un determinado producto.
     * @param menu Menú que queremos ver.
     * @param id ID del producto.
     * @return True en caso de contener el producto. False en caso contrario.
     */
    public boolean menuContieneProducto(ImplMenu menu, int id){
        boolean resultado = false;
        int[] ids = menu.getProductos();

        for(int i = 0; i < ids.length && !resultado; i++){
            if(ids[i] == id){
                resultado = true;
            }
        }
        return resultado;
    }

    /*
    * Interfaz
    * Nombre: eliminarMenusPorProductoDeterminado
    * Comentario: Esta función nos permite eliminar todas los menús de la lista de
    * menús que contengan un producto determinado.
    * Cabecera: public void eliminarMenusPorProductoDeterminado(int idProducto)
    * Entrada:
    *   -entero idProducto
    * Precondiciones:
    *   - El idProducto debe ser mayor o igual a 0
    *   - El fichero ListaMenus.dat debe tener una cabecera de la clase ObjectStream.
    *   - El fichero MovimientosMneu.dat debe tener una cabecera de la clase ObjectStream.
    * Postcondiciones: La función elimina todos los menús de la lista que contengan
    * el mismo producto.
    * */
    /**
     * Elimina todos los menus que contengan un producto determinado.
     * @param idProducto ID del producto.
     */
    public void eliminarMenusPorProductoDeterminado(int idProducto){
        ImplMenu menu1 = null, menu2 = null;
        FileInputStream fis1 = null, fis2 = null;
        ObjectInputStream ois1 = null, ois2 = null;
        int idActual = 0, saltoExcepcion = 1;
        ArrayList<Integer> menusAEliminar = new ArrayList<Integer>();
        FuncionesOrdenacionFicheros ordenacion = new FuncionesOrdenacionFicheros();
        ordenacion.mezclaDirecta2("src\\Ficheros\\MovimientosMenu.dat");

        try {
            fis2 = new FileInputStream("src\\Ficheros\\MovimientosMenu.dat");
            ois2 = new ObjectInputStream(fis2);
            fis1 = new FileInputStream("src\\Ficheros\\ListaMenus.dat");
            ois1 = new ObjectInputStream(fis1);//Si el fichero se encuentra vacío directamente nos salta la excepción

            menu1 = (ImplMenu) ois1.readObject();
            saltoExcepcion = 2;
            menu2 = (ImplMenu) ois2.readObject();
            while (true) {//Mientras no haya ningún fin de fichero
                if (menu1.getId() < menu2.getId()) {
                    if (menuContieneProducto(menu1, idProducto)){
                        menusAEliminar.add(menu1.getId());
                    }
                    saltoExcepcion = 1;
                    menu1 = (ImplMenu) ois1.readObject();
                } else {
                    if (menu1.getId() > menu2.getId()) {
                        //Si el producto no sufre una posterior eliminación
                        idActual = menu2.getId();//Almacemos la id del producto actual
                        if ((menu2 = obtenerMenu(menu2.getId())) != null && menuContieneProducto(menu2, idProducto)) {
                            menusAEliminar.add(menu2.getId());
                        }
                        saltoExcepcion = 2;
                        do {
                            menu2 = (ImplMenu) ois2.readObject();
                        } while (menu2.getId() == idActual);//Mientras sea un registro con el mismo id
                    } else {
                        //Buscamos el movimiento más reciente del producto
                        //Si el último movimiento no es una eliminación.
                        idActual = menu2.getId();//Almacemos la id del producto actual
                        if ((menu2 = buscarEnMovimientos(menu2.getId())) != null && menuContieneProducto(menu2, idProducto)) {
                            menusAEliminar.add(menu2.getId());
                        }
                        saltoExcepcion = 2;
                        do {
                            menu2 = (ImplMenu) ois2.readObject();
                        } while (menu2.getId() == idActual);//Mientras sea un registro con el mismo id
                        saltoExcepcion = 1;
                        menu1 = (ImplMenu) ois1.readObject();
                    }
                }
            }
        } catch (FileNotFoundException error1) {
            error1.printStackTrace();
        }catch (EOFException error){
            try{
                if(saltoExcepcion == 1){//Si la excepcion ha saltado en el fichero maestro
                    if(menu2 == null){
                        menu2 = (ImplMenu)ois2.readObject();
                    }
                    while (true) {
                        idActual = menu2.getId();//Almacemos la id del producto actual
                        if ((menu2 = buscarEnMovimientos(menu2.getId())) != null && menuContieneProducto(menu2, idProducto)) {
                            menusAEliminar.add(menu2.getId());
                        }
                        do {
                            menu2 = (ImplMenu) ois2.readObject();
                        } while (menu2.getId() == idActual);//Mientras sea un registro con el mismo id
                    }
                }else{
                    while(true){
                        menusAEliminar.add(menu1.getId());
                        menu1 = (ImplMenu)ois1.readObject();
                    }
                }
            }catch (FileNotFoundException error1) {
                error1.printStackTrace();
            }catch (EOFException error4){
            }catch (IOException error2){
                error2.printStackTrace();
            }catch (ClassNotFoundException error3){
                error3.printStackTrace();
            }
        }catch (IOException error2){
            error2.printStackTrace();
        }catch (ClassNotFoundException error3){
            error3.printStackTrace();
        }finally {
            try{
                ois1.close();
                fis1.close();
                ois2.close();
                fis2.close();

                for(int i = 0;  i < menusAEliminar.size(); i++){
                    eliminarMenu(menusAEliminar.get(i));
                }
            }catch (IOException error){
                error.printStackTrace();
            }
        }
    }

    /*
    * Interfaz
    * Nombre: productoSinStock
    * Comentario: Esta función nos permite verificar si un menú contiene algún
    * producto sin stock.
    * Cabecera: public boolean productoSinStock(int idMenu)
    * Entrada:
    *   -entero idMenu
    * Salida:
    *   -booleano resultado
    * Precondiciones:
    *   -idMenu debe coincidir con algún id de la lista de menús.
    *   -El menú debe contener productos existentes en el almacén.
    * Postcondiciones: La función devuelve un valor booleano asociado al nombre, verdadero
    * si el menú contiene algún producto sin stock y falso en caso contrario.
    * */
    /**
     * Verifica si un menú contiene algun producto sin stock.
     * @param idMenu ID del menú que queremos ver.
     * @return True si contiene algun producto sin stock. False en caso contrario.
     */
    public boolean productoSinStock(int idMenu){
        boolean resultado = false;
        ImplMenu menu = obtenerMenu(idMenu);
        ImplStockProducto producto = null;
        FuncionesProductos funcion = new FuncionesProductos();

        for(int i = 0; i < menu.getProductos().length && !resultado; i++){
            producto = funcion.obtenerProductoAlmacen(menu.getProductos()[i]);
            if(producto.getStock() == 0){
                resultado = true;
            }
        }
        return resultado;
    }

    /*
    * Interfaz
    * Nombre: canjeoMenu
    * Comentario: Esta función nos permite canjear los productos que contiene
    * un menú, es decir, nos permite decrementar el stock de los productos del
    * menú que se encuentran en el almacén.
    * Cabecera: public int canjeoMenu(ImplMenu menu)
    * Entrada:
    *   -ImplMenu menu
    * Salida:
    *   -entero validez
    * Precondiciones:
    *   -idMenu debe coincidir con algún id de la lista de menús.
    *   -El menú debe contener productos existentes en el almacén.
    * Postcondiciones: La función devuelve un número entero asociado al nombre, 0 si
    * se ha conseguido canjear el menú o -1 si el menú contiene algún producto sin stock.
    * */
    /**
     * Canjea los productos que forman el menú. Es decir, decrementa los productos del almacén que componen ese menú.
     * @param menu Menu que queremos canjear.
     * @return 0 si se ha canjeado. -1 si tiene algun producto sin stock.
     */
    public int canjeoMenu(ImplMenu menu){
        int validez = -1;
        ImplStockProducto producto = null;
        FuncionesProductos funcion = new FuncionesProductos();

        if(!productoSinStock(menu.getId())){
            for(int i = 0; i < menu.getProductos().length; i++){
                producto = funcion.obtenerProductoAlmacen(menu.getProductos()[i]);
                funcion.decrementarStock(producto.getProductoId(), 1);
            }
            validez = 0;
        }
        return validez;
    }

    /*
    * Interfaz
    * Nombre: encabezarFichero()
    * Comentario: Nos permite crear una cabecera en un fichero para evitar errores de lectura
    * por la clase ObjectInputStream.
    * Cabecera: public void encabezarFichero(String direccion)
    * Entrada:
    *   -Cadena direccion.
    * Precondiciones:
    *   -direccion debe apuntar a un fichero existente.
    * Postcondiciones: La función inserta una nueva cabecera en un fichero.
    * */
    /**
     * Crea una cabecera en un fichero para evitar errores de lectura por la clase ObjectInputStream.
     * @param direccion Path del fichero.
     */
    public void encabezarFichero(String direccion){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try{
            fos = new FileOutputStream(direccion);
            oos = new ObjectOutputStream(fos);
        }catch(FileNotFoundException error){
            error.printStackTrace();
        }catch(IOException error2){
            error2.printStackTrace();
        }finally{
            try {
                fos.close();
                oos.close();
            }catch(IOException error3){
               error3.printStackTrace();
            }
        }
    }

}
