package proyectoepk.backend;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/contratos")
@CrossOrigin(origins = "*")
public class ContratoController {

    @PostMapping
    public ResponseEntity<Map<String, Object>> recibirContrato(
            @RequestBody Map<String, Object> contrato) {

        // ✅ ESTO DEBE APARECER EN LA TERMINAL DE VS CODE
        System.out.println("✅ CONTRATO RECIBIDO EN EL BACKEND:");
        System.out.println(contrato);

        Object valorTotal = contrato.get("valorTotal");

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("mensaje", "Contrato recibido correctamente");
        respuesta.put("valorTotal", valorTotal);

        return ResponseEntity.ok(respuesta);
    }
}
