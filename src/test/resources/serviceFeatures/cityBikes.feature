@All
Feature: Validate the location of city bikes around the world
  As a user, I want to verify that the city Frankfurt is in Germany and return their correspondent latitude and longitude
  For each valid request, returns city location details including latitude and longitude
  For each invalid request, returns error response

  Scenario Outline: validate that the city <cityName> is in <countryName> and return their correspondent latitude and longitude
    Given I want to test "<serviceUrl>" service
    When I do a GET request for "<uri>"
    Then I validate the response with status code <expectedStatus>
    And Cycle brand "<company>" City "<cityName>" should belong to Country "<countryName>"
    And response should contain the <latitude> and <longitude>

    @Positive
    Examples:
      | serviceUrl                        | expectedStatus | uri                     | company       | cityName  | countryName | latitude | longitude |
      | http://api.citybik.es/v2/networks | 200            | /visa-frankfurt         | Nextbike GmbH | Frankfurt | DE          | 50.1072  | 8.66375   |
      | http://api.citybik.es/v2/networks | 200            | /nextbike-london        | Nextbike GmbH | London    | GB          | 51.4862  | -0.11966  |
      | http://api.citybik.es/v2/networks | 200            | /nextbike-zagreb        | Nextbike GmbH | Zagreb    | HR          | 45.7984  | 15.9789   |
      | http://api.citybik.es/v2/networks | 200            | /bykystations-uae-dubai | Nextbike GmbH | Dubai     | AE          | 25.2435  | 55.2722   |


  @Negative
  Scenario: Validate error response when invalid city is provided
    Given I want to test "http://api.citybik.es/v2/networks" service
    When I do a GET request for "/unknowncity"
    Then I validate the response with status code 404
