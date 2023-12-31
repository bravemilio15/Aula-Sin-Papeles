/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.ed.lista.exception.EmptyException;
import controlador.ed.lista.exception.PositionException;
import java.io.IOException;
import modelo.MateriaI;


public class MateriaDaoItinerario extends AdaptadorDAO<MateriaI>{
    
    private MateriaI materiaI;
 

    public MateriaDaoItinerario() {
        super(MateriaI.class);
    }

    public MateriaI getMateriaI() {
        if (this.materiaI == null) {
            this.materiaI = new MateriaI();
        }
        return materiaI;
    }

    public void setMateriaI(MateriaI materiaI) {
        this.materiaI = materiaI;
    }

    public void guardar() throws IOException {
        materiaI.setId(generateID());
        this.guardar(materiaI);
    }

    public void modificar(Integer pos) throws EmptyException, PositionException, IOException {
        this.modificar(materiaI, pos);
    }

    private Integer generateID() {
        return listar().size() + 1;
    }
    
}
