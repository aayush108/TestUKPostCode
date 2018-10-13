Feature: Validate postcode.io from the APIs

  Background: Postcodes.io is a free Postcode lookup API and geocoder for the UK

  Scenario: Get nearest postcodes for a given longitude & latitude

    Given I have valid longitude "-1.45206389524253" and latitude "53.3751367373779"
    When I make a get request to nearest postcode endpoint
    Then the response status should be "200"
    And content type of response received should be in "JSON" format
