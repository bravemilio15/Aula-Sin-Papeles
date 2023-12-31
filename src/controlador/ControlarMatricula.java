/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.dao.EstudianteDao;
import controlador.dao.MatriculaDao;
import controlador.ed.lista.ListaEnlazada;
import java.io.IOException;
import modelo.Estudiante;
import modelo.Matricula;

/**
 *
 * @author cristian
 */
public class ControlarMatricula {

    private MatriculaDao matriculaDao;
    private Matricula matricula;
    private EstudianteDao estudianteDao;

    public ControlarMatricula() {
        this.matriculaDao = new MatriculaDao();
        this.estudianteDao = new EstudianteDao();
    }

    public MatriculaDao getMatriculaDao() {
        return matriculaDao;
    }

    public void setMatriculaDao(MatriculaDao matriculaDao) {
        this.matriculaDao = matriculaDao;
    }

    public ListaEnlazada<Matricula> listar() {
        return matriculaDao.listar();
    }

    public Matricula getMatricula() {
        if (matricula == null) {
            matricula = new Matricula();
        }
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public void guardarMatricula(String carrera, String estado, String nivel) {

        matriculaDao.getMatricula().setCarrera(carrera);
        matriculaDao.getMatricula().setEstado(estado);
        matriculaDao.getMatricula().setNivel_academico(nivel);
        //usuario.getUsuario().setId_rol(this.rol.buscarRol(rol).getId());
        try {
            matriculaDao.guardar();
        } catch (IOException ex) {
            System.out.println("Error");
        }
    }

    public ListaEnlazada<Estudiante> busquedaPorNombreLineal(String nombre) {
        ListaEnlazada<Estudiante> lista = estudianteDao.listar();
        ListaEnlazada<Estudiante> resultado = new ListaEnlazada<>();

        Estudiante[] arreglo = lista.toArray();

        quickSortNombre(arreglo, 0, arreglo.length - 1);

        for (Estudiante pc : arreglo) {
            if (pc.getNombre().toLowerCase().startsWith(nombre.toLowerCase())) {
                resultado.insertar(pc);
            }
        }

        return resultado;
    }

    public ListaEnlazada<Estudiante> buscarPorNombreBinaria(String nombre) {
        ListaEnlazada<Estudiante> lista = estudianteDao.listar();
        ListaEnlazada<Estudiante> resultado = new ListaEnlazada<>();

        Estudiante[] arreglo = lista.toArray();

        quickSortNombre(arreglo, 0, arreglo.length - 1);

        int l = 0, r = arreglo.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (arreglo[m].getNombre().equalsIgnoreCase(nombre)) {
                resultado.insertar(arreglo[m]);
                return resultado;
            } else if (arreglo[m].getNombre().compareToIgnoreCase(nombre) < 0) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        for (var a : arreglo) {
            System.out.println(a + " == " + nombre);
        }

        return resultado;
    }

    private void quickSortNombre(Estudiante[] arr, int low, int high) {
        if (low < high) {

            int pi = partitionNombre(arr, low, high);

            quickSortNombre(arr, low, pi - 1);
            quickSortNombre(arr, pi + 1, high);
        }
    }

    private int partitionNombre(Estudiante[] arr, int low, int high) {
        Estudiante pivot = arr[high];

        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            if (arr[j].getNombre().compareToIgnoreCase(pivot.getNombre()) < 0) {
                i++;
                swapNombre(arr, i, j);
            }
        }
        swapNombre(arr, i + 1, high);
        return (i + 1);
    }

    private void swapNombre(Estudiante[] arr, int i, int j) {
        Estudiante temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public ListaEnlazada<Estudiante> busquedaPorCedulaLineal(String cedula) {
        ListaEnlazada<Estudiante> lista = estudianteDao.listar();
        ListaEnlazada<Estudiante> resultado = new ListaEnlazada<>();

        Estudiante[] arreglo = lista.toArray();

        quickSortNombre(arreglo, 0, arreglo.length - 1);

        for (Estudiante pc : arreglo) {
            if (pc.getNombre().toLowerCase().startsWith(cedula.toLowerCase())) {
                resultado.insertar(pc);
            }
        }

        return resultado;
    }

    public ListaEnlazada<Estudiante> buscarPorCedulaBinaria(String cedula) {
        ListaEnlazada<Estudiante> lista = estudianteDao.listar();
        ListaEnlazada<Estudiante> resultado = new ListaEnlazada<>();

        Estudiante[] arreglo = lista.toArray();

        quickSortNombre(arreglo, 0, arreglo.length - 1);

        int l = 0, r = arreglo.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (arreglo[m].getCedula().equalsIgnoreCase(cedula)) {
                resultado.insertar(arreglo[m]);
                return resultado;
            } else if (arreglo[m].getCedula().compareToIgnoreCase(cedula) < 0) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        for (var a : arreglo) {
            System.out.println(a + " == " + cedula);
        }

        return resultado;
    }
}
