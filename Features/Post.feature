
Feature: Post call operation

  Scenario: Test Post Request with Payload data as string
    When user perform post with body
    Then user verify post api call with succcess code 201
   
  
  