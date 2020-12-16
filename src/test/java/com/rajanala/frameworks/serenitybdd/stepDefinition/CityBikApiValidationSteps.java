package com.rajanala.frameworks.serenitybdd.stepDefinition;

import com.rajanala.frameworks.serenitybdd.utils.RestOperations;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class CityBikApiValidationSteps extends RestOperations {
    private String endpointUrl;

    @Given("I want to test {string} service")
    public void iWantToTestService(final String endpointUrl) throws Throwable {
        this.endpointUrl = endpointUrl;
    }

    @When("I do a GET request for {string}")
    public void iDoAGETRequestFor(final String endpointUri) throws Throwable {
        endpointUrl = this.endpointUrl + endpointUri;
        response = getService(endpointUrl);
    }

    @Then("I validate the response with status code {int}")
    public void iValidateTheResponseWithStatuscode(final int statusCode) throws Throwable {
        assertEquals(statusCode, response.getStatusCode());
    }



    @And("response should contain the {float} and {float}")
    public void responseShouldContainTheLatitudeAndLongitude(final float latitude, final float longitude) {
        float actLatitude = response.jsonPath().get("network.location.latitude");
        assertEquals(latitude, actLatitude, 0.0f);
        float actLongitude = response.jsonPath().get("network.location.longitude");
        assertEquals(longitude, actLongitude, 0.0f);

    }

    @And("Cycle brand {string} City {string} should belong to Country {string}")
    public void cityShouldBelongToCountry(final String company, final String cityName, final String country) {
        assertEquals(company, response.jsonPath().get("network.company[0]"));
        assertEquals(cityName, response.jsonPath().get("network.location.city"));
        assertEquals(country, response.jsonPath().get("network.location.country"));
    }


}
