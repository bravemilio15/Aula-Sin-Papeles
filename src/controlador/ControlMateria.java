/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.dao.CicloDAO;
import controlador.dao.MateriaDao;
import controlador.dao.EstudianteDao;
import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.EmptyException;
import controlador.ed.lista.exception.PositionException;
import java.io.IOException;
import modelo.Ciclo;
import modelo.Materia;
import modelo.Estudiante;

/**
 *
 * @author cristian
 */
public class ControlMateria {

    private MateriaDao materiaDao;
    private Materia materia;
    private CicloDAO cd = new CicloDAO();

    public ControlMateria() {
        this.materiaDao = new MateriaDao();
    }

    public MateriaDao getMateriaDao() {
        return materiaDao;
    }

    public void setMateriaDao(MateriaDao materiaDao) {
        this.materiaDao = materiaDao;
    }

    public Materia getMateria() {
        if (materia == null) {
            materia = new Materia();
        }
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public ListaEnlazada<Materia> listar() {
        return materiaDao.listar();
    }

    public void guardarMateria(String nombre, String categoria, String nombreCiclo) {
        try {

            Ciclo cicloAsociado = cd.obtenerCicloPorNombre(nombreCiclo);
            if (cicloAsociado != null) {
                if (materiaDao != null) {
                    if (materiaDao.getMateria() != null) {
                        materiaDao.getMateria().setNombre(nombre);
                        materiaDao.getMateria().setCategoria(categoria);
                        materiaDao.getMateria().setCiclo(cicloAsociado);
                        try {
                            materiaDao.guardar();
                            System.out.println("Materia guardada exitosamente");
                        } catch (IOException ex) {
                            System.out.println("Error al guardar la materia: " + ex.getMessage());
                        }
                    } else {
                        System.out.println("Error: materiaDao.getMateria() es null");
                    }
                } else {
                    System.out.println("Error: materiaDao es null");
                }
            } else {
                System.out.println("Ciclo no encontrado");
            }
        } catch (EmptyException | PositionException ex) {
            System.out.println("Error al obtener el ciclo: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        ControlMateria cm = new ControlMateria();

        cm.guardarMateria("Diseno de Circuitos", "Basica", "Segundo");
        cm.guardarMateria("Analisis Matematico", "Basica", "Segundo");
        cm.guardarMateria("Teoria de la DIstribucion y probabilidad", "Basica", "Segundo");
        cm.guardarMateria("Programacion Orientada a Objetos", "Basica", "Segundo");
        cm.guardarMateria("Emprendimiento e Innovación Tecnológica", "Basica", "Segundo");

        cm.guardarMateria("Estructura de Datos", "Basica", "Tercero");
        cm.guardarMateria("Requisitos de Sofware", "Basica", "Tercero");
        cm.guardarMateria("Estadistica Analitica", "Basica", "Tercero");
        cm.guardarMateria("Arquitectura de ordenadores", "Basica", "Tercero");
        cm.guardarMateria("Base de Datos", "Basica", "Tercero");

        cm.guardarMateria("Complejidad Computacional", "Basica", "Cuarto");
        cm.guardarMateria("Ecuaciones Diferenciales", "Basica", "Cuarto");
        cm.guardarMateria("Diseño de Software", "Basica", "Cuarto");
        cm.guardarMateria("Sistemas Operativos", "Basica", "Cuarto");
        cm.guardarMateria("Metodología de la Investigación en Computación", "Basica", "Cuarto");

        cm.guardarMateria("Sistemas Digitales", "Basica", "Quinto");
        cm.guardarMateria("Análisis Numérico", "Basica", "Quinto");
        cm.guardarMateria("Desarrollo Basado en Plataformas", "Basica", "Quinto");
        cm.guardarMateria("Simulación", "Basica", "Quinto");
        cm.guardarMateria("Fundamentos de Redes de Comunicaciones", "Basica", "Quinto");

        cm.guardarMateria("Teoría de Autómatas y Computabilidad Avanzada", "Basica", "Sexto");
        cm.guardarMateria("Sistemas Distribuidos", "Basica", "Sexto");
        cm.guardarMateria("Procesos de Software", "Basica", "Sexto");
        cm.guardarMateria("Computación en la Nube", "Basica", "Sexto");
        cm.guardarMateria("Gestión de Redes y Comunicaciones", "Basica", "Sexto");
        cm.guardarMateria("Practicas Laborales", "Basica", "Sexto");

        cm.guardarMateria("Algoritmos, Análisis y Programación Paralela", "Basica", "Septimo");
        cm.guardarMateria("Seguridad de la Información", "Basica", "Septimo");
        cm.guardarMateria("Proyectos Tecnológicos 1", "Basica", "Septimo");

        cm.guardarMateria("Human-Computer Interaction", "Itinerario IA", "Septimo");
        cm.guardarMateria("Data Mining", "Itinerario IA", "Septimo");

        cm.guardarMateria("Software Engineering Models", "Itinerario Software", "Septimo");
        cm.guardarMateria("Software Engineering Management", "Itinerario Software", "Septimo");

        cm.guardarMateria("Internet of Things", "Itinerario Aplicaciones", "Septimo");
        cm.guardarMateria("Virtual Systems and Services", "Itinerario Aplicaciones", "Septimo");

        cm.guardarMateria("Etica Profesional", "Basica", "Octavo");
        cm.guardarMateria("Proyectos Tecnológicos 2", "Basica", "Octavo");
        cm.guardarMateria("Servicio Comunitario 1", "Basica", "Octavo");

        cm.guardarMateria("Machine Learningn", "Itinerario IA", "Octavo");
        cm.guardarMateria("Human Perception in Computer Vision", "Itinerario IA", "Octavo");

        cm.guardarMateria("Software Quality", "Itinerario Software", "Octavo");
        cm.guardarMateria("Software Security", "Itinerario Software", "Octavo");

        cm.guardarMateria("Cybersecurity", "Itinerario Aplicaciones", "Octavo");
        cm.guardarMateria("Data Science", "Itinerario Aplicaciones", "Octavo");

        cm.guardarMateria("Composición deTextos Científicos en Ingeniería", "Basica", "Noveno");
        cm.guardarMateria("Laborales 2", "Basica", "Noveno");
        cm.guardarMateria("Servicio Comunitario 2", "Basica", "Noveno");
        cm.guardarMateria("Tranajo de Integracion Curricular", "Basica", "Noveno");

    }
}
