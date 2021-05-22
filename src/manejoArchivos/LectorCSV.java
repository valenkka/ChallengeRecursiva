package manejoArchivos;

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

public class LectorCSV {

    public ArrayList<Socio> socios = new ArrayList();

    public void LeerCSV() throws UnsupportedEncodingException {
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
    }

    public int ContadorSocios() {
        int cantidadSocios = 0;
        for (int i = 0; i < socios.size(); i++) {
            cantidadSocios++;
        }
        return cantidadSocios;
    }

    public void Listado() {
        Socio sociosCE[] = new Socio[100];
        final int CANT_LISTADO = 100;
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
        for(int i = 0; i < CANT_LISTADO; i++){
            System.out.println(sociosCE[i] + " SOCIO NUMERO: " + i);
        }
        
        
//        for(int i =0; i< 100; i++){
        //          System.out.println(sociosCE[i]);
        //   }
    }

}
