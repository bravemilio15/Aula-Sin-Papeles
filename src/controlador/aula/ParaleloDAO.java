/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.aula;

import controlador.dao.AdaptadorDao;
import controlador.ed.listas.LinkedList;
import modelo.Paralelo;

/**
 *
 * @author Bravo
 */
public class ParaleloDAO extends AdaptadorDao<Paralelo> {

    private Paralelo paralelo = new Paralelo();
    private LinkedList<Paralelo> paralelos = new LinkedList<>();

    public ParaleloDAO() {
        super(Paralelo.class);
    }

    public LinkedList<Paralelo> getParalelos() {
        if (paralelos.isEmpty()) {
            paralelos = listar();
        }
        return paralelos;
    }

    public void setParalelos(LinkedList<Paralelo> paralelos) {
        this.paralelos = paralelos;
    }

    public Paralelo getParalelo() {
        if (paralelo == null) {
            paralelo = new Paralelo();
        }
        return paralelo;
    }

    public void setParalelo(Paralelo paralelo) {
        this.paralelo = paralelo;
    }

    public Integer save() throws Exception {
        paralelo.setParalelo_Id(generated_id());
        return guardar(paralelo);
    }

    public void update() throws Exception {
        modificar(paralelo);
    }

    private Integer BuscarIndex(Integer id) {
        Integer index = -1;

        if (!listar().isEmpty()) {
            Paralelo[] paralelos = listar().toArray();
            for (int i = 0; i < paralelos.length; i++) {
                if (id.intValue() == paralelos[i].getParalelo_Id().intValue()) {
                    index = 1;
                    break;
                }
            }
        }
        return index;

    }

    public static void main(String[] args) throws Exception {
        ParaleloDAO r = new ParaleloDAO();

//                r.getParalelo().setNombre("Estudiante");
//                r.getParalelo().setDescripcion("Es Estudiante");
//                r.save();
//                r.getParalelo().setNombre("Docente");
//                r.getParalelo().setDescripcion("Es Docente");
//                r.save();
//                
//                r.getParalelo().setNombre("Secretaria");
//                r.getParalelo().setDescripcion("Es secre");
//                r.save();
//                var paralelo = r.obtener(3);
//                System.out.println(paralelo);
//                paralelo.setNombre("Secretaria");
//                paralelo.setDescripcion("Es Secretaria");
//                r.modificar(paralelo);
    }
}
