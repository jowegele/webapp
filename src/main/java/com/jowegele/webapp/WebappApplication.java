package com.jowegele.webapp;

import com.jowegele.webapp.domain.Product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.math.BigDecimal;

@SpringBootApplication
public class WebappApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(WebappApplication.class, args);

		EntityManagerFactory emf = ctx.getBean(EntityManagerFactory.class);
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Product product1 = new Product();
		product1.setDescription("Product 1");
		product1.setPrice(new BigDecimal("12.99"));

		em.merge(product1);

		Product product2 = new Product();
		product2.setDescription("Product 2");
		product2.setPrice(new BigDecimal("24.20"));

		em.merge(product2);

		Product product3 = new Product();
		product3.setDescription("Product 3");
		product3.setPrice(new BigDecimal("23.89"));

		em.merge(product3);

		em.getTransaction().commit();
	}
}
