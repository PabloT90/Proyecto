package Clases;

import java.io.*;

public class FuncionesOrdenacionFicheros {
    /*
    * Interfaz
    * Nombre: partirFicheroEnSecuencias
    * Comentario: Esta función permite partir(distribuir) los datos de un fichero en
    * secuencias dentro de dos nuevos ficheros. Esta función no modifica el estado del fichero
    * de origen.
    * Cabecera: public void partirFicheroEnSecuencias(String fichero, String ficheroNuevo1, String ficheroNuevo2, int longitud)
    * Entrada:
    *   -Cadena fichero //Dirección del fichero del que se va a partir la información.
    *   -Cadena ficheroNuevo1   //Dirección del primer nuevo fichero.
    *   -Cadena ficheroNuevo2   //Dirección del segundo nuevo fichero.
    *   -entero longitud    //longitud de la secuencia
    * Precondiciones:
    *   -fichero debe apuntar a un fichero existente.
    *   -ficheroNuevo1 debe ser una dirección(Path) correcta para el nuevo fichero.
    *   -ficheroNuevo2 debe ser una dirección(Path) correcta para el nuevo fichero.
    *   -longitud debe ser mayor que 0.
    * Postcondiciones: Se han creado dos nuevos ficheros con la información partida en secuencias de un fichero origen.
    * */
    /**
     * Parte los datos de un fichero en secuencias dentro de dos nuevos ficheros.
     * @param fichero Dirección del fichero del que se va a partir la información.
     * @param ficheroNuevo1 Dirección del primer nuevo fichero.
     * @param ficheroNuevo2 Dirección del segundo nuevo fichero.
     * @param longitud Longitud de la secuencia.
     */
    public void partirFicheroEnSecuencias(String fichero, String ficheroNuevo1, String ficheroNuevo2, int longitud){
        int contadorSecuencia = 1;
        String registro = " ";
        FileReader fr = null;
        BufferedReader br = null;
        FileWriter fw1 = null, fw2 = null;
        BufferedWriter bw1 = null, bw2 = null;

        try{
            fr = new FileReader(fichero);
            br = new BufferedReader(fr);
            fw1 = new FileWriter(ficheroNuevo1);
            bw1 = new BufferedWriter(fw1);
            fw2 = new FileWriter(ficheroNuevo2);
            bw2 = new BufferedWriter(fw2);

            registro = br.readLine();//Leemos el primer registro
            while (registro != null) {//Mientras aún haya registros

                 if (contadorSecuencia <= longitud) {//Si contadorSecuencia es menor o igual que la longitud.
                    bw1.write(registro);    //Escribimos el dato en el fichero
                    bw1.newLine();  //Salto de línea en el fichero
                    bw1.flush();    //Limpia el buffer
                 } else {
                    bw2.write(registro);
                    bw2.newLine();
                    bw2.flush();
                 }

                 if (contadorSecuencia >= longitud * 2) {//Si contadorSecuencia es mayor o igual que el doble de la longitud
                    contadorSecuencia = 1;
                 } else {
                    contadorSecuencia++;
                 }

                 registro = br.readLine();
                }
        }catch(FileNotFoundException error1) {
            error1.printStackTrace();   //printStackTrace nos muestra porque salto la excepción.
        }catch(IOException error2) {
            error2.printStackTrace();
        }finally{
            try{
                fr.close();
                br.close();
                fw1.close();
                bw1.close();
                fw2.close();
                bw2.close();
            }catch(IOException error1){
                error1.printStackTrace();
            }
        }
    }

