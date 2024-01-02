/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Administracion;

import controlador.ControlMateria;
import controlador.ControlarMatricula;
import controlador.dao.CicloDAO;
import controlador.ed.lista.exception.EmptyException;
import controlador.ed.lista.exception.PositionException;
import controlador.ed.lista.exception.VacioException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Ciclo;
import modelo.tabla.ModeloTablaCiclo;
import modelo.tabla.ModeloTablaMateria;
import vista.utilidades.Utilidades;

/**
 *
 * @author cristian
 */
public class pnlConfiguracion extends javax.swing.JPanel {

    CicloDAO cd = new CicloDAO();
    ControlMateria cm = new ControlMateria();
    ModeloTablaCiclo modeloC = new ModeloTablaCiclo();
    ModeloTablaMateria modeloM = new ModeloTablaMateria();

    public pnlConfiguracion() {
        initComponents();
        Limpiar();
    }

    public void CargarCiclos() {
        modeloC.setDatos(cd.listar());
        tblCiclo.setModel(modeloC);
        tblCiclo.updateUI();
    }

    public void CargarMaterias() {
        modeloM.setDatos(cm.getMateriaDao().listar());
        tblMaterias.setModel(modeloM);
        tblMaterias.updateUI();
    }

    public void CargarRoles() {

    }

    public void cargarCombos() {
        try {
            Utilidades.cargarCiclosDisponibles(cbxCiclos);
            cbxCiclos.updateUI();
        } catch (VacioException ex) {
            Logger.getLogger(pnlConfiguracion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EmptyException ex) {
            Logger.getLogger(pnlConfiguracion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PositionException ex) {
            Logger.getLogger(pnlConfiguracion.class.getName()).log(Level.SEVERE, null, ex);
        }

        Utilidades.cargarCategoria(cbxCategoria);

    }

    public void Limpiar() {
        txtNombreCiclo.setText("");
        txtDuracionCiclo.setText("");
        txtNombreMaterias.setText("");
        cbxCategoria.setSelectedIndex(0);
        cbxCiclos.setSelectedIndex(0);
        CargarCiclos();
        CargarMaterias();
        CargarRoles();
        cargarCombos();
    }

    public void GuardarCiclos() throws IOException {

        if (validarCiclo()) {
            cd.getCiclo().setNombre_ciclo(txtNombreCiclo.getText());
            cd.getCiclo().setDuracion(Integer.parseInt(txtDuracionCiclo.getText()));
            cd.guardar();
            Limpiar();

        } else {
            JOptionPane.showMessageDialog(null,
                    "Por favor, complete todos los campos antes de guardar.",
                    "Error", JOptionPane.ERROR_MESSAGE);

        }

    }

    public void guardarMaterias() throws IOException, EmptyException, PositionException {
        if (validarMaterias()) {
            String nombreCicloSeleccionado = (String) cbxCiclos.getSelectedItem();
            Ciclo cicloSeleccionado = cd.obtenerCicloPorNombre(nombreCicloSeleccionado);

            if (cicloSeleccionado != null) {
                cm.guardarMateria(txtNombreMaterias.getText(),
                        cbxCategoria.getSelectedItem().toString(),
                        cicloSeleccionado.getId());
                Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Ciclo no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Por favor, complete todos los campos antes de guardar.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Boolean validarCiclo() {
        return (!txtNombreCiclo.getText().trim().isEmpty()
                && !txtDuracionCiclo.getText().trim().isEmpty());
    }

    public Boolean validarMaterias() {
        return (!txtNombreMaterias.getText().trim().isEmpty()
                && cbxCategoria.getSelectedItem() != null
                && !cbxCategoria.getSelectedItem().toString().isEmpty()
                && cbxCiclos.getSelectedItem() != null
                && !cbxCiclos.getSelectedItem().toString().isEmpty());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombreCiclo = new javax.swing.JTextField();
        txtDuracionCiclo = new javax.swing.JTextField();
        btnGuardarCiclo = new javax.swing.JButton();
        btnModificarCiclo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCiclo = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtNombreMaterias = new javax.swing.JTextField();
        btnGuardarMaterias = new javax.swing.JButton();
        btnModificarMaterias = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cbxCategoria = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbxCiclos = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMaterias = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CREAR CICLOS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N

        jLabel1.setText("Nombre:");

        jLabel2.setText("Duracion:");

        btnGuardarCiclo.setText("Guardar");
        btnGuardarCiclo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCicloActionPerformed(evt);
            }
        });

        btnModificarCiclo.setText("Modificar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(txtNombreCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtDuracionCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnModificarCiclo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGuardarCiclo)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombreCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtDuracionCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificarCiclo)
                    .addComponent(btnGuardarCiclo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblCiclo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblCiclo);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CREAR MATERIAS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N

        jLabel3.setText("Nombre:");

        txtNombreMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreMateriasActionPerformed(evt);
            }
        });

        btnGuardarMaterias.setText("Guardar");
        btnGuardarMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarMateriasActionPerformed(evt);
            }
        });

        btnModificarMaterias.setText("Modificar");

        jLabel4.setText("Categoria");

        cbxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Basica", "Itinerario IA", "Itinerario Software", "Itinerario Aplicaciones" }));

        jLabel5.setText("Ciclo");

        cbxCiclos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxCiclos, 0, 125, Short.MAX_VALUE)
                    .addComponent(txtNombreMaterias))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(cbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(btnModificarMaterias)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGuardarMaterias)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombreMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnModificarMaterias)
                        .addComponent(btnGuardarMaterias))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(cbxCiclos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblMaterias);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(218, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarCicloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCicloActionPerformed
        try {
            GuardarCiclos();
        } catch (IOException ex) {
            Logger.getLogger(pnlConfiguracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGuardarCicloActionPerformed

    private void btnGuardarMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarMateriasActionPerformed
        try {
            guardarMaterias();
        } catch (IOException ex) {
            Logger.getLogger(pnlConfiguracion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EmptyException ex) {
            Logger.getLogger(pnlConfiguracion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PositionException ex) {
            Logger.getLogger(pnlConfiguracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGuardarMateriasActionPerformed

    private void txtNombreMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreMateriasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreMateriasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarCiclo;
    private javax.swing.JButton btnGuardarMaterias;
    private javax.swing.JButton btnModificarCiclo;
    private javax.swing.JButton btnModificarMaterias;
    private javax.swing.JComboBox<String> cbxCategoria;
    private javax.swing.JComboBox<String> cbxCiclos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblCiclo;
    private javax.swing.JTable tblMaterias;
    private javax.swing.JTextField txtDuracionCiclo;
    private javax.swing.JTextField txtNombreCiclo;
    private javax.swing.JTextField txtNombreMaterias;
    // End of variables declaration//GEN-END:variables
}
