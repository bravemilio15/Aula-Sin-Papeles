/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import controlador.ed.lista.ListaEnlazada;

/**
 *
 * @author cristian
 */
public class Estudiante extends Usuario {

    private ListaEnlazada<Matricula> matriculas;
    private Paralelo paralelo;

    public Estudiante() {
        this.matriculas = new ListaEnlazada<>();
    }

    public ListaEnlazada<Matricula> getMatriculas() {
        return matriculas;
    }

    public Paralelo getParalelo() {
        return paralelo;
    }

    public void setParalelo(Paralelo paralelo) {
        this.paralelo = paralelo;
    }

    public void setMatriculas(ListaEnlazada<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    @Override
    public String toString() {
        return this.getNombre() + " " + this.getApellido();
    }

    public String getCicloNombre() {
        return ciclo != null ? ciclo.toString() : "";
    }

    public String getParaleloNombre() {
        return paralelo != null ? paralelo.toString() : "";
    }
}
