package com.jowegele.webapp.controllers;

import com.jowegele.webapp.domain.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpServletRequest;

/**
 *
 */

@Controller
public class ProductController{

    @RequestMapping("/product/list")
    public String listProducts(Model model, HttpServletRequest request){

        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
        EntityManagerFactory emf = ctx.getBean(EntityManagerFactory.class);
        EntityManager em = emf.createEntityManager();
        model.addAttribute("products", em.createQuery("from Product", Product.class).getResultList());
        return "product/list";
    }
}