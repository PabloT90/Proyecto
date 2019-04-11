package Conductores;

import Clases.FuncionesMenus;
import Clases.ImplMenu;
import Clases.ImplProducto;
import Enums.EnumTipo;

public class ConductorFuncionesMenus {
    public static void main (String[] args){
        FuncionesMenus funcion = new FuncionesMenus();
        ImplProducto producto1 = new ImplProducto(1, EnumTipo.BEBIDA, 1.50, "CocaCola","Bebida refrescante", true);
        ImplProducto producto2 = new ImplProducto(1, EnumTipo.BEBIDA, 1, "Pepsi","Bebida refrescante", true);
        int[] productos = {66, 69};
        ImplMenu menu1 = new ImplMenu(1, "ParaPa", "Esto es una descripcion.", productos, 3.5);
        ImplMenu menu2 = new ImplMenu(3, "Nononono", "Esto es un nuevo menú.", productos, 9.5);

        //insertarMenu
        funcion.insertarMenu(menu1);
        //funcion.insertarMenu(menu2);

        //menuEliminado
        //System.out.println(funcion.menuEliminado(1));

        //eliminarMenu
        System.out.println(funcion.eliminarMenu(3));

        //buscarEnListaMenus No funciona del todo
        //System.out.println(funcion.buscarEnListaMenus(3));

        //buscarMovimientosMenu
        System.out.println(funcion.buscarEnMovimientos(1));

        //obtenerMenu
        System.out.println(funcion.obtenerMenu(3));

    }
}