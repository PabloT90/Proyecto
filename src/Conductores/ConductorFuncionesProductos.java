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

        //insertarProducto (funciona)
        //funcion.insertarProducto(producto1);

        //buscarEnAlmacen (funciona)
        //System.out.println("buscarEnAlmacen:");
        //System.out.println(funcion.buscarEnAlmacen(3));
        //System.out.println(funcion.buscarEnAlmacen(12));
        //System.out.println(funcion.buscarEnAlmacen(29));
        //System.out.println("Fin buscar en almacen.");

        //buscarEnMovimientos (funciona)
        //System.out.println("buscarEnMovimientos:");
        //System.out.println(funcion.buscarEnMovimientos(3));
        //System.out.println(funcion.buscarEnMovimientos(4));
        //System.out.println(funcion.buscarEnMovimientos(27));
        //System.out.println("----Fin buscarEnMovimientos");

        //mostrarProductosAlmacen (funciona)
        //System.out.println("Mostrar todos los productos del almacen");
        funcion.mostrarProductosAlmacen();
        //System.out.println("---Fin Almacen-----");

        //mostrarProductosVeganos (funciona)
        //System.out.println("Mostrar los productos veganos.");
        //funcion.mostrarProductosVeganos();
        //System.out.println("----Fin veganos---");

        //eliminarProducto(funciona)
        //System.out.println(funcion.eliminarProducto(1));
        //System.out.println(funcion.eliminarProducto(2));
        //System.out.println(funcion.eliminarProducto(3));
        //System.out.println(funcion.eliminarProducto(4));
        //System.out.println(funcion.eliminarProducto(34));
        //System.out.println(funcion.eliminarProducto(6));

        //productoEliminado (funciona)
        //System.out.println(funcion.productoEliminado(1));
        //System.out.println(funcion.productoEliminado(2));

        //ObtenerProdcutoAlmacen (funciona)
        //System.out.println(funcion.obtenerProductoAlmacen(2));
        //System.out.println(funcion.obtenerProductoAlmacen(29));

        //sincronizarAlmacen
        //funcion.sincronizarAlmacen();

        //mostrarProductosPorTipo
        //funcion.mostrarProductosPorTipo(EnumTipo.BEBIDA);
        //funcion.mostrarProductosPorTipo(EnumTipo.COMPLEMENTO);
        //funcion.mostrarProductosPorTipo(EnumTipo.DESAYUNO);
        //funcion.mostrarProductosPorTipo(EnumTipo.POSTRE);

        //incrementarStock
        //System.out.println(funcion.incrementarStock(67, 3));
        //System.out.println(funcion.incrementarStock(222, 3));

        //decrementarStock
        //System.out.println(funcion.decrementarStock(145, 11));
        //System.out.println(funcion.decrementarStock(6, 9));
        //System.out.println(funcion.decrementarStock(23, 4));

        //existenProductos
        //System.out.println(funcion.existenProductos(EnumTipo.SANDWICH));
        //System.out.println(funcion.existenProductos(EnumTipo.BEBIDA));
        //System.out.println(funcion.existenProductos(EnumTipo.COMPLEMENTO));
        //System.out.println(funcion.existenProductos(EnumTipo.ENSALADA));
        //System.out.println(funcion.existenProductos(EnumTipo.POSTRE));
        //System.out.println(funcion.existenProductos(EnumTipo.DESAYUNO));

        //almacenVacio
        //System.out.println(funcion.almacenVacio());
    }
}
