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
    protected String name = new String();
    protected String currency = new String();
    protected float price = -1;
    protected String description = new String();



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @ManyToMany(mappedBy = "sellables")
    Set<Business> businessesThatSellMe = new HashSet<>();


    protected Sellable(){}

    protected Sellable(String _name, String _description , float _price , String _currency)
    {
        this.name = _name;
        this.description = _description;
        this.price = _price;
        this.currency = _currency;
    }

    protected Sellable(Sellable sellable)
    {
        this.name = sellable.name;
        this.description = sellable.description;
        this.price = sellable.price;
        this.currency = sellable.currency;
    }


    public void AddBusiness(Business business)
    {
        businessesThatSellMe.add(business);
    }

    @Override
    public String toString() {
        return "Sellable{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", currency='" + currency + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", businessesThatSellMe=" + businessesThatSellMe +
                '}';
    }
}
