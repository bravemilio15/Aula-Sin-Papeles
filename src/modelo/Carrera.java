/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Bravo
 */
public class Carrera {

    private Integer carrera_Id;
    private String nombre_Carrera;
    private Integer malla_Id;

    public Carrera() {
    }

    public Integer getCarrera_Id() {
        return carrera_Id;
    }

    public void setCarrera_Id(Integer carrera_Id) {
        this.carrera_Id = carrera_Id;
    }

    public String getNombre_Carrera() {
        return nombre_Carrera;
    }

    public void setNombre_Carrera(String nombre_Carrera) {
        this.nombre_Carrera = nombre_Carrera;
    }

    public Integer getMalla_Id() {
        return malla_Id;
    }

    public void setMalla_Id(Integer malla_Id) {
        this.malla_Id = malla_Id;
    }

}
