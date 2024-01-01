package modelo;

import controlador.ed.lista.ListaEnlazada;

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
        return this.getPrimer_nombre() + " " + this.getPrimer_apellido();
    }

    public String getCicloNombre() {
        return ciclo != null ? ciclo.toString() : "";
    }

    public String getParaleloNombre() {
        return paralelo != null ? paralelo.toString() : "";
    }
}
