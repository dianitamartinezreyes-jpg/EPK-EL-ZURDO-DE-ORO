package proyectoepk.backend.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase encargada de gestionar la conexión
 * con la base de datos MySQL mediante JDBC.
 */
public class ConexionBD {

    public static Connection conectar() {
        try {
            String host = System.getenv("MYSQLHOST");
            String port = System.getenv("MYSQLPORT");
            String database = System.getenv("MYSQLDATABASE");
            String user = System.getenv("MYSQLUSER");
            String password = System.getenv("MYSQLPASSWORD");

            String url = "jdbc:mysql://" + host + ":" + port + "/" + database
                    + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

            Connection conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa a la base de datos");
            return conexion;

        } catch (SQLException e) {
            System.out.println("Error al conectar con la BD: " + e.getMessage());
            return null;
        }
    }
}
