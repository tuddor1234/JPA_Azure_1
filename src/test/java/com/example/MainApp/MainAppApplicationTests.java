package com.example.MainApp;

import com.example.MainApp.Entities.Business;
import com.example.MainApp.Entities.Product;
import com.example.MainApp.Entities.Sellable;
import com.example.MainApp.Entities.Service;
import com.example.MainApp.Repositories.BusinessRepository;
import com.example.MainApp.Repositories.ProductRepository;
import com.example.MainApp.Repositories.ServiceRepository;
import com.example.MainApp.Specs.BusinessSpecs;
import com.example.MainApp.Specs.ProductSpecs;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import org.hibernate.*;

import javax.annotation.Resource;
import javax.persistence.*;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.EntityType;
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

	@Resource
	ServiceRepository serviceRepository;

	@Autowired
	EntityManager em;

//	@Autowired
//	SessionFactory sessionFactory;

//	@BeforeAll
//	public void setup()
//	{
//
//	}


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
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Business> cq = cb.createQuery(Business.class);
		Root<Business> root = cq.from(Business.class);

		cq.select(root).where(cb.equal(root.get("location"),"Cluj"));


		var allBusinessesInCluj  = em.createQuery(cq).getResultList();
				// businessRepository.findAll(HasLocationInCluj());
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

	//@TODO FINISH THIS TEST, maybe ask
	@Test // Find All Businesses that sell products with X
	public void AllBusinessThatSellX()
	{
		// Step 1. Find all products that contain X

		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);

		//Root<Business> bRoot = criteriaQuery.from(Business.class);
		Root<Product> rootP = criteriaQuery.from(Product.class);

		var condition = criteriaBuilder.like(rootP.get("description"),"%aliaj metalic%");
		criteriaQuery.select(rootP).distinct(true).where(condition);

		var productsWithAM = em.createQuery(criteriaQuery).getResultList();




		productsWithAM.forEach(System.out::println);
		//System.out.println(productsWithAM.size());
		assert (productsWithAM.size() > 0);

		CriteriaQuery<Business> businessCriteriaQuery = criteriaBuilder.createQuery(Business.class);
		Root<Business> businessRoot = businessCriteriaQuery.from(Business.class);

//		var newCondition = criteriaBuilder.in();
//		businessCriteriaQuery.select(businessRoot).distinct(true).where(newCondition).in;


//		Join<Business, Product> answers = bRoot.join("sellables", JoinType.INNER);
//		CriteriaQuery<Product> cq = criteriaQuery.select(answers).where(condition);
//
//		var query = em.createQuery(cq).getResultList();


//		System.out.println("\n\n\n");
//		query.forEach(System.out::println);
//		System.out.println("\n\n\n");




//		assert(query.size() > 0);
	}

	@Test
	public void Second()
	{
		CriteriaBuilder cb = em.getCriteriaBuilder();
//		CriteriaQuery<Business> cq1 = cb.createQuery(Business.class);
//		Root<Business> broot = cq1.from(Business.class);
//
//		CriteriaQuery<Product> cq2 = cb.createQuery(Product.class);
//		Root<Product> proot = cq2.from(Product.class);
//
//		var join = broot.join(String.valueOf(proot.get("businessesthatsellme"))) ;
//
//		cq1.select(join.get("location"));
//		var all =em.createQuery(cq1).getResultList();
//		all.forEach(System.out::println);


		// PET = Business
		// Owner = Product

		CriteriaQuery<Business> cq = cb.createQuery(Business.class);
		CriteriaQuery<Product> cq5 = cb.createQuery(Product.class);

		Metamodel m = (Metamodel) em.getMetamodel();
		EntityType<Business> business = m.entity(Business.class);


		Root<Product> prod = cq5.from(Product.class);

//		Root<Business> pet = cq.from(Business.class);
//		var join = pet.join(prod.get("businessesthatsellme"));
//
//		cq.select(join.get("name"));
//		var all =em.createQuery(cq5).getResultList();
//		all.forEach(System.out::println);

		assert(true);
	}


	@Test
	public void ExtendTime()
	{
		// GET ALL SERVICES, IF THEY Happen in TM, extend by one hour

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery cq = cb.createQuery(Service.class);
		Root<Service> serviceRoot = cq.from(Service.class);

		CriteriaQuery businessQuery = cb.createQuery(Business.class);
		Root<Business> businessRoot = businessQuery.from(Business.class);

		cq.select(businessRoot.get("sellables")).distinct(true).where(cb.equal(businessRoot.get("location"),"Timisoara"));

		var businesses = em.createQuery(businessQuery).getResultList();
		businesses.forEach(System.out::println);

		//cq.select(serviceRoot).where();




//		var desiredServices = (List<Service>) em.createQuery(cq).getResultList();
//
//		for (var service : desiredServices)
//		{
//			var dur = service.getDuration();
//			dur += 60;
//			service.setDuration(dur);
//		}
//
//		serviceRepository.saveAll(desiredServices);
		assert(true);
	}


	@Test
	public void AddSellable()
	{
		em.getTransaction().begin();
		//Product p1 = new Product("product", "Some desc" , 123,"USD" , 20, "Unavailable");
		var b1 = ((Business) ((ArrayList) businessRepository.findAll()).get(0));
		var p1 = ((Product) ((ArrayList) productRepository.findAll()).get(0));

		System.out.println(b1.getName());
	//		b1.AddSellable(p1);
		businessRepository.save(b1);


		em.getTransaction().commit();
		em.close();

		assert( b1.getSellables().size() > 0);
	}
}
