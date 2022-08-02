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

    public SocketServiceData connectAndListen(SocketServiceData socketContext, String event, String pair, String interval, String name) {
        boolean isSent = false;
        try {
            webSocket = new Client(socketContext);
            if (!socketContext.requestHeaders.isEmpty()) {
                final Map<String, String> requestHeaderParams = socketContext.requestHeaders;
                requestHeaderParams.forEach((key, value) -> {
                    webSocket.addHeader(key, value);
                });
            }
            webSocket.connectBlocking();
            while (!webSocket.isClosed()) {

                if (webSocket.connectionAliveTime() >= socketContext.timeOut) {
                    webSocket.close(1006, "Time Out");
                }
                if (!isSent) {
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

}
