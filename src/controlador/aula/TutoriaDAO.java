/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.aula;

import controlador.dao.AdaptadorDao;
import controlador.ed.listas.LinkedList;
import modelo.Tutoria;
import modelo.Malla;

/**
 *
 * @author Bravo
 */
public class TutoriaDAO extends AdaptadorDao<Tutoria> {

    private Tutoria tutoria = new Tutoria();
    private LinkedList<Tutoria> tutorias = new LinkedList<>();

    public TutoriaDAO() {
        super(Tutoria.class);
    }

    public LinkedList<Tutoria> getTutorias() {
        if (tutorias.isEmpty()) {
            tutorias = listar();
        }
        return tutorias;
    }

    public void setTutorias(LinkedList<Tutoria> tutorias) {
        this.tutorias = tutorias;
    }

    public Tutoria getTutoria() {
        if (tutoria == null) {
            tutoria = new Tutoria();
        }
        return tutoria;
    }

    public void setTutoria(Tutoria tutoria) {
        this.tutoria = tutoria;
    }

    public Integer save() throws Exception {
        tutoria.setTutoria_Id(generated_id());
        return guardar(tutoria);
    }

    public void update() throws Exception {
        modificar(tutoria);
    }

    private Integer BuscarIndex(Integer id) {
        Integer index = -1;

        if (!listar().isEmpty()) {
            Tutoria[] tutorias = listar().toArray();
            for (int i = 0; i < tutorias.length; i++) {
                if (id.intValue() == tutorias[i].getTutoria_Id().intValue()) {
                    index = 1;
                    break;
                }
            }
        }
        return index;

    }

    public static void main(String[] args) throws Exception {
        TutoriaDAO r = new TutoriaDAO();

//                r.getTutoria().setNombre("Estudiante");
//                r.getTutoria().setDescripcion("Es Estudiante");
//                r.save();
//                r.getTutoria().setNombre("Docente");
//                r.getTutoria().setDescripcion("Es Docente");
//                r.save();
//                
//                r.getTutoria().setNombre("Secretaria");
//                r.getTutoria().setDescripcion("Es secre");
//                r.save();
//                var tutoria = r.obtener(3);
//                System.out.println(tutoria);
//                tutoria.setNombre("Secretaria");
//                tutoria.setDescripcion("Es Secretaria");
//                r.modificar(tutoria);
    }
}
