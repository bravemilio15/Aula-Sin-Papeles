/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.utilidades;

import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.EmptyException;
import controlador.ed.lista.exception.PositionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 *
 * @author cristian
 */
public class Utilidades {

//    public static void cargarRoles(JComboBox cbx) {
//        cbx.removeAllItems();
//        ListaEnlazada<Rol> lista = new RolDAO().listar();
//
//        for (int i = 0; i < lista.size(); i++) {
//            try {
//                cbx.addItem(lista.get(i));
//            } catch (EmptyException | PositionException ex) {
//                System.out.println("Error");
//            }
//        }
//    }
//    
    public static void cargarRoles(JComboBox cbx) {
        cbx.removeAllItems();

        cbx.addItem("Estudiante");
        cbx.addItem("Docente");
        cbx.addItem("Decano");
        cbx.addItem("Secretaria");

    }

    public static void cargarPrimero(JComboBox cbx) {
        cbx.removeAllItems();

        cbx.addItem("Electricidad");
        cbx.addItem("Matematicas Dsicretas");
        cbx.addItem("Algebra Lineal");
        cbx.addItem("Teoria de la programcion");
        cbx.addItem("Comunicacion y redaccion tecnica");

    }

    public static void cargarSegundo(JComboBox cbx) {
        cbx.removeAllItems();

        cbx.addItem("Estructura de datos");
        cbx.addItem("Analisis Matematico");
        cbx.addItem("Teoria de la DIstribucion y probabilidad");
        cbx.addItem("Programacion Orientada a Objetos");
        cbx.addItem("Emprendimiento e Innovación Tecnológica");

    }

    public static void cargarTercero(JComboBox cbx) {
        cbx.removeAllItems();

        cbx.addItem("Diseno de Circuitos");
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
    
    

    public static void cargarCiclos(JComboBox cbx) {
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

    public static void cargarCriterios(JComboBox cbx) {
        cbx.removeAllItems();

        cbx.addItem("Apellido");

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

}
