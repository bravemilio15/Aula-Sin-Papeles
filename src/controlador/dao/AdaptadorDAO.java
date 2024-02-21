/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import controlador.ed.listas.LinkedList;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase adaptadora para los metodos de guardar, modificar, listar y buscar por
 * id desde la Base de datos
 *
 * @author infierno
 */
public class AdaptadorDao<T> implements InterfazDao<T> {

    /**
     * Obejto Conexion
     */
    private Conexion conexion;
    /**
     * Class del modelo a usar
     */
    private Class clazz;

    /**
     * Constructor de la clase
     *
     * @param clazz El objeto de la clase del modelo Ejemplo: Persona.class
     */
    public AdaptadorDao(Class clazz) {
        this.conexion = new Conexion();
        this.clazz = clazz;
    }

    /**
     * Metodo que permite guardar
     *
     * @param obj El objeto del modelo lleno
     * @return La llave primaria generada por el motor de base de datos (se
     * sugiere construir la tabla de base de datos con la generacion de id auto
     * incementable)
     * @throws Exception Cuando no se puede guardar en la base de datos
     */
    @Override
    public Integer guardar(T obj) throws Exception {
        //INSERT INTO <TABLA> (..) value (...)
        String query = queryInsert(obj);
        System.out.println(query);
        Integer idGenerado = -1;
        PreparedStatement statement
                = conexion.getConnection().prepareStatement(query,
                        Statement.RETURN_GENERATED_KEYS);
        System.out.println("Hola");
        statement.executeUpdate();

        ResultSet generatedKeys = statement.getGeneratedKeys();

//        if (generatedKeys.next()) {
//            idGenerado = generatedKeys.getInt(1);
//        }
        conexion.getConnection().close();
        conexion.setConnection(null);

        return idGenerado;
    }

    /**
     * Metodo que permite modificar un registro en la base de datos, para
     * modificar se debe primero consultar el Objeto haciendo uso del metodo
     * Obtener
     *
     * @param obj El objeto del modelo a modificar
     * @throws Exception Alguna Excepcion si no modifica
     */
    @Override
    public void modificar(T obj) throws Exception {
        String query = queryUpdate(obj);
        System.out.println(query);
        Statement st = conexion.getConnection().createStatement();
        st.executeUpdate(query);
        conexion.getConnection().close();
        conexion.setConnection(null);
    }

    /**
     * Metodo que permite sacar los datos de la base de datos
     *
     * @return Un Objeto de la LinkedList con los datos llenos
     */
    @Override
    public LinkedList<T> listar() {

        LinkedList<T> lista = new LinkedList<>();
        try {
            Statement stmt = conexion.getConnection().createStatement();
            String query = "SELECT * FROM " + clazz.getSimpleName().toLowerCase();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                lista.add(llenarObjeto(rs));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return lista;
    }

    /**
     * Permite obtener un objeto de la base de datos a travez del Id
     *
     * @param id El id a buscar en la base de datos
     * @return El objeto buscado, es null si no esxiste el objeto
     */
    @Override
    public T obtener(Integer id) {
        T data = null;
        try {
            Statement stmt = conexion.getConnection().createStatement();
            String query = "select * from " + clazz.getSimpleName().toLowerCase()
                    + " WHERE " + clazz.getSimpleName().toLowerCase() + "_id = " + id;

            System.out.println(query);
            //select * from rol WHERE id_rol = 0
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                data = llenarObjeto(rs);
            }
        } catch (Exception e) {
        }
        return data;
    }

    public Integer generated_id() {
        return listar().getSize() + 1;
    }

