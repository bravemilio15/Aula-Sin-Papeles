/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.EmptyException;
import controlador.ed.lista.exception.PositionException;
import java.io.IOException;

import modelo.Ciclo;

/**
 *
 * @author Bravo
 */
public class CicloDAO extends AdaptadorDAO<Ciclo> {

    private Ciclo ciclo;

    public CicloDAO() {
        super(Ciclo.class);
    }

    public Ciclo getCiclo() {
        if (this.ciclo == null) {
            this.ciclo = new Ciclo();
        }
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }

    public void guardar() throws IOException {
        ciclo.setId(generateID());
        this.guardar(ciclo);
    }

    public void modificar(Integer pos) throws EmptyException, PositionException, IOException {
        this.modificar(ciclo, pos);
    }

    private Integer generateID() {
        return listar().size() + 1;
    }

    public Ciclo obtenerCicloPorNombre(String nombre) throws EmptyException, PositionException {
        ListaEnlazada<Ciclo> ciclos = listar();
        for (int i = 0; i < ciclos.size(); i++) {
            Ciclo ciclo = ciclos.get(i);
            if (ciclo.getNombre_ciclo().equals(nombre)) {
                return ciclo;
            }
        }
        return null; // Retornar null si no se encuentra
    }

    public static void main(String[] args) throws IOException {
        CicloDAO cd = new CicloDAO();

        cd.getCiclo().setId(1);
        cd.getCiclo().setNombre_ciclo("Primero");
        cd.getCiclo().setDuracion(120);
        cd.guardar();
        cd.getCiclo().setId(2);
        cd.getCiclo().setNombre_ciclo("Segundo");
        cd.getCiclo().setDuracion(120);
        cd.guardar();
        cd.getCiclo().setId(3);
        cd.getCiclo().setNombre_ciclo("Tercero");
        cd.getCiclo().setDuracion(120);
        cd.guardar();
        cd.getCiclo().setId(4);
        cd.getCiclo().setNombre_ciclo("Cuarto");
        cd.getCiclo().setDuracion(120);
        cd.guardar();
        cd.getCiclo().setId(5);
        cd.getCiclo().setNombre_ciclo("Quinto");
        cd.getCiclo().setDuracion(120);
        cd.guardar();
        cd.getCiclo().setId(6);
        cd.getCiclo().setNombre_ciclo("Sexto");
        cd.getCiclo().setDuracion(120);
        cd.guardar();
        cd.getCiclo().setId(7);
        cd.getCiclo().setNombre_ciclo("Septimo");
        cd.getCiclo().setDuracion(120);
        cd.guardar();
        cd.getCiclo().setId(8);
        cd.getCiclo().setNombre_ciclo("Octavo");
        cd.getCiclo().setDuracion(120);
        cd.guardar();
        cd.getCiclo().setId(9);
        cd.getCiclo().setNombre_ciclo("Noveno");
        cd.getCiclo().setDuracion(120);
        cd.guardar();

    }

}
