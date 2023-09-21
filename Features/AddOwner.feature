Feature: Creating New Owner record

@sanity
Scenario: Adding the Owner
  Given User launch the browser
  And opens the URL "http://localhost:8080/"
  When User navigates to FIND OWNERS menu and clicks on FIND OWNERS
  And Clicks on Add Owner
  And  User enters firstname as "Padma" and lastname as "QT" and Address as "1231" and City as "Newark1" and Telephone as "1234567891"
 
  Then user navigates to Owner Information Page
