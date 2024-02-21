/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.tabla;

import controlador.ed.listas.LinkedList;
import javax.swing.table.AbstractTableModel;
import modelo.Carrera;

/**
 *
 * @author cristian
 */
public class ModeloTablaCarrera extends AbstractTableModel {

    private LinkedList<Carrera> datos;

    public LinkedList<Carrera> getDatos() {
        return datos;
    }

    public void setDatos(LinkedList<Carrera> datos) {
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
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            Carrera d = datos.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return d.getNombre_Carrera();
            }
        } catch (Exception ex) {
            System.out.println("Error en Datos Carrera");
        }
        return null;
    }

    public String getColumnName(int Column) {
        switch (Column) {
            case 0:
                return "Nombre";

        }

        return null;
    }

}
