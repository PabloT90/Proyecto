/*
 * Tipo: ImplMenu
 *
 * Propiedades Básicas:
 *   -Id entero, consultable y modificable.
 *   -Nombre String, consultable y modificable.
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
 * public String getNombre()
 * public void setNombre(String nombre)
 *
 * public String getDescripcion()
 * public void setDescripcion(String descripcion)
 *
 * public double getPrecioMenu()
 *
 * Funciones añadidas:
 * public ImplProducto[] getProductos()
 * public void setProductos(ImplProducto[] productos)
 *
 * public int hashCode()
 * public boolean equals(Object obj)
 * public ImplMenu clone()
 * public String toString()
 * public int compareTo(ImplMenu otro)
 * */

package Clases;

import Interfaces.Menu;

public class ImplMenu implements Menu, Cloneable, Comparable<ImplMenu> {
    private int id;
    private String nombre;
    private String descripcion;
    private ImplProducto[] productos;

    //Constructor por defecto
    public ImplMenu(){
        ImplProducto producto = new ImplProducto();
        id = 0;
        descripcion = "DEFAULT";
        nombre = "DEFAULT";
        productos = new ImplProducto[1];
        productos[0] = producto;//productos no debe contener ningún valor nulo.
    }

    //Constructor con parámetros
    public ImplMenu(int id,String nombre, String descripcion, ImplProducto[] productos){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.productos = productos;
    }

    //Constructor de copia
    public ImplMenu(ImplMenu otro){
        id = otro.getId();  //La copia tendrá el mismo id
        nombre = otro.getNombre();
        descripcion = otro.getDescripcion();
        productos = otro.getProductos();
    }

    //Get Y Set
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getDescripcion(){
        return descripcion;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public double getPrecioMenu(){
        double precio = 0.0;
        //Sumamos el precio de todos los productos
        for(int i = 0; i < productos.length; i++){
            precio += productos[i].getPrecio();
        }
        return precio;
    }

    //Funciones añadidas
    public ImplProducto[] getProductos(){
        return productos;
    }
    public void setProductos(ImplProducto[] productos){
        this.productos = productos;
    }

    //hashCode
    @Override
    public int hashCode(){
        return getId(); //El id debe ser único para cada producto
    }

    /**
     * Criterio de igualdad: segun el id
     * @param obj de tipo Object.
     * @return boolean. True en caso que dos tipo ImplMenu tengan el mismo ID. False en caso contrario.
     */
    @Override
    public boolean equals(Object obj){
        boolean ret = false;

        if(this == obj){
            ret = true;
        }else{
            if(obj != null && obj instanceof ImplMenu){
                ImplMenu otro = (ImplMenu) obj;
                if(this.getId() == otro.getId()){
                    ret = true;
                }
            }
        }
        return ret;
    }

    //clone
    @Override
    public ImplMenu clone(){
        ImplMenu copia = null;

        try{
            copia = (ImplMenu) super.clone();
        }catch (CloneNotSupportedException error){
            error.printStackTrace();
        }

        return copia;
    }

    //toString
    @Override
    public String toString(){
        return getId()+","+getNombre()+","+getDescripcion()+","+getPrecioMenu();
    }

    /**
     * Criterio de comparacion: segun el id.
     * @param otro un tipo ImplMenu para compararlo.
     * @return      1 --> Si el tipo ImplMenu es mayor que el otro introducido por parámetros.
     *              0 --> Si el tipo ImplMenu es igual que el otro introducido por parámetros.
     *             -1 --> Si el tipo ImplMenu es menor que el otro introducido por parámetros.
     */
    public int compareTo(ImplMenu otro){
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