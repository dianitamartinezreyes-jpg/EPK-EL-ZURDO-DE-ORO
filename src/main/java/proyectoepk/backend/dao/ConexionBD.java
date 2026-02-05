package proyectoepk.backend.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL = "jdbc:mysql://localhost:3306/epk";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // pon tu contraseña si MySQL tiene

    public static Connection conectar() {
        try {
            Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos");
            return conexion;
        } catch (SQLException e) {
            System.out.println("Error al conectar con la BD: " + e.getMessage());
            return null;
        }
    }
}
