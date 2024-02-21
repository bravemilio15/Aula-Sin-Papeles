/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.ed.ecepciones;

/**
 *
 * @author walter
 */
public class EspacioException extends Exception {

    public EspacioException(String message) {
        super(message);
    }
    
    public EspacioException() {
        super("No hay espacio suficiente o posicion no valida");
    }
    
}
