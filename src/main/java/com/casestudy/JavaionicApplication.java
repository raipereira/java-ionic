package com.casestudy;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.casestudy.model.Address;
import com.casestudy.model.Category;
import com.casestudy.model.City;
import com.casestudy.model.Client;
import com.casestudy.model.Ordeer;
import com.casestudy.model.OrderItem;
import com.casestudy.model.Payment;
import com.casestudy.model.PaymentSlip;
import com.casestudy.model.PaymentWithCard;
import com.casestudy.model.Product;
import com.casestudy.model.State;
import com.casestudy.model.enums.StatusPayment;
import com.casestudy.model.enums.TipeBusiness;
import com.casestudy.repositories.AddressRepository;
import com.casestudy.repositories.CategoryRepository;
import com.casestudy.repositories.CityRepository;
import com.casestudy.repositories.ClientRepository;
import com.casestudy.repositories.ItemRepository;
import com.casestudy.repositories.OrderRepository;
import com.casestudy.repositories.PaymentRepository;
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
	@Autowired
	ClientRepository clr;
	@Autowired
	AddressRepository addr;
	@Autowired
	OrderRepository or;
	@Autowired
	PaymentRepository payr;
	@Autowired
	ItemRepository ir;

	public static void main(String[] args) {
		SpringApplication.run(JavaionicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Category c1 = new Category(null, "Cell Phones & Accessories");
		Category c2 = new Category(null, "Clothing, Shoes & Jewelry");
		Category c3 = new Category(null, "Computers");
		Category c4 = new Category(null, "courses");
		Category c5 = new Category(null, "Digital Educational Resources");
		Category c6 = new Category(null, "Digital Music");
		Category c7 = new Category(null, "Eletronic");
		Category c8 = new Category(null, "Gift Cards");
		Category c9 = new Category(null, "Grocery & Gourmet Food");
		Category c10 = new Category(null, "Healh, Household & Baby Care");
		Category c11 = new Category(null, "Home Kitchen");
		Category c12 = new Category(null, "Industrial & Scientific");

		Product p1 = new Product(null, "Computer", 200.00);
		Product p2 = new Product(null, "Printer", 800.00);
		Product p3 = new Product(null, "produt3", 80.00);
		Product p4 = new Product(null, "produt4", 80.00);
		Product p5 = new Product(null, "produt5", 80.00);
		Product p6 = new Product(null, "produt6", 80.00);
		Product p7 = new Product(null, "produt7", 80.00);
		
		

		c1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		c2.getProducts().addAll(Arrays.asList(p2));
		c3.getProducts().addAll(Arrays.asList(p4));
		c4.getProducts().addAll(Arrays.asList(p5));
		c5.getProducts().addAll(Arrays.asList(p6));
		c6.getProducts().addAll(Arrays.asList(p7));
		c7.getProducts().addAll(Arrays.asList(p7));
		c8.getProducts().addAll(Arrays.asList(p7));

		p1.getCategories().addAll(Arrays.asList(c1));
		p2.getCategories().addAll(Arrays.asList(c1, c2));
		p3.getCategories().addAll(Arrays.asList(c1));
		p4.getCategories().addAll(Arrays.asList(c3));
		p5.getCategories().addAll(Arrays.asList(c4));
		p6.getCategories().addAll(Arrays.asList(c5));
		p7.getCategories().addAll(Arrays.asList(c6));
		p7.getCategories().addAll(Arrays.asList(c7));
		p7.getCategories().addAll(Arrays.asList(c8));

		cr.saveAll(Arrays.asList(c1, c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12));
		pr.saveAll(Arrays.asList(p1, p2, p3,p4,p5,p6,p7));

		State s1 = new State(null, "California");
		State s2 = new State(null, "Florida");

		City ct1 = new City(null, "San Diego", s1);
		City ct2 = new City(null, "Los Ageles", s1);
		City ct3 = new City(null, "Miami", s2);

		s1.getCities().addAll(Arrays.asList(ct1, ct2));
		s2.getCities().addAll(Arrays.asList(ct3));

		sr.saveAll(Arrays.asList(s1, s2));
		ctr.saveAll(Arrays.asList(ct1, ct2, ct3));

		Client cl1 = new Client(null, "Rai", "raigmail.com", "729729765", TipeBusiness.PRIVATEINDIVIDUAL);

		cl1.getPhonenumbers().addAll(Arrays.asList("673787654", "987342165"));

		Address ad1 = new Address(null, "Marten Ave", 1234, "house", 95148, cl1, ct1);
		Address ad2 = new Address(null, "segund st", 765, "apt 2", 84652, cl1, ct2);

		clr.save(cl1);
		addr.saveAll(Arrays.asList(ad1, ad2));
		
		
		Instant instant = Instant.parse( "2013-09-29T18:46:19Z");
		
		LocalDateTime ld = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
		
		LocalDateTime ld2 = LocalDateTime.of(2021, 5,5, 10, 20 );
		
		

		Ordeer order1 = new Ordeer(null, ld2, cl1, ad1);
		Ordeer order2 = new Ordeer(null, ld, cl1, ad2);

		Payment pay1 = new PaymentWithCard(null, StatusPayment.PAID, order1, 5);
		order1.setPyment(pay1);

		Payment pay2 = new PaymentSlip(null, StatusPayment.PENDING, order2, ld, null);
		order2.setPyment(pay2);

		cl1.getOrders().addAll(Arrays.asList(order1, order2));
		
		or.saveAll(Arrays.asList(order1,order2));
		payr.saveAll(Arrays.asList(pay1,pay2));
		
		OrderItem item1 = new OrderItem(order1, p1, 0.00, 1, 2000.00);
		OrderItem item2 = new OrderItem(order1, p1, 0.00, 2, 80.00);
		OrderItem item3 = new OrderItem(order2, p2, 100.00, 1, 800.00);
		
		order1.getItens().addAll(Arrays.asList(item1,item2));
		order2.getItens().addAll(Arrays.asList(item3));
		
		p1.getItens().addAll(Arrays.asList(item1));
		p2.getItens().addAll(Arrays.asList(item3));
		p3.getItens().addAll(Arrays.asList(item2));
		
		ir.saveAll(Arrays.asList(item1,item2,item3));
		

	}

}
