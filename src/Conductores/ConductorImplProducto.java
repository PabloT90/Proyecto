package Conductores;

import Clases.ImplProducto;
import Enums.EnumTipo;

public class ConductorImplProducto {
    public static void main (String[] args){
        //Constructor por defecto
        ImplProducto producto1 = new ImplProducto();
        System.out.println("producto1.toString() --> "+producto1.toString());

        //Constructor con parámetros
        ImplProducto producto2 = new ImplProducto(1, EnumTipo.BEBIDA, 1.50, "CocaCola", true);
        System.out.println("producto2.toString() --> "+producto2.toString());

        ImplProducto producto3 = new ImplProducto(300, EnumTipo.COMPLEMENTO, 1.0, "Patatas fritas", true);
        System.out.println("producto3.toString() --> "+producto3.toString());

        //Constructor de copia
        ImplProducto producto4 = new ImplProducto(producto3);
        System.out.println("producto4.toString() --> "+producto4.toString());

        //Get Y Set

        //setId
        //producto1.setId(-1);//Valor no permitido
        //producto1.setId(0);
        producto1.setId(200);

        //getId
        System.out.println("producto1.getId() --> "+producto1.getId());

        //setTipo
        //producto1.setTipo(EnumTipo.BEBIDA);
        //producto1.setTipo(EnumTipo.COMPLEMENTO);
        //producto1.setTipo(EnumTipo.DESAYUNO);
        //producto1.setTipo(EnumTipo.POSTRE);
        //producto1.setTipo(EnumTipo.ENSALADA);
        producto1.setTipo(EnumTipo.SANDWICH);

        //getTipo
        System.out.println("producto1.getTipo() --> "+producto1.getTipo());

        //setPrecio
        //producto1.setPrecio(-1.0);////Valor no permitido
        //producto1.setPrecio(0.0);
        producto1.setPrecio(2.45);

        //getPrecio
        System.out.println("producto1.getPrecio() --> "+producto1.getPrecio());

        //setDescripcion
        //producto1.setDescripcion(" ");
        //producto1.setDescripcion("  ");
        producto1.setDescripcion("Esto es una descripcion.");

        //getDescripcion
        System.out.println("producto1.getDescripcion() --> "+producto1.getDescripcion());

        //setVegano
        producto1.setVegano(true);
        //producto1.setVegano(false);

        //getVegano
        System.out.println("producto1.getVegano() --> "+producto1.getVegano());

        System.out.println();

        //Funciones sobreescritas

        //hashCode
        System.out.println("producto1.hashCode() --> "+producto1.hashCode());
        System.out.println("producto2.hashCode() --> "+producto2.hashCode());
        System.out.println("producto3.hashCode() --> "+producto3.hashCode());
        System.out.println("producto4.hashCode() --> "+producto4.hashCode());

        //equals
        System.out.println("producto1.equals(producto2) --> "+producto1.equals(producto2));
        System.out.println("producto2.equals(producto2) --> "+producto2.equals(producto2));
        System.out.println("producto3.equals(producto2) --> "+producto3.equals(producto2));
        System.out.println("producto4.equals(producto3) --> "+producto4.equals(producto3));

        //compareTo
        System.out.println("producto1.compareTo(producto2) --> "+producto1.compareTo(producto2));
        System.out.println("producto2.compareTo(producto1) --> "+producto2.compareTo(producto1));
        System.out.println("producto2.compareTo(producto2) --> "+producto2.compareTo(producto2));
        System.out.println("producto3.compareTo(producto2) --> "+producto3.compareTo(producto2));
        System.out.println("producto4.compareTo(producto3) --> "+producto4.compareTo(producto3));

        //clone
        System.out.println("Clone:");

        System.out.println("producto1.toString() --> "+producto1.toString());
        System.out.println("producto2.toString() --> "+producto2.toString());

        System.out.println("producto1 = producto2.clone()");
        producto1 = producto2.clone();

        System.out.println("producto1.equals(producto2) --> "+producto1.equals(producto2));
        System.out.println("producto1.compareTo(producto2) --> "+producto1.compareTo(producto2));

        System.out.println("producto1.toString() --> "+producto1.toString());
        System.out.println("producto2.toString() --> "+producto2.toString());
    }
}
