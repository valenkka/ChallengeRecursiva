package domain;

public class Club implements Comparable<Club>{
    public final String NOMBRE_CLUBES[] = new String[]{"Boca","River","Newells","Racing","Velez","Huracán","Gimnasia LP","Estudiantes","Independiente","Rosario Central","San Lorenzo"};
    private String nombre;
    private int cantidadSocios;
    private int promedioEdad;
    private int menorEdad;
    private int mayorEdad;
    
    
    public Club(){
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadSocios() {
        return cantidadSocios;
    }

    public void setCantidadSocios(int cantidadSocios) {
        this.cantidadSocios = cantidadSocios;
    }

    public int getPromedioEdad() {
        return promedioEdad;
    }

    public void setPromedioEdad(int promedioEdad) {
        this.promedioEdad = promedioEdad;
    }

    public int getMenorEdad() {
        return menorEdad;
    }

    public void setMenorEdad(int menorEdad) {
        this.menorEdad = menorEdad;
    }

    public int getMayorEdad() {
        return mayorEdad;
    }

    public void setMayorEdad(int mayorEdad) {
        this.mayorEdad = mayorEdad;
    }

    @Override
    public String toString() {
        return "Club{" + "nombre=" + nombre + ", cantidadSocios=" + cantidadSocios + ", promedioEdad=" + promedioEdad + ", menorEdad=" + menorEdad + ", mayorEdad=" + mayorEdad + '}';
    }

    @Override
    public int compareTo(Club o) {
           if (this.cantidadSocios < o.cantidadSocios) {
                return -1;
            }
            if (this.cantidadSocios > o.cantidadSocios) {
                return 1;
            }
            return 0;
    }
    
    
}
