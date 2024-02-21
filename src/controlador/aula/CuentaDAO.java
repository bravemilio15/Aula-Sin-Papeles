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

    private Integer BuscarIndex(Integer id) {
        Integer index = -1;

        if (!listar().isEmpty()) {
            Cuenta[] cuentas = listar().toArray();
            for (int i = 0; i < cuentas.length; i++) {
                if (id.intValue() == cuentas[i].getCuenta_Id().intValue()) {
                    index = 1;
                    break;
                }
            }
        }
        return index;

    }

    public static void main(String[] args) throws Exception {
        CuentaDAO r = new CuentaDAO();

//                r.getCuenta().setNombre("Estudiante");
//                r.getCuenta().setDescripcion("Es Estudiante");
//                r.save();
//                r.getCuenta().setNombre("Docente");
//                r.getCuenta().setDescripcion("Es Docente");
//                r.save();
//                
//                r.getCuenta().setNombre("Secretaria");
//                r.getCuenta().setDescripcion("Es secre");
//                r.save();
//                var cuenta = r.obtener(3);
//                System.out.println(cuenta);
//                cuenta.setNombre("Secretaria");
//                cuenta.setDescripcion("Es Secretaria");
//                r.modificar(cuenta);
    }
}
