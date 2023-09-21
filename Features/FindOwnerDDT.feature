
Feature: Finding the owner through search criteria(DDT)

  

  @sanity
  Scenario Outline: Finding the owner 
    Given User launch the browser
    And opens the URL "http://localhost:8080/"
    When User navigates to FIND OWNERS menu and clicks on FIND OWNERS
    And User enters the "<lastname>" field and clicks on Find Owner
    Then user navigates to Owner Information Page
    Examples: 
      | lastname  |
      | P |    
      | X |    
