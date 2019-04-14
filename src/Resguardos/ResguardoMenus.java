package Resguardos;

import Clases.ImplMenu;

public class ResguardoMenus {
    //Funciones de menus

    /*
     * Interfaz
     * Nombre: insertarMenu
     * Comentario: Esta función permite insertar un menú en el archivo de movimiento de los menús.
     * Cabecera: public void insertarMenu(ImplMenu menu)
     * Entrada:
     *   -ImplMenu menu
     * Postcondiciones: el menú es insertado en el fichero de movimiento de los menús.
     * */
    /**
     * Inserta un menú en el archivo de movimiento de los menús.
     * @param menu Menú que queremos insertar.
     */
    public void insertarMenu(ImplMenu menu){
        System.out.println("En resguardo");
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

    /**
     * Obtiene un menú de la lista de menús.
     * @param idMenu id del menú que queremos obtener.
     * @return Devuelve un menú en caso de encontrar alguno que concuerde con la id recibida. NULL en caso conttrario.
     */
    public ImplMenu obtenerMenu(int idMenu){
        ImplMenu menu = null;
        System.out.println("En resguardo");
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
        System.out.println("En resguardo");
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
        ImplMenu menu = null;
        System.out.println("En resguardo");
        return menu;
    }

    /*
     * menuEliminado
     * Comentario: comprueba si un menú está marcado como eliminado o no.
     * Entrada: entero ID.
     * Precondiciones: no hay.
     * Salida: boolean ret.
     * Postcondiciones: Asociado al nombre devuelve un boolean. True en caso que el ultimo registro con esa ID sea marcado
     * como eliminado. False en caso contrario.
     * Cabecera: public boolean menuEliminado(int id)
     * */
    /**
     * Comprueba si un menú está marcado como eliminado o no.
     * @param id id del menú a comprobar.
     * @return True en caso de estar marcado como eliminado. False en caso contrario.
     */
    public boolean menuEliminado(int id){
        System.out.println("En resguardo");
        return true;
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
    /**
     * Elimina un menú de la lista de menús.
     * @param id id del menú a eliminar.
     * @return 0 si se ha conseguido eliminar. -1 si no se encuentra el menú en la lista de menús.
     */
    public int eliminarMenu(int id){
        System.out.println("En resguardo");
        return 0;
    }

    /*
     * Interfaz
     * Nombre: sincronizarListaMenus (Mejora esta interfaz)
     * Comentario: Esta función permite sincronizar el fichero maestro(ListaMenus) y de movimientos
     * (MovimientosMenu) en un maestro actualizado, que será nombrado como el maestro.
     * Cabecera: public void sincronizarListaMenus()
     * Postcondiciones: Los ficheros quedan sincronizados en 1 solo. Se renombra a Maestro y se borran
     * el fichero de movimiento y el antiguo maestro.
     * */
    /**
     * Sincroniza el fichero maestro y el de movimientos en un maestro actualizado. Luego borra los 2 primeros
     * y renombra el último a Maestro.
     */
    public void sincronizarListaMenus() {
        System.out.println("En resguardo");
    }

    /*
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
    public int ficheroVacio(String direccion){
        System.out.println("En resguardo");
        return 0;
    }

    /*
     * Interfaz
     * Nombre: mostrarListaMenus
     * Comentario: Esta función permite mostrar todo el almacén de menús.
     * Cabecera: public void mostrarListaMenus()
     * Postcondiciones: el fichero de movimiento queda ordenado y muestra en pantalla todo el almacén.
     * */
    /**
     * Muestra todo el almacén de menús.
     */
    public void mostrarListaMenus() {
        System.out.println("En resguardo");
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
    public boolean menuContieneProducto(ImplMenu menu, int id){
        System.out.println("En resguardo");
        return true;
    }

    /*
     * Interfaz
     * Nombre: eliminarMenusPorProductoDeterminado
     * Comentario: Esta función nos permite eliminar todas los menús de la lista de
     * menús que contengan un producto determinado.
     * Cabecera: public void eliminarMenusPorProductoDeterminado(int idProducto)
     * Entrada:
     *   -entero idProducto
     * Postcondiciones: La función elimina todos los menús de la lista que contengan
     * el mismo producto.
     * */
    public void eliminarMenusPorProductoDeterminado(int idProducto){
        System.out.println("En resguardo");
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
     *   -el menú debe contener productos existentes en el almacén.
     * Postcondiciones: La función devuelve un valor booleano asociado al nombre, verdadero
     * si el menú contiene algún producto sin stock y falso en caso contrario.
     * */
    public boolean productoSinStock(int idMenu){
        System.out.println("En resguardo");
        return true;
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
     *   -el menú debe contener productos existentes en el almacén.
     * Postcondiciones: La función devuelve un número entero asociado al nombre, 0 si
     * se ha conseguido canjear el menú o -1 si el menú contiene algún producto sin stock.
     * */
    public int canjeoMenu(ImplMenu menu){
        System.out.println("En resguardo");
        return 1;
    }

}
