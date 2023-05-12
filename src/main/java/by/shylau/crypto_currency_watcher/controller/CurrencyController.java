package by.shylau.crypto_currency_watcher.controller;

import by.shylau.crypto_currency_watcher.model.User;
import by.shylau.crypto_currency_watcher.service.CurrencyService;
import by.shylau.crypto_currency_watcher.model.Currency;
import by.shylau.crypto_currency_watcher.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static by.shylau.crypto_currency_watcher.util.Constants.*;

@RestController
@RequestMapping("/V1")
public class CurrencyController {
    private final static Logger logger = LoggerFactory.getLogger(Util.class);

    private final CurrencyService currencyService;
    public static User user = new User("", "", 0.0);

    @Autowired
    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/show")
    public List<Currency> showAllCurrency() {
        return Util.getActualCurrency(currencyService.showAllCurrency());
    }

    @GetMapping("/{symbol}")
    public String getPriceByIdCurrency(@PathVariable("symbol") String symbol) {
        String message = null;
        Currency currency = null;

        List<Currency> list = Util.getActualCurrency(currencyService.showAllCurrency());
        for (Currency item : list) {
            if (symbol.equals(item.getSymbol())) {
                currency = item;
                message = item.getSymbol() + " price_usd coin = " + item.getPrice_usd();
            }
        }
        if (currency == null) {
            message = CANT_FIND_BY_SYMBOL + " " + symbol;
        }
        return message;
    }

    @GetMapping("/name/{name}/{symbol}")
    public String notify(@PathVariable("name") String name,
                                 @PathVariable("symbol") String symbol) {
        double priceTiedUser = 0.0;
        String message = CANT_FIND_BY_SYMBOL;

        List<Currency> list = Util.getActualCurrency(currencyService.showAllCurrency());
        for (Currency item : list) {
            if (symbol.equals(item.getSymbol())) {
                priceTiedUser = item.getPrice_usd();
                message = SUCCESS + name;
            }
        }
        user = new User(name, symbol, priceTiedUser);
        logger.info(SUCCESS + user);

        return message;
    }
}