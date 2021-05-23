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

    public void leerCSV() throws UnsupportedEncodingException { //con este procedimiento cargamos los datos del csv en la clase Socios y Club
        String archivo = "src\\socios.csv";
        String linea = "";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(archivo), "ISO-8859-1"));
            try {
                while ((linea = br.readLine()) != null) {
                    String[] columnas = linea.split(";");
                    Socio socio = new Socio(columnas[0], parseInt(columnas[1]), columnas[2], columnas[3], columnas[4]);  //aca se ingresan los datos de cada socio , dividiendolos por columnas
                    socios.add(socio);  //se agrega el socio creado al array que los va a guardar a todos
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        Club club = new Club();
        for (int i = 0; i < club.NOMBRE_CLUBES.length; i++) { // usamos la constante para iterar
            this.cargarClub(club.NOMBRE_CLUBES[i]);//desde esta parte cargamos los datos de los clubes , llamando a la funcion
        }

    }

    public int contadorSocios() { //aca se cuenta cuantos socios hay en el archivo csv
        int cantidadSocios = 0;
        for (int i = 0; i < socios.size(); i++) {
            cantidadSocios++;
        }
        return cantidadSocios;
    }

    public void listado() { //lista los 100 primeros socios con estudios universitarios y casados
        final int CANT_LISTADO = 100;
        Socio sociosCE[] = new Socio[CANT_LISTADO];
        int a = 0;
        for (int i = 0; i < socios.size(); i++) {
            if (a < CANT_LISTADO && socios.get(i).getEstadoCivil().equals("Casado") && socios.get(i).getEstudio().equals("Universitario")) {
                sociosCE[a] = socios.get(i);
                a++;
            }

        }

        Arrays.sort(sociosCE); //ordena los socios de menor a mayor segun la edad
        for (int i = 0; i < CANT_LISTADO; i++) {
            System.out.println("NOMBRE: " + sociosCE[i].getNombre() + ", EDAD: " + sociosCE[i].getEdad() + ",EQUIPO: " + sociosCE[i].getClub() + ", CONTADOR: " + (i + 1));
        }
    }

    public void cargarClub(String nombreClub) { //cargamos el club , es llamada por el procedimiento leerCSV 
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
        club.setNombre(nombreClub); //cargamos los datos del club
        club.setCantidadSocios(cantSocios);
        club.setPromedioEdad(edadPromedio / cantSocios);
        club.setMenorEdad(edadMinima);
        club.setMayorEdad(edadMaxima);
        clubes.add(club);
    }

    public void ordenarClubes() { //ordena los clubes de menor a mayor segun la cantidad de los socios
        Collections.sort(clubes);
        for (int i = 0; i < clubes.size(); i++) {
            System.out.println("CLUB: " + clubes.get(i).getNombre() + ", CANTIDAD DE SOCIOS: " + clubes.get(i).getCantidadSocios()
                    + ", PROMEDIO EDAD DE SOCIOS: " + clubes.get(i).getPromedioEdad() + " años , SOCIO MAS JOVEN: " + clubes.get(i).getMenorEdad() + " años , SOCIO MAS ANCIANO: " + clubes.get(i).getMayorEdad() + " años");

        }
    }

    public int promedioEdadRacing() { //saca el promedio de la edad de los socios de racing 
        int promedioRacing = 0;
        for (int i = 0; i < clubes.size(); i++) {
            if (clubes.get(i).getNombre().equals("Racing")) {
                promedioRacing = clubes.get(i).getPromedioEdad();
            }
        }
        return promedioRacing;
    }

    public void nombresRiver() { //obtengo una sola ves los diferentes nombres que tienen los socios de river (usando un set que no guarda duplicados)
        Set<String> nombresRiver = new HashSet<String>();
        ArrayList<String> nombresRiverCompletos = new ArrayList();
        for (int i = 0; i < socios.size(); i++) {
            if (socios.get(i).getClub().equals("River")) {
                nombresRiver.add(socios.get(i).getNombre());
                nombresRiverCompletos.add(socios.get(i).getNombre());
            }
        }
        ArrayList<String> nombresAux = new ArrayList<>(nombresRiver); //pasamos el set a un arrayList para obtener los datos con un get
        this.nombresRepetidos(nombresAux, nombresRiverCompletos); //llama al procedimiento para saber que nombres se repitieron mas
    }

    public void nombresRepetidos(ArrayList<String> nombresAux, ArrayList<String> nombresRiverCompletos) { //muestra los 5 nombres que mas se repitieron , con la cantidad de veces
        int contador;
        String nomMasRepetido = "";
        int masRepetido = 0;
        for (int y = 0; y < 5; y++) { //lo repite 5 veces asi muestra solo los 5 mas repetidos
            for (int i = 0; i < nombresAux.size(); i++) {
                contador = 0;
                for (int a = 0; a < nombresRiverCompletos.size(); a++) {
                    if (nombresRiverCompletos.get(a).equals(nombresAux.get(i))) {
                        contador++;
                    }
                }
                if (contador > masRepetido) {
                    masRepetido = contador;
                    nomMasRepetido = nombresAux.get(i);
                }
            }
            nombresAux.remove(nomMasRepetido);//se borra el nombre mas repetido asi busca el que le sigue
            System.out.println("Nombre: " + nomMasRepetido + ", Se repitio: " + masRepetido + " veces.");
            masRepetido = 0;
        }
    }
}
