package com.example.MainApp;

import com.example.MainApp.Entities.Business;
import com.example.MainApp.Entities.Product;
import com.example.MainApp.Repositories.BusinessRepository;
import com.example.MainApp.Repositories.ProductRepository;
import com.example.MainApp.Repositories.ServiceRepository;
import com.example.MainApp.Specs.BusinessSpecs;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.test.context.junit4.SpringRunner;

import org.hibernate.*;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;

import static com.example.MainApp.Specs.BusinessSpecs.HasLocationInCluj;
import static org.springframework.data.jpa.domain.Specification.where;


@SpringBootTest
class MainAppApplicationTests {

	@Resource
	BusinessRepository businessRepository;


	@Test /** This is a test for tests, we will ignore it for now */
	public void findFirstBusinesses()
	{
		
		Business b1 = new Business("AnAwesomeBusiness","1234","Timisoara", "1234567" );
		businessRepository.save(b1);

		var first =((ArrayList<Business>) businessRepository.findAll()).get(0);

		assert(first.getName().equals("AnAwesomeBusiness"));
	}


	/** Easy tests */
	@Test  // FIND ALL BUSINESS IN CLUJ
	public void BusinessWithLocationInCluj()
	{
		var allBusinessesInCluj  = businessRepository.findAll(HasLocationInCluj());
		allBusinessesInCluj.forEach(System.out::println);

 		assert(allBusinessesInCluj.size() > 0);
	}




}
