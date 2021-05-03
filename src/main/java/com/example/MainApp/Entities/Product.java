package com.example.MainApp.Entities;

import javax.persistence.Entity;

@Entity
public class Product extends Sellable{

    float shippingArea = -1;
    String availability  = new String();

    private Product(){
        super();
    }


    public Product( String _name, String _desc , float _price, String _currency , float _shippingArea , String _availability){
        super(_name, _desc, _price, _currency );
        shippingArea = _shippingArea;
        availability = _availability;
    }


    public Product(Product p)
    {
        super(p);
        this.shippingArea = p.shippingArea;
        this.availability = p.availability;
    }



    @Override
    public String toString() {
        return "Product{" +
                "shippingArea=" + shippingArea +
                ", availability='" + availability + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", currency='" + currency + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
