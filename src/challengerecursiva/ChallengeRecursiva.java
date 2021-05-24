package challengerecursiva;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import manejoArchivos.LectorCSV;

public class ChallengeRecursiva {

    public static void main(String[] args) throws UnsupportedEncodingException {
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;
        LectorCSV lector = new LectorCSV();
        lector.leerCSV(); //se cargan los datos del socios.csv antes de iniciar el menu
        while (opcion <= 5 && opcion >= 0) {
            System.out.println(" ---------------------------------------------------------------------------------\n"
                    + "| INGRESE 1: Cantidad total de personas registradas.                              |\n"
                    + "| INGRESE 2: El promedio de edad de los socios de Racing.                         |\n"
                    + "| INGRESE 3: Un listado con las 100 primeras personas casadas, con estudios       |\n"
                    + "| Universitarios, ordenadas de menor a mayor según su edad. Por                   |\n"
                    + "| cada persona, mostrar: nombre, edad y equipo.                                   |\n"
                    + "| INGRESE 4: Un listado con los 5 nombres más comunes entre los hinchas de River. |\n"
                    + "| INGRESE 5: Un listado, ordenado de mayor a menor según la cantidad de           |\n"
                    + "| socios, que enumere, junto con cada equipo, el promedio de edad                 |\n"
                    + "| de sus socios, la menor edad registrada y la mayor edad registrada.             |\n"
                    + "| INGRESE 6: para salir del menu.                                                 |\n"
                    + " ---------------------------------------------------------------------------------\n"
                    + "INGRESE UN NUMERO:");
           try {  //por si ingresan un char o string no se rompa el programa
               opcion = entrada.nextInt();}
           catch(InputMismatchException ex){
               System.out.println("¡ERROR DEBE INGRESAR UN NUMERO!");
               entrada.nextLine();
           }
            switch (opcion) {
                case 1: //muestra la cantidad de socios en el archivo
                    System.out.println("LA CANTIDAD TOTAL DE PERSONAS REGISTRADAS ES DE: " + lector.contadorSocios() + " Personas.");
                    System.out.println("\nINGRESE UN NUMERO PARA REGRESAR AL MENU:");
                    entrada.next();
                    break;
                case 2: //muestra  el promedio de edad de los hinchas de racing
                    int promedioEdadRacing = lector.promedioEdadRacing();
                    System.out.println("EL PROMEDIO DE LA EDAD DE LOS SOCIOS DE RACING ES: " + promedioEdadRacing + " años.");
                    System.out.println("\nINGRESE UN NUMERO PARA REGRESAR AL MENU:");
                    entrada.next();
                    break;
                case 3: //muestra las 100 primeras personas casadas y con estudios universitarios
                    lector.listado();
                    System.out.println("\nINGRESE UN NUMERO PARA REGRESAR AL MENU:");
                    entrada.next();
                    break;
                case 4: //muestra los 5 nombres mas comunes en los hinchas de river
                    System.out.println("LOS 5 NOMBRES MAS REPETIDOS EN RIVER SON:");
                    lector.nombresRiver();
                    System.out.println("\nINGRESE UN NUMERO PARA REGRESAR AL MENU:");
                    entrada.next();
                    break;
                case 5: //muestra las estadisticas de los clubes de mayor a menor
                    lector.ordenarClubes();
                    System.out.println("\nINGRESE UN NUMERO PARA REGRESAR AL MENU:");
                    entrada.next();
                    break;
            }
        }
        System.out.println("¡EL PROGRAMA A FINALIZADO!");
    }
}