    /*
    * Interfaz
    * Nombre: mezclaFicherosEnSecuencias
    * Comentario: Esta función permite mezclar la información de dos ficheros en secuencias, originando un nuevo fichero
    * con la información de ambos. Esta función no modifica el estado(datos) de los ficheros originales.
    * Cabecera: public void mezclaFicherosEnSecuencias(String fichero1, String fichero2, String ficheroNuevo, int longitud)
    * Entrada:
    *   -Cadena fichero1 //Dirección del primer fichero.
    *   -Cadena fichero2 //Dirección del segundo fichero.
    *   -Cadena ficheroNuevo //Dirección del nuevo fichero.
    *   -entero longitud //Longitud de la secuencia
    * Precondiciones:
    *   -fichero1 debe apuntar a un fichero existente.
    *   -fichero2 debe apuntar a un fichero existente.
    *   -ficheroNuevo debe ser una dirección(Path) correcta para el nuevo fichero.
    *   -longitud debe ser mayor que 0.
    * Postcondiciones: En un fichero se ha almacenado la información partida en secuencias de dos ficheros origen.
    * */
    /**
     * Mezcla la información de 2 ficheros en secuencias, originando un nuevo fichero con la información de ambos.
     * @param fichero1 Dirección del primer fichero.
     * @param fichero2 Dirección del segundo fichero.
     * @param ficheroNuevo Dirección del nuevo fichero.
     * @param longitud Longitud de la secuencia.
     */
    public void mezclaFicherosEnSecuencias(String fichero1, String fichero2, String ficheroNuevo, int longitud){
        int contadorSecuencia1 = 1, contadorSecuencia2 = 1;
        String registro1 = " ", registro2 = " ";
        FileReader fr1 = null, fr2 = null;
        BufferedReader br1 = null, br2 = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        String[] partesRegistro1 = null, partesRegistro2 = null;

        try{
            fr1 = new FileReader(fichero1);
            br1 = new BufferedReader(fr1);
            fr2 = new FileReader(fichero2);
            br2 = new BufferedReader(fr2);
            fw = new FileWriter(ficheroNuevo);
            bw = new BufferedWriter(fw);

            registro1 = br1.readLine();//Leemos un dato del primer fichero.
            registro2 = br2.readLine();//Leemos un dato del segundo fichero.
            while(registro1 != null || registro2 != null){//Mientras alguno de los ficheros no haya alcanzado el fin de fichero
                //Almacenamos los datos en secuencias en el nuevo fichero
                while(contadorSecuencia1 <= longitud && contadorSecuencia2 <= longitud && registro1 != null && registro2 != null) {
                    partesRegistro1 = registro1.split(",");
                    partesRegistro2 = registro2.split(",");
                    if (Integer.parseInt(partesRegistro1[0]) <= Integer.parseInt(partesRegistro2[0])) {//Insertamos los datos en orden ascendente
                        bw.write(registro1);
                        bw.newLine();
                        bw.flush();
                        registro1 = br1.readLine();
                        contadorSecuencia1++;
                    } else {
                        bw.write(registro2);
                        bw.newLine();
                        bw.flush();
                        registro2 = br2.readLine();
                        contadorSecuencia2++;
                    }
                }
                //Almacenamos los registros restantes
                if(contadorSecuencia1 <= longitud && registro1 != null){
                    for(;contadorSecuencia1 <= longitud && registro1 != null; contadorSecuencia1++){
                        bw.write(registro1);
                        bw.newLine();
                        bw.flush();
                        registro1 = br1.readLine();
                    }
                }else{
                    if(registro2 != null){
                        for(;contadorSecuencia2 <= longitud && registro2 != null; contadorSecuencia2++){
                            bw.write(registro2);
                            bw.newLine();
                            bw.flush();
                            registro2 = br2.readLine();
                        }
                    }
                }
                //Actualizamos los contadores de secuencia
                contadorSecuencia1 = 1;
                contadorSecuencia2 = 1;
            }
        }catch(FileNotFoundException error1){
            error1.printStackTrace();
        }catch(IOException error2){
            error2.printStackTrace();
        }finally {
            try{
                fr1.close();
                br1.close();
                fr2.close();
                br2.close();
                fw.close();
                bw.close();
            }catch(IOException error1){
                error1.printStackTrace();
            }

        }
    }

    /*
    * Interfaz
    * Nombre: numeroRegistrosFichero
    * Comentario: Esta función permite obtener el número de registros almacenados en
    * un fichero.
    * Cabecera: public int numeroRegistrosFichero(String direccionFichero)
    * Entrada:
    *   -Cadena direccionFichero //Es la dirección(Path) del fichero.
    * Salida:
    *   -entero numeroRegistros
    * Precondiciones:
    *   -La dirección debe apuntar a un fichero existente.
    * Postcondiciones: La función devuelve un número entero asociado al nombre,
    * que es el número de registros que almacena el fichero.
    * */
    /**
     * Obtiene el número de registros de un fichero.
     * @param direccionFichero Dirección del fichero.
     * @return Numero de registros del fichero.
     */
    public int numeroRegistrosFichero(String direccionFichero){
        int numeroRegistros = 0;
        String registro = " ";
        FileReader fr = null;
        BufferedReader br = null;

        try{
            fr = new FileReader(direccionFichero);
            br = new BufferedReader(fr);

            registro = br.readLine();
            while(registro != null){    //Mientras no sea fin de fichero
                numeroRegistros++;  //Incrementamos numeroRegistros
                registro = br.readLine();
            }
        }catch(FileNotFoundException error1){
            error1.printStackTrace();
        }catch (IOException error2){
            error2.printStackTrace();
        }finally {
            try{
                fr.close();
                br.close();
            }catch (IOException error1){
                error1.printStackTrace();
            }
        }
        return numeroRegistros;
    }

