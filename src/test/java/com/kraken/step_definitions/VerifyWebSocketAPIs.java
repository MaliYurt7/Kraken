package com.kraken.step_definitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

import static com.kraken.PojoSerialization.PojoCommonMethod.PojoCommonMethod.expectedResultJson;
import static java.lang.Integer.parseInt;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class VerifyWebSocketAPIs {
    SocketServiceData context;
    SocketServiceData responseContext;

    @Given("the user enter the data {string},{string}")
    public void the_user_enter_the_data(String wss, String timeOut) {
        context = new SocketServiceData();
        context.setURI(wss);
        context.getURI();
        context.setTimeOut(parseInt(timeOut));
        context.getTimeOut();
    }

    @Given("the user connects the api sending json payload info {string} {string} {string} {string}")
    public void the_user_connects_the_api_sending_json_payload_info_based_on(String event, String pair, String interval, String name) {
        responseContext = WebClient.getInstance().connectAndListen(context, event, pair, interval, name);
    }

    @Then("The user should be able to see initial connection payload scheme's keys and values {string}, {string}, {string}, {string}")
    public void the_user_should_be_able_to_see_initial_connection_payload_scheme_s_keys_and_values(String expectConnectionID, String expectEvent, String expectStatus, String expectVersion) {
        String expectedResult = expectedResultJson(expectConnectionID, expectEvent, expectStatus, expectVersion);
        String actualResult = responseContext.messageList.get(0);
        String[] actualResultArray = actualResult.split(",");
        List<String> actualResultArrayHamcrestMatchers = Arrays.asList(actualResultArray);
        assertThat(actualResultArrayHamcrestMatchers, hasSize(4));
        assertThat(actualResultArray, hasItemInArray("\"event\":\"systemStatus\""));
        String expectedInitialPayload = expectedResult.substring(0, 16) + expectedResult.substring(expectedResult.length()-59);
        String actualInitialPayload = responseContext.messageList.get(0).substring(0, 16) + responseContext.messageList.get(0).substring(responseContext.messageList.get(0).length()-59);
        assertThat(actualInitialPayload, stringContainsInOrder(Arrays.asList(expectedInitialPayload)));
    }

    @Then("the user should see the {int}")
    public void the_user_should_see_the(Integer expectedChannelID) {
        int actualChannelID = parseInt(responseContext.messageList.get(1).substring(13, 16));
        assertThat(actualChannelID, comparesEqualTo(expectedChannelID));
    }

    @Then("the user should not see the {string} in Json")
    public void the_user_should_not_see_the_in_Json(String errorMessage) {
        String actualJsonResponse = responseContext.messageList.get(1);
        System.out.println("actualJsonResponse = " + actualJsonResponse);
        Assert.assertFalse("The json body should not contain"+errorMessage, actualJsonResponse.contains(errorMessage));
    }


}



