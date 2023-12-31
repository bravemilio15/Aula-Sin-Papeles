/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


public class Docente extends Persona{
    private Integer id;
    private String especialidad;
    private String grado_academico;
    private String experiencia_educativa;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
