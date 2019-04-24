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
    /**
     * Obtiene un ID válida de un producto o menu.
     * @return Asociado al nombre devuelve un entero mayor que 0, que es una ID válida.
     */
    public int leerYValidarId(){
        Scanner teclado = new Scanner(System.in);
        int id;

        do{
            System.out.println("Introduce el ID (Debe ser mayor o igual que 0).");
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
    /**
     * Obtiene un producto con un stock válido.
     * @param idProducto ID del producto.
     * @return Asociado al nombre devuelve un tipo ImplStockProducto, que es un producto con stock válido.
     */
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
    /**
     * Obtiene un tipo de producto válido para la aplicación BurguerDonald
     * @return Asociado al nombre devuelve un EnumTipo.
     */
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
    /**
     * Obtiene un precio válido para un producto.
     * @return Asociado al nombre devuelve el precio del producto.
     */
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
    /**
     * Obtiene un stock válido para un producto.
     * @return Asociado al nombre devuelve el número de stock de un producto.
     */
    public int leerYValidarStock(){
        Scanner teclado = new Scanner(System.in);
        int stock;

        do{
            System.out.println("Indica el stock del producto (No puede ser negativo).");
            stock = teclado.nextInt();
        }while(stock < 0);
        return stock;
    }

    /*
    * Interfaz
    * Nombre: leerYValidarProductoModificado
    * Comentario: Esta función nos permite obtener un tipo ImplStockProducto
    * válido, que es un producto del almacén modificado por el usuario.
    * El usuario podrá modificar los campos del producto que el desee.
    * Cabecera: public ImplStockProducto leerYValidarProductoModificado(int idProducto)
    * Entrada:
    *   -entero idProducto
    * Salida:
    *   -ImplStockProducto producto
    * Postcondiciones: La función devuelve un tipo ImplStockProducto asociado al nombre, que
    * es un producto del almacén modificado o null si idProducto no coincide con ninguno de los
    * productos del almacén (Si no se encontró el producto en el almacén).
    * */
    /**
     * Obtiene un tipo StockImplProducto válido, que es un producto modificado por el usuario.
     * @param idProducto ID del producto a modificar.
     * @return Asociado al nombre devuelve un ImplStockProducto con el producto modificado. Si el ID no coincide
     * con ninguno de los del almacén devuelve null
     */
    public ImplStockProducto leerYValidarProductoModificado(int idProducto){
        FuncionesProductos funcion = new FuncionesProductos();
        ImplStockProducto producto = funcion.obtenerProductoAlmacen(idProducto);
        Scanner teclado = new Scanner(System.in);

        if(producto != null){
            if(leerYValidarRespuestaTipo(producto) == 's'){
                producto.setProductoTipo(leerYValidarTipoProducto());
            }

            if(leerYValidarRespuestaPrecio(producto) == 's'){
                producto.setProductoPrecio(leerYValidarPrecio());
            }

            if(leerYValidarRespuestaNombre(producto) == 's'){
                System.out.println("Introduce el nuevo nombre del producto.");
                producto.setProductoNombre(teclado.nextLine());
            }

            if(leerYValidarRespuestaDescripcion(producto) == 's'){
                System.out.println("Introduce la nueva descripci\u00f3n del producto.");
                producto.setProductoDescripcion(teclado.nextLine());
            }

            if(leerYValidarRespuestaVegano(producto) == 's'){
                System.out.println("Indica si el producto es o no vegano (true/false).");
                producto.setProductoVegano(teclado.nextBoolean());
            }

            if(leerYValidarRespuestaStock(producto) == 's'){
                producto.setStock(leerYValidarStock());
            }
        }
        return producto;
    }

    /*
    * Interfaz
    * Nombre: leerYValidarRespuestaTipo
    * Comentario: Esta función nos permite obtener una respuesta válida para
    * la modificación del tipo de un producto. Esta función es utilizada en
    * el método leerYValidarProductoModificado.
    * Cabecera: public char leerYValidarRespuestaTipo(ImplStockProducto producto)
    * Entrada:
    *   -ImplStockProducto producto
    * Salida:
    *   -carácter respuesta
    * Postcondiciones: La función devuelve un carácter asociado al nombre, que es
    * una respuesta válida.
    * */
    /**
     * Obtiene una respuesta valida para la modificación del tipo producto.
     * @param producto Producto al que le queremos modificar el tipo.
     * @return Asociado al nombre devuelve un caracter. 's' o 'n'.
     */
    public char leerYValidarRespuestaTipo(ImplStockProducto producto){
        Scanner teclado = new Scanner(System.in);
        char respuesta = ' ';

        do{
            System.out.println("Indica si deseas modificar su tipo (s/n). Tipo actual: "+producto.getProductoTipo());
            respuesta = Character.toLowerCase(teclado.next().charAt(0));
        }while(respuesta != 's' & respuesta != 'n');

        return respuesta;
    }

    /*
     * Interfaz
     * Nombre: leerYValidarRespuestaPrecio
     * Comentario: Esta función nos permite obtener una respuesta válida para
     * la modificación del precio de un producto. Esta función es utilizada en
     * el método leerYValidarProductoModificado.
     * Cabecera: public char leerYValidarRespuestaPrecio(ImplStockProducto producto)
     * Entrada:
     *   -ImplStockProducto producto
     * Salida:
     *   -carácter respuesta
     * Postcondiciones: La función devuelve un carácter asociado al nombre, que es
     * una respuesta válida.
     * */
    /**
     * Obtiene un respuesta válida para la modificación del precio de un producto.
     * @param producto Producto al que queremos modificar el precio.
     * @return Asociado al nombre devuelve un caracter. 's' o 'n'.
     */
    public char leerYValidarRespuestaPrecio(ImplStockProducto producto){
        Scanner teclado = new Scanner(System.in);
        char respuesta = ' ';

        do{
            System.out.println("Indica si deseas modificar su precio (s/n). Precio actual: "+producto.getProductoPrecio());
            respuesta = Character.toLowerCase(teclado.next().charAt(0));
        }while(respuesta != 's' & respuesta != 'n');

        return respuesta;
    }

    /*
     * Interfaz
     * Nombre: leerYValidarRespuestaNombre
     * Comentario: Esta función nos permite obtener una respuesta válida para
     * la modificación del nombre de un producto. Esta función es utilizada en
     * el método leerYValidarProductoModificado.
     * Cabecera: public char leerYValidarRespuestaNombre(ImplStockProducto producto)
     * Entrada:
     *   -ImplStockProducto producto
     * Salida:
     *   -carácter respuesta
     * Postcondiciones: La función devuelve un carácter asociado al nombre, que es
     * una respuesta válida.
     * */
    /**
     * Obtiene una respuesta valida para la modificación del nombre de un producto.
     * @param producto Producto al que le queremos modificar el nombre.
     * @return Asociado al nombre devuelve un caracter. 's' o 'n'.
     */
    public char leerYValidarRespuestaNombre(ImplStockProducto producto){
        Scanner teclado = new Scanner(System.in);
        char respuesta = ' ';

        do{
            System.out.println("Indica si deseas modificar su nombre (s/n). Nombre actual: "+producto.getProductoNombre());
            respuesta = Character.toLowerCase(teclado.next().charAt(0));
        }while(respuesta != 's' & respuesta != 'n');

        return respuesta;
    }

    /*
     * Interfaz
     * Nombre: leerYValidarRespuestaDescripcion
     * Comentario: Esta función nos permite obtener una respuesta válida para
     * la modificación de la descripción de un producto. Esta función es utilizada en
     * el método leerYValidarProductoModificado.
     * Cabecera: public char leerYValidarRespuestaDescripcion(ImplStockProducto producto)
     * Entrada:
     *   -ImplStockProducto producto
     * Salida:
     *   -carácter respuesta
     * Postcondiciones: La función devuelve un carácter asociado al nombre, que es
     * una respuesta válida.
     * */
    /**
     * Obtiene un respuesta válida para la modificación de la descripión de un producto.
     * @param producto Producto al que le queremos modificar la descripción.
     * @return Asociado al nombre devuelve un caracter. 's' o 'n'.
     */
    public char leerYValidarRespuestaDescripcion(ImplStockProducto producto){
        Scanner teclado = new Scanner(System.in);
        char respuesta = ' ';

        do{
            System.out.println("Indica si deseas modificar su descripci\u00f3n (s/n).");
            System.out.println("Descripci\u00f3n actual: "+producto.getProductoDescripcion());
            respuesta = Character.toLowerCase(teclado.next().charAt(0));
        }while(respuesta != 's' & respuesta != 'n');

        return respuesta;
    }

    /*
     * Interfaz
     * Nombre: leerYValidarRespuestaVegano
     * Comentario: Esta función nos permite obtener una respuesta válida para
     * la modificación de la clasificación vegana de un producto. Esta función es utilizada en
     * el método leerYValidarProductoModificado.
     * Cabecera: public char leerYValidarRespuestaVegano(ImplStockProducto producto)
     * Entrada:
     *   -ImplStockProducto producto
     * Salida:
     *   -carácter respuesta
     * Postcondiciones: La función devuelve un carácter asociado al nombre, que es
     * una respuesta válida.
     * */
    /**
     * Obtiene un respuesta válida para la modificación de la clasificación vegana de un producto.
     * @param producto Producto al que le queremos modificar si es vegano o no.
     * @return Asociado al nombre devuelve un caracter. 's' o 'n'.
     */
    public char leerYValidarRespuestaVegano(ImplStockProducto producto){
        Scanner teclado = new Scanner(System.in);
        char respuesta = ' ';

        do{
            System.out.println("Indica si deseas modificar la clasificaci\u00f3n vegana del producto (s/n). " +
                    "Producto vegano: "+producto.getProductoVegano());
            respuesta = Character.toLowerCase(teclado.next().charAt(0));
        }while(respuesta != 's' & respuesta != 'n');

        return respuesta;
    }

    /*
     * Interfaz
     * Nombre: leerYValidarRespuestaStock
     * Comentario: Esta función nos permite obtener una respuesta válida para
     * la modificación del stock de un producto. Esta función es utilizada en
     * el método leerYValidarProductoModificado.
     * Cabecera: public char leerYValidarRespuestaStock(ImplStockProducto producto)
     * Entrada:
     *   -ImplStockProducto producto
     * Salida:
     *   -carácter respuesta
     * Postcondiciones: La función devuelve un carácter asociado al nombre, que es
     * una respuesta válida.
     * */
    /**
     * Obtiene un respuesta válida para la modificación del stock de un producto.
     * @param producto Producto al que le queremos modificar el stock.
     * @return Asociado al nombre devuelve un caracter. 's' o 'n'.
     */
    public char leerYValidarRespuestaStock(ImplStockProducto producto){
        Scanner teclado = new Scanner(System.in);
        char respuesta = ' ';

        do{
            System.out.println("Indica si deseas modificar su stock (s/n). Stock actual: "+producto.getStock());
            respuesta = Character.toLowerCase(teclado.next().charAt(0));
        }while(respuesta != 's' & respuesta != 'n');

        return respuesta;
    }

    /*
    * Interfaz
    * Nombre: leerYValidarNuevoMenu
    * Comentario: Esta función nos permite obtener un tipo ImplMenu válido
    * para el programa BurguerDonald.
    * Cabecera: public ImplMenu leerYValidarNuevoMenu(int id)
    * Entrada:
    *   -int id
    * Precondiciones:
    *   -el id debe ser positivo.
    * Salida:
    *   -ImplMenu menu
    * Postcondiciones: La función devuelve un tipo ImplMenu asociado al nombre,
    * que es un menú válido para el programa.
    * */
    /**
     * Obtiene un tipo ImplMenu válido para el programa BurguerDonald.
     * @return Asociado al nombre devuelve un tipo ImplMenu, que es un menu válido para el programa.
     */
    public ImplMenu leerYValidarNuevoMenu(int id){
        ImplMenu menu = null;
        Scanner teclado = new Scanner(System.in);
        double precio =0;
        String nombre = " ", descripcion = " ";
        int[] productos;

        System.out.println("Introduce el nombre del men\u00fa.");
        nombre = teclado.nextLine();
        System.out.println("Introduce la descripci\u00f3n del men\u00fa.");
        descripcion = teclado.nextLine();
        productos = leerYValidarListaProductos();
        precio = leerYValidarPrecio();

        menu = new ImplMenu(id, nombre, descripcion, productos, precio);

        return menu;
    }

    /*
    * Interfaz
    * Nombre: leerYValidarListaProductos
    * Comentario: Esta función nos permite obtener un array de enteros
    * que son las id's de los productos que contendrá un menú.
    * Cabecera: public int[] leerYValidarListaProductos()
    * Salida:
    *   -entero[] productos
    * Precondiciones:
    *   -El almacén de productos no debe estar vacío. (Fichero AlmacenProductos y FicheroMovimientoNuevosProductos)
    * Postcondiciones: La función devuelve un array de enteros asociado al nombre,
    * que es una lista de los id's de productos válida para un menú.
    * */
    /**
     * Obtiene un array de enteros válido para un menú.
     * @return Asociado al nombre devuelve un array de enteros, que es una lista de id's de productos válida para un menú.
     */
    public int[] leerYValidarListaProductos(){
        int[] productos = new int[1], aux = null;
        char respuesta;

        do{
            productos[productos.length-1] = leerYValidarProductoDelAlmacen();
            respuesta = leerYValidarRespuestaInsercion();
            if(respuesta == 's'){//Incrementamos el tamaño del array
                aux = new int[productos.length+1];
                System.arraycopy(productos, 0, aux, 0, productos.length);
                productos = aux;
            }
        }while(respuesta == 's');

        return productos;
    }

    /*
    * Interfaz
    * Nombre: leerYValidarRespuestaInsercion
    * Comentario: Esta función nos permite obtener una respuesta válida
    * a la hora de insertar un nuevo producto en un menú. Esta función es
    * utilizada en el método leerYValidarListaProductos.
    * Cabecera: public char leerYValidarRespuestaInsercion()
    * Salida:
    *   -carácter respuesta
    * Postcondiciones: La función devuelve un caracter asociado al nombre,
    * que es una respuesta válida.
    * */
    /**
     * Obtiene una respuesta válida a la hora de insertar un nuevo producto en un menú.
     * @return Asociado al nombre devuelve 's' o 'n'.
     */
    public char leerYValidarRespuestaInsercion(){
        char respuesta;
        Scanner teclado = new Scanner(System.in);

        do{
            System.out.println("Indica si deseas insertar otro producto (s/n).");
            respuesta = Character.toLowerCase(teclado.next().charAt(0));
        }while (respuesta != 's' && respuesta != 'n');

        return respuesta;
    }

    /*
    * Interfaz
    * Nombre: leerYValidarProductoDelAlmacen
    * Comentario: Esta función nos permite obtener un tipo ImplProducto
    * válido del almacén de productos.
    * Cabecera: public ImplProducto leerYValidarProductoDelAlmacen()
    * Salida:
    *   -ImplProducto producto
    * Precondiciones:
    *   -El almacén no debe estar vacío (Los ficheros AlmacenProductos y FicheroMovimientoNuevosProductos).
    * Postcondiciones: La función devuelve un tipo ImplProducto asociado al nombre,
    * que es un producto del almacén.
    * */
    /**
     * Obtiene un tipo ImplProducto válido para el almacén de productos.
     * @return Asociado al nombre devuelve un producto del almacén.
     */
    public int leerYValidarProductoDelAlmacen(){
        ImplStockProducto productoConStock;
        Scanner teclado = new Scanner(System.in);
        FuncionesProductos funcion = new FuncionesProductos();
        int idProducto;
        do{
            System.out.println("Lista de productos:");
            funcion.mostrarProductosAlmacen();
            System.out.println("Indica el id del producto a introducir.");
            idProducto = teclado.nextInt();
            productoConStock = funcion.obtenerProductoAlmacen(idProducto);
        }while(productoConStock == null);//Si el id no coincide con ninguno de los productos del almacén

        return idProducto;
    }

    /*
    * Lee y valida el decremento que se le aplicara a un producto
    * Entrada: ImplStockProducto producto.
    * Salida: entero stock.
    * Postcondiciones: Asociado al nombre se devuelve el stock.
    * Cabecera: leerValidarDecremento(ImplStockProducto producto)
    * */
    /**
     * Lee y valida el decremento.
     * @param producto Producto para saber su stock.
     * @return Asociado al nombre se manda el stock.
     */
    public int leerValidarDecremento(ImplStockProducto producto){
        Scanner teclado = new Scanner(System.in);
        int stock;
        do{
            System.out.println("Cuanto decremento quieres aplicar?");
            stock = teclado.nextInt();
        }while(producto.getStock() < stock);
        return stock;
    }

}