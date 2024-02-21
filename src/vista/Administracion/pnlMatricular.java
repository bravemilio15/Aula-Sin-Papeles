package vista.Administracion;

import controlador.aula.EstudianteDAO;
import controlador.aula.MateriaDAO;
import controlador.aula.MatriculaDAO;
import controlador.aula.Matricula_MateriaDAO;
import controlador.aula.ParaleloDAO;
import controlador.aula.UsuarioDAO;
import controlador.ed.listas.LinkedList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Estudiante;
import modelo.Materia;
import modelo.Matricula;
import modelo.Matricula_Materia;
import modelo.Paralelo;
import modelo.Usuario;
import modelo.tabla.ModeloTablaEstudiante;
import modelo.tabla.ModeloTablaMM;
import modelo.tabla.ModeloTablaMatricula;

import vista.utilidades.Utilidades;

public class pnlMatricular extends javax.swing.JPanel {

    private ModeloTablaMatricula modeloMatricula = new ModeloTablaMatricula();
    private MatriculaDAO md = new MatriculaDAO();
    private MateriaDAO mad = new MateriaDAO();
    private ParaleloDAO pd = new ParaleloDAO();
    private EstudianteDAO ed = new EstudianteDAO();
    private UsuarioDAO ud = new UsuarioDAO();
    private Matricula_MateriaDAO mm = new Matricula_MateriaDAO();
    private ModeloTablaEstudiante modeloEstudiante = new ModeloTablaEstudiante();
    private ModeloTablaMM modeloMM = new ModeloTablaMM();
    private MateriaDAO materiad = new MateriaDAO();
    private Integer pos = -1;

    /**
     * Creates new form pnlHome
     */
    public pnlMatricular() {
        initComponents();
        limpiar();

    }

    private void cargarTablaEstudiante() {
        modeloEstudiante.setDatos(ed.listar());
        tblEstudiantes.setModel(modeloEstudiante);
        tblEstudiantes.updateUI();

    }

    private void cargarTablaMatricula_Materia() {
        modeloMM.setDatos(mm.listar());
        tblMatriculaMateria.setModel(modeloMM);
        tblMatriculaMateria.updateUI();

    }

    private void cargarTablaMatricula() {
        modeloMatricula.setDatos(md.listar());
        tblMatricula.setModel(modeloMatricula);
        tblMatricula.updateUI();

    }

    private void cargarCombos() {
        Utilidades.cargarExpediente(cbxEstado);
        Utilidades.cargarCriterio(cbxCriterio);
        Utilidades.cargarGradoAcademico(cbxNivelAcademico);
        try {
            Utilidades.cargarMateriasDisponibles(cbxMaterias);
            Utilidades.cargarParalelosDisponibles(cbxParalelos);

        } catch (Exception e) {
        }
    }

    private void limpiar() {
        cargarCombos();
        cargarTablaEstudiante();
        cargarTablaMatricula();
        cargarTablaMatricula_Materia();
    }

    public void buscarBinaria() {
        switch (cbxCriterio.getSelectedItem().toString()) {
            case "Nombre":
            try {
                LinkedList<Usuario> resultadosNombre = ud.buscarPorNombre(txtBuscar.getText());
                LinkedList<Estudiante> estudiantesEncontrados = new LinkedList<>();

                for (int i = 0; i < resultadosNombre.getSize(); i++) {
                    Usuario usuario = resultadosNombre.get(i);
                    Estudiante estudiante = buscarEstudiantePorId(usuario.getUsuario_Id());
                    if (estudiante != null) {
                        estudiantesEncontrados.add(estudiante);
                    }
                }

                modeloEstudiante.setDatos(estudiantesEncontrados);
                limpiar();

            } catch (Exception ex) {

                ex.printStackTrace();
            }

            break;
            case "Cedula":
            try {
                LinkedList<Usuario> resultadosCedula = ud.buscarPorCedula(txtBuscar.getText());
                LinkedList<Estudiante> estudiantesEncontrados = new LinkedList<>();

                for (int i = 0; i < resultadosCedula.getSize(); i++) {
                    Usuario usuario = resultadosCedula.get(i);
                    Estudiante estudiante = buscarEstudiantePorId(usuario.getUsuario_Id());
                    if (estudiante != null) {
                        estudiantesEncontrados.add(estudiante);
                    }
                }

                modeloEstudiante.setDatos(estudiantesEncontrados);
                limpiar();
            } catch (Exception ex) {
                // Manejo de la excepción
                ex.printStackTrace();
            }
            break;
        }
    }

