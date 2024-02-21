package modelo.tabla;


import controlador.ed.listas.LinkedList;
import javax.swing.table.AbstractTableModel;
import modelo.Paralelo;

public class ModeloTablaParalelo extends AbstractTableModel {

    private LinkedList<Paralelo> datos;

    public LinkedList<Paralelo> getDatos() {
        return datos;
    }

    public void setDatos(LinkedList<Paralelo> datos) {
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
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (datos == null) {
            System.out.println("¡La lista de datos es nula!");
            return null;
        }

        try {
            Paralelo e = datos.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return e.getNombre();


 
            }
        } catch (Exception ex) {
            System.out.println("Error en tablaParalelos: " + ex.getMessage());
        }

        return null;
    }

    @Override
    public String getColumnName(int columnIndex) {

        switch (columnIndex) {
            case 0:
                return "Nombre";
        }

        return null;
    }
}
