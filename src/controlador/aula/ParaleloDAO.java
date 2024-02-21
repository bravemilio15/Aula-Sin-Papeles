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

    public Paralelo obtenerParaleloPorNombre(String nombreParalelo) throws Exception {
        LinkedList<Paralelo> paralelos = listar();
        for (int i = 0; i < paralelos.getSize(); i++) {
            Paralelo paralelo = paralelos.get(i);
            if (paralelo.getNombre().equals(nombreParalelo)) {
                return paralelo;
            }
        }
        return null; // Si no se encuentra el paralelo, devolvemos null
    }

    public Integer buscarIdParalelo(Paralelo paraleloSeleccionado) throws Exception {
        LinkedList<Paralelo> paralelos = listar();
        for (int i = 0; i < paralelos.getSize(); i++) {
            Paralelo paralelo = paralelos.get(i);
            if (paralelo.getNombre().equals(paraleloSeleccionado.getNombre())) {
                return paralelo.getParalelo_Id();
            }
        }
        throw new Exception("El paralelo seleccionado no se encuentra en la base de datos.");
    }
    
    public Paralelo obtenerPorNombre(String nombreParalelo) throws Exception {
        LinkedList<Paralelo> materias = listar();
        for (int i = 0; i < materias.getSize(); i++) {
            Paralelo materia = materias.get(i);
            if (materia.getNombre().equals(nombreParalelo)) {
                return materia;
            }
        }
        return null; // Si no se encuentra ninguna materia con el nombre proporcionado
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
