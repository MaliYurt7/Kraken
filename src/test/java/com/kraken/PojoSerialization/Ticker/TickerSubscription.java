
package com.kraken.PojoSerialization.Ticker;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class TickerSubscription {

    @SerializedName("interval")
    @Expose
    private Integer interval;
    @SerializedName("name")
    @Expose
    private String name;

    /**
     * No args constructor for use in serialization
     *
     */
    public TickerSubscription() {
    }

    /**
     *
     * @param name
     * @param interval
     */
    public TickerSubscription( String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
