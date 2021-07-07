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
import java.util.Random;

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

	@Test
	public void HaveLocationInClujV2()
	{
		var allBusinessesInCluj = businessRepository.findAll(HasLocationInCluj());
		allBusinessesInCluj.forEach(System.out::println);
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
		allBusinessesInCluj.forEach(System.out::println);

 		assert(true);
	}

    @Test
	public void FindAllCurrenciesForProduct()
	{
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<String> cq = cb.createQuery(String.class);
		Root<Product> root = cq.from(Product.class);
		cq.select(root.get("currency")).distinct(true).where(cb.equal(root.get("name"),"Product1"));

		var results = em.createQuery(cq).getResultList();
		results.forEach(System.out::println);

		assert (true);
	}

 	@Test
	public void AllBusinessThatSellProduct1()
	{
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Business> criteriaQuery = criteriaBuilder.createQuery(Business.class);

		Root<Business> businessRoot = criteriaQuery.from(Business.class);
		Join<Business, Product> businesses_product = businessRoot.join("sellables",JoinType.INNER);

		var nameMatch = criteriaBuilder.equal(businesses_product.get("name"),"Product1");
		var descriptionMatch = criteriaBuilder.like(businesses_product.get("description"), "%aliaj metalic%");
		criteriaQuery.where(criteriaBuilder.and(nameMatch,descriptionMatch)).distinct(true);

		var list = em.createQuery((criteriaQuery)).getResultList();
		list.forEach(System.out::println);


		assert(true);
	}
//	@Test
//	void ClearTable()
//	{
//		//serviceRepository.deleteAll();
//
//		var all = serviceRepository.findAll();
//		all.forEach(System.out::println);
//	}

//	@Test
//	void PopulateTable()
//	{
////		Product p1 = new Product("Product1", "Something with aliaj metalic",
////				12, "EUR",12,"YES");
////		Product p2 = new Product("Product1", "Something else with aliaj metalic",
////				1512, "RON",12555,"YES");
////		Product p3 = new Product("Product2", "Something without aliaj metalic",
////				12, "EUR",12,"YES");
////		Product p4 = new Product("Product3", "just something",
////				12, "EUR",12,"YES");
////
////		productRepository.save(p1);
////		productRepository.save(p2);
////		productRepository.save(p3);
////		productRepository.save(p4);
////
//
//
//		var allBusiness = businessRepository.findAll();
//		var allProducts = productRepository.findAll();
//		var allServices = serviceRepository.findAll();
//
//		Random r = new Random();
//
//		for(var b : allBusiness)
//		{
//			 for(var p : allProducts)
//			 {
//			 	if(r.nextBoolean() == true)
//			 		b.AddSellable(p);
//			 }
//
//			 for(var s : allServices)
//				 if(r.nextBoolean() == true)
//					 b.AddSellable(s);
//
//		}
//
//		businessRepository.deleteAll();
//		businessRepository.saveAll(allBusiness);
//
//	}



	@Test
	void ExtendTimeV2()
	{

		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Service> criteriaQuery = criteriaBuilder.createQuery(Service.class);
		Root<Service> root = criteriaQuery.from(Service.class);

		Join<Service, Business> service_business = root.join("businessesthatsellme", JoinType.INNER);

		var matchLocation = criteriaBuilder.equal(service_business.get("location"),"Timisoara");
		criteriaQuery.where(matchLocation).distinct(true);

		var list = em.createQuery((criteriaQuery)).getResultList();
		list.forEach(System.out::println);

		for(var service :list) {
			var dur = service.getDuration() + 60;
			service.setDuration(dur);
		}

		serviceRepository.saveAll(list);
	}

	//Remove ProductX from the market and all the businesses that only sold Pro-ductX
	@Test
	void RemoveX()
	{
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Business> criteriaQuery = criteriaBuilder.createQuery(Business.class);

		Root<Business> businessRoot = criteriaQuery.from(Business.class);
		Join<Business, Product> businesses_product = businessRoot.join("sellables",JoinType.INNER);

		var nameMatch = criteriaBuilder.equal(businesses_product.get("name"),"Product1");
		criteriaQuery.where(nameMatch).distinct(true);

		var list = em.createQuery(criteriaQuery).getResultList();

		for(var b :list)
		{
			var sellables = b.getSellables();
			if(sellables.size() == 1 )
			{
				for( var x :sellables)
				{
					if(x.getName().equals("Product1"))
					{
						em.remove(b);
						break;
					}
				}
			}
		}


		CriteriaQuery<Product> q2 = criteriaBuilder.createQuery(Product.class);

		Root<Product> proot = q2.from(Product.class);

		var nameMatchAgain = criteriaBuilder.equal(proot.get("name"),"Product1");
		criteriaQuery.where(nameMatchAgain).distinct(true);

		var list2 = em.createQuery(q2).getResultList();
		for(var p : list2)
			em.remove(p);

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
