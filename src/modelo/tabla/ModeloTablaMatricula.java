/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.tabla;

import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.EmptyException;
import controlador.ed.lista.exception.PositionException;
import javax.swing.table.AbstractTableModel;
import modelo.Matricula;

/**
 *
 * @author cristian
 */
public class ModeloTablaMatricula extends AbstractTableModel {

    ListaEnlazada<Matricula> datos;

    public ListaEnlazada<Matricula> getDatos() {
        return datos;
    }

    public void setDatos(ListaEnlazada<Matricula> datos) {
        this.datos = datos;
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            Matricula m = datos.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return m.getId();
                case 1:
                    return m.getCarrera();
                case 2:
                    return m.getNivel_academico();
                case 3:
                    return m.getEstado();
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
                return "Nombre de Carrera";
            case 2:
                return "Nivel Academico";
            case 3:
                return "Estado de Matricula";
        }

        return null;
    }

}
