
package com.kraken.PojoSerialization.Ohlc;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.processing.Generated;
import java.util.List;

@Generated("jsonschema2pojo")
public class OhlcPayload {

    @SerializedName("event")
    @Expose
    private String event;
    @SerializedName("pair")
    @Expose
    private List<String> pair = null;
    @SerializedName("subscription")
    @Expose
    private OhlcSubscription ohlcSubscription;

    /**
     * No args constructor for use in serialization
     * 
     */
    public OhlcPayload() {
    }

    /**
     * 
     * @param subscription
     * @param event
     * @param pair
     */
    public OhlcPayload(String event, List<String> pair, OhlcSubscription ohlcSubscription) {
        super();
        this.event = event;
        this.pair = pair;
        this.ohlcSubscription = ohlcSubscription;
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

    public OhlcSubscription getSubscription() {
        return ohlcSubscription;
    }

    public void setSubscription(OhlcSubscription subscription) {
        this.ohlcSubscription = subscription;
    }

}
