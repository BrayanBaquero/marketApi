package com.devcode.marketplace.persistence.crud;

import com.devcode.marketplace.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoCrudRepository extends CrudRepository<Producto,Integer> {
}
