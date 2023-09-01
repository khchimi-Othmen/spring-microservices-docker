package tn.stb.msexchange_rate.controllers;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.stb.msexchange_rate.config.MessagingConfig;
import tn.stb.msexchange_rate.entities.ExchangeRateEvent;

import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("/ExchangeRate")
public class ExchangePublisher {

    @Autowired
    private RabbitTemplate template;

    @PostMapping("/{Event}")
    public String publishExchangeRate(@PathVariable String Event) {
        ExchangeRateEvent exchangeRateEvent = new ExchangeRateEvent();
        exchangeRateEvent.setExchangeId(UUID.randomUUID().toString());
        exchangeRateEvent.setMessage("ExchangeRate placed successfully in " + Event);

        // Generate random values for Customer_PurchaseRate and Customer_SaleRate
        double randomPurchaseRate = generateRandomRate();
        double randomSaleRate = generateRandomRate();

        exchangeRateEvent.setCustomerPurchaseRate(randomPurchaseRate);
        exchangeRateEvent.setCustomerSaleRate(randomSaleRate);

        // Add a delay of 1 second
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, exchangeRateEvent);
        return "Success 2 !!";
    }

    private double generateRandomRate() {
        double minRate = 3.2;
        double maxRate = 3.4;
        return minRate + (new Random().nextDouble() * (maxRate - minRate));
    }
}
