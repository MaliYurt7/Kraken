
package com.kraken.PojoSerialization.Trade;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.processing.Generated;
import java.util.List;

@Generated("jsonschema2pojo")
public class TradePayload {

    @SerializedName("event")
    @Expose
    private String event;
    @SerializedName("pair")
    @Expose
    private List<String> pair = null;
    @SerializedName("subscription")
    @Expose
    private TradeSubscription subscription;

    /**
     * No args constructor for use in serialization
     * 
     */
    public TradePayload() {
    }

    /**
     * 
     * @param subscription
     * @param event
     * @param pair
     */
    public TradePayload(String event, List<String> pair, TradeSubscription subscription) {
        super();
        this.event = event;
        this.pair = pair;
        this.subscription = subscription;
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

    public TradeSubscription getSubscription() {
        return subscription;
    }

    public void setSubscription(TradeSubscription subscription) {
        this.subscription = subscription;
    }

}
