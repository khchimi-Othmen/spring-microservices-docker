package tn.stb.msexchange_rate.controllers;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import tn.stb.msexchange_rate.config.ExchangeRateMessagingConfig;
import tn.stb.msexchange_rate.dto.ExchangeRate;
import tn.stb.msexchange_rate.entities.ExchangeRateEvent;

import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("/ExchangeRate")
public class ExchangePublisher {

    private final String API_URL = "https://openbank.stb.com.tn/api/trade/v-1/ExchangeRateByCode/EUR";

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private RestTemplate restTemplate; // Inject RestTemplate
    @PostMapping("/{Event}")
    public String publishExchangeRate(@PathVariable String Event) {
        ExchangeRateEvent exchangeRateEvent = new ExchangeRateEvent();
        exchangeRateEvent.setExchangeId(UUID.randomUUID().toString());
        exchangeRateEvent.setMessage("ExchangeRate placed successfully in " + Event);

        try {
            // Fetch exchange rates from the API
            ResponseEntity<tn.stb.msexchange_rate.dto.ExchangeRate[]> response = restTemplate.getForEntity(API_URL, tn.stb.msexchange_rate.dto.ExchangeRate[].class);
            tn.stb.msexchange_rate.dto.ExchangeRate[] rates = response.getBody();

            if (rates != null && rates.length > 0) {
                // Assuming the API response always contains the latest rate
                ExchangeRate latestRate = rates[0];

                // Replace comma with period and then parse as double
                String purchaseRateString = latestRate.getCustomer_PurchaseRate().replace(",", ".");
                String saleRateString = latestRate.getCustomer_SaleRate().replace(",", ".");

                exchangeRateEvent.setCustomerPurchaseRate(Double.parseDouble(purchaseRateString));
                exchangeRateEvent.setCustomerSaleRate(Double.parseDouble(saleRateString));
            } else {
                // Handle error when rates are not available
                return "error";
            }

            template.convertAndSend(ExchangeRateMessagingConfig.EX_RATE_EXCHANGE, ExchangeRateMessagingConfig.EX_RATE_ROUTING_KEY, exchangeRateEvent);
            return "success";
        } catch (Exception e) {
            // Handle exception by generating a message
            return "Exception occurred: " + e.getMessage();
        }
    }
}
