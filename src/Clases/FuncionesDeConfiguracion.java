package Clases;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class FuncionesDeConfiguracion {
    /*
    * Interfaz
    * Nombre: configuracionInicial
    * Comentario: Esta función permite realizar modificaciones
    * automáticas en el almacén de productos y en la lista de menús, según
    * el día y hora a la que se ejecute la aplicación. Modificaciones
    * predeterminadas:
    *   -Todos los lunes los cafés pasan a ser gratuitos.
    *   -Cada sábado de 13:00 a 14:00 se realizará una sincronización del almacén
    *   de productos y de la lista de menús.
    * Cabecera: public void configuracionInicial()
    * Postcondiciones: La función modifica el estado del almacén de productos y/o
    * de la lista de menús.
    * */
    /**
     * Realiza modificaciones automáticas en el almacén de productos y en la lista de menús según el día y hora en que se ejecute la aplicación.
     * Modifica el estado del almacén de productos y/o de la lista de menús.
     */
    public void configuracionInicial(){
        Calendar fecha = new GregorianCalendar();
        int dia = fecha.get(Calendar.DAY_OF_WEEK);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int minuto = fecha.get(Calendar.MINUTE);
        FuncionesProductos almacenProductos = new FuncionesProductos();
        FuncionesMenus listaMenus = new FuncionesMenus();

        if(dia == 1){//Si es lunes
            cafeGratis();
        }else{ //Si es cualquier otro dia
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
    /**
     * Modifica el precio del café a 0.
     * @return 0 si se ha conseguido modificar el precio del café.
     *        -1 si no se ha encontrado el producto en el almacén.
     */
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
     * predeterminado, es decir, de 1 euro.
     * Cabecera: public int cafePrecioPredeterminado()
     * Salida:
     *   -entero validez
     * Postcondiciones: La función devuelve un número entero asociado al nombre, 0
     * si se ha conseguido modificar el precio del café o -1 si no se ha encontrado
     * el producto en el almacén.
     * */
    /**
     * Modifica el precio del café a su precio predeterminado.
     * @return 0 si se ha conseguido modificar el precio.
     *        -1 si no se ha encontrado el producto en el almacén.
     */
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
    * Interfaz
    * Nombre: ajustesEncabezamiento
    * Comentario: Esta función crear los ficheros maestro y de movimiento para el manejo de menús con una
    * cabecera válida para trabajar con la clase ObjectStream, en caso de no existir dichos ficheros.
    * Cabecera: public void ajustesEncabezamiento()
    * Postcondiciones: La función puede llegar a crear un fichero maestro y/o
    * de movimientos con la cabecera para poder manejar correctamente el fichero
    * con la clases de ObjectStream.
    * */
    /**
     * Esta función crear los ficheros maestro y de movimiento con una cabecera válida para trabajar
     * con la clase ObjectStream, en caso de no existir.
     */
    public void ajustesEncabezamiento(){
        File listaMenus = new File("src\\Ficheros\\ListaMenus.dat");
        File movimientosMenus = new File("src\\Ficheros\\MovimientosMenu.dat");
        FuncionesMenus fm = new FuncionesMenus();

        if(!listaMenus.isFile()){
            fm.crearFichero("src\\Ficheros\\ListaMenus.dat");
        }
        if(!movimientosMenus.isFile()){
            fm.crearFichero("src\\Ficheros\\MovimientosMenu.dat");
        }
    }

    /*
    * Interfaz
    * Nombre: comprobacionFicheros
    * Comentario: Esta función crea el fichero maestro y de movimientos
    * del almacén de productos, en caso de que no existan.
    * Cabecera: public void comprobacionFicheros()
    * Postcondiciones: La función puede llegar a generar dos ficheros
    * de texto para la aplicación BurguerDonald.
    * IOException si ocurre algún error en la entrada de los datos.
    * */
    /**
     * Crea el fichero maestro y de movimientos del almacén de productos, en caso de no existir.
     * @throws IOException si ocurre algún error en la entrada de los datos.
     */
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

    /*
    * Reproduce pistas de audio en formato .mp3
    * Entrada:
    *   - entero pista
    * Postcondiciones: nada, solo reproduce sonido.
    * Cabecera: void sonidos(int numAudio)
    * FileNotFoundException en caso de no encontrar un archivo.
    * JavaLayerException si ocurre algun error a la hora de reproducir los archivos.
    * */
    /**
     * Reproduce pistas de audio en formato .mp3
     * @param numAudio Numero de pista
     * @throws FileNotFoundException en caso de no encontrar un archivo.
     * @throws JavaLayerException si ocurre algun error a la hora de reproducir los archivos.
     */
    public void sonidos(int numAudio){
        Player apl = null;
        try {
            if (numAudio == 0) {
                apl = new Player(new FileInputStream("src\\Media\\gorrino.mp3"));
                apl.play();
            } else if (numAudio == 1) {
                apl = new Player(new FileInputStream("src\\Media\\intro.mp3"));
                apl.play();
            }else{
                apl = new Player(new FileInputStream("src\\Media\\me.mp3"));
                apl.play();
            }
        }catch(FileNotFoundException error){
            error.printStackTrace();
        }catch(JavaLayerException error2){
            error2.printStackTrace();
        }
    }

}
