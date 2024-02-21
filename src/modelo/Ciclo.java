/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Bravo
 */
public class Ciclo {

    private Integer ciclo_Id;
    private String nombre;
    private Integer duracion;
    private Integer malla_Id;

    public Ciclo() {
    }

    public Integer getCiclo_Id() {
        return ciclo_Id;
    }

    public void setCiclo_Id(Integer ciclo_Id) {
        this.ciclo_Id = ciclo_Id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Integer getMalla_Id() {
        return malla_Id;
    }

    public void setMalla_Id(Integer malla_Id) {
        this.malla_Id = malla_Id;
    }

}
