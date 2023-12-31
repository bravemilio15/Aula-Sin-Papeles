/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.tabla;

import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.EmptyException;
import controlador.ed.lista.exception.PositionException;
import javax.swing.table.AbstractTableModel;
import modelo.Persona;


public class ModeloTablaUsuario extends AbstractTableModel {

    ListaEnlazada<Persona> datos;

    public ListaEnlazada<Persona> getDatos() {
        return datos;
    }

    public void setDatos(ListaEnlazada<Persona> datos) {
        this.datos = datos;
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            Persona u = datos.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return u.getId();
                case 1:
                    return u.getNombre();
                case 2:
                    return u.getApellido();
                case 3:
                    return u.getCedula();
                 case 4:
                    return u.getRol();
            }
        } catch (EmptyException | PositionException ex) {
        }
        return null;
    }

    public String getColumnName(int Column) {
        switch (Column) {
            case 0:
                return "ID";
            case 1:
                return "Nombre";
            case 2:
                return "Apellido";
            case 3:
                return "Cedula";
            case 4:
                return "Rol";
        }

        return null;
    }

}
