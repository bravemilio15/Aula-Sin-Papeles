/*
 * To change this license cabeceraer, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.ed.lista;

import controlador.ed.lista.exception.EmptyException;
import controlador.ed.lista.exception.IndexListException;
import controlador.ed.lista.exception.NonExistentElementException;
import controlador.ed.lista.exception.PositionException;
import controlador.ed.lista.exception.VacioException;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Random;

/**
 *
 * @author cristian
 */
public class ListaEnlazada<E> {

    private NodoLista<E> cabecera;
    private Integer size = 0;
    private Field field;
    private String typeField;

    public NodoLista getCabecera() {
        return cabecera;
    }

    public void setCabecera(NodoLista cabecera) {
        this.cabecera = cabecera;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public boolean estaVacia() {
        return cabecera == null;
    }

    public boolean insertar(E info) {
        NodoLista<E> nuevo = new NodoLista<>(null, info);
        if (estaVacia()) {

            this.cabecera = nuevo;
            this.size++;
        } else {
            NodoLista<E> aux = cabecera;
//            for (int i = 0; i < size()-1; i++) {
//                aux = aux.getSig();
//            }
            while (aux.getSig() != null) {
                aux = aux.getSig();
            }
            aux.setSig(nuevo);
            this.size++;
        }
        return true;
    }

    /**
     *
     * @return
     */
    public Integer size() {

        return size;
    }

    public void imprimir() throws EmptyException {
        if (estaVacia()) {
            throw new EmptyException();
        } else {
            NodoLista<E> aux = cabecera;
            System.out.println("----------Lista------------");
            for (int i = 0; i < size(); i++) {
                System.out.println(aux.getInfo());
                aux = aux.getSig();
            }
            System.out.println("----------Lista fin--------------");
        }
    }

    public void insertarInicio(E info) {
        if (estaVacia()) {
            insertar(info);
        } else {
            NodoLista<E> nuevo = new NodoLista<>(null, info);
            nuevo.setSig(cabecera);
            cabecera = nuevo;
            size++;

        }
    }

    public void insertarPosicion(E info, Integer pos) throws PositionException {
        if (estaVacia()) {
            insertar(info);
        } else if (pos >= 0 && pos < size() && pos == 0) {
            insertarInicio(info);
        } else if (pos >= 0 && pos < size()) {
            NodoLista<E> nuevo = new NodoLista<>(null, info);
            NodoLista<E> aux = cabecera;
            for (int i = 0; i < (pos - 1); i++) {
                aux = aux.getSig();
            }
            NodoLista<E> sig = aux.getSig();
            aux.setSig(nuevo);
            nuevo.setSig(sig);
            size++;
        } else {
            throw new PositionException();
        }
    }

    public E get(Integer pos) throws EmptyException, PositionException {
        if (estaVacia()) {
            throw new EmptyException();
        } else {
            E dato = null;
            if (pos >= 0 && pos < size()) {
                if (pos == 0) {
                    dato = cabecera.getInfo();
                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < pos; i++) {
                        aux = aux.getSig();
                    }
                    dato = aux.getInfo();
                }
            } else {
                throw new PositionException();
            }
            return dato;
        }

    }

