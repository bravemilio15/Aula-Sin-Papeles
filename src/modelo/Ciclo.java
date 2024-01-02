package modelo;

import controlador.ed.lista.ListaEnlazada;

public class Ciclo {

    //Ciclo
    private Integer id;
    private Integer duracion;
    private String nombre_ciclo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public String getNombre_ciclo() {
        return nombre_ciclo;
    }

    public void setNombre_ciclo(String nombre_ciclo) {
        this.nombre_ciclo = nombre_ciclo;
    }

    @Override
    public String toString() {
        return "Nombre:" + nombre_ciclo;
    }

}
