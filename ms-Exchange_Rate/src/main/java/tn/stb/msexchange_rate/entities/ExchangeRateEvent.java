package tn.stb.msexchange_rate.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExchangeRateEvent {

    @JsonProperty("ExchangeId")
    private String exchangeId;

    @JsonProperty("Customer_PurchaseRate")
    private double customerPurchaseRate = 3.2; // Default value

    @JsonProperty("Customer_SaleRate")
    private double customerSaleRate = 3.25; // Default value

    @JsonProperty("message")
    private String message;

}
