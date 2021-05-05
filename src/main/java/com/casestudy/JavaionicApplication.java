package com.casestudy;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.casestudy.model.Category;
import com.casestudy.repositories.CategoryRepository;

@SpringBootApplication
public class JavaionicApplication implements CommandLineRunner {
	
	@Autowired
	CategoryRepository cr;

	public static void main(String[] args) {
		SpringApplication.run(JavaionicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category c1 = new Category(null, "Informatics");
		Category c2 = new Category(null, "Office");
		
		cr.saveAll(Arrays.asList(c1,c2));
		
		
	}

}
