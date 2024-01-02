/*
 * To change this license cabeceraer, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.ed.lista;

import controlador.ed.lista.exception.EmptyException;
import controlador.ed.lista.exception.IndexListException;
import controlador.ed.lista.exception.NonExistentElementException;
import controlador.ed.lista.exception.PositionException;
import controlador.ed.lista.exception.VacioException;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Random;

/**
 *
 * @author cristian
 */
public class ListaEnlazada<E> {

    private NodoLista<E> cabecera;
    private NodoLista<E> last;
    private Integer size = 0;

    public NodoLista getCabecera() {
        return cabecera;
    }

    public void setCabecera(NodoLista cabecera) {
        this.cabecera = cabecera;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public boolean estaVacia() {
        return cabecera == null;
    }

    public boolean insertar(E info) {
        NodoLista<E> nuevo = new NodoLista<>(null, info);
        if (estaVacia()) {

            this.cabecera = nuevo;
            this.size++;
        } else {
            NodoLista<E> aux = cabecera;
//            for (int i = 0; i < size()-1; i++) {
//                aux = aux.getSig();
//            }
            while (aux.getSig() != null) {
                aux = aux.getSig();
            }
            aux.setSig(nuevo);
            this.size++;
        }
        return true;
    }

    public void insertarFinal(E data) {
        if (estaVacia()) {
            insertar(data);
        } else {
            NodoLista<E> aux = new NodoLista<>(null, data);
            last.setSig(aux);
            last = aux;
            size++;
        }

    }

    public boolean contiene(E elemento) {
        NodoLista<E> actual = cabecera;

        while (actual != null) {
            if (actual.getInfo().equals(elemento)) {
                return true; // El elemento ya está en la lista
            }
            actual = actual.getSig();
        }

        return false; // El elemento no está en la lista
    }

    public E getLast() throws VacioException {
        if (estaVacia()) {
            throw new VacioException("Lista Vacia");
        } else {
            return last.getInfo();
        }
    }

    /**
     *
     * @return
     */
    public Integer size() {

        return size;
    }

    public void imprimir() throws EmptyException {
        if (estaVacia()) {
            throw new EmptyException();
        } else {
            NodoLista<E> aux = cabecera;
            System.out.println("----------Lista------------");
            for (int i = 0; i < size(); i++) {
                System.out.println(aux.getInfo());
                aux = aux.getSig();
            }
            System.out.println("----------Lista fin--------------");
        }
    }

    public void insertarInicio(E info) {
        if (estaVacia()) {
            insertar(info);
        } else {
            NodoLista<E> nuevo = new NodoLista<>(null, info);
            nuevo.setSig(cabecera);
            cabecera = nuevo;
            size++;

        }
    }

    public void insertarPosicion(E info, Integer pos) throws PositionException {
        if (estaVacia()) {
            insertar(info);
        } else if (pos >= 0 && pos < size() && pos == 0) {
            insertarInicio(info);
        } else if (pos >= 0 && pos < size()) {
            NodoLista<E> nuevo = new NodoLista<>(null, info);
            NodoLista<E> aux = cabecera;
            for (int i = 0; i < (pos - 1); i++) {
                aux = aux.getSig();
            }
            NodoLista<E> sig = aux.getSig();
            aux.setSig(nuevo);
            nuevo.setSig(sig);
            size++;
        } else {
            throw new PositionException();
        }
    }

    public E get(Integer pos) throws EmptyException, PositionException {
        if (estaVacia()) {
            throw new EmptyException();
        } else {
            E dato = null;
            if (pos >= 0 && pos < size()) {
                if (pos == 0) {
                    dato = cabecera.getInfo();
                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < pos; i++) {
                        aux = aux.getSig();
                    }
                    dato = aux.getInfo();
                }
            } else {
                throw new PositionException();
            }
            return dato;
        }

    }

    public E delete(Integer pos) throws EmptyException, PositionException {
        if (estaVacia()) {
            throw new EmptyException();
        } else {
            E dato = null;
            if (pos >= 0 && pos < size()) {
                if (pos == 0) {
                    dato = cabecera.getInfo();
                    cabecera = cabecera.getSig();
                    size--;
                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < (pos - 1); i++) {
                        aux = aux.getSig();
                    }
                    if ((pos + 1) == size()) {
                        NodoLista<E> aux1 = aux.getSig();
                        // dato = aux.getSig().getInfo();
                    } else {
                        dato = aux.getInfo();
                    }
                    dato = aux.getInfo();
                    NodoLista<E> proximo = aux.getSig();
                    aux.setSig(proximo.getSig());
                    size--;
                }
            } else {

                throw new PositionException();
            }
            return dato;
        }

    }

    public void deleteAll() {
        this.cabecera = null;
        this.size = 0;
    }

    public void update(Integer pos, E dato) throws EmptyException, PositionException {
        if (estaVacia()) {
            throw new EmptyException();
        } else {
            if (pos >= 0 && pos < size()) {
                if (pos == 0) {
                    dato = cabecera.getInfo();

                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < pos; i++) {
                        aux = aux.getSig();
                    }
                    aux.setInfo(dato);
                }
            } else {
                throw new PositionException();
            }
        }

    }

    public E[] toArray() {
        Class clazz = null;
        E[] matriz = null;
        if (this.size > 0) {
            clazz = cabecera.getInfo().getClass();
            matriz = (E[]) java.lang.reflect.Array.newInstance(clazz, size);
            NodoLista<E> aux = cabecera;
            for (int i = 0; i < size; i++) {
                matriz[i] = aux.getInfo();
                aux = aux.getSig();
            }
        }
        return matriz;
    }

    public ListaEnlazada<E> toList(E[] m) {
        deleteAll();
        for (int i = 0; i < m.length; i++) {
            this.insertar(m[i]);
        }

        return this;
    }

}
