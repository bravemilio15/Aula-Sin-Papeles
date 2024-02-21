/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.aula;

import controlador.dao.AdaptadorDao;
import controlador.ed.listas.LinkedList;
import modelo.Carrera;
import modelo.Malla;

/**
 *
 * @author Bravo
 */
public class CarreraDAO extends AdaptadorDao<Carrera> {

    private Carrera carrera = new Carrera();
    private LinkedList<Carrera> carreras = new LinkedList<>();

    public CarreraDAO() {
        super(Carrera.class);
    }

    public LinkedList<Carrera> getCarreras() {
        if (carreras.isEmpty()) {
            carreras = listar();
        }
        return carreras;
    }

    public void setCarreras(LinkedList<Carrera> carreras) {
        this.carreras = carreras;
    }

    public Carrera getCarrera() {
        if (carrera == null) {
            carrera = new Carrera();
        }
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public Integer save() throws Exception {
        carrera.setCarrera_Id(generated_id());
        return guardar(carrera);
    }

    public void update() throws Exception {
        modificar(carrera);
    }

    private Integer BuscarIndex(Integer id) {
        Integer index = -1;

        if (!listar().isEmpty()) {
            Carrera[] carreras = listar().toArray();
            for (int i = 0; i < carreras.length; i++) {
                if (id.intValue() == carreras[i].getCarrera_Id().intValue()) {
                    index = 1;
                    break;
                }
            }
        }
        return index;

    }

    

    public String obtenerNombreCarreraPorId(Integer idCarrera) {
        try {
            // Obtener la lista de roles
            LinkedList<Carrera> roles = listar();

            // Recorrer la lista de roles
            for (int i = 0; i < roles.getSize(); i++) {
                Carrera rol = roles.get(i);

                // Verificar si el ID del rol actual coincide con el ID buscado
                if (rol.getCarrera_Id().equals(idCarrera)) {
                    // Retornar el nombre del rol actual si se encuentra
                    return rol.getNombre_Carrera();
                }
            }
        } catch (Exception e) {
            // Manejar la excepción, por ejemplo, registrándola o lanzándola nuevamente
            e.printStackTrace();
        }

        // Retornar null si no se encuentra ningún rol con el ID proporcionado
        return null;
    }

    public static void main(String[] args) throws Exception {
        CarreraDAO r = new CarreraDAO();

//                r.getCarrera().setNombre("Estudiante");
//                r.getCarrera().setDescripcion("Es Estudiante");
//                r.save();
//                r.getCarrera().setNombre("Docente");
//                r.getCarrera().setDescripcion("Es Docente");
//                r.save();
//                
//                r.getCarrera().setNombre("Secretaria");
//                r.getCarrera().setDescripcion("Es secre");
//                r.save();
//                var carrera = r.obtener(3);
//                System.out.println(carrera);
//                carrera.setNombre("Secretaria");
//                carrera.setDescripcion("Es Secretaria");
//                r.modificar(carrera);
    }
}
