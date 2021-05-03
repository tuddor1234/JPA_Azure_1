package com.example.MainApp.Repositories;

import com.example.MainApp.Entities.Product;
import com.example.MainApp.Entities.Sellable;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends SellableRepository{

}
