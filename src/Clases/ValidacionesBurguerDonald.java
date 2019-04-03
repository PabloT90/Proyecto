package Clases;

import Interfaces.Menu;

import java.util.Scanner;

public class ValidacionesBurguerDonald {
    /*
    * Interfaz
    * Nombre: leerYValidarOpcionMenu
    * Comentario: Esta función permite obtener una opción válida
    * del primer menú del programa BurguerDonald.
    * Cabecera: public int leerYValidarOpcionMenu()
    * Salida:
    *   -entero opcion
    * Postcondiciones: La función devuelve un número entero asociado al nombre, que
    * es una opción válida del menú.
    * */

    /**
     * Obtiene una opcion para el primer menu del programa BurgerDonald.
     * @return asociado al nombre devuelve un número entero con la opción valida del menú.
     */
    public int leerYValidarOpcionMenu(){
        Scanner teclado = new Scanner(System.in);
        MenusYPantallas menu = new MenusYPantallas();
        int opcion = 0;

        do{
            menu.mostrarMenu1();
            opcion = teclado.nextInt();
        }while(opcion < 0 || opcion > 2);

        return opcion;
    }

    /*
    * Interfaz
    * Nombre: leerYValidarOpcionSubMenu1
    * Comentario: Esta función permite obtener una opción válida
    * del primer submenú de la aplicación BurguerDonald.
    * Cabecera: public int leerYValidarOpcionSubMenu1()
    * Salida:
    *   -entero opcion
    * Postcondiciones: La función devuelve un número entero asociado al nombre,
    * que es una opción válida del menú.
    * */

    /**
     * Obtiene un opcion valida del primer submenú de la aplicación BurgerDonald.
     * @return Asociado al nombre devuelve un número entero con la opción valida del menú.
     */
    public int leerYValidarOpcionSubMenu1(){
        Scanner teclado = new Scanner(System.in);
        MenusYPantallas menu = new MenusYPantallas();
        int opcion = 0;

        do{
            menu.mostrarMenu2();
            opcion = teclado.nextInt();
        }while(opcion < 0 || opcion > 6);

        return opcion;
    }

    /*
     * Interfaz
     * Nombre: leerYValidarOpcionSubMenu2
     * Comentario: Esta función permite obtener una opción válida
     * del segundo submenú de la aplicación BurguerDonald.
     * Cabecera: public int leerYValidarOpcionSubMenu2()
     * Salida:
     *   -entero opcion
     * Postcondiciones: La función devuelve un número entero asociado al nombre,
     * que es una opción válida del menú.
     * */

    /**
     * Obtiene una opcion valida del segundo submenú de la aplicación BurguerDonald
     * @return Asociado al nombre devuelve un número entero con la opción valida del menú.
     */
    public int leerYValidarOpcionSubMenu2(){
        Scanner teclado = new Scanner(System.in);
        MenusYPantallas menu = new MenusYPantallas();
        int opcion = 0;

        do{
            menu.mostrarMenu3();
            opcion = teclado.nextInt();
        }while(opcion < 0 || opcion > 6);

        return opcion;
    }

    /*
     * Interfaz
     * Nombre: leerYValidarOpcionSubMenu3
     * Comentario: Esta función permite obtener una opción válida
     * del tercer submenú de la aplicación BurguerDonald.
     * Cabecera: public int leerYValidarOpcionSubMenu3()
     * Salida:
     *   -entero opcion
     * Postcondiciones: La función devuelve un número entero asociado al nombre,
     * que es una opción válida del menú.
     * */

    /**
     * Obtiene una opcion valida del tercer submenú de la aplicacion BurguerDonald
     * @return Asociado al nombre devuelve un número entero con la opción valida del menú.
     */
    public int leerYValidarOpcionSubMenu3(){
        Scanner teclado = new Scanner(System.in);
        MenusYPantallas menu = new MenusYPantallas();
        int opcion = 0;

        do{
            menu.mostrarMenu4();
            opcion = teclado.nextInt();
        }while(opcion < 0 || opcion > 3);

        return opcion;
    }

    /*
     * Interfaz
     * Nombre: leerYValidarOpcionSubMenu4
     * Comentario: Esta función permite obtener una opción válida
     * del cuarto submenú de la aplicación BurguerDonald.
     * Cabecera: public int leerYValidarOpcionSubMenu4()
     * Salida:
     *   -entero opcion
     * Postcondiciones: La función devuelve un número entero asociado al nombre,
     * que es una opción válida del menú.
     * */

    /**
     * Obtiene una opcion válida del cuarto submenú de la aplicación BurguerDonald.
     * @return Asociado al nombre devuelve un número entero con la opción válida del menú.
     */
    public int leerYValidarOpcionSubMenu4(){
        Scanner teclado = new Scanner(System.in);
        MenusYPantallas menu = new MenusYPantallas();
        int opcion = 0;

        do{
            menu.mostrarMenu5();
            opcion = teclado.nextInt();
        }while(opcion < 0 || opcion > 2);

        return opcion;
    }
}
