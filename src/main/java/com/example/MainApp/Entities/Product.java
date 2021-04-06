package com.example.MainApp.Entities;

import javax.persistence.Entity;

@Entity
public class Product extends Sellable{

    float shippingArea;
    String availability;

    private Product(){
        super();
    }


    public Product( String _name, String _desc , float _price, String _currency , float _shippingArea , String _availability){
        super(_name, _desc, _price, _currency );
        shippingArea = _shippingArea;
        availability = _availability;
    }
}