    private Estudiante buscarEstudiantePorId(Integer idUsuario) {
        Estudiante estudianteEncontrado = null;
        LinkedList<Estudiante> estudiantes = null;

        try {
            estudiantes = new EstudianteDAO().getEstudiantes();

            // Bucle for tradicional para iterar sobre la lista de estudiantes
            for (int i = 0; i < estudiantes.getSize(); i++) {
                Estudiante estudiante = estudiantes.get(i);
                // Verificar si el ID de usuario del estudiante coincide con el ID proporcionado
                if (estudiante.getEstudiante_Id().equals(idUsuario)) {
                    // Si hay coincidencia, asignar el estudiante encontrado y salir del bucle
                    estudianteEncontrado = estudiante;
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return estudianteEncontrado;
    }

    public void modificarUsuario() {
        int fila = tblEstudiantes.getSelectedRow();

        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                Estudiante estudianteSeleccionado = modeloEstudiante.getDatos().get(fila);

                // Imprimir el ID del estudiante seleccionado antes de realizar cualquier operación
                System.out.println("ID del estudiante seleccionado: " + estudianteSeleccionado.getEstudiante_Id());

                // Verificar si el estudiante tiene una matrícula existente
                if (estudianteSeleccionado.getMatricula_Id() == null) {
                    // Si no tiene matrícula, crear una nueva matrícula y asignarla al estudiante
                    Matricula nuevaMatricula = new Matricula();
                    nuevaMatricula.setNivel_Academico(cbxNivelAcademico.getSelectedItem().toString()); // Puedes establecer el nivel académico deseado aquí
                    nuevaMatricula.setEstado(1); // Por defecto, la nueva matrícula se establece como activa

                    // Guardar la nueva matrícula y obtener su ID
                    Integer nuevaMatriculaId = md.guardar(nuevaMatricula);

                    // Asignar el ID de la nueva matrícula al estudiante seleccionado
                    estudianteSeleccionado.setMatricula_Id(nuevaMatriculaId);

                    // Actualizar el estudiante en la base de datos usando el método update del UsuarioDAO
                    ud.update();
                    limpiar();

                } else {
                    // Crear una nueva matrícula para el estudiante
                    Matricula nuevaMatricula = new Matricula();
                    nuevaMatricula.setNivel_Academico(cbxNivelAcademico.getSelectedItem().toString()); // Puedes establecer el nivel académico deseado aquí
                    nuevaMatricula.setEstado(1); // Por defecto, la nueva matrícula se establece como activa

                    // Guardar la nueva matrícula y obtener su ID
                    Integer nuevaMatriculaId = md.guardar(nuevaMatricula);

                    // Actualizar el estudiante en la base de datos con la nueva matrícula usando el método update del UsuarioDAO
                    estudianteSeleccionado.setMatricula_Id(nuevaMatriculaId);
                    ud.update();
                    limpiar();
                }

                JOptionPane.showMessageDialog(null, "Se Guardo bien", 
                        "OK", JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void modificarMatricula() {
        int fila = tblMatricula.getSelectedRow();

        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                Matricula matriculaSeleccionada = modeloMatricula.getDatos().get(fila);

                Integer idMatricula = matriculaSeleccionada.getMatricula_Id();

                // Obtener la materia seleccionada del JComboBox cbxMaterias
                String nombreMateria = (String) cbxMaterias.getSelectedItem();
                Materia materiaSeleccionada = mad.obtenerPorNombre(nombreMateria);

                String nombreParalelo = (String) cbxParalelos.getSelectedItem();
                Paralelo paraleloSeleccionado = pd.obtenerPorNombre(nombreParalelo);

                mm.getMatricula_Materia().setMatricula_Id(idMatricula);
                mm.getMatricula_Materia().setMateria_Id(materiaSeleccionada.getMateria_Id());
                mm.getMatricula_Materia().setParalelo_Id(paraleloSeleccionado.getParalelo_Id());

                mm.save();

                JOptionPane.showMessageDialog(null, "Materia y paralelo asignados correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
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
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblEstudiantes = new javax.swing.JTable();
        btnMatricula = new javax.swing.JButton();
        panelMatri = new javax.swing.JPanel();
        panelMatri1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbxNivelAcademico = new javax.swing.JComboBox<>();
        cbxEstado = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMatricula = new javax.swing.JTable();
        btnModificar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbxMaterias = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbxParalelos = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblMatriculaMateria = new javax.swing.JTable();

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

        cbxCriterio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCriterioActionPerformed(evt);
            }
        });

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
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
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnBuscar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCriterio)
                    .addComponent(cbxCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnBuscar)
                .addGap(0, 0, Short.MAX_VALUE))
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
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnMatricula)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMatricula)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelMatri.setBorder(javax.swing.BorderFactory.createTitledBorder("Asignar Matricula"));

