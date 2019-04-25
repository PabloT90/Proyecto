package Clases;

/*
* Creamos una subclase de ObjectOutputStream modificando uno de sus métodos protegidos, para
* impedir que a la hora de ingresar nueva información en un fichero cree una nueva cabecerá distinta
* a la original.
*/

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MyObjectOutputStream extends ObjectOutputStream {

    //Constructor
    public MyObjectOutputStream(OutputStream os) throws IOException{
        super(os);
    }

    //Sobreescribimos el método writeStreamHeader para evitar que a la hora de insertar un objeto en un fichero en el que
    //anteriormente se inserto un objeto con ObjectOutputStream, cree una nueva cabecera.
    @Override
    public void writeStreamHeader() throws IOException{ }
}
