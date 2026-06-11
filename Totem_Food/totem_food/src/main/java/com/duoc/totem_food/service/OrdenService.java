package com.duoc.totem_food.service;

import com.duoc.totem_food.model.Orden;
import com.duoc.totem_food.model.DetalleOrden;
import com.duoc.totem_food.repository.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class OrdenService {

    private final OrdenRepository ordenRepository;

    OrdenService(OrdenRepository ordenRepository) {
        this.ordenRepository = ordenRepository;
    }

    public Orden guardarOrden(Orden nuevaOrden) {
        nuevaOrden.setFechaOrden(LocalDateTime.now());
        nuevaOrden.setEstado("PREPARANDO");

        if (nuevaOrden.getDetalles() != null) {
            for (DetalleOrden detalle : nuevaOrden.getDetalles()) {
                detalle.setOrden(nuevaOrden);
            }
        }

        return ordenRepository.save(nuevaOrden);
    }
}