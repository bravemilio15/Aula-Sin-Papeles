package modelo;

import controlador.ed.lista.ListaEnlazada;

public class Docente extends Usuario {

    private String especialidad;
    private String grado_academico;
    private String experiencia_educativa;
    private ListaEnlazada<Materia> materias;

    public ListaEnlazada<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(ListaEnlazada<Materia> materias) {
        this.materias = materias;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getGrado_academico() {
        return grado_academico;
    }

    public void setGrado_academico(String grado_academico) {
        this.grado_academico = grado_academico;
    }

    public String getExperiencia_educativa() {
        return experiencia_educativa;
    }

    public void setExperiencia_educativa(String experiencia_educativa) {
        this.experiencia_educativa = experiencia_educativa;
    }

}
