package proyectoepk.backend.dao;

import proyectoepk.backend.model.Contrato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ContratoDAO {

    public void guardarContrato(Contrato contrato) {

        String sql = "INSERT INTO contratos (nombre_cliente, telefono, evento, fecha_evento, valor_total) VALUES (?, ?, ?, ?, ?)";

        Connection conexion = ConexionBD.conectar();

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setString(1, contrato.getNombreCliente());
            ps.setString(2, contrato.getTelefono());
            ps.setString(3, contrato.getEvento());
            ps.setString(4, contrato.getFechaEvento());
            ps.setDouble(5, contrato.getValorTotal());

            ps.executeUpdate();

            System.out.println("Contrato guardado correctamente");

        } catch (SQLException e) {
            System.out.println("Error al guardar contrato: " + e.getMessage());
        }
    }

    // ✅ ESTE MÉTODO VA DENTRO DE LA CLASE
    public void listarContratos() {

        String sql = "SELECT * FROM contratos";

        Connection conexion = ConexionBD.conectar();

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Cliente: " + rs.getString("nombre_cliente"));
                System.out.println("Teléfono: " + rs.getString("telefono"));
                System.out.println("Evento: " + rs.getString("evento"));
                System.out.println("Fecha: " + rs.getString("fecha_evento"));
                System.out.println("Valor: " + rs.getDouble("valor_total"));
                System.out.println("---------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar contratos: " + e.getMessage());
        }
    }

    // ✅ AHORA SÍ AGREGAMOS EL UPDATE
    public void actualizarContrato(Contrato contrato) {

        String sql = "UPDATE contratos SET nombre_cliente=?, telefono=?, evento=?, fecha_evento=?, valor_total=? WHERE id=?";

        Connection conexion = ConexionBD.conectar();

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setString(1, contrato.getNombreCliente());
            ps.setString(2, contrato.getTelefono());
            ps.setString(3, contrato.getEvento());
            ps.setString(4, contrato.getFechaEvento());
            ps.setDouble(5, contrato.getValorTotal());
            ps.setInt(6, contrato.getId());

            ps.executeUpdate();

            System.out.println("Contrato actualizado correctamente");

        } catch (SQLException e) {
            System.out.println("Error al actualizar contrato: " + e.getMessage());
        }
    }


    public void eliminarContrato(int id) {

    String sql = "DELETE FROM contratos WHERE id=?";

    Connection conexion = ConexionBD.conectar();

    try {
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, id);

        ps.executeUpdate();

        System.out.println("Contrato eliminado correctamente");

    } catch (SQLException e) {
        System.out.println("Error al eliminar contrato: " + e.getMessage());
    }
}

}
