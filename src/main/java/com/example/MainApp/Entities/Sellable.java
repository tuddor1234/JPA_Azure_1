package com.example.MainApp.Entities;



import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Sellable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected UUID id;
    protected String name;
    protected String currency;
    protected float price;
    protected String description;


    @ManyToMany(mappedBy = "sellables")
    Set<Business> businessesThatSellMe = new HashSet<>();


    protected Sellable(){}

    public Sellable(String _name, String _description , float _price , String _currency)
    {
        this.name = _name;
        this.description = _description;
        this.price = _price;
        this.currency = _currency;
    }

    public void AddBusiness(Business business)
    {
        businessesThatSellMe.add(business);
    }

}
