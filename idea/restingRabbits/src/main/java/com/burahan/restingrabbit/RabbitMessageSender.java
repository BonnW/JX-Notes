package com.burahan.restingrabbit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;
import java.util.Random;

@Slf4j
// @Service
public class RabbitMessageSender
{
    private final RabbitTemplate rt;
    private final RabbitRepository rabbitRepo;

    public RabbitMessageSender(RabbitTemplate rt, RabbitRepository rabbitRepo)
    {
        this.rt = rt;
        this.rabbitRepo = rabbitRepo;
    }

    @Scheduled(fixedDelay = 3000L)
    public void sendMessage()
    {
        var rabbits = new ArrayList<Rabbit>(); // Only works with Java 11
        // ArrayList<Rabbit> rabbits = new ArrayList<Rabbit>();

        rabbits.addAll(rabbitRepo.findAll());

        for (Rabbit r : rabbits)
        {
            int rand = new Random().nextInt(10);
            boolean randBool = new Random().nextBoolean();
            final RabbitMessage message = new RabbitMessage(r.toString(), rand, randBool);
            if (rand <= 5)
            {
                log.info("Sending Message HIGH");
                rt.convertAndSend(RestingrabbitApplication.QUEUE_NAME_HIGH, message);
            }
            else
            {
                log.info("Sending Message LOW");
                rt.convertAndSend(RestingrabbitApplication.QUEUE_NAME_LOW, message);
            }
        }
    }
}
