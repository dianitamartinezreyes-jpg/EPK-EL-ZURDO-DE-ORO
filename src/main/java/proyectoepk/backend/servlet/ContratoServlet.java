package proyectoepk.backend.servlet;

import proyectoepk.backend.dao.ContratoDAO;
import proyectoepk.backend.model.Contrato;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/guardarContrato")
public class ContratoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // ⚠️ Estos nombres deben coincidir con tu form (name="...")
            Contrato contrato = new Contrato();

            contrato.setNombreCliente(request.getParameter("nombreCliente"));
            contrato.setDocumento(request.getParameter("documento"));
            contrato.setDireccion(request.getParameter("direccion"));
            contrato.setTelefono(request.getParameter("telefono"));
            contrato.setCorreo(request.getParameter("correo"));

            contrato.setLugarEvento(request.getParameter("lugarEvento"));
            contrato.setFechaInicio(request.getParameter("fechaInicio"));
            contrato.setFechaFin(request.getParameter("fechaFin"));
            contrato.setHoraInicio(request.getParameter("horaInicio"));
            contrato.setHoraFin(request.getParameter("horaFin"));

            // Servicios: si viene como checkboxes:
            // String[] servicios = request.getParameterValues("servicios");
            // contrato.setServicios(servicios != null ? String.join(", ", servicios) : "");
            contrato.setServicios(request.getParameter("servicios"));

            String valorStr = request.getParameter("valorTotal");
            contrato.setValorTotal(valorStr != null && !valorStr.isBlank() ? Double.parseDouble(valorStr) : 0.0);

            ContratoDAO dao = new ContratoDAO();
            dao.guardarContrato(contrato);

            response.getWriter().println("✅ Contrato guardado con éxito");

        } catch (Exception e) {
            response.getWriter().println("❌ Error: " + e.getMessage());
        }
    }
}
