package by.shylau.crypto_currency_watcher.service;

import by.shylau.crypto_currency_watcher.dto.CurrencyDTO;
import by.shylau.crypto_currency_watcher.model.Currency;
import by.shylau.crypto_currency_watcher.util.Util;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static by.shylau.crypto_currency_watcher.util.Constants.*;

@Service
public class RestDataService {
    private final static Logger logger = LoggerFactory.getLogger(RestDataService.class);

    private final CurrencyService currencyService;
    private List<String> list = new ArrayList();

    {
        list.add(ETH);
        list.add(BTC);
        list.add(SOL);
    }

    @Autowired
    public RestDataService(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @Scheduled(fixedRate = 60000) // 60000 миллисекунд = 1 минута
    public void fetchData() {
        Currency currency;
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();

        for (int i = 0; i < list.size(); i++) {
            String json = restTemplate.getForObject(list.get(i), String.class);

            try {
                CurrencyDTO[] array = mapper.readValue(json, CurrencyDTO[].class);

                for (CurrencyDTO item : array) {
                    currency = new Currency(item.getId(), item.getSymbol(), item.getPrice_usd());
                    Util.checkCurrency(item);
                    saveData(currency);
                }
            } catch (IOException e) {
                System.err.println(JSON_EXCEPTION);
            }
        }
    }

    public void saveData(Currency currency) {
        currencyService.save(currency);
        logger.info(currency + " was add");
    }
}