package tn.stb.mstransaction.entities;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExchangeRateEventTransaction {

    @JsonProperty("ExchangeId")
    private String exchangeId;

    @JsonProperty("Customer_PurchaseRate")
    private double customerPurchaseRate;

    @JsonProperty("Customer_SaleRate")
    private double customerSaleRate;

    @JsonProperty("message")
    private String message;

}