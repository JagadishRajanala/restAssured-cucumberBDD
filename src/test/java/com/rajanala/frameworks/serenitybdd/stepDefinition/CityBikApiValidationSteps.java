package com.rajanala.frameworks.serenitybdd.stepDefinition;

import com.rajanala.frameworks.serenitybdd.utils.RestOperations;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class CityBikApiValidationSteps extends RestOperations {
    private String endpointUrl;

    @Given("^I want to test \"([^\"]*)\" service$")
    public void iWantToTestService(final String endpointUrl) throws Throwable {
        this.endpointUrl = endpointUrl;
    }

    @When("^I do a GET request for \"([^\"]*)\"$")
    public void iDoAGETRequestFor(final String endpointUri) throws Throwable {
        endpointUrl = this.endpointUrl + endpointUri;
        response = getService(endpointUrl);
    }

    @Then("^I validate the response with status code (\\d+)$")
    public void iValidateTheResponseWithStatuscode(final int statusCode) throws Throwable {
        assertEquals(statusCode, response.getStatusCode());
    }

    @And("^response should contain the \"([^\"]*)\", (\\d+.\\d+) and (\\d+.\\d+)$")
    public void responseShouldContainTheAnd(final String cityName, final float latitude, final float longitude) throws Throwable {
        assertEquals(cityName, response.jsonPath().get("network.location.city"));
        float actLongitude = response.jsonPath().get("network.location.longitude");
        assertEquals(longitude, actLongitude, 0.0f);
        float actLatitude = response.jsonPath().get("network.location.latitude");
        assertEquals(latitude, actLatitude, 0.0f);
    }
}
