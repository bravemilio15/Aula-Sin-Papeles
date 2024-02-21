/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.aula.CuentaDAO;

/**
 *
 * @author Bravo
 */
public class ControllerCuenta {
      CuentaDAO cd = new CuentaDAO();
      
      public Boolean login(String nombre, String clave){
          return cd.verificarCuenta(nombre, clave);
      }
      
}
  
    

      
    
  
    

    

