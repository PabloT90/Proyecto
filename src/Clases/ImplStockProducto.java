/*
 * Tipo: ImplStockProducto
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
 *
 * Funciones añadidas:
 * public int getProductoId()
 * public void setProductoId(int id)
 *
 * public EnumTipo getProductoTipo()
 * public void setProductoTipo(EnumTipo tipo)
 *
 * public double getProductoPrecio()
 * public void setProductoPrecio(double precio)
 *
 * public String getProductoNombre()
 * public void setProductoNombre(String nombre)
 *
 * public String getProductoDescripcion()
 * public void setProductoDescripcion(String descripcion)
 *
 * public boolean getProductoVegano()
 * public void setProductoVegano(boolean vegano)
 *
 * public int hashCode()
 * public boolean equals(Object obj)
 * public ImplStockProducto clone()
 * public ImplStockProducto deepClone()
 * public String toString()
 * public String toStringBonito()
 * public ImplProducto productoSinStock()
 * */

package Clases;

import Enums.EnumTipo;
import Interfaces.StockProducto;

public class ImplStockProducto implements StockProducto, Cloneable{
    private ImplProducto producto;
    private int stock;
    
    //Constructor por defecto
    /**
     * Instancia un nuevo objeto ImplStockProducto
     */
    public ImplStockProducto(){
        producto = new ImplProducto();
        stock = 0;
    }
    
    //Constructor con parámetros
    /**
     * Instancia un nuevo objeto ImplStockProducto
     * @param producto Producto del que vamos a registrar el stock
     * @param stock Cantidad de producto que tendremos en el almacen.
     */
    public ImplStockProducto(ImplProducto producto, int stock){
        this.producto = producto;
        this.stock = stock;
    }

    //Constructor con parametros 2
    public ImplStockProducto(int id, EnumTipo tipo, double precio, String nombre, String descripcion, boolean vegano, int stock){
        producto = new ImplProducto( id, tipo, precio, nombre, descripcion, vegano);
        this.stock = stock;
    }
    
    //Constructor de copia
    /**
     * Instancia un nuevo objeto ImplStockProducto
     * @param otro Objeto que copiaremos.
     */
    public ImplStockProducto(ImplStockProducto otro){
        producto = otro.producto;
        this.stock = otro.getStock();
    }

    //Get Y Set

    /**
     * Obtiene el stock del producto
     * @return asociado al nombre devuelve un entero con el numero de stock del producto.
     */
    public int getStock(){
        return stock;
    }
    /**
     * Establece el stock del producto.
     * @param stock Numero de productos guardados en el almacen.
     */
    public void setStock(int stock){
        this.stock = stock;
    }

    //Funciones añadidas

    //Patrón delegación ImplProducto
    /**
     *  Obtiene el ID del producto.
     * @return asociado al nombre manda el ID del producto.
     */
    public int getProductoId(){
        return producto.getId();
    }
    /**
     * Establece el ID del producto.
     * @param id El ID para el producto.
     */
    public void setProductoId(int id){
        producto.setId(id);
    }

    /**
     * Obtiene el tipo de producto
     * @return Asociado al nombre manda un EnumTipo con el tipo de producto.
     */
    public EnumTipo getProductoTipo(){
        return producto.getTipo();
    }
    /**
     * Establece el tipo de producto
     * @param tipo EnumTipo para el tipo de producto
     */
    public void setProductoTipo(EnumTipo tipo){
        producto.setTipo(tipo);
    }

    /**
     * Obtiene el precio de un producto.
     * @return asociado al nombre devuelve el precio del producto
     */
    public double getProductoPrecio(){
        return producto.getPrecio();
    }
    /**
     * Establece el precio del producto.
     * @param precio Precio que tendra el producto.
     */
    public void setProductoPrecio(double precio){
        producto.setPrecio(precio);
    }

    /**
     * Obtiene el nombre de un producto.
     * @return asociado al nombre devuelve el nombre del producto.
     */
    public String getProductoNombre(){
        return producto.getNombre();
    }
    /**
     * Establece el nombre del producto.
     * @param nombre Nombre que tendra el producto.
     */
    public void setProductoNombre(String nombre){
        producto.setNombre(nombre);
    }

    /**
     * Obtiene la descripcion del prodcuto
     * @return asociado al nombre devuelve la descripcion del producto.
     */
    public String getProductoDescripcion(){
        return producto.getDescripcion();
    }
    /**
     * Establece la descripcion del producto.
     * @param descripcion Descripcion del producto.
     */
    public void setProductoDescripcion(String descripcion){
        producto.setDescripcion(descripcion);
    }

    /**
     * Obtiene si un producto es vegano o no.
     * @return asociado al nombre devuelve un boolean. True en caso de ser vegano, false en caso contrario.
     */
    public boolean getProductoVegano(){
        return producto.getVegano();
    }
    /**
     * Establece si un producto es vegano o no.
     * @param vegano Boolean para establecer vegano o no.
     */
    public void setProductoVegano(boolean vegano){
        producto.setVegano(vegano);
    }

    /*
    * Interfaz
    * Nombre: productoSinStock
    * Comentario: Esta función nos permite obtener el tipo ImplProducto sin el
    * atributo stock.
    * Cabecera: public ImplProducto productoSinStock()
    * Salida:
    *   -ImplProducto producto
    * Postcondiciones: La función devuelve un tipo ImplProducto asociado al nombre,
    * que es el producto sin el stock.
    * */
    public ImplProducto productoSinStock(){
        return producto;
    }

    //hashCode
    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode(){
        return getProductoId() * 7 + stock + 13;
    }

    /** Criterio de igualdad: segun el id y el stock.
     * @param obj de tipo Object.
     * @return True en caso de tener el mismo idy stock. False en caso contrario.
     */
    @Override
    public boolean equals(Object obj){
        boolean ret = false;

        if(this == obj){
            ret = true;
        }else{
            if(obj != null && obj instanceof ImplStockProducto){
                ImplStockProducto otro = (ImplStockProducto) obj;
                if(this.getProductoId() == otro.getProductoId() &&
                   this.getStock() == otro.getStock()){
                    ret = true;
                }
            }
        }

        return ret;
    }
    //clone
    @Override
    public ImplStockProducto clone(){
        ImplStockProducto copia = null;

        try{
            copia = (ImplStockProducto) super.clone();
        }catch (CloneNotSupportedException error){
            error.printStackTrace();
        }

        return copia;
    }

    public ImplStockProducto deepClone(){
        ImplStockProducto copia = null;

        try{
            copia = (ImplStockProducto) super.clone();
            copia.producto = new ImplProducto(this.producto);
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
        return getProductoId()+","+getProductoTipo()+","+getProductoPrecio()+","+getProductoNombre()+","+getProductoDescripcion()+","+
                getProductoVegano()+","+getStock();
    }

    //toStringBonito
    /**
     * toString que muestra los datos de forma más legible para el usuario.
     */
    public String toStringBonito(){
        return "ID: " +getProductoId()+"  |Tipo: "+getProductoTipo()+"  |Precio: "+getProductoPrecio()+"  |Nombre: "+getProductoNombre()+"  |Descripcion: "+getProductoDescripcion()+"  |Vegano: "+
                getProductoVegano()+"  |Stock: "+getStock();
    }
}
