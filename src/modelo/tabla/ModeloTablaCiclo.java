/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.tabla;

import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.EmptyException;
import controlador.ed.lista.exception.PositionException;
import javax.swing.table.AbstractTableModel;
import modelo.Ciclo;

/**
 *
 * @author cristian
 */
public class ModeloTablaCiclo extends AbstractTableModel {

    private ListaEnlazada<Ciclo> datos;

    public ListaEnlazada<Ciclo> getDatos() {
        return datos;
    }

    public void setDatos(ListaEnlazada<Ciclo> datos) {
        this.datos = datos;
    }

    @Override
    public int getRowCount() {
        if (datos == null) {
            System.out.println("¡La lista de datos es nula!");
            return 0;
        }
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            Ciclo d = datos.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return d.getId();
                case 1:
                    return d.getNombre_ciclo();
                case 2:
                    return d.getDuracion();
            }
        } catch (EmptyException | PositionException ex) {
        }
        return null;
    }

    public String getColumnName(int Column) {
        switch (Column) {
            case 0:
                return "ID";
            case 1:
                return "Nombre";
            case 2:
                return "Duracion";
            
        }

        return null;
    }

}
