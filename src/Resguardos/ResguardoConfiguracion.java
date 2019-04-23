package Resguardos;

public class ResguardoConfiguracion {
    /*
     * Interfaz
     * Nombre: configuracionInicial
     * Comentario: Esta función permite realizar modificaciones
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
    /**
     * Realiza modificaciones automáticas en el almacén de productos y en la lista de menús según el día y hora en que se ejecute la aplicación.
     * Modifica el estado del almacén de productos y/o de la lista de menús.
     */
    public void configuracionInicial(){
        System.out.println("En resguardo.");
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
        System.out.println("En resguardo.");
        return -1;
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
        System.out.println("En resguardo.");
        return -1;
    }


    /*
     * Interfaz
     * Nombre: ajustesEncabezamiento
     * Comentario: Esta función permite establecer la cabecera inicial del
     * fichero maestro y el de movimientos para la lista de menús.
     * Cabecera: public void ajustesEncabezamiento()
     * Postcondiciones: La función puede llegar a crear un fichero maestro y/o
     * de movimientos con la cabecera para poder manejar correctamente el fichero
     * con la clases de ObjectStream.
     * */
    /**
     * Establece la cabecera inicial del fichero maestro y el de movimientos para la lista de menús.
     */
    public void ajustesEncabezamiento(){
        System.out.println("En resguardo.");
    }

    /*
     * Interfaz
     * Nombre: comprobacionFicheros
     * Comentario: Esta función crea el fichero maestro y de movimientos
     * del almacén de productos, en caso de que no existan.
     * Cabecera: public void comprobacionFicheros()
     * Postcondiciones: La función puede llegar a generar dos ficheros
     * de texto para aplicación BurguerDonald.
     * */
    /**
     * Crea el fichero maestro y de movimientos del almacén de productos, en caso de no existir.
     */
    public void comprobacionFicheros(){
       System.out.println("En resguardo.");
    }
}
