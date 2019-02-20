package com.lambdaschool.restfulemps;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
public class EmployeeController
{
    private final EmployeeRepository empRepo;
    private final EmployeeResourceAssembler assembler;

    public EmployeeController(EmployeeRepository empRepo, EmployeeResourceAssembler assembler)
    {
        this.empRepo = empRepo;
        this.assembler = assembler;
    }

    // Post -> Create
    // Get -> Read
    // Put -> Update/Replace
    // Patch -> Update/Modify
    // Delete -> Delete

    // RequestMapping(method = RequestMethod.GET)
    @GetMapping("/employee")
    public Resources<Resource<Employee>> all()
    {
        List<Resource<Employee>> employees = empRepo.findAll().stream()
                .map(assembler::toResource)
                .collect(Collectors.toList());

        return new Resources<>(employees, linkTo(methodOn(EmployeeController.class).all()).withSelfRel());
    }

    @GetMapping("/employees/{id}")
    public Resource<Employee> findOne(@PathVariable Long id)
    {
        Employee foundEmp = empRepo.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));

        return assembler.toResource(foundEmp);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<?> replaceEmployee(@RequestBody Employee newEmp, @PathVariable Long id)
        throws URISyntaxException
    {
        Employee updatedEmployee = empRepo.findById(id)
                .map(employee ->
                {
                    employee.setFname(newEmp.getFname());
                    employee.setLname(newEmp.getFname());
                    employee.setSalary(newEmp.getSalary());
                    employee.setHas401k(newEmp.isHas401k());
                    return empRepo.save(employee);
                })
                .orElseGet(() ->
                {
                    newEmp.setId(id);
                    return empRepo.save(newEmp);
                });
        Resource<Employee> resource = assembler.toResource(updatedEmployee);

        return ResponseEntity
                .created(new URI(resource.getId().expand().getHref()))
                .body(resource);
    }

//    @PostMapping("/newemployee")
//    {
//
//    }
}
