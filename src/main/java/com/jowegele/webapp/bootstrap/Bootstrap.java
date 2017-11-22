package com.jowegele.webapp.bootstrap;

import com.jowegele.webapp.controllers.ProductController;
import com.jowegele.webapp.domain.Product;
import com.jowegele.webapp.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.ProblemReporter;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.math.BigDecimal;

/**
 * JWG 2017-11-22
 * a type we are implementing, and spring is going to look at it and when we get a "content refreshing event" this method is going to get called
 * when spring starts up
 * quick way to start up events and load the database
 */

@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent>{

    private ProductRepository repository;

    @Autowired
    public Bootstrap(ProductRepository repository){
        this.repository = repository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        Product product1 = new Product();
        product1.setDescription("Product 1");
        product1.setPrice(new BigDecimal("12.99"));

        repository.save(product1);

        Product product2 = new Product();
        product2.setDescription("Product 2");
        product2.setPrice(new BigDecimal("24.20"));

        repository.save(product2);

        Product product3 = new Product();
        product3.setDescription("Product 3");
        product3.setPrice(new BigDecimal("23.89"));

        repository.save(product3);
    }
}
