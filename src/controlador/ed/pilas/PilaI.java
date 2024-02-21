/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.ed.pilas;

import controlador.ed.ecepciones.PosicionException;
import controlador.ed.ecepciones.TopeException;
import controlador.ed.ecepciones.VacioException;
import controlador.ed.listas.LinkedList;

/**
 *
 * @author walter
 */
public class PilaI<E> extends LinkedList<E> {

    private Integer cima;

    public PilaI(Integer cima) {
        this.cima = cima;
    }

    public Boolean isFull() {
        return (getSize() >= cima);
    }

    //7
    //10
    //10 --- 7
    //8
    //8 -- 10 -- 7
    public void push(E info) throws TopeException {
        if (!isFull()) {
            addFirst(info);
        } else {
            throw new TopeException();
        }
    }

    //8 -- 10 -- 7
    //10  -- 7
    //7
    //9  -- 8  --- 6 -- 3
    public E pop() throws VacioException, PosicionException {
        E dato = null;
        if (isEmpty()) {
            throw new VacioException("Pila vacia");
        } else {
            return this.delete(0);
        }
    }

    public Integer getCima() {
        return cima;
    }

}
