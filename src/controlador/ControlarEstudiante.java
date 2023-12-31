/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.dao.EstudianteDao;
import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.EmptyException;
import controlador.ed.lista.exception.PositionException;
import java.io.IOException;
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

        ListaEnlazada<Matricula> matriculas;
        matriculas = new ListaEnlazada<>();

        for (int i = 0; i < 3; i++) {
            matriculas.insertar(new Matricula());
        }
        estudiante.setMatriculas(matriculas);
        estudiante.setId(estudiantes.size() + 1);
        estudiantes.insertar(estudiante);

        guardarDao();
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

}
