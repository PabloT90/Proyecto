package Clases;

public class MenusYPantallas {
    /*
    * Interfaz
    * Nombre: mostrarMenu1
    * Comentario: Esta función permite mostrar por pantalla el primer menú de
    * la aplicación BurguerDonald.
    * Cabecera: public void mostrarMenu1()
    * Postcondiciones: Nada, solo se pinta un menú por pantalla.
    * */

    /**
     * Muestra por pantalla el primer menú de la aplicacion BurguerDonald.
     */
    public void mostrarMenu1(){
        System.out.println("Elige una de las siguientes opciones:");
        System.out.println();
        System.out.println("0 --> Finalizar el programa.");
        System.out.println("1 --> Acciones sobre productos.");
        System.out.println("2 --> Acciones sobre men\u00fas.");
        System.out.println();
    }

    /*
     * Interfaz
     * Nombre: mostrarMenu2
     * Comentario: Esta función permite mostrar por pantalla el segundo submenú de
     * la aplicación BurguerDonald.
     * Cabecera: public void mostrarMenu2()
     * Postcondiciones: Nada, solo se pinta un menú por pantalla.
     * */
    /**
     * Esta función permite mostrar por pantalla el primer submenú de la aplicación BurguerDonald.
     */
    public void mostrarMenu2(){
        System.out.println("Elige una de las siguientes opciones:");
        System.out.println();
        System.out.println("0 --> Volver al men\u00fa anterior.");
        System.out.println("1 --> Consultas.");
        System.out.println("2 --> Modificar producto.");
        System.out.println("3 --> Modificar stock.");
        System.out.println("4 --> Insertar producto con stock.");
        System.out.println("5 --> Eliminar producto.");
        System.out.println("6 --> Ordenar almac\u00e9n de productos.");
        System.out.println();
    }

    /*
     * Interfaz
     * Nombre: mostrarMenu3
     * Comentario: Esta función permite mostrar por pantalla el tercer submenú de
     * la aplicación BurguerDonald.
     * Cabecera: public void mostrarMenu3()
     * Postcondiciones: Nada, solo se pinta un menú por pantalla.
     * */

    /**
     * Esta función permite mostrar por pantalla el tercer submenú de la aplicación BurguerDonald.
     */
    public void mostrarMenu3(){
        System.out.println("Elige una de las siguientes opciones:");
        System.out.println();
        System.out.println("0 --> Volver al men\u00fa anterior.");
        System.out.println("1 --> Mostrar los men\u00fas por pantalla.");
        System.out.println("2 --> Modificar men\u00fa.");
        System.out.println("3 --> Canjear un men\u00fa.");
        System.out.println("4 --> Insertar men\u00fa.");
        System.out.println("5 --> Eliminar men\u00fa.");
        System.out.println("6 --> Ordenar lista de men\u00fas");
        System.out.println();
    }

    /*
     * Interfaz
     * Nombre: mostrarMenu4
     * Comentario: Esta función permite mostrar por pantalla un menú de
     * consultas sobre productos de la aplicación BurguerDonald.
     * Cabecera: public void mostrarMenu4()
     * Postcondiciones: Nada, solo se pinta un menú por pantalla.
     * */

    /**
     *Esta función permite mostrar por pantalla un menú de consultas sobre productos de la aplicación BurguerDonald.
     */
    public void mostrarMenu4(){
        System.out.println("Elige una de las siguientes opciones:");
        System.out.println();
        System.out.println("0 --> Volver al men\u00fa anterior.");
        System.out.println("1 --> Mostrar todos los productos del almac\u00e9n.");
        System.out.println("2 --> Mostrar un tipo de producto.");
        System.out.println("3 --> Mostrar productos veganos.");
        System.out.println();
    }

    /*
     * Interfaz
     * Nombre: mostrarMenu5
     * Comentario: Esta función permite mostrar por pantalla un menú sobre
     * la modificación de stock de productos de la aplicación BurguerDonald.
     * Cabecera: public void mostrarMenu5()
     * Postcondiciones: Nada, solo se pinta un menú por pantalla.
     * */

    /**
     * Esta función permite mostrar por pantalla un menú sobre la modificación de stock de
     * productos de la aplicación BurguerDonald.
     */
    public void mostrarMenu5(){
        System.out.println("Elige una de las siguientes opciones:");
        System.out.println();
        System.out.println("0 --> Volver al men\u00fa anterior.");
        System.out.println("1 --> Incrementar stock de un producto.");
        System.out.println("2 --> Decrementar stock de un producto.");
        System.out.println();
    }
}
