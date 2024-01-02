/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.dao.EstudianteDao;
import controlador.dao.MateriaDao;
import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.EmptyException;
import controlador.ed.lista.exception.IndexListException;
import controlador.ed.lista.exception.NonExistentElementException;
import controlador.ed.lista.exception.PositionException;
import controlador.ed.lista.exception.VacioException;
import java.awt.List;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import modelo.Estudiante;
import modelo.Materia;
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

    

}
