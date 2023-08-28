package tn.stb.msexchange_rate.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import tn.stb.msexchange_rate.controllers.ExchangePublisher;

@Component
public class ExchangeRateScheduler {

    @Autowired
    private ExchangePublisher exchangePublisher;

    @Scheduled(fixedRate = 60000)
    public void publishExchangeRate() {
        exchangePublisher.publishExchangeRate("EVENT");
    }
}
