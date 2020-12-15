@All
Feature: Validate the location of city bikes around the world
  As a user, I want to verify that the city Frankfurt is in Germany and return their correspondent latitude and longitude
  For each valid request, returns city location details including latitude and longitude
  For each invalid request, returns error response

  Scenario Outline: validate that the city Frankfurt is in Germany and return their correspondent latitude and longitude
    Given I want to test "<serviceUrl>" service
    When I do a GET request for "<uri>"
    Then I validate the response with status code <expectedStatus>
    And response should contain the "<cityName>", <latitude> and <longitude>

    @testMeAlone
    Examples:
      | tc_id | serviceUrl                        | expectedStatus | uri             | cityName  | latitude | longitude |
      | TC01  | http://api.citybik.es/v2/networks | 200            | /visa-frankfurt | Frankfurt | 50.1072  | 8.66375   |
