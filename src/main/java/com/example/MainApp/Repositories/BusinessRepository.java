package com.example.MainApp.Repositories;

import com.example.MainApp.Entities.Business;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BusinessRepository extends JpaRepository<Business,Long> {
}
