package Tests;

import Clases.ImplProducto;
import Clases.ImplStockProducto;
import Enums.EnumTipo;

public class TestImplStockProducto {
    public static void main (String[] args){
        //Constructor por defecto
        ImplStockProducto stockProducto1 = new ImplStockProducto();
        System.out.println("stockProducto1.toString() --> "+stockProducto1.toString());

        //Constructor con parámetros
        ImplProducto producto1 = new ImplProducto(1, EnumTipo.BEBIDA, 1.50, "CocaCola", true);
        ImplProducto producto2 = new ImplProducto(300, EnumTipo.COMPLEMENTO, 1.0, "Patatas fritas", true);

        ImplStockProducto stockProducto2 = new ImplStockProducto(producto1, 7);
        System.out.println("stockProducto2.toString() --> "+stockProducto2.toString());

        ImplStockProducto stockProducto3 = new ImplStockProducto(producto2, 34);
        System.out.println("stockProducto3.toString() --> "+stockProducto3.toString());

        //Constructor de copia
        ImplStockProducto stockProducto4 = new ImplStockProducto(stockProducto3);
        System.out.println("stockProducto4.toString() --> "+stockProducto4.toString());

        System.out.println();

        //Get Y Set

        //setStock
        //stockProducto1.setStock(-1);//Valor no permitido por la interfaz
        //stockProducto1.setStock(0);
        stockProducto1.setStock(12);

        //getStock
        System.out.println("stockProducto1.getStock() --> "+stockProducto1.getStock());

        //Funciones añadidas

        //setProductoId
        //stockProducto1.setProductoId(-1);//Valor no permitido
        //stockProducto1.setProductoId(0);
        stockProducto1.setProductoId(200);

        //getProductoId
        System.out.println("stockProducto1.getProductoId() --> "+stockProducto1.getProductoId());

        //setProductoTipo
        //stockProducto1.setProductoTipo(EnumTipo.BEBIDA);
        //stockProducto1.setProductoTipo(EnumTipo.COMPLEMENTO);
        //stockProducto1.setProductoTipo(EnumTipo.DESAYUNO);
        //stockProducto1.setProductoTipo(EnumTipo.POSTRE);
        //stockProducto1.setProductoTipo(EnumTipo.ENSALADA);
        stockProducto1.setProductoTipo(EnumTipo.SANDWICH);

        //getProductoTipo
        System.out.println("stockProductoProducto1.getTipo() --> "+stockProducto1.getProductoTipo());

        //setProductoPrecio
        //stockProducto1.setProductoPrecio(-1.0);////Valor no permitido
        //stockProducto1.setProductoPrecio(0.0);
        stockProducto1.setProductoPrecio(2.45);

        //getProductoPrecio
        System.out.println("stockProducto1.getProductoPrecio() --> "+stockProducto1.getProductoPrecio());

        //setProductoDescripcion
        //stockProducto1.setProductoDescripcion(" ");
        //stockProducto1.setProductoDescripcion("  ");
        stockProducto1.setProductoDescripcion("Esto es una descripcion.");

        //getDescripcion
        System.out.println("stockProducto1.getProductoDescripcion() --> "+stockProducto1.getProductoDescripcion());

        //setProductoVegano
        stockProducto1.setProductoVegano(true);
        //stockProducto1.setProductoVegano(false);

        //getProductoVegano
        System.out.println("stockProducto1.getProductoVegano() --> "+stockProducto1.getProductoVegano());

        System.out.println();

        //hashCode
        System.out.println("stockProducto1.hashCode() --> "+stockProducto1.hashCode());
        System.out.println("stockProducto2.hashCode() --> "+stockProducto2.hashCode());
        System.out.println("stockProducto3.hashCode() --> "+stockProducto3.hashCode());
        System.out.println("stockProducto4.hashCode() --> "+stockProducto4.hashCode());

        //equals
        System.out.println("stockProducto1.equals(stockProducto2) --> "+stockProducto1.equals(stockProducto2));
        System.out.println("stockProducto2.equals(stockProducto2) --> "+stockProducto2.equals(stockProducto2));
        System.out.println("stockProducto3.equals(stockProducto1) --> "+stockProducto3.equals(stockProducto1));
        System.out.println("stockProducto4.equals(stockProducto3) --> "+stockProducto4.equals(stockProducto3));

        //clone
        System.out.println("clone:");

        System.out.println("stockProducto1.toString() --> "+stockProducto1.toString());
        System.out.println("stockProducto2.toString() --> "+stockProducto2.toString());

        System.out.println("stockProducto1 = stockProducto2.clone()");
        stockProducto1 = stockProducto2.clone();

        System.out.println("stockProducto1.equals(stockProducto2) --> "+stockProducto1.equals(stockProducto2));

        System.out.println("stockProducto1.toString() --> "+stockProducto1.toString());
        System.out.println("stockProducto2.toString() --> "+stockProducto2.toString());

        System.out.println("Realizamos cambios en el objeto relacionado:");
        stockProducto1.setProductoPrecio(999);

        System.out.println("stockProducto1.toString() --> "+stockProducto1.toString());
        System.out.println("stockProducto2.toString() --> "+stockProducto2.toString());

        //deepClone
        System.out.println("deepClone:");

        System.out.println("stockProducto1.toString() --> "+stockProducto1.toString());
        System.out.println("stockProducto3.toString() --> "+stockProducto3.toString());

        System.out.println("stockProducto1 = stockProducto3.deepClone()");
        stockProducto1 = stockProducto3.deepClone();

        System.out.println("stockProducto1.equals(stockProducto3) --> "+stockProducto1.equals(stockProducto3));

        System.out.println("stockProducto1.toString() --> "+stockProducto1.toString());
        System.out.println("stockProducto3.toString() --> "+stockProducto3.toString());

        System.out.println("Realizamos cambios en el objeto relacionado:");
        stockProducto1.setProductoTipo(EnumTipo.POSTRE);

        System.out.println("stockProducto1.toString() --> "+stockProducto1.toString());
        System.out.println("stockProducto3.toString() --> "+stockProducto3.toString());
    }
}
