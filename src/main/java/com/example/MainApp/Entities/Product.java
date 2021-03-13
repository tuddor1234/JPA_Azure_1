package com.example.MainApp.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
//@AllArgsConstructor
@NoArgsConstructor
public class Product  extends Sellable{

    private float price;

    public Product(long _ID, String _name, int _price){
        this.id = _ID;
        this.name = _name;
        this.price = _price;
    }
}
