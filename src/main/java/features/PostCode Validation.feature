Feature: Validate postcode.io from the APIs

  Background: Postcodes.io is a free Postcode lookup API and geocoder for the UK
    Given The GET postcode endpoint is up and running

  @run
  Scenario: A valid postcode should return postcode details
    When I input a postcode "s22sf"
    Then I should get the response status "200"
    And content type of response should be in "JSON" format
    And the body response should be contain below values
      | result.postcode             | S2 2SF    |
      | result.quality              | 1         |
      | result.country              | England   |
      | result.codes.admin_district | E08000019 |
      | result.codes.admin_county   | E99999999 |
      | result.codes.ccg            | E38000146 |


  @run
  Scenario: An invalid postcode should return error
    When I input a postcode "random"
    Then I should get the response status "404"
    And error message is "Invalid postcode"


    Scenario Outline: Postcode should contain valid values
      When I input a postcode "<postcode>"
      Then I should get the response status "200"
      And content type of response should be in "JSON" format

      Examples:
      |postcode       |
      |s22sf          |
      |s38nf          |
      |S2 2SZ         |

