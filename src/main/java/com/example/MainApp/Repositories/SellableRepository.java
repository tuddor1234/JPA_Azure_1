package com.example.MainApp.Repositories;

import com.example.MainApp.Entities.Sellable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface SellableRepository extends JpaRepository<Sellable, Long> {

}
