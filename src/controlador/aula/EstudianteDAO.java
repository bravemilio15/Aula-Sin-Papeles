/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.aula;

import controlador.dao.AdaptadorDao;
import controlador.ed.listas.LinkedList;
import modelo.Estudiante;

/**
 *
 * @author Bravo
 */
public class EstudianteDAO extends AdaptadorDao<Estudiante> {

    private Estudiante estudiante = new Estudiante();
    private LinkedList<Estudiante> estudiantes = new LinkedList<>();

    public EstudianteDAO() {
        super(Estudiante.class);
    }

    public LinkedList<Estudiante> getEstudiantes() {
        if (estudiantes.isEmpty()) {
            estudiantes = listar();
        }
        return estudiantes;
    }

    public void setEstudiantes(LinkedList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public Estudiante getEstudiante() {
        if (estudiante == null) {
            estudiante = new Estudiante();
        }
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Integer save() throws Exception {
        estudiante.setEstudiante_Id(generated_id());
        return guardar(estudiante);
    }

    public void update() throws Exception {
        modificar(estudiante);
    }

    private Integer BuscarIndex(Integer id) {
        Integer index = -1;

        if (!listar().isEmpty()) {
            Estudiante[] estudiantes = listar().toArray();
            for (int i = 0; i < estudiantes.length; i++) {
                if (id.intValue() == estudiantes[i].getEstudiante_Id().intValue()) {
                    index = 1;
                    break;
                }
            }
        }
        return index;

    }

    public static void main(String[] args) throws Exception {
        EstudianteDAO r = new EstudianteDAO();

//                r.getEstudiante().setNombre("Estudiante");
//                r.getEstudiante().setDescripcion("Es Estudiante");
//                r.save();
//                r.getEstudiante().setNombre("Docente");
//                r.getEstudiante().setDescripcion("Es Docente");
//                r.save();
//                
//                r.getEstudiante().setNombre("Secretaria");
//                r.getEstudiante().setDescripcion("Es secre");
//                r.save();
//                var estudiante = r.obtener(3);
//                System.out.println(estudiante);
//                estudiante.setNombre("Secretaria");
//                estudiante.setDescripcion("Es Secretaria");
//                r.modificar(estudiante);
    }
}
