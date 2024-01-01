/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.ed.lista;

/**
 *
 * @author cristian
 */
public class NodoLista<E> {

    private E info;
    private NodoLista sig;

    public NodoLista() {
        sig = null;
        info = null;
    }

    public NodoLista(NodoLista sig, E info) {
        this.sig = sig;
        this.info = info;

    }

    public E getInfo() {
        return info;
    }

    public void setInfo(E info) {
        this.info = info;
    }

    public NodoLista getSig() {
        return sig;
    }

    public void setSig(NodoLista sig) {
        this.sig = sig;
    }

}
