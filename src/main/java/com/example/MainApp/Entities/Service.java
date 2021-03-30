package com.example.MainApp.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;

@Entity
//@Data
//@RequiredArgsConstructor
//@NoArgsConstructor
public class Service extends  Sellable{
    private  float availableDistance;

    public Service(String _name, float _availableDistance)
    {
        super(_name);
        this.availableDistance = _availableDistance;
    }
}
