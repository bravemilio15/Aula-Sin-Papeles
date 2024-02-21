/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.aula;

import controlador.dao.AdaptadorDao;
import controlador.ed.listas.LinkedList;
import modelo.Cuenta;

/**
 *
 * @author Bravo
 */
public class CuentaDAO extends AdaptadorDao<Cuenta> {

    private Cuenta cuenta = new Cuenta();
    private LinkedList<Cuenta> cuentas = new LinkedList<>();

    public CuentaDAO() {
        super(Cuenta.class);
    }

    public LinkedList<Cuenta> getCuentas() {
        if (cuentas.isEmpty()) {
            cuentas = listar();
        }
        return cuentas;
    }

    public void setCuentas(LinkedList<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public Cuenta getCuenta() {
        if (cuenta == null) {
            cuenta = new Cuenta();
        }
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Integer save() throws Exception {
        cuenta.setCuenta_Id(generated_id());
        return guardar(cuenta);
    }

    public void update() throws Exception {
        modificar(cuenta);
    }
    
    public boolean verificarCuenta(String nombre, String clave) {

        var cuentas = listar();

        if(cuentas.isEmpty()) return false;

        try {
            
            cuentas.mergeSort("nombre", true);
            
            cuenta = cuentas.binarySearch("nombre", nombre);
            
            if(cuenta == null) return false;
        
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return cuenta.getClave().equals(clave);

    }
    
    

}
