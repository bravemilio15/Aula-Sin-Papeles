package modelo.tabla;


import controlador.ed.listas.LinkedList;
import javax.swing.table.AbstractTableModel;
import modelo.Rol;

public class ModeloTablaRoles extends AbstractTableModel {

    private LinkedList<Rol> datos;

    public LinkedList<Rol> getDatos() {
        return datos;
    }

    public void setDatos(LinkedList<Rol> datos) {
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
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (datos == null) {
            System.out.println("¡La lista de datos es nula!");
            return null;
        }

        try {
            Rol e = datos.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return e.getNombre();
                case 1:
                    return e.getDescripcion();

 
            }
        } catch (Exception ex) {
            System.out.println("Error en tablaRols: " + ex.getMessage());
        }

        return null;
    }

    @Override
    public String getColumnName(int columnIndex) {

        switch (columnIndex) {
            case 0:
                return "Nombre";
            case 1:
                return "Descripcion";
        }

        return null;
    }
}
