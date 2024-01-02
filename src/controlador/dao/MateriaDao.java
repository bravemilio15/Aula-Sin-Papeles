/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.EmptyException;
import controlador.ed.lista.exception.PositionException;
import java.io.IOException;
import modelo.Materia;

/**
 *
 * @author cristian
 */
public class MateriaDao extends AdaptadorDAO<Materia> {

    private Materia materia;

    public MateriaDao() {
        super(Materia.class);
    }

    public Materia getMateria() {
        if (this.materia == null) {
            this.materia = new Materia();
        }
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public void guardar() throws IOException {
        materia.setId(generateID());
        super.guardar(materia);
    }

    public void modificar(Integer pos) throws EmptyException, PositionException, IOException {
        super.modificar(materia, pos); 
    }

    private Integer generateID() {
        return generarId();
    }
    
    

    

}
