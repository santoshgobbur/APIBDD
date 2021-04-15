# Gobbur Santosh
Feature: Get operation

	  Scenario: Get request for product api
	    #When user perform GET
	    #Then user verify get call success with status code 200
	    #And user verify response body as "JSON"
      #And user verify limit is 10
      #And user verify data has 10 elements
	    
  Scenario: Get request for product api with path parameter 
   When user perform GET
   Then user verify below
   |id|abcat0208002|pcmcat248700050021|pcmcat303600050001|pcmcat312300050015|
   |name|Alkaline Batteries|Housewares|Household Batteries|Connected Home & Housewares|
   |createdAt|2016-11-17T17:57:04.285Z|2016-11-17T17:57:05.399Z|2016-11-17T17:57:04.285Z|2016-11-17T17:57:04.285Z|
   |updatedAt|2016-11-17T17:57:04.285Z|2016-11-17T17:57:05.399Z|2016-11-17T17:57:04.285Z|2016-11-17T17:57:04.285Z|
   
 
   
   
   
  
    
