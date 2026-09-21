@regression
Feature: Trainings programs location filter

    Background:
        Given I am on the EPAM Campus homepage

    Scenario Outline: Filter programs by location and open the first result
        When I open the training programs catalog
        Then the page heading should be "Training programs"
        When I open the location filter
        Then the location dropdown should be open
        When I filter programs by country "<country>"
        Then the results should be filtered
        When I open the first program card
        Then the program detail title should match the selected card

        Examples:
            | country   |
            | Argentina |
            | Poland    |
            | Ukraine   |
            | Croatia   |
            | Lithuania |