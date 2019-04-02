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
*
*   Si se elige la opción de "Consultas", se muestra el siguiente submenú:
*
*   0 --> Volver al menú anterior.
*   1 --> Mostrar todos los productos del almacen.
*   2 --> Mostrar un tipo de producto.
*   3 --> Mostrar productos veganos.
*
*   Si se elige la opción "Modificar stock", se muestra el siguiente submenú:
*   0 --> Volver al menú anterior.
*   1 --> Incrementar stock.
*   2 --> decrementar stock.
*
* Si se elige la opción 2, se muestra el siguiente menú:
*
* 0 --> Volver al menú anterior.
* 1 --> Mostrar los menús por pantalla.
* 2 --> Modificar menú.
* 3 --> Canjear un menú. //Al canjear un menú se modificará el stock de los productos que tenga el menú.
*
* Todos los menús anteriores son iterativos, es decir, solo finalizan cuando el usuario así lo desea.
*
* Entrada:
*   -Un número entero para opcionMenu1.
*   -Un número entero para opcionMenu2.
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
*   -opcionMenu1 debe ser un número entre 0 y 2.
*   -opcionMenu2 debe ser un número entre 0 y 3.
*   -id debe ser mayor o igual que 0.
*   -modificadorStock debe ser mayor que 0.
*   -tipoProducto debe ser igual a "BEBIDA", "POSTRE", "SANDWICH", "COMPLEMENTO", "ENSALADA" o "DESAYUNO".
*
* PG Nivel: 0
* Inicio
*
*   Repetir
*
*       leerYValidarOpcionMenu1*
*
*       Si opcionMenu1 != 0
*
*           Segun (opcionMenu1)
*
*               para opcionMenu1 == 1
*                   AccionesMenu
*
*               para opcionMenu2 == 2
*                   AccionesProductos
*
*           Fin_segun
*
*       Fin_si
*
*   Mientras opcionMenu1 != 0
*
* Fin
*
* PG Nivel: 1
* AccionesMenu
* Inicio
*
*   Repetir
*
*       leerYValidarOpcionSubMenu1*
*
*       Si opcionMenu2 != 0
*
*           Segun (opcionMenu2)
*
*               para opcionMenu2 == 1
*
*               para opcionMenu2 == 2
*
*               para opcionMenu2 == 3
*
*           Fin_si
*
*       Fin_si
*
*   Mientras opcionMenu2 != 0
*
* Fin
* */

package Main;

public class BurguerDonaldStore {
}
