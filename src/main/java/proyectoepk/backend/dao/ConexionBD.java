package proyectoepk.backend.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase encargada de gestionar la conexión
 * con la base de datos MySQL mediante JDBC.
 * Proporciona un método estático para obtener
 * una conexión activa hacia la base de datos EPK.
 */
public class ConexionBD {

    // URL de conexión a la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/epk";

    // Usuario de la base de datos
    private static final String USER = "root";

    // Contraseña de la base de datos
    private static final String PASSWORD = ""; // Colocar contraseña si aplica

    /**
     * Establece y retorna una conexión con la base de datos.
     *
     * @return Objeto Connection si la conexión es exitosa,
     *         o null en caso de error.
     */
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
