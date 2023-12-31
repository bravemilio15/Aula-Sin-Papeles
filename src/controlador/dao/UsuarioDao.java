/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.ed.lista.exception.EmptyException;
import controlador.ed.lista.exception.PositionException;
import java.io.IOException;
import modelo.Persona;


public class UsuarioDao extends AdaptadorDAO<Persona>{
    
    private Persona usuario;
 

    public UsuarioDao() {
        super(Persona.class);
    }

    public Persona getUsuario() {
        if (this.usuario == null) {
            this.usuario = new Persona();
        }
        return usuario;
    }

    public void setUsuario(Persona usuario) {
        this.usuario = usuario;
    }

    public void guardar() throws IOException {
        usuario.setId(generateID());
        this.guardar(usuario);
    }

    public void modificar(Integer pos) throws EmptyException, PositionException, IOException {
        this.modificar(usuario, pos);
    }

    private Integer generateID() {
        return listar().size() + 1;
    }
    
}
