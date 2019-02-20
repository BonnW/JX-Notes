package com.burahan.h2cruddy;

import com.burahan.h2cruddy.models.Customer;
import com.burahan.h2cruddy.models.Snack;
import com.burahan.h2cruddy.models.VendingMachine;
import com.burahan.h2cruddy.repository.CustomerRepository;
import com.burahan.h2cruddy.repository.SnackRepository;
import com.burahan.h2cruddy.repository.VendingMachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = {}, produces = MediaType.APPLICATION_JSON_VALUE)
public class SnackBarController
{
    @Autowired
    CustomerRepository custRepo;

    @Autowired
    SnackRepository snackRepo;

    @Autowired
    VendingMachineRepository vendorRepo;

    @GetMapping("/customer")
    public List<Customer> allcust()
    {
        return custRepo.findAll();
    }

    @GetMapping("/customer/{name}")
    public Customer findCustByName(@PathVariable String name)
    {
        return custRepo.findByName(name);
    }

    @GetMapping("/snack")
    public List<Snack> allsnacks()
    {
        return snackRepo.findAll();
    }

    @GetMapping("/snack/vending")
    public List<Object[]> vendingSnacks()
    {
        return snackRepo.vendingSnacks();
    }

    @GetMapping("/vending")
    public List<VendingMachine> allvending()
    {
        return vendorRepo.findAll();
    }

    @GetMapping("/vending/{name}")
    public List<VendingMachine> namedVending(@PathVariable String name)
    {
        return vendorRepo.findByName(name);
    }

}
