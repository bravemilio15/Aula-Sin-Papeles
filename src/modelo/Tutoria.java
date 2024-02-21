/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Bravo
 */
import java.util.Date;

public class Tutoria {

    private Integer tutoria_Id;
    private Date fecha;
    private String temaGeneral;
    private Integer estado;
    private String comentario;
    private Integer materia_Id;
    

    public Tutoria() {
    }
    
    

    public Integer getMateria_Id() {
        return materia_Id;
    }

    public void setMateria_Id(Integer materia_Id) {
        this.materia_Id = materia_Id;
    }
    

    public Integer getTutoria_Id() {
        return tutoria_Id;
    }

    public void setTutoria_Id(Integer tutoria_Id) {
        this.tutoria_Id = tutoria_Id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTemaGeneral() {
        return temaGeneral;
    }

    public void setTemaGeneral(String temaGeneral) {
        this.temaGeneral = temaGeneral;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }


}
