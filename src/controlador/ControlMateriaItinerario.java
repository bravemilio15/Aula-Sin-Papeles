/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.dao.MateriaDaoItinerario;
import controlador.ed.lista.ListaEnlazada;
import java.io.IOException;
import modelo.MateriaI;


public class ControlMateriaItinerario {
    private MateriaDaoItinerario materiaDaoItinerario;
    private MateriaI materiaI;

    public ControlMateriaItinerario() {
        this.materiaDaoItinerario = new MateriaDaoItinerario();
    }

    public MateriaDaoItinerario getMateriaDaoItinerario() {
        return materiaDaoItinerario;
    }

    public void setMateriaDaoItinerario(MateriaDaoItinerario materiaDaoItinerario) {
        this.materiaDaoItinerario = materiaDaoItinerario;
    }

    public MateriaI getMateriaI() {
       if (materiaI == null) {
            materiaI = new MateriaI();
        }
        return materiaI;
    }

    public void setMateriaI(MateriaI materiaI) {
        this.materiaI = materiaI;
    }
      public ListaEnlazada<MateriaI> listar() {
        return materiaDaoItinerario.listar();
    }

      public void guardarMateria(String nombre,String ciclo) {

        materiaDaoItinerario.getMateriaI().setNombre(nombre);
        materiaDaoItinerario.getMateriaI().setCiclo(ciclo);
        try {
            materiaDaoItinerario.guardar();
        } catch (IOException ex) {
            System.out.println("Error");
        }
    }
    
            
            
            
            
      
}
