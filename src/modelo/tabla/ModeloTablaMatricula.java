/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.tabla;

import controlador.aula.CarreraDAO;
import controlador.ed.colas.ColaI;
import controlador.ed.listas.LinkedList;
import javax.swing.table.AbstractTableModel;
import modelo.Matricula;

/**
 *
 * @author cristian
 */
public class ModeloTablaMatricula extends AbstractTableModel {

    LinkedList<Matricula> datos = new LinkedList<>();

    public LinkedList<Matricula> getDatos() {
        return datos;
    }

    public void setDatos(LinkedList<Matricula> datos) {
        this.datos = datos;
    }

    @Override
    public int getRowCount() {
        return datos.getSize();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            Matricula m = datos.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return m.getEstado();
                case 1:
                    return m.getNivelAcademico();

            }
        } catch (Exception ex) {
        }
        return null;
    }

    public String getColumnName(int Column) {
        switch (Column) {

            case 0:
                return "Estado de Matricula";
            case 1:
                return "Nivel Academico";

        }

        return null;
    }

}