    /*
    * Interfaz
    * Nombre: mezclaDirecta
    * Comentario: Esta función permite ordenar de manera ascendente un fichero que almacena objetos ImplStockProducto.
    * Cabecera: public void mezclaDirecta(String direccionFichero)
    * Entrada:
    *   -Cadena direccionFichero //Es la dirección(Path) del fichero.
    * Precondiciones:
    *   -La dirección debe apuntar a un fichero existente.
    *   -El fichero solo debe almacenar productos.
    * Postcondiciones: Se han ordenado los registros del fichero en orden ascendente, según el valor de los enteros
    * que almacena.
    * */
    /**
     * Ordena de manera ascendente un fichero que almacena números enteros.
     * @param direccionFichero Dirección del fichero.
     */
    public void mezclaDirecta(String direccionFichero){
        int numeroRegistros = numeroRegistrosFichero(direccionFichero);

        for(int longitudSecuencias = 1; longitudSecuencias < numeroRegistros; longitudSecuencias *= 2){
            partirFicheroEnSecuencias(direccionFichero, "src\\OrdenacionFicheros\\Fichero1.txt",
                    "src\\OrdenacionFicheros\\Fichero2.txt", longitudSecuencias);

            mezclaFicherosEnSecuencias("src\\OrdenacionFicheros\\Fichero1.txt",
                    "src\\OrdenacionFicheros\\Fichero2.txt", direccionFichero, longitudSecuencias);
        }
    }

