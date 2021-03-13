package com.example.MainApp;

import com.example.MainApp.Entities.Business;
import com.example.MainApp.Entities.Product;
import com.example.MainApp.Entities.Sellable;
import com.example.MainApp.Repositories.BusinessRepository;
import com.example.MainApp.Repositories.SellableRepository;
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

	private final SellableRepository sellableRepository;

	@EventListener(ApplicationReadyEvent.class)
	public void ready()
	{

		Business b1 = new Business("Name");
		Business b2 = new Business("Conti");
		Business b3 = new Business("Nokia");

		Business b4 = new Business("Hella");

		businessRepository.save(b1);
		businessRepository.save(b2);
		businessRepository.save(b3);
		businessRepository.save(b4);

		businessRepository.findAll().forEach(System.out::println);

//
//		Product product = new Product(0,"Produs", 12);
//
//		sellableRepository.save(product);
//
//		sellableRepository.findAll().forEach(System.out::println);
	}
}
