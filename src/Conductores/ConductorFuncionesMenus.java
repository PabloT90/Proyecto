package Conductores;

import Clases.FuncionesMenus;
import Clases.ImplMenu;
import Clases.ImplProducto;
import Enums.EnumTipo;

public class ConductorFuncionesMenus {
    public static void main (String[] args){
        FuncionesMenus funcion = new FuncionesMenus();
        int[] productos = {67, 68}, productos2 = {1, 69};
        ImplMenu menu1 = new ImplMenu(19, "ParaPa", "El 19.", productos, 3.5);
        ImplMenu menu2 = new ImplMenu(4, "Nononono", "El 4.", productos, 9.5);
        ImplMenu menu3 = new ImplMenu(23, "*Nueeevo", "El 23.", productos, 9.5);
        ImplMenu menu4 = new ImplMenu(4, "Pato", "El 4.", productos, 9.5);
        ImplMenu menu5 = new ImplMenu(22, "Nueevo", "El 22.", productos2, 9.5);

        funcion.crearFichero("src\\Ficheros\\MovimientosMenu.dat");
        funcion.crearFichero("src\\Ficheros\\ListaMenus.dat");

        //insertarMenu
        funcion.insertarMenu(menu1);
        funcion.insertarMenu(menu2);
        funcion.insertarMenu(menu3);
        funcion.insertarMenu(menu4);
        funcion.insertarMenu(menu5);

        //menuEliminado
        System.out.println(funcion.menuEliminado(1));

        //eliminarMenu
        System.out.println(funcion.eliminarMenu(3));

        //buscarEnListaMenus
        System.out.println(funcion.buscarEnListaMenus(3));

        //buscarMovimientosMenu
        System.out.println(funcion.buscarEnMovimientos(1));

        //obtenerMenu
        System.out.println(funcion.obtenerMenu(3));

        //sincronizarListaMenus
        funcion.sincronizarListaMenus();

        //mostrarListaMenus (funciona)
        funcion.mostrarListaMenus();

        //menuContieneProducto (funciona)
        System.out.println(funcion.menuContieneProducto(menu1,66));

        //eliminarMenusPorProductoDeterminado
        funcion.eliminarMenusPorProductoDeterminado(66);

        //productoSinStock
        System.out.println(funcion.productoSinStock(19));

        //canjeoMenu
        System.out.println(funcion.canjeoMenu(menu1));

    }
}