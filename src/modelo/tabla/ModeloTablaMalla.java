/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.tabla;

import controlador.ed.listas.LinkedList;
import javax.swing.table.AbstractTableModel;
import modelo.Malla;

/**
 *
 * @author cristian
 */
public class ModeloTablaMalla extends AbstractTableModel {

    private LinkedList<Malla> datos;

    public LinkedList<Malla> getDatos() {
        return datos;
    }

    public void setDatos(LinkedList<Malla> datos) {
        this.datos = datos;
    }

    @Override
    public int getRowCount() {
        if (datos == null) {
            System.out.println("¡La lista de datos es nula!");
            return 0;
        }
        return datos.getSize();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            Malla d = datos.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return d.getNombre();
                case 1:
                    return convertirEstado(d.getEstado());
                case 2:
                    return d.getFecha();

            }
        } catch (Exception ex) {
            System.out.println("Error en Datos Malla");
        }
        return null;
    }

    private String convertirEstado(int estado) {
        // Convertir el valor del estado a un String representativo
        return estado == 0 ? "Activa" : "Inactiva";
    }

    public String getColumnName(int Column) {
        switch (Column) {
            case 0:
                return "Nombre";
            case 1:
                return "Estado";
            case 2:
                return "Fecha";

        }

        return null;
    }

}
