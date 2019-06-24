package framework;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import stepdefinition.SharedSD;

import java.util.concurrent.TimeUnit;

/**
 * Created by JanCakal
 * mvn antrun:run@create test site
 */
public class BasePage {

	// This is the most common wait function used in selenium
	public static WebElement webAction(final By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(SharedSD.getDriver())
				.withTimeout(15, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.ignoring(ElementNotFoundException.class)
				.withMessage(
						"Webdriver waited for 15 seconds but still could not find the element therefore Timeout Exception has been thrown");

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});

		return element;
	}

	public static void clickOn(By locator) {
		webAction(locator).click();
	}
	public void clickOnDrksky(By locator) {

		try {
			SharedSD.getDriver().findElement(locator).click();
		}catch (NoSuchElementException e) {
			Assert.fail("Elemnet is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}
	}


	public void setValue(By locator, String value) {
		webAction(locator).sendKeys(value);
	}

	public static String getTextFromElement(By locator) {
		return webAction(locator).getText();
	}

	public boolean isElementDisplayedErrorMessage(By locator) {
		return webAction(locator).isDisplayed();
	}

	public boolean isElementDisplayed(By locator) {
		return webAction(locator).isDisplayed();
	}

	public boolean isElementSelected(By locator) {
		return webAction(locator).isSelected();
	}

	public static boolean messengerIsDisplayedInvalid(By locator) {
		return webAction(locator).isDisplayed();
	}

	public void selectFromDropdown(By locator, String dropdownText) {
		WebElement month = webAction(locator);
		Select selectMonth = new Select(month);
		//select element by visible text
		selectMonth.selectByVisibleText(dropdownText);
	}

	public void selectFromDropdown(By locator, int index) {
		WebElement month = webAction(locator);
		Select selectMonth = new Select(month);
		//select element by index
		selectMonth.selectByIndex(index);
	}

	//  2) To click an element
	public static void clickOnAmazon(By locator){
		webAction(locator).click();
	}


	//  3) To set value to an input field
	public void setValueToInputField(By locator, String value){
		webAction(locator).sendKeys(value);
	}

	public static void mouseOverAndClick(By hoverElementLocator,By clickLocator) throws InterruptedException {

		WebElement element = SharedSD.getDriver().findElement(hoverElementLocator);

		Actions action = new Actions(SharedSD.getDriver());
		action.moveToElement(element).build().perform();
		Thread.sleep(2000);

		clickOn(clickLocator);
		Thread.sleep(2000);
	}




}
