/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.dao.MateriaDao;
import controlador.dao.EstudianteDao;
import controlador.ed.lista.ListaEnlazada;
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

    public void guardarMateria(String nombre, Ciclo ciclo) {
        materiaDao.getMateria().setNombre(nombre);
        materiaDao.getMateria().setCiclo(ciclo);
        try {
            materiaDao.guardar();
        } catch (IOException ex) {
            System.out.println("Error");
        }
    }

}
