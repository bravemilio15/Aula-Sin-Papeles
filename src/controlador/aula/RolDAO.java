/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.aula;

import controlador.dao.*;
import controlador.ed.listas.LinkedList;
import modelo.Rol;
import modelo.Rol;

/**
 *
 * @author Bravo
 */
public class RolDAO extends AdaptadorDao<Rol> {

    private Rol rol = new Rol();
    private LinkedList<Rol> rols = new LinkedList<>();

    public RolDAO() {
        super(Rol.class);
    }

    public LinkedList<Rol> getRols() {
        if (rols.isEmpty()) {
            rols = listar();
        }
        return rols;
    }

    public void setRols(LinkedList<Rol> rols) {
        this.rols = rols;
    }

    public Rol getRol() {
        if (rol == null) {
            rol = new Rol();
        }
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Integer save() throws Exception {
        rol.setRol_Id(generated_id());
        return guardar(rol);
    }

    public void update() throws Exception {
        modificar(rol);
    }

    private Integer BuscarIndex(Integer id) {
        Integer index = -1;

        if (!listar().isEmpty()) {
            Rol[] rols = listar().toArray();
            for (int i = 0; i < rols.length; i++) {
                if (id.intValue() == rols[i].getRol_Id().intValue()) {
                    index = 1;
                    break;
                }
            }
        }
        return index;

    }

    public Integer obtenerIdRolPorNombre(String nombreRol) {
        try {
            // Obtener la lista de roles
            LinkedList<Rol> roles = listar();

            // Recorrer la lista de roles
            for (int i = 0; i < roles.getSize(); i++) {
                Rol rol = roles.get(i);

                // Verificar si el nombre del rol actual coincide con el nombre buscado
                if (rol.getNombre().equalsIgnoreCase(nombreRol)) {
                    // Retornar el ID del rol actual si se encuentra
                    return rol.getRol_Id();
                }
            }
        } catch (Exception e) {
            // Manejar la excepción, por ejemplo, registrándola o lanzándola nuevamente
            e.printStackTrace();
        }

        // Retornar null si no se encuentra ningún rol con el nombre proporcionado
        return null;
    }

    public String obtenerNombreRolPorId(Integer idRol) {
        try {
            // Obtener la lista de roles
            LinkedList<Rol> roles = listar();

            // Recorrer la lista de roles
            for (int i = 0; i < roles.getSize(); i++) {
                Rol rol = roles.get(i);

                // Verificar si el ID del rol actual coincide con el ID buscado
                if (rol.getRol_Id().equals(idRol)) {
                    // Retornar el nombre del rol actual si se encuentra
                    return rol.getNombre();
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
        RolDAO r = new RolDAO();

//                r.getRol().setNombre("Estudiante");
//                r.getRol().setDescripcion("Es Estudiante");
//                r.save();
//                r.getRol().setNombre("Docente");
//                r.getRol().setDescripcion("Es Docente");
//                r.save();
//                
//                r.getRol().setNombre("Secretaria");
//                r.getRol().setDescripcion("Es secre");
//                r.save();
        var rol = r.obtener(3);
        System.out.println(rol);
        rol.setNombre("Secretaria");
        rol.setDescripcion("Es Secretaria");
        r.modificar(rol);

    }
}
