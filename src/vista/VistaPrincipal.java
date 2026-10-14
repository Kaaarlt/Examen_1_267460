package vista;

import controlador.ControladorConstancia;
import modelo.ModeloConstancia;

public class VistaPrincipal extends javax.swing.JFrame {

    private ModeloConstancia modelo;
    private ControladorConstancia controlador;
    
     public VistaPrincipal(ModeloConstancia modelo, ControladorConstancia controlador) {
        this.modelo = modelo;
        this.controlador = controlador;
        initComponents();

        modelo.agregarObservador(pnlLista);
        modelo.agregarObservador(pnlDetalle);

        setLocationRelativeTo(null);
    }

    public void mostrar() {
        setVisible(true);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlIzquierda = new javax.swing.JPanel();
        pnlCaptura = new PanelCapturaID(controlador);
        pnlDerecha = new javax.swing.JPanel();
        pnlLista = new PanelListaAlumnos(modelo, controlador);
        pnlDetalle = new PanelDetalle(modelo, controlador);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Generar Constancia de Alumno Inscrito");
        setPreferredSize(new java.awt.Dimension(800, 520));
        getContentPane().setLayout(new java.awt.GridLayout(1, 2, 10, 10));

        pnlIzquierda.setLayout(new java.awt.BorderLayout(5, 5));

        pnlCaptura.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Captura", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tw Cen MT", 0, 12))); // NOI18N
        pnlIzquierda.add(pnlCaptura, java.awt.BorderLayout.NORTH);

        getContentPane().add(pnlIzquierda);

        pnlDerecha.setLayout(new java.awt.GridLayout(2, 1, 0, 5));
        pnlDerecha.add(pnlLista);
        pnlDerecha.add(pnlDetalle);

        getContentPane().add(pnlDerecha);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private vista.PanelCapturaID pnlCaptura;
    private javax.swing.JPanel pnlDerecha;
    private vista.PanelDetalle pnlDetalle;
    private javax.swing.JPanel pnlIzquierda;
    private vista.PanelListaAlumnos pnlLista;
    // End of variables declaration//GEN-END:variables
}
