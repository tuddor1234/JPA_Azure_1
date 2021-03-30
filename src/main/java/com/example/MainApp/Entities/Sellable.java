package com.example.MainApp.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;


//@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Sellable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    protected String name;

    public Sellable(String _name)
    {
        this.name = _name;
    }

}
