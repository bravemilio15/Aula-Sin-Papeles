/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.ControlMateria;
import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.EmptyException;
import controlador.ed.lista.exception.PositionException;
import java.io.IOException;

import modelo.Ciclo;
import modelo.Materia;

/**
 *
 * @author Bravo
 */
public class CicloDAO extends AdaptadorDAO<Ciclo> {

    private ListaEnlazada<Ciclo> ciclos;
    private Ciclo ciclo;

    public CicloDAO() {
        super(Ciclo.class);
    }

    public ListaEnlazada<Ciclo> getCiclos() {
        return ciclos;
    }

    public void setCiclos(ListaEnlazada<Ciclo> ciclos) {
        this.ciclos = ciclos;
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
        Integer idCiclo = generateID();
        ciclo.setId(idCiclo);

        try {
            // Guardar el ciclo sin asociar las materias
            this.guardar(ciclo);

            // Actualizar el ciclo en la lista después de guardarlo
            ciclo = obtener(idCiclo);

            System.out.println("Ciclo guardado exitosamente. Asocie las materias más tarde.");

        } catch (Exception e) {
            System.out.println("Error en Guardar de CicloDAO");
        }
    }

    public void modificar(Integer pos) throws EmptyException, PositionException, IOException {
        this.modificar(ciclo, pos);
    }

    private Integer generateID() {
        return listar().size() + 1;
    }

    public Ciclo obtenerCicloPorId(Integer id) throws EmptyException, PositionException {
        ListaEnlazada<Ciclo> ciclos = listar();
        for (int i = 0; i < ciclos.size(); i++) {
            Ciclo ciclo = ciclos.get(i);
            if (ciclo.getId().equals(id)) {
                return ciclo;
            }
        }
        return null; // Retornar null si no se encuentra
    }

    public int obtenerPosicionPorId(Integer id) throws EmptyException, PositionException {
        ListaEnlazada<Ciclo> ciclos = listar();
        for (int i = 0; i < ciclos.size(); i++) {
            Ciclo ciclo = ciclos.get(i);
            if (ciclo.getId().equals(id)) {
                return i;
            }
        }
        throw new EmptyException("Ciclo no encontrado");
    }

    public Ciclo obtenerCicloPorNombre(String nombreCiclo) throws EmptyException, PositionException {
        ListaEnlazada<Ciclo> ciclos = listar();

        for (int i = 0; i < ciclos.size(); i++) {
            Ciclo ciclo = ciclos.get(i);
            if (ciclo.getNombre_ciclo().equalsIgnoreCase(nombreCiclo)) {
                return ciclo;
            }
        }

        return null; // Retornar null si no se encuentra el ciclo con el nombre proporcionado
    }

    public static void main(String[] args) throws IOException, EmptyException, PositionException {
        CicloDAO cd = new CicloDAO();
        MateriaDao md = new MateriaDao();

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
