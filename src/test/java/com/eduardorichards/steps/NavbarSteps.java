package com.eduardorichards.steps;

import static org.testng.Assert.assertTrue;

import com.eduardorichards.pages.AboutUsPage;
import com.eduardorichards.pages.AbstractPage;
import com.eduardorichards.pages.BlogPage;
import com.eduardorichards.pages.CareerJourneyPage;
import com.eduardorichards.pages.SkillsPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NavbarSteps {

    private final ScenarioContext context;

    public NavbarSteps(ScenarioContext context) {
        this.context = context;
    }

    @When("^I click \"(Career journey|Skills|Blog|About us)\" in the navbar$")
    public void iClickTheNavbar(String link) {
        AbstractPage page = context.getCurrentPage();
        switch (link) {
            case "Career journey" -> {
                page.clickCareerJourney();
                context.setCurrentPage(new CareerJourneyPage());
            }
            case "Skills" -> {
                page.clickSkills();
                context.setCurrentPage(new SkillsPage());
            }
            case "Blog" -> {
                page.clickBlog();
                context.setCurrentPage(new BlogPage());
            }
            case "About us" -> {
                page.clickAboutUs();
                context.setCurrentPage(new AboutUsPage());
            }
            default -> throw new IllegalArgumentException("Unknown navbar link: " + link);
        }
    }

    @Then("the blog search input should be displayed")
    public void theBlogSearchInputShouldBeDisplayed() {
        assertTrue(((BlogPage) context.getCurrentPage()).isSearchInputDisplayed());
    }
}
