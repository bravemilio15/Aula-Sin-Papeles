package modelo.tabla;

import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.EmptyException;
import controlador.ed.lista.exception.PositionException;
import javax.swing.table.AbstractTableModel;
import modelo.Estudiante;

public class ModeloTablaEstudiante extends AbstractTableModel {

    private ListaEnlazada<Estudiante> datos;

    public ListaEnlazada<Estudiante> getDatos() {
        return datos;
    }

    public void setDatos(ListaEnlazada<Estudiante> datos) {
        this.datos = datos;
    }

    @Override
    public int getRowCount() {
        if (datos == null) {
            System.out.println("¡La lista de datos es nula!");
            return 0;
        }
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (datos == null) {
            System.out.println("¡La lista de datos es nula!");
            return null;
        }

        try {
            Estudiante e = datos.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return e.getId();
                case 1:
                    return e.getPrimer_nombre();
                case 2:
                    return e.getPrimer_apellido();
                case 3:
                    return e.getCedula();
                case 4:
                    return e.getCicloNombre();
                case 5:
                    return e.getParaleloNombre();
                case 6:
                    return e.getModalidad();
            }
        } catch (EmptyException | PositionException ex) {
            System.out.println("Error en tablaEstudiantes: " + ex.getMessage());
        }

        return null;
    }

    @Override
    public String getColumnName(int columnIndex) {
        // Ajustado al número de atributos en Estudiante
        switch (columnIndex) {
            case 0:
                return "ID";
            case 1:
                return "Nombre";
            case 2:
                return "Apellido";
            case 3:
                return "Cedula";
            case 4:
                return "Ciclo";
            case 5:
                return "Paralelo";
            case 6:
                return "Modalidad";
        }

        return null;
    }
}
