package com.devcode.marketplace.persistence;

import com.devcode.marketplace.domain.Product;
import com.devcode.marketplace.domain.repository.ProductRepository;
import com.devcode.marketplace.persistence.crud.ProductoCrudRepository;
import com.devcode.marketplace.persistence.entity.Producto;
import com.devcode.marketplace.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {
    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll(){
        List<Producto> productos=(List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId){
        List<Producto> productos=productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScaseProducts(int quantity){
        Optional<List<Producto>> productos=productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity,true);
        return productos.map(prods-> mapper.toProducts(prods));
    }

    @Override
    public  Optional<Product> getProduct(int productId){
        Optional<Producto> producto=productoCrudRepository.findById(productId);
        return producto.map(prod->mapper.toProduct(prod));
    }

    @Override
    public Product save(Product product){
        Producto producto= mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public  void delete(int productId){
        productoCrudRepository.deleteById(productId);
    }
}
