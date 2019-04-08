package Conductores;

import Clases.FuncionesProductos;
import Clases.ImplStockProducto;
import Enums.EnumTipo;

public class ConductorFuncionesProductos {
    public static void main (String[] args){
        FuncionesProductos funcion = new FuncionesProductos();
        ImplStockProducto producto1 = new ImplStockProducto(57, EnumTipo.BEBIDA, 1.5, "CocaCola", "Un poco cara.", true, 56);
        ImplStockProducto producto2 = new ImplStockProducto(54,EnumTipo.SANDWICH,7.8,"Modificacion","Esta es la prueba de una modificación.",false,90);
        ImplStockProducto producto3 = new ImplStockProducto(13,EnumTipo.COMPLEMENTO,45,"Pablo centrate","Un poquito.",false,22);

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
        System.out.println(funcion.posicionProducto("src\\Ficheros\\FicheroMovimientoNuevosProductos.txt", 57));

        //eliminarProductoFichero
        System.out.println(funcion.eliminarProductoFichero("src\\Ficheros\\FicheroMovimientoNuevosProductos.txt", 56));
        System.out.println(funcion.eliminarProductoFichero("src\\Ficheros\\FicheroMovimientoNuevosProductos.txt", 55));

        //eliminarProducto
        System.out.println(funcion.eliminarProducto(1));
        System.out.println(funcion.eliminarProducto(2));
        System.out.println(funcion.eliminarProducto(3));

        System.out.println(funcion.eliminarProducto(4));
        System.out.println(funcion.eliminarProducto(5));
        System.out.println(funcion.eliminarProducto(6));

        //modificarProducto
        //System.out.println(funcion.modificarProducto(producto2));
        //System.out.println(funcion.modificarProducto(producto3));

        //bytesCamposIntermedios
        System.out.println(funcion.bytesCamposIntermedios(producto1));
    }
}
