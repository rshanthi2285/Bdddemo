Feature: Login functionality
@smoketest
  Scenario: Check log in with valid cred
    Given User is on the default page
    Then User clicks on signup now
    Then User navigates back and click on mail
    Then User clicks on sigin