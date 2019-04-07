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
        System.out.println(funcion.buscarEnAlmacen(3,"src\\Ficheros\\FicheroMovimientoNuevosProductos.txt"));
        System.out.println(funcion.buscarEnAlmacen(57,"src\\Ficheros\\FicheroMovimientoNuevosProductos.txt"));
        System.out.println(funcion.buscarEnAlmacen(56,"src\\Ficheros\\FicheroMovimientoNuevosProductos.txt"));

        //mostrarProductosAlmacen
        System.out.println("Mostrar todos los productos del almacen");
        funcion.mostrarProductosAlmacen();

        //mostrarProductosVeganos
        System.out.println("Mostrar los productos veganos.");
        funcion.mostrarProductosVeganos();

        //posicionProducto
        System.out.println(funcion.posicionProducto("src\\Ficheros\\FicheroMovimientoNuevosProductos.txt", 55));
    }
}
