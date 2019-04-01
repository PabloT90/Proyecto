/*
 * Tipo: ImplProducto
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
 * Funciones añadidas:
 * public int hashCode()
 * public boolean equals(Object obj)
 * public ImplProducto clone()
 * public String toString()
 * public int compareTo(ImplProducto otro)
 * */

package Clases;

import Enums.EnumTipo;
import Interfaces.Producto;

public class ImplProducto implements Producto, Cloneable, Comparable<ImplProducto> {
    private int id;
    private EnumTipo tipo;
    private double precio;
    private String descripcion;
    private boolean vegano;

    //Constructor por defecto
    public ImplProducto(){
        id = 0;
        tipo = EnumTipo.COMPLEMENTO;
        precio = 0.0;
        descripcion = "DEFAULT";
        vegano = false;
    }

    //Constructor con parámetros
    public ImplProducto(int id, EnumTipo tipo, double precio, String descripcion, boolean vegano){
        this.id = id;
        this.tipo = tipo;
        this.precio = precio;
        this.descripcion = descripcion;
        this.vegano = vegano;
    }

    //Constructor de copia
    public ImplProducto(ImplProducto otro){
        id = otro.getId();
        tipo = otro.getTipo();
        precio = otro.getPrecio();
        descripcion = otro.getDescripcion();
        vegano = otro.getVegano();
    }

    //Get Y Set
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public EnumTipo getTipo(){
        return tipo;
    }
    public void setTipo(EnumTipo tipo){
        this.tipo = tipo;
    }

    public double getPrecio(){
        return precio;
    }
    public void setPrecio(double precio){
        this.precio = precio;
    }

    public String getDescripcion(){
        return descripcion;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public boolean getVegano(){
        return vegano;
    }
    public void setVegano(boolean vegano){
        this.vegano = vegano;
    }

    //Funciones sobreescritas
    //hashCode
    @Override
    public int hashCode(){
        return getId(); //El id debe ser único para cada producto
    }

    /** Criterio de igualdad: por id
     * @param obj de tipo Object.
     * @return True en caso que los ID sean igual, False en caso contrario.
     */
    @Override
    public boolean equals(Object obj){
        boolean ret = false;

        if(this == obj){
            ret = true;
        }else{
            if(obj != null && obj instanceof ImplProducto){
                ImplProducto otro = (ImplProducto) obj;
                if(this.getId() == otro.getId()){
                    ret = true;
                }
            }
        }

        return ret;
    }
    //clone
    @Override
    public ImplProducto clone(){
        ImplProducto copia = null;

        try{
            copia = (ImplProducto) super.clone();
        }catch (CloneNotSupportedException error){
            error.printStackTrace();
        }

        return copia;
    }
    //toString
    public String toString() {
        return getId() + "," + getTipo() + "," + getPrecio() + "," + getDescripcion() + "," + getVegano();
    }

    /**
     * Criterio de comparacion: segun el id
     * @param otro de tipo ImplProducto para compararlo.
     * @return 1 --> Si el tipo ImplProducto es mayor que el otro introducido por parámetros.
     *         0 --> Si el tipo ImplProducto es igual que el otro introducido por parámetros.
     *        -1 --> Si el tipo ImplProducto es menor que el otro introducido por parámetros.
     */
    public int compareTo(ImplProducto otro){
        int ret = -1;

        if(this.getId() > otro.getId()){
            ret = 1;
        }else{
            if(this.getId() == otro.getId()){
                ret = 0;
            }
        }

        return ret;
    }
}
