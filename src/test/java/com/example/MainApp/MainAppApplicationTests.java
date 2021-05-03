package com.example.MainApp;

import com.example.MainApp.Entities.Business;
import com.example.MainApp.Entities.Product;
import com.example.MainApp.Entities.Sellable;
import com.example.MainApp.Repositories.BusinessRepository;
import com.example.MainApp.Repositories.ProductRepository;
import com.example.MainApp.Repositories.ServiceRepository;
import com.example.MainApp.Specs.BusinessSpecs;
import com.example.MainApp.Specs.ProductSpecs;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.test.context.junit4.SpringRunner;

import org.hibernate.*;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.MainApp.Specs.BusinessSpecs.HasLocationInCluj;
import static org.springframework.data.jpa.domain.Specification.where;


@SpringBootTest
class MainAppApplicationTests {

	@Resource
	BusinessRepository businessRepository;

	@Resource
	ProductRepository productRepository;

	@Autowired
	EntityManager em;

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

    @Test
	public void FindAllCurrenciesForProduct()
	{
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<String> cq = cb.createQuery(String.class);
		Root<Product> root = cq.from(Product.class);
		cq.select(root.get("currency")).distinct(true).where(cb.equal(root.get("name"),"Produs1"));

		var results = em.createQuery(cq).getResultList();
		results.forEach(System.out::println);

		assert (results.size() > 0);
	}

	@Test
	public void AllBusinessThatSellX()
	{
		CriteriaBuilder cb = em.getCriteriaBuilder();


		CriteriaQuery<Product> cqp = cb.createQuery(Product.class);
		Root<Product> rootP = cqp.from(Product.class);
//
//		var conditions = cb.and( cb.equal(rootP.get("name"), "Produs1")
//										,cb.like(rootP.get("description"),"aliaj metalic") );

		var conditions = cb.equal(rootP.get("name"), "Produs1");
		cqp.select(rootP).where(conditions);

		var outcome = em.createQuery(cqp).getResultList();
		//outcome.forEach(System.out::println);

		assert(outcome.size() > 0);
	}


}
