/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.dao.EstudianteDao;
import controlador.dao.UsuarioDao;
import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.EmptyException;
import controlador.ed.lista.exception.PositionException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Persona;
import modelo.Estudiante;


public class Control {

    private UsuarioDao usuario;
    private Persona usuarioNormal;
    private EstudianteDao estudiante;

    public Control() {
        this.usuario = new UsuarioDao();
        this.estudiante = new EstudianteDao();
    }

    public EstudianteDao getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteDao estudiante) {
        this.estudiante = estudiante;
    }

    public UsuarioDao getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDao usuario) {
        this.usuario = usuario;
    }

    public ListaEnlazada<Persona> listar() {
        return usuario.listar();
    }

    public Persona getUsuarioNormal() {
         if (usuarioNormal == null) {
            usuarioNormal = new Persona();
        }
        return usuarioNormal;
    }

    public void setUsuarioNormal(Persona usuarioNormal) {
        this.usuarioNormal = usuarioNormal;
    }

    public ListaEnlazada<Estudiante> listarE() {
        return estudiante.listar();
    }

    public void guardarUsuario(String nombre, String apellido, String cedula, String celular, String estado, String nacimiento, int edad,String genero,String correoPer, String correoIns, String rol) {

        usuario.getUsuario().setNombre(nombre);
        usuario.getUsuario().setApellido(apellido);
        usuario.getUsuario().setCedula(cedula);
        usuario.getUsuario().setCelular(celular);
        usuario.getUsuario().setEstado(estado);
        usuario.getUsuario().setNacimiento(nacimiento);
        usuario.getUsuario().setEdad(edad);
        usuario.getUsuario().setGenero(genero);
        usuario.getUsuario().setCorreoPer(correoPer);
        usuario.getUsuario().setCorreoIns(correoIns);
        usuario.getUsuario().setRol(rol);
        //usuario.getUsuario().setId_rol(this.rol.buscarRol(rol).getId());
        try {
            usuario.guardar();
        } catch (IOException ex) {
            System.out.println("Error");
        }
    }

    public void guardarEstudiante(String nombre, String apellido, String cedula, String paralelo, String ciclo, String jornada,String modalidad) {

        estudiante.getEstudiante().setNombre(nombre);
        estudiante.getEstudiante().setApellido(apellido);
        estudiante.getEstudiante().setCedula(cedula);
        estudiante.getEstudiante().setParalelo(paralelo);
        estudiante.getEstudiante().setCiclo(ciclo);
        estudiante.getEstudiante().setJornada(jornada);
        estudiante.getEstudiante().setModalidad(modalidad);
        //usuario.getUsuario().setId_rol(this.rol.buscarRol(rol).getId());
        try {
            estudiante.guardar();
        } catch (IOException ex) {
            System.out.println("Error");
        }
    }

    public ListaEnlazada<Persona> buscarPorRolBinaria(String apellido) {
        ListaEnlazada<Persona> lista = usuario.listar();
        ListaEnlazada<Persona> resultado = new ListaEnlazada<>();

        Persona[] arreglo = lista.toArray();

        quickSortApellido(arreglo, 0, arreglo.length - 1);

        int l = 0, r = arreglo.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (arreglo[m].getApellido().equalsIgnoreCase(apellido)) {
                resultado.insertar(arreglo[m]);
                return resultado;
            } else if (arreglo[m].getApellido().compareToIgnoreCase(apellido) < 0) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        for (var a : arreglo) {
            System.out.println(a + " == " + apellido);
        }

        return resultado;
    }

    public ListaEnlazada<Persona> busquedaPorApellidoLineal(String apellido) {
        ListaEnlazada<Persona> lista = usuario.listar();
        ListaEnlazada<Persona> resultado = new ListaEnlazada<>();

        Persona[] arreglo = lista.toArray();

        quickSortApellido(arreglo, 0, arreglo.length - 1);

        for (Persona pc : arreglo) {
            if (pc.getApellido().toLowerCase().startsWith(apellido.toLowerCase())) {
                resultado.insertar(pc);
            }
        }

        return resultado;
    }

    private void swapApellido(Persona[] arr, int i, int j) {
        Persona temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int partitionApellido(Persona[] arr, int low, int high) {
        Persona pivot = arr[high];

        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            if (arr[j].getApellido().compareToIgnoreCase(pivot.getApellido()) < 0) {
                i++;
                swapApellido(arr, i, j);
            }
        }
        swapApellido(arr, i + 1, high);
        return (i + 1);
    }

    private void quickSortApellido(Persona[] arr, int low, int high) {
        if (low < high) {

            int pi = partitionApellido(arr, low, high);

            quickSortApellido(arr, low, pi - 1);
            quickSortApellido(arr, pi + 1, high);
        }
    }

}
