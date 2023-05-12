package by.shylau.crypto_currency_watcher.util;

import by.shylau.crypto_currency_watcher.controller.CurrencyController;
import by.shylau.crypto_currency_watcher.dto.CurrencyDTO;
import by.shylau.crypto_currency_watcher.model.Currency;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static by.shylau.crypto_currency_watcher.util.Constants.*;

public class Util {
    private final static Logger logger = LoggerFactory.getLogger(Util.class);

    public static List<Currency> getActualCurrency(List<Currency> list) {
        List<Currency> listShow = new ArrayList<>();
        for (int i = list.size() - VALUE_FOR_LOGIC; i > list.size() - VALUE_FOR_SHOW_COIN; i--) {
            listShow.add(list.get(i));
        }
        return listShow;
    }

    public static void checkCurrency(CurrencyDTO currency) {
        double priceUsdUser = CurrencyController.user.getPriceUsd();
        double max = priceUsdUser + priceUsdUser/100;
        double min = priceUsdUser - priceUsdUser/100;

        if (currency.getSymbol().equals(CurrencyController.user.getSymbol())) {
            if (currency.getPrice_usd() > max || currency.getPrice_usd() < min) {
                logger.warn(LOG_CHANGE + currency.getSymbol() + ";" +
                        CurrencyController.user.getUsername() + ";" +
                        findChangePrice(priceUsdUser, currency.getPrice_usd()));
            }
        }
    }

    private static Double findChangePrice(double price, double changePrice) {
        return Math.abs(1 - changePrice/price) * 100;
    }
}