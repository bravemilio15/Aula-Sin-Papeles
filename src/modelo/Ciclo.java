
package modelo;

import controlador.ed.lista.ListaEnlazada;

public class Ciclo {

    //Ciclo
    private Integer id;
    private Integer duracion;
    private String nombre_ciclo;
    private ListaEnlazada<Materia> materias;

    public Ciclo() {
        this.materias = new ListaEnlazada<>();
    }

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

    public void agregarMateria(Materia materia) {
        this.materias.insertar(materia);
    }

    @Override
    public String toString() {
        return nombre_ciclo;
    }

}
