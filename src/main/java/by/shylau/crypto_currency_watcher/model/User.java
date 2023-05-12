package by.shylau.crypto_currency_watcher.model;

import java.util.Objects;

public class User {
    private String username;
    private String symbol;
    private double priceUsd;

    public User() {
    }

    public User(String username, String symbol, double priceUsd) {
        this.username = username;
        this.symbol = symbol;
        this.priceUsd = priceUsd;
    }

    public String getUsername() {
        return username;
    }

    public double getPriceUsd() {
        return priceUsd;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(symbol, user.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", symbol='" + symbol + '\'' +
                ", priceUsd=" + priceUsd +
                '}';
    }
}
