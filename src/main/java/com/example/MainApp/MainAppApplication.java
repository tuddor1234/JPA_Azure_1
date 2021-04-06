package com.example.MainApp;

import com.example.MainApp.Entities.Business;
import com.example.MainApp.Entities.Product;
import com.example.MainApp.Entities.Sellable;
import com.example.MainApp.Entities.Service;
import com.example.MainApp.Repositories.BusinessRepository;
import com.example.MainApp.Repositories.ProductRepository;
import com.example.MainApp.Repositories.SellableRepository;
import com.example.MainApp.Repositories.ServiceRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.rowset.serial.SerialJavaObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
public class MainAppApplication{

	public static void main(String[] args) {
		SpringApplication.run(MainAppApplication.class, args);
	}
}



@Component
@RequiredArgsConstructor
class SqlServerDemo{


	private  final BusinessRepository businessRepository;

	private final ProductRepository productRepository;

	private final ServiceRepository serviceRepository;


	@PersistenceContext
	EntityManager entityManager;

	@EventListener(ApplicationReadyEvent.class)
	public void ready()
	{
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
	}



//	public List<Business> FindAllBusiness()
//	{
//		return businessRepository.findAll();
//	}




}
