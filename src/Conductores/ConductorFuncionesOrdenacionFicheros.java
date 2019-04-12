package Conductores;

import Clases.FuncionesMenus;
import Clases.FuncionesOrdenacionFicheros;
import Clases.ImplMenu;

import java.io.*;

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
        //System.out.println(funcion.numeroRegistrosFichero("src\\OrdenacionFicheros\\Fichero1.txt"));
        //System.out.println(funcion.numeroRegistrosFichero("src\\OrdenacionFicheros\\Fichero2.txt"));

        //mezclaDirecta (funciona)
        //funcion.mezclaDirecta("src\\OrdenacionFicheros\\Principal.txt");

        System.out.println("Menus");
        FuncionesMenus funciones = new FuncionesMenus();
        int[] productos = {66, 69};
        ImplMenu menu1 = new ImplMenu(16, "trabajo", "El 16", productos, 3.5);
        ImplMenu menu2 = new ImplMenu(18, "trabajo", "El 18", productos, 3.5);
        ImplMenu menu3 = new ImplMenu(6, "trabajo", "El 6.", productos, 3.5);
        ImplMenu menu4 = new ImplMenu(74, "trabajo", "El 74.", productos, 3.5);
        ImplMenu menu5 = new ImplMenu(14, "trabajo", "El 14.", productos, 3.5);
        try {
            FileOutputStream fos = new FileOutputStream("src\\OrdenacionFicheros\\Principal.dat");
            ObjectOutputStream oos =  new ObjectOutputStream(fos);
            oos.writeObject(menu1);
            oos.writeObject(menu2);
            oos.writeObject(menu3);
            oos.writeObject(menu4);
            oos.writeObject(menu5);
            oos.close();
            fos.close();
        }catch(FileNotFoundException error){
            error.printStackTrace();
        }catch(EOFException error2){
        }catch(IOException error3){
            error3.printStackTrace();
        }

        //partirFicheroEnSecuencias
        /*funcion.partirFicheroEnSecuencias2("src\\OrdenacionFicheros\\Principal.dat",
                "src\\OrdenacionFicheros\\Fichero1.dat",
                "src\\OrdenacionFicheros\\Fichero2.dat", 1);*/

        //MezclaFicherosEnSecuencias
        /*funcion.mezclaFicherosEnSecuencias2("src\\OrdenacionFicheros\\Fichero1.dat",
                "src\\OrdenacionFicheros\\Fichero2.dat",
                "src\\OrdenacionFicheros\\Principal.dat", 1);*/

        //NumeroRegistrosFichero (funciona)
        //System.out.println(funcion.numeroRegistrosFichero2("src\\OrdenacionFicheros\\Principal.dat"));
        //System.out.println(funcion.numeroRegistrosFichero2("src\\OrdenacionFicheros\\Fichero2.dat"));

        funcion.mezclaDirecta2("src\\OrdenacionFicheros\\Principal.dat");

    }
}
