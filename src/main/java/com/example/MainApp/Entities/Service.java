package com.example.MainApp.Entities;

import javax.persistence.Entity;

@Entity
public class Service extends  Sellable{

    private float maxDistance = -1;
    private float duration = -1;

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

    public Service(Service s)
    {
        super(s);
        this.maxDistance = s.maxDistance;
        this.duration = s.duration;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", currency='" + currency + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", maxDistance=" + maxDistance +
                ", duration=" + duration +
                '}';
    }
}
