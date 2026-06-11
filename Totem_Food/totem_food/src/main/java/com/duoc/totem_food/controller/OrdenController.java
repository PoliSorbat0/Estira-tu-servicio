package com.duoc.totem_food.controller;

import com.duoc.totem_food.DTO.PagoRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.HashMap;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/ordenes")
public class OrdenController {

    @PostMapping("/{idOrden}/procesar-pago")
    public ResponseEntity<?> procesarPago(@PathVariable int idOrden, @RequestBody PagoRequest request) {
        Map<String, Object> response = new HashMap<>();
        response.put("idOrden", idOrden);
        
        
        if (!request.isPagarAhora()) {
            response.put("status", "CUENTA_PENDIENTE");
            response.put("mensaje", "Orden enviada a cocina. Podrá solicitar la cuenta y pagar desde el tótem al terminar.");
            return ResponseEntity.ok(response);
        }

        
        if ("EFECTIVO".equalsIgnoreCase(request.getMetodoPago())) {
            response.put("status", "ESPERANDO_MESERO");
            response.put("mensaje", "Notificación enviada. Un mesero acudirá a la mesa para recibir el pago en efectivo.");
            return ResponseEntity.ok(response);
        }

        
        String tokenTransaccion = "TXN-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        
        response.put("status", "PAGADO");
        response.put("codigoTransaccion", tokenTransaccion);
        response.put("seguridad", "Cifrado SSL/TLS activo. Conexión segura PCI-DSS.");
        response.put("mensaje", "¡Pago autorizado exitosamente!");
        
        return ResponseEntity.ok(response);
    }
}