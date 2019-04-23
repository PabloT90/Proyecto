package Resguardos;

import Clases.ImplStockProducto;
import Enums.EnumTipo;

import java.io.*;

public class Resguardo {
    /*
     * Interfaz
     * Nombre: insertarProducto (Funciona)
     * Comentario: Esta función permite insertar un producto en el almacen.
     * Cabecera: public void insertarProducto(ImplStockProducto producto)
     * Entrada:
     *   -ImplStockProducto producto
     * Postcondiciones: La función inserta un tipo ImplStockProducto en el fichero
     * del almacén.
     * Si hay algún error durante la entrada de datos se lanzará IOException.
     * */
    /**
     * Inserta un producto en el almacen.
     * @param producto Producto que se quiere insertar.
     * @throws IOException al ocurrir un error durante la salida de datos.
     */
    public void insertarProducto(ImplStockProducto producto){
        System.out.println("En resguardo.");
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
        System.out.println("En resguardo.");
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
     * Si hay algún error durante la salida de datos se lanzará IOException.
     * Si alguna dirección de fichero es erronea o no existe, se lanzará la excepción FileNotFoundException.
     * */
    /**
     * Obtiene un tipo ImplStockProducto de un directorio.
     * @param ID ID del producto.
     * @return Asociado al nombre devuelve un tipo ImplStockProducto si se ha encontrado un producto con el mismo ID
     * en el almacén y null en caso contrario.
     * @throws FileNotFoundException en caso de no encontrar un archivo.
     * @throws IOException al ocurrir un error durante la salida de datos.
     */
    public ImplStockProducto buscarEnAlmacen(int ID){
        ImplStockProducto producto = null;
        System.out.println("En resguardo.");
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
     * Si hay algún error durante la salida de datos se lanzará IOException.
     * Si alguna dirección de fichero es erronea o no existe, se lanzará la excepción FileNotFoundException.
     * */
    /**
     * Busca un producto en el archivo de movimientos que coincida con la ID recibida.
     * @param id ID que queremos buscar.
     * @return Null en caso de no encontrarlo. ImplProducto en caso contrario.
     * @throws FileNotFoundException en caso de no encontrar un archivo.
     * @throws IOException al ocurrir un error durante la salida de datos.
     */
    public ImplStockProducto buscarEnMovimientos(int id){
        ImplStockProducto producto = null;
        System.out.println("En resguardo.");
        return producto;
    }

    /*
     * Interfaz
     * Nombre: mostrarProductosAlmacen
     * Comentario: Esta función nos permite mostrar por pantalla todos los productos del
     * almacén. Tanto de fichero de movimiento como de almacen.
     * Cabecera: public void mostrarProductosAlmacen()
     * Postcondiciones: Nada, solo se muestra por pantalla los productos del almacén.
     * Si hay algún error durante la salida de datos se lanzará IOException.
     * Si alguna dirección de fichero es erronea o no existe, se lanzará la excepción FileNotFoundException.
     * */
    /**
     * Permite mostrar todos los productos del almacen.
     * Postcondiciones: nada, solo se muestran todos los productos del almacen.
     * @throws FileNotFoundException en caso de no encontrar un archivo.
     * @throws IOException al ocurrir un error durante la salida de datos.
     */
    public void mostrarProductosAlmacen(){
        System.out.println("En resguardo.");
    }
    /*
     * Interfaz
     * Nombre: mostrarProductosVeganos
     * Comentario: Esta función nos permite mostrar por pantalla los productos veganos del
     * almacén.
     * Cabecera: public void mostrarProductosVeganos()
     * Postcondiciones: Nada, solo se muestra por pantalla los productos veganos del almacén.
     * Si hay algún error durante la salida de datos se lanzará IOException.
     * Si alguna dirección de fichero es erronea o no existe, se lanzará la excepción FileNotFoundException.
     * */
    /**
     * Permite mostrar todos los productos veganos del almacen
     * Postcondiciones: nada, solo se muestran todos los productos veganos del almacen.
     * @throws FileNotFoundException en caso de no encontrar un archivo.
     * @throws IOException al ocurrir un error durante la salida de datos.
     */
    public void mostrarProductosVeganos(){ //No funciona bien.
        System.out.println("En resguardo.");
    }

    /*
     * ProductoEliminado
     * Comentario: comprueba si un producto esta marcado como eliminado o no.
     * Entrada: entero ID.
     * Salida: boolean ret.
     * Postcondiciones: Asociado al nombre devuelve un boolean. True en caso que el ultimo registro con esa ID sea marcado
     * como eliminado. False en caso contrario.
     * Si hay algún error durante la salida de datos se lanzará IOException.
     * Si alguna dirección de fichero es erronea o no existe, se lanzará la excepción FileNotFoundException.
     * Cabecera: public boolean productoEliminado(int ID)
     * */
    /**
     * Comprueba si un producto está marcado como eliminado o no.
     * @param ID ID del producto a comprobar.
     * @return True en caso de estar eliminado. False en caso contrario.
     * @throws FileNotFoundException en caso de no encontrar un archivo.
     * @throws IOException al ocurrir un error durante la salida de datos.
     */
    public boolean productoEliminado(int ID){
        System.out.println("En resguardo.");
        return true;
    }

    /*
     * Interfaz
     * Nombre: eliminarProducto
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
        System.out.println("En resguardo.");
        return 0;
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
     * Si hay algún error durante la salida o entrada de datos se lanzará IOException.
     * Si alguna dirección de fichero es erronea o no existe, se lanzará la excepción FileNotFoundException.
     * */
    /**
     * Sincroniza el fichero maestro AlmacenProductos.txt con el fichero de movimientos Movimientos.txt. Reorganiza el almacén de productos.
     * @throws FileNotFoundException en caso de no encontrar un archivo.
     * @throws IOException al ocurrir un error durante la entrada o salida de datos.
     */
    public void sincronizarAlmacen(){
        System.out.println("En resguardo.");
    }

    /*
     * Interfaz
     * Nombre: limpiarFichero
     * Comentario: Esta función nos permite vaciar los datos de un fichero recibido como parametro.
     * Cabecera: public void limpiarFichero(String direccion)
     * Entrada:
     *   -Cadena direccion
     * Postcondiciones: El fichero queda limpio de datos.
     * Si hay algún error durante la entrada de datos se lanzará IOException.
     * Si alguna dirección de fichero es erronea o no existe, se lanzará la excepción FileNotFoundException.
     * */
    /**
     * Permite vaciar los datos de un fichero recibido como parametro.
     * @param direccion Path del fichero.
     * @throws FileNotFoundException en caso de no encontrar un archivo.
     * @throws IOException al ocurrir un error durante la entrada de datos.
     */
    public void limpiarFichero(String direccion){
        System.out.println("En resguardo.");
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
     * Si hay algún error durante la salida de datos se lanzará IOException.
     * Si alguna dirección de fichero es erronea o no existe, se lanzará la excepción FileNotFoundException.
     * */
    /**
     * Muestra los productos de un tipo determinado.
     * @param tipo Tipo del que queremos hacer una busqueda.
     * @throws FileNotFoundException en caso de no encontrar un archivo.
     * @throws IOException al ocurrir un error durante la salida de datos.
     */
    public void mostrarProductosPorTipo(EnumTipo tipo){
        System.out.println("En resguardo.");
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
        System.out.println("En resguardo.");
        return 0;
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
     *   -decremento debe ser mayor que 0.
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
        System.out.println("En resguardo.");
        return 0;
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
     * Si hay algún error durante la salida de datos se lanzará IOException.
     * Si alguna dirección de fichero es erronea o no existe, se lanzará la excepción FileNotFoundException.
     * */
    /**
     * Permite conocer si en el almacén existen productos de un tipo determinado.
     * @param tipo Tipo del que queremos saber si existen productos.
     * @return True en caso de que existan. False en caso contrario.
     * @throws FileNotFoundException en caso de no encontrar un archivo.
     * @throws IOException al ocurrir un error durante la salida de datos.
     */
    public boolean existenProductos(EnumTipo tipo){
        System.out.println("En resguardo.");
        return true;
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
     * Si hay algún error durante la salida de datos se lanzará IOException.
     * Si alguna dirección de fichero es erronea o no existe, se lanzará la excepción FileNotFoundException.
     * */
    /**
     * Permite saber si el almacén está vacío o no.
     * @return True en caso de estar vacio. False en caso contrario.
     * @throws FileNotFoundException en caso de no encontrar un archivo.
     * @throws IOException al ocurrir un error durante la salida de datos.
     */
    public boolean almacenVacio(){
        System.out.println("En resguardo.");
        return true;
    }
}