package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    Connection Conexion;

    public Connection conectar() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            String usuario = "root";
            String password = "Salometeamo21@";
            String url = "jdbc:mysql://localhost:3306/inventario";

            Conexion = DriverManager.getConnection(url, usuario, password);

            System.out.println("Conexion exitosa");

        } catch (ClassNotFoundException | SQLException e) {

            System.out.println("Error de conexion " + e);

        }

        return Conexion;
    }
}