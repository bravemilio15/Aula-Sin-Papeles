/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;


public class Asistencia {
    private Integer id;
    private String estado_estudiante;
    private String Asistencia;
    private Date Duracion;
    private String curso;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEstado_estudiante() {
        return estado_estudiante;
    }

    public void setEstado_estudiante(String estado_estudiante) {
        this.estado_estudiante = estado_estudiante;
    }

    public String getAsistencia() {
        return Asistencia;
    }

    public void setAsistencia(String Asistencia) {
        this.Asistencia = Asistencia;
    }

    public Date getDuracion() {
        return Duracion;
    }

    public void setDuracion(Date Duracion) {
        this.Duracion = Duracion;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    
    
}
