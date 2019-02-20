package com.burahan.restingrabbit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RabbitMessageListener
{
    @RabbitListener(queues = RestingrabbitApplication.QUEUE_NAME_HIGH)
    public void receiveMessage(RabbitMessage message)
    {
        log.info("Received Message: {} ", message.toString());
    }
}
