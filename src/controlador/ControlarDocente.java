package controlador;

import controlador.dao.DocenteDao;
import controlador.ed.lista.ListaEnlazada;
import java.io.IOException;
import modelo.Docente;

public class ControlarDocente {

    private ListaEnlazada<Docente> docentes;
    private DocenteDao docenteDao;
    private Docente docente;

    public ControlarDocente() {
        this.docenteDao = new DocenteDao();
        this.docentes = docenteDao.listar();
    }

    public ListaEnlazada<Docente> getDocentes() {
        return docentes;
    }

    public void setDocentes(ListaEnlazada<Docente> docentes) {
        this.docentes = docentes;
    }

    public DocenteDao getDocenteDao() {
        return docenteDao;
    }

    public void setDocenteDao(DocenteDao docenteDao) {
        this.docenteDao = docenteDao;
    }

    public ListaEnlazada<Docente> listar() {
        return docenteDao.listar();
    }

    public Docente getDocente() {
        if (docente == null) {
            docente = new Docente();
        }
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public void guardarDao() {
        try {
            docenteDao.guardar(docente);
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public void guardarDocente(String nombre, String apellido, String cedula, String celular,
            String estado, String nacimiento, Integer edad, String genero,
            String correoPer, String correoIns, String especialidad,
            String gradoAcademico, String experienciaEducativa) {

        docenteDao.getDocente().setNombre(nombre);
        docenteDao.getDocente().setApellido(apellido);
        docenteDao.getDocente().setCedula(cedula);
        docenteDao.getDocente().setCelular(celular);
        docenteDao.getDocente().setEstado(estado);
        docenteDao.getDocente().setNacimiento(nacimiento);
        docenteDao.getDocente().setEdad(edad);
        docenteDao.getDocente().setGenero(genero);
        docenteDao.getDocente().setCorreoPer(correoPer);
        docenteDao.getDocente().setCorreoIns(correoIns);
        docenteDao.getDocente().setEspecialidad(especialidad);
        docenteDao.getDocente().setGrado_academico(gradoAcademico);
        docenteDao.getDocente().setExperiencia_educativa(experienciaEducativa);
        //usuario.getUsuario().setId_rol(this.rol.buscarRol(rol).getId());
        guardarDao();

    }
}
