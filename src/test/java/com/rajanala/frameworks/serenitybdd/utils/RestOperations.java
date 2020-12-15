package com.rajanala.frameworks.serenitybdd.utils;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

/**
 * Contains reusable methods related to REST endpoints.
 * Includes major operations like, GET, POST and PUT operations
 */
public class RestOperations {

    protected Response response;

    /**
     * Hits the GET rest endpoint
     * @param url - service endpoint url
     * @return endpoint response
     */
    protected Response getService(final String url) {
        try {
            response = SerenityRest.
                    given().
                    when().
                    get(url);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return response;
    }
}
