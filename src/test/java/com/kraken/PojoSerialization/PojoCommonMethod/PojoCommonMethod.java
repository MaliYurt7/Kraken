package com.kraken.PojoSerialization.PojoCommonMethod;

import com.google.gson.Gson;
import com.kraken.PojoSerialization.Book.BookPayload;
import com.kraken.PojoSerialization.Book.BookSubscription;
import com.kraken.PojoSerialization.ExpectedconnectionIDJson.ExpectedResult;
import com.kraken.PojoSerialization.Ohlc.OhlcPayload;
import com.kraken.PojoSerialization.Ohlc.OhlcSubscription;
import com.kraken.PojoSerialization.Spread.SpreadPayload;
import com.kraken.PojoSerialization.Spread.SpreadSubscription;
import com.kraken.PojoSerialization.Ticker.TickerPayload;
import com.kraken.PojoSerialization.Ticker.TickerSubscription;
import com.kraken.PojoSerialization.Trade.TradePayload;
import com.kraken.PojoSerialization.Trade.TradeSubscription;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class PojoCommonMethod {

    private static Gson gson = new Gson();

    /**
     *
     * @param event
     * @param pair
     * @param ohlcSubscription
     * @return String
     */
    public static String ohlcPojoSerilization(String event, List<String> pair, OhlcSubscription ohlcSubscription) {
        OhlcPayload ohlcPayload=new OhlcPayload(event, pair, ohlcSubscription);
        String jsonOhlcPayload = gson.toJson(ohlcPayload);
        System.out.println("ohlcPayload = " + jsonOhlcPayload);
        return jsonOhlcPayload;
    }

    /**
     *
     * @param event
     * @param pair
     * @param tickerSubscription
     * @return String
     */
    public static String tickerPojoSerilization(String event, List<String> pair, TickerSubscription tickerSubscription) {
        TickerPayload tickerPayload = new TickerPayload(event, pair, tickerSubscription);
        String jsonTickerPayload = gson.toJson(tickerPayload);
        System.out.println("jsonTickerPayload = " + jsonTickerPayload);
        return jsonTickerPayload;
    }

    /**
     *
     * @param event
     * @param pair
     * @param tradeSubscription
     * @return String
     */
    public static String tradePojoSerilization(String event, List<String> pair, TradeSubscription tradeSubscription) {
        TradePayload tradePayload = new TradePayload(event, pair, tradeSubscription);
        String jsontradePayload = gson.toJson(tradePayload);
        System.out.println("jsontradePayload = " + jsontradePayload);
        return jsontradePayload;
    }

    /**
     * @param event
     * @param pair
     * @param spreadSubscription
     * @return String
     */
    public static String spreadPojoSerilization(String event, List<String> pair, SpreadSubscription spreadSubscription) {
        SpreadPayload spreadPayload  = new SpreadPayload(event, pair, spreadSubscription);
        String jsonSpreadPayload = gson.toJson(spreadPayload);
        System.out.println("jsonSpreadPayload = " + jsonSpreadPayload);
        return jsonSpreadPayload;
    }

    /**
     *
     * @param event
     * @param pair
     * @param bookSubscription
     * @return String
     */
    public static String bookPojoSerilization(String event, List<String> pair, BookSubscription bookSubscription) {
        BookPayload bookPayload   = new BookPayload(event, pair, bookSubscription);
        String jsonBookPayload= gson.toJson(bookPayload);
        System.out.println("jsonBookPayload = " + jsonBookPayload);
        return jsonBookPayload;
    }

    /**
     *
     * @param connectionID
     * @param event
     * @param status
     * @param version
     * @return String
     */
    public static String expectedResultJson(String connectionID, String event, String status, String version) {
        ExpectedResult expectedResult = new ExpectedResult( connectionID,  event,  status,  version);
        String jsonExpectedResultJson = gson.toJson(expectedResult);
        System.out.println("jsonExpectedResultJson = " + jsonExpectedResultJson);
        return jsonExpectedResultJson;
    }

    /**
     *
     * @param jsonFileName
     * @return String
     */
    public static String jsonRead(String jsonFileName) {
        String json = null;
        try {
            JSONParser parser = new JSONParser();
            //Use JSONObject for simple JSON and JSONArray for array of JSON.
            JSONObject data = (JSONObject) parser.parse(
                    new FileReader(jsonFileName+".json"));//path to the JSON file.

            json = data.toJSONString();

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return json;
    }
}
