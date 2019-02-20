package com.burahan.restingrabbit;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Rabbit
{
    private @Id @GeneratedValue Long id;
    private String name;
    private double weight;

    public Rabbit()
    {
        // default constructor
    }

    public Rabbit(String name, double weight)
    {
        this.name = name;
        this.weight = weight;
    }
}
