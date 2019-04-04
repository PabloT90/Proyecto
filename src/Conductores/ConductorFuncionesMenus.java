package Conductores;

import Clases.FuncionesMenus;
import Clases.ImplProducto;
import Enums.EnumTipo;

public class ConductorFuncionesMenus {
    public static void main (String[] args){
        FuncionesMenus funcion = new FuncionesMenus();
        ImplProducto producto1 = new ImplProducto(1, EnumTipo.BEBIDA, 1.50, "CocaCola","Bebida refrescante", true);
        ImplProducto producto2 = new ImplProducto(1, EnumTipo.BEBIDA, 1, "Pepsi","Bebida refrescante", true);
        ImplProducto[] productos = {producto1, producto2};

        //incrementarArrayProductos
        System.out.println("productos.length --> "+productos.length);
        funcion.incrementarArrayProductos(2, productos);
        System.out.println("productos.length --> "+productos.length);

    }
}
