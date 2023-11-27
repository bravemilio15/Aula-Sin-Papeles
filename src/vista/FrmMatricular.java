/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista;

import controlador.Control;
import controlador.ControlMateria;
import controlador.ControlMateriaItinerario;
import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.EmptyException;
import controlador.ed.lista.exception.PositionException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelo.tabla.ModeloTablaEstudiante;
import modelo.tabla.ModeloTablaMateria;
import modelo.tabla.ModeloTablaMateriaItinerario;
import vista.utilidades.Utilidades;


public class FrmMatricular extends javax.swing.JDialog {

    private ModeloTablaEstudiante modelo = new ModeloTablaEstudiante();
    private ModeloTablaMateria modeloM = new ModeloTablaMateria();
    private ModeloTablaMateriaItinerario modeloMI = new ModeloTablaMateriaItinerario();
    private Control control = new Control();
    private ControlMateria controlM = new ControlMateria();
    private ControlMateriaItinerario controlMI = new ControlMateriaItinerario();
    private ListaEnlazada<JComboBox<String>> combos;
    private ListaEnlazada<JComboBox<String>> combosIntinerarios;

    /**
     * Creates new form FrmMatricular
     */
    public FrmMatricular(java.awt.Frame parent, boolean modal, String nombre, String apellido, String cedula, String rol) {
        super(parent, modal);
        initComponents();
          pack();
        setLocationRelativeTo(null);
        cargarTabla();
        cargarTablaMateria();
        cargarTablaItinerario();
//        cargarTablaItinerario();
        // txtNombre.setText(control.getUsuario().getUsuario().getNombre());

        cbxCiclo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxCicloItemStateChanged(evt);
            }
        });

        combos = new ListaEnlazada<>();
        combos.insertar(cbxPrimero);
        combos.insertar(cbxSegundo);
        combos.insertar(cbxTercero);
        combos.insertar(cbxCuarto);
        combos.insertar(cbxQuinto);
        combos.insertar(cbxSexto);
        combos.insertar(cbxSeptimo);
        combos.insertar(cbxArtificial);
        combos.insertar(cbxSofware);
        combos.insertar(cbxAplicada);
        combos.insertar(cbxOctavo);
        combos.insertar(cbxArtificialOc);
        combos.insertar(cbxSofwareOc);
        combos.insertar(cbxAplicadaOc);
        combos.insertar(cbxNoveno);

        // Inicializa los checkboxes y combos
        initCheckBoxesAndCombos();

        cargarCombos();
        deshabilitarCombosMaterias();
        deshabilitarCombosItinerarios();
        lblNombre.setText(nombre);
        lblApellido.setText(apellido);
        lblCedula.setText(cedula);
        lblRol.setText(rol);
    }

    private void initCheckBoxesAndCombos() {
        cbxArtificial.setEnabled(false);
        cbxSofware.setEnabled(false);
        cbxAplicada.setEnabled(false);
        cbxArtificialOc.setEnabled(false);
        cbxSofwareOc.setEnabled(false);
        cbxAplicadaOc.setEnabled(false);
        // Desactiva los checkboxes también
        checkArtificial.setEnabled(false);
        checkSofware.setEnabled(false);
        checkAplicada.setEnabled(false);
    }

    private void deshabilitarCombosMaterias() {
        cbxPrimero.setEnabled(false);
        cbxSegundo.setEnabled(false);
        cbxTercero.setEnabled(false);
        cbxCuarto.setEnabled(false);
        cbxQuinto.setEnabled(false);
        cbxSexto.setEnabled(false);
        cbxSeptimo.setEnabled(false);
        cbxOctavo.setEnabled(false);
        cbxNoveno.setEnabled(false);
    }

    private void habilitarCombosMaterias() {
        deshabilitarCombosMaterias();
        String cicloSeleccionado = cbxCiclo.getSelectedItem().toString();
        switch (cicloSeleccionado) {
            case "Primero":
                cbxPrimero.setEnabled(true);
                break;
            case "Segundo":
                cbxSegundo.setEnabled(true);
                break;
            case "Tercero":
                cbxTercero.setEnabled(true);
                break;
            case "Cuarto":
                cbxCuarto.setEnabled(true);
                break;
            case "Quinto":
                cbxQuinto.setEnabled(true);
                break;
            case "Sexto":
                cbxSexto.setEnabled(true);
                break;
            case "Septimo":
                cbxSeptimo.setEnabled(true);
                break;
            case "Octavo":
                cbxOctavo.setEnabled(true);
                break;
            case "Noveno":
                cbxNoveno.setEnabled(true);
                break;
            default:
                break;
        }
    }

