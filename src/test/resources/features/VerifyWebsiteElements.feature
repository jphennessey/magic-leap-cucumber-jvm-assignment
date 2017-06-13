Feature: Verify elements of the Magic Leap website

  Background:
    Given I load the home page
    And I load the contact page

# Test 1, part a
  Scenario: Verify address listing
    When I inspect the address
    Then The street address is 7500 west sunrise boulevard

# Test 1, part b
  Scenario: Verify contact form submission
    When I complete the contact form
    And I submit the contact form
    Then I get a confirmation

# Test 2
  Scenario: Verify incorrect address listing
    When I inspect the address
    Then The street address is not 1800 Griffin Rd
