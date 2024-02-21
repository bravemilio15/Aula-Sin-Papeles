/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.ed.pilas;

import controlador.ed.ecepciones.PosicionException;
import controlador.ed.ecepciones.TopeException;
import controlador.ed.ecepciones.VacioException;

/**
 *
 * @author walter
 */
public class Pila <E> {
    private PilaI<E> pilai;

    public Pila(Integer cima) {
        pilai = new PilaI<>(cima);
    } 

    public void push(E obj) throws TopeException  {
        pilai.push(obj);
    }
    
    public E pop() throws VacioException, PosicionException {
        return pilai.pop();
    }
    
    public Integer getCima() {
        return pilai.getCima();
    }
    
    public void print() throws VacioException  {
        pilai.print();
    }
    
    public Integer size() {
        return pilai.getSize();
    }
    
}