    /*
     * Interfaz
     * Nombre: mezclaFicherosEnSecuencias2
     * Comentario: Esta función permite mezclar la información de dos ficheros en secuencias, originando un nuevo fichero
     * con la información de ambos. Esta función no modifica el estado(datos) de los ficheros originales.
     * Cabecera: public void mezclaFicherosEnSecuencias2(String fichero1, String fichero2, String ficheroNuevo, int longitud)
     * Entrada:
     *   -Cadena fichero1 //Dirección del primer fichero.
     *   -Cadena fichero2 //Dirección del segundo fichero.
     *   -Cadena ficheroNuevo //Dirección del nuevo fichero.
     *   -entero longitud //Longitud de la secuencia
     * Precondiciones:
     *   -fichero1 debe apuntar a un fichero existente.
     *   -fichero2 debe apuntar a un fichero existente.
     *   -ficheroNuevo debe ser una dirección(Path) correcta para el nuevo fichero.
     *   -longitud debe ser mayor que 0.
     * Postcondiciones: En un fichero se ha almacenado la información partida en secuencias de dos ficheros origen.
     * */
    /**
     * Mezcla la información de 2 ficheros en secuencias, originando un nuevo fichero con la información de ambos.
     * @param fichero1 Path del primer fichero.
     * @param fichero2 Path del segundo fichero.
     * @param ficheroNuevo Path del nuevo fichero.
     * @param longitud Longitud de la secuencia.
     */
    public void mezclaFicherosEnSecuencias2(String fichero1, String fichero2, String ficheroNuevo, int longitud){
        int contadorSecuencia1 = 1, contadorSecuencia2 = 1, saltoExcepcion = 1;
        FileInputStream fis1 = null, fis2 = null;
        ObjectInputStream ois1 = null, ois2 = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        ImplMenu menu1 = null, menu2 = null;

        try{
            fis1 = new FileInputStream(fichero1);
            ois1 = new ObjectInputStream(fis1);
            fis2 = new FileInputStream(fichero2);
            ois2 = new ObjectInputStream(fis2);
            fos = new FileOutputStream(ficheroNuevo);
            oos = new ObjectOutputStream(fos);

            menu1 = (ImplMenu) ois1.readObject();
            saltoExcepcion = 2;//No permite saber en que lectura salta la excepción de fin de fichero
            menu2 = (ImplMenu) ois2.readObject();
            while(true){
                //Almacenamos los datos en secuencias en el nuevo fichero
                while(contadorSecuencia1 <= longitud && contadorSecuencia2 <= longitud) {
                    if (menu1.getId() <= menu2.getId()) {//Insertamos los datos en orden ascendente
                        oos.writeObject(menu1);
                        saltoExcepcion = 1;
                        menu1 = (ImplMenu) ois1.readObject();
                        contadorSecuencia1++;
                    } else {
                        oos.writeObject(menu2);
                        saltoExcepcion = 2;
                        menu2 = (ImplMenu) ois2.readObject();
                        contadorSecuencia2++;
                    }
                }
                //Almacenamos los registros de secuencias restantes
                for(;contadorSecuencia1 <= longitud; contadorSecuencia1++){
                    oos.writeObject(menu1);
                    saltoExcepcion = 1;
                    menu1 = (ImplMenu) ois1.readObject();
                }

                for(;contadorSecuencia2 <= longitud; contadorSecuencia2++){
                    oos.writeObject(menu2);
                    saltoExcepcion = 2;
                    menu2 = (ImplMenu) ois2.readObject();
                }

                //Actualizamos los contadores de secuencia
                contadorSecuencia1 = 1;
                contadorSecuencia2 = 1;
            }
        }catch(ClassNotFoundException error1) {
            error1.printStackTrace();
        }catch (EOFException error){
            try{
                if(saltoExcepcion == 1){
                    while(true){
                        oos.writeObject(menu2);
                        menu2 = (ImplMenu) ois2.readObject();
                    }
                }else{
                    while(true){
                        oos.writeObject(menu1);
                        menu1 = (ImplMenu) ois1.readObject();
                    }
                }
            }catch (FileNotFoundException error1) {
                error1.printStackTrace();
            }catch (EOFException error4){
            }catch (IOException error2){
                error2.printStackTrace();
            }catch (ClassNotFoundException error3){
                error3.printStackTrace();
            }
        }catch(IOException error2){
            error2.printStackTrace();
        }finally {
            try{
                ois1.close();
                fis1.close();
                ois2.close();
                fis2.close();
                oos.close();
                fos.close();
            }catch(IOException error1){
                error1.printStackTrace();
            }
        }
    }

    /*
     * Interfaz
     * Nombre: partirFicheroEnSecuencias2
     * Comentario: Esta función permite partir(distribuir) los datos de un fichero en
     * secuencias dentro de dos nuevos ficheros. Esta función no modifica el estado del fichero
     * de origen.
     * Cabecera: public void partirFicheroEnSecuencias2(String fichero, String ficheroNuevo1, String ficheroNuevo2, int longitud)
     * Entrada:
     *   -Cadena fichero //Dirección del fichero del que se va a partir la información.
     *   -Cadena ficheroNuevo1   //Dirección del primer nuevo fichero.
     *   -Cadena ficheroNuevo2   //Dirección del segundo nuevo fichero.
     *   -entero longitud    //longitud de la secuencia
     * Precondiciones:
     *   -fichero debe apuntar a un fichero existente.
     *   -ficheroNuevo1 debe ser una dirección(Path) correcta para el nuevo fichero.
     *   -ficheroNuevo2 debe ser una dirección(Path) correcta para el nuevo fichero.
     *   -longitud debe ser mayor que 0.
     * Postcondiciones: Se han creado dos nuevos ficheros con la información partida en secuencias de un fichero origen.
     * */
    /**
     * Parte los datos de un fichero en secuencias dentro de 2 ficheros recibidos como parámetros.
     * @param fichero Path del fichero a partir.
     * @param ficheroNuevo1 Path del primer fichero.
     * @param ficheroNuevo2 Path del segundo fichero.
     * @param longitud Longitud de la secuencia.
     */
    public void partirFicheroEnSecuencias2(String fichero, String ficheroNuevo1, String ficheroNuevo2, int longitud) {
        int contadorSecuencia = 1;
        ImplMenu menu = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        FileOutputStream fos1 = null, fos2 = null;
        ObjectOutputStream oos1 = null, oos2 = null;

        try {
            fis = new FileInputStream(fichero);
            ois = new ObjectInputStream(fis);
            fos1 = new FileOutputStream(ficheroNuevo1);
            oos1 = new ObjectOutputStream(fos1);
            fos2 = new FileOutputStream(ficheroNuevo2);
            oos2 = new ObjectOutputStream(fos2);

            while (true) {
                menu = (ImplMenu) ois.readObject();

                if (contadorSecuencia <= longitud) {//Si contadorSecuencia es menor o igual que la longitud.
                    oos1.writeObject(menu);
                } else {
                    oos2.writeObject(menu);
                }

                if (contadorSecuencia >= longitud * 2) {//Si contadorSecuencia es mayor o igual que el doble de la longitud
                    contadorSecuencia = 1;
                } else {
                    contadorSecuencia++;
                }
            }
        }catch (FileNotFoundException error1) {
            error1.printStackTrace();   //printStackTrace nos muestra porque salto la excepción.
        }catch (EOFException error){
        }catch (IOException error2) {
            error2.printStackTrace();
        }catch (ClassNotFoundException error3) {
            error3.printStackTrace();
        }finally{
            try{
                ois.close();
                fis.close();
                oos1.close();
                fos1.close();
                oos2.close();
                fos2.close();
            }catch(IOException error1){
                error1.printStackTrace();
            }
        }
    }

