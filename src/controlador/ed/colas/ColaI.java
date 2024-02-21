/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.ed.colas;

import controlador.ed.ecepciones.PosicionException;
import controlador.ed.ecepciones.TopeException;
import controlador.ed.ecepciones.VacioException;
import controlador.ed.listas.LinkedList;



/**
 *
 * @author walter
 */
public class ColaI<E> extends LinkedList<E>{
    private Integer tope;

    public ColaI(Integer tope) {
        this.tope = tope;
    }
    public Boolean isFull() {
        return (getSize() >= tope ); 
    }
    // 7 
    //9
    //7 -- 9
    //4
    //7 -- 9 --4
    public void queue(E dato) throws TopeException{
        if(isFull())
            throw new TopeException("Cola sin espacio");
        else this.add(dato);
    }
    //7 -- 9 --4
    //9 --- 4
    //4
    public E dequeue() throws VacioException, PosicionException {
        E dato = null;
        if(isEmpty()) {
            throw new VacioException("Cola vacia");
        } else {
            return this.delete(0);
        }
    }

    public Integer getTope() {
        return tope;
    }
    
    
    
}
