package proyectoepk.backend.dao;

import proyectoepk.backend.model.Contrato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 * Clase DAO encargada de realizar operaciones CRUD
 * sobre la tabla contrato_epk usando JDBC.
 */
public class ContratoDAO {

    /**
     * Inserta un nuevo contrato en la base de datos.
     */
    public void guardarContrato(Contrato contrato) {

        String sql = "INSERT INTO contrato_epk " +
                "(nombre_cliente, documento, direccion, telefono, correo, lugar_evento, " +
                "fecha_inicio, fecha_fin, hora_inicio, hora_fin, servicios, valor_total, creado_en) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW())";

        Connection conexion = ConexionBD.conectar();

        if (conexion == null) {
            throw new RuntimeException("No se pudo conectar a la base de datos.");
        }

        try {

            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setString(1, contrato.getNombreCliente());
            ps.setString(2, contrato.getDocumento());
            ps.setString(3, contrato.getDireccion());
            ps.setString(4, contrato.getTelefono());
            ps.setString(5, contrato.getCorreo());
            ps.setString(6, contrato.getLugarEvento());
            ps.setString(7, contrato.getFechaInicio());
            ps.setString(8, contrato.getFechaFin());
            ps.setString(9, contrato.getHoraInicio());
            ps.setString(10, contrato.getHoraFin());
            ps.setString(11, contrato.getServicios());
            ps.setDouble(12, contrato.getValorTotal());

            ps.executeUpdate();

            System.out.println("✅ Contrato guardado correctamente en la base de datos.");

        } catch (SQLException e) {

            System.out.println("❌ Error SQL al guardar contrato: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * Lista los contratos registrados.
     */
    public void listarContratos() {

        String sql = "SELECT * FROM contrato_epk ORDER BY id DESC";

        Connection conexion = ConexionBD.conectar();

        if (conexion == null) {
            System.out.println("❌ No se pudo conectar a la base de datos.");
            return;
        }

        try {

            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Cliente: " + rs.getString("nombre_cliente"));
                System.out.println("Documento: " + rs.getString("documento"));
                System.out.println("Teléfono: " + rs.getString("telefono"));
                System.out.println("Correo: " + rs.getString("correo"));
                System.out.println("Lugar evento: " + rs.getString("lugar_evento"));
                System.out.println("Fecha inicio: " + rs.getString("fecha_inicio"));
                System.out.println("Fecha fin: " + rs.getString("fecha_fin"));
                System.out.println("Hora inicio: " + rs.getString("hora_inicio"));
                System.out.println("Hora fin: " + rs.getString("hora_fin"));
                System.out.println("Servicios: " + rs.getString("servicios"));
                System.out.println("Valor total: " + rs.getDouble("valor_total"));
                System.out.println("Creado en: " + rs.getTimestamp("creado_en"));
                System.out.println("---------------------------");
            }

        } catch (SQLException e) {

            System.out.println("❌ Error al consultar contratos: " + e.getMessage());
        }
    }

    /**
     * Actualiza un contrato existente.
     */
    public void actualizarContrato(Contrato contrato) {

        String sql = "UPDATE contrato_epk SET " +
                "nombre_cliente=?, documento=?, direccion=?, telefono=?, correo=?, lugar_evento=?, " +
                "fecha_inicio=?, fecha_fin=?, hora_inicio=?, hora_fin=?, servicios=?, valor_total=? " +
                "WHERE id=?";

        Connection conexion = ConexionBD.conectar();

        if (conexion == null) {
            System.out.println("❌ No se pudo conectar a la base de datos.");
            return;
        }

        try {

            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setString(1, contrato.getNombreCliente());
            ps.setString(2, contrato.getDocumento());
            ps.setString(3, contrato.getDireccion());
            ps.setString(4, contrato.getTelefono());
            ps.setString(5, contrato.getCorreo());
            ps.setString(6, contrato.getLugarEvento());
            ps.setString(7, contrato.getFechaInicio());
            ps.setString(8, contrato.getFechaFin());
            ps.setString(9, contrato.getHoraInicio());
            ps.setString(10, contrato.getHoraFin());
            ps.setString(11, contrato.getServicios());
            ps.setDouble(12, contrato.getValorTotal());
            ps.setInt(13, contrato.getId());

            ps.executeUpdate();

            System.out.println("✅ Contrato actualizado correctamente");

        } catch (SQLException e) {

            System.out.println("❌ Error al actualizar contrato: " + e.getMessage());
        }
    }

    /**
     * Elimina un contrato por ID.
     */
    public void eliminarContrato(int id) {

        String sql = "DELETE FROM contrato_epk WHERE id=?";

        Connection conexion = ConexionBD.conectar();

        if (conexion == null) {
            System.out.println("❌ No se pudo conectar a la base de datos.");
            return;
        }

        try {

            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("✅ Contrato eliminado correctamente");

        } catch (SQLException e) {

            System.out.println("❌ Error al eliminar contrato: " + e.getMessage());
        }
    }
}
