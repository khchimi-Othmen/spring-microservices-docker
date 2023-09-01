package tn.stb.mstransaction_log.consumer;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import static tn.stb.mstransaction_log.config.MessagingConfig.TRS_QUEUE_2;


@Component
public class AverageRateConsumer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = TRS_QUEUE_2)
    public void consumeMessageFromQueue(Double averageRate) {
        System.out.println("Message received from queue: " + averageRate);

        // Do something with the averageRate
    }
}
