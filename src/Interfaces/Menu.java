/*
* Tipo: Menu
*
* Propiedades Básicas:
*   -Id entero, consultable y modificable.
*   -Descripcion Cadena, consultable y modificable.
*   -Productos ImplProducto[], consultable y modificable.
* Propiedades Derivadas:
*   -PrecioMenu real, consultable y modificable.
* Propiedades Compartidas: Nada.
*
* Requisitos:
*   -id debe ser igual o mayor que 0.
*   -productos no debe contener ningún elemento nulo.
*
* Interfaz
* public int getId()
* public void setId(int id)
*
* public String getDescripcion()
* public void setDescripcion(String descripcion)
*
* public double getPrecioMenu()
* */

package Interfaces;

public interface Menu {
    public int getId();
    public void setId(int id);

    public String getNombre();
    public void setNombre(String nombre);

    public String getDescripcion();
    public void setDescripcion(String descripcion);

    public double getPrecioMenu();
}
