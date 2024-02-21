/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.aula;

import controlador.dao.AdaptadorDao;
import controlador.ed.listas.LinkedList;
import modelo.Matricula_Materia;

/**
 *
 * @author Bravo
 */
public class Matricula_MateriaDAO extends AdaptadorDao<Matricula_Materia> {

    private Matricula_Materia cuenta = new Matricula_Materia();
    private LinkedList<Matricula_Materia> cuentas = new LinkedList<>();

    public Matricula_MateriaDAO() {
        super(Matricula_Materia.class);
    }

    public LinkedList<Matricula_Materia> getMatricula_Materias() {
        if (cuentas.isEmpty()) {
            cuentas = listar();
        }
        return cuentas;
    }

    public void setMatricula_Materias(LinkedList<Matricula_Materia> cuentas) {
        this.cuentas = cuentas;
    }

    public Matricula_Materia getMatricula_Materia() {
        if (cuenta == null) {
            cuenta = new Matricula_Materia();
        }
        return cuenta;
    }

    public void setMatricula_Materia(Matricula_Materia cuenta) {
        this.cuenta = cuenta;
    }

    public Integer save() throws Exception {
        return guardar(cuenta);
    }

    public void update() throws Exception {
        modificar(cuenta);
    }

    
}