    public E delete(Integer pos) throws EmptyException, PositionException {
        if (estaVacia()) {
            throw new EmptyException();
        } else {
            E dato = null;
            if (pos >= 0 && pos < size()) {
                if (pos == 0) {
                    dato = cabecera.getInfo();
                    cabecera = cabecera.getSig();
                    size--;
                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < (pos - 1); i++) {
                        aux = aux.getSig();
                    }
                    if ((pos + 1) == size()) {
                        NodoLista<E> aux1 = aux.getSig();
                        // dato = aux.getSig().getInfo();
                    } else {
                        dato = aux.getInfo();
                    }
                    dato = aux.getInfo();
                    NodoLista<E> proximo = aux.getSig();
                    aux.setSig(proximo.getSig());
                    size--;
                }
            } else {

                throw new PositionException();
            }
            return dato;
        }

    }

    public void deleteAll() {
        this.cabecera = null;
        this.size = 0;
    }

    public void update(Integer pos, E dato) throws EmptyException, PositionException {
        if (estaVacia()) {
            throw new EmptyException();
        } else {
            if (pos >= 0 && pos < size()) {
                if (pos == 0) {
                    dato = cabecera.getInfo();

                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < pos; i++) {
                        aux = aux.getSig();
                    }
                    aux.setInfo(dato);
                }
            } else {
                throw new PositionException();
            }
        }

    }

    public E[] toArray() {
        Class clazz = null;
        E[] matriz = null;
        if (this.size > 0) {
            clazz = cabecera.getInfo().getClass();
            matriz = (E[]) java.lang.reflect.Array.newInstance(clazz, size);
            NodoLista<E> aux = cabecera;
            for (int i = 0; i < size; i++) {
                matriz[i] = aux.getInfo();
                aux = aux.getSig();
            }
        }
        return matriz;
    }

    public ListaEnlazada<E> toList(E[] m) {
        deleteAll();
        for (int i = 0; i < m.length; i++) {
            this.insertar(m[i]);
        }

        return this;
    }

    private void getAttribute(String attribute) {

        Field[] fields = this.cabecera.getInfo().getClass().getDeclaredFields();

        for (var fld : fields) {
            if (fld.getName().equals(attribute)) {
                this.field = fld;
            }
        }

        field.setAccessible(true);

        this.typeField = field.getType().getSimpleName();

    }

    private void resetAttribute() {
        field = null;
        typeField = null;
    }

    private Integer compare(E e1, E e2) throws IllegalAccessException {

        if (field == null) {
            System.out.println("Error en Compare Valor Nulo");
            return 0;
        }

        if (typeField.equals("Integer") || typeField.equals("Double")) {

            return Double.compare(((Number) field.get(e1)).doubleValue(), ((Number) field.get(e2)).doubleValue());

        } else {

            return Integer.compare(field.get(e1).toString().compareToIgnoreCase(field.get(e2).toString()), 0);

        }

    }

    private Integer compareS(E e1, Object e2) throws IllegalAccessException {
        if (field == null) {
            System.out.println("Error en CompareS Valor Nulo");
            return 0;
        }

        if (typeField.equals("Integer") || typeField.equals("Double")) {
            return Double.compare(((Number) field.get(e1)).doubleValue(), ((Number) e2).doubleValue());
        } else {
            return Integer.compare(field.get(e1).toString().compareToIgnoreCase(e2.toString()), 0);
        }
    }

    public void shuffle() throws VacioException {

        var tmpArr = this.toArray();

        Random random = new Random();

        for (Integer i = 0; i < tmpArr.length; i++) {

            Integer randomNum = random.nextInt(tmpArr.length - 1);

            var tmp = tmpArr[i];

            tmpArr[i] = tmpArr[randomNum];

            tmpArr[randomNum] = tmp;

        }

        this.toList(tmpArr);

    }

    private Integer partition(E[] arr, Integer low, Integer high, boolean typeSort) throws IllegalAccessException {

        var pivot = arr[high];

        Integer i = (low - 1);

        for (Integer j = low; j < high; j++) {

            if (typeSort ? compare(arr[j], pivot) <= 0 : compare(arr[j], pivot) >= 0) {

                i++;
                var tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;

            }

        }

        var tmp = arr[i + 1];

        arr[i + 1] = arr[high];

        arr[high] = tmp;

        return i + 1;

    }

    private void quick(E[] arr, Integer low, Integer high, boolean typeSort) throws IllegalAccessException {

        if (low < high) {

            Integer pi = partition(arr, low, high, typeSort);

            quick(arr, low, pi - 1, typeSort);

            quick(arr, pi + 1, high, typeSort);

        }

    }

    private void merge(E[] arr, Integer l, Integer m, Integer r, boolean typeSort) throws IllegalAccessException {

        Integer n1 = m - l + 1;
        Integer n2 = r - m;

        E[] L = (E[]) java.lang.reflect.Array.newInstance(this.cabecera.getInfo().getClass(), n1);

        E[] R = (E[]) java.lang.reflect.Array.newInstance(this.cabecera.getInfo().getClass(), n2);

        for (Integer i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }

        for (Integer j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }

        Integer i = 0, j = 0;

        Integer k = l;

        while (i < n1 && j < n2) {

            if (typeSort ? compare(L[i], R[j]) <= 0 : compare(L[i], R[j]) >= 0) {

                arr[k] = L[i];
                i++;

            } else {

                arr[k] = R[j];
                j++;

            }

            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }

    }

    private void sortMerge(E[] arr, Integer l, Integer r, boolean typeSort) throws IllegalAccessException {

        if (l < r) {

            Integer m = l + (r - l) / 2;

            sortMerge(arr, l, m, typeSort);

            sortMerge(arr, m + 1, r, typeSort);

            merge(arr, l, m, r, typeSort);

        }

    }

    public void mergeSort(String attribute, boolean typeSort) throws VacioException, IllegalAccessException {

        if (estaVacia()) {
            throw new VacioException();
        }

        if (getSize() == 1) {
            return;
        }

        getAttribute(attribute);

        var tmp = this.toArray();

        sortMerge(tmp, 0, (tmp.length - 1), typeSort);

        resetAttribute();

        this.toList(tmp);

    }

    public void quickSort(String attribute, boolean typeSort) throws VacioException, IllegalAccessException {

        if (estaVacia()) {
            throw new VacioException();
        }

        if (getSize() == 1) {
            return;
        }

        getAttribute(attribute);

        var tmp = this.toArray();

        quick(tmp, 0, (tmp.length - 1), typeSort);

        resetAttribute();

        this.toList(tmp);

    }

    private Integer binary(E[] arr, Object element, Integer low, Integer high) throws IllegalAccessException {

        if (high >= low) {

            Integer mid = low + (high - low) / 2;

            //check if mid-element is searched element
            if (compareS(arr[mid], element) == 0) {
                return mid;
            }

            //Search the left half of mid
            if (compareS(arr[mid], element) > 0) {
                return binary(arr, element, low, mid - 1);
            }

            //Search the right half of mid
            return binary(arr, element, mid + 1, high);

        }

        return -1;
    }

    public E binarySearch(String attribute, Object info) throws VacioException, IllegalAccessException, NonExistentElementException, IndexListException, EmptyException, PositionException {

        if (estaVacia()) {
            throw new VacioException();
        }

        var tmpArray = this.toArray();

        getAttribute(attribute);

        Integer idx = binary(tmpArray, info, 0, tmpArray.length - 1);

        resetAttribute();

        if (idx == -1) {
            System.out.println("Elemento no encontrado en la búsqueda binaria");
            throw new NonExistentElementException();
        }

        return this.get(idx);
    }

    public ListaEnlazada<E> linearSearch(String attribute, Object info) throws VacioException, IllegalAccessException, NonExistentElementException, IndexListException, EmptyException, PositionException {

        ListaEnlazada<E> result = new ListaEnlazada<>();

        var tmpArray = toArray();

        getAttribute(attribute);

        Integer idx = binary(tmpArray, info, 0, tmpArray.length - 1);

        if (idx == -1) {
            throw new NonExistentElementException();
        }

        Integer tmpIdx = 0;

        for (Integer i = idx; i >= 0; i--) {
            if (compareS(this.get(i), info) != 0) {
                break;
            }
            tmpIdx = i;
        }

        for (Integer i = tmpIdx; i < this.getSize(); i++) {
            if (compareS(this.get(i), info) == 0) {
                result.insertar(this.get(i));
            } else {
                break;
            }
        }

        resetAttribute();

        return result;
    }

    public ListaEnlazada<E> linearBinarySearch(String attribute, Object element) throws IllegalAccessException {

        if (estaVacia()) {
            throw new NullPointerException();
        }

        getAttribute(attribute);

        var result = new ListaEnlazada<E>();

        var tmp = this.toArray();

        for (int i = 0; i < tmp.length; i++) {

            if (compareS(tmp[i], element) == 0) {
                result.insertar(tmp[i]);
            }

        }

        return result;

    }

    private Integer indexOf(E element) throws VacioException, IndexListException, IllegalAccessException, NonExistentElementException, EmptyException, PositionException {
        for (Integer i = 0; i < getSize(); i++) {
            if (compareS(get(i), element) == 0) {
                return i;
            }
        }
        throw new NonExistentElementException(); // Cambiado a NonExistentElementException
    }
}
