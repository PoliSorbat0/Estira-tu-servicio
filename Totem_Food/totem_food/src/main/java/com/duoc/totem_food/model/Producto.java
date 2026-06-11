package com.duoc.totem_food.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties; // Asegúrate de tener este import

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;

    @NotBlank
    private String nombreProducto;

    @NotBlank
    private String descripcionProducto;

    @NotNull
    private Double precio; // Recuerda dejarlo en Double con mayúscula

    @NotBlank
    private String urlImagen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria")
    @JsonIgnoreProperties("productos") // <-- ESTO CORTA EL BUCLE HACIA ABAJO
    private Categoria categoria;
}