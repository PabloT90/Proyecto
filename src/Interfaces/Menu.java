/*
* Tipo: Menu
*
* Propiedades Básicas:
*   -Id entero, consultable y modificable.
*   -nombre Cadena, consultable y modificable.
*   -Descripcion Cadena, consultable y modificable.
*   -Productos int[], consultable y modificable.
*   -Precio double, consultable y modificable.
* Propiedades Derivadas: nada.
* Propiedades Compartidas: Nada.
*
* Requisitos:
*   -id debe ser igual o mayor que 0.
*   -productos no debe contener ningún elemento nulo.
*   -precio debe ser superior a 0.
*
* Interfaz
* public int getId()
* public void setId(int id)
*
* public String getNombre()
* public void setNombre(String nombre)
*
* public String getDescripcion()
* public void setDescripcion(String descripcion)
*
* public double getPrecio()
* public void setPrecio(double precio)
* */

package Interfaces;

public interface Menu {
    public int getId();
    public void setId(int id);

    public String getNombre();
    public void setNombre(String nombre);

    public String getDescripcion();
    public void setDescripcion(String descripcion);

    public double getPrecio();
    public void setPrecio(double precio);
}
