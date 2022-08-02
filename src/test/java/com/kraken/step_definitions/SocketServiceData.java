package com.kraken.step_definitions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SocketServiceData {
    String URI;
    Map<String,String> requestHeaders=new HashMap<>();
    List<String> messageList=new ArrayList<>();
    int statusCode;
    int timeOut;
    int timeTaken;

    public String getURI() {
        return URI;
    }

    public void setURI(String URI) {
        this.URI = URI;
    }

    public int getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }
}
