package modelo.tabla;


import controlador.ed.listas.LinkedList;
import javax.swing.table.AbstractTableModel;
import modelo.Tutoria;

public class ModeloTablaTutorias extends AbstractTableModel {

    private LinkedList<Tutoria> datos;

    public LinkedList<Tutoria> getDatos() {
        return datos;
    }

    public void setDatos(LinkedList<Tutoria> datos) {
        this.datos = datos;
    }

    @Override
    public int getRowCount() {
        if (datos == null) {
            System.out.println("¡La lista de datos es nula!");
            return 0;
        }
        return datos.getSize();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (datos == null) {
            System.out.println("¡La lista de datos es nula!");
            return null;
        }

        try {
            Tutoria e = datos.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return e.getTemaGeneral();
                case 1:
                    return e.getFecha();
                case 2:
                    return e.getEstado();

            }
        } catch (Exception ex) {
            System.out.println("Error en tablaTutorias: " + ex.getMessage());
        }

        return null;
    }

    @Override
    public String getColumnName(int columnIndex) {
        // Ajustado al número de atributos en Tutoria
        switch (columnIndex) {

            case 0:
                return "Tema General";
            case 1:
                return "Fecha";
            case 2:
                return "Estado";
        }

        return null;
    }
}
