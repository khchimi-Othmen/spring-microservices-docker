package tn.stb.msexchange_rate.controllers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExchangeRate {
    @JsonProperty("Customer_PurchaseRate")
    private String customer_PurchaseRate;

    @JsonProperty("Customer_SaleRate")
    private String customer_SaleRate;


}
