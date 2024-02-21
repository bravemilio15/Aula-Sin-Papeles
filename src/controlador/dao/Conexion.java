/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
 */
public class Conexion {

    private Connection connection;
    // Librería de MySQL
    public String driver = "oracle.jdbc.OracleDriver";//"com.mysql.cj.jdbc.Driver";

//    // Nombre de la base de datos
//    public String database = "AulaSinPapeles";
    // Host
    public String hostname = "localhost";

    // Puerto
    public String port = "1521";// 3306

    // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
    //String aux = "jdbc:oracle:thin:@"+hostname+":"+port+":"+database;
//    public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";//"jdbc:oracle:thin:@"+hostname+":"+port+":"+database;
    public String url = "jdbc:oracle:thin:@" + hostname + ":" + port + ":XE";
    // Nombre de usuario
    public String username = "PIS";

    // Clave de usuario
    public String password = "1234";

    private Connection conectar() {
        Connection conn = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Conected!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public Connection getConnection() {
        if (connection == null) {
            connection = conectar();
        }
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        Connection connection = conexion.getConnection();

        if (connection != null) {
            System.out.println("Conexión exitosa a la base de datos.");

        } else {
            System.out.println("Fallo en la conexión a la base de datos.");
        }
    }

    /*private XStream xstream;
    public static String URL = "data/";
    private void conectar() {         
        xstream = new XStream(new JettisonMappedXmlDriver());        
         xstream.setMode(XStream.NO_REFERENCES);
         xstream.addPermission(AnyTypePermission.ANY);
    }
    public XStream getXstream() {
        if(xstream == null)
            conectar();
        return xstream;
    }
    public void setXstream(XStream xstream) {
        this.xstream = xstream;
    }*/
}
