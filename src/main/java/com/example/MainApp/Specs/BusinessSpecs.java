package com.example.MainApp.Specs;

import com.example.MainApp.Entities.Business;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class BusinessSpecs /* implements Specification<Business>*/ {

    private static Business business;

    public static Specification<Business> HasLocationInCluj()
    {
        return new Specification<Business>() {
            @Override
            public Predicate toPredicate(Root<Business> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("location"),"Cluj");
            }
        };
    }


//    public Predicate toPredicate( Root<Business> businessRoot , CritiaQu)
//
//    public static Specification<Business> HasLocationInCluj()
//    {
//        return ((root, query, criteriaBuilder) -> {
//
//            return criteriaBuilder
//
//
//           root.get(Business)
//
//
//        });
//    }
//
//    @Override
//    public javax.persistence.criteria.Predicate toPredicate(Root<Business> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
//
//        return criteriaBuilder.equal(root.get(business.getLocation()),"Cluj");
//    }
}


