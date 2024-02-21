/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.aula;

import controlador.dao.*;
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

    public String obtenerNombrePorIdEstudiante(Integer idEstudiante) throws Exception {
        LinkedList<Usuario> usuarios = listar();

        for (int i = 0; i < usuarios.getSize(); i++) {
            Usuario usuario = usuarios.get(i);

            if (usuario.getUsuario_Id().equals(idEstudiante)) {
                return usuario.getPrimer_Nombre();
            }
        }

        return null;
    }

    public String obtenerApellidoPorIdEstudiante(Integer idEstudiante) throws Exception {
        LinkedList<Usuario> usuarios = listar();

        for (int i = 0; i < usuarios.getSize(); i++) {
            Usuario usuario = usuarios.get(i);

            if (usuario.getUsuario_Id().equals(idEstudiante)) {
                return usuario.getPrimer_Apellido();
            }
        }

        return null;
    }

    public String obtenerDniPorIdEstudiante(Integer idEstudiante) throws Exception {
        LinkedList<Usuario> usuarios = listar();

        for (int i = 0; i < usuarios.getSize(); i++) {
            Usuario usuario = usuarios.get(i);

            if (usuario.getUsuario_Id().equals(idEstudiante)) {
                return usuario.getDni();
            }
        }

        return null;
    }

    public String obtenerNombrePorIdDocente(Integer idDocente) throws Exception {
        LinkedList<Usuario> usuarios = listar();

        for (int i = 0; i < usuarios.getSize(); i++) {
            Usuario usuario = usuarios.get(i);

            if (usuario.getUsuario_Id().equals(idDocente)) {
                return usuario.getPrimer_Nombre();
            }
        }

        return null;
    }

    public String obtenerApellidoPorIdDocente(Integer idDocente) throws Exception {
        LinkedList<Usuario> usuarios = listar();

        for (int i = 0; i < usuarios.getSize(); i++) {
            Usuario usuario = usuarios.get(i);

            if (usuario.getUsuario_Id().equals(idDocente)) {
                return usuario.getPrimer_Apellido();
            }
        }

        return null;
    }

    public String obtenerDniPorIdDocente(Integer idDocente) throws Exception {
        LinkedList<Usuario> usuarios = listar();

        for (int i = 0; i < usuarios.getSize(); i++) {
            Usuario usuario = usuarios.get(i);

            if (usuario.getUsuario_Id().equals(idDocente)) {
                return usuario.getDni();
            }
        }

        return null;
    }

    public LinkedList<Usuario> buscarPorNombre(String nombre) throws Exception {
        LinkedList<Usuario> usuarios = listar();
        LinkedList<Usuario> resultados = new LinkedList<>();

        for (int i = 0; i < usuarios.getSize(); i++) {
            Usuario usuario = usuarios.get(i);
            if (usuario.getPrimer_Nombre().equalsIgnoreCase(nombre)
                    || (usuario.getSegundo_Nombre() != null && usuario.getSegundo_Nombre().equalsIgnoreCase(nombre))) {
                resultados.add(usuario);
            }
        }

        // Verificar si hay usuarios con ambos nombres
        LinkedList<Usuario> resultadosFiltrados = new LinkedList<>();
        for (int i = 0; i < resultados.getSize(); i++) {
            Usuario usuario = resultados.get(i);
            // Buscar otros usuarios con el mismo ID (mismo usuario)
            boolean mismoId = true;
            for (int j = 0; j < resultados.getSize(); j++) {
                Usuario otroUsuario = resultados.get(j);
                if (!usuario.getUsuario_Id().equals(otroUsuario.getUsuario_Id())) {
                    mismoId = false;
                    break;
                }
            }
            // Si todos los resultados tienen el mismo ID, agregarlos a los resultados filtrados
            if (mismoId) {
                resultadosFiltrados.add(usuario);
            }
        }

        return resultadosFiltrados;
    }

    public LinkedList<Usuario> buscarPorCedula(String cedula) throws Exception {
        LinkedList<Usuario> usuarios = listar();
        LinkedList<Usuario> resultados = new LinkedList<>();

        for (int i = 0; i < usuarios.getSize(); i++) {
            Usuario usuario = usuarios.get(i);
            if (usuario.getDni().equalsIgnoreCase(cedula)) {
                resultados.add(usuario);
            }
        }

        return resultados;
    }

    public Usuario buscarPorId(Integer idUsuario) throws Exception {
        LinkedList<Usuario> usuarios = listar();

        for (int i = 0; i < usuarios.getSize(); i++) {
            Usuario usuario = usuarios.get(i);
            if (usuario.getUsuario_Id().equals(idUsuario)) {
                return usuario;
            }
        }

        return null; // Retornar null si no se encuentra ningún usuario con el ID especificado
    }

    public Usuario verificarRol(String atributo, Object rol) {
        crear();
        var usuarios = listar();


        try {

            usuarios.mergeSort(atributo, true);

            usuario = usuarios.binarySearch(atributo, rol);

  
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return usuario;

    }
    
    private void crear(){
        usuario = new Usuario();
        
    }

}
