/*
 * Tipo: ImplMenu
 *
 * Propiedades Básicas:
 *   -Id entero, consultable y modificable.
 *   -Nombre Cadena, consultable y modificable.
 *   -Descripcion Cadena, consultable y modificable.
 *   -Precio real, consultable y modificable.
 *   -Productos int[], consultable y modificable.
 * Propiedades Derivadas: nada.
 * Propiedades Compartidas: Nada.
 *
 * Requisitos:
 *   -id debe ser igual o mayor que 0.
 *   -productos no debe contener ningún elemento nulo.
 *   -precio debe ser mayor a 0.
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
 *
 * Funciones añadidas:
 * public int[] getProductos()
 * public void setProductos(int[] productos)
 *
 * public int hashCode()
 * public boolean equals(Object obj)
 * public ImplMenu clone()
 * public String toString()
 * public int compareTo(ImplMenu otro)
 * public String toStringBonito()
 * */

package Clases;

import Interfaces.Menu;
import java.io.Serializable;
import java.util.Arrays;

public class ImplMenu implements Menu, Cloneable, Comparable<ImplMenu>, Serializable {
    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int[] productos;

    //Constructor por defecto

    /**
     * Instancia un nuevo objeto ImplMenu
     */
    public ImplMenu(){
        ImplProducto producto = new ImplProducto();
        id = 0;
        descripcion = "DEFAULT";
        precio = 0.1;
        nombre = "DEFAULT";
        productos = null;
    }

    //Constructor con parámetros

    /**
     * Instancia un nuevo objeto ImplMenu.
     * @param id ID del menu.
     * @param nombre Nombre del menu.
     * @param descripcion Breve descripcion del menu.
     * @param productos Productos que componen el menu.
     * @param precio Precio que queremos poner.
     */
    public ImplMenu(int id,String nombre, String descripcion, int[] productos, double precio){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.productos = productos;
        this.precio = precio;
    }

    //Constructor de copia

    /**
     * Instancia un nuevo objeto ImplMenu
     * @param otro el objeto a copiar.
     */
    public ImplMenu(ImplMenu otro){
        id = otro.getId();  //La copia tendrá el mismo id
        nombre = otro.getNombre();
        descripcion = otro.getDescripcion();
        productos = otro.getProductos();
        precio = otro.getPrecio();
    }

    //Get Y Set
    /** Obtiene el ID del Menu
     * @return Devuelve asociado al nombre el ID del menu
     */
    public int getId(){
        return id;
    }

    /**
     * Establece el ID al menu
     * @param id El ID para el menu
     */
    public void setId(int id){
        this.id = id;
    }

    /**
     * Obtiene el nombre del menu
     * @return Asociado al nombre devuelve el nombre del menu.
     */
    public String getNombre(){
        return nombre;
    }
    /**
     * Establece el nombre al menu
     * @param nombre Nombre que se le asigna al menu
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    /**
     * Obtiene la descripcion del menu
     * @return Asociado al nombre devuelve la descripcion.
     */
    public String getDescripcion(){
        return descripcion;
    }
    /**
     * Establece la descripcion para el menu
     * @param descripcion Descripcion que se le asigna al menu
     */
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el precio del menu
     * @return asociado al nombre devuelve el precio del menu.
     */
    public double getPrecio(){
        return precio;
    }

    /**
     * Establece el precio del menu.
     * @param precio Precio que queremos poner.
     */
    public void setPrecio(double precio){
        this.precio = precio;
    }

    //Funciones añadidas

    /**
     * Obtiene los productos del menu
     * @return asociado al nombre manda un array con los productos que contiene el menu
     */
    public int[] getProductos(){
        return productos;
    }
    /**
     *  Establece los productos que contiene el menu
     * @param productos Array de productos para el menu
     */
    public void setProductos(int[] productos){
        this.productos = productos;
    }

    //hashCode

    /**
     * @see java.lang.Object#hashCode()
     */
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
    /**
     * @see java.lang.Object#toString()
	 */
    @Override
    public String toString(){
        return getId()+","+getNombre()+","+getDescripcion()+","+ Arrays.toString(getProductos()) +","+getPrecio();
    }

    //toStringBonito
    /**
     * Es un toString que muestra los datos de manera mas legible para el usuario.
     */
    public String toStringBonito(){
        return "ID: "+getId()+"  |Nombre: "+getNombre()+"  |Descripcion: "+getDescripcion()+"  |Productos: "+Arrays.toString(getProductos())+"  |Precio:"+getPrecio();
    }

    /**
     * Criterio de comparacion: segun el id.
     * @param otro un tipo ImplMenu para compararlo.
     * @return      1 -- Si el tipo ImplMenu es mayor que el otro introducido por parámetros.
     *              0 -- Si el tipo ImplMenu es igual que el otro introducido por parámetros.
     *             -1 -- Si el tipo ImplMenu es menor que el otro introducido por parámetros.
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