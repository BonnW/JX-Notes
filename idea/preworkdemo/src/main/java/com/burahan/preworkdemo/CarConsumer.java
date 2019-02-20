package com.burahan.preworkdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CarConsumer
{
    @RabbitListener(queues = PreworkdemoApplication.QUEUE_NAME)
    public void consumeMessage(final Message cm)
    {
        log.info("Received Message: ", cm.toString());
    }
}
