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

/**
 *
 * @author cristian
 */
public class ControlMateria {

    private ListaEnlazada<Materia> materias;
    private MateriaDao materiaDao;
    private Materia materia;
    
    private CicloDAO cd = new CicloDAO();

    public ControlMateria() {
        this.materiaDao = new MateriaDao();
    }

    public ListaEnlazada<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(ListaEnlazada<Materia> materias) {
        this.materias = materias;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
    
    public MateriaDao getMateriaDao() {
        return materiaDao;
    }

    public void setMateriaDao(MateriaDao materiaDao) {
        this.materiaDao = materiaDao;
    }
    
    
    public void guardarMateria(String nombreMateria, String categoriaMateria, Integer idCiclo) throws IOException, EmptyException, PositionException {

        Ciclo ciclo = cd.obtenerCicloPorId(idCiclo);

        if (ciclo == null) {
            System.out.println("Error: Ciclo con ID " + idCiclo + " no encontrado. La materia no se guardará.");
        } else {

            Materia nuevaMateria = new Materia();
            nuevaMateria.setId(materiaDao.generarId());
            nuevaMateria.setNombre(nombreMateria);
            nuevaMateria.setCategoria(categoriaMateria);
            nuevaMateria.setCiclo(ciclo);

            try {
                materiaDao.guardar(nuevaMateria);

                System.out.println("Materia guardada y asociada al ciclo exitosamente");
            } catch (IOException ex) {
                System.out.println("Error al guardar la materia: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) throws EmptyException, PositionException, IOException {
        ControlMateria cm = new ControlMateria();

//        cm.guardarCiclo("Primero", 120);
//        cm.guardarCiclo("Segundo", 120);
//        cm.guardarCiclo("Tercero", 120);
//        cm.guardarCiclo("Cuarto", 120);
//        cm.guardarCiclo("Quinto", 120);
//        cm.guardarCiclo("Sexto", 120);
//        cm.guardarCiclo("Septimo", 120);
//        cm.guardarCiclo("Octavo", 120);
//        cm.guardarCiclo("Noveno", 120);
        cm.guardarMateria("Algebra Lineal", "Basica", 1);
        cm.guardarMateria("Programacion", "Basica", 1);
        cm.guardarMateria("Comunicacion", "Basica", 1);
        cm.guardarMateria("Electricidad", "Basica", 1);
        cm.guardarMateria("Matematicas Discretas", "Basica", 1);

        cm.guardarMateria("Diseno de Circuitos", "Basica", 2);
        cm.guardarMateria("Analisis Matematico", "Basica", 2);
        cm.guardarMateria("Teoria de la DIstribucion y probabilidad", "Basica", 2);
        cm.guardarMateria("Programacion Orientada a Objetos", "Basica", 2);
        cm.guardarMateria("Emprendimiento e Innovación Tecnológica", "Basica", 2);

        cm.guardarMateria("Estructura de Datos", "Basica", 3);
        cm.guardarMateria("Requisitos de Sofware", "Basica", 3);
        cm.guardarMateria("Estadistica Analitica", "Basica", 3);
        cm.guardarMateria("Arquitectura de ordenadores", "Basica", 3);
        cm.guardarMateria("Base de Datos", "Basica", 3);

        cm.guardarMateria("Complejidad Computacional", "Basica", 4);
        cm.guardarMateria("Ecuaciones Diferenciales", "Basica", 4);
        cm.guardarMateria("Diseño de Software", "Basica", 4);
        cm.guardarMateria("Sistemas Operativos", "Basica", 4);
        cm.guardarMateria("Metodología de la Investigación en Computación", "Basica", 4);

        cm.guardarMateria("Sistemas Digitales", "Basica", 5);
        cm.guardarMateria("Análisis Numérico", "Basica", 5);
        cm.guardarMateria("Desarrollo Basado en Plataformas", "Basica", 5);
        cm.guardarMateria("Simulación", "Basica", 5);
        cm.guardarMateria("Fundamentos de Redes de Comunicaciones", "Basica", 5);

        cm.guardarMateria("Teoría de Autómatas y Computabilidad Avanzada", "Basica", 6);
        cm.guardarMateria("Sistemas Distribuidos", "Basica", 6);
        cm.guardarMateria("Procesos de Software", "Basica", 6);
        cm.guardarMateria("Computación en la Nube", "Basica", 6);
        cm.guardarMateria("Gestión de Redes y Comunicaciones", "Basica", 6);
        cm.guardarMateria("Practicas Laborales", "Basica", 6);

        cm.guardarMateria("Algoritmos, Análisis y Programación Paralela", "Basica", 7);
        cm.guardarMateria("Seguridad de la Información", "Basica", 7);
        cm.guardarMateria("Proyectos Tecnológicos 1", "Basica", 7);

        cm.guardarMateria("Human-Computer Interaction", "Itinerario IA", 7);
        cm.guardarMateria("Data Mining", "Itinerario IA", 7);

        cm.guardarMateria("Software Engineering Models", "Itinerario Software", 7);
        cm.guardarMateria("Software Engineering Management", "Itinerario Software", 7);

        cm.guardarMateria("Internet of Things", "Itinerario Aplicaciones", 7);
        cm.guardarMateria("Virtual Systems and Services", "Itinerario Aplicaciones", 7);

        cm.guardarMateria("Etica Profesional", "Basica", 8);
        cm.guardarMateria("Proyectos Tecnológicos 2", "Basica", 8);
        cm.guardarMateria("Servicio Comunitario 1", "Basica", 8);

        cm.guardarMateria("Machine Learningn", "Itinerario IA", 8);
        cm.guardarMateria("Human Perception in Computer Vision", "Itinerario IA", 8);

        cm.guardarMateria("Software Quality", "Itinerario Software", 8);
        cm.guardarMateria("Software Security", "Itinerario Software", 8);

        cm.guardarMateria("Cybersecurity", "Itinerario Aplicaciones", 8);
        cm.guardarMateria("Data Science", "Itinerario Aplicaciones", 8);

        cm.guardarMateria("Composición deTextos Científicos en Ingeniería", "Basica", 9);
        cm.guardarMateria("Laborales 2", "Basica", 9);
        cm.guardarMateria("Servicio Comunitario 2", "Basica", 9);
        cm.guardarMateria("Tranajo de Integracion Curricular", "Basica", 9);
    }
}
