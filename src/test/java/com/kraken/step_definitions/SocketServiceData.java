package com.kraken.step_definitions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SocketServiceData {
    String URI;
   // String actualMessage;
    //String expectedMessage;
    Map<String,String> requestHeaders=new HashMap<>();
    List<String> messageList=new ArrayList<>();
    int statusCode;
    int timeOut;
    int timeTaken;

//    public SocketServiceData(String URI, String expectedMessage,  int statusCode, int timeOut) {
//        this.URI = URI;
//        this.expectedMessage = expectedMessage;
//        this.statusCode = statusCode;
//        this.timeOut = timeOut;
//    }

    public String getURI() {
        return URI;
    }

    public void setURI(String URI) {
        this.URI = URI;
    }

//    public String getExpectedMessage() {
//        return expectedMessage;
//    }
//
//    public void setExpectedMessage(String expectedMessage) {
//        this.expectedMessage = expectedMessage;
//    }

    public int getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }
}
