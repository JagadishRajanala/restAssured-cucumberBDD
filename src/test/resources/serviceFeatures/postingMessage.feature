Feature: To test the social site for posts, comments and users
  As a user, I want to verify that posting a message on social site is successfull
  and  check for comments on the post including the users

  Scenario Outline: Validate that the posts is returning a valid and invalid response
  Given I want to post a "<message>" on social site
  When I do a POST request for "<serviceUrl>"
  Then I validate the response with status code <expectedStatus>

  Examples:
  | serviceUrl                                 | expectedStatus | message        |
  | https://jsonplaceholder.typicode.com/posts |            201 | Hello Jagadish |
  
  Scenario Outline: validate the comment on post is returning a valid response
    Given I want to get the comments on the post
    When I do a GET request for "<serviceUrl>"
    Then I validate the response with status code <expectedStatus>
    Then I validate the Email in the response body is "<Email>"

    Examples: 
      | serviceUrl                                            | expectedStatus | message        | Email              |
      | https://jsonplaceholder.typicode.com/posts/1/comments |            200 | Hello Everyone | Eliseo@gardner.biz |
     
  Scenario Outline: To get the list of users
    Given I want to get the list of all the users
    When I do a GET request for "<serviceUrl>"
    Then I validate the response with status code <expectedStatus>

    Examples: 
      | serviceUrl                                 | expectedStatus | message        |
      | https://jsonplaceholder.typicode.com/users |            200 | Hello Everyone |
