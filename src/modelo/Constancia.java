package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Constancia {
   private Alumno alumno;
    private Inscripcion inscripcion;
    private LocalDate fecha;

    public Constancia(Alumno alumno, Inscripcion inscripcion) {
        this.alumno = alumno;
        this.inscripcion = inscripcion;
        this.fecha = LocalDate.now();
    }

    public String generarTexto() {
        String fechaTexto = fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return "       CONSTANCIA DE INSCRIPCIÓN\n"
             + "--------------------------------------------\n\n"
             + "Se hace constar que el(la) alumno(a):\n\n"
             + "   " + alumno.getNombre().toUpperCase() + "\n"
             + "   ID: " + alumno.getId() + "\n"
             + "   Programa: " + alumno.getPrograma() + "\n\n"
             + "se encuentra INSCRITO(A) en el semestre " + inscripcion.getSemestre()
             + "\ncon " + inscripcion.getCantidadMaterias() + " materias.\n\n"
             + "Se expide la presente a solicitud del\ninteresado.\n\n"
             + "Fecha de expedición: " + fechaTexto + "\n";
    } 
}
