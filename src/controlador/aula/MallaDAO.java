/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contmallaador.aula;

import controlador.dao.AdaptadorDao;
import controlador.ed.listas.LinkedList;

import modelo.Malla;

/**
 *
 * @author Bravo
 */
public class MallaDAO extends AdaptadorDao<Malla> {

    private Malla malla = new Malla();
    private LinkedList<Malla> mallas = new LinkedList<>();

    public MallaDAO() {
        super(Malla.class);
    }

    public LinkedList<Malla> getMallas() {
        if (mallas.isEmpty()) {
            mallas = listar();
        }
        return mallas;
    }

    public void setMallas(LinkedList<Malla> mallas) {
        this.mallas = mallas;
    }

    public Malla getMalla() {
        if (malla == null) {
            malla = new Malla();
        }
        return malla;
    }

    public void setMalla(Malla malla) {
        this.malla = malla;
    }

    public Integer save() throws Exception {
        malla.setMalla_Id(generated_id());
        return guardar(malla);
    }

    public void update() throws Exception {
        modificar(malla);
    }

    private Integer BuscarIndex(Integer id) {
        Integer index = -1;

        if (!listar().isEmpty()) {
            Malla[] mallas = listar().toArray();
            for (int i = 0; i < mallas.length; i++) {
                if (id.intValue() == mallas[i].getMalla_Id().intValue()) {
                    index = 1;
                    break;
                }
            }
        }
        return index;

    }

    public Malla obtenerMallaPorNombre(String nombreMalla) throws Exception {
        LinkedList<Malla> mallas = listar();

        for (int i = 0; i < mallas.getSize(); i++) {
            Malla malla = mallas.get(i);

            if (malla.getNombre().equalsIgnoreCase(nombreMalla)) {
                return malla;
            }
        }

        return null; 
    }

    public Integer obtenerIdMallaPorNombre(String nombreMallaSeleccionada) {
        try {
            LinkedList<Malla> mallas = listar();

            // Recorrer la lista de mallas
            for (int i = 0; i < mallas.getSize(); i++) {
                Malla malla = mallas.get(i);

                // Verificar si el nombre de la malla actual coincide con el nombre buscado
                if (malla.getNombre().equalsIgnoreCase(nombreMallaSeleccionada)) {
                    // Retornar el ID de la malla actual si se encuentra
                    return malla.getMalla_Id();
                }
            }
        } catch (Exception e) {
            // Manejar la excepción, por ejemplo, registrándola o lanzándola nuevamente
            e.printStackTrace();
        }

        // Retornar null si no se encuentra ninguna malla con el nombre proporcionado
        return null;
    }

    public static void main(String[] args) throws Exception {
        MallaDAO r = new MallaDAO();

//                r.getMalla().setNombre("Estudiante");
//                r.getMalla().setDescripcion("Es Estudiante");
//                r.save();
//                r.getMalla().setNombre("Docente");
//                r.getMalla().setDescripcion("Es Docente");
//                r.save();
//                
//                r.getMalla().setNombre("Secretaria");
//                r.getMalla().setDescripcion("Es secre");
//                r.save();
//                var malla = r.obtener(3);
//                System.out.println(malla);
//                malla.setNombre("Secretaria");
//                malla.setDescripcion("Es Secretaria");
//                r.modificar(malla);
    }
}
