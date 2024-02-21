/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.aula.UsuarioDAO;

/**
 *
 * @author Bravo
 */
public class ControllerUsuario {
    UsuarioDAO cd = new UsuarioDAO();
      
      public Integer validadorRol(String dni){
          return cd.verificarRol("correo_Institucional",dni ).getRol_Id();
      }
}