    //--------------ESTO ES DEL CRUD NO MODIFICAR AL MENOS QUE LO NECESITES------
    private T llenarObjeto(ResultSet rs) {
        T data = null;
        try {
            data = (T) clazz.getDeclaredConstructor().newInstance();
            for (Field f : clazz.getDeclaredFields()) {
                String atributo = f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);
                fijarDatos(f, rs, data, atributo);
            }
            for (Field f : clazz.getSuperclass().getDeclaredFields()) {
                String atributo = f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);
                fijarDatos(f, rs, data, atributo);
            }

        } catch (Exception e) {
            System.out.println("error " + e);
        }
        return data;
    }

    private void fijarDatos(Field f, ResultSet rs, T data, String atributo) {
        try {
            Method m = null;

            if (f.getType().getSimpleName().equalsIgnoreCase("String")) {
                m = clazz.getMethod("set" + atributo, String.class);
                m.invoke(data, rs.getString(atributo));
            }

            if (f.getType().getSimpleName().equalsIgnoreCase("Integer")) {
                m = clazz.getMethod("set" + atributo, Integer.class);
                m.invoke(data, rs.getInt(atributo));
            }

            if (f.getType().getSimpleName().equalsIgnoreCase("Double")) {
                m = clazz.getMethod("set" + atributo, Double.class);
                m.invoke(data, rs.getDouble(atributo));
            }

            if (f.getType().getSimpleName().equalsIgnoreCase("Boolean")) {
                m = clazz.getMethod("set" + atributo, Boolean.class);
                m.invoke(data, rs.getBoolean(atributo));
            }

            if (f.getType().getSimpleName().equalsIgnoreCase("Date")) {
                m = clazz.getMethod("set" + atributo, Date.class);
                m.invoke(data, rs.getDate(atributo));
            }

            if (f.getType().isEnum()) {

                m = clazz.getMethod("set" + atributo, (Class<Enum>) f.getType());
                m.invoke(data, Enum.valueOf((Class<Enum>) f.getType(), rs.getString(atributo)));
            }
        } catch (Exception e) {
            System.out.println("chiqui error " + e);
        }
    }

    private HashMap<String, Object> obtenerObjeto(T obj) {
        HashMap<String, Object> mapa = new HashMap<>();
        try {
            for (Field f : clazz.getDeclaredFields()) {
                String atributo = f.getName();
                Method m = clazz.getMethod("get" + atributo.substring(0, 1).toUpperCase() + atributo.substring(1));
                Object aux = m.invoke(obj);
                mapa.put(atributo.toLowerCase(), aux);
            }
            for (Field f : clazz.getSuperclass().getDeclaredFields()) {
                String atributo = f.getName();
                Method m = clazz.getMethod("get" + atributo.substring(0, 1).toUpperCase() + atributo.substring(1));
                Object aux = m.invoke(obj);
                mapa.put(atributo.toLowerCase(), aux);
            }
        } catch (Exception e) {
            System.out.println("No se pudo obtener el dato: " + e.getMessage());
        }
        return mapa;
    }

//    private String queryInsert(T obj) {
//        HashMap<String, Object> mapa = obtenerObjeto(obj);
//        String query = "INSERT INTO " + clazz.getSimpleName().toLowerCase() + " (";
//        String values = " VALUES (";
//        for (Map.Entry<String, Object> entry : mapa.entrySet()) {
//            query += entry.getKey() + ",";
//            if (entry.getValue() instanceof String) {
//                values += "'" + entry.getValue() + "',";
//            } else {
//                values += entry.getValue() + ",";
//            }
//        }
//        query = query.substring(0, query.length() - 1) + ")";
//        values = values.substring(0, values.length() - 1) + ")";
//        return query + values;
//    }
    
    private String queryInsert(T obj) {
        HashMap<String, Object> mapa = obtenerObjeto(obj);
        String query = "INSERT INTO " + clazz.getSimpleName().toLowerCase() + " (";
        String values = " VALUES (";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (Map.Entry<String, Object> entry : mapa.entrySet()) {
            query += entry.getKey() + ",";
            if (entry.getValue() instanceof String) {
                values += "'" + entry.getValue() + "',";
            } else if (entry.getValue() instanceof Date) {
    
                values += "'" + dateFormat.format(entry.getValue()) + "',";
            } else {
                values += entry.getValue() + ",";
            }
        }
        query = query.substring(0, query.length() - 1) + ")";
        values = values.substring(0, values.length() - 1) + ")";
        return query + values;
    }

    private String queryUpdate(T obj) {
        HashMap<String, Object> mapa = obtenerObjeto(obj);
        String query = "UPDATE " + clazz.getSimpleName().toLowerCase() + " SET ";
        String idColumn = clazz.getSimpleName().toLowerCase() + "_id";
        String idValue = "";

        for (Map.Entry<String, Object> entry : mapa.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(idColumn)) {
                idValue = entry.getValue().toString();
            } else {
                query += entry.getKey() + " = ";
                if (entry.getValue() instanceof Number || entry.getValue() instanceof Boolean) {
                    query += entry.getValue();
                } else if (entry.getValue() instanceof Date) {
                    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    query += "'" + formato.format(entry.getValue()) + "'";
                } else if (entry.getValue().getClass().isEnum() || entry.getValue() instanceof String) {
                    query += "'" + entry.getValue().toString() + "'";
                }
                query += ", ";
            }
        }

        query = query.substring(0, query.length() - 2);
        query += " WHERE " + idColumn + " = " + idValue;

        return query;
    }

}
