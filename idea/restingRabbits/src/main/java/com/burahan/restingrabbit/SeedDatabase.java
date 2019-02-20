package com.burahan.restingrabbit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class SeedDatabase
{
    @Bean
    public CommandLineRunner inttDB(RabbitRepository rabbitrepo)
    {
        return args ->
        {
            log.info("Seeding " + rabbitrepo.save(new Rabbit("Barn Barn", 5.1)));
            log.info("Seeding " + rabbitrepo.save(new Rabbit("Cinnamon", 4.3)));
            log.info("Seeding " + rabbitrepo.save(new Rabbit("fluffy", 4.7)));
        };
    }
}
