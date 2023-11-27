/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.EmptyException;
import controlador.ed.lista.exception.PositionException;
import java.io.IOException;


/**
 *
 * @author cristian
 */
public interface InterfazDAO <T>{
    /**
     * Metodo que permite guardar
     * @param obj Objeto del modelo
     */
    public void guardar(T obj) throws IOException;
    /**
     * Permite modificar los datos en un repositorio de datos
     * @param obj Objeto a modificar
     * @param pos posicion del arreglo
     */
    public void modificar(T obj, Integer pos) throws EmptyException, PositionException,IOException;
    /**
     * Permite listar los elementos
     * @return una lista enlazada
     */
    public ListaEnlazada<T> listar();
    /**
     * Permite obtener un elemento del arreglo
     * @param id Posicion
     * @return returna un dato
     */
    public T obtener(Integer id);
      
}