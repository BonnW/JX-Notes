package com.burahan.h2cruddy.models;

import javax.persistence.*;

@Entity
@Table(name="customer")
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (nullable = false)
    private String name;

    private double cashOnHand;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getCashOnHand()
    {
        return cashOnHand;
    }

    public void setCashOnHand(double cashOnHand)
    {
        this.cashOnHand = cashOnHand;
    }
}
