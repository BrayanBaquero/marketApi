package com.devcode.marketplace.persistence;

import com.devcode.marketplace.persistence.crud.ProductoCrudRepository;
import com.devcode.marketplace.persistence.entity.Producto;

import java.util.List;

public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }
}
