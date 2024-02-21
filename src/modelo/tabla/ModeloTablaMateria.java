package modelo.tabla;

import controlador.aula.CicloDAO;
import controlador.aula.MateriaDAO;
import controlador.ed.listas.LinkedList;
import javax.swing.table.AbstractTableModel;
import modelo.Ciclo;
import modelo.Materia;

public class ModeloTablaMateria extends AbstractTableModel {

    public LinkedList<Materia> datos;

    public LinkedList<Materia> getDatos() {
        return datos;
    }

    public void setDatos(LinkedList<Materia> datos) {
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
            Materia materia = datos.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return materia.getNombre();
                case 1:
                    return materia.getCiclo_Id();
                case 2:
                    return materia.getCategoria();
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
                return "Nombre";
            case 1:
                return "Ciclo";
            case 2:
                return "Categoria";
        }
        return null;
    }
}
