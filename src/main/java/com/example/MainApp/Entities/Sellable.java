package com.example.MainApp.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass

@Data
@AllArgsConstructor
@NoArgsConstructor
public  class Sellable {

    @Id
    protected Long id;
    protected String name;

}
