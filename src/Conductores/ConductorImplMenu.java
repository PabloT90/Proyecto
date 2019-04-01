package Conductores;

import Clases.ImplMenu;
import Clases.ImplProducto;
import Enums.EnumTipo;

public class ConductorImplMenu {
    public static void main (String[] args){
        //Constructor por defecto
        ImplMenu menu1 = new ImplMenu();
        System.out.println("menu1.toString() --> "+menu1.toString());

        //Constructor con parámetros
        ImplProducto producto1 = new ImplProducto(1, EnumTipo.BEBIDA, 1.50, "CocaCola", true);
        ImplProducto producto2 = new ImplProducto(300, EnumTipo.COMPLEMENTO, 1.0, "Patatas fritas", true);
        ImplProducto producto3 = new ImplProducto(201, EnumTipo.SANDWICH, 4.5, "Big Supreme", false);
        ImplProducto[] productos1 = {producto1, producto2};
        ImplProducto[] productos2 = {producto1, producto2, producto3};
        ImplProducto[] productos3 = new ImplProducto[2];//Contiene elementos nulos

        ImplMenu menu2 = new ImplMenu(101, "Revienta arterias", productos1);
        System.out.println("menu2.toString() --> "+menu2.toString());

        ImplMenu menu3 = new ImplMenu(102, "Tocino Kusmi", productos2);
        System.out.println("menu3.toString() --> "+menu3.toString());

        //Constructor de copia
        ImplMenu menu4 = new ImplMenu(menu3);
        System.out.println("menu4.toString() --> "+menu4.toString());

        System.out.println();

        //Get Y Set

        //setId
        //menu1.setId(-1);//Valor no permitido
        //menu1.setId(0);
        menu1.setId(145);

        //getId
        System.out.println("menu1.getId() --> "+menu1.getId());

        //setDescripcion
        menu1.setDescripcion(" ");
        menu1.setDescripcion("  ");
        menu1.setDescripcion("Esto es una descripcion.");

        //getDescripcion
        System.out.println("menu1.getDescripcion() --> "+menu1.getDescripcion());

        //setProductos
        //menu1.setProductos(productos3);//Contiene elementos nulos, la interfaz no lo permite.
        //menu1.setProductos(productos1);
        menu1.setProductos(productos2);

        //getPrecioMenu
        System.out.println("menu1.getPrecioMenu() --> "+menu1.getPrecioMenu());//Si productos contiene elementos nulos da error

        System.out.println();

        //Funciones añadidas

        //hashCode
        System.out.println("menu1.hashCode() --> "+menu1.hashCode());
        System.out.println("menu2.hashCode() --> "+menu2.hashCode());
        System.out.println("menu3.hashCode() --> "+menu3.hashCode());
        System.out.println("menu4.hashCode() --> "+menu4.hashCode());

        //equals
        System.out.println("menu1.equals(menu2) --> "+menu1.equals(menu2));
        System.out.println("menu2.equals(menu2) --> "+menu2.equals(menu2));
        System.out.println("menu3.equals(menu2) --> "+menu3.equals(menu2));
        System.out.println("menu4.equals(menu3) --> "+menu4.equals(menu3));

        //compareTo
        System.out.println("menu1.compareTo(menu2) --> "+menu1.compareTo(menu2));
        System.out.println("menu2.compareTo(menu1) --> "+menu2.compareTo(menu1));
        System.out.println("menu2.compareTo(menu2) --> "+menu2.compareTo(menu2));
        System.out.println("menu3.compareTo(menu2) --> "+menu3.compareTo(menu2));
        System.out.println("menu4.compareTo(menu3) --> "+menu4.compareTo(menu3));

        //clone
        System.out.println("Clone:");

        System.out.println("menu1.toString() --> "+menu1.toString());
        System.out.println("menu2.toString() --> "+menu2.toString());

        System.out.println("menu1 = menu2.clone()");
        menu1 = menu2.clone();

        System.out.println("menu1.equals(menu2) --> "+menu1.equals(menu2));
        System.out.println("menu1.compareTo(menu2) --> "+menu1.compareTo(menu2));

        System.out.println("menu1.toString() --> "+menu1.toString());
        System.out.println("menu2.toString() --> "+menu2.toString());
    }
}
