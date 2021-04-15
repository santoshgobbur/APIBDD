
Feature: Post call operation

  Scenario: Test Post Request with Payload data as string
    When user perform post
    Then user verify post api call with succcess code 201
    And user verify
     
