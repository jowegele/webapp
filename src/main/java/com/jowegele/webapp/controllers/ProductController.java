package com.jowegele.webapp.controllers;

import com.jowegele.webapp.domain.Product;
import com.jowegele.webapp.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpServletRequest;

/**
 *  service-layer
 */

@Controller
public class ProductController{

    private ProductRepository repository;

    @Autowired
    public ProductController(ProductRepository repository){
        this.repository = repository; //constructor for the repository
    }

    @RequestMapping("/product/list")
    public String listProducts(Model model){
        model.addAttribute("products", repository.findAll());
        return "product/list";
    }
}