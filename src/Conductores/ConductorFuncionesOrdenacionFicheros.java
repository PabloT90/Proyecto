package Conductores;

import Clases.FuncionesOrdenacionFicheros;

public class ConductorFuncionesOrdenacionFicheros {
    public static void main (String[] args){
        FuncionesOrdenacionFicheros funcion = new FuncionesOrdenacionFicheros();

        //partirFicheroEnSecuencias
        funcion.partirFicheroEnSecuencias("FicheroPrueba.txt", "FicheroSecuencias1.txt",
                "FicheroSecuencias2.txt", 3);
        /*funcion.partirFicheroEnSecuencias("..\\Presentaciones\\FicheroPrueba.txt", "..\\Pablo\\FicheroSecuencias1.txt",
                "..\\Presentaciones\\FicheroSecuencias2.txt", 3);*///Error en la dirección del primer nuevo fichero
        /*funcion.partirFicheroEnSecuencias("..\\Presentaciones\\FicheroPrueba.txt", "..\\Presentaciones\\FicheroSecuencias1.txt",
                "..\\Presentaciones\\FicheroSecuencias2.txt", 2);*/

        //mezclaFicherosEnSecuencias
        funcion.mezclaFicherosEnSecuencias("FicheroSecuencias1.txt",
                "FicheroSecuencias2.txt", "FicheroEnSecuencias.txt", 2);

        /*funcion.mezclaFicherosEnSecuencias("..\\Presentaciones\\FicheroSecuencias1.txt",
                "..\\Presentaciones\\FicheroSecuencias2.txt", "..\\Presentaciones\\FicheroEnSecuencias.txt", 1);*/

        //numeroRegistrosFichero
        System.out.println(funcion.numeroRegistrosFichero("FicheroEnSecuencias.txt"));
        System.out.println(funcion.numeroRegistrosFichero("FicheroSecuencias1.txt"));

        //mezclaDirecta
        funcion.mezclaDirecta("FicheroAOrdenar.txt");
    }
}
