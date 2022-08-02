
package com.kraken.PojoSerialization.ExpectedconnectionIDJson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class ExpectedResult {

    @SerializedName("connectionID")
    @Expose
    private String connectionID;
    @SerializedName("event")
    @Expose
    private String event;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("version")
    @Expose
    private String version;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ExpectedResult() {
    }

    /**
     * 
     * @param connectionID
     * @param event
     * @param version
     * @param status
     */
    public ExpectedResult(String connectionID, String event, String status, String version) {
        super();
        this.connectionID = connectionID;
        this.event = event;
        this.status = status;
        this.version = version;
    }

    public String getConnectionID() {
        return connectionID;
    }

    public void setConnectionID(String connectionID) {
        this.connectionID = connectionID;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}
