/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.tabla;



import controlador.ed.listas.LinkedList;
import javax.swing.table.AbstractTableModel;
import modelo.Docente;

/**
 *
 * @author cristian
 */
public class ModeloTablaDocente extends AbstractTableModel {

    private LinkedList<Docente> datos;

    public LinkedList<Docente> getDatos() {
        return datos;
    }

    public void setDatos(LinkedList<Docente> datos) {
        this.datos = datos;
    }

    @Override
    public int getRowCount() {
        return datos.getSize();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            Docente d = datos.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return d.getPrimer_Nombre();
                case 1:
                    return d.getPrimer_Apellido();
                case 2:
                    return d.getDni();
                case 3:
                    return d.getGradoAcademico();
            }
        } catch (Exception ex) {
            System.out.println("Error" + ex);
        }
        return null;
    }

    public String getColumnName(int Column) {
        switch (Column) {

            case 0:
                return "Nombre";
            case 1:
                return "Apellido";
            case 2:
                return "Cedula";
            case 3:
                return "Grado Academico";
        }

        return null;
    }

}
