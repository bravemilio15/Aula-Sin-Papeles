/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Administracion;

import controlador.ControlarEstudiante;
import controlador.ControlarMatricula;
import controlador.ed.lista.exception.EmptyException;
import controlador.ed.lista.exception.PositionException;
import java.io.IOException;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Matricula;
import modelo.tabla.ModeloTablaEstudiante;
import modelo.tabla.ModeloTablaMatricula;
import vista.utilidades.Utilidades;
import static vista.utilidades.Utilidades.cargarCursosPorCicloEItinerario;

/**
 *
 * @author cristian
 */
public class pnlMatricular extends javax.swing.JPanel {

    private ModeloTablaMatricula modelo = new ModeloTablaMatricula();
    private ControlarMatricula control = new ControlarMatricula();
    private ControlarEstudiante controlE = new ControlarEstudiante();
    private ModeloTablaEstudiante modeloE = new ModeloTablaEstudiante();
    private int pos = -1;

    /**
     * Creates new form pnlHome
     */
    public pnlMatricular() {
        initComponents();
        cargarCombos();
        cargarTablaMatricula();
        desabilitarPanel();

    }

    public void desabilitarPanel() {
        panelMatri.setEnabled(false);
        panelMatri1.setEnabled(false);
        cbxCarrera.setEnabled(false);
        cbxMateria.setEnabled(false);
        btnGuardar.setEnabled(false);
        tblMatricula.setEnabled(false);
        btnModificar.setEnabled(false);
    }

    public void habilitarPanel() {
        panelMatri.setEnabled(true);
        panelMatri1.setEnabled(true);
        cbxCarrera.setEnabled(true);
        cbxMateria.setEnabled(true);
        btnGuardar.setEnabled(true);
        tblMatricula.setEnabled(true);
        btnModificar.setEnabled(true);
    }

    private void cargarTablaEstudiante() {
        modeloE.setDatos(controlE.listar());
        tblEstudiantes.setModel(modelo);
        tblEstudiantes.updateUI();
    }

    private void cargarTablaMatricula() {
        modelo.setDatos(control.listar());
        tblMatricula.setModel(modelo);
        tblMatricula.updateUI();
    }

    private void actualizarTabla() {
        tblEstudiantes.setModel(modeloE);
        tblEstudiantes.updateUI();
    }

    public void buscarBinaria() {

        switch (cbxCriterio.getSelectedItem().toString()) {
            case "Nombre":
                modeloE.setDatos(control.buscarPorNombreBinaria(txtbuscar.getText()));
                limpiar();
                actualizarTabla();
                break;
            case "Cedula":
                modeloE.setDatos(control.buscarPorCedulaBinaria(txtbuscar.getText()));
                limpiar();
                actualizarTabla();
                break;
        }
    }

    private void cargarCombos() {
        Utilidades.cargarCarrera(cbxCarrera);
        Utilidades.cargarExpediente(cbxExpediente);
        Utilidades.cargarGradoAcademico(cbxGrado);
        Utilidades.cargarCriterio(cbxCriterio);
        Utilidades.cargarNumeroMatricula(cbxNumeroMatricula);

    }

    private void limpiar() {
    }

    private Boolean validar() {
        return (!cbxCarrera.getSelectedItem().toString().isEmpty() && !cbxMateria.getSelectedItem().toString().isEmpty());

    }

    private void modificarUsuario() {
        int fila = tblMatriculas.getSelectedRow();

        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                Matricula usuarioAModificar = modelo.getDatos().get(fila);
                cbxCarrera.setSelectedItem(usuarioAModificar.getCarrera());
                cbxExpediente.setSelectedItem(usuarioAModificar.getEstado());
                cbxMateria.setSelectedItem(usuarioAModificar.getNivel_academico());

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

//    public void guardar() {
//        try {
//
//            if (validar()) {
//                String carrera = cbxCarrera.getSelectedItem().toString();
//                String expediente = cbxExpediente.getSelectedItem().toString();
//                String grado = cbxGrado.getSelectedItem().toString();
//                control.guardarMatricula(carrera, expediente, grado);
//                desabilitarPanel();
//                JOptionPane.showMessageDialog(null, "Docente guardado correctamente", "Correcto", JOptionPane.INFORMATION_MESSAGE);
//
//                cargarTablaMatricula();
//                limpiar();
//                
//            } else {
//                JOptionPane.showMessageDialog(null, "Llene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
//            }
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(null, "Error al guardar el usuario: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//        }
//        
//    }
    private void guardar() throws EmptyException, PositionException, IOException {
//        double valor = Double.parseDouble(txtValor.getText());
        String carrera = cbxCarrera.getSelectedItem().toString();
        String estado = cbxExpediente.getSelectedItem().toString();
        String nivel = cbxMateria.getSelectedItem().toString();

        if (pos >= 0 && pos < controlE.getEstudiante().getMatriculas().size()) {
            controlE.guardarMatricula(pos, carrera, estado, nivel);
        }
        cargarTablaMatricula();
        limpiar();
    }

    private void mostrarEstudiante() throws EmptyException, PositionException {
        int pos = tblEstudiantes.getSelectedRow();

        if (pos >= controlE.getEstudiantes().size()) {
            throw new EmptyException("El estudiante no existe");
        }

        if (pos >= 0) {
            controlE.setEstudiante(modeloE.getDatos().get(pos));
            habilitarPanel();
            limpiar();
        } else {
            throw new PositionException("Seleccione una fila(estudiante)");
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblMatriculas = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbCriterio = new javax.swing.JLabel();
        cbxCriterio = new javax.swing.JComboBox<>();
        txtbuscar = new javax.swing.JTextField();
        btnBinaria = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblEstudiantes = new javax.swing.JTable();
        btnMatricula = new javax.swing.JButton();
        panelMatri = new javax.swing.JPanel();
        panelMatri1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbxCarrera = new javax.swing.JComboBox<>();
        cbxMateria = new javax.swing.JComboBox<>();
        cbxNumeroMatricula = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbxGrado = new javax.swing.JComboBox<>();
        cbxExpediente = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cbxItinerarioSelec = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbxItinerario = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMatricula = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();

        tblMatriculas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblMatriculas);

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Busqueda de estudiante"));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lbCriterio.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        lbCriterio.setText("Buscar por:");

        cbxCriterio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnBinaria.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        btnBinaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        btnBinaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBinariaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lbCriterio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 194, Short.MAX_VALUE)
                .addComponent(btnBinaria)
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBinaria)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbCriterio)
                        .addComponent(cbxCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblEstudiantes);

