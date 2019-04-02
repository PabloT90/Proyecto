/*
 * Tipo: ImplProducto
 *
 * Propiedades Básicas:
 *   -Id entero, consultable y modificable.
 *   -Nombre Cadena, consultable y modificable.
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
 * public String getNombre()
 * public void setNombre()
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
    private String nombre;
    private String descripcion;
    private boolean vegano;

    //Constructor por defecto

    /**
     * Instancia un nuevo objeto ImplProducto
     */
    public ImplProducto(){
        id = 0;
        tipo = EnumTipo.COMPLEMENTO;
        precio = 0.0;
        nombre = "DEFAULT";
        descripcion = "DEFAULT";
        vegano = false;
    }

    //Constructor con parámetros

    /**
     * Instancia un nuevo objeto ImplProducto
     * @param id ID que tendra el producto.
     * @param tipo Tipo que sera el producto.
     * @param precio Precio al que se vendera el producto.
     * @param nombre Nombre del producto.
     * @param descripcion Breve descripcion del producto.
     * @param vegano Para conocer si es vegano o no.
     */
    public ImplProducto(int id, EnumTipo tipo, double precio, String nombre, String descripcion, boolean vegano){
        this.id = id;
        this.tipo = tipo;
        this.precio = precio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.vegano = vegano;
    }

    //Constructor de copia

    /**
     * Instancia un nuevo objeto ImplProducto.
     * @param otro Objeto que vamos a copiar.
     */
    public ImplProducto(ImplProducto otro){
        id = otro.getId();
        tipo = otro.getTipo();
        precio = otro.getPrecio();
        nombre = otro.getNombre();
        descripcion = otro.getDescripcion();
        vegano = otro.getVegano();
    }

    //Get Y Set
    /**
     * Obtiene el ID del producto
     * @return asociado al nombre manda el ID del producto
     */
    public int getId(){
        return id;
    }
    /**
     *  Establece el ID del producto
     * @param id El ID para el producto
     */
    public void setId(int id){
        this.id = id;
    }

    /**
     * Obtiene un EnumTipo que se refiere al tipo de producto que es.
     * @return asociado al nombre devuelve el tipo de producto.
     */
    public EnumTipo getTipo(){
        return tipo;
    }
    /**
     * Establece el tipo de producto.
     * @param tipo EnumTipo para establecer el tipo de producto.
     */
    public void setTipo(EnumTipo tipo){
        this.tipo = tipo;
    }

    /**
     * Obtiene el precio del producto.
     * @return asociado al nombre devuelve el precio del producto.
     */
    public double getPrecio(){
        return precio;
    }
    /**
     * Establece el precio del producto.
     * @param precio Precio al que se establece el producto.
     */
    public void setPrecio(double precio){
        this.precio = precio;
    }

    /**
     * Obtiene el nombre del producto
     * @return asociado al nombre devuelve el nombre del producto
     */
    public String getNombre(){
        return nombre;
    }
    /**
     * Establece el nombre del producto.
     * @param nombre Nombre para el producto.
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    /**
     * Obtiene la descripcion del producto
     * @return asociado al nombre devuelve la descripcion del producto.
     */
    public String getDescripcion(){
        return descripcion;
    }
    /**
     * Establece la descripcion del producto.
     * @param descripcion Descripcion del producto.
     */
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    /**
     * Obtiene si un producto es vegano o no.
     * @return asociado al nombre devuelve un boolean. True en caso de ser vegano y False en caso contrario.
     */
    public boolean getVegano(){
        return vegano;
    }
    /**
     * Establece si un producto es vegano o no.
     * @param vegano Boolean para indicar si es vegano o no.
     */
    public void setVegano(boolean vegano){
        this.vegano = vegano;
    }

    //Funciones sobreescritas
    //hashCode
    /**
     * @see java.lang.Object#hashCode()
     */
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
    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return getId() + "," + getTipo() + "," + getPrecio() + "," +getNombre()+ "," + getDescripcion() + "," + getVegano();
    }

    /**
     * Criterio de comparacion: segun el id
     * @param otro de tipo ImplProducto para compararlo.
     * @return 1 -- Si el tipo ImplProducto es mayor que el otro introducido por parámetros.
     *         0 -- Si el tipo ImplProducto es igual que el otro introducido por parámetros.
     *        -1 -- Si el tipo ImplProducto es menor que el otro introducido por parámetros.
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