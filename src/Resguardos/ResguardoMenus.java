package Resguardos;

import Clases.ImplMenu;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ResguardoMenus {
    /*
     * Interfaz
     * Nombre: insertarMenu
     * Comentario: Esta función permite insertar un menú en el archivo de movimiento de menús.
     * Cabecera: public void insertarMenu(ImplMenu menu)
     * Entrada:
     *   -ImplMenu menu
     * Postcondiciones: El menú es insertado en el fichero de movimiento de los menús.
     * Lanzará IOException en caso de ocurrir algun error durante la entrada de datos.
     * */
    /**
     * Inserta un menú en el archivo de movimiento de los menús.
     * @param menu Menú que queremos insertar.
     * @throws IOException Si ocurre algún error durante la entrada de datos.
     */
    public void insertarMenu(ImplMenu menu){
        System.out.println("En resguardo.");
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
        System.out.println("En resguardo.");
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
     * FileNotFoundException en caso de no encontrar un archivo.
     * EOFException al llegar al fin de fichero.
     * IOException al ocurrir un error durante la salida de datos.
     * ClassNotFoundException si no se encuentra la clase de un objeto serializado.
     * */
    /**
     * Obtiene un tipo ImplMenu del fichero ListaMenus.dat
     * @param id id del menú a buscar.
     * @return Devuelve un menú en caso de encontrar alguno que coincida con la id recibida. NULL en caso contrario.
     * @throws FileNotFoundException en caso de no encontrar un archivo.
     * @throws EOFException al llegar al fin de fichero.
     * @throws IOException al ocurrir un error durante la salida de datos.
     * @throws ClassNotFoundException si no se encuentra la clase de un objeto serializado.
     */
    public ImplMenu buscarEnListaMenus(int id){
        ImplMenu menu = null;
        System.out.println("En resguardo.");
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
     * FileNotFoundException en caso de no encontrar un archivo.
     * EOFException al llegar al fin de fichero.
     * IOException al ocurrir un error durante la salida de datos.
     * ClassNotFoundException si no se encuentra la clase de un objeto serializado.
     * */
    /**
     * Obtiene un tipo ImplMenu del fichero MovimientosMenus.dat.
     * @param id id del Menú a buscar.
     * @return Devuelve un menú en caso de coincidir con la id recibida. NULL en caso contrario.
     * @throws FileNotFoundException en caso de no encontrar un archivo.
     * @throws EOFException al llegar al fin de fichero.
     * @throws IOException al ocurrir un error durante la salida de datos.
     * @throws ClassNotFoundException si no se encuentra la clase de un objeto serializado.
     */
    public ImplMenu buscarEnMovimientos(int id){
        ImplMenu menu = null;
        System.out.println("En resguardo.");
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
     *  -id debe ser mayor que 0.
     *  -El fichero MovimientosMenu.dat debe tener una cabecera de la clase ObjectStream.
     * Postcondiciones: Asociado al nombre devuelve un boolean. True en caso de que el último
     * registro con esa id sea marcado como eliminado. False en caso contrario.
     * FileNotFoundException en caso de no encontrar un archivo.
     * EOFException al llegar al fin de fichero.
     * IOException al ocurrir un error durante la salida de datos.
     * ClassNotFoundException si no se encuentra la clase de un objeto serializado.
     * */
    /**
     * Comprueba si un menú está marcado como eliminado o no.
     * @param id id del menú a comprobar.
     * @return True en caso de estar marcado como eliminado. False en caso contrario.
     * @throws FileNotFoundException en caso de no encontrar un archivo.
     * @throws EOFException al llegar al fin de fichero.
     * @throws IOException al ocurrir un error durante la salida de datos.
     * @throws ClassNotFoundException si no se encuentra la clase de un objeto serializado.
     */
    public boolean menuEliminado(int id){
        System.out.println("En resguardo.");
        return true;
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
     * IOException al ocurrir un error durante la entrada de datos.
     * */
    /**
     * Elimina un menú de la lista de menús.
     * @param id id del menú a eliminar.
     * @return 0 si se ha conseguido eliminar. -1 si no se encuentra el menú en la lista de menús.
     * @throws IOException al ocurrir un error durante la entrada de datos.
     */
    public int eliminarMenu(int id){
        System.out.println("En resguardo.");
        return 0;
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
     * FileNotFoundException en caso de no encontrar un archivo.
     * EOFException al llegar al fin de fichero.
     * IOException al ocurrir un error durante la entrada o salida de datos.
     * ClassNotFoundException si no se encuentra la clase de un objeto serializado.
     * */
    /**
     * Sincroniza el fichero maestro y el de movimientos en un maestro actualizado. El maestro actualizado se renombra
     * a Maestro, se borra el maestro desactualizado y se vacía el fichero de movimientos.
     * @throws FileNotFoundException en caso de no encontrar un archivo.
     * @throws EOFException al llegar al fin de fichero.
     * @throws IOException al ocurrir un error durante la entrada o salida de datos.
     * @throws ClassNotFoundException si no se encuentra la clase de un objeto serializado.
     */
    public void sincronizarListaMenus() {
        System.out.println("En resguardo.");
    }

    /*
     * Interfaz
     * Nombre: limpiarFichero
     * Comentario: Esta función vacia los datos del fichero recibido como parametro.
     * Cabecera: public void limpiarFichero(String direccionFichero)
     * Entrada:
     *   -Cadena direccionFichero
     * Postcondiciones: los ficheros quedan vacios de los datos que contenia anteriormente.
     * FileNotFoundException en caso de no encontrar un archivo.
     * IOException al ocurrir un error durante la salida de datos.
     * */
    /**
     * Vacía los datos del fichero recibido como parametro.
     * @param direccionFichero Path del fichero.
     * @throws FileNotFoundException en caso de no encontrar un archivo.
     * @throws IOException al ocurrir un error durante la salida de datos.
     */
    public void limpiarFichero(String direccionFichero){
        System.out.println("En resguardo.");
    }

    /*
     * Interfaz
     * Nombre: ficheroVacio
     * Comentario: Permite verificar si un fichero está vacío o si tiene algún registro.
     * Cabecera: public int ficheroVacio(String direccion)
     * Entrada: String direccion.
     * Salida: entero ret.
     * Postcondiciones: Asociado al nombre devuelve 0 si está vacío, -1 si tiene algún registro.
     * FileNotFoundException en caso de no encontrar un archivo.
     * EOFException al llegar al fin de fichero.
     * IOException al ocurrir un error durante la salida de datos.
     * ClassNotFoundException si no se encuentra la clase de un objeto serializado.
     * */
    /**
     * Permite conocer si un fichero está vacío o si tiene algún registro.
     * @param direccion Path del fichero.
     * @return 0 si está vacio. -1 si tiene algún registro.
     * @throws FileNotFoundException en caso de no encontrar un archivo.
     * @throws EOFException al llegar al fin de fichero.
     * @throws IOException al ocurrir un error durante la salida de datos.
     * @throws ClassNotFoundException si no se encuentra la clase de un objeto serializado.
     */
    public int ficheroVacio(String direccion){
        System.out.println("En resguardo.");
        return 0;
    }

    /*
     * Interfaz
     * Nombre: mostrarListaMenus
     * Comentario: Esta función permite mostrar todo el almacén de menús.
     * Cabecera: public void mostrarListaMenus()
     * Precondiciones:
     *  -El fichero ListaMenus.dat debe tener una cabecera de la clase ObjectStream.
     *  -El fichero MovimientosMenu.dat debe tener una cabecera de la clase ObjectStream
     * Postcondiciones: El fichero de movimiento queda ordenado y muestra en pantalla todo el almacén.
     * FileNotFoundException en caso de no encontrar un archivo.
     * EOFException al llegar al fin de fichero.
     * IOException al ocurrir un error durante la salida de datos.
     * ClassNotFoundException si no se encuentra la clase de un objeto serializado.
     * */
    /**
     * Muestra todo el almacén de menús.
     * @throws FileNotFoundException en caso de no encontrar un archivo.
     * @throws EOFException al llegar al fin de fichero.
     * @throws IOException al ocurrir un error durante la salida de datos.
     * @throws ClassNotFoundException si no se encuentra la clase de un objeto serializado.
     */
    public void mostrarListaMenus() {
        System.out.println("En resguardo.");
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
     * Verifica si un menú contiene un determinado producto.
     * @param menu Menú que queremos ver.
     * @param id ID del producto.
     * @return True en caso de contener el producto. False en caso contrario.
     */
    public boolean menuContieneProducto(ImplMenu menu, int id){
        System.out.println("En resguardo.");
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
     * Precondiciones:
     *   - El idProducto debe ser mayor o igual a 0
     *   - El fichero ListaMenus.dat debe tener una cabecera de la clase ObjectStream.
     *   - El fichero MovimientosMneu.dat debe tener una cabecera de la clase ObjectStream.
     * Postcondiciones: La función elimina todos los menús de la lista que contengan
     * el mismo producto.
     * FileNotFoundException en caso de no encontrar un archivo.
     * EOFException al llegar al fin de fichero.
     * IOException al ocurrir un error durante la salida de datos.
     * ClassNotFoundException si no se encuentra la clase de un objeto serializado.
     * */
    /**
     * Elimina todos los menus que contengan un producto determinado.
     * @param idProducto ID del producto.
     * @throws FileNotFoundException en caso de no encontrar un archivo.
     * @throws EOFException al llegar al fin de fichero.
     * @throws IOException al ocurrir un error durante la salida de datos.
     * @throws ClassNotFoundException si no se encuentra la clase de un objeto serializado.
     */
    public void eliminarMenusPorProductoDeterminado(int idProducto){
        System.out.println("En resguardo.");
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
        System.out.println("En resguardo.");
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
     *   -El menú debe contener productos del almacén.
     * Postcondiciones: La función devuelve un número entero asociado al nombre, 0 si
     * se ha conseguido canjear el menú o -1 si el menú contiene algún producto sin stock.
     * */
    /**
     * Canjea los productos que forman el menú. Es decir, decrementa los productos del almacén que componen ese menú.
     * @param menu Menu que queremos canjear.
     * @return 0 si se ha canjeado. -1 si tiene algun producto sin stock.
     */
    public int canjeoMenu(ImplMenu menu){
        System.out.println("En resguardo.");
        return 0;
    }

    /*
     * Interfaz
     * Nombre: limpiarFichero
     * Comentario: Esta función vacía los datos de un fichero.
     * Cabecera: public void limpiarFichero(String direccionFichero)
     * Entrada:
     *   -Cadena direccionFichero
     * Postcondiciones: El fichero queda vacío de datos.
     * */
    /**
     * Vacía los datos del fichero recibido como parametro.
     * @param direccionFichero Path del fichero.
     */
    public void crearFichero(String direccionFichero) {
        System.out.println("En resguardo.");
    }
}
