@regression
Feature: Career journey navigation quiz

    Background:
        Given I am on the EPAM Campus homepage

    Scenario: Complete the navigation quiz and reach the guidance page
        When I click the pass navigation test button
        Then the page heading should be "Journey to career in tech"
        When I start the career test
        Then the quiz question should be "How would you evaluate your current level of knowledge in IT?"
        When I answer "I have some knowledge of tech"
        Then the quiz question should be "Have you already chosen your skill?"
        When I answer "No"
        Then I should be on the guidance page
        And the page heading should be "Test: What tech job is right for me?"
        And the pass test button should be displayed