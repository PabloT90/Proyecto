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
*
* Todos los menús anteriores son iterativos, es decir, solo finalizan cuando el usuario así lo desea.
*
* Entrada:
*   -Un número entero para opcionMenu.
*   -Un número entero para opcionSubMenu1.
*   -Un número entero para opcionSubMenu2.
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
*   -opcionSubMenu1 debe ser un número entre 0 y 5.
*   -opcionSubMenu2 debe ser un número entre 0 y 3.
*   -id debe ser mayor o igual que 0.
*   -modificadorStock debe ser mayor que 0.
*   -tipoProducto debe ser igual a "BEBIDA", "POSTRE", "SANDWICH", "COMPLEMENTO", "ENSALADA" o "DESAYUNO".
*
* PG Nivel: 0
* Inicio
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
* AccionesMenu
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
*           Fin_si
*       Fin_si
*   Mientras opcionSubMenu1 != 0
* Fin
*
* AccionesProductos
* Inicio
*   Repetir
*       leerYValidarOpcionSubMenu2*
*       Si opcionSubMenu1 != 0
*           Segun (opcionSubMenu1)
*               para opcionSubMenu1 == 1
*                   mostrarMenus*
*               para opcionSubMenu1 == 2
*                   ModificacionMenu
*               para opcionSubMenu1 == 3
*                   CanjeoMenu
*               para opcionSubMenu1 == 4
*                   InsercionMenu
*               para opcionSubMenu1 == 5
*                   EliminacionMenu
*           Fin_segun
*       Fin_si
*   Mientras opcionSubMenu1 != 0
* Fin
*
* PG Nivel: 2
* Consultas
* Inicio
*   Repetir
*       leerYValidarSubMenu3*
*       Si opcionSubMenu2 != 0
*           Segun (opcionSubMenu2)
*               para opcionSubMenu2 == 1
*                   mostrarProductosAlmacen*
*               para opcionSubMenu2 == 2
*                   MostrarProductosPorTipo
*               para opcionSubMenu2 == 3
*                   mostrarProductosVeganos*
*           Fin_segun
*       Fin_si
*   Mientras opcionSubMenu2 != 0
* Fin
*
* ModificacionProducto
* Inicio
*   leerYValidarId*
*   Si el producto existe
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
*       Si opcionMenu != 0
*           Segun (opcionMenu)
*               para opcionMenu == 1
*                   IncrementoStock
*               para opcionMenu == 2
*                   DecrementoStock
*           Fin_segun
*       Fin_si
*   Mientras opcionMenu != 0
* Fin
*
* InsercionProducto
* Inicio
*   leerYValidarProducto*
*   insertarProducto*
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
*   leerYValidarMenu*
*   insertarMenu*
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
* */

package Main;

public class BurguerDonaldStore {

}