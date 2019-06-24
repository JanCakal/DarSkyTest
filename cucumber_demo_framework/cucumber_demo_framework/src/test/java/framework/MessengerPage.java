package framework;

import org.openqa.selenium.By;

public class MessengerPage extends BasePage{

    private By emailField = By.id("email");
    private By passwordField = By.id("pass");
    private By signUpButton = By.id("loginbutton");
    private static By errorMessage = By.xpath("//div[contains(text(),'Incorrect email or phone number')]");
    private By firstNameTextField = By.id("firstName");
    private By lastNameTextField = By.id("lastName");
    private By mobileNumberTextField = By.id("mobileNumber");
    private By newPasswordTextField = By.id("newPwd");

    public void enterEmail(String email) {
        setValue(emailField, email);
    }

    public void enterPassword(String password) {
        setValue(passwordField, password);
    }

    public void clickOnSignupButton() {
        clickOn(signUpButton);
    }

    public void enterFirstName(String firstName) {
        setValue(firstNameTextField, firstName);
    }

    public void enterLastName(String lastName) {
        setValue(lastNameTextField, lastName);
    }

    public void enterMobileNumber(String mobileNum) {
        setValue(mobileNumberTextField, mobileNum);
    }

    public void enterNewPassword(String password) {
        setValue(newPasswordTextField, password);
    }

    public void clickOnLoginButton() {
        clickOn(signUpButton);
    }








}
