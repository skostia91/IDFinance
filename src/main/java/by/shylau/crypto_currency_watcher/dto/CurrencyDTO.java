package by.shylau.crypto_currency_watcher.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyDTO {

    private int id;
    private String symbol;
    private double price_usd;

    public double getPrice_usd() {
        return price_usd;
    }

    public int getId() {
        return id;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return "CurrencyDTO{" +
                "id=" + id +
                ", symbol='" + symbol + '\'' +
                ", price_usd=" + price_usd +
                '}';
    }
}