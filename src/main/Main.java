package main;

import controlador.ControladorConstancia;
import javax.swing.SwingUtilities;
import modelo.ModeloConstancia;
import vista.VistaPrincipal;

public class Main {
  public static void main(String[] args) {
   SwingUtilities.invokeLater(() -> {
     ModeloConstancia modelo = new ModeloConstancia();
     ControladorConstancia controlador = new ControladorConstancia(modelo);
     VistaPrincipal vista = new VistaPrincipal(modelo, controlador);
     vista.mostrar();
        });
    }
}
