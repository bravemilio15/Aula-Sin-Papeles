/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.aula;

import controlador.dao.*;
import controlador.ed.ecepciones.VacioException;
import controlador.ed.listas.LinkedList;
import modelo.Usuario;

/**
 *
 * @author Bravo
 */
public class UsuarioDAO extends AdaptadorDao<Usuario> {

    private Usuario usuario = new Usuario();
    private LinkedList<Usuario> usuarios = new LinkedList<>();

    public UsuarioDAO() {
        super(Usuario.class);
    }

    public LinkedList<Usuario> getUsuarios() {
        if (usuarios.isEmpty()) {
            usuarios = listar();
        }
        return usuarios;
    }

    public void setUsuarios(LinkedList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario getUsuario() {
        if (usuario == null) {
            usuario = new Usuario();
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Boolean save() throws Exception {
        usuario.setUsuario_Id(generated_id());
        return guardar(usuario) != null;
    }

    public void update() throws Exception {
        modificar(usuario);
    }

    private Integer BuscarIndex(Integer id) {
        Integer index = -1;

        if (!listar().isEmpty()) {
            Usuario[] usuarios = listar().toArray();
            for (int i = 0; i < usuarios.length; i++) {
                if (id.intValue() == usuarios[i].getUsuario_Id().intValue()) {
                    index = 1;
                    break;
                }
            }
        }
        return index;

    }

    public String obtenerNombrePorIdEstudiante(Integer idEstudiante) throws Exception {

        for (int i = 0; i < usuarios.getSize(); i++) {
            Usuario usuario = usuarios.get(i);

            if (usuario.getUsuario_Id().equals(idEstudiante)) {

                return usuario.getPrimer_Nombre();
            }
        }

        return null;
    }

// Método para obtener el apellido del estudiante por su ID
    public String obtenerApellidoPorIdEstudiante(Integer idEstudiante) throws Exception {

        for (int i = 0; i < usuarios.getSize(); i++) {
            Usuario usuario = usuarios.get(i);

            if (usuario.getUsuario_Id().equals(idEstudiante)) {

                return usuario.getPrimer_Apellido();
            }
        }

        return null;
    }

    public String obtenerDniPorIdEstudiante(Integer idEstudiante) throws Exception {
        for (int i = 0; i < usuarios.getSize(); i++) {
            Usuario usuario = usuarios.get(i);
            if (usuario.getUsuario_Id().equals(idEstudiante)) {

                return usuario.getDni();
            }
        }

        return null;
    }

//    public static void main(String[] args) throws Exception {
//
//        UsuarioDAO usuario = new UsuarioDAO();
//
//        usuario.getUsuario().setDni("1105918419");
//        usuario.getUsuario().setPrimer_Nombre("Emilio");
//        usuario.getUsuario().setSegundo_Nombre("Andres");
//        usuario.getUsuario().setPrimer_Apellido("Bravo");
//        usuario.getUsuario().setSegundo_Apellido("Herrera");
//        usuario.getUsuario().setGenero("Masculino");
//        usuario.getUsuario().setCorreo("@example.com");
//        usuario.getUsuario().setCorreo_Institucional("perez@institucion.edu");
//        usuario.getUsuario().setTelefono("123456789");
//        usuario.getUsuario().setEstado(1);
//        usuario.getUsuario().setRol_Id(1);
//
//        usuario.save();
//
//
//    }
}
