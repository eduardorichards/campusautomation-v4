package com.eduardorichards.steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.eduardorichards.model.TrainingProgram;
import com.eduardorichards.pages.HomePage;
import com.eduardorichards.pages.ProgramDetailPage;
import com.eduardorichards.pages.TrainingProgramsPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LocationFilterSteps {

    private final ScenarioContext context;
    private TrainingProgramsPage trainingProgramsPage;
    private TrainingProgram selectedProgram;

    public LocationFilterSteps(ScenarioContext context) {
        this.context = context;
    }
    
    @When("I open the training programs catalog")
    public void iOpenTheTrainingProgramsCatalog() {
        ((HomePage) context.getCurrentPage()).clickFindAProgram();
        trainingProgramsPage = new TrainingProgramsPage();
        context.setCurrentPage(trainingProgramsPage);        
    }

    @When("I open the location filter")
    public void iOpenTheLocationFilter() {
        trainingProgramsPage.openLocationFilter();
    }

    @Then("the location dropdown should be open")
    public void theLocationFilterShouldBeOpen() {
        assertTrue(trainingProgramsPage.isLocationDropdownOpen());
    }

    @When("^I filter programs by country \"([A-Za-z ]+)\"$")
    public void iFilterProgramsByCountry(String country) {
        trainingProgramsPage.selectCountry(country);
    }

    @Then("the results should be filtered")
    public void theResultsShouldBeFIltered() {
        assertTrue(trainingProgramsPage.isFilterApplied());
    }

    @When("I open the first program card")
    public void iOpenTheFirstProgramCard(){
        selectedProgram = trainingProgramsPage.openFirstResultCard();
    }

    @Then("the program detail title should match the selected card")
    public void theProgramDetailTitleShouldMatchTheSelectedCard() {
        ProgramDetailPage detailPage = new ProgramDetailPage();
        context.setCurrentPage(detailPage);
        assertEquals(detailPage.getHeadingText(), selectedProgram.getTitle());
    }
}
