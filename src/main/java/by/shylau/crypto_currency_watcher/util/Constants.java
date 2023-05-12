package by.shylau.crypto_currency_watcher.util;

public class Constants {
    private Constants() {
    }

    //Message
    public static final String CANT_FIND_BY_SYMBOL = "DB is dont have currency with SYMBOL ";
    public static final String SUCCESS = "User successful registration with username ";
    public static final String LOG_CHANGE = "Изменилась цена ";

    //Error
    public static final String JSON_EXCEPTION = "incorrect JSON parse";

    //DB
    public static final String TABLE_NAME = "currency";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_ID_CURRENCY = "id_currency";
    public static final String COLUMN_SYMBOL = "symbol";
    public static final String COLUMN_PRICE_USD = "price_usd";

    //Math value for logic app
    public static final int VALUE_FOR_LOGIC = 1;
    public static final int VALUE_FOR_SHOW_COIN = 4;

    //Adress currency
    public static final String ETH = "https://api.coinlore.net/api/ticker/?id=80";
    public static final String BTC= "https://api.coinlore.net/api/ticker/?id=90";
    public static final String SOL = "https://api.coinlore.net/api/ticker/?id=48543";
}