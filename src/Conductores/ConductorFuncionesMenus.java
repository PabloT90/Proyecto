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

        //insertarMenu
        funcion.insertarMenu(menu1);

        //menuEliminado
        //funcion.menuEliminado(1);

    }
}
