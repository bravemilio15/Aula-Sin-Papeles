/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.tabla;

import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.EmptyException;
import controlador.ed.lista.exception.PositionException;
import javax.swing.table.AbstractTableModel;
import modelo.Estudiante;


public class ModeloTablaEstudiante extends AbstractTableModel {

    ListaEnlazada<Estudiante> datos;

    public ListaEnlazada<Estudiante> getDatos() {
        return datos;
    }

    public void setDatos(ListaEnlazada<Estudiante> datos) {
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
            Estudiante u = datos.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return u.getNombre();
                case 1:
                    return u.getCedula();
                case 2:
                    return u.getCiclo();
                case 3:
                    return u.getParalelo();
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
                return "Cedula";
            case 2:
                return "Ciclo";
            case 3:
                return "Paralelo";
        }

        return null;
    }

}
