@smoke @regression
Feature: Main navbar navigation

    Background:
        Given I am on the EPAM Campus homepage

    Scenario: Navigate through the main navbar links
        When I click "Career journey" in the navbar
        Then the page heading should be "Journey to career in tech"
        When I click "Skills" in the navbar
        Then the page heading should be "Training skills"
        When I click "Blog" in the navbar
        Then the page heading should be "Blog"
        And the blog search input should be displayed
        When I click "About us" in the navbar
        Then the page heading should be "Elevate your career through education"