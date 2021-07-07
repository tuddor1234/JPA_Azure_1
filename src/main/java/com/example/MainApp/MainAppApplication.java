package com.example.MainApp;

import com.example.MainApp.Entities.Business;
import com.example.MainApp.Entities.Product;
import com.example.MainApp.Entities.Service;
import com.example.MainApp.Repositories.BusinessRepository;
import com.example.MainApp.Repositories.ProductRepository;
import com.example.MainApp.Repositories.SellableRepository;
import com.example.MainApp.Repositories.ServiceRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


@SpringBootApplication
public class MainAppApplication{

	public static void main(String[] args) {
		SpringApplication.run(MainAppApplication.class, args);
	}
}

@Component
class SqlServerDemo{

	@Autowired
	private  BusinessRepository businessRepository;
	@Autowired
	private  ProductRepository productRepository;
	@Autowired
	private  ServiceRepository serviceRepository;


	@Autowired
	EntityManager entityManager;

	@EventListener(ApplicationReadyEvent.class)
	public void ready()
	{
//		Service s1 = new Service("Service1", "Some description", 200 ,"USD", 20 , 120);
//		Service s2 = new Service("Service2", "No description", 1200 ,"RON", 120 , 20);
//		Service s3 = new Service("Service3", "Exchange ", 123 ,"EUR", 21 , 5);
//		Service s4 = new Service("Service5", "Software developement", 20000 ,"USD", -1 , 120);
//
//		serviceRepository.save(s1);
//		serviceRepository.save(s2);
//		serviceRepository.save(s3);
//		serviceRepository.save(s4);

//
//		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//		CriteriaQuery<Business> cq = cb.createQuery(Business.class);
//		Root<Business> root = cq.from(Business.class);
//
//		cq.select(root).where(cb.equal(root.get("location"),"Cluj"));
//
//
//		var allBusinessesInCluj  = entityManager.createQuery(cq).getResultList();
//		// businessRepository.findAll(HasLocationInCluj());
//		allBusinessesInCluj.forEach(System.out::println);


//		entityManager.getTransaction().commit();
//		entityManager.close();
//

//		var prod = productRepository.findAll();
//		boolean al = true;
//		for(Sellable p : prod)
//		{
//			if(al)
//			{
//				p.setDescription("Ceva cu altceva si aliaj metalic");
//				productRepository.save(p);
//			}
//			al = !al;
//
//		}


//		var business = businessRepository.findAll();
//		var products = productRepository.findAll();

//		Random random = new Random();
//
//		for(var b : business)
//		{
//			for(var p : products)
//			{
//				if(random.nextBoolean())
//				{
//					b.AddSellable(p);
//				}
//			}
//		}
//		businessRepository.saveAll(business);
//


//
//		Business b1 = new Business("Name","123","Cluj","123455");
//		Business b2 = new Business("Conti", "4125", "Timisoara", "15567");
//		Business b3 = new Business("GameLoft" , "152", "Cluj","15632" );
//
//		Business b4 = new Business("Hella","15267","Timisoara","2555");
//
//		businessRepository.save(b1);
//		businessRepository.save(b2);
//		businessRepository.save(b3);
//		businessRepository.save(b4);
//
//		businessRepository.findAll().forEach(System.out::println);
//
//
////
//
//		Product product1 = new Product("Produs1", 15);
//		Product product2 = new Product("Produs2", 80);
//		Product product3 = new Product("Produs3", 120);
//
//		productRepository.save(product1);
//		productRepository.save(product2);
//		productRepository.save(product3);
//
//		Service service1 = new Service("Service1",10);
//		Service service2 = new Service("Service2",1000);
//		Service service3 = new Service("Service3",15);
//
//
//		serviceRepository.save(service1);
//		serviceRepository.save(service2);
//		serviceRepository.save(service3);
//
//
//		b1.AddSellable(product1);
//		b1.AddSellable(product2);
//		b1.AddSellable(service3);
//		businessRepository.save(b1);
//

//		var b1 = ((Business) ((ArrayList) businessRepository.findAll()).get(0));
//		var p1 = ((Product) ((ArrayList) productRepository.findAll()).get(0));
//
//		System.out.println(b1.getName());
//		b1.AddSellable(p1);
//		businessRepository.save(b1);







	}



//	public List<Business> FindAllBusiness()
//	{
//		return businessRepository.findAll();
//	}






}
