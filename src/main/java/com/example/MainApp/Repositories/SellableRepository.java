package com.example.MainApp.Repositories;

import com.example.MainApp.Entities.Sellable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellableRepository extends JpaRepository<Sellable, Long> {

}
