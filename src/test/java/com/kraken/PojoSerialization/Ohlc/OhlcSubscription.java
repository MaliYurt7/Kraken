
package com.kraken.PojoSerialization.Ohlc;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class OhlcSubscription {

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
    public OhlcSubscription() {
    }

    /**
     * 
     * @param name
     * @param interval
     */
    public OhlcSubscription(Integer interval, String name) {
        super();
        this.interval = interval;
        this.name = name;
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
