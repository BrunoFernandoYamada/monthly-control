#Author: bfyamada@outlook.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Tests do SpreadSheet
  I want to use this template for my feature file

  @tag1
  Scenario: Generating a new SpreadSheet without any Incomes or Expenses For the First month of 2021
    Given I want to generate a new feature
    When I set the year 2021 and month 1
    Then I validate the SpreadSheet with year 2021 and month "January"

  @tag2
  Scenario Outline: Gerenate a SpreadSheet For February do 2021 end adding a not received Income do 100.00 and a Expense of 50.00 not paid
    Given I want to generate a new feature
    When I set the year <year> and month <month>
    And I create a new Income with name <incomeName> and <incomeValue> of value and payment <isPaid>
    And I add the income to the spreadsheet
    And I create a new Expense with name <expenseName> and value of <expenseValue> receipt <isReceived>
    And I add the expense to the spreadsheet
    Then I validate the SpreadSheet with year <year> and month <monthText>
    And I validate the Income
    And I Validatte The expense

    Examples: 
      | year | month | incomeName | incomeValue | isPaid   | expenseName   | expenseValue | isReceived | monthText   |
      | 2021 |     2 |"Salary"    |     1000.00 | "false"  | "Shopping"    |        50.00 | "false"    | "February"  |
      | 2021 |     3 | "Bonus"    |      250.00 | "true"   | "Supermarket" |        50.00 | "false"    | "March"     |
      | 2021 |     5 | "Salary"   |      100.00 | "false"  | "Car repair"  |        50.00 | "false"    | "May"       |
