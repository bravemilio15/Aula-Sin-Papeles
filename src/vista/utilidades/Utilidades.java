/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.utilidades;

import contmallaador.aula.MallaDAO;
import controlador.aula.CicloDAO;
import controlador.aula.RolDAO;
import controlador.ed.listas.LinkedList;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import modelo.Ciclo;
import modelo.Malla;
import modelo.Rol;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author cristian
 */
public class Utilidades {

    public static boolean validarEdad(String edad) {
        try {
            Integer edadNumerica = Integer.parseInt(edad);
            if (edadNumerica >= 18) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null,
                        "La Edad Tiene que ser Mayor a 18 años",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "La Edad no es un número válido",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static boolean validarNombresApellidos(String nombres, String apellidos) {
        // Elimina los espacios al final y al principio, y luego verifica que haya al menos un espacio entre nombres y apellidos
        String nombresTrimmed = nombres != null ? nombres.trim() : "";
        String apellidosTrimmed = apellidos != null ? apellidos.trim() : "";

        String regex = ".*\\s+.*";
        if (nombresTrimmed.matches(regex) && apellidosTrimmed.matches(regex)) {
            return true;
        } else {
            System.out.println("Debe haber al menos un espacio entre nombres y apellidos");
            JOptionPane.showMessageDialog(null,
                    "Debe haber al menos un espacio entre nombres y apellidos",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static boolean verificarCelular(String numero) {
        if (numero != null && numero.matches("\\d{10}")) {
            return true;
        } else {
            System.out.println("El Celular Debe tener 10 Digitos");
            JOptionPane.showMessageDialog(null,
                    "El Celular Debe tener 10 Digitos",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }

    public static boolean validarCorreoInstitucional(String correo) {
        // El correo institucional debe tener el dominio "@unl.edu.ec" al final y ser en minúsculas
        String regex = ".*@unl\\.edu\\.ec$";
        if (correo != null && correo.toLowerCase().matches(regex)) {
            return true;
        } else {
            System.out.println("El Correo Institucional Debe contar con @unl.edu.ec");
            JOptionPane.showMessageDialog(null,
                    "El Correo Institucional Debe contar con @unl.edu.ec",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static boolean validarCorreoPersonal(String correo) {
        // El correo personal debe tener uno de los siguientes dominios: "@gmail.com", "@hotmail.com" o "@yahoo.com" al final y ser en minúsculas
        String regex = ".*@(gmail\\.com|hotmail\\.com|yahoo\\.com)$";
        if (correo != null && correo.toLowerCase().matches(regex)) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null,
                    "El Correo debe contar con el '@' y con la direccion gmail,hotmail,yahoo y con .com",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static boolean validarCedula(String cedula) {
        // Elimina posibles guiones o espacios
        cedula = cedula.replaceAll("[^0-9]", "");

        // Verifica que la cédula tenga 10 dígitos
        if (cedula.length() != 10) {
            JOptionPane.showMessageDialog(
                    null,
                    "La Cédula Debe tener 10 dígitos",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Extrae el último dígito (dígito verificador)
        int ultimoDigito = Character.getNumericValue(cedula.charAt(9));

        // Calcula el dígito verificador esperado
        int suma = 0;
        for (int i = 0; i < 9; i++) {
            int digito = Character.getNumericValue(cedula.charAt(i));
            if (i % 2 == 0) {
                digito *= 2;
                if (digito > 9) {
                    digito -= 9;
                }
            }
            suma += digito;
        }

        int residuo = suma % 10;
        int resultado = (residuo == 0) ? 0 : 10 - residuo;

        // Compara el dígito verificador calculado con el último dígito
        if (resultado == ultimoDigito) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null,
                    "La Cédula Debe ser Ecuatoriana y contar con 10 dígitos",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }

    public static JDatePickerImpl createDatePicker() {
        UtilDateModel model = new UtilDateModel();

        // Configurar propiedades (opcional)
        Properties properties = new Properties();
        properties.put("text.today", "Today");
        properties.put("text.month", "Month");
        properties.put("text.year", "Year");

        JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);
        return new JDatePickerImpl(datePanel, new DateLabelFormatter());
    }

    public static SimpleDateFormat getSimpleDateFormat(String pattern) {
        return new SimpleDateFormat(pattern);
    }

    public static String formatDateString(Date date, String pattern) {
        SimpleDateFormat sdf = getSimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public static Date parseDateString(String dateString, String pattern) throws ParseException {
        SimpleDateFormat sdf = getSimpleDateFormat(pattern);
        return sdf.parse(dateString);
    }

    public static int calcularEdad(String fecha) {
        try {
            Date fechaNac = parseDateString(fecha, "yyyy-MM-dd");
            Calendar calNacimiento = Calendar.getInstance();
            calNacimiento.setTime(fechaNac);

            Calendar calHoy = Calendar.getInstance();

            int edad = calHoy.get(Calendar.YEAR) - calNacimiento.get(Calendar.YEAR);

            if (calHoy.get(Calendar.DAY_OF_YEAR) < calNacimiento.get(Calendar.DAY_OF_YEAR)) {
                edad--;
            }

            return edad;
        } catch (ParseException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static void showDatePickerPopup(Component component, JDatePickerImpl datePicker) {
        JDialog dialog = new JDialog();
        dialog.getContentPane().add(datePicker);
        dialog.setSize(100, 100);
        dialog.setLocationRelativeTo(component);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }

    public static void cargarGradoAcademico(JComboBox cbx) {
        cbx.removeAllItems();

        cbx.addItem("Bachiller");
        cbx.addItem("Licenciado");
        cbx.addItem("Magister");
        cbx.addItem("Doctorado");

    }

    public static void cargarNumeroMatricula(JComboBox cbx) {
        cbx.removeAllItems();

        cbx.addItem("Primera");
        cbx.addItem("Segunda");
        cbx.addItem("Tercera");

    }

    public static void cargarPrimero(JComboBox cbx) {
        cbx.removeAllItems();

        cbx.addItem("Electricidad");
        cbx.addItem("Matematicas Discretas");
        cbx.addItem("Algebra Lineal");
        cbx.addItem("Teoria de la programcion");
        cbx.addItem("Comunicacion y redaccion tecnica");

    }

    public static void cargarSegundo(JComboBox cbx) {
        cbx.removeAllItems();

        cbx.addItem("Diseno de Circuitos");
        cbx.addItem("Analisis Matematico");
        cbx.addItem("Teoria de la DIstribucion y probabilidad");
        cbx.addItem("Programacion Orientada a Objetos");
        cbx.addItem("Emprendimiento e Innovación Tecnológica");

    }

    public static void cargarTercero(JComboBox cbx) {
        cbx.removeAllItems();

        cbx.addItem("Estructura de Datos");
        cbx.addItem("Requisitos de Sofware");
        cbx.addItem("Estadistica Analitica");
        cbx.addItem("Arquitectura de ordenadores");
        cbx.addItem("Base de Datos");

    }

    public static void cargarCuarto(JComboBox cbx) {
        cbx.removeAllItems();

        cbx.addItem("Complejidad Computacional");
        cbx.addItem("Ecuaciones Diferenciales");
        cbx.addItem("Diseño de Software");
        cbx.addItem("Sistemas Operativos");
        cbx.addItem("Metodología de la Investigación en Computación");

    }

    public static void cargarQuinto(JComboBox cbx) {
        cbx.removeAllItems();

        cbx.addItem("Sistemas Digitales");
        cbx.addItem("Análisis Numérico");
        cbx.addItem("Desarrollo Basado en Plataformas");
        cbx.addItem("Simulación");
        cbx.addItem("Fundamentos de Redes de Comunicaciones");

    }

    public static void cargarSexto(JComboBox cbx) {
        cbx.removeAllItems();

        cbx.addItem("Teoría de Autómatas y Computabilidad Avanzada");
        cbx.addItem("Sistemas Distribuidos");
        cbx.addItem("Procesos de Software");
        cbx.addItem("Computación en la Nube");
        cbx.addItem("Gestión de Redes y Comunicaciones");
        cbx.addItem("Practicas Laborales");

    }

    public static void cargarSeptimo(JComboBox cbx) {
        cbx.removeAllItems();

        cbx.addItem("Algoritmos, Análisis y Programación Paralela");
        cbx.addItem("Seguridad de la Información");
        cbx.addItem("Proyectos Tecnológicos 1");

    }

    public static void cargarSeptimoIA(JComboBox cbx) {
        cbx.removeAllItems();

        cbx.addItem("Human-Computer Interaction");
        cbx.addItem("Data Mining");

    }

    public static void cargarSeptimoSof(JComboBox cbx) {
        cbx.removeAllItems();

        cbx.addItem("Software Engineering Models");
        cbx.addItem("Software Engineering Management");

    }

    public static void cargarSeptimoApli(JComboBox cbx) {
        cbx.removeAllItems();

        cbx.addItem("Internet of Things");
        cbx.addItem("Virtual Systems and Services");

    }

    public static void cargarOctavo(JComboBox cbx) {
        cbx.removeAllItems();

        cbx.addItem("Etica Profesional");
        cbx.addItem("Proyectos Tecnológicos 2");
        cbx.addItem("Servicio Comunitario 1");

    }

    public static void cargarOctavoIA(JComboBox cbx) {
        cbx.removeAllItems();

        cbx.addItem("Machine Learning");
        cbx.addItem("Human Perception in Computer Vision");

    }

    public static void cargarOctavoSof(JComboBox cbx) {
        cbx.removeAllItems();

        cbx.addItem("Software Quality");
        cbx.addItem("Software Security");

    }

    public static void cargarOctavoApli(JComboBox cbx) {
        cbx.removeAllItems();

        cbx.addItem("Cybersecurity");
        cbx.addItem("Data Science");

    }

    public static void cargarNoveno(JComboBox cbx) {
        cbx.removeAllItems();

        cbx.addItem("Composición deTextos Científicos en Ingeniería");
        cbx.addItem("Laborales 2");
        cbx.addItem("Servicio Comunitario 2");
        cbx.addItem("Tranajo de Integracion Curricular");
    }

    public static void cargarJornada(JComboBox cbx) {
        cbx.removeAllItems();

        cbx.addItem("Vespertina");
        cbx.addItem("Matutina");

    }

    public static void cargarParalelo(JComboBox cbx) {
        cbx.removeAllItems();

        cbx.addItem("A");
        cbx.addItem("B");

    }

    public static void cargarEstado(JComboBox cbx) {
        cbx.removeAllItems();

        cbx.addItem("Soltero");
        cbx.addItem("Casado");
        cbx.addItem("Divorciado");
        cbx.addItem("Otro");

    }

    public static void cargarGenero(JComboBox cbx) {
        cbx.removeAllItems();

        cbx.addItem("Masculino");
        cbx.addItem("Femenino");
        cbx.addItem("Otro");

    }

    public static void cargarFacultad(JComboBox cbx) {
        cbx.removeAllItems();

        cbx.addItem("Facultad Agropecuaria y de Recursos Naturales Renovables");
        cbx.addItem("Facultad de la Educación el Arte y la Comunicación");
        cbx.addItem("Facultad de la Energía, las Industrias y los Recursos Naturales no Renovables");
        cbx.addItem("Facultad Jurídica, Social y Administrativa");
        cbx.addItem("Facultad de la Salud Humana");

    }

    public static void cargarModalidad(JComboBox cbx) {
        cbx.removeAllItems();

        cbx.addItem("Presencial");
        cbx.addItem("Distancia");

    }

    public static void cargarExpediente(JComboBox cbx) {
        cbx.removeAllItems();

        cbx.addItem("Activo");
        cbx.addItem("Inactivo");

    }

    public static void cargarNivel(JComboBox cbx) {
        cbx.removeAllItems();

        cbx.addItem("DE GRADO REGIMEN 2019");

    }

    public static void cargarCarrera(JComboBox cbx) {
        cbx.removeAllItems();

        cbx.addItem("Computacion");

    }

    public static void cargarCriterio(JComboBox cbx) {
        cbx.removeAllItems();

        cbx.addItem("Nombre");
        cbx.addItem("Cedula");

    }

    public static void cargarCiclos(JComboBox cbx) {
        if (cbx != null) {
            cbx.removeAllItems();

            cbx.addItem("Primero");
            cbx.addItem("Segundo");
            cbx.addItem("Tercero");
            cbx.addItem("Cuarto");
            cbx.addItem("Quinto");
            cbx.addItem("Sexto");
            cbx.addItem("Septimo");
            cbx.addItem("Octavo");
            cbx.addItem("Noveno");
        } else {
            System.out.println("Error: El JComboBox es nulo.");
        }
    }

    public static void cargarItinerariosComunes(JComboBox cbxItinerario) {
        cbxItinerario.removeAllItems();
        cbxItinerario.addItem("Aplicaciones");
        cbxItinerario.addItem("Inteligencia Artificial");
        cbxItinerario.addItem("Software");
    }

    public static void cargarCursosPorCicloEItinerario(String cicloSeleccionado,
            String itinerarioSeleccionado, JComboBox cbxMateria, JComboBox cbxItinerario) {
        cbxMateria.removeAllItems();

        switch (cicloSeleccionado) {
            case "Primero":
                cargarPrimero(cbxMateria);
                break;
            case "Segundo":
                cargarSegundo(cbxMateria);
                break;
            case "Tercero":
                cargarTercero(cbxMateria);
                break;
            case "Cuarto":
                cargarCuarto(cbxMateria);
                break;
            case "Quinto":
                cargarQuinto(cbxMateria);
                break;
            case "Sexto":
                cargarSexto(cbxMateria);
                break;
            case "Septimo":
                cargarSeptimo(cbxMateria);
                if (itinerarioSeleccionado.equals("Aplicaciones")) {
                    cargarSeptimoApli(cbxItinerario);
                } else if (itinerarioSeleccionado.equals("Inteligencia Artificial")) {
                    cargarSeptimoIA(cbxItinerario);
                } else if (itinerarioSeleccionado.equals("Software")) {
                    cargarSeptimoSof(cbxItinerario);
                }
                break;

            case "Octavo":
                cargarOctavo(cbxMateria);
                if (itinerarioSeleccionado.equals("Aplicaciones")) {
                    cargarOctavoApli(cbxItinerario);
                } else if (itinerarioSeleccionado.equals("Inteligencia Artificial")) {
                    cargarOctavoIA(cbxItinerario);
                } else if (itinerarioSeleccionado.equals("Software")) {
                    cargarOctavoSof(cbxItinerario);
                }
                break;
            case "Noveno":
                cargarNoveno(cbxMateria);
                break;
            default:
                System.out.println("Escoga bien el Ciclo.");
                break;
        }
    }

    public static void cargarMaterias(String cicloSeleccionado,
            JComboBox cbxMateria) {
        cbxMateria.removeAllItems();

        switch (cicloSeleccionado) {
            case "Primero":
                cargarPrimero(cbxMateria);
                break;
            case "Segundo":
                cargarSegundo(cbxMateria);
                break;
            case "Tercero":
                cargarTercero(cbxMateria);
                break;
            case "Cuarto":
                cargarCuarto(cbxMateria);
                break;
            case "Quinto":
                cargarQuinto(cbxMateria);
                break;
            case "Sexto":
                cargarSexto(cbxMateria);
                break;
            case "Septimo":
                cargarSeptimo(cbxMateria);

            case "Octavo":
                cargarOctavo(cbxMateria);

                break;
            case "Noveno":
                cargarNoveno(cbxMateria);
                break;
            default:
                System.out.println("Escoga bien el Ciclo.");
                break;
        }
    }

    public static void cargarCategoria(JComboBox cbx) {
        cbx.removeAllItems();

        cbx.addItem("Basica");
        cbx.addItem("Itinerario IA");
        cbx.addItem("Itinerario Software");
        cbx.addItem("Itinerario Aplicaciones");

    }

    public static void cargarCiclosDisponibles(JComboBox cbxCensador) throws Exception {
        CicloDAO csd = new CicloDAO();
        cbxCensador.removeAllItems();

        LinkedList<Ciclo> ciclos = csd.listar();

        if (ciclos != null) {
            for (int i = 0; i < ciclos.getSize(); i++) {
                Ciclo censador = ciclos.get(i);

                if (censador != null) {

                    cbxCensador.addItem(censador.getNombre());
                }
            }
            cbxCensador.updateUI();
        }
    }

    public static void cargarMallasDisponibles(JComboBox cbxMallas) throws Exception {
        MallaDAO mallaDAO = new MallaDAO();
        cbxMallas.removeAllItems();

        LinkedList<Malla> mallas = mallaDAO.listar();

        if (mallas != null) {
            for (int i = 0; i < mallas.getSize(); i++) {
                Malla malla = mallas.get(i);

                // Solo agregar mallas con estado igual a 0
                if (malla != null && malla.getEstado() == 0) {
                    cbxMallas.addItem(malla.getNombre());
                }
            }
            cbxMallas.updateUI();
        }
    }

    public static void cargarRolesDisponibles(JComboBox cbxRoles) throws Exception {
        RolDAO rolDAO = new RolDAO();
        cbxRoles.removeAllItems();

        LinkedList<Rol> roles = rolDAO.listar();

        if (roles != null) {
            for (int i = 0; i < roles.getSize(); i++) {
                Rol rol = roles.get(i);

                if (rol != null) {
                    cbxRoles.addItem(rol.getNombre());
                }
            }
            cbxRoles.updateUI();
        }
    }

    public static String generarCodigo() {
        // Definir los caracteres permitidos en el código
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder codigo = new StringBuilder();

        // Crear una instancia de Random
        Random random = new Random();

        // Generar cada uno de los 5 caracteres del código
        for (int i = 0; i < 5; i++) {
            // Obtener un índice aleatorio dentro del rango de caracteres
            int indice = random.nextInt(caracteres.length());

            // Agregar el caracter correspondiente al código (convertido a mayúscula)
            codigo.append(Character.toUpperCase(caracteres.charAt(indice)));
        }

        // Devolver el código generado
        return codigo.toString();
    }
    
    
    

    public static Ciclo getComboCiclos(JComboBox cbx) {
        Object selectedObject = cbx.getSelectedItem();
        System.out.println("Tipo de objeto seleccionado: " + selectedObject.getClass().getName());
        return (Ciclo) selectedObject;
    }

}
