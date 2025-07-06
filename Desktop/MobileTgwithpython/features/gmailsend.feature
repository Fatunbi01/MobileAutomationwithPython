#Feature: Send an email via Gmail app
#
#  Scenario Outline: Send a Gmail message using Appium automation
#    Given the Gmail app is opened
#    When the user taps the compose button
#    And the user enters recipient "<recipient>"
#    And the user enters subject "<subject>"
#    And the user enters body "<body>"
#    And the user sends the email
#    Then the email should be sent successfully
#
#    Examples:
#      | recipient              | subject      | body                        |
#      | yfatunbi@gmail.com     | Appium Test   | This is an automated test email      |
#      | kehindefatunbi2@gmail.com    | Appium Test  | This is a second test mail. |

  Feature: Send Email via Gmail App
  As a user
  I want to send an email through the Gmail app
  So that I can test email functionality

  Scenario: Send test email to yfatunbi@gmail.com
    Given I open the Gmail application
    When I compose a new email
    And I enter "yfatunbi@gmail.com" as recipient
    And I enter "Gmail Test" as subject
    And I enter "This is an automated test email" as body
    Then I send the email
    And I should see confirmation that email was sent