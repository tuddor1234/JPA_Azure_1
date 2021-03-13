package com.example.MainApp.Entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Business")
@Data

@RequiredArgsConstructor
@ToString()

public class Business {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long ID;

    private final String name;

    protected Business(){
        name= "";
    }

//    //public Business(int id, String name)
//    {
//        this.name = name;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public String toString() {
//        return "Business{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                '}';
//    }
}