package Clases;

public class FuncionesMenus {
    /*
    * Interfaz
    * Nombre: incrementarArrayProductos
    * Comentario: Esta función permite incrementar el tamaño de un
    * array del tipo Implproducto.
    * Cabecera: public int incrementarArrayProductos(int incremento, ImplProducto[] array)
    * Entrada/Salida:
    *   -ImplProducto[] array
    * Entrada:
    *   -entero incremento
    * Salida:
    *   -entero validez
    * Postcondiciones: La función devuelve un número entero asociado al
    * nombre, 0 si se ha conseguido incrementar el tamaño del array o -1
    * si incremento es menor o igual que 0, no modificando el tamaño
    * del array.
    * */
    public int incrementarArrayProductos(int incremento, ImplProducto[] array){
        int validez = -1;
        ImplProducto[] copia = null;

        if(incremento > 0){
            validez = 0;
            copia = new ImplProducto[array.length + incremento];

            //Copiamos los elementos del array en el array de copia
            //System.arraycopy(array, 0, copia, 0, array.length);
            for (int i = 0; i < array.length; i++){
                copia[i] = array[i];
            }

            //Hacemos que array apunte a una nueva colección de elementos de mayor tamaño
            array = copia;

            for(int i = 0; i < array.length; i++){
                System.out.println(array[i]);
            }
        }

        return validez;
    }
}
