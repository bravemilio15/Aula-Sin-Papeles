/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Bravo
 */
public class Usuario {

    private Integer usuario_Id;
    private String dni;
    private String primer_Nombre;
    private String segundo_Nombre;
    private String primer_Apellido;
    private String segundo_Apellido;
    private String genero;
    private String correo;
    private String correo_Institucional;
    private String telefono;
    private Integer estado;
    private String fecha_Nacimiento;
    private Integer edad;
    private String modalidad;
    private Integer rol_Id;

    public Usuario() {
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getFecha_Nacimiento() {
        return fecha_Nacimiento;
    }

    public void setFecha_Nacimiento(String fecha_Nacimiento) {
        this.fecha_Nacimiento = fecha_Nacimiento;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getUsuario_Id() {
        return usuario_Id;
    }

    public void setUsuario_Id(Integer usuario_Id) {
        this.usuario_Id = usuario_Id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPrimer_Nombre() {
        return primer_Nombre;
    }

    public void setPrimer_Nombre(String primer_Nombre) {
        this.primer_Nombre = primer_Nombre;
    }

    public String getSegundo_Nombre() {
        return segundo_Nombre;
    }

    public void setSegundo_Nombre(String segundo_Nombre) {
        this.segundo_Nombre = segundo_Nombre;
    }

    public String getPrimer_Apellido() {
        return primer_Apellido;
    }

    public void setPrimer_Apellido(String primer_Apellido) {
        this.primer_Apellido = primer_Apellido;
    }

    public String getSegundo_Apellido() {
        return segundo_Apellido;
    }

    public void setSegundo_Apellido(String segundo_Apellido) {
        this.segundo_Apellido = segundo_Apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCorreo_Institucional() {
        return correo_Institucional;
    }

    public void setCorreo_Institucional(String correo_Institucional) {
        this.correo_Institucional = correo_Institucional;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getRol_Id() {
        return rol_Id;
    }

    public void setRol_Id(Integer rol_Id) {
        this.rol_Id = rol_Id;
    }

    @Override
    public String toString() {
        return primer_Nombre + primer_Apellido;
    }

}
