package modelo;

public interface Sujeto {
    void agregarObservador(Observador o);
    void quitarObservador(Observador o);
    void notificarObservadores();
}
