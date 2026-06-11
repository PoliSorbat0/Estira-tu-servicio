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

//sisi
//que te vaya ayudando el nico xd