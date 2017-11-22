package com.jowegele.webapp.repositories;

import com.jowegele.webapp.domain.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by JWG following JT Video#3   2017-11-22
 */

public interface ProductRepository extends CrudRepository<Product, Integer>{
}