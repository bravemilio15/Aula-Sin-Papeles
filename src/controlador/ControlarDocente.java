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

    

}
