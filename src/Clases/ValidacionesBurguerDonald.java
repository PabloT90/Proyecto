package Clases;

import Enums.EnumTipo;
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
        int opcion;

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
        int opcion;

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
        int opcion;

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
        int opcion;

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
        int opcion;

        do{
            menu.mostrarMenu5();
            opcion = teclado.nextInt();
        }while(opcion < 0 || opcion > 2);

        return opcion;
    }

    /*
    * Interfaz
    * Nombre: leerYValidarId
    * Comentario: Esta función permite obtener una id válida de un producto
    * o menú, la id es válida si es mayor o igual que 0.
    * Cabecera: public int leerYValidarId()
    * Salida:
    *   -entero id
    * Postcondiciones: La función de vuelve un número entero asociado al nombre,
    * que es una id válida.
    * */
    public int leerYValidarId(){
        Scanner teclado = new Scanner(System.in);
        int id;

        do{
            System.out.println("Introduce el id (Debe ser mayor o igual que 0).");
            id = teclado.nextInt();
        }while(id < 0);

        return id;
    }

    /*
    * Interfaz
    * Nombre: leerYValidarNuevoProducto
    * Comentario: Esta función permite obtener un producto junto
    * con un stock válido.
    * Cabecera: public ImplStockProducto leerYValidarNuevoProducto(int idProducto)
    * Entrada:
    *   -entero idProducto
    * Salida:
    *   -ImplStockProducto producto
    * Precondiciones:
    *   -idProducto debe ser mayor o igual que 0.
    * Postcondiciones: La función devuelve un tipo ImplStockProducto asociado
    * al nombre, que es un producto con un stock válido.
    * */
    public ImplStockProducto leerYValidarNuevoProducto(int idProducto){
        Scanner teclado = new Scanner(System.in);
        ImplStockProducto producto;
        EnumTipo tipo;
        String nombre, descripcion;
        double precio;
        boolean vegano;
        int stock;

        tipo = leerYValidarTipoProducto();//Obtenemos un tipo válido
        precio = leerYValidarPrecio();//Obtenemos un precio válido
        System.out.println("Introduce el nombre del producto.");//Obtenemos el nombre
        nombre = teclado.nextLine();
        System.out.println("Introduce una descripci\u00f3n para el producto.");//Obtenemos la descripción
        descripcion = teclado.nextLine();
        System.out.println("Indica si el producto es vegano (true/false).");//Obtenemos si el producto es vegano
        vegano = teclado.nextBoolean();
        stock = leerYValidarStock();//Obtenemos un stock válido

        producto = new ImplStockProducto(idProducto, tipo, precio, nombre, descripcion, vegano, stock);

        return producto;
    }

    /*
    * Interfaz
    * Nombre: leerYValidarTipoProducto
    * Comentario: Esta función nos permite obtener un tipo de producto
    * válido para la aplicación BurguerDonald.
    * Cabecera: public EnumTipo leerYValidarTipoProducto()
    * Salida:
    *   -EnumTipo tipoProducto
    * Postcondiciones: La función devuelve un tipo EnumTipo asociado al nombre,
    * que es un tipo de producto válido.
    * */
    public EnumTipo leerYValidarTipoProducto(){
        Scanner teclado = new Scanner(System.in);
        EnumTipo tipoProducto = null;
        String tipo;

        do{
            System.out.println("Indica el tipo de producto (Bebida, Postre, Sandwich, Ensalada, Desayuno o Complemento).");
            tipo = (teclado.nextLine()).toUpperCase();
        }while(!tipo.equals("BEBIDA") && !tipo.equals("POSTRE") && !tipo.equals("SANDWICH") &&
                !tipo.equals("ENSALADA") && !tipo.equals("DESAYUNO") && !tipo.equals("COMPLEMENTO"));

        switch (tipo){
            case "BEBIDA":
                tipoProducto = EnumTipo.BEBIDA;
            break;
            case "POSTRE":
                tipoProducto = EnumTipo.POSTRE;
            break;
            case "SANDWICH":
                tipoProducto = EnumTipo.SANDWICH;
            break;
            case "ENSALADA":
                tipoProducto = EnumTipo.ENSALADA;
            break;
            case "DESAYUNO":
                tipoProducto = EnumTipo.DESAYUNO;
            break;
            case "COMPLEMENTO":
                tipoProducto = EnumTipo.COMPLEMENTO;
            break;
        }

        return tipoProducto;
    }

    /*
    * Interfaz
    * Nombre: leerYValidarPrecio
    * Comentario: Esta función nos permite obtener un precio válido
    * para un producto.
    * Cabecera: public double leerYValidarPrecio()
    * Salida:
    *   -real precio
    * Postcondiciones: La función devuelve un número real asociado al nombre,
    * que es un precio válido para un producto.
    * */
    public double leerYValidarPrecio(){
        Scanner teclado = new Scanner(System.in);
        double precio;

        do{
            System.out.println("Indica el precio del producto (No puede ser negativo).");
            precio = teclado.nextDouble();
        }while(precio < 0);

        return precio;
    }

    /*
    * Interfaz
    * Nombre: leerYValidarStock
    * Comentario: Esta función nos permite obtener un stock válido
    * para un producto.
    * Cabecera: public int leerYValidarStock()
    * Salida:
    *   -entero stock
    * Postcondiciones: La función devuelve un número entero asociado al nombre,
    * que es un stock válido para un producto.
    * */
    public int leerYValidarStock(){
        Scanner teclado = new Scanner(System.in);
        int stock;

        do{
            System.out.println("Indica el stock del producto (No puede ser negativo).");
            stock = teclado.nextInt();
        }while(stock < 0);

        return stock;
    }
}
