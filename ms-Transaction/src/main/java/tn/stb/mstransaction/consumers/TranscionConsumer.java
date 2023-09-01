package tn.stb.mstransaction.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tn.stb.mstransaction.entities.ExchangeRateEventTransaction;
import tn.stb.mstransaction.publishers.TranscionPublisher;

import static tn.stb.mstransaction.config.MessagingConfig.QUEUE;
@Component
public class TranscionConsumer {

    @Autowired
    private TranscionPublisher transcionPublisher;

    @RabbitListener(queues = QUEUE)
    public void consumeMessageFromQueue(ExchangeRateEventTransaction exchangeRateEventTransaction) {
        System.out.println("Message received from queue: " + exchangeRateEventTransaction);

        // Extract the rates from the received message
        double customerPurchaseRate = exchangeRateEventTransaction.getCustomerPurchaseRate();
        double customerSaleRate = exchangeRateEventTransaction.getCustomerSaleRate();

        // Calculate the average of the rates
        double averageRate = (customerPurchaseRate + customerSaleRate) / 2;
        System.out.println("Message send to third ms: " + averageRate);

        // Publish the averageRate to the third microservice using the RabbitTemplate
        try {
            transcionPublisher.publishAverageRate(averageRate);
        } catch (Exception e) {
            System.out.println("Error publishing average rate: " + e.getMessage());
        }    }
}
