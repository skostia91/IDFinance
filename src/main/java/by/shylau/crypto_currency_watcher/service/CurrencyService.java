package by.shylau.crypto_currency_watcher.service;

import by.shylau.crypto_currency_watcher.model.Currency;
import by.shylau.crypto_currency_watcher.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {
    private final CurrencyRepository currencyRepository;

    @Autowired
    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    public List<Currency> showAllCurrency() {
        return currencyRepository.findAll();
    }

    public void save(Currency currency) {
        currencyRepository.save(currency);
    }
}