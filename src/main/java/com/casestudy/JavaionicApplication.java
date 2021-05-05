package com.casestudy;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.casestudy.model.Category;
import com.casestudy.model.Product;
import com.casestudy.repositories.CategoryRepository;
import com.casestudy.repositories.ProductRepository;

@SpringBootApplication
public class JavaionicApplication implements CommandLineRunner {
	
	@Autowired
	CategoryRepository cr;
	
	@Autowired
	ProductRepository pr;

	public static void main(String[] args) {
		SpringApplication.run(JavaionicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category c1 = new Category(null, "Informatics");
		Category c2 = new Category(null, "Office");
		
		Product p1 = new Product(null, "Computer", 200.00);
		Product p2 = new Product(null, "Printer", 800.00);
		Product p3 = new Product(null, "Mouse", 80.00);
		
		c1.getProducts().addAll(Arrays.asList(p1,p2,p3));
		c2.getProducts().addAll(Arrays.asList(p2));
		
		p1.getCategories().addAll(Arrays.asList(c1));
		p2.getCategories().addAll(Arrays.asList(c1,c2));
		p3.getCategories().addAll(Arrays.asList(c1));
		
		cr.saveAll(Arrays.asList(c1,c2));
		pr.saveAll(Arrays.asList(p1,p2,p3));
		
		
		
	}

}
