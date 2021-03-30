package com.example.MainApp.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity

public class Product extends Sellable{

    private float price;




    public Product( String _name, int _price){
        super(_name);
        this.price = _price;
    }
}
