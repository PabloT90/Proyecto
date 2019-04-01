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
 * */

package Clases;

import Enums.EnumTipo;
import Interfaces.StockProducto;

public class ImplStockProducto implements StockProducto, Cloneable{
    private ImplProducto producto;
    private int stock;
    
    //Constructor por defecto
    public ImplStockProducto(){
        producto = new ImplProducto();
        stock = 0;
    }
    
    //Constructor con parámetros
    public ImplStockProducto(ImplProducto producto, int stock){
        this.producto = producto;
        this.stock = stock;
    }
    
    //Constructor de copia
    public ImplStockProducto(ImplStockProducto otro){
        producto = otro.producto;
        this.stock = otro.getStock();
    }

    //Get Y Set
    public int getStock(){
        return stock;
    }
    public void setStock(int stock){
        this.stock = stock;
    }

    //Funciones añadidas

    //Patrón delegación ImplProducto
    public int getProductoId(){
        return producto.getId();
    }
    public void setProductoId(int id){
        producto.setId(id);
    }

    public EnumTipo getProductoTipo(){
        return producto.getTipo();
    }
    public void setProductoTipo(EnumTipo tipo){
        producto.setTipo(tipo);
    }

    public double getProductoPrecio(){
        return producto.getPrecio();
    }
    public void setProductoPrecio(double precio){
        producto.setPrecio(precio);
    }

    public String getProductoDescripcion(){
        return producto.getDescripcion();
    }
    public void setProductoDescripcion(String descripcion){
        producto.setDescripcion(descripcion);
    }

    public boolean getProductoVegano(){
        return producto.getVegano();
    }
    public void setProductoVegano(boolean vegano){
        producto.setVegano(vegano);
    }

    //hashCode
    public int hashCode(){
        return getProductoId() * 7 + stock + 1 * 13;
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
    public String toString(){
        return getProductoId()+","+getProductoTipo()+","+getProductoPrecio()+","+getProductoDescripcion()+","+
                getProductoVegano()+","+getStock();
    }
}
