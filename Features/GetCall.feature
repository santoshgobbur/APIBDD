# Gobbur Santosh
Feature: Get call operation

 Scenario: Test GET api
 When user perform get operation "/products"
 Then user verify get api call with succcess code 200
 And user verify limit is 10


 
 
 
 #Scenario: Test GET request by query parameters
 #
 #When user perform get with queryparaneter "limit&skip"
 #|limit|skip|
 #|2|2|
 
 #Scenario: Test post call 
 #When user perform post with body
 #|name|type|price|shipping|upc|description|manufacturer|model|url|image|
 #|nokia|mobile|1500|2|FM|music|hmd|express|www.nokia.com|white|
 #Then user verify post api call with succcess code 201
 
 
 #Scenario: Test post call 
 #When user perform post operation for "/products" with payload data as json file 
 #Then user verify post api call with succcess code 201
 
 #|name|type|price|shipping|upc|description|manufacturer|model|url|image|
 #|Google|smartphone|30000|1|yes|India|pixel|a|www.google.in|white|
