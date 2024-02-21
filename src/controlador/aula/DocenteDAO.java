/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contdocenteador.aula;

import controlador.dao.*;
import controlador.ed.listas.LinkedList;
import modelo.Docente;
import modelo.Docente;

/**
 *
 * @author Bravo
 */
public class DocenteDAO extends AdaptadorDao<Docente> {

    private Docente docente = new Docente();
    private LinkedList<Docente> docentes = new LinkedList<>();

    public DocenteDAO() {
        super(Docente.class);
    }

    public LinkedList<Docente> getDocentes() {
        if (docentes.isEmpty()) {
            docentes = listar();
        }
        return docentes;
    }

    public void setDocentes(LinkedList<Docente> docentes) {
        this.docentes = docentes;
    }

    public Docente getDocente() {
        if (docente == null) {
            docente = new Docente();
        }
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Integer save() throws Exception {
        docente.setDocente_Id(generated_id());
        return guardar(docente);
    }

    public void update() throws Exception {
        modificar(docente);
    }

    private Integer BuscarIndex(Integer id) {
        Integer index = -1;

        if (!listar().isEmpty()) {
            Docente[] docentes = listar().toArray();
            for (int i = 0; i < docentes.length; i++) {
                if (id.intValue() == docentes[i].getDocente_Id().intValue()) {
                    index = 1;
                    break;
                }
            }
        }
        return index;

    }

    

    public static void main(String[] args) throws Exception {
        DocenteDAO r = new DocenteDAO();

//                r.getDocente().setNombre("Estudiante");
//                r.getDocente().setDescripcion("Es Estudiante");
//                r.save();
//                r.getDocente().setNombre("Docente");
//                r.getDocente().setDescripcion("Es Docente");
//                r.save();
//                
//                r.getDocente().setNombre("Secretaria");
//                r.getDocente().setDescripcion("Es secre");
//                r.save();
//        var docente = r.obtener(3);
//        System.out.println(docente);
//        docente.setNombre("Secretaria");
//        docente.setDescripcion("Es Secretaria");
//        r.modificar(docente);

    }
}
