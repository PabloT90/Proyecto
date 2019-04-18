/*
 * Nombre: BurguerDonaldStore
 *
 * Descripción: Este programa permite gestionar el stock de productos de la cadena de comida rápida BuguerDonald.
 * Podremos insertar, modificar y/o eliminar productos o menús. También podremos modificar el stock de los diferentes
 * productos. Al comenzar la aplicación se muestra el siguiente menú por pantalla:
 *
 * 0 --> Finalizar el programa.
 * 1 --> Acciones sobre menús.
 * 2 --> Acciones sobre productos.
 *
 * Si se elige la opción 1, se muestra el siguiente menú:
 *
 * 0 --> Volver al menú anterior.
 * 1 --> Consultas.
 * 2 --> Modificar producto.
 * 3 --> Modificar stock.
 * 4 --> Insertar producto con stock.
 * 5 --> Eliminar producto.
 * 6 --> Sincronizar almacén de productos.
 *
 *       Si se elige la opción de "Consultas", se muestra el siguiente submenú:
 *
 *       0 --> Volver al menú anterior.
 *       1 --> Mostrar todos los productos del almacen.
 *       2 --> Mostrar un tipo de producto.
 *       3 --> Mostrar productos veganos.
 *
 *       Si se elige la opción "Modificar stock", se muestra el siguiente submenú:
 *       0 --> Volver al menú anterior.
 *       1 --> Incrementar stock.
 *       2 --> decrementar stock.
 *
 * Si se elige la opción 2, se muestra el siguiente menú:
 *
 * 0 --> Volver al menú anterior.
 * 1 --> Mostrar los menús por pantalla.
 * 2 --> Modificar menú.
 * 3 --> Canjear un menú. //Al canjear un menú se modificará el stock de los productos que tenga el menú.
 * 4 --> Insertar menú.
 * 5 --> Eliminar menú.
 * 6 --> Ordenar lista de menús.
 *
 * Todos los menús anteriores son iterativos, es decir, solo finalizan cuando el usuario así lo desea.
 *
 * Entrada:
 *   -Un número entero para opcionMenu.
 *   -Un número entero para opcionSubMenu1.
 *   -Un número entero para opcionSubMenu2.
 *   -Un número entero para opcionSubMenu3
 *   -Un número entero para opcionSubMenu4
 *   -Un número entero para id.//Para produto o menú.
 *   -Un tipo ImplMenu para menu.
 *   -Un tipo ImplProducto para producto.
 *   -Un número entero para modificadorStock.//Variable para incrementar o decrementar el stock de un producto.
 *   -Una cadena para tipoProducto.
 *
 * Salida:
 *   -Mensajes de comunicación con el usuario.
 *   -Se muestran los menús por pantalla.
 *   -Se muestran los productos por pantalla.
 *
 * Restricciones:
 *   -opcionMenu debe ser un número entre 0 y 2.
 *   -opcionSubMenu1 debe ser un número entre 0 y 6.
 *   -opcionSubMenu2 debe ser un número entre 0 y 6.
 *   -opcionSubMenu3 debe ser un número entre 0 y 3.
 *   -opcionSubMenu4 debe ser un número entre 0 y 2.
 *   -id debe ser mayor o igual que 0.
 *   -modificadorStock debe ser mayor que 0.
 *   -tipoProducto debe ser igual a "BEBIDA", "POSTRE", "SANDWICH", "COMPLEMENTO", "ENSALADA" o "DESAYUNO".
 *
 * PG Nivel: 0
 * Inicio
 *   comprobacionFicheros*
 *   ajustesEncabezamiento*
 *   configuracionInicial*
 *   Repetir
 *       leerYValidarOpcionMenu*
 *       Si opcionMenu != 0
 *           Segun (opcionMenu)
 *               para opcionMenu == 1
 *                   AccionesMenu
 *               para opcionMenu == 2
 *                   AccionesProductos
 *           Fin_segun
 *       Fin_si
 *   Mientras opcionMenu != 0
 * Fin

 * PG Nivel: 1
 * AccionesProductos
 * Inicio
 *   Repetir
 *       leerYValidarOpcionSubMenu1*
 *       Si opcionSubMenu1 != 0
 *           Segun (opcionSubMenu1)
 *               para opcionSubMenu1 == 1
 *                   Consultas
 *               para opcionSubMenu1 == 2
 *                   ModificacionProducto
 *               para opcionSubMenu1 == 3
 *                   ModificacionStock
 *               para opcionSubMenu1 == 4
 *                   InsercionProducto
 *               para opcionSubMenu1 == 5
 *                   EliminacionProducto
 *               para opcionSubMenu1 == 6
 *                   OrdenarListaProducto
 *           Fin_segun
 *       Fin_si
 *   Mientras opcionSubMenu1 != 0
 * Fin
 *
 * AccionesMenus
 * Inicio
 *   Repetir
 *       leerYValidarOpcionSubMenu2*
 *       Si opcionSubMenu2 != 0
 *           Segun (opcionSubMenu2)
 *               para opcionSubMenu2 == 1
 *                   mostrarMenus*
 *               para opcionSubMenu2 == 2
 *                   ModificacionMenu
 *               para opcionSubMenu2 == 3
 *                   CanjeoMenu
 *               para opcionSubMenu2 == 4
 *                   InsercionMenu
 *               para opcionSubMenu2 == 5
 *                   EliminacionMenu
 *               para opcionSubMenu2 == 6
 *                   OrdenarListaMenu
 *           Fin_segun
 *       Fin_si
 *   Mientras opcionSubMenu2 != 0
 * Fin
 *
 * PG Nivel: 2
 * Consultas
 * Inicio
 *   Repetir
 *       leerYValidarSubMenu3*
 *       Si opcionSubMenu3 != 0
 *           Segun (opcionSubMenu3)
 *               para opcionSubMenu3 == 1
 *                   mostrarProductosAlmacen*
 *               para opcionSubMenu3 == 2
 *                   MostrarProductosPorTipo
 *               para opcionSubMenu3 == 3
 *                   mostrarProductosVeganos*
 *           Fin_segun
 *       Fin_si
 *   Mientras opcionSubMenu3 != 0
 * Fin
 *
 * ModificacionProducto
 * Inicio
 *   leerYValidarId*
 *   Si el producto existe
 *       LeerValidarProducto*
 *       modificarProducto*
 *   Sino
 *       MensajeExplicatorio1
 *   Fin_si
 * Fin
 *
 * ModificacionStock
 * Inicio
 *   Repetir
 *       leerYValidarOpcionSubMenu4*
 *       Si opcionMenu4 != 0
 *           Segun (opcionMenu4)
 *               para opcionMenu4 == 1
 *                   IncrementoStock
 *               para opcionMenu4 == 2
 *                   DecrementoStock
 *           Fin_segun
 *       Fin_si
 *   Mientras opcionMenu4 != 0
 * Fin
 *
 * InsercionProducto
 * Inicio
 *   leerYValidarId*
 *   Si el producto no existe
 *       LeerValidarProducto*
 *       insertarProducto*
 *   Sino
 *       MensajeExplicatorio1
 *   Fin_si
 * Fin
 *
 * EliminacionProducto
 * Inicio
 *   leerYValdarId*
 *   Si existe el producto
 *       eliminarProducto*
 *   Sino
 *       MensajeExplicatorio
 *   Fin_si
 * Fin
 *
 * ModificacionMenu
 * Inicio
 *   leerYValidarId*
 *   Si el menú existe
 *       leerYValidarMenu* //El ID se recibe como parametro
 *       modificarMenu*
 *   Sino
 *       MensajeExplicatorio3
 *   Fin_si
 * Fin
 *
 * CanjeoMenu
 * Inicio
 *   leerYValidarId*
 *   Si el menú existe
 *       Si el menú contiene algún producto sin stock
 *           MensajeExplicatorio4
 *       Sino
 *           canjearMenu*
 *       Fin_si
 *   Sino
 *       MensajeExplicatorio3
 *   Fin_si
 * Fin
 *
 * InsercionMenu
 * Inicio
 *   Si almacen de productos no esta vacio //Si no hay productos
 *       leerYValidarMenu*
 *       insertarMenu*
 *   Sino
 *       MensajeExplicatorio5
 *   Fin_si
 * Fin
 *
 * EliminacionMenu
 * Inicio
 *   leerYValidarId*
 *   Si el menú existe
 *       eliminarMenu*
 *   Sino
 *       MensajeExplicatorio3
 *   Fin_si
 * Fin
 *
 * PG Nivel: 3
 * MostrarProductosPorTipo
 * Inicio
 *   leerYValidarTipoProducto*
 *   mostrarProductosTipo*
 * Fin
 *
 * IncrementarStock
 * Inicio
 *   leerYValidarId*
 *   leerYValidarStock*
 *   incrementarStock*
 * Fin
 *
 * DecrementarStock
 * Inicio
 *   leerYValidarId*
 *   leerYValidarStock*
 *   decrementarStock*
 * Fin
 * */

