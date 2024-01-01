package controlador;

import controlador.dao.EstudianteDao;
import controlador.dao.MatriculaDao;
import controlador.dao.MateriaDao;
import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.EmptyException;
import controlador.ed.lista.exception.PositionException;
import java.io.IOException;
import modelo.Ciclo;
import modelo.Estudiante;
import modelo.Materia;
import modelo.Matricula;
import modelo.Paralelo;
import modelo.Rol;

public class Control {

    private EstudianteDao estudianteDao;
    private MatriculaDao matriculaDao;
    private MateriaDao materiaDao;

    public Control() {
        this.estudianteDao = new EstudianteDao();
        this.matriculaDao = new MatriculaDao();
        this.materiaDao = new MateriaDao();
    }

    public EstudianteDao getEstudianteDao() {
        return estudianteDao;
    }

    public void setEstudianteDao(EstudianteDao estudianteDao) {
        this.estudianteDao = estudianteDao;
    }

    public MatriculaDao getMatriculaDao() {
        return matriculaDao;
    }

    public void setMatriculaDao(MatriculaDao matriculaDao) {
        this.matriculaDao = matriculaDao;
    }

    public MateriaDao getMateriaDao() {
        return materiaDao;
    }

    public void setMateriaDao(MateriaDao materiaDao) {
        this.materiaDao = materiaDao;
    }

    public ListaEnlazada<Estudiante> listarEstudiantes() {
        return estudianteDao.listar();
    }

    public ListaEnlazada<Matricula> listarMatriculas() {
        return matriculaDao.listar();
    }

    public ListaEnlazada<Materia> listarMaterias() {
        return materiaDao.listar();
    }

    public void guardarUsuario(String primerNombre, String segundoNombre, String primerApellido, String segundoApellido,
            String cedula, String celular, String estado, String nacimiento, Integer edad, String genero, String correoPer,
            String correoIns, Rol rol, Paralelo paralelo, Ciclo ciclo, String jornada, String modalidad) {

        Estudiante nuevoEstudiante = new Estudiante();
        nuevoEstudiante.setPrimer_nombre(primerNombre);
        nuevoEstudiante.setSegundo_nombre(segundoNombre);
        nuevoEstudiante.setPrimer_apellido(primerApellido);
        nuevoEstudiante.setSegundo_apellido(segundoApellido);
        nuevoEstudiante.setCedula(cedula);
        nuevoEstudiante.setCelular(celular);
        nuevoEstudiante.setEstado(estado);
        nuevoEstudiante.setNacimiento(nacimiento);
        nuevoEstudiante.setEdad(edad);
        nuevoEstudiante.setGenero(genero);
        nuevoEstudiante.setCorreoPer(correoPer);
        nuevoEstudiante.setCorreoIns(correoIns);
        nuevoEstudiante.setRol(rol);
        nuevoEstudiante.setParalelo(paralelo);
        nuevoEstudiante.setCiclo(ciclo);
        nuevoEstudiante.setJornada(jornada);
        nuevoEstudiante.setModalidad(modalidad);

        try {
            estudianteDao.guardar(nuevoEstudiante);
        } catch (IOException ex) {
            System.out.println("Error al guardar estudiante: " + ex.getMessage());
        }
    }

    public void guardarEstudiante(String primerNombre, String segundoNombre, String primerApellido, String segundoApellido,
            String cedula, String celular, String estado, String nacimiento, Integer edad, String genero, String correoPer,
            String correoIns, Rol rol, Paralelo paralelo, Ciclo ciclo, String jornada, String modalidad) {

        Estudiante nuevoEstudiante = new Estudiante();
        nuevoEstudiante.setPrimer_nombre(primerNombre);
        nuevoEstudiante.setSegundo_nombre(segundoNombre);
        nuevoEstudiante.setPrimer_apellido(primerApellido);
        nuevoEstudiante.setSegundo_apellido(segundoApellido);
        nuevoEstudiante.setCedula(cedula);
        nuevoEstudiante.setCelular(celular);
        nuevoEstudiante.setEstado(estado);
        nuevoEstudiante.setNacimiento(nacimiento);
        nuevoEstudiante.setEdad(edad);
        nuevoEstudiante.setGenero(genero);
        nuevoEstudiante.setCorreoPer(correoPer);
        nuevoEstudiante.setCorreoIns(correoIns);
        nuevoEstudiante.setRol(rol);
        nuevoEstudiante.setParalelo(paralelo);
        nuevoEstudiante.setCiclo(ciclo);
        nuevoEstudiante.setJornada(jornada);
        nuevoEstudiante.setModalidad(modalidad);

        try {
            estudianteDao.guardar(nuevoEstudiante);
        } catch (IOException ex) {
            System.out.println("Error al guardar estudiante: " + ex.getMessage());
        }
    }

    public ListaEnlazada<Estudiante> buscarPorApellidoBinaria(String apellido) {
        ListaEnlazada<Estudiante> lista = estudianteDao.listar();
        ListaEnlazada<Estudiante> resultado = new ListaEnlazada<>();

        Estudiante[] arreglo = lista.toArray();

        quickSortApellido(arreglo, 0, arreglo.length - 1);

        int l = 0, r = arreglo.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (arreglo[m].getPrimer_apellido().equalsIgnoreCase(apellido)) {
                resultado.insertar(arreglo[m]);
                return resultado;
            } else if (arreglo[m].getPrimer_apellido().compareToIgnoreCase(apellido) < 0) {
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

    public ListaEnlazada<Estudiante> busquedaPorApellidoLineal(String apellido) {
        ListaEnlazada<Estudiante> lista = estudianteDao.listar();
        ListaEnlazada<Estudiante> resultado = new ListaEnlazada<>();

        Estudiante[] arreglo = lista.toArray();

        quickSortApellido(arreglo, 0, arreglo.length - 1);

        for (Estudiante estudiante : arreglo) {
            if (estudiante.getPrimer_apellido().toLowerCase().startsWith(apellido.toLowerCase())) {
                resultado.insertar(estudiante);
            }
        }

        return resultado;
    }

    private void swapApellido(Estudiante[] arr, int i, int j) {
        Estudiante temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int partitionApellido(Estudiante[] arr, int low, int high) {
        Estudiante pivot = arr[high];

        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            if (arr[j].getPrimer_apellido().compareToIgnoreCase(pivot.getPrimer_apellido()) < 0) {
                i++;
                swapApellido(arr, i, j);
            }
        }
        swapApellido(arr, i + 1, high);
        return (i + 1);
    }

    private void quickSortApellido(Estudiante[] arr, int low, int high) {
        if (low < high) {
            int pi = partitionApellido(arr, low, high);
            quickSortApellido(arr, low, pi - 1);
            quickSortApellido(arr, pi + 1, high);
        }
    }
}
