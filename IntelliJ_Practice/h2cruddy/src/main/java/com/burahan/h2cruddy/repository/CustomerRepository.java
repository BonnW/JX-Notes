package com.burahan.h2cruddy.repository;

import com.burahan.h2cruddy.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long>
{
    public Customer findByName(String name);
}
