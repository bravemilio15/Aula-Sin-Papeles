/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.aula;

import controlador.dao.*;
import controlador.ed.listas.LinkedList;
import modelo.Ciclo;
import modelo.Matricula;

/**
 *
 * @author Bravo
 */
public class MatriculaDAO extends AdaptadorDao<Matricula> {

    private Matricula matricula = new Matricula();
    private LinkedList<Matricula> matriculas = new LinkedList<>();

    public MatriculaDAO() {
        super(Matricula.class);
    }

    public LinkedList<Matricula> getMatriculas() {
        if (matriculas.isEmpty()) {
            matriculas = listar();
        }
        return matriculas;
    }

    public void setMatriculas(LinkedList<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    public Matricula getMatricula() {
        if (matricula == null) {
            matricula = new Matricula();
        }
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Integer save() throws Exception {
        matricula.setMatricula_Id(generated_id());
        return guardar(matricula);
    }

    public void update() throws Exception {
        modificar(matricula);
    }

    private Integer BuscarIndex(Integer id) {
        Integer index = -1;

        if (!listar().isEmpty()) {
            Matricula[] matriculas = listar().toArray();
            for (int i = 0; i < matriculas.length; i++) {
                if (id.intValue() == matriculas[i].getMatricula_Id().intValue()) {
                    index = 1;
                    break;
                }
            }
        }
        return index;

    }

}
