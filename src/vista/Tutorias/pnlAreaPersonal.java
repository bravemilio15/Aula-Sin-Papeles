/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Tutorias;

import vista.Administracion.*;
import controlador.ControlarEstudiante;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.tabla.ModeloTablaEstudiante;
import vista.utilidades.Utilidades;

/**
 *
 * @author cristian
 */
public class pnlAreaPersonal extends javax.swing.JPanel {

    private ModeloTablaEstudiante modelo = new ModeloTablaEstudiante();
    private ControlarEstudiante control = new ControlarEstudiante();
    private int pos = -1;

    /**
     * Creates new form pnlHome
     */
    public pnlAreaPersonal() {
        initComponents();
    }

   
//    private void mostrarVentas() throws EmptyException, PositionException {
//        int pos = tblUsuarios.getSelectedRow();
//
//        if (pos >= control.getEstudiantes().size()) {
//            throw new EmptyException("La Sucursal no existe");
//        }
//
//        if (pos >= 0) {
//            control.setEstudiante(modelo.getDatos().get(pos));
//            new pnlMatricular(null, true, controlador).setVisible(true);
//            clear();
//        } else {
//            throw new PosicionExcepcion("Seleccione una fila(sucursal)");
//        }
//
//    }
    
//    private void modificarUsuario() {
//        int fila = tblUsuarios.getSelectedRow();
//
//        if (fila < 0) {
//            JOptionPane.showMessageDialog(null, "Seleccione una fila", "Error", JOptionPane.ERROR_MESSAGE);
//        } else {
//            try {
//                Estudiante usuarioAModificar = modelo.getDatos().get(fila);
//                control.setEstudiante(usuarioAModificar);
//                txtNombre.setText(usuarioAModificar.getNombre());
//                txtApellido.setText(usuarioAModificar.getApellido());
//                txtCedula.setText(usuarioAModificar.getCedula());
//                txtCelular.setText(usuarioAModificar.getCelular());
//                txtNacimiento.setText(usuarioAModificar.getNacimiento());
//                cbxGenero.setSelectedItem(usuarioAModificar.getGenero());
//                txtEdad.setText(String.valueOf(usuarioAModificar.getEdad()));
//                txtInstitucional.setText(usuarioAModificar.getCorreoIns());
//                txtPersonal.setText(usuarioAModificar.getCorreoPer());
//                cbxEstado.setSelectedItem(usuarioAModificar.getEstado());
//
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//            }
//        }
//    }
//
//    private Boolean validar() {
//        return (!txtNombre.getText().trim().isEmpty() && !txtApellido.getText().trim().isEmpty() && !txtCedula.getText().trim().isEmpty() && !txtCelular.getText().trim().isEmpty() && !txtNacimiento.getText().trim().isEmpty() && !txtPersonal.getText().trim().isEmpty() && !txtInstitucional.getText().trim().isEmpty()&& !cbxEstado.getSelectedItem().toString().isEmpty());
//
//    }
//
//    public void guardar() {
//        try {
//
//            if (validar()) {
//                String nombre = txtNombre.getText();
//                String apellido = txtApellido.getText();
//                String cedula = txtCedula.getText();
//                String celular = txtCelular.getText();
//                String estado = cbxEstado.getSelectedItem().toString();
//                String nacimiento = txtNacimiento.getText();
//
//                int edad = 0;
//                try {
//                    edad = Integer.parseInt(txtEdad.getText());
//                } catch (NumberFormatException e) {
//                    JOptionPane.showMessageDialog(null, "Ingrese una edad válida", "Error", JOptionPane.ERROR_MESSAGE);
//                    return;
//                }
//                String genero = cbxGenero.getSelectedItem().toString();
//                String correoPer = txtPersonal.getText();
//                String correoIns = txtInstitucional.getText();
//                control.(nombre, apellido, cedula, celular, estado, nacimiento, edad, genero, correoPer, correoIns);
//
//                JOptionPane.showMessageDialog(null, "Estudiante guardado correctamente", "Correcto", JOptionPane.INFORMATION_MESSAGE);
//
//                cargarTabla();
//                limpiar();
//            } else {
//                JOptionPane.showMessageDialog(null, "Llene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
//            }
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(null, "Error al guardar el usuario: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 991, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 437, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
