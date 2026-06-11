package com.duoc.totem_food.repository;

import com.duoc.totem_food.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}