package tn.stb.mstransaction.publishers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import static tn.stb.mstransaction.config.MessagingConfig.SECOND_EXCHANGE;
import static tn.stb.mstransaction.config.MessagingConfig.SECOND_ROUTING_KEY;

@Component
public class TranscionPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void publishAverageRate(double averageRate) {
        rabbitTemplate.convertAndSend(SECOND_EXCHANGE, SECOND_ROUTING_KEY, averageRate);
    }
}
