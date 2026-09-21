package com.eduardorichards.steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.eduardorichards.pages.CareerJourneyPage;
import com.eduardorichards.pages.CareerJourneyQuizPage;
import com.eduardorichards.pages.GuidancePage;
import com.eduardorichards.pages.HomePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class QuizSteps {

    private final ScenarioContext context;
    private CareerJourneyQuizPage quizPage;
    private GuidancePage GuidancePage;

    public QuizSteps(ScenarioContext context) {
        this.context = context;
    }
    
    @When("I click the pass navigation test button")
    public void iClickThePassNavigationTestButton() {
        ((HomePage) context.getCurrentPage()).clickPassNavigationTest();
        context.setCurrentPage(new CareerJourneyPage());
    }

    @When("I start the career test")
    public void iStartTheCareerTest() {
        ((CareerJourneyPage) context.getCurrentPage()).clickStartTest();
        quizPage = new CareerJourneyQuizPage();
        context.setCurrentPage(quizPage);
    }

    @Then("the quiz question should be {string}")
    public void theQuizQuestionShouldBe(String expectedQuestion) {
        assertEquals(quizPage.getQuestionHeadingText(), expectedQuestion);
    }

    @When("^I answer \"(.+)\"$")
    public void iAnswer(String answer) {
        quizPage.selectAnswer(answer);
    }
    
    @Then("I should be on the guidance page")
    public void iShouldBeOnTheGuidancePage() {
        GuidancePage = new GuidancePage();
        assertTrue(GuidancePage.isLoaded());
        context.setCurrentPage(GuidancePage);
    }

    @Then("the pass test button should be displayed")
    public void thePassTestButtonShouldBeDisplayed() {
        assertTrue(GuidancePage.isPassTestButtonDisplayed());
    }
}
 