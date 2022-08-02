package com.kraken.step_definitions;

import com.google.gson.Gson;
import com.kraken.PojoSerialization.Book.BookSubscription;
import com.kraken.PojoSerialization.Ohlc.OhlcSubscription;
import com.kraken.PojoSerialization.Spread.SpreadSubscription;
import com.kraken.PojoSerialization.Ticker.TickerSubscription;
import com.kraken.PojoSerialization.Trade.TradeSubscription;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import static com.kraken.PojoSerialization.PojoCommonMethod.PojoCommonMethod.*;
import static java.lang.Integer.parseInt;

public class WebClient {
    private Client webSocket;

    private WebClient() {
    }

    public static WebClient getInstance() {
        return new WebClient();
    }

    private static Gson gson = new Gson();

    Gson gsonn = new Gson();
//    public SocketServiceData connectAndListen(SocketServiceData socketContext) {
//        boolean isSent=false;
//        try {
//            webSocket = new Client(socketContext);
//            if (!socketContext.requestHeaders.isEmpty()) {
//                final Map<String, String> requestHeaderParams = socketContext.requestHeaders;
//                requestHeaderParams.forEach((key, value) -> {
//                    webSocket.addHeader(key, value);
//                });
//            }
//            webSocket.connectBlocking();
////            System.out.println("!webSocket.isClosed(TRUE) = " + !webSocket.isClosed());
//            while (!webSocket.isClosed()){
////                System.out.println("webSocket.connectionAliveTime() = " + webSocket.connectionAliveTime());
////                System.out.println("socketContext.timeOut = " + socketContext.timeOut);
//                if(webSocket.connectionAliveTime()>=socketContext.timeOut){
//                    webSocket.close(1006,"Time Out");
//                }
//                if(!isSent){
//                    //webSocket.onMessage(socketContext.actualMessage);
//                    String myJsonData="{\n" +
//                        "  \"event\": \"subscribe\",\n" +
//                        "  \"pair\": [\n" +
//                        "    \"XBT/EUR\"\n" +
//                        "  ],\n" +
//                        "  \"subscription\": {\n" +
//                        "    \"interval\": 5,\n" +
//                        "    \"name\": \"ohlc\"\n" +
//                        "  }\n" +
//                        "}";
//                    System.out.println("myJsonData = " + myJsonData);
//
//                    //webSocket.onMessage(myJsonData);
//                    isSent=true;
//                }
//            }
//
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return socketContext;
//    }

    public SocketServiceData connectAndListen(SocketServiceData socketContext, String event, String pair, String interval, String name) {
        boolean isSent = false;
        try {
            webSocket = new Client(socketContext);
            if (!socketContext.requestHeaders.isEmpty()) {
                final Map<String, String> requestHeaderParams = socketContext.requestHeaders;
                requestHeaderParams.forEach((key, value) -> {
                    webSocket.addHeader(key, value);
                    System.out.println("3 = " + 3);
                });
            }
            System.out.println("1 = " + 1);
            webSocket.connectBlocking();
            System.out.println("2 = " + 2);
//            System.out.println("!webSocket.isClosed(TRUE) = " + !webSocket.isClosed());
            while (!webSocket.isClosed()) {

                if (webSocket.connectionAliveTime() >= socketContext.timeOut) {
                    webSocket.close(1006, "Time Out");
                }
                if (!isSent) {
                    System.out.println("first way");
                    //  System.out.println("jsonRead() = " + jsonRead("ohlc"));
                    //  webSocket.send(jsonRead("ohlc"));
                    System.out.println("second way");
                    //  webSocket.send(tickerPojoSerilization("event", new ArrayList(Arrays.asList("XBT/USD")), new TickerSubscription("ticker")));

                    if (name.equalsIgnoreCase("ohlc")) {
                        webSocket.send(ohlcPojoSerilization(event, new ArrayList(Arrays.asList(pair)), new OhlcSubscription(parseInt(interval), name)));
                    } else if (name.equalsIgnoreCase("ticker")) {
                        webSocket.send(tickerPojoSerilization(event, new ArrayList(Arrays.asList(pair)), new TickerSubscription(name)));
                    }else if (name.equalsIgnoreCase("trade")) {
                        webSocket.send(tradePojoSerilization(event, new ArrayList(Arrays.asList(pair)), new TradeSubscription(name)));
                    }else if (name.equalsIgnoreCase("spread")) {
                        webSocket.send(spreadPojoSerilization(event, new ArrayList(Arrays.asList(pair)), new SpreadSubscription(name)));
                    }else if (name.equalsIgnoreCase("book")) {
                        webSocket.send(bookPojoSerilization(event, new ArrayList(Arrays.asList(pair)), new BookSubscription(name)));
                    }
                    isSent = true;
                }
            }

        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return socketContext;
    }


//    public void tickerPojoSerilization(String eveta, List<String> pair, Subscription subscription) {
//        TickerPayload tickerPayload =new TickerPayload("event", new ArrayList(Arrays.asList("XBT/USD",
//                "XBT/EUR")), new Subscription("ticker"));
//        String jsonTickerPayload = gson.toJson(tickerPayload);
//        System.out.println("jsonTickerPayload = " + jsonTickerPayload);
//    }

//    public String tickerPojoSerilization(String eveta, List<String> pair, TickerSubscription tickerSubscription) {
//        TickerPayload tickerPayload =new TickerPayload(eveta, pair, tickerSubscription);
//        String jsonTickerPayload = gson.toJson(tickerPayload);
//        System.out.println("jsonTickerPayload = " + jsonTickerPayload);
//        return jsonTickerPayload;
//    }

//    public String ohlcPojoSerilization(String event, List<String> pair, OhlcSubscription ohlcSubscription) {
//        OhlcPayload ohlcPayload=new OhlcPayload(event, pair, ohlcSubscription);
//        String jsonOhlcPayload = gson.toJson(ohlcPayload);
//        System.out.println("ohlcPayload = " + jsonOhlcPayload);
//        return jsonOhlcPayload;
//    }


//    public String jsonRead(String jsonFileName) {
//        String json = null;
//        try {
//            JSONParser parser = new JSONParser();
//            //Use JSONObject for simple JSON and JSONArray for array of JSON.
//            JSONObject data = (JSONObject) parser.parse(
//                    new FileReader(jsonFileName+".json"));//path to the JSON file.
//
//            json = data.toJSONString();
//
//        } catch (IOException | ParseException e) {
//            e.printStackTrace();
//        }
//        return json;
//    }

//    public String createJson(String jsonFileName) {
//        TickerSubscription tickerSubscription=
//        return "Malo";
//    }


}
