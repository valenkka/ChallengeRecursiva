package manejoArchivos;

import domain.Club;
import domain.Socio;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LectorCSV {

    public ArrayList<Socio> socios = new ArrayList();
    public ArrayList<Club> clubes = new ArrayList();
    public ArrayList<Socio> sociosRiver = new ArrayList();

    public void leerCSV() throws UnsupportedEncodingException {
        String archivo = "src\\socios.csv";
        String linea = "";

        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(archivo), "ISO-8859-1"));
            try {
                while ((linea = br.readLine()) != null) {

                    /*String stringLegible = new String(linea.getBytes("ISO-8859-1"), "UTF-8");
                    System.out.println(stringLegible);*/
                    String[] columnas = linea.split(";");
                    Socio socio = new Socio(columnas[0], parseInt(columnas[1]), columnas[2], columnas[3], columnas[4]);
                    /* System.out.println(socio.toString());*/
                    socios.add(socio);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        Club club = new Club();
        for (int i = 0; i < club.NOMBRE_CLUBES.length; i++) {
            this.cargarClub(club.NOMBRE_CLUBES[i]);
        }

    }

    public int contadorSocios() {
        int cantidadSocios = 0;
        for (int i = 0; i < socios.size(); i++) {
            cantidadSocios++;
        }
        return cantidadSocios;
    }

    public void listado() {
        final int CANT_LISTADO = 100;
        Socio sociosCE[] = new Socio[CANT_LISTADO];

        //ArrayList<Socio> sociosCE = new ArrayList();
        //Socio aux = new Socio();
        int a = 0;
        for (int i = 0; i < socios.size(); i++) {
            if (a < CANT_LISTADO && socios.get(i).getEstadoCivil().equals("Casado") && socios.get(i).getEstudio().equals("Universitario")) {
                /*  aux.setNombre(socios.get(i).getNombre());
              aux.setEdad(socios.get(i).getEdad());
              aux.setClub(socios.get(i).getClub());
              aux.setEstadoCivil(socios.get(i).getEstadoCivil());
              aux.setEstudio(socios.get(i).getEstudio()); */
                sociosCE[a] = socios.get(i);
                //sociosCE.add(socios.get(i));
                a++;
            }

        }

        Arrays.sort(sociosCE);
        for (int i = 0; i < CANT_LISTADO; i++) {
            System.out.println("NOMBRE: " + sociosCE[i].getNombre() + ", EDAD: " + sociosCE[i].getEdad() + ",EQUIPO: " + sociosCE[i].getClub() + ", CONTADOR: " + (i + 1));
        }

//        for(int i =0; i< 100; i++){
        //          System.out.println(sociosCE[i]);
        //   }
    }

    public void cargarClub(String nombreClub) {
        Club club = new Club();
        int edadPromedio = 0;
        int edadMinima = 100;
        int edadMaxima = 0;
        int cantSocios = 0;
        for (int i = 0; i < socios.size(); i++) {
            if (socios.get(i).getClub().equals(nombreClub)) {
                edadPromedio += socios.get(i).getEdad();
                cantSocios++;
                if (edadMinima > socios.get(i).getEdad()) {
                    edadMinima = socios.get(i).getEdad();
                } else if (edadMaxima < socios.get(i).getEdad()) {
                    edadMaxima = socios.get(i).getEdad();
                }
            }
        }
        club.setNombre(nombreClub);
        club.setCantidadSocios(cantSocios);
        club.setPromedioEdad(edadPromedio / cantSocios);
        club.setMenorEdad(edadMinima);
        club.setMayorEdad(edadMaxima);
        clubes.add(club);
    }

    public void ordenarClubes() {
        Collections.sort(clubes);
        for (int i = 0; i < clubes.size(); i++) {
            System.out.println("CLUB: " + clubes.get(i).getNombre() + ", CANTIDAD DE SOCIOS: " + clubes.get(i).getCantidadSocios()
                    + ", PROMEDIO EDAD DE SOCIOS: " + clubes.get(i).getPromedioEdad() + " años , SOCIO MAS JOVEN: " + clubes.get(i).getMenorEdad() + " años , SOCIO MAS ANCIANO: " + clubes.get(i).getMayorEdad() + " años");

        }
    }

    public int promedioEdadRacing() {
        int promedioRacing = 0;
        for (int i = 0; i < clubes.size(); i++) {
            if (clubes.get(i).getNombre().equals("Racing")) {
                promedioRacing = clubes.get(i).getPromedioEdad();
            }
        }
        return promedioRacing;
    }

    public void nombresRiver() {
        Set<String> nombresRiver = new HashSet<String>();
        ArrayList<String> nombresRiverCompletos = new ArrayList();
        int[] cantRepetidos;
        ArrayList<Socio> nombresRepetidos = new ArrayList();
        for (int i = 0; i < socios.size(); i++) {
            if (socios.get(i).getClub().equals("River")) {
                nombresRiver.add(socios.get(i).getNombre());
                nombresRiverCompletos.add(socios.get(i).getNombre());
            }
        }
        
        ArrayList<String> nombresAux = new ArrayList();
        for (String cadena : nombresRiver) {
            nombresAux.add(cadena);
        }
        this.nombresRepetidos(nombresAux, nombresRiverCompletos);

            /*      System.out.println(nombresRiver);
        for(int i = 0;i < nombresRiver.size();i++){
            for(int a = 0; a < nombresRiverCompletos.size(); i++){
                if(nombresRiver.toString())
            }
        }
            
        
        /*for(int i= 0; i < sociosRiver.size();i++){
            contador ++;
            
            System.out.println(sociosRiver.get(i) + "Contador: " + contador);
        }*/
        }
    
    public void nombresRepetidos(ArrayList<String> nombresAux, ArrayList<String> nombresRiverCompletos){
        int contador;
        String nomMasRepetido = "";
        int masRepetido = 0;
        
        for(int y = 0; y < 5 ; y++){
        
          for(int i = 0; i < nombresAux.size(); i++){
            contador = 0;
            for(int a = 0; a < nombresRiverCompletos.size(); a++){
                if(nombresRiverCompletos.get(a).equals(nombresAux.get(i))){
                    contador ++;
                }
            }
 
              if(contador > masRepetido){
              masRepetido = contador;
              nomMasRepetido = nombresAux.get(i);
            }

              
            
            
    }
              nombresAux.remove(nomMasRepetido);
              System.out.println("Nombre: " + nomMasRepetido + ", Se repitio: " + masRepetido + " veces." );
              masRepetido = 0; 
    
    }
    }
    
}
