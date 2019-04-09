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

        //buscarEnAlmacen (Funciona)
        System.out.println("buscarEnAlmacen:");
        System.out.println(funcion.buscarEnAlmacen(3));
        System.out.println(funcion.buscarEnAlmacen(12));
        System.out.println(funcion.buscarEnAlmacen(29));

        //buscarEnMovimientos (funciona)
        System.out.println("buscarEnMovimientos:");
        System.out.println(funcion.buscarEnMovimientos(3));
        System.out.println(funcion.buscarEnMovimientos(4));
        System.out.println(funcion.buscarEnMovimientos(7));
        System.out.println("--------");

        //mostrarProductosAlmacen (Funciona, aunque si hay ID en ambos archivos muestra el de Movimiento)
        System.out.println("Mostrar todos los productos del almacen");
        funcion.mostrarProductosAlmacen();
        System.out.println("---Fin Almacen-----");

        //mostrarProductosVeganos (No funciona del todo)
        System.out.println("Mostrar los productos veganos.");
        funcion.mostrarProductosVeganos();
        System.out.println("----Fin veganos---");

        //posicionProducto
        //System.out.println(funcion.posicionProducto("src\\Ficheros\\Movimientos.txt", 57));

        //eliminarProductoFichero
        //System.out.println(funcion.eliminarProductoFichero("src\\Ficheros\\Movimientos.txt", 56));
        //System.out.println(funcion.eliminarProductoFichero("src\\Ficheros\\Movimientos.txt", 55));

        //eliminarProducto
        //System.out.println(funcion.eliminarProducto(1));
        //System.out.println(funcion.eliminarProducto(2));
        //System.out.println(funcion.eliminarProducto(3));

        //System.out.println(funcion.eliminarProducto(4));
        //System.out.println(funcion.eliminarProducto(5));
        //System.out.println(funcion.eliminarProducto(6));

        //modificarProducto (Funciona)
        //System.out.println(funcion.modificarProducto(producto2));
        //System.out.println(funcion.modificarProducto(producto3));

        //productoEliminado(Funciona)
        System.out.println(funcion.productoEliminado(1)+ "Debe salir true");
        System.out.println(funcion.productoEliminado(2)+ "Debe salir false");

        //eliminarProducto
        System.out.println(funcion.eliminarProducto(3));
        System.out.println(funcion.eliminarProducto(27));
        System.out.println(funcion.eliminarProducto(11));
    }
}