        panelMatri1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel4.setText("Estado");

        jLabel5.setText("Nivel Academico");

        cbxNivelAcademico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout panelMatri1Layout = new javax.swing.GroupLayout(panelMatri1);
        panelMatri1.setLayout(panelMatri1Layout);
        panelMatri1Layout.setHorizontalGroup(
            panelMatri1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMatri1Layout.createSequentialGroup()
                .addGroup(panelMatri1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMatri1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(cbxNivelAcademico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelMatri1Layout.createSequentialGroup()
                        .addGap(389, 389, 389)
                        .addComponent(jLabel9)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelMatri1Layout.setVerticalGroup(
            panelMatri1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMatri1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMatri1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(cbxNivelAcademico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addGroup(panelMatriLayout.createSequentialGroup()
                .addGroup(panelMatriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelMatri1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMatriLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMatriLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnModificar)
                .addGap(39, 39, 39))
        );
        panelMatriLayout.setVerticalGroup(
            panelMatriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMatriLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelMatri1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificar)
                .addGap(12, 12, 12))
        );

        jLabel1.setText("Materias");

        cbxMaterias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Paralelos");

        cbxParalelos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGuardar.setText("Matricular");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        tblMatriculaMateria.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tblMatriculaMateria);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(78, 78, 78)
                            .addComponent(btnGuardar))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addGap(57, 57, 57)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cbxParalelos, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbxMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbxMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbxParalelos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnGuardar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelMatri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(panelMatri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        modificarMatricula();

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarBinaria();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatriculaActionPerformed
        modificarUsuario();

    }//GEN-LAST:event_btnMatriculaActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

    }//GEN-LAST:event_btnModificarActionPerformed

    private void cbxCriterioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCriterioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxCriterioActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnMatricula;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cbxCriterio;
    private javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JComboBox<String> cbxMaterias;
    private javax.swing.JComboBox<String> cbxNivelAcademico;
    private javax.swing.JComboBox<String> cbxParalelos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbCriterio;
    private javax.swing.JPanel panelMatri;
    private javax.swing.JPanel panelMatri1;
    private javax.swing.JTable tblEstudiantes;
    private javax.swing.JTable tblMatricula;
    private javax.swing.JTable tblMatriculaMateria;
    private javax.swing.JTable tblMatriculas;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
