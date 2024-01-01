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
    
    public void registrar(){
        docente.setId(docentes.size()+1);
        docentes.insertar(docente);
        guardarDao();
    }

    public void guardarDao() {
        try {
            docenteDao.guardar(docente);
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public void guardarDocente(String primerNombre, String segundoNombre, String primerApellido, String segundoApellido,
            String cedula, String celular, String estado, String nacimiento, Integer edad, String genero,
            String correoPer, String correoIns, String especialidad, String gradoAcademico, String experienciaEducativa)
            throws IOException {

        Docente nuevoDocente = new Docente();
        
        nuevoDocente.setPrimer_nombre(primerNombre);
        nuevoDocente.setSegundo_nombre(segundoNombre);
        nuevoDocente.setPrimer_apellido(primerApellido);
        nuevoDocente.setSegundo_apellido(segundoApellido);
        nuevoDocente.setCedula(cedula);
        nuevoDocente.setCelular(celular);
        nuevoDocente.setEstado(estado);
        nuevoDocente.setNacimiento(nacimiento);
        nuevoDocente.setEdad(edad);
        nuevoDocente.setGenero(genero);
        nuevoDocente.setCorreoPer(correoPer);
        nuevoDocente.setCorreoIns(correoIns);
        nuevoDocente.setEspecialidad(especialidad);
        nuevoDocente.setGrado_academico(gradoAcademico);
        nuevoDocente.setExperiencia_educativa(experienciaEducativa);

        try {
            docenteDao.guardar(nuevoDocente);
        } catch (IOException ex) {
            System.out.println("Error al guardar docente: " + ex.getMessage());
            throw ex; // Re-lanzar la excepción para que sea manejada en un nivel superior si es necesario
        }
    }

}
