package com.example.MainApp.Entities;

import javax.persistence.Entity;

@Entity
public class Service extends  Sellable{

    private float maxDistance;
    private float duration;

    private Service()
    {
        super();
    }


    public Service( String _name, String _desc , float _price, String _currency , float _maxDistance, float _duration)
    {
        super(_name, _desc, _price, _currency );
        this.maxDistance = _maxDistance;
        this.duration = _duration;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", availableDistance=" + maxDistance +
                '}';
    }
}
