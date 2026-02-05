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
            String nombre = request.getParameter("nombre");
            String telefono = request.getParameter("telefono");
            String evento = request.getParameter("evento");
            String fecha = request.getParameter("fecha");
            double valor = Double.parseDouble(request.getParameter("valor"));

            Contrato contrato = new Contrato();
            contrato.setNombreCliente(nombre);
            contrato.setTelefono(telefono);
            contrato.setEvento(evento);
            contrato.setFechaEvento(fecha);
            contrato.setValorTotal(valor);

            ContratoDAO dao = new ContratoDAO();
            dao.guardarContrato(contrato);

            response.getWriter().println("Contrato guardado con éxito");

        } catch (Exception e) {
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