//    private void limpiar() {
//        txtNombre.setText("");
//        txtApellido.setText("");
//        txtCedula.setText("");
//    }
    private void cargarTabla() {
        modelo.setDatos(control.listarE());
        tblEstudiante.setModel(modelo);
        tblEstudiante.updateUI();
    }

    private void cargarTablaMateria() {
        modeloM.setDatos(controlM.listar());
        tblMateria.setModel(modeloM);
        tblMateria.updateUI();
    }
    
      private void cargarTablaItinerario() {
        modeloMI.setDatos(controlMI.listar());
        tblItinerarios.setModel(modeloMI);
        tblItinerarios.updateUI();
    }

    private void actualizarTabla() {
        tblEstudiante.setModel(modelo);
        tblEstudiante.updateUI();
    }

    private void cargarCombos() {
        Utilidades.cargarModalidad(cbxModalidad);
        Utilidades.cargarCiclos(cbxCiclo);
        Utilidades.cargarJornada(cbxJornada);
        Utilidades.cargarParalelo(cbxParalelo);
        Utilidades.cargarPrimero(cbxPrimero);
        Utilidades.cargarSegundo(cbxSegundo);
        Utilidades.cargarTercero(cbxTercero);
        Utilidades.cargarCuarto(cbxCuarto);
        Utilidades.cargarQuinto(cbxQuinto);
        Utilidades.cargarSexto(cbxSexto);
        Utilidades.cargarSeptimo(cbxSeptimo);
        Utilidades.cargarSeptimoIA(cbxArtificial);
        Utilidades.cargarSeptimoSof(cbxSofware);
        Utilidades.cargarSeptimoApli(cbxAplicada);
        Utilidades.cargarOctavo(cbxOctavo);
        Utilidades.cargarOctavoIA(cbxArtificialOc);
        Utilidades.cargarOctavoSof(cbxSofwareOc);
        Utilidades.cargarOctavoApli(cbxAplicadaOc);
        Utilidades.cargarNoveno(cbxNoveno);

    }

    private void deshabilitarCombosItinerarios() {
        cbxArtificial.setEnabled(false);
        cbxSofware.setEnabled(false);
        cbxAplicada.setEnabled(false);
        cbxArtificialOc.setEnabled(false);
        cbxSofwareOc.setEnabled(false);
        cbxAplicadaOc.setEnabled(false);
    }

    private void habilitarCombosItinerarios() {
        deshabilitarCombosItinerarios();
        String cicloSeleccionado = cbxCiclo.getSelectedItem().toString().toLowerCase();
        if (cicloSeleccionado.equals("septimo")) {
            cbxArtificial.setEnabled(true);
            cbxSofware.setEnabled(true);
            cbxAplicada.setEnabled(true);
        } else if (cicloSeleccionado.equals("octavo")) {
            cbxArtificialOc.setEnabled(true);
            cbxSofwareOc.setEnabled(true);
            cbxAplicadaOc.setEnabled(true);
        }
    }

    private Boolean validarEstudiante() {
        return (!lblNombre.getText().trim().isEmpty() && !lblApellido.getText().trim().isEmpty() && !lblCedula.getText().trim().isEmpty() && !cbxParalelo.getSelectedItem().toString().isEmpty() && !cbxCiclo.getSelectedItem().toString().isEmpty() && !cbxJornada.getSelectedItem().toString().isEmpty() && !cbxModalidad.getSelectedItem().toString().isEmpty());

    }

    private Boolean validarMateria() {
        return (!lblNombre.getText().trim().isEmpty());

    }

    public void guardarEstudiante() {
        try {
            if (validarEstudiante()) {
                control.guardarEstudiante(lblNombre.getText(), lblApellido.getText(), lblCedula.getText(), cbxParalelo.getSelectedItem().toString(), cbxCiclo.getSelectedItem().toString(), cbxJornada.getSelectedItem().toString(), cbxModalidad.getSelectedItem().toString());
                JOptionPane.showMessageDialog(null, "Estudiante guardado correctamente", "Correcto", JOptionPane.INFORMATION_MESSAGE);
                cargarTabla();
                //limpiar();
                habilitarCombosMaterias();
                habilitarCombosItinerarios();
            } else {
                JOptionPane.showMessageDialog(null, "Llene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar el estudiante: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void guardarMateriasCiclo() {
        try {
            if (validarMateria()) {
                controlM.guardarMateria(txtMateria.getText(), cbxCiclo.getSelectedItem().toString());
                JOptionPane.showMessageDialog(null, "Materia guardado ", "Correcto", JOptionPane.INFORMATION_MESSAGE);
                cargarTablaMateria();
                //limpiar();
                habilitarCombosMaterias();
                habilitarCombosItinerarios();
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una materia", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar el materia: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void guardarMateriasItinerario() {
        try {
            if (validarMateria()) {
                controlMI.guardarMateria(txtItinerario.getText(), cbxCiclo.getSelectedItem().toString());
                JOptionPane.showMessageDialog(null, "Materia guardado ", "Correcto", JOptionPane.INFORMATION_MESSAGE);
             cargarTablaItinerario();
                //limpiar();
                habilitarCombosMaterias();
                habilitarCombosItinerarios();
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una materia", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar el materia: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarMateriaSeleccionada() throws EmptyException, PositionException {
        for (int i = 0; i < combos.size(); i++) {
            JComboBox<String> combo = combos.get(i);
            if (combo.isEnabled()) {
                String seleccion = combo.getSelectedItem().toString();
                txtMateria.setText(seleccion);
                break;
            }
        }
    }

    private void cargarMateriaSeleccionadaItinerario() {
        try {
            // Itera sobre los combos de itinerarios y verifica si están habilitados
            for (JComboBox<String> combo : Arrays.asList(cbxArtificial, cbxSofware, cbxAplicada,
                    cbxArtificialOc, cbxSofwareOc, cbxAplicadaOc)) {
                System.out.println("Combo: " + combo.getName());
                System.out.println("Habilitado: " + combo.isEnabled());
                System.out.println("Seleccionado: " + combo.getSelectedIndex());

                if (combo.isEnabled() && combo.getSelectedIndex() != -1) {
                    txtItinerario.setText(combo.getSelectedItem().toString());
                    return;  // Sale del bucle si encuentra un combo válido
                }
            }

            // Si no se encontró ningún combo válido, puedes manejar este caso según tus necesidades
            System.out.println("Ningún combo de itinerario seleccionado");
        } catch (Exception ex) {
            ex.printStackTrace();
            // Manejar la excepción según tus necesidades
        }
    }

    private void cbxCicloItemStateChanged(java.awt.event.ItemEvent evt) {
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
            String selectedCiclo = cbxCiclo.getSelectedItem().toString().toLowerCase();

            // Deshabilitar checkboxes y combos al principio
            checkArtificial.setEnabled(false);
            checkSofware.setEnabled(false);
            checkAplicada.setEnabled(false);
            cbxArtificial.setEnabled(false);
            cbxSofware.setEnabled(false);
            cbxAplicada.setEnabled(false);

            // Habilitar checkboxes según el ciclo seleccionado
            if (selectedCiclo.equals("septimo") || selectedCiclo.equals("octavo")) {
                checkArtificial.setEnabled(true);
                checkSofware.setEnabled(true);
                checkAplicada.setEnabled(true);
            }
        }
    }

//private void cargarSeleccionItinerario() throws EmptyException, PositionException {
//    for (int i = 0; i < combosIntinerarios.size(); i++) {
//        JComboBox<String> combo = combos.get(i);
//        if (combo.isEnabled()) {
//            String seleccion = combo.getSelectedItem().toString();
//
//            // Lógica específica para los combos de itinerarios
//            if (combo == cbxArtificial || combo == cbxArtificialOc ||
//                combo == cbxSofware || combo == cbxSofwareOc ||
//                combo == cbxAplicada || combo == cbxAplicadaOc) {
//                txtItinerario.setText(seleccion);
//                break;
//            }
//
//            // Lógica para los demás combos
//            txtMateria.setText(seleccion);
//            break;
//        }
//    }
//}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        lblCedula = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbxCiclo = new javax.swing.JComboBox<>();
        cbxJornada = new javax.swing.JComboBox<>();
        cbxParalelo = new javax.swing.JComboBox<>();
        lblRol = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbxModalidad = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEstudiante = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        cbxSegundo = new javax.swing.JComboBox<>();
        cbxPrimero = new javax.swing.JComboBox<>();
        cbxSexto = new javax.swing.JComboBox<>();
        cbxTercero = new javax.swing.JComboBox<>();
        cbxCuarto = new javax.swing.JComboBox<>();
        cbxSeptimo = new javax.swing.JComboBox<>();
        cbxQuinto = new javax.swing.JComboBox<>();
        cbxOctavo = new javax.swing.JComboBox<>();
        cbxNoveno = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        cbxArtificial = new javax.swing.JComboBox<>();
        cbxSofware = new javax.swing.JComboBox<>();
        cbxAplicada = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbxArtificialOc = new javax.swing.JComboBox<>();
        cbxSofwareOc = new javax.swing.JComboBox<>();
        cbxAplicadaOc = new javax.swing.JComboBox<>();
        checkSofware = new javax.swing.JCheckBox();
        checkArtificial = new javax.swing.JCheckBox();
        checkAplicada = new javax.swing.JCheckBox();
        btnCargar = new javax.swing.JButton();
        cbxItinerario = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMateria = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblItinerarios = new javax.swing.JTable();
        btnAnular = new javax.swing.JButton();
        btnAnularItinerario = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        txtMateria = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtItinerario = new javax.swing.JTextField();
        btnRegistrarItinerario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/sgaLogo.png"))); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Estudiante"));

        lblNombre.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        lblNombre.setText("NOMBRES");

        lblApellido.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        lblApellido.setText("APELLIDOS");

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        lblCedula.setText("CEDULA");

        jLabel3.setText("Ciclo");

        jLabel4.setText("Jornada");

        jLabel5.setText("Paralelo");

        cbxCiclo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxJornada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxParalelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblRol.setText("ROL");

        jLabel11.setText("Modalidad");

        cbxModalidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(lblNombre)
                                .addGap(18, 18, 18)
                                .addComponent(lblApellido)
                                .addGap(18, 18, 18)
                                .addComponent(lblCedula))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxJornada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblRol))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnGuardar)
                                    .addComponent(cbxParalelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 27, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxModalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblNombre)
                                    .addComponent(lblApellido)
                                    .addComponent(lblCedula)))
                            .addComponent(lblRol))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbxCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(cbxJornada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(cbxParalelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(cbxModalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGuardar)))
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles de Matricula"));

        tblEstudiante.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblEstudiante);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Asignar Materias"));

        cbxSegundo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxPrimero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxSexto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxTercero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxCuarto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxSeptimo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxQuinto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxOctavo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxNoveno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Intinerarios"));

        cbxArtificial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxSofware.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxAplicada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Ingeniería de Software");

        jLabel7.setText("Computación Aplicada");

        jLabel8.setText("Inteligencia Artifical");

        cbxArtificialOc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxSofwareOc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxAplicadaOc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        checkSofware.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkSofwareActionPerformed(evt);
            }
        });

        checkArtificial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkArtificialActionPerformed(evt);
            }
        });

        checkAplicada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkAplicadaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxArtificial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxArtificialOc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addComponent(checkArtificial))
                            .addComponent(jLabel8)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbxSofware, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbxSofwareOc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(checkSofware))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbxAplicada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbxAplicadaOc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(checkAplicada))))))
                    .addComponent(jLabel7))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxArtificial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxArtificialOc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(checkArtificial)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxSofware, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxSofwareOc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(checkSofware)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(cbxAplicada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxAplicadaOc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(checkAplicada))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCargar.setText("Cargar");
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });

        cbxItinerario.setText("Cargar Itinerario");
        cbxItinerario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxItinerarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbxNoveno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxOctavo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxSeptimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxSexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxQuinto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxCuarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxTercero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxPrimero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxSegundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(17, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cbxItinerario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCargar)
                        .addGap(29, 29, 29))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cbxPrimero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxSegundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxTercero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxCuarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(cbxQuinto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxSexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxSeptimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxOctavo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxNoveno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxItinerario)
                    .addComponent(btnCargar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Materias  Horarios"));

        tblMateria.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblMateria);

        jLabel10.setText("Materias del Ciclo");

        jLabel12.setText("Materias Itinerarios");

        tblItinerarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblItinerarios);

        btnAnular.setText("Anular");

        btnAnularItinerario.setText("Anular");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAnular))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel12))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAnularItinerario)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(btnAnular)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(btnAnularItinerario)
                        .addGap(24, 24, 24))))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Asignar Materias"));

        txtMateria.setText("jTextField1");

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jLabel2.setText("Materias del Ciclo");

        jLabel9.setText("Materia de Itinerario");

        txtItinerario.setText("jTextField1");

        btnRegistrarItinerario.setText("Registrar");
        btnRegistrarItinerario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarItinerarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRegistrar)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(txtMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel9)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(txtItinerario, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnRegistrarItinerario))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtItinerario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnRegistrarItinerario))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(508, 508, 508)))))
                .addContainerGap(323, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(164, 164, 164))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardarEstudiante();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        try {
            cargarMateriaSeleccionada();
            //   cargarSeleccionItinerario();
        } catch (EmptyException ex) {
            Logger.getLogger(FrmMatricular.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PositionException ex) {
            Logger.getLogger(FrmMatricular.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCargarActionPerformed

    private void cbxItinerarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxItinerarioActionPerformed
        cargarMateriaSeleccionadaItinerario();
    }//GEN-LAST:event_cbxItinerarioActionPerformed

    private void checkArtificialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkArtificialActionPerformed
        boolean selected = checkArtificial.isSelected();
        if (selected) {
            // Desactiva los combos de septimo
            cbxSofware.setEnabled(false);
            cbxAplicada.setEnabled(false);
            // Activa el combo correspondiente
            cbxArtificial.setEnabled(true);
        } else {
            // Activa todos los combos
            cbxArtificial.setEnabled(false);
            cbxSofware.setEnabled(false);
            cbxAplicada.setEnabled(false);
        }

        // Desactiva combos de octavo
        cbxArtificialOc.setEnabled(false);
        cbxSofwareOc.setEnabled(false);
        cbxAplicadaOc.setEnabled(false);

        cargarMateriaSeleccionadaItinerario();
    }//GEN-LAST:event_checkArtificialActionPerformed

    private void checkSofwareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkSofwareActionPerformed
        boolean selected = checkSofware.isSelected();
        if (selected) {
            // Desactiva los combos de septimo

            cbxArtificial.setEnabled(false);
            cbxAplicada.setEnabled(false);
            // Activa el combo correspondiente
            cbxSofware.setEnabled(true);
        } else {
            // Activa todos los combos
            cbxArtificial.setEnabled(false);
            cbxSofware.setEnabled(false);
            cbxAplicada.setEnabled(false);
        }

        // Desactiva combos de octavo
        cbxArtificialOc.setEnabled(false);
        cbxSofwareOc.setEnabled(false);
        cbxAplicadaOc.setEnabled(false);

        cargarMateriaSeleccionadaItinerario();
    }//GEN-LAST:event_checkSofwareActionPerformed

    private void checkAplicadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkAplicadaActionPerformed
        boolean selected = checkAplicada.isSelected();
        if (selected) {
            // Desactiva los combos de septimo
            cbxSofware.setEnabled(false);
            cbxArtificial.setEnabled(false);
            // Activa el combo correspondiente

            cbxAplicada.setEnabled(true);
        } else {
            // Activa todos los combos
            cbxArtificial.setEnabled(false);
            cbxSofware.setEnabled(false);
            cbxAplicada.setEnabled(false);
        }

        // Desactiva combos de octavo
        cbxArtificialOc.setEnabled(false);
        cbxSofwareOc.setEnabled(false);
        cbxAplicadaOc.setEnabled(false);

        cargarMateriaSeleccionadaItinerario();
    }//GEN-LAST:event_checkAplicadaActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        guardarMateriasCiclo();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnRegistrarItinerarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarItinerarioActionPerformed
        guardarMateriasItinerario();
    }//GEN-LAST:event_btnRegistrarItinerarioActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(FrmMatricular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FrmMatricular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FrmMatricular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FrmMatricular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                FrmMatricular dialog = new FrmMatricular(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnular;
    private javax.swing.JButton btnAnularItinerario;
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegistrarItinerario;
    private javax.swing.JComboBox<String> cbxAplicada;
    private javax.swing.JComboBox<String> cbxAplicadaOc;
    private javax.swing.JComboBox<String> cbxArtificial;
    private javax.swing.JComboBox<String> cbxArtificialOc;
    private javax.swing.JComboBox<String> cbxCiclo;
    private javax.swing.JComboBox<String> cbxCuarto;
    private javax.swing.JButton cbxItinerario;
    private javax.swing.JComboBox<String> cbxJornada;
    private javax.swing.JComboBox<String> cbxModalidad;
    private javax.swing.JComboBox<String> cbxNoveno;
    private javax.swing.JComboBox<String> cbxOctavo;
    private javax.swing.JComboBox<String> cbxParalelo;
    private javax.swing.JComboBox<String> cbxPrimero;
    private javax.swing.JComboBox<String> cbxQuinto;
    private javax.swing.JComboBox<String> cbxSegundo;
    private javax.swing.JComboBox<String> cbxSeptimo;
    private javax.swing.JComboBox<String> cbxSexto;
    private javax.swing.JComboBox<String> cbxSofware;
    private javax.swing.JComboBox<String> cbxSofwareOc;
    private javax.swing.JComboBox<String> cbxTercero;
    private javax.swing.JCheckBox checkAplicada;
    private javax.swing.JCheckBox checkArtificial;
    private javax.swing.JCheckBox checkSofware;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRol;
    private javax.swing.JTable tblEstudiante;
    private javax.swing.JTable tblItinerarios;
    private javax.swing.JTable tblMateria;
    private javax.swing.JTextField txtItinerario;
    private javax.swing.JTextField txtMateria;
    // End of variables declaration//GEN-END:variables
}
