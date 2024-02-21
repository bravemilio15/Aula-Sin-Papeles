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

public class PeriodoAcademico {

    private Integer periodo_Id;
    private Date fecha_Inicio;
    private Date fecha_Fin;
    private Integer malla_Id;

    public PeriodoAcademico() {
    }

    public Integer getPeriodo_Id() {
        return periodo_Id;
    }

    public void setPeriodo_Id(Integer periodo_Id) {
        this.periodo_Id = periodo_Id;
    }

    public Date getFecha_Inicio() {
        return fecha_Inicio;
    }

    public void setFecha_Inicio(Date fecha_Inicio) {
        this.fecha_Inicio = fecha_Inicio;
    }

    public Date getFecha_Fin() {
        return fecha_Fin;
    }

    public void setFecha_Fin(Date fecha_Fin) {
        this.fecha_Fin = fecha_Fin;
    }

    public Integer getMalla_Id() {
        return malla_Id;
    }

    public void setMalla_Id(Integer malla_Id) {
        this.malla_Id = malla_Id;
    }
    
    

    
}
