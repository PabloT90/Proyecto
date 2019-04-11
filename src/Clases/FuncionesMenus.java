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
    /*public ImplMenu obtenerMenu(int idMenu){
        ImplMenu menu = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        menu = buscarEnMovimientos(idMenu);//Buscamos en el fichero de movimientos
        //Si el producto no se encontraba en el fichero de movimientos se buscará en el almacén de productos.
        if(menu == null && !productoEliminado(idMenu)) //Si no se ha encontrado en el fichero de mov y no se ha marcado como eliminado.
            menu = buscarEnListaMenus(idMenu);
        return menu;
    }*/

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
            fis = new FileInputStream("src\\Ficheros\\ListaMenus.txt");
            ois = new ObjectInputStream(fis);
            //Mientras no sea fin de fichero, no se haya encontrado el producto y sea posible encontrarlo aún.
            while ((menu = (ImplMenu) ois.readObject()) != null && !encontrado && menu.getId() <= id) {
                if(menu.getId() == id){
                    encontrado = true;
                }
            }
        }catch(FileNotFoundException error1){
            error1.printStackTrace();
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
        ImplMenu menu = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        boolean encontrado = false;

        try{
            fis = new FileInputStream("src\\Ficheros\\MovimientosMenu.dat");
            ois = new ObjectInputStream(fis);
            //Mientras no sea fin de fichero y no se haya encontrado el producto.

            while ((menu = (ImplMenu) ois.readObject()) != null && !encontrado) {
                if(menu.getId() == id){
                    encontrado = true;
                }
            }
        }catch(FileNotFoundException error1) {
            error1.printStackTrace();
        }catch(EOFException error4) {
            System.out.println("Fin del fichero");
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
     * ProductoEliminado
     * Comentario: comprueba si un menú esta marcado como eliminado o no.
     * Entrada: entero ID.
     * Precondiciones: no hay.
     * Salida: boolean ret.
     * Postcondiciones: Asociado al nombre devuelve un boolean. True en caso que el ultimo registro con esa ID sea marcado
     * como eliminado. False en caso contrario.
     * Cabecera: public boolean menuEliminado(int ID)
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

}
