package modelo;

import java.util.ArrayList;
import java.util.List;

public class ModeloConstancia implements Sujeto{
    private List<Alumno> alumnos;
    private List<Inscripcion> inscripciones;
    private List<Alumno> coincidentes;
    private Alumno alumnoSeleccionado;
    private Inscripcion inscripcionSeleccionada;
    private Constancia constancia;
    private List<Observador> observadores;

    public ModeloConstancia() {
        alumnos = new ArrayList<>();
        inscripciones = new ArrayList<>();
        coincidentes = new ArrayList<>();
        observadores = new ArrayList<>();
        cargarDatos();
    }

    private void cargarDatos() {
        alumnos.add(new Alumno("000312", "Karem Lizbeth Flores López", "Lic. en contaduria publica"));
        alumnos.add(new Alumno("000345", "Karla Poala Flores López", "Ing. en Software"));
        alumnos.add(new Alumno("000398", "Omar Aristeo Muñoz Álvarez", "Lic. en contaduria publica"));
        alumnos.add(new Alumno("000412", "Marlenne Lizeth Álvarez Soto", "Ing. en Software"));
        alumnos.add(new Alumno("000457", "Edwin Enriquez Armenta", "Ing. Biosistemas"));
        alumnos.add(new Alumno("000501", "Estefania Cazares Gil", "Lic. en contaduria publica"));

        inscripciones.add(new Inscripcion("000312", 5, 6, true));
        inscripciones.add(new Inscripcion("000345", 3, 5, true));
        inscripciones.add(new Inscripcion("000398", 7, 6, true));
        inscripciones.add(new Inscripcion("000412", 1, 7, true));
        inscripciones.add(new Inscripcion("000457", 4, 6, true));
        inscripciones.add(new Inscripcion("000501", 6, 0, false)); // no inscrito
    }

    public void buscarAlumnos(String texto) {
        coincidentes = new ArrayList<>();
        if (texto != null && !texto.isEmpty()) {
            for (Alumno a : alumnos) {
                if (a.getId().contains(texto)) {
                    coincidentes.add(a);
                }
            }
        }
        alumnoSeleccionado = null;
        inscripcionSeleccionada = null;
        constancia = null;
        notificarObservadores();
    }

    public void seleccionarAlumno(String id) {
        alumnoSeleccionado = null;
        inscripcionSeleccionada = null;
        constancia = null;
        for (Alumno a : alumnos) {
            if (a.getId().equals(id)) {
                alumnoSeleccionado = a;
                break;
            }
        }
        for (Inscripcion i : inscripciones) {
            if (i.getIdAlumno().equals(id)) {
                inscripcionSeleccionada = i;
                break;
            }
        }
        notificarObservadores();
    }

    public void generarConstancia() {
        if (alumnoSeleccionado != null && inscripcionSeleccionada != null
                && inscripcionSeleccionada.isVigente()) {
            constancia = new Constancia(alumnoSeleccionado, inscripcionSeleccionada);
        }
        notificarObservadores();
    }

    public List<Alumno> getCoincidentes() { return coincidentes; }
    public Alumno getAlumnoSeleccionado() { return alumnoSeleccionado; }
    public Inscripcion getInscripcionSeleccionada() { return inscripcionSeleccionada; }
    public Constancia getConstancia() { return constancia; }

    @Override
    public void agregarObservador(Observador o) {
        observadores.add(o);
    }

    @Override
    public void quitarObservador(Observador o) {
        observadores.remove(o);
    }

    @Override
    public void notificarObservadores() {
        for (Observador o : observadores) {
            o.actualizar();
        }
    }
}
