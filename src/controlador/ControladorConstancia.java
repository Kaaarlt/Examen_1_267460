package controlador;

import modelo.ModeloConstancia;

public class ControladorConstancia {
     private ModeloConstancia modelo;

    public ControladorConstancia(ModeloConstancia modelo) {
        this.modelo = modelo;
    }

    public void textoIDCambiado(String texto) {
        modelo.buscarAlumnos(texto);
    }

    public void alumnoSeleccionado(String id) {
        modelo.seleccionarAlumno(id);
    }

    public void generarConstancia() {
        modelo.generarConstancia();
    }
}
