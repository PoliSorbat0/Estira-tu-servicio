package com.duoc.totem_food.service;

import com.duoc.totem_food.model.Categoria;
import com.duoc.totem_food.model.Producto;
import com.duoc.totem_food.repository.CategoriaRepository;
import com.duoc.totem_food.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MenuService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    public List<Categoria> obtenerTodasLasCategorias() {
        return categoriaRepository.findAll();
    }

    public List<Producto> obtenerProductosPorCategoria(int idCategoria) {
        return productoRepository.findByCategoriaIdCategoria(idCategoria);
    }

    public Categoria guardarCategoria(Categoria categoria) {
    return categoriaRepository.save(categoria);
    }

public Producto guardarProducto(Producto producto) {
    return productoRepository.save(producto);
    }

    public void eliminarCategoria(int idCategoria) {
    categoriaRepository.deleteById(idCategoria);
    }

public void eliminarProducto(int idProducto) {
    productoRepository.deleteById(idProducto);
    }
}