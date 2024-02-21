/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Bravo
 */
public class Query {

    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        Connection connection = conexion.getConnection();

        String nombreTabla = "ROL";
        String atributos = "NOMBRE, DESCRIPCION";
        String valores = "?, ?";

        try {
            // aca por cada atributo que vas a meter pones un ?
            // o sea si son 4 pones ?, ?, ?, ?
            // los atributos pues (atributo1, atributo2) así ya sabes
            String sql = "INSERT INTO " + nombreTabla + " (" + atributos + ") VALUES (" + valores + ")";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                preparedStatement.setString(1, "Estudiant");
                preparedStatement.setString(2, "Descripción del Estudiant");
                
                System.out.println(sql.toString());

                int filasAfectadas = preparedStatement.executeUpdate();

                if (filasAfectadas > 0) {
                    System.out.println("Insert exitoso.");
                } else {
                    System.out.println("No se pudo realizar el insert.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {

                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
