package framework;

import org.openqa.selenium.By;

public class MessengerLoginPage extends BasePage{

    private By errorMessage = By.xpath("//div[contains(text(),'Incorrect Email')]");

    public String getErrorMessage() {
        return getTextFromElement(errorMessage);
    }
}
