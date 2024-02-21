package modelo.tabla;

import controlador.aula.CicloDAO;
import controlador.ed.listas.LinkedList;
import javax.swing.table.AbstractTableModel;
import modelo.Ciclo;
import modelo.PeriodoAcademico;

public class ModeloTablaPeriodo extends AbstractTableModel {

    public LinkedList<PeriodoAcademico> datos;

    public LinkedList<PeriodoAcademico> getDatos() {
        return datos;
    }

    public void setDatos(LinkedList<PeriodoAcademico> datos) {
        this.datos = datos;
    }

    @Override
    public int getRowCount() {
        return datos.getSize();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            PeriodoAcademico p = datos.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return p.getFecha_Inicio();
                case 1:
                    return p.getFecha_Fin();
                case 2:
                    return p.getMalla_Id();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Fecha Inicio";
            case 1:
                return "Fecha Fin";
            case 2:
                return "Malla";
        }
        return null;
    }
}
