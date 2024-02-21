/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Bravo
 */
public class Materia {

    private Integer materia_Id;
    private Integer estado;
    private String nombre;
    private String codigo;
    private String categoria;
    private Integer ciclo_Id;
    private Integer docente_Id;

    public Materia() {
    }

    public Integer getMateria_Id() {
        return materia_Id;
    }

    public void setMateria_Id(Integer materia_Id) {
        this.materia_Id = materia_Id;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getCiclo_Id() {
        return ciclo_Id;
    }

    public void setCiclo_Id(Integer ciclo_Id) {
        this.ciclo_Id = ciclo_Id;
    }

    public Integer getDocente_Id() {
        return docente_Id;
    }

    public void setDocente_Id(Integer docente_Id) {
        this.docente_Id = docente_Id;
    }

}
