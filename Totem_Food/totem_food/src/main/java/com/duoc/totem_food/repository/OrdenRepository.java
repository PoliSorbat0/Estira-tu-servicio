package com.duoc.totem_food.repository;

import com.duoc.totem_food.model.Orden;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdenRepository extends JpaRepository<Orden, Integer> {
}