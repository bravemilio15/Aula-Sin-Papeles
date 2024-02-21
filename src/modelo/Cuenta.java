/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Bravo
 */
public class Cuenta {

    private Integer cuenta_Id;
    private String clave;
    private String nombre;
    private Integer usuario_Id;

    public Cuenta() {
    }

    public Integer getCuenta_Id() {
        return cuenta_Id;
    }

    public void setCuenta_Id(Integer cuenta_Id) {
        this.cuenta_Id = cuenta_Id;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getUsuario_Id() {
        return usuario_Id;
    }

    public void setUsuario_Id(Integer usuario_Id) {
        this.usuario_Id = usuario_Id;
    }

}
