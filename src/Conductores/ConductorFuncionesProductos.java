package Conductores;

import Clases.FuncionesProductos;
import Clases.ImplStockProducto;
import Enums.EnumTipo;

public class ConductorFuncionesProductos {
    public static void main (String[] args){
        FuncionesProductos funcion = new FuncionesProductos();
        ImplStockProducto producto1 = new ImplStockProducto(56, EnumTipo.BEBIDA, 1.5, "CocaCola", "Un poco cara.", true, 56);

        //insertarProducto
        //funcion.insertarProducto(producto1);

        //obtenerProductoAlmacen
        System.out.println(funcion.obtenerProductoAlmacen(3));
        System.out.println(funcion.obtenerProductoAlmacen(54));
        System.out.println(funcion.obtenerProductoAlmacen(56));
    }
}
