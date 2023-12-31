package modelo.tabla;

import controlador.dao.MateriaDao;
import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.EmptyException;
import controlador.ed.lista.exception.PositionException;
import javax.swing.table.AbstractTableModel;
import modelo.Materia;

public class ModeloTablaMateria extends AbstractTableModel {

    public ListaEnlazada<Materia> datos;

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
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            Materia materia = datos.get(rowIndex);
            MateriaDao md = new MateriaDao();
            switch (columnIndex) {
                case 0:
                    return materia.getId();
                case 1:
                    return materia.getNombre();
                case 2:
                    return materia.getCiclo().getNombre_ciclo();
                case 3:
                    return materia.getCategoria();
            }
        } catch (EmptyException | PositionException ex) {

        }
        return null;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "ID";
            case 1:
                return "Nombre";
            case 2:
                return "Ciclo";
            case 3:
                return "Categoria";
        }
        return null;
    }
}
