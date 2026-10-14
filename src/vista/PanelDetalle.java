package vista;

import controlador.ControladorConstancia;
import modelo.Alumno;
import modelo.Inscripcion;
import modelo.ModeloConstancia;
import modelo.Observador;

public class PanelDetalle extends javax.swing.JPanel implements Observador {

    private ModeloConstancia modelo;
    private ControladorConstancia controlador;
    
    public PanelDetalle(ModeloConstancia modelo, ControladorConstancia controlador) {
        this.modelo = modelo;
        this.controlador = controlador;
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollDetalle = new javax.swing.JScrollPane();
        txtDetalle = new javax.swing.JTextArea();
        btnGenerar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de Confirmación / Constancia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tw Cen MT", 0, 12))); // NOI18N
        setLayout(new java.awt.BorderLayout());

        txtDetalle.setEditable(false);
        txtDetalle.setColumns(20);
        txtDetalle.setFont(new java.awt.Font("Monospaced", 0, 13)); // NOI18N
        txtDetalle.setRows(5);
        scrollDetalle.setViewportView(txtDetalle);

        add(scrollDetalle, java.awt.BorderLayout.CENTER);

        btnGenerar.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        btnGenerar.setText("Generar Constancia");
        btnGenerar.setEnabled(false);
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });
        add(btnGenerar, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
    controlador.generarConstancia();
    }//GEN-LAST:event_btnGenerarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerar;
    private javax.swing.JScrollPane scrollDetalle;
    private javax.swing.JTextArea txtDetalle;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actualizar() {
      if (modelo.getConstancia() != null) {
            mostrarConstancia();
        } else if (modelo.getAlumnoSeleccionado() != null) {
            mostrarDatosConfirmacion();
        } else {
            txtDetalle.setText("");
            btnGenerar.setEnabled(false);
        }
    }
    
    private void mostrarDatosConfirmacion() {
        Alumno a = modelo.getAlumnoSeleccionado();
        Inscripcion i = modelo.getInscripcionSeleccionada();
        StringBuilder sb = new StringBuilder();
        sb.append("DATOS DE CONFIRMACIÓN\n");
        sb.append("----------------------------------------------\n");
        sb.append("ID:        ").append(a.getId()).append("\n");
        sb.append("Nombre:    ").append(a.getNombre()).append("\n");
        sb.append("Programa:  ").append(a.getPrograma()).append("\n");
        if (i != null && i.isVigente()) {
            sb.append("Semestre:  ").append(i.getSemestre()).append("\n");
            sb.append("Materias:  ").append(i.getCantidadMaterias()).append("\n");
            btnGenerar.setEnabled(true);
        } else {
            sb.append("\nEl alumno NO está inscrito en el semestre vigente.\n");
            sb.append("No es posible generar la constancia.\n");
            btnGenerar.setEnabled(false);
        }
        txtDetalle.setText(sb.toString());
        txtDetalle.setText(sb.toString());
        txtDetalle.setCaretPosition(0);
    }

    private void mostrarConstancia() {
        txtDetalle.setText(modelo.getConstancia().generarTexto());
        txtDetalle.setCaretPosition(0); 
        btnGenerar.setEnabled(false);
    }
    
}