package Main;

import Clases.*;
import Enums.EnumTipo;

public class BurguerDonaldStore {
    public static void main(String[]args){
        ValidacionesBurguerDonald validacion = new ValidacionesBurguerDonald();
        FuncionesProductos fp = new FuncionesProductos();
        ImplStockProducto producto;
        ImplMenu menu;
        FuncionesMenus fm = new FuncionesMenus();
        EnumTipo tipo;
        int opcionMenu, opcionSubMenu1, opcionSubMenu2, opcionSubMenu3, opcionSubMenu4;
        int id;
        int stock;
        FuncionesDeConfiguracion fc = new FuncionesDeConfiguracion();

        fc.comprobacionFicheros();
        fc.ajustesEncabezamiento();
        fc.configuracionInicial();

        do{
            //leerYValidarOpcionMenu *
            opcionMenu = validacion.leerYValidarOpcionMenu();
            //Si opcionMenu != 0
            if(opcionMenu != 0) {
                switch(opcionMenu) {//Segun(opcionMenu)
                    case 1://para opcionMenu ==1
                    //AccionesProductos
                        do { //Repetir
                            //leerYValidarOpcionSubMenu1 *
                            opcionSubMenu1 = validacion.leerYValidarOpcionSubMenu1();
                            if(opcionSubMenu1 != 0) {//Si opcionSubMenu1 != 0
                                switch(opcionSubMenu1) {//Segun(opcionSubMenu1)
                                    case 1://para opcionSubMenu1 ==1
                                        // Consultas
                                        do { //Repetir
                                            //leerYValidarSubMenu3 *
                                            opcionSubMenu3 = validacion.leerYValidarOpcionSubMenu3();
                                            if(opcionSubMenu3 != 0) {//Si opcionSubMenu3 != 0
                                                switch(opcionSubMenu3) {//Segun(opcionSubMenu3)
                                                    case 1: //para opcionSubMenu3 ==1
                                                        // mostrarProductosAlmacen *
                                                        //resguardo.mostrarProductosAlmacen();
                                                        fp.mostrarProductosAlmacen();
                                                    break;
                                                    case 2: //para opcionSubMenu3 == 2
                                                        // MostrarProductosPorTipo
                                                        //leerYValidarTipoProducto*
                                                        tipo =  validacion.leerYValidarTipoProducto();
                                                        //mostrarProductosTipo*
                                                        //resguardo.mostrarProductosPorTipo(tipo);
                                                        fp.mostrarProductosPorTipo(tipo);
                                                    break;
                                                    case 3: //para opcionSubMenu3 ==3
                                                        //mostrarProductosVeganos *
                                                        //resguardo.mostrarProductosVeganos();
                                                        fp.mostrarProductosVeganos();
                                                    break;
                                                }
                                            }
                                        }while(opcionSubMenu3 != 0); //Mientras opcionSubMenu3 != 0
                                    break;
                                    case 2://para opcionSubMenu1 ==2
                                        //ModificacionProducto
                                        //leerYValidarId*
                                        id = validacion.leerYValidarId();

                                        if(fp.obtenerProductoAlmacen(id) != null) {//Si el producto existe
                                            //LeerValidarProducto*
                                            producto = validacion.leerYValidarProductoModificado(id);

                                            //modificarProducto* (es una insercion)
                                            //resguardo.insertarProducto(producto);
                                            fp.insertarProducto(producto);
                                        }else {
                                            //MensajeExplicatorio1
                                            System.out.println("No ha sido posible modificar el producto.");
                                        }
                                        break;

                                        case 3://para opcionSubMenu1 ==3
                                            //ModificacionStock
                                            do {//Repetir
                                                //leerYValidarOpcionSubMenu4*
                                                opcionSubMenu4 = validacion.leerYValidarOpcionSubMenu4();
                                                if(opcionSubMenu4 != 0) {//Si opcionMenu4 != 0
                                                    switch(opcionSubMenu4) {//Segun (opcionMenu4)
                                                        case 1://para opcionMenu4 == 1
                                                            //IncrementoStock
                                                            //LeerYValidarID*
                                                            id = validacion.leerYValidarId();
                                                            //LeerValidarStock*
                                                            stock = validacion.leerYValidarStock();
                                                            //incrementarStock*
                                                            fp.incrementarStock(id,stock);
                                                        break;
                                                        case 2://para opcionMenu4 == 2
                                                            //DecrementoStock
                                                            //LeerYValidarID*
                                                            id = validacion.leerYValidarId();
                                                            //LeerValidarStock*
                                                            stock = validacion.leerYValidarStock();
                                                            //decrementarStock*
                                                            fp.decrementarStock(id,stock);
                                                        break;
                                                    }
                                                }
                                            }while(opcionSubMenu4 != 0);//Mientras opcionMenu4 != 0
                                        break;
                                        case 4://para opcionSubMenu1 ==4
                                            //InsercionProducto
                                            //leerYValidarId*
                                            id = validacion.leerYValidarId();

                                            if(fp.obtenerProductoAlmacen(id) == null) {//Si el producto no existe
                                                //LeerValidarProducto*
                                                producto = validacion.leerYValidarNuevoProducto(id);
                                                
                                                //insertarProducto*
                                                //resguardo.insertarProducto(producto);
                                                fp.insertarProducto(producto);
                                            }else{
                                                //MensajeExplicatorio1
                                                System.out.println("No se ha podido insertar.");
                                            }
                                        break;
                                        case 5://para opcionSubMenu1 ==5
                                            //EliminacionProducto
                                            //leerYValdarId*
                                            id = validacion.leerYValidarId();

                                            if(fp.obtenerProductoAlmacen(id) != null) {//Si existe el producto
                                                //eliminarProducto*
                                                //resguardo.eliminarProducto(id);
                                                fp.eliminarProducto(id);
                                            }else{//Sino
                                                //MensajeExplicatorio
                                                System.out.println("No ha sido posible eliminar el producto");
                                            }
                                        break;
                                        case 6://para opcionSubMenu1 ==6
                                            //SincronizarListaProducto
                                            //resguardo.sincronizarAlmacen();
                                            fp.sincronizarAlmacen();
                                        break;
                                    }
                                }
                            }while(opcionSubMenu1 != 0);//Mientras opcionSubMenu1 != 0
                        break;
                    case 2://para opcionMenu ==2
                    //AccionesMenus
                        do { //Repetir
                            //leerYValidarOpcionSubMenu2 *
                            opcionSubMenu2 = validacion.leerYValidarOpcionSubMenu2();
                            if(opcionSubMenu2 !=0) {//Si opcionSubMenu2 != 0
                                switch(opcionSubMenu2) {//Segun(opcionSubMenu2)
                                    case 1://para opcionSubMenu2 ==1
                                        //mostrarMenus*
                                        //resguardoMenus.mostrarListaMenus();
                                        fm.mostrarListaMenus();
                                    break;
                                    case 2: //para opcionSubMenu2 == 2
                                        //ModificacionMenu
                                        //leerYValidarId*
                                        id = validacion.leerYValidarId();
                                        if(fm.obtenerMenu(id) != null) {//Si el menú existe
                                            //leerYValidarMenu* //El ID se recibe como parametro
                                            menu = validacion.leerYValidarNuevoMenu(id);
                                            //modificarMenu*
                                            //resguardoMenus.insertarMenu(menu);
                                            fm.insertarMenu(menu);
                                        }else{
                                            //MensajeExplicatorio3
                                            System.out.println("No ha sido posible modificar el menu.");
                                        }
                                    break;
                                    case 3://para opcionSubMenu2 ==3
                                        //CanjeoMenu
                                        //leerYValidarId*
                                        id = validacion.leerYValidarId();
                                        //Si el menú existe
                                        //menu = resguardoMenus.obtenerMenu(id);
                                        menu = fm.obtenerMenu(id);
                                        if(menu != null) {
                                            if (fm.productoSinStock(id)) {//Si el menú contiene algún producto sin stock
                                                //MensajeExplicatorio4
                                                System.out.println("Alguno de los productos del menu no tenia stock.");
                                            } else {
                                                //canjearMenu*
                                                //resguardoMenus.canjeoMenu(menu);
                                                fm.canjeoMenu(menu);
                                            }
                                        }else{
                                            //MensajeExplicatorio3
                                            System.out.println("El menu no existe.");
                                        }
                                    break;
                                    case 4://para opcionSubMenu2 ==4
                                        //InsercionMenu
                                        //leerYValidarId*
                                        id = validacion.leerYValidarId();

                                        if(fm.obtenerMenu(id) == null) {//Si el menu no existe
                                            //LeerValidarMenu*
                                            menu = validacion.leerYValidarNuevoMenu(id);

                                            //insertarMenu*
                                            //resguardo.insertarMenu(menu);
                                            fm.insertarMenu(menu);
                                        }else{
                                            //MensajeExplicatorio1
                                            System.out.println("No se ha podido insertar el menu.");
                                        }
                                    break;
                                    case 5://para opcionSubMenu2 ==5
                                        //EliminacionMenu
                                        //leerYValidarId*
                                        id = validacion.leerYValidarId();
                                        if(fm.obtenerMenu(id) != null) {//Si el menú existe
                                            //eliminarMenu*
                                            //resguardoMenus.eliminarMenu(id);
                                            fm.eliminarMenu(id);
                                        }else {//Sino
                                            //MensajeExplicatorio3
                                            System.out.println("No se ha podido eliminar el menu");
                                        }//Fin_si
                                    break;
                                    case 6://para opcionSubMenu2 ==6
                                        //OrdenarListaMenu
                                        //resguardoMenus.sincronizarListaMenus();
                                        fm.sincronizarListaMenus();
                                    break;
                                }
                            }
                        }while(opcionSubMenu2 != 0); //Mientras opcionSubMenu2 != 0
                    break;
                }
            }
        }while(opcionMenu != 0); //Mientras opcionMenu != 0
    }
}