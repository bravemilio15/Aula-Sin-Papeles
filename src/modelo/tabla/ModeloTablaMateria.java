/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.tabla;

import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.EmptyException;
import controlador.ed.lista.exception.PositionException;
import javax.swing.table.AbstractTableModel;
import modelo.Materia;


public class ModeloTablaMateria extends AbstractTableModel {

    ListaEnlazada<Materia> datos;

    public ListaEnlazada<Materia> getDatos() {
        return datos;
    }

    public void setDatos(ListaEnlazada<Materia> datos) {
        this.datos = datos;
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            Materia m = datos.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return m.getNombre();
                case 1:
                    return m.getCiclo();
            }
        } catch (EmptyException | PositionException ex) {
        }
        return null;
    }

    public String getColumnName(int Column) {
        switch (Column) {
            case 0:
                return "Nombre";
            case 1:
                return "Ciclo";
        }

        return null;
    }

}
