package modelo.tabla;


import controlador.ed.listas.LinkedList;
import javax.swing.table.AbstractTableModel;
import modelo.Matricula_Materia;

public class ModeloTablaMM extends AbstractTableModel {

    private LinkedList<Matricula_Materia> datos;

    public LinkedList<Matricula_Materia> getDatos() {
        return datos;
    }

    public void setDatos(LinkedList<Matricula_Materia> datos) {
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
            Matricula_Materia e = datos.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return e.getMatricula_Id();
                case 1:
                    return e.getMateria_Id();
                case 3:
                    return e.getParalelo_Id();

 
            }
        } catch (Exception ex) {
            System.out.println("Error en tablaMatricula_Materias: " + ex.getMessage());
        }

        return null;
    }

    @Override
    public String getColumnName(int columnIndex) {

        switch (columnIndex) {
            case 0:
                return "Matricula";
            case 1:
                return "Materia";
            case 2:
                return "Paralelo";
        }

        return null;
    }
}
