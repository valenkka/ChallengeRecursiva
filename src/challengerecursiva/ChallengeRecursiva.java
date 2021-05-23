package challengerecursiva;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import domain.Socio;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Scanner;
import manejoArchivos.LectorCSV;

public class ChallengeRecursiva {

    public static void main(String[] args) throws UnsupportedEncodingException {
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;     
        LectorCSV lector = new LectorCSV();
        lector.leerCSV();
       /* lector.CargarClub("Boca");
        lector.CargarClub("River");
        lector.CargarClub("Newells");
        lector.CargarClub("Racing");
        lector.CargarClub("Velez");
        lector.CargarClub("Huracán");
        lector.CargarClub("Gimnasia LP");
        lector.CargarClub("Estudiantes");
        lector.CargarClub("Independiente");
        lector.CargarClub("Rosario Central");
        lector.CargarClub("San Lorenzo");*/
        while(opcion <= 5 && opcion >= 0) {
            System.out.println("--------------------------------------------------------");
            System.out.println("INGRESE 1: Cantidad total de personas registradas.");
            System.out.println("INGRESE 2: El promedio de edad de los socios de Racing.");
            System.out.println("INGRESE 3: Un listado con las 100 primeras personas casadas, con estudios\n" +
                               "Universitarios, ordenadas de menor a mayor según su edad. Por\n" +
                               "cada persona, mostrar: nombre, edad y equipo.");
            System.out.println("INGRESE 4: Un listado con los 5 nombres más comunes entre los hinchas de River.");
            System.out.println("INGRESE 5: Un listado, ordenado de mayor a menor según la cantidad de\n" +
                                "socios, que enumere, junto con cada equipo, el promedio de edad\n" +
                                "de sus socios, la menor edad registrada y la mayor edad registrada.");
            System.out.println("INGRESE 6: para salir del menu");
            System.out.println("--------------------------------------------------------");
            opcion = entrada.nextInt();
        
                switch (opcion) {
                     case 1:
                        System.out.println("LA CANTIDAD TOTAL DE PERSONAS REGISTRADAS ES DE: " + lector.contadorSocios() + " Personas.");
                         System.out.println("INGRESE 0: para regresar al menu");
                         opcion = entrada.nextInt();
                        break;
                     case 2:
                         int promedioEdadRacing = lector.promedioEdadRacing();
                         System.out.println("EL PROMEDIO DE LA EDAD DE LOS SOCIOS DE RACING ES: " + promedioEdadRacing + " años.");
                         System.out.println("INGRESE 0: para regresar al menu");
                         opcion = entrada.nextInt();
                         break;
                     case 3:
                         lector.listado();
                         System.out.println("INGRESE 0: para regresar al menu");
                         opcion = entrada.nextInt();
                         break;
                     case 4:
                         System.out.println("LOS 5 NOMBRES MAS REPETIDOS EN RIVER SON:");
                         lector.nombresRiver();
                         System.out.println("INGRESE 0: para regresar al menu");
                         break;
                     case 5:
                         lector.ordenarClubes();
                         System.out.println("INGRESE 0: para regresar al menu");
                         opcion = entrada.nextInt();
                         break;
                        
         }
            
        }
        

        
        
        /*   String archivo = "src\\socios.csv";
        String linea = "";
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader (new FileInputStream(archivo), "ISO-8859-1"));
            try {
                while((linea = br.readLine())!= null){ 
                    
                    
                    /*String stringLegible = new String(linea.getBytes("ISO-8859-1"), "UTF-8");
                    System.out.println(stringLegible);*/
                    
        /*            String[] columnas = linea.split(";");
                    Socio socio = new Socio(columnas[0],parseInt(columnas[1]),columnas[2],columnas[3],columnas[4]);
                   /* System.out.println(socio.toString());*/
          /*          ArrayList<Socio> socios = new ArrayList();
                    socios.add(socio);
                    for(int i = 0; i< socios.size(); i++)
                    System.out.println(socios.get(i));
                    
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } */
    } 
    
}
