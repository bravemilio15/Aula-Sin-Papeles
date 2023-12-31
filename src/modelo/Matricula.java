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
public class Matricula {

    private Integer id;
    private String carrera;
    private String nivel_academico;
    private String historial_academico;
    private String estado;
    private ListaEnlazada<Materia> materias;

    public ListaEnlazada<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(ListaEnlazada<Materia> materias) {
        this.materias = materias;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getNivel_academico() {
        return nivel_academico;
    }

    public void setNivel_academico(String nivel_academico) {
        this.nivel_academico = nivel_academico;
    }

    public String getHistorial_academico() {
        return historial_academico;
    }

    public void setHistorial_academico(String historial_academico) {
        this.historial_academico = historial_academico;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
