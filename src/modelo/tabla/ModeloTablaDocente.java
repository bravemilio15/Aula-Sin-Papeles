/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.tabla;

import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.EmptyException;
import controlador.ed.lista.exception.PositionException;
import java.util.stream.DoubleStream;
import javax.swing.table.AbstractTableModel;
import modelo.Docente;

/**
 *
 * @author cristian
 */
public class ModeloTablaDocente extends AbstractTableModel {

    private ListaEnlazada<Docente> datos;

    public ListaEnlazada<Docente> getDatos() {
        return datos;
    }

    public void setDatos(ListaEnlazada<Docente> datos) {
        this.datos = datos;
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            Docente d = datos.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return d.getId();
                case 1:
                    return d.getPrimer_nombre();
                case 2:
                    return d.getPrimer_apellido();
                case 3:
                    return d.getCedula();
                case 4:
                    return d.getGrado_academico();
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
                return "Apellido";
            case 3:
                return "Cedula";
            case 4:
                return "Grado Academico";
        }

        return null;
    }

}
