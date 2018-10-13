Feature: Validate postcode.io from the APIs

  Background: Postcodes.io is a free Postcode lookup API and geocoder for the UK
    Given The random postcode endpoint is up and running

  @run
  Scenario: Get random postcode should return a valid postcode details
    When I call the get random postcode end point
    Then I should get the response status back "200"
    And content type of response should be in the "JSON" format


