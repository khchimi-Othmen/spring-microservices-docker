package tn.stb.mstransaction.publishers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TranscionPublisher {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private FanoutExchange trsExchange;

    public void publishAverageRate(double averageRate) {
        try {
            log.info("Publishing average rate: {}", averageRate);
            rabbitTemplate.convertAndSend(trsExchange.getName(), "", averageRate);
            log.info("Message successfully published to exchange: {}", trsExchange.getName());
        } catch (Exception e) {
            log.error("Error while publishing message: {}", e.getMessage(), e);
        }
    }
}
