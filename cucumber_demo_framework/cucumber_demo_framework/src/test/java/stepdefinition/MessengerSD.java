package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.HomePage;
import framework.MessengerLoginPage;
import framework.MessengerPage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class MessengerSD {

    private HomePage homePage = new HomePage();
    private MessengerPage messengerPage = new MessengerPage();
    private MessengerLoginPage messengerLoginPage = new MessengerLoginPage();

    @Given("^I am on messenger page$")
    public void setMessengerPage() {

        Assert.assertEquals(SharedSD.getDriver().getCurrentUrl(), "https://www.messenger.com/");
    }

    @When("^I enter (.+) into (username|password|firstname|lastname|mobile number|new password) field on messenger page$")
    public void enterDataIntoTextFields(String anyText, String textFields) {


        switch (textFields) {
            case "username":
                messengerPage.enterEmail(anyText);
                break;
            case "password":
                messengerPage.enterPassword(anyText);
                break;
            case "firstname":
                messengerPage.enterFirstName(anyText);
                break;
            case "lastname":
                messengerPage.enterLastName(anyText);
                break;
            case "mobile number":
                messengerPage.enterMobileNumber(anyText);
                break;
            case "new password":
                messengerPage.enterNewPassword(anyText);
                break;
        }
    }

    @And("^I click on (signup|create account) button on messenger page$")
    public void clickOnLoginButton(String button) {

        switch (button) {
            case "signup":
                messengerPage.clickOnLoginButton( );
                break;
            case "create account":
                //Implement Create account object
                break;
        }
    }

//    @Then("^I verify that i am an invalid login page$")
//    public void verifyInvalidLoginPage() {
//        Assert.assertEquals(loginPage.getPageHeader(), "Log Into Facebook");
//    }

    @Then("^I verify invalid login verify message on signup page$")

        public void verifySignUpErrorMessage() {
            Assert.assertEquals(messengerLoginPage.getErrorMessage(), "Incorrect Email");

    }

}






