/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.dao.EstudianteDao;
import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.EmptyException;
import controlador.ed.lista.exception.IndexListException;
import controlador.ed.lista.exception.NonExistentElementException;
import controlador.ed.lista.exception.PositionException;
import controlador.ed.lista.exception.VacioException;
import java.io.IOException;
import java.lang.reflect.Field;
import modelo.Estudiante;
import modelo.Matricula;

/**
 *
 * @author cristian
 */
public class ControlarEstudiante {

    private ListaEnlazada<Estudiante> estudiantes;
    private EstudianteDao estudianteDao;
    private Estudiante estudiante;

    public ControlarEstudiante() {
        this.estudianteDao = new EstudianteDao();
        this.estudiantes = estudianteDao.listar();
    }

    public ListaEnlazada<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ListaEnlazada<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public EstudianteDao getEstudianteDao() {
        return estudianteDao;
    }

    public void setEstudianteDao(EstudianteDao estudianteDao) {
        this.estudianteDao = estudianteDao;
    }

    public ListaEnlazada<Estudiante> listar() {
        return estudianteDao.listar();
    }

    public Estudiante getEstudiante() {
        if (estudiante == null) {
            estudiante = new Estudiante();
        }
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public void registrar() {
        estudiante.setMatriculas(new ListaEnlazada<>());
        estudiante.setId(estudiantes.size() + 1);
        estudiantes.insertar(estudiante);
        guardarDao();
    }

    public void agregarMatricula(String carrera, String estado, String nivel) {
        if (estudiante != null) {
            Matricula nuevaMatricula = new Matricula();
            nuevaMatricula.setCarrera(carrera);
            nuevaMatricula.setEstado(estado);
            nuevaMatricula.setNivel_academico(nivel);

            estudiante.getMatriculas().insertar(nuevaMatricula);
            guardarDao();
        }
    }

    private void guardarDao() {
        try {
            estudianteDao.guardar(estudiante);
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private void modificarDao(int pos) throws EmptyException, PositionException {
        try {
            System.out.println("Pos -> " + pos);
            estudianteDao.modificar(estudiante, pos);
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public void guardarMatricula(int pos, String carrera, String estado, String nivel) throws EmptyException, PositionException {

        if (pos >= 0) {
            if (estudiante != null) {
                estudiante.getMatriculas().get(pos).setCarrera(carrera);
                estudiante.getMatriculas().get(pos).setEstado(estado);
                estudiante.getMatriculas().get(pos).setNivel_academico(nivel);
                modificarDao(estudiante.getId() - 1);
            } else {
                throw new EmptyException("La sucursal esta vacia");
            }
        } else {
            throw new PositionException("La posicion no existe");
        }

    }

    public ListaEnlazada<Estudiante> buscarPorAtributo(String atributo, Object valor, boolean ordenAscendente) {
        try {

            estudiantes.quickSort(atributo, true); // Cambiar el true por false si deseas orden descendente

            ListaEnlazada<Estudiante> resultados = new ListaEnlazada<>();

            if (atributo.equals("primer_apellido")) {
                resultados = estudiantes.linearBinarySearch(atributo, valor);
            } else if (atributo.equals("cedula")) {
                resultados = estudiantes.linearBinarySearch(atributo, valor);
            } else {
                // Si no es uno de los atributos especificados, realizar búsqueda lineal
                for (int i = 0; i < estudiantes.size(); i++) {
                    Estudiante actual = estudiantes.get(i);

                    // Obtener el valor del atributo usando reflexión
                    Field field = actual.getClass().getDeclaredField(atributo);
                    field.setAccessible(true);
                    Object valorAtributo = field.get(actual);

                    // Comparar el valor del atributo con el valor buscado
                    if (valorAtributo != null && valorAtributo.equals(valor)) {
                        resultados.insertar(actual);
                    } else {
                        System.out.println("Valor del atributo " + atributo + " es null para el estudiante con ID " + actual.getId());
                    }

                }
            }
            return resultados;
        } catch (Exception e) {
            System.out.println("Error en la búsqueda: " + e.getMessage());
            return new ListaEnlazada<>(); // Devolver una lista vacía en caso de error
        }
    }

}
