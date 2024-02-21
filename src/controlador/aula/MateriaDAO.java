/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.aula;

import controlador.dao.*;
import controlador.ed.listas.LinkedList;
import modelo.Ciclo;
import modelo.Materia;

/**
 *
 * @author Bravo
 */
public class MateriaDAO extends AdaptadorDao<Materia> {

    private Materia materia = new Materia();
    private LinkedList<Materia> materias = new LinkedList<>();

    public MateriaDAO() {
        super(Materia.class);
    }

    public LinkedList<Materia> getMaterias() {
        if (materias.isEmpty()) {
            materias = listar();
        }
        return materias;
    }

    public void setMaterias(LinkedList<Materia> materias) {
        this.materias = materias;
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

    public Integer save() throws Exception {
        materia.setMateria_Id(generated_id());
        return guardar(materia);
    }

    public void update() throws Exception {
        modificar(materia);
    }

    private Integer BuscarIndex(Integer id) {
        Integer index = -1;

        if (!listar().isEmpty()) {
            Materia[] materias = listar().toArray();
            for (int i = 0; i < materias.length; i++) {
                if (id.intValue() == materias[i].getMateria_Id().intValue()) {
                    index = 1;
                    break;
                }
            }
        }
        return index;

    }

}
