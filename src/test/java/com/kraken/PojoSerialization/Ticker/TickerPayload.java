
package com.kraken.PojoSerialization.Ticker;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.processing.Generated;
import java.util.List;

@Generated("jsonschema2pojo")
public class TickerPayload {

    @SerializedName("event")
    @Expose
    private String event;
    @SerializedName("pair")
    @Expose
    private List<String> pair = null;
    @SerializedName("subscription")
    @Expose
    private TickerSubscription tickerSubscription;

    /**
     * No args constructor for use in serialization
     * 
     */
    public TickerPayload() {
    }

    /**
     * 
     * @param subscription
     * @param event
     * @param pair
     */
    public TickerPayload(String event, List<String> pair, TickerSubscription tickerSubscription) {
        super();
        this.event = event;
        this.pair = pair;
        this.tickerSubscription=tickerSubscription;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public List<String> getPair() {
        return pair;
    }

    public void setPair(List<String> pair) {
        this.pair = pair;
    }

    public TickerSubscription getSubscription() {
        return tickerSubscription;
    }

    public void setSubscription(TickerSubscription tickerSubscription) {
        this.tickerSubscription = tickerSubscription;
    }

}
