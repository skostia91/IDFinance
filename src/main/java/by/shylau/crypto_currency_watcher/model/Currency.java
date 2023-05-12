package by.shylau.crypto_currency_watcher.model;

import javax.persistence.*;

import java.util.Objects;

import static by.shylau.crypto_currency_watcher.util.Constants.*;

@Entity
@Table(name = TABLE_NAME)
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_ID)
    private int idIntoDB;

    @Column(name = COLUMN_ID_CURRENCY)
    private int idCurrency;

    @Column(name = COLUMN_SYMBOL)
    private String symbol;

    @Column(name = COLUMN_PRICE_USD)
    private double price_usd;

    public Currency() {
    }

    public Currency(int idCurrency, String symbol, double price_usd) {
        this.idCurrency = idCurrency;
        this.symbol = symbol;
        this.price_usd = price_usd;
    }

    public int getIdIntoDB() {
        return idIntoDB;
    }

    public void setIdIntoDB(int idIntoDB) {
        this.idIntoDB = idIntoDB;
    }

    public int getIdCurrency() {
        return idCurrency;
    }

    public void setIdCurrency(int idCurrency) {
        this.idCurrency = idCurrency;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getPrice_usd() {
        return price_usd;
    }

    public void setPrice_usd(double price_usd) {
        this.price_usd = price_usd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
        return idIntoDB == currency.idIntoDB &&
                idCurrency == currency.idCurrency &&
                Double.compare(currency.price_usd, price_usd) == 0 &&
                Objects.equals(symbol, currency.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idIntoDB, idCurrency, symbol, price_usd);
    }

    @Override
    public String toString() {
        return
                "Currency{" + "idIntoDB=" + idIntoDB +
                ", idCurrency=" + idCurrency +
                ", symbol='" + symbol + '\'' +
                ", price_usd=" + price_usd +
                '}';
    }
}