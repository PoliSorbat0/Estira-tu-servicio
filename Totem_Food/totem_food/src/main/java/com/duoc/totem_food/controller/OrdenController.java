package com.duoc.totem_food.controller;

import com.duoc.totem_food.DTO.PagoRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.HashMap;
import java.util.UUID;
import java.util.Random;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/ordenes")
public class OrdenController {

    // NUEVO ENDPOINT: Para recibir el carrito del frontend y crear la orden
    @PostMapping("/crear")
    public ResponseEntity<?> crearOrden(@RequestBody Map<String, Object> payload) {
        // Aquí eventualmente guardarías la orden en la base de datos usando un servicio.
        // Por ahora, simulamos la creación devolviendo un ID generado aleatoriamente.
        int idOrdenGenerado = new Random().nextInt(1000) + 1;
        
        Map<String, Object> response = new HashMap<>();
        response.put("idOrden", idOrdenGenerado);
        response.put("mensaje", "Orden creada exitosamente");
        
        return ResponseEntity.ok(response);
    }

    // Tu código existente para procesar el pago...
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