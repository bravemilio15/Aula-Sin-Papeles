/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.EmptyException;
import controlador.ed.lista.exception.PositionException;
import java.io.IOException;
import modelo.Paralelo;

/**
 *
 * @author Bravo
 */
public class ParaleloDAO extends AdaptadorDAO<Paralelo> {

    private Paralelo paralelo;

    public ParaleloDAO() {
        super(Paralelo.class);
    }

    public Paralelo getParalelo() {
        if (this.paralelo == null) {
            this.paralelo = new Paralelo();
        }
        return paralelo;
    }

    public void setParalelo(Paralelo paralelo) {
        this.paralelo = paralelo;
    }

    public void guardar() throws IOException {
        paralelo.setId(generateID());
        this.guardar(paralelo);
    }

    public void modificar(Integer pos) throws EmptyException, PositionException, IOException {
        this.modificar(paralelo, pos);
    }

    private Integer generateID() {
        return listar().size() + 1;
    }

    public Paralelo obtenerParaleloPorNombre(String nombre) throws EmptyException, PositionException {
        ListaEnlazada<Paralelo> paralelos = listar();
        for (int i = 0; i < paralelos.size(); i++) {
            Paralelo paralelo = paralelos.get(i);
            if (paralelo.getNombre_paralelo().equals(nombre)) {
                return paralelo;
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        ParaleloDAO pd = new ParaleloDAO();
        pd.getParalelo().setId(1);
        pd.getParalelo().setNombre_paralelo("A");
        pd.guardar();
        pd.getParalelo().setId(2);
        pd.getParalelo().setNombre_paralelo("B");
        pd.guardar();
    }
}
