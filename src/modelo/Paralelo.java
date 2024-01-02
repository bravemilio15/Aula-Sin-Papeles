/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import controlador.ed.lista.ListaEnlazada;

public class Paralelo {

    private Integer id;
    private String nombre_paralelo;
    private ListaEnlazada<Estudiante> estudiantes;
    private ListaEnlazada<Docente> docentes;

    public ListaEnlazada<Docente> getDocentes() {
        return docentes;
    }

    public void setDocentes(ListaEnlazada<Docente> docentes) {
        this.docentes = docentes;
    }

    public ListaEnlazada<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ListaEnlazada<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre_paralelo() {
        return nombre_paralelo;
    }

    public void setNombre_paralelo(String nombre_paralelo) {
        this.nombre_paralelo = nombre_paralelo;
    }



    public String toString() {
        return nombre_paralelo;
    }

}
