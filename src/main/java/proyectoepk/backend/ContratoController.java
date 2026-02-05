package proyectoepk.backend;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/contratos")
@CrossOrigin(origins = "*")
public class ContratoController {

    @PostMapping
    public ResponseEntity<Map<String, Object>> recibirContrato(@RequestBody Map<String, Object> contrato) {

        System.out.println("Contrato recibido: " + contrato);

        Object total = contrato.get("total");
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("total", total);

        return ResponseEntity.ok(respuesta);
    }
}
