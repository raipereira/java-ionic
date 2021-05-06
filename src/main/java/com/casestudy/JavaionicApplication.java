package com.casestudy;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.casestudy.model.Category;
import com.casestudy.model.City;
import com.casestudy.model.Product;
import com.casestudy.model.State;
import com.casestudy.repositories.CategoryRepository;
import com.casestudy.repositories.CityRepository;
import com.casestudy.repositories.ProductRepository;
import com.casestudy.repositories.StateRepository;

@SpringBootApplication
public class JavaionicApplication implements CommandLineRunner {
	
	@Autowired
	CategoryRepository cr;
	
	@Autowired
	ProductRepository pr;
	
	@Autowired
	CityRepository ctr;
	
	@Autowired
	StateRepository sr;

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
		
		State s1 = new State(null, "California");
		State s2 = new State(null, "Florida");
		
		City ct1 = new City(null, "San Diego", s1);
		City ct2 = new City(null, "Los Ageles", s1);
		City ct3 = new City(null, "Miami", s2);
		
		s1.getCities().addAll(Arrays.asList(ct1,ct2));
		s2.getCities().addAll(Arrays.asList(ct3));
		
		sr.saveAll(Arrays.asList(s1,s2));
		ctr.saveAll(Arrays.asList(ct1,ct2,ct3));
		
		
		
	}

}
