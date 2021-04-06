package com.example.MainApp.Repositories;

import com.example.MainApp.Entities.Business;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;


//public interface BusinessRepository extends JpaRepository<Business,Long> {
//}


public interface BusinessRepository extends CrudRepository<Business,Long>, JpaSpecificationExecutor<Business>{

//    List<Business> hasLocationIn(String location);

}