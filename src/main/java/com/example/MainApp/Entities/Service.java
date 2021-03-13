package com.example.MainApp.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Service extends  Sellable{
    private float availableDistance;
}
