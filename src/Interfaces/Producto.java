/*
* Tipo: Producto
*
* Propiedades Básicas:
*   -Id entero, consultable y modificable.
*   -Tipo EnumTipo, consultable y modificable.
*   -Precio real, consultable y modificable.
*   -Descripcion Cadena, consultable y modificable.
*   -Vegano booleano, consultable y modificable.
*
* Propiedades Derivadas: Nada.
* Propiedades Compartidas: Nada.
*
* Requisitos:
*   -id debe ser mayor o igual que 0.
*   -tipo debe ser igual a "BEBIDA", "POSTRE", "SANDWICH", "COMPLEMENTO", "ENSALADA" o "DESAYUNO".
*   -precio debe ser mayor o igual que 0.
*
* Interfaz
* public int getId()
* public void setId(int id)
*
* public EnumTipo getTipo()
* public void setTipo(EnumTipo tipo)
*
* public double getPrecio()
* public void setPrecio(double precio)
*
* public String getDescripcion()
* public void setDescripcion(String descripcion)
*
* public boolean getVegano()
* public void setVegano(boolean vegano)
*
* */

package Interfaces;

import Enums.EnumTipo;

public interface Producto {
    public int getId();
    public void setId(int id);

    public EnumTipo getTipo();
    public void setTipo(EnumTipo tipo);

    public double getPrecio();
    public void setPrecio(double precio);

    public String getNombre();
    public void setNombre(String nombre);

    public String getDescripcion();
    public void setDescripcion(String descripcion);

    public boolean getVegano();
    public void setVegano(boolean vegano);
}
