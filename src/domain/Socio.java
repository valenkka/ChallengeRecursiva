package domain;

public class Socio implements Comparable<Socio>{
    private String nombre;
    private int edad;
    private String club;
    private String estadoCivil;
    private String estudio;
    
    public Socio(){
        
    }
    
    public Socio(String nombre, int edad, String club, String estadoCivil, String estudio){
    this.nombre = nombre;
    this.edad = edad;
    this.club = club;
    this.estadoCivil = estadoCivil;
    this.estudio = estudio;
}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    @Override
    public String toString() {
        return "Socio{" + "Nombre=" + nombre + ", Edad=" + edad + ", Club=" + club + ", Estado-Civil=" + estadoCivil + ", Estudio=" + estudio + '}';
    }

    @Override
    public int compareTo(Socio o) {
        if (this.edad < o.edad) {
                return -1;
            }
            if (this.edad > o.edad) {
                return 1;
            }
            return 0;
    }
    
    
}
