package Conductores;

import Clases.FuncionesOrdenacionFicheros;

public class ConductorFuncionesOrdenacionFicheros {
    public static void main (String[] args){
        FuncionesOrdenacionFicheros funcion = new FuncionesOrdenacionFicheros();

        //partirFicheroEnSecuencias (funciona)
        /*funcion.partirFicheroEnSecuencias("src\\OrdenacionFicheros\\Principal.txt",
                "src\\OrdenacionFicheros\\Fichero1.txt",
                "src\\OrdenacionFicheros\\Fichero2.txt", 3);*/

        //mezclaFicherosEnSecuencias (funciona)
        /*funcion.mezclaFicherosEnSecuencias("src\\OrdenacionFicheros\\Principal.txt",
                "src\\OrdenacionFicheros\\Fichero1.txt",
                "src\\OrdenacionFicheros\\Fichero2.txt", 3);*/

        //numeroRegistrosFichero (funciona)
        System.out.println(funcion.numeroRegistrosFichero("src\\OrdenacionFicheros\\Fichero1.txt"));
        System.out.println(funcion.numeroRegistrosFichero("src\\OrdenacionFicheros\\Fichero2.txt"));

        //mezclaDirecta (funciona)
        funcion.mezclaDirecta("src\\OrdenacionFicheros\\Principal.txt");


    }
}
