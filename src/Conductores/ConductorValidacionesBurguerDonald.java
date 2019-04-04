package Conductores;

import Clases.ImplStockProducto;
import Clases.ValidacionesBurguerDonald;
import Enums.EnumTipo;

public class ConductorValidacionesBurguerDonald {
    public static void main (String[] args){
        ValidacionesBurguerDonald funcion = new ValidacionesBurguerDonald();
        ImplStockProducto producto1 = new ImplStockProducto(300, EnumTipo.COMPLEMENTO, 1.0, "Patatas fritas", "A gajos", true, 34);

        //leerYValidarOpcionMenu
        //System.out.println(funcion.leerYValidarOpcionMenu());

        //leerYValidarOpcionSubMenu1
        //System.out.println(funcion.leerYValidarOpcionSubMenu1());

        //leerYValidarOpcionSubMenu2
        //System.out.println(funcion.leerYValidarOpcionSubMenu2());

        //leerYValidarOpcionSubMenu3
        //System.out.println(funcion.leerYValidarOpcionSubMenu3());

        //leerYValidarOpcionSubMenu4
        //System.out.println(funcion.leerYValidarOpcionSubMenu4());

        //leerYValidarId
        //System.out.println(funcion.leerYValidarId());

        //leerYValidarTipoProducto
        //System.out.println(funcion.leerYValidarTipoProducto());

        //leerYValidarPrecio
        //System.out.println(funcion.leerYValidarPrecio());

        //leerYValidarStock
        //System.out.println(funcion.leerYValidarStock());

        //leerYValidarNuevoProducto
        //System.out.println(funcion.leerYValidarNuevoProducto(345));

        //leerYValidarRespuestaTipo
        //System.out.println(funcion.leerYValidarRespuestaTipo(producto1));

        //leerYValidarRespuestaPrecio
        //System.out.println(funcion.leerYValidarRespuestaPrecio(producto1));

        //leerYValidarRespuestaNombre
        //System.out.println(funcion.leerYValidarRespuestaNombre(producto1));

        //leerYValidarRespuestaDescripcion
        //System.out.println(funcion.leerYValidarRespuestaDescripcion(producto1));

        //leerYValidarRespuestaVegano
        //System.out.println(funcion.leerYValidarRespuestaVegano(producto1));

        //leerYValidarRespuestaStock
        //System.out.println(funcion.leerYValidarRespuestaStock(producto1));

        //leerYValidarProductoModificado
        //System.out.println(funcion.leerYValidarProductoModificado(54));
        System.out.println(funcion.leerYValidarProductoModificado(55));
    }
}