    /*
     * Interfaz
     * Nombre: mezclaDirecta2 (Pablo modifica la interfaz)
     * Comentario: Esta función permite ordenar de manera ascendente un fichero que almacena objetos ImplMenu.
     * Cabecera: public void mezclaDirecta2(String direccionFichero)
     * Entrada:
     *   -Cadena direccionFichero //Es la dirección(Path) del fichero.
     * Precondiciones:
     *   -La dirección debe apuntar a un fichero existente.
     *   -El fichero solo almacena menús.
     * Postcondiciones: Se han ordenado los registros del fichero en orden ascendente, según el valor de las id's
     * de los menús que almacena.
     * */
    /**
     * Ordena de manera ascendente un fichero que almacena números enteros.
     * @param direccionFichero Path del fichero.
     */
    public void mezclaDirecta2(String direccionFichero){
        int numeroRegistros = numeroRegistrosFichero2(direccionFichero);

        for(int longitudSecuencias = 1; longitudSecuencias < numeroRegistros; longitudSecuencias *= 2){
            partirFicheroEnSecuencias2(direccionFichero, "src\\OrdenacionFicheros\\Fichero1.dat",
                    "src\\OrdenacionFicheros\\Fichero2.dat", longitudSecuencias);

            mezclaFicherosEnSecuencias2("src\\OrdenacionFicheros\\Fichero1.dat",
                    "src\\OrdenacionFicheros\\Fichero2.dat", direccionFichero, longitudSecuencias);
        }
    }

    /*
     * Interfaz
     * Nombre: numeroRegistrosFichero2
     * Comentario: Esta función permite obtener el número de registros almacenados en
     * un fichero.
     * Cabecera: public int numeroRegistrosFichero(String direccionFichero)
     * Entrada:
     *   -Cadena direccionFichero //Es la dirección(Path) del fichero.
     * Salida:
     *   -entero numeroRegistros
     * Precondiciones:
     *   -La dirección debe apuntar a un fichero existente.
     * Postcondiciones: La función devuelve un número entero asociado al nombre,
     * que es el número de registros que almacena el fichero.
     * */
    /**
     * Obtiene el número de registros de un fichero.
     * @param direccionFichero Path del fichero.
     * @return Número de registros del fichero.
     */
    public int numeroRegistrosFichero2(String direccionFichero) {
        int numeroRegistros = 0;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(direccionFichero);
            ois = new ObjectInputStream(fis);

            while (true) {
                ois.readObject();
                numeroRegistros++;  //Incrementamos numeroRegistros
            }
        }catch (ClassNotFoundException error3){
            error3.printStackTrace();
        }catch(FileNotFoundException error1) {
            error1.printStackTrace();
        }catch (EOFException error){
        }catch (IOException error2){
            error2.printStackTrace();
        }finally {
            try{
                if(ois != null) {
                    ois.close();
                }
                fis.close();

            }catch (IOException error1){
                error1.printStackTrace();
            }
        }
        return numeroRegistros;
    }
}
