/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.ed.lista.exception.EmptyException;
import controlador.ed.lista.exception.PositionException;
import java.io.IOException;
import modelo.Estudiante;


public class EstudianteDao extends AdaptadorDAO<Estudiante>{
    
    private Estudiante estudiante;
 

    public EstudianteDao() {
        super(Estudiante.class);
    }

    public Estudiante getEstudiante() {
        if (this.estudiante == null) {
            this.estudiante = new Estudiante();
        }
        return estudiante;
    }

    public void setEstudiante(Estudiante usuario) {
        this.estudiante = usuario;
    }

    public void guardar() throws IOException {
        estudiante.setId(generateID());
        this.guardar(estudiante);
    }

    public void modificar(Integer pos) throws EmptyException, PositionException, IOException {
        this.modificar(estudiante, pos);
    }

    private Integer generateID() {
        return listar().size() + 1;
    }
    
}
