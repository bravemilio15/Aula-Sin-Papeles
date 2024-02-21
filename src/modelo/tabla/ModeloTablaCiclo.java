/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.tabla;

import controlador.ed.listas.LinkedList;
import javax.swing.table.AbstractTableModel;
import modelo.Ciclo;

/**
 *
 * @author cristian
 */
public class ModeloTablaCiclo extends AbstractTableModel {

    private LinkedList<Ciclo> datos;

    public LinkedList<Ciclo> getDatos() {
        return datos;
    }

    public void setDatos(LinkedList<Ciclo> datos) {
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
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            Ciclo d = datos.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return d.getNombre();
                case 1:
                    return d.getDuracion();
            }
        } catch (Exception ex) {
            System.out.println("Error en Datos Ciclo");
        }
        return null;
    }

    public String getColumnName(int Column) {
        switch (Column) {
            case 0:
                return "Nombre";
            case 1:
                return "Duracion";

        }

        return null;
    }

}
