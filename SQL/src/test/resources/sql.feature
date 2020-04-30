Feature: Getting the details of the students
  Scenario: client makes a call to /hello
    Given the client calls /hello
    Then the status code is 200
    And the client receives student details Hello
  Scenario: client makes call to /students
    Given the client calls /students
    Then the status code is 200
    And the client receives student details []
  Scenario: client makes call to /students
    Given the client posts to /students
    Then the status code is 200





