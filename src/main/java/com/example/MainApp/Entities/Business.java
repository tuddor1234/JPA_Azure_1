package com.example.MainApp.Entities;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Business")
public class Business {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private UUID ID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCIF() {
        return CIF;
    }

    public void setCIF(String CIF) {
        this.CIF = CIF;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRegistrationNumber() {
        return RegistrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        RegistrationNumber = registrationNumber;
    }

    public Set<Sellable> getSellables() {
        return sellables;
    }

    public void setSellables(Set<Sellable> sellables) {
        this.sellables = sellables;
    }

    private String name;
    private String CIF;
    private String location;
    private String RegistrationNumber;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "business_sellable",
    joinColumns =  @JoinColumn(name = "business_id"))
    Set<Sellable> sellables = new HashSet<>();


    public Business(){}

    public Business(String name, String CIF, String location, String registrationNumber) {
        this.name = name;
        this.CIF = CIF;
        this.location = location;
        RegistrationNumber = registrationNumber;
    }

    public void AddSellable(Sellable sellable)
    {
        sellables.add(sellable);
        sellable.AddBusiness(this);
    }


    @Override
    public String toString() {
        return "Business{" +
                "id=" + ID +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", CIF" + CIF + '\'' +
                ", Registration Number='" + RegistrationNumber +
                "\'}";
    }


}