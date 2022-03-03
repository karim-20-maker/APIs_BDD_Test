@Test_BDD_SCRIPT
Feature: Validating numView API's

  Scenario Outline: verify numViews from  colour lovers response  body to be greater than 4000
    Given colour lovers URL
    When user calls patterns  End Point with get http request
    Then Should get numViews value from numViews Path and that value should be greater than  <value>
    And the API call must got success with status code  <statusCode>
    Examples:
        | value |  statusCode |
        | "4000" | 200 |
