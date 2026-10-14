package vista;

import controlador.ControladorConstancia;
import javax.swing.DefaultListModel;
import modelo.Alumno;
import modelo.ModeloConstancia;
import modelo.Observador;

public class PanelListaAlumnos extends javax.swing.JPanel implements Observador {

    private DefaultListModel<Alumno> listModel;
    private ModeloConstancia modelo;
    private ControladorConstancia controlador;
    private boolean actualizando = false;
    
    public PanelListaAlumnos(ModeloConstancia modelo, ControladorConstancia controlador) {
        this.modelo = modelo;
        this.controlador = controlador;
        initComponents();
        listModel = new DefaultListModel<>();
        lstAlumnos.setModel(listModel);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollLista = new javax.swing.JScrollPane();
        lstAlumnos = new javax.swing.JList<>();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Alumnos coincidentes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tw Cen MT", 0, 12))); // NOI18N
        setLayout(new java.awt.BorderLayout());

        lstAlumnos.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        lstAlumnos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstAlumnosValueChanged(evt);
            }
        });
        scrollLista.setViewportView(lstAlumnos);

        add(scrollLista, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void lstAlumnosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstAlumnosValueChanged
    if (!evt.getValueIsAdjusting() && !actualizando) {
            Alumno seleccionado = lstAlumnos.getSelectedValue();
            if (seleccionado != null) {
                controlador.alumnoSeleccionado(seleccionado.getId());
            }
        }
    }//GEN-LAST:event_lstAlumnosValueChanged

    @Override
    public void actualizar() {
        actualizando = true;
        if (modelo.getAlumnoSeleccionado() == null) {
            listModel.clear();
            for (Alumno a : modelo.getCoincidentes()) {
                listModel.addElement(a);
            }
        }
        actualizando = false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<Alumno> lstAlumnos;
    private javax.swing.JScrollPane scrollLista;
    // End of variables declaration//GEN-END:variables
}
