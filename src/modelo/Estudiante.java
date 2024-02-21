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

public class Estudiante {

    private Date fecha_Ingreso;
    private Integer estudiante_Id;
    private Integer matricula_Id;

    public Date getFecha_Ingreso() {
        return fecha_Ingreso;
    }

    public void setFecha_Ingreso(Date fecha_Ingreso) {
        this.fecha_Ingreso = fecha_Ingreso;
    }

    public Integer getEstudiante_Id() {
        return estudiante_Id;
    }

    public void setEstudiante_Id(Integer estudiante_Id) {
        this.estudiante_Id = estudiante_Id;
    }

    public Integer getMatricula_Id() {
        return matricula_Id;
    }

    public void setMatricula_Id(Integer matricula_Id) {
        this.matricula_Id = matricula_Id;
    }

}
