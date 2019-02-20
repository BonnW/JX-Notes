package com.burahan.restingrabbit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Random;

@Slf4j
@RestController
public class RabbitController
{
    private final RabbitRepository rabbitRepo;
    private final RabbitTemplate rt;

    public RabbitController(RabbitRepository rabbitRepo, RabbitTemplate rt)
    {
        this.rabbitRepo = rabbitRepo;
        this.rt = rt;
    }

    @GetMapping("/rabbits")

    public void findSome()
    {
        ArrayList<Rabbit> rabbits = new ArrayList<Rabbit>();
        rabbits.addAll(rabbitRepo.findAll());

        for (Rabbit r : rabbits)
        {
            int rand = new Random().nextInt(10);
            boolean randBool = new Random().nextBoolean();
            final RabbitMessage message = new RabbitMessage(r.toString(), rand, randBool);

            log.info("Sending Message... ");
            if (rand <= 5)
            {
                rt.convertAndSend(RestingrabbitApplication.QUEUE_NAME_HIGH, message);
            }
            else
            {
                rt.convertAndSend(RestingrabbitApplication.QUEUE_NAME_LOW, message);
            }
        }
    }

}
