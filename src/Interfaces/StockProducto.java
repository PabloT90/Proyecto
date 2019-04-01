/*
* Tipo: StockProducto
*
* Propiedades Básicas:
*   -Producto ImplProducto, consultable y modificable.
*   -Stock entero, consultable y modificable.
* Propiedades Derivadas: Nada.
* Propiedades Compartidas: Nada.
*
* Requisitos:
*   -stock debe ser igual o mayor que 0.
*
* Interfaz
* public int getStock()
* public void setStock(int stock)
* */

package Interfaces;

public interface StockProducto {
    public int getStock();
    public void setStock(int stock);
}
