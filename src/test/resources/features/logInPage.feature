@LoginPageScenarios
Feature: Verify Login Page Scenarios

  @test2
  Scenario: Verify Login Page
    Given I launch the Application
    When I Click on Sign Button from Header on HomePage
    And I Verify Amazon Logo on HomePage
    And I Verify Search Bar on HomePage
