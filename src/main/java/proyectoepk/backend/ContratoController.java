package proyectoepk.backend;

import proyectoepk.backend.dao.ContratoDAO;
import proyectoepk.backend.model.Contrato;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Controlador REST encargado de gestionar las operaciones CRUD
 * relacionadas con los contratos.
 * Permite crear, listar, actualizar y eliminar contratos
 * mediante servicios web (API REST).
 */
@RestController
@RequestMapping("/contratos")
@CrossOrigin(
    origins = "*",
    methods = {
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.PUT,
        RequestMethod.DELETE,
        RequestMethod.OPTIONS
    },
    allowedHeaders = "*"
)
public class ContratoController {


    private ContratoDAO dao = new ContratoDAO();

    /**
     * Método GET para verificar que la API está activa.
     */
    @GetMapping
    public ResponseEntity<Map<String, Object>> estadoApi() {
        Map<String, Object> r = new HashMap<>();
        r.put("mensaje", "API de contratos activa.");
        return ResponseEntity.ok(r);
    }

    /**
     * Crea un nuevo contrato en la base de datos.
     * Endpoint: POST /contratos
     */
    @PostMapping
    public ResponseEntity<Map<String, Object>> crearContrato(@RequestBody Map<String, Object> datos) {

        Contrato contrato = construirContratoDesdeDatos(datos);

        dao.guardarContrato(contrato);

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("mensaje", "Contrato guardado correctamente");
        respuesta.put("valorTotal", contrato.getValorTotal());

        return ResponseEntity.ok(respuesta);
    }

    /**
     * Lista los contratos registrados.
     * Endpoint: GET /contratos/listar
     */
    @GetMapping("/listar")
    public ResponseEntity<String> listarContratos() {

        dao.listarContratos(); // actualmente imprime en consola
        return ResponseEntity.ok("Lista de contratos mostrada en consola");
    }

    /**
     * Actualiza un contrato existente según su ID.
     * Endpoint: PUT /contratos/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarContrato(@PathVariable int id,
                                                     @RequestBody Map<String, Object> datos) {

        Contrato contrato = construirContratoDesdeDatos(datos);
        contrato.setId(id);

        dao.actualizarContrato(contrato);

        return ResponseEntity.ok("Contrato actualizado correctamente");
    }

    /**
     * Elimina un contrato según su ID.
     * Endpoint: DELETE /contratos/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarContrato(@PathVariable int id) {

        dao.eliminarContrato(id);
        return ResponseEntity.ok("Contrato eliminado correctamente");
    }

    /**
     * Método auxiliar para construir un objeto Contrato
     * a partir del JSON recibido.
     */
    private Contrato construirContratoDesdeDatos(Map<String, Object> datos) {

        Contrato contrato = new Contrato();

        contrato.setNombreCliente((String) datos.get("nombreCliente"));
        contrato.setDocumento((String) datos.get("documento"));
        contrato.setDireccion((String) datos.get("direccion"));
        contrato.setTelefono((String) datos.get("telefono"));
        contrato.setCorreo((String) datos.get("correo"));

        contrato.setLugarEvento((String) datos.get("lugarEvento"));
        contrato.setFechaInicio((String) datos.get("fechaInicio"));
        contrato.setFechaFin((String) datos.get("fechaFin"));
        contrato.setHoraInicio((String) datos.get("horaInicio"));
        contrato.setHoraFin((String) datos.get("horaFin"));

        Object serviciosObj = datos.get("servicios");
        contrato.setServicios(serviciosObj != null ? serviciosObj.toString() : "");

        Object vt = datos.get("valorTotal");
        contrato.setValorTotal(vt != null ? Double.parseDouble(vt.toString()) : 0.0);

        return contrato;
    }
}
