package modelo.tabla;

import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.EmptyException;
import controlador.ed.lista.exception.PositionException;
import javax.swing.table.AbstractTableModel;
import modelo.Materia;

public class ModeloTablaMateria<T> extends AbstractTableModel {

    ListaEnlazada<T> datos;

    public ListaEnlazada<T> getDatos() {
        return datos;
    }

    public void setDatos(ListaEnlazada<T> datos) {
        this.datos = datos;
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 3; // Ajusta el número de columnas según tu necesidad
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            T elemento = datos.get(rowIndex);

            if (elemento instanceof Materia) {
                Materia materia = (Materia) elemento;
                switch (columnIndex) {
                    case 0:
                        return materia.getNombre();
                    case 1:
                        return materia.getCiclo();
                    case 2:
                        return materia.getCategoria(); 
                }
            }
        } catch (EmptyException | PositionException ex) {
            // Manejar la excepción apropiadamente
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
                return "Categoria"; // Agregado el caso para Categoria
        }
        return null;
    }
}
