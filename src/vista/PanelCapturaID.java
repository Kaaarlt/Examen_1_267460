package vista;

import controlador.ControladorConstancia;

public class PanelCapturaID extends javax.swing.JPanel {

    
    private ControladorConstancia controlador;
    
    public PanelCapturaID (ControladorConstancia controlador) {
        this.controlador = controlador;
        initComponents();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Captura", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tw Cen MT", 0, 12))); // NOI18N
        setLayout(new java.awt.BorderLayout(5, 0));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel1.setText("ID del alumno: ");
        add(jLabel1, java.awt.BorderLayout.WEST);

        txtID.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        txtID.setPreferredSize(new java.awt.Dimension(28, 26));
        txtID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIDKeyReleased(evt);
            }
        });
        add(txtID, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyReleased
    controlador.textoIDCambiado(txtID.getText().trim());
    }//GEN-LAST:event_txtIDKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}
