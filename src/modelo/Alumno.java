package modelo;

public class Alumno {
   private String id;
    private String nombre;
    private String programa;

    public Alumno(String id, String nombre, String programa) {
        this.id = id;
        this.nombre = nombre;
        this.programa = programa;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getPrograma() { return programa; }

    @Override
    public String toString() {
        return id + " - " + nombre;
    } 
}
