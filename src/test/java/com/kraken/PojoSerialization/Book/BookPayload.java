
package com.kraken.PojoSerialization.Book;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.processing.Generated;
import java.util.List;

@Generated("jsonschema2pojo")
public class BookPayload {

    @SerializedName("event")
    @Expose
    private String event;
    @SerializedName("pair")
    @Expose
    private List<String> pair = null;
    @SerializedName("subscription")
    @Expose
    private BookSubscription subscription;

    /**
     * No args constructor for use in serialization
     * 
     */
    public BookPayload() {
    }

    /**
     * 
     * @param subscription
     * @param event
     * @param pair
     */
    public BookPayload(String event, List<String> pair, BookSubscription subscription) {
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

    public BookSubscription getSubscription() {
        return subscription;
    }

    public void setSubscription(BookSubscription subscription) {
        this.subscription = subscription;
    }

}
