package Clases;

import Enums.EnumTipo;

import java.io.*;

public class FuncionesMenus {
    /*
     * Interfaz
     * Nombre: insertarMenu
     * Comentario: Esta función permite insertar un menú en la lista de menús.
     * Cabecera: public void insertarMenu(ImplMenu menu)
     * Entrada:
     *   -ImplMenu menu
     * Postcondiciones: La función inserta un tipo ImplMenu en el fichero
     * de la lista de menús.
     * */
    public void insertarMenu(ImplMenu menu){
        MyObjectOutputStream moos = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File fichero = new File("src\\Ficheros\\MovimientosMenu.dat");
        try{
            if(fichero.exists()) {
                fos = new FileOutputStream(fichero, true);
                moos = new MyObjectOutputStream(fos);
                moos.writeObject(menu);//Insertamos el nuevo producto en el almacén
                moos.close();
            }else {
                fos = new FileOutputStream(fichero);
                oos = new ObjectOutputStream(fos);
                oos.writeObject(menu);
                oos.close();
            }
        } catch(IOException error){
            error.printStackTrace();
        }finally {
            try {
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
    * Salida:
    *   -ImplMenu menu
    * Postcondiciones: La función devuelve un tipo ImplMenu asociado al nombre, que es
    * el menú con misma id en la lista o null si el menú con esa id no se encuentra en la lista.
    * */
    public ImplMenu obtenerMenu(int idMenu){
        ImplMenu menu = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        File fichero = new File("src\\Ficheros\\ListaMenus.dat");

        menu = buscarEnMovimientos(idMenu);//Buscamos en el fichero de movimientos
        //Si no se ha encontrado en el fichero de mov, no se ha marcado como eliminado y el fichero maestro existe.
        if(menu == null && !menuEliminado(idMenu) && fichero.exists()){
            menu = buscarEnListaMenus(idMenu);
        }

        return menu;
    }

    /*
     * Interfaz
     * Nombre: buscarEnListaMenus
     * Comentario: La función nos permite obtener un tipo ImplMenu del fichero
     * ListaMenus.txt.
     * Se pasará por parámetros un número de id.
     * Si no existe un menú con la misma id en el fichero la función devuelve null.
     * Cabecera: public ImplMenu buscarEnListaMenus(int id)
     * Entrada:
     *   -entero id
     * Salida:
     *   -ImplMenu menu
     * Postcondiciones: La función devuelve un tipo ImplMenu asociado al nombre, si se ha
     * encontrado un menú con la misma id en el fichero, en caso contrario la función
     * devuelve null.
     * */
    public ImplMenu buscarEnListaMenus(int id){
        ImplMenu menu = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        boolean encontrado = false;

        try{
            fis = new FileInputStream("src\\Ficheros\\ListaMenus.dat");
            ois = new ObjectInputStream(fis);
            //Repetir mientras no sea fin de fichero, no se haya encontrado el producto y sea posible encontrarlo aún.
            do{
                menu = (ImplMenu) ois.readObject();
                if(menu.getId() == id){
                    encontrado = true;
                }
            }while(!encontrado && menu.getId() <= id);
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
        if(menu.getId() != id){
            menu = null;
        }

        return menu;
    }

    /*
     * Interfaz
     * Nombre: buscarEnMovimientos
     * Comentario: La función nos permite obtener un tipo ImplMenu del fichero
     * MovimientosMenus.txt.
     * Se pasará por parámetros un número de id.
     * Si no existe un producto con la misma id en el fichero la función devuelve null.
     * Cabecera: public ImplMenu buscarEnMovimientos(int id)
     * Entrada:
     *   -entero id
     * Salida:
     *   -ImplMenu menu
     * Postcondiciones: La función devuelve un tipo ImplMenu asociado al nombre, si
     * se ha encontrado un menú con misma id en el fichero de movimientos, en caso
     * contrario la función devuelve null.
     * */
    public ImplMenu buscarEnMovimientos(int id){
        ImplMenu menu = null, registro = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        boolean encontrado = false;

        try{
            fis = new FileInputStream("src\\Ficheros\\MovimientosMenu.dat");
            ois = new ObjectInputStream(fis);
            //Mientras no sea fin de fichero y no se haya encontrado el producto.

            while (true) {
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
     * menuEliminado
     * Comentario: comprueba si un menú esta marcado como eliminado o no.
     * Entrada: entero ID.
     * Precondiciones: no hay.
     * Salida: boolean ret.
     * Postcondiciones: Asociado al nombre devuelve un boolean. True en caso que el ultimo registro con esa ID sea marcado
     * como eliminado. False en caso contrario.
     * Cabecera: public boolean menuEliminado(int id)
     * */
    public boolean menuEliminado(int id){
        boolean ret = false;
        ImplMenu menu = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try{
            fis = new FileInputStream("src\\Ficheros\\MovimientosMenu.dat");
            ois = new ObjectInputStream(fis);

            //Recorremos el fichero de movimiento.
            while(true) {
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
     * Nombre: eliminarMenu (Actu) (Funciona)
     * Comentario: Esta función nos permite eliminar un menú de la lista de menús.
     * Cabecera: public int eliminarMenu(int id)
     * Entrada:
     *   -entero id
     * Salida:
     *   -entero validez
     * Postcondiciones: La función devuelve un número entero asociado al nombre, 0 si se
     * ha conseguido eliminar el menú o -1 si no se encuentre el menú en la lista de menús.
     * */
    public int eliminarMenu(int id){
        int validez = -1;
        ImplMenu menu = null;
        FileOutputStream fos = null;
        MyObjectOutputStream oos = null;

        //Si el menú existe
        if((menu = obtenerMenu(id)) != null){
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
    * Nombre: sincronizarListaMenus (Mejora esta interfaz)
    * Comentario: Esta función permite sincronizar el fichero maestro(ListaMenus) y de movimientos
    * (MovimientosMenu) en un maestro actualizado, que será nombrado como el maestro.
    * Cabecera: public void sincronizarListaMenus()
    * Postcondiciones: La función sincroniza los ficheros de menús en uno solo.
    * */
    /*public void sincronizarListaMenus(){
        ImplMenu menu = null;
        FileInputStream fis1 = null, fis2 = null;
        ObjectInputStream ois1 = null, ois2 = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        int idActual = 0;
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
            ficheroMaestroActualizado.renameTo(aux = new File ("src\\Ficheros\\AlmacenProductos.txt"));
        }catch (FileNotFoundException error1){
            error1.printStackTrace();
        }catch (IOException error2){
            error2.printStackTrace();
        }
    }*/
}
