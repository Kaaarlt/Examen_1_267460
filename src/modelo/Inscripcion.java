package modelo;

public class Inscripcion {
   private String idAlumno;
    private int semestre;
    private int cantidadMaterias;
    private boolean vigente;

    public Inscripcion(String idAlumno, int semestre, int cantidadMaterias, boolean vigente) {
        this.idAlumno = idAlumno;
        this.semestre = semestre;
        this.cantidadMaterias = cantidadMaterias;
        this.vigente = vigente;
    }

    public String getIdAlumno() { return idAlumno; }
    public int getSemestre() { return semestre; }
    public int getCantidadMaterias() { return cantidadMaterias; }
    public boolean isVigente() { return vigente; } 
}
