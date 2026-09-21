package com.eduardorichards.steps;

import static org.testng.Assert.assertEquals;

import com.eduardorichards.pages.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CommonSteps {
    
    private final ScenarioContext context;
    
    public CommonSteps(ScenarioContext context) {
        this.context = context;
    }

    @Given("I am on the EPAM Campus homepage")
    public void IamOnTheHomepage() {
        HomePage homwPage = new HomePage();
        homwPage.navigateTo();
        context.setCurrentPage(homwPage);
    }

    @Then("the page heading should be {string}")
    public void thePageHeadingShouldBe(String expected) {
        assertEquals(context.getCurrentPage().getHeadingText(), expected);
    }
}
