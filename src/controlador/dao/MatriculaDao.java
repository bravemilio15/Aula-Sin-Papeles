/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.ed.lista.exception.EmptyException;
import controlador.ed.lista.exception.PositionException;
import java.io.IOException;
import modelo.Matricula;

/**
 *
 * @author cristian
 */
public class MatriculaDao extends AdaptadorDAO<Matricula>{
    
    private Matricula matricula;
 

    public MatriculaDao() {
        super(Matricula.class);
    }

    public Matricula getMatricula() {
        if (this.matricula == null) {
            this.matricula = new Matricula();
        }
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public void guardar() throws IOException {
        matricula.setId(generateID());
        this.guardar(matricula);
    }

    public void modificar(Integer pos) throws EmptyException, PositionException, IOException {
        this.modificar(matricula, pos);
    }

    private Integer generateID() {
        return listar().size() + 1;
    }
    
}
