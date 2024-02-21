package modelo.tabla;

import controlador.aula.UsuarioDAO;
import controlador.ed.listas.LinkedList;
import javax.swing.table.AbstractTableModel;
import modelo.Estudiante;

public class ModeloTablaEstudiante extends AbstractTableModel {

    private LinkedList<Estudiante> datos;
    private UsuarioDAO ud = new UsuarioDAO();

    public ModeloTablaEstudiante() {
    }

    public LinkedList<Estudiante> getDatos() {
        return datos;
    }

    public void setDatos(LinkedList<Estudiante> datos) {
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
        return 4;
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
                    return ud.obtenerNombrePorIdEstudiante(e.getEstudiante_Id());
                case 1:

                    return ud.obtenerApellidoPorIdEstudiante(e.getEstudiante_Id());
                case 2:
                    return ud.obtenerDniPorIdEstudiante(e.getEstudiante_Id());
                case 3:
                    return e.getFecha_Ingreso();
            }
        } catch (Exception ex) {
            System.out.println("Error en tablaEstudiantes: " + ex.getMessage());
        }

        return null;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Nombre";
            case 1:
                return "Apellido";
            case 2:
                return "DNI";
            case 3:
                return "Fecha Ingreso";
        }

        return null;
    }
}
