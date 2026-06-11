package com.duoc.totem_food.controller;

import com.duoc.totem_food.model.Categoria;
import com.duoc.totem_food.model.Producto;
import com.duoc.totem_food.service.MenuService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*") 
@RestController
@RequestMapping("/api/menu")
@Tag(name = "Menú del Tótem", description = "Endpoints públicos para la pantalla del cliente")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @Operation(summary = "Obtener todas las categorías")
    @GetMapping("/categorias")
    public List<Categoria> obtenerCategorias() {
        return menuService.obtenerTodasLasCategorias();
    }

    @Operation(summary = "Obtener productos por categoría")
    @GetMapping("/productos/{idCategoria}")
    public List<Producto> obtenerProductosPorCategoria(@PathVariable int idCategoria) {
        return menuService.obtenerProductosPorCategoria(idCategoria);
    }

    @Operation(summary = "Crear una nueva categoría", description = "Permite registrar una sección en la base de datos")
    @PostMapping("/categorias")
    public Categoria crearCategoria(@RequestBody Categoria categoria) {
        return menuService.guardarCategoria(categoria);
    }

    @Operation(summary = "Crear un nuevo producto", description = "Permite registrar un alimento asociado a una categoría")
    @PostMapping("/productos")
    public Producto crearProducto(@RequestBody Producto producto) {
        return menuService.guardarProducto(producto);
    }

    @Operation(summary = "Eliminar una categoría", description = "Permite eliminar una categoría por su ID")
    @DeleteMapping("/categorias/{idCategoria}")
    public void eliminarCategoria(@PathVariable int idCategoria) {
        menuService.eliminarCategoria(idCategoria);
    }

    @Operation(summary = "Eliminar un producto", description = "Permite eliminar un producto por su ID")
    @DeleteMapping("/productos/{idProducto}")
    public void eliminarProducto(@PathVariable int idProducto) {
        menuService.eliminarProducto(idProducto);
    }
}

/*poblado de tablas sql para la presentacion

--------CATEGORÍAS---------------------------------------------------------------------------

INSERT INTO categorias (id_categoria, nombre_categoria) VALUES 
(1, 'Hamburguesas'),
(2, 'Papas Fritas y Acompañamientos'),
(3, 'Bebidas y Refrescos'),
(4, 'Postres y Helados'),
(5, 'Combos Promocionales'),
(6, 'Salsas y Extras');



--------PRODUCTOS----------------------------------------------------------------------------

-- Asegurar que las tablas estén limpias para evitar errores de duplicados de prueba antiguos
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE productos;
SET FOREIGN_KEY_CHECKS = 1;


- CATEGORÍA 1: HAMBURGUESAS

INSERT INTO productos (id_producto, nombre_producto, descripcion_producto, precio, url_imagen, id_categoria) VALUES
(1, 'Hamburguesa Italiana', 'Jugosa carne de vacuno, palta fresca molida, tomate picado y mayonesa casera.', 6500, 'https://images.unsplash.com/photo-1568901346375-23c9450c58cd?w=500', 1),
(2, 'Burger Cheddar Bacon', 'Doble carne, triple queso cheddar fundido, tocino ahumado crujiente y salsa BBQ.', 7200, 'https://images.unsplash.com/photo-1594212699903-ec8a3eca50f5?w=500', 1),
(3, 'Hamburguesa Chacarera', 'Carne de vacuno a la plancha, porotos verdes tiernos, ají verde y tomate fresco.', 6800, 'https://images.unsplash.com/photo-1586190848861-99aa4a171e90?w=500', 1);


-- CATEGORÍA 2: PAPAS FRITAS Y ACOMPAÑAMIENTOS

INSERT INTO productos (id_producto, nombre_producto, descripcion_producto, precio, url_imagen, id_categoria) VALUES
(4, 'Papas Fritas Medianas', 'Papas rústicas cortadas a mano, doradas y crujientes con un toque de sal marina.', 2500, 'https://images.unsplash.com/photo-1573080496219-bb080dd4f877?w=500', 2),
(5, 'Papas Supremas Cheddar', 'Porción grande de papas fritas bañadas en salsa de queso cheddar y trozos de tocino.', 4500, 'https://images.unsplash.com/photo-1585109649139-366815a0d713?w=500', 2),
(6, 'Aros de Cebolla Crujientes', '10 unidades de aros de cebolla rebozados en panko, fritos al minuto.', 2800, 'https://images.unsplash.com/photo-1639024471283-2da7b3c6a267?w=500', 2);


-- CATEGORÍA 3: BEBIDAS Y REFRESCOS

INSERT INTO productos (id_producto, nombre_producto, descripcion_producto, precio, url_imagen, id_categoria) VALUES
(7, 'Bebida en Lata 350ml', 'Variedad de refrescos (Coca-Cola, Sprite, Fanta) helados en lata.', 1500, 'https://images.unsplash.com/photo-1622483767028-3f66f32aef97?w=500', 3),
(8, 'Jugo Natural del Día', 'Exprimido natural de fruta de la estación (Frutilla, Frambuesa o Mango).', 2500, 'https://images.unsplash.com/photo-1536882240095-0379873feb4e?w=500', 3),
(9, 'Agua Mineral 500ml', 'Agua purificada premium, disponible con o sin gas, muy helada.', 1200, 'https://images.unsplash.com/photo-1608885898957-a599fb1698d6?w=500', 3);


-- CATEGORÍA 4: POSTRES Y HELADOS

INSERT INTO productos (id_producto, nombre_producto, descripcion_producto, precio, url_imagen, id_categoria) VALUES
(10, 'Brownie con Helado', 'Brownie casero tibio de chocolate amargo acompañado de una bola de helado de vainilla.', 3500, 'https://images.unsplash.com/photo-1606313564200-e75d5e30476c?w=500', 4),
(11, 'Copa de Helado Artesanal', 'Tres suntuosas bolas de helado a elección con salsa de chocolate y mostacillas.', 2900, 'https://images.unsplash.com/photo-1563805042-7684c019e1cb?w=500', 4);


- CATEGORÍA 5: COMBOS PROMOCIONALES

INSERT INTO productos (id_producto, nombre_producto, descripcion_producto, precio, url_imagen, id_categoria) VALUES
(12, 'Combo Italiano Clásico', 'Hamburguesa Italiana + Papas Fritas Medianas + Bebida en lata a elección.', 8900, 'https://images.unsplash.com/photo-1610614819513-58e34989848b?w=500', 5),
(13, 'Mega Combo Cheddar Doble', 'Burger Cheddar Bacon + Papas Supremas + Bebida en lata a elección.', 10500, 'https://images.unsplash.com/photo-1550547660-d9450f859349?w=500', 5);


-- CATEGORÍA 6: SALSAS Y EXTRAS

INSERT INTO productos (id_producto, nombre_producto, descripcion_producto, precio, url_imagen, id_categoria) VALUES
(14, 'Salsa Mayo Casera de Ajo', 'Pote extra de nuestra famosa mayonesa artesanal con un toque sutil de ajo.', 600, 'https://images.unsplash.com/photo-1571115177098-24ec420951d5?w=500', 6),
(15, 'Porción de Queso Cheddar Extra', 'Salsa de queso cheddar líquido extra caliente para untar tus snacks.', 1000, 'https://images.unsplash.com/photo-1552763427-4d68e3ac1b1a?w=500', 6);  */