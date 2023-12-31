/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.ed.lista.exception.EmptyException;
import controlador.ed.lista.exception.PositionException;
import java.io.IOException;
import modelo.Docente;

/**
 *
 * @author cristian
 */
public class DocenteDao extends AdaptadorDAO<Docente>{
    
    private Docente docente;
 

    public DocenteDao() {
        super(Docente.class);
    }

    public Docente getDocente() {
        if (this.docente == null) {
            this.docente = new Docente();
        }
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public void guardar() throws IOException {
        docente.setId(generateID());
        this.guardar(docente);
    }

    public void modificar(Integer pos) throws EmptyException, PositionException, IOException {
        this.modificar(docente, pos);
    }

    private Integer generateID() {
        return listar().size() + 1;
    }
    
}
