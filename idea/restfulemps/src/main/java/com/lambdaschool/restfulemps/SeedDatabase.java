package com.lambdaschool.restfulemps;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j // Lombok autocreates Slf4j-based logs
@Configuration  // Indicates that a class declares one or more @Beans
                // Bean - object, method controller by Spring. Contains java + metadata
public class SeedDatabase
{
    @Bean
    // CommandLineRunner - Spring Boot Runs all Beans at Startup
    public CommandLineRunner initDB(EmployeeRepository empRepo)
    {
        return args ->
        {
            log.info("Seeding " + empRepo.save(new Employee("Bonn", "W", true, 45000)));
            log.info("Seeding " + empRepo.save(new Employee("Bonn", "W", true, 45000)));
            log.info("Seeding " + empRepo.save(new Employee("Bonn", "W", true, 45000)));
        };
    }
}
