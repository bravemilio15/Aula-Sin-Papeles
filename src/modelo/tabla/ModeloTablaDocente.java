/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.tabla;



import controlador.aula.UsuarioDAO;
import controlador.ed.listas.LinkedList;
import javax.swing.table.AbstractTableModel;
import modelo.Docente;

/**
 *
 * @author cristian
 */
public class ModeloTablaDocente extends AbstractTableModel {

    private LinkedList<Docente> datos;
    private UsuarioDAO ud = new UsuarioDAO();

    public LinkedList<Docente> getDatos() {
        return datos;
    }

    public void setDatos(LinkedList<Docente> datos) {
        this.datos = datos;
    }

    @Override
    public int getRowCount() {
        return datos.getSize();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (datos == null) {
            System.out.println("¡La lista de datos es nula!");
            return null;
        }

        try {
            Docente d = datos.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return d.getDocente_Id();
                case 1:
                    return ud.obtenerNombrePorIdDocente(d.getDocente_Id());
                case 2:
                    return ud.obtenerApellidoPorIdDocente(d.getDocente_Id());
                case 3:
                    return ud.obtenerDniPorIdDocente(d.getDocente_Id());
                case 4:
                    return d.getEspecialidad();
            }
        } catch (Exception ex) {
            System.out.println("Error en tablaDocentes: " + ex.getMessage());
        }

        return null;
    }

    public String getColumnName(int Column) {
        switch (Column) {
            case 0:
                return "id";
            case 1:
                return "Nombre";
            case 2:
                return "Apellido";
            case 3:
                return "Cedula";
            case 4:
                return "Grado Academico";
        }

        return null;
    }

}
