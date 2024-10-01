Feature: form test scenario
  Scenario Outline: Go to web site and submit
    Given go to login page
    And down scroll bar
    And type name as "<name>"
    And type lastname as "<lastname>"
    And type email as "<email>"
    And type number as "<number>"
    And type subject as "<subject>"
    And upload image "<imagePath>"
    And type address as "<address>"
    And select state "<state>"
    And select city "<city>"
    When click submit button
    Then success submit message
    Examples:
      |name  |lastname|email|number|subject|address|imagePath|state|city|
      |serhat|baglam |s@s.com|1234567890|subject-1|adana|/Users/resitserhatbaglam/IdeaProjects/formTest/src/images/selenium.png|Haryana|Karnal|
