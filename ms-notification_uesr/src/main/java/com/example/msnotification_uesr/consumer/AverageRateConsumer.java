package com.example.msnotification_uesr.consumer;


import com.example.msnotification_uesr.config.MessagingConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AverageRateConsumer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = MessagingConfig.SECOND_QUEUE)
    public void consumeMessageFromQueue(Double averageRate) {
        System.out.println("Message received from queue: " + averageRate);

        // Do something with the averageRate
    }
}
