/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Bravo
 */
public class Docente {

    private String especialidad;
    private String experiencia_Educativa;
    private String grado_Academico;
    private Integer docente_Id;

    public Docente() {
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getExperiencia_Educativa() {
        return experiencia_Educativa;
    }

    public void setExperiencia_Educativa(String experiencia_Educativa) {
        this.experiencia_Educativa = experiencia_Educativa;
    }

    public String getGrado_Academico() {
        return grado_Academico;
    }

    public void setGrado_Academico(String grado_Academico) {
        this.grado_Academico = grado_Academico;
    }

    public Integer getDocente_Id() {
        return docente_Id;
    }

    public void setDocente_Id(Integer docente_Id) {
        this.docente_Id = docente_Id;
    }

}
