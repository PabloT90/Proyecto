package Conductores;

import Clases.FuncionesProductos;
import Clases.ImplStockProducto;
import Enums.EnumTipo;

public class ConductorFuncionesProductos {
    public static void main (String[] args){
        FuncionesProductos funcion = new FuncionesProductos();
        ImplStockProducto producto1 = new ImplStockProducto(57, EnumTipo.BEBIDA, 1.5, "CocaCola", "Un poco cara.", true, 56);

        //insertarProducto
        //funcion.insertarProducto(producto1);

        //obtenerProductoAlmacen
        System.out.println(funcion.obtenerProductoAlmacen(3));
        System.out.println(funcion.obtenerProductoAlmacen(57));
        System.out.println(funcion.obtenerProductoAlmacen(56));

        //mostrarProductosAlmacen
        System.out.println("Mostrar todos los productos del almacen");
        funcion.mostrarProductosAlmacen();

        //mostrarAlmacenProductos
        System.out.println("Mostrar Almacen de productos");
        funcion.mostrarAlmacenProductos();

        //mostrarFicheroMov
        System.out.println("Mostrar Fichero de movimiento");
        funcion.mostrarFicheroMov();
    }
}
