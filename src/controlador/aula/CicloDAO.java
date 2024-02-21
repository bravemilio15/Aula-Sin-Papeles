/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.aula;

import controlador.dao.AdaptadorDao;
import controlador.ed.listas.LinkedList;
import modelo.Ciclo;

/**
 *
 * @author Bravo
 */
public class CicloDAO extends AdaptadorDao<Ciclo> {

    private Ciclo ciclo = new Ciclo();
    private LinkedList<Ciclo> ciclos = new LinkedList<>();

    public CicloDAO() {
        super(Ciclo.class);
    }

    public LinkedList<Ciclo> getCiclos() {
        if (ciclos.isEmpty()) {
            ciclos = listar();
        }
        return ciclos;
    }

    public void setCiclos(LinkedList<Ciclo> ciclos) {
        this.ciclos = ciclos;
    }

    public Ciclo getCiclo() {
        if (ciclo == null) {
            ciclo = new Ciclo();
        }
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }

    public Integer save() throws Exception {
        ciclo.setCiclo_Id(generated_id());
        return guardar(ciclo);
    }

    public void update() throws Exception {
        modificar(ciclo);
    }

    private Integer BuscarIndex(Integer id) {
        Integer index = -1;

        if (!listar().isEmpty()) {
            Ciclo[] ciclos = listar().toArray();
            for (int i = 0; i < ciclos.length; i++) {
                if (id.intValue() == ciclos[i].getCiclo_Id().intValue()) {
                    index = 1;
                    break;
                }
            }
        }
        return index;

    }

    public Integer obtenerIdCicloPorNombre(String nombreCicloSeleccionada) {
        try {
            LinkedList<Ciclo> mallas = listar();

            // Recorrer la lista de mallas
            for (int i = 0; i < mallas.getSize(); i++) {
                Ciclo malla = mallas.get(i);

                // Verificar si el nombre de la malla actual coincide con el nombre buscado
                if (malla.getNombre().equalsIgnoreCase(nombreCicloSeleccionada)) {
                    // Retornar el ID de la malla actual si se encuentra
                    System.out.println("Ciclo encontrado: " + malla.getNombre() + " - ID: " + malla.getCiclo_Id());
                    return malla.getCiclo_Id();
                }
            }
        } catch (Exception e) {
            // Manejar la excepción, por ejemplo, registrándola o lanzándola nuevamente
            e.printStackTrace();
        }

        // Retornar null si no se encuentra ninguna malla con el nombre proporcionado
        System.out.println("Ciclo no encontrado: " + nombreCicloSeleccionada);
        return null;
    }

    public static void main(String[] args) throws Exception {
        CicloDAO r = new CicloDAO();

//                r.getCiclo().setNombre("Estudiante");
//                r.getCiclo().setDescripcion("Es Estudiante");
//                r.save();
//                r.getCiclo().setNombre("Docente");
//                r.getCiclo().setDescripcion("Es Docente");
//                r.save();
//                
//                r.getCiclo().setNombre("Secretaria");
//                r.getCiclo().setDescripcion("Es secre");
//                r.save();
//                var ciclo = r.obtener(3);
//                System.out.println(ciclo);
//                ciclo.setNombre("Secretaria");
//                ciclo.setDescripcion("Es Secretaria");
//                r.modificar(ciclo);
    }
}