        btnMatricula.setText("Asignar Matricula");
        btnMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatriculaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnMatricula)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(btnMatricula)
                .addContainerGap())
        );

        panelMatri.setBorder(javax.swing.BorderFactory.createTitledBorder("Asignar Matricula"));

        panelMatri1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel3.setText("Carrera");

        jLabel4.setText("Estado");

        jLabel5.setText("Nivel Academico");

        cbxCarrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxMateria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxNumeroMatricula.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Matricula");

        cbxGrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxExpediente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("Materia");

        cbxItinerarioSelec.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setText("Itinerario");

        cbxItinerario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout panelMatri1Layout = new javax.swing.GroupLayout(panelMatri1);
        panelMatri1.setLayout(panelMatri1Layout);
        panelMatri1Layout.setHorizontalGroup(
            panelMatri1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMatri1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelMatri1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMatri1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMatri1Layout.createSequentialGroup()
                        .addGroup(panelMatri1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxNumeroMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(panelMatri1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMatri1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(cbxMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(cbxItinerario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbxItinerarioSelec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelMatri1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(cbxGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbxExpediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelMatri1Layout.createSequentialGroup()
                        .addGap(315, 315, 315)
                        .addComponent(jLabel9)))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        panelMatri1Layout.setVerticalGroup(
            panelMatri1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMatri1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMatri1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMatri1Layout.createSequentialGroup()
                        .addGroup(panelMatri1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbxCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(cbxGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxExpediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelMatri1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(cbxNumeroMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMatri1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(cbxMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(cbxItinerario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbxItinerarioSelec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        tblMatricula.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblMatricula);

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGuardar.setText("Matricular");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMatriLayout = new javax.swing.GroupLayout(panelMatri);
        panelMatri.setLayout(panelMatriLayout);
        panelMatriLayout.setHorizontalGroup(
            panelMatriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMatriLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnModificar)
                .addGap(18, 18, 18)
                .addComponent(btnGuardar)
                .addGap(29, 29, 29))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMatriLayout.createSequentialGroup()
                .addGroup(panelMatriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelMatri1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        panelMatriLayout.setVerticalGroup(
            panelMatriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMatriLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelMatri1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMatriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar)
                    .addComponent(btnGuardar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelMatri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelMatri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        try {
            guardar();
        } catch (EmptyException ex) {
            Logger.getLogger(pnlMatricular.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PositionException ex) {
            Logger.getLogger(pnlMatricular.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(pnlMatricular.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBinariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBinariaActionPerformed
        // TODO add your handling code here:
        buscarBinaria();
        limpiar();
    }//GEN-LAST:event_btnBinariaActionPerformed

    private void btnMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatriculaActionPerformed

        try {
            mostrarEstudiante();
        } catch (EmptyException ex) {
            Logger.getLogger(pnlMatricular.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PositionException ex) {
            Logger.getLogger(pnlMatricular.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnMatriculaActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        habilitarPanel();
    }//GEN-LAST:event_btnModificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBinaria;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnMatricula;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cbxCarrera;
    private javax.swing.JComboBox<String> cbxCriterio;
    private javax.swing.JComboBox<String> cbxExpediente;
    private javax.swing.JComboBox<String> cbxGrado;
    private javax.swing.JComboBox<String> cbxItinerario;
    private javax.swing.JComboBox<String> cbxItinerarioSelec;
    private javax.swing.JComboBox<String> cbxMateria;
    private javax.swing.JComboBox<String> cbxNumeroMatricula;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbCriterio;
    private javax.swing.JPanel panelMatri;
    private javax.swing.JPanel panelMatri1;
    private javax.swing.JTable tblEstudiantes;
    private javax.swing.JTable tblMatricula;
    private javax.swing.JTable tblMatriculas;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}
