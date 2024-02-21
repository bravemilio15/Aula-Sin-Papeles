/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.aula;

import controlador.dao.AdaptadorDao;
import controlador.ed.listas.LinkedList;
import modelo.PeriodoAcademico;
import modelo.Malla;

/**
 *
 * @author Bravo
 */
public class PeriodoDAO extends AdaptadorDao<PeriodoAcademico> {

    private PeriodoAcademico periodo = new PeriodoAcademico();
    private LinkedList<PeriodoAcademico> periodos = new LinkedList<>();

    public PeriodoDAO() {
        super(PeriodoAcademico.class);
    }

    public LinkedList<PeriodoAcademico> getPeriodoAcademicos() {
        if (periodos.isEmpty()) {
            periodos = listar();
        }
        return periodos;
    }

    public void setPeriodoAcademicos(LinkedList<PeriodoAcademico> periodos) {
        this.periodos = periodos;
    }

    public PeriodoAcademico getPeriodoAcademico() {
        if (periodo == null) {
            periodo = new PeriodoAcademico();
        }
        return periodo;
    }

    public void setPeriodoAcademico(PeriodoAcademico periodo) {
        this.periodo = periodo;
    }

    public Integer save() throws Exception {
        periodo.setPeriodo_Id(generated_id());
        return guardar(periodo);
    }

    public void update() throws Exception {
        modificar(periodo);
    }

    private Integer BuscarIndex(Integer id) {
        Integer index = -1;

        if (!listar().isEmpty()) {
            PeriodoAcademico[] periodos = listar().toArray();
            for (int i = 0; i < periodos.length; i++) {
                if (id.intValue() == periodos[i].getPeriodo_Id().intValue()) {
                    index = 1;
                    break;
                }
            }
        }
        return index;

    }

    

    public static void main(String[] args) throws Exception {
        PeriodoDAO r = new PeriodoDAO();

//                r.getPeriodoAcademico().setNombre("Estudiante");
//                r.getPeriodoAcademico().setDescripcion("Es Estudiante");
//                r.save();
//                r.getPeriodoAcademico().setNombre("Docente");
//                r.getPeriodoAcademico().setDescripcion("Es Docente");
//                r.save();
//                
//                r.getPeriodoAcademico().setNombre("Secretaria");
//                r.getPeriodoAcademico().setDescripcion("Es secre");
//                r.save();
//                var periodo = r.obtener(3);
//                System.out.println(periodo);
//                periodo.setNombre("Secretaria");
//                periodo.setDescripcion("Es Secretaria");
//                r.modificar(periodo);
    }
}
