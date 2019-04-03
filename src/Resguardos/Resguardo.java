package Resguardos;

import Clases.ImplMenu;
import Clases.ImplStockProducto;
import Enums.EnumTipo;

public class Resguardo {
    /**
     * Permite mostrar los diferentes menus de comida por pantalla
     * Se muestra el id, el nombre y la descripcion del menu.
     * Postcondiciones: nada, solo se muestra por pantalla los menus de comida.
     */
    public void mostrarMenus(){
        System.out.println("mostrarMenus en reguardo.");
    }

    /**
     * Permite mostrar todos los productos del almacen
     * Postcondiciones: nada, solo se muestran todos los productos del almacen.
     */
    public void mostrarProductosAlmacen(){
        System.out.println("mostrarProductosAlmacen en resguardo.");
    }

    /**
     * Muestra por pantalla todos los productos veganos
     * Postcondiciones: nada, solo se muestra por pantalla los productos veganos del almacen.
     */
    public void mostrarProductosVeganos(){
        System.out.println("mostrarProductosVeganos en resguardo.");
    }

    /*
    * Interfaz
    * Nombre: modificarProducto
    * Comentario: Esta función permite modificar un producto del almacen. Si el producto no existe
    * en el almacén la función devuelve -1.
    * Cabecera: public int modificarProducto(ImplStockProducto producto)
    * Entrada:
    *   -ImplStockProducto producto
    * Salida:
    *   -entero validez
    * Postcondiciones: La función devuelve un número entero asociado al nombre, 0 si no se han cometido
    * errores, modificando el producto del almacén o -1 si la id de producto no coincide con ninguno de los
    * productos del almacén.
    * */
    /**
     * Modifica un producto del almacen.
     * @param producto Objeto que nos indica la cantidad de stock que hay de dicho producto.
     * @return Asociado al nombre devuelve un entero. -1 en caso de no existir el producto.
     * 0 en caso de haber cometido errores modificando el producto
     */
    public int modificarProducto(ImplStockProducto producto){
        int validez = -1;

        System.out.println("modificarProducto en resguardo.");

        return validez;
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
     * Obtiene un tipo ImplStockProducto valido.
     * @param idProducto ID del producto.
     * @return asociado al nombre devuelve un tipo ImplStockProducto.
     */
    public ImplStockProducto leerYValidarNuevoProducto(int idProducto){
        ImplStockProducto producto = null;

        System.out.println("leerYValidarProducto en resguardo.");

        return producto;
    }

    /*
    * Interfaz
    * Nombre: insertarProducto
    * Comentario: Esta función permite insertar un producto en el almacen.
    * Cabecera: public void insertarProducto(ImplStockProducto producto)
    * Entrada:
    *   -ImplStockProducto producto
    * Postcondiciones: La función inserta un tipo ImplStockProducto en el fichero
    * del almacén.
    * */
    /**
     * Inserta un producto en el almacen.
     * @param producto Producto que se quiere insertar.
     * Postcondiciones: La función inserta un tipo ImplStockProducto en el fichero del almacen.
     */
    public void insertarProducto(ImplStockProducto producto){
        System.out.println("insertarProducto en resguardo.");
    }

    /*
    * Interfaz
    * Nombre: eliminarProducto
    * Comentario: Esta función permite eliminar un producto del almacén.
    * Cabecera: public int eliminarProducto(int idProducto)
    * Entrada:
    *   -entero idProducto
    * Postcondiciones: La función devuelve un número entero asociado al nombre, 0 si se
    * ha conseguido eliminar el producto o -1 si no se ha encontrado el producto en el almacén.
    * */
    /**
     * Elimina un producto del almacen
     * @param idProducto ID del producto que se quiere eliminar.
     * @return Asociado al nombre se devuelve un entero. 0 si se ha eliminado y -1 en caso contrario.
     */
    public int eliminarProducto(int idProducto){
        int validez = -1;

        System.out.println("eliminarProducto en resguardo.");

        return validez;
    }

    /*
    * Interfaz
    * Nombre: modificarMenu
    * Comentario: Esta función permite modificar un menú de comida, si en el fichero
    * de menús no se encuentra un menú con el mismo id que la modificación la función
    * devuelve -1 y no se realiza ninguna modificación.
    * Cabecera: public int modificarMenu(ImplMenu menu)
    * Entrada:
    *   -ImplMenu menu
    * Salida:
    *   -entero validez
    * Postcondiciones: La función devuelve un número entero asociado al nombre, 0 si no se han
    * cometido errores, modificando el menú o -1 si la id de menu no coincide con ninguna id de los
    * menús almacenados en el fichero de menús.
    * */
    /**
     * Modifica un menu de comida.
     * @param menu Tipo ImplMenu. Es el menu que queremos modificar.
     * @return Asociado al nombre devuelve un entero.
     * 0 si no se han cometido errores.
     * -1 si el ID del menu no coincide con ningun ID registrado.
     */
    public int modificarMenu(ImplMenu menu){
        int validez = -1;

        System.out.println("modificarMenu en resguardo.");

        return validez;
    }

    /*
    * Interfaz
    * Nombre: canjearMenu
    * Comentario: Esta función permite decrementar en una unidad, los productos de un menú
    * en el almacén.
    * Cabecera: public void canjearMenu(int idMenu)
    * Entrada:
    *   -entero idMenu
    * Precondiciones:
    *   -Los productos del menú deben tener un stock superior de 0.
    * Postcondiciones: La función decrementa en una unidad los productos del almacén que aparecen
    * en el menú.
    * */
    /**
     * Permite decrementar en una unidad los productos que componen un menu.
     * @param idMenu ID del menu al que queremos aplicar el decremento de sus productos. El prooducto debe tener un stock superior a 0.
     * Postcondiciones: decrementa en una unidad los productos que componen el menu.
     */
    public void canjearMenu(int idMenu){
        System.out.println("canjearMenu en resguardo.");
    }

    /*
    * Interfaz
    * Nombre: leerYValidarMenu
    * Comentario: La función permite obetener un menú válido para el programa
    * BuguerDonald.
    * Cabecera: public ImplMenu leerYValidarMenu()
    * Salida:
    *   -ImplMenu menu
    * Precondiciones:
    *   -El almacén(fichero) de productos no debe estar vacío.
    * Postcondiciones: La función devuelve un tipo ImplMenu asociado al nombre,
    * que es un menú válido para la aplicación.
    * */
    /**
     * Obtiene un menu valido
     * @return Asociado al nombre devuelve un tipo ImplMenu.
     */
    public ImplMenu leerYValidarMenu(){
        ImplMenu menu = null;

        System.out.println("leerYValidarMenu en resguardo.");

        return menu;
    }

    /*
    * Interfaz
    * Nombre: insertarMenu
    * Comentario: Esta función permite insertar un menú en el archivo de menús.
    * Cabecera: public void insertarMenu(ImplMenu menu)
    * Entrada:
    *   -ImplMenu menu
    * Postcondiciones: La función inserta un menú en el archivo de menús de la
    * aplicación BurguerDonald.
    * */
    /**
     * Inserta un menu en el archivo de menus.
     * @param menu Tipo ImplMenu, es el menu que queremos insertar en el fichero de menus.
     * Postcondiciones: La función inserta un menú en el archivo de menús de la aplicacion BurguerDonald
     */
    public void insertarMenu(ImplMenu menu){
        System.out.println("insertarMenu en resguardo.");
    }

    /*
    * Interfaz
    * Nombre: eliminarMenu
    * Comentario: Esta función permite eliminar un menú del archivo de menús del
    * programa BurguerDonald. Si no se encuentra el menú en el archivo, la función
    * devuelve -1 y no elimina nada.
    * Cabecera: public int eliminarMenu(int idMenu)
    * Entrada:
    *   -entero idMenu
    * Salida:
    *   -entero validez
    * Postcondiciones: La función devuelve un número entero asociado al nombre, 0 si se
    * ha conseguido eliminar el menú o -1 si no se ha encontrado el menú en el archivo
    * de menús.
    * */
    /**
     * Elimina un menu del archivo de menus.
     * @param idMenu El ID del menus que queremos eliminar.
     * @return asociado al nombre devuelve un entero. 0 si se ha conseguido eliminar o -1 si no se ha podido.
     */
    public int eliminarMenu(int idMenu){
        int validez = -1;

        System.out.println("eliminarMenu en resguardo.");

        return validez;
    }

    /*
    * Interfaz
    * Nombre: mostrarProductosTipo
    * Comentario: Esta función permite mostrar por pantalla todos los productos que sean
    * de un mismo tipo introducido por parámetros.
    * Cabecera: public void mostrarProductosTipo(EnumTipo tipoProducto)
    * Entrada:
    *   -EnumTipo tipoProducto
    * Postcondiciones: La función muestra por pantalla todos los productos del almacén que
    * sean del mismo tipo.
    * */
    /**
     * Muestra por pantalla todos los productos que sean del mismo tipo introducido por parametro.
     * @param tipoProducto EnumTipo para los productos que hay que mostrar.
     * Postcondiciones: muestra por pantalla todos los productos del almacén que sean del mismo tipo.
     */
    public void mostrarProductosTipo(EnumTipo tipoProducto){
        System.out.println("mostrarProductosTipo en resguardo.");
    }
}
