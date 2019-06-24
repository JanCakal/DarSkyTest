package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.DarkskyTS;
import org.testng.Assert;

public class DarkskySD {

  DarkskyTS darkskyTS = new DarkskyTS();

  DarkskyTS tempTimeline1 = new DarkskyTS();

  @Given("^I am on Darksky Home Page$")
    public void iAmOnDarkskyHomePage() throws Throwable{
      Assert.assertEquals(SharedSD.getDriver().getTitle(),"Dark Sky - 260 Broadway, New York City, NY", "Invalid website");
  }

  @Then("^I verify timeline is displayed with two hours incremented$")
    public void iVerifyTimelineIsDisplayedTwoHours () throws Throwable {
      tempTimeline1.verifyTempTimeline();
  }

  @When("^I expand todays timeline$")
  public void iExpandTodayTimeline() throws Throwable {

    darkskyTS.expandTodayTimeline();
  }

  @Then("^I verify lowest and highest temp is displayed correctly$")
  public void iVerifyLowestandHighestTempIsDsiplayedCorrectly () throws Throwable {
    darkskyTS.verifyLowHighTemp();
  }

  @Then(("^I verify current temp is not greater or less then temps from daily timeline$"))
  public void currentTempGreaterOrless(){
    //darkskyTS.verifyCurrentTemp();
    darkskyTS.verifyGreaterOrLessCurrentTepm();

  }
}
