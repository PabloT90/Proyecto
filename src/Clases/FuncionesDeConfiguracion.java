package Clases;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class FuncionesDeConfiguracion {
    /*
    * Interfaz
    * Nombre: configuracionInicial
    * Comentario: Esta función permite permite realizar modificaciones
    * automáticas en el almacén de productos y en la lista de menús, según
    * el día y hora a la que se ejecute la aplicación. Modificaciones
    * predeterminadas:
    *   -Todos los lunes los cafés pasan a ser gratuitos.
    *   -Cada sabados de 13:00 a 14:00 se realizará una sincronización del almacén
    *   de productos y de la lista de menús.
    * Cabecera: public void configuracionInicial()
    * Postcondiciones: La función modifica el estado del almacén de productos y/o
    * de la lista de menús.
    * */
    public void configuracionInicial(){
        Calendar fecha = new GregorianCalendar();
        int dia = fecha.get(Calendar.DAY_OF_WEEK);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int minuto = fecha.get(Calendar.MINUTE);
        FuncionesProductos almacenProductos = new FuncionesProductos();
        FuncionesMenus listaMenus = new FuncionesMenus();

        if(dia == 1){//Si es lunes
            cafeGratis();
        }else{
            cafePrecioPredeterminado();
            if(dia == 7 && (hora == 13 || (hora == 14 && minuto == 0))){//Si es sabado y esta en el rango de horas permitido
                almacenProductos.sincronizarAlmacen();
                listaMenus.sincronizarListaMenus();
            }
        }
    }

    /*
    * Interfaz
    * Nombre: cafeGratis
    * Comentario: Esta función permite modificar el precio del café a 0.
    * Cabecera: public int cafeGratis()
    * Salida:
    *   -entero validez
    * Postcondiciones: La función devuelve un número entero asociado al nombre, 0
    * si se ha conseguido modificar el precio del café o -1 si no se ha encontrado
    * el producto en el almacén.
    * */
    public int cafeGratis(){
        int validez = -1;
        FuncionesProductos funcion = new FuncionesProductos();
        ImplStockProducto producto = null;

        if((producto = funcion.obtenerProductoAlmacen(1)) != null){//Si el producto existe
            validez = 0;
            producto.setProductoPrecio(0);
            funcion.insertarProducto(producto);
        }

        return validez;
    }

    /*
     * Interfaz
     * Nombre: cafePrecioPredeterminado
     * Comentario: Esta función permite modificar el precio del café a su precio
     * predereminado, es decir, de 1 euro.
     * Cabecera: public int cafeGratis()
     * Salida:
     *   -entero validez
     * Postcondiciones: La función devuelve un número entero asociado al nombre, 0
     * si se ha conseguido modificar el precio del café o -1 si no se ha encontrado
     * el producto en el almacén.
     * */
    public int cafePrecioPredeterminado(){
        int validez = -1;
        FuncionesProductos funcion = new FuncionesProductos();
        ImplStockProducto producto = null;

        if((producto = funcion.obtenerProductoAlmacen(1)) != null){//Si el producto existe
            validez = 0;
            producto.setProductoPrecio(1);
            funcion.insertarProducto(producto);
        }

        return validez;
    }


    /*
    *
    * */
    public void ajustesEncabezamiento(){
        File listaMenus = new File("src\\Ficheros\\ListaMenus.dat");
        File movimientosMenus = new File("src\\Ficheros\\MovimientosMenu.dat");
        FuncionesMenus fm = new FuncionesMenus();

        if(!listaMenus.isFile()){
            fm.encabezarFichero("src\\Ficheros\\ListaMenus.dat");
        }
        if(!movimientosMenus.isFile()){
            fm.encabezarFichero("src\\Ficheros\\MovimientosMenu.dat");
        }
    }

    /*
    *
    *
    * */
    public void comprobacionFicheros(){
        File fichero = new File("src\\Ficheros\\Movimientos.txt");
        File fichero2 = new File("src\\Ficheros\\AlmacenProductos.txt");
        FileWriter fw = null;
        FileWriter fw2 = null;

        try{
            if(!fichero.isFile()){
                fw = new FileWriter(fichero);
            }
            if(!fichero2.isFile()){
                fw2 = new FileWriter(fichero2);
            }
        }catch(IOException error){
            error.printStackTrace();
        }
    }

}
