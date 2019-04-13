package Resguardos;

import Clases.FuncionesOrdenacionFicheros;
import Clases.ImplMenu;
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
     * */
    /**
     * Inserta un producto en el almacen.
     * @param producto Producto que se quiere insertar.
     * Postcondiciones: La función inserta un tipo ImplStockProducto en el fichero del almacen.
     * Cabecera: public void insertarProducto(ImplStockProducto producto)
     */
    public void insertarProducto(ImplStockProducto producto){
        System.out.println("En resguardo");
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
     * */
    /**
     * Obtiene un tipo ImplStockProducto de un directorio.
     * @param ID ID del producto.
     * @return Asociado al nombre devuelve un tipo ImplStockProducto si se ha encontrado un producto con el mismo ID
     * en el almacén y null en caso contrario.
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
     * */
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
     * */

    /**
     * Permite mostrar todos los productos del almacen.
     * Postcondiciones: nada, solo se muestran todos los productos del almacen.
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
     * */
    /**
     * Permite mostrar todos los productos veganos del almacen
     * Postcondiciones: nada, solo se muestran todos los productos veganos del almacen.
     */
    public void mostrarProductosVeganos(){ //No funciona bien.
        System.out.println("En resguardo.");
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
        System.out.println("En resguardo.");
        return true;
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
     * */
    public void sincronizarAlmacen() {
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
     * */
    public void mostrarProductosPorTipo(EnumTipo tipo){
          System.out.println("En resguardo.");
    }
}