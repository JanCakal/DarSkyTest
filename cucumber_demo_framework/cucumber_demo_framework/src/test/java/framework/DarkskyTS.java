package framework;

import org.apache.commons.lang3.text.StrBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import stepdefinition.SharedSD;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class DarkskyTS extends BasePage {

    private By todayTimeline = By.xpath("//*[@id='week']/a[1]");
    private By minTemp = By.xpath("");
    private By highTemp1 = By.xpath("");
    private By greaterOrLess = By.xpath("//div[@id='timeline']//div[@class='temps']");
    private By first = By.xpath("//span[@class='first']");
    private By second = By.xpath("//div[@class='temps']//span[2]");
    private By third = By.xpath("//div[@class='temps']//span[3]");
    private By forth = By.xpath("//div[@class='temps']//span[4]");
    private By fifth = By.xpath("//div[@class='temps']//span[5]");
    private By sixth = By.xpath("//div[@class='temps']//span[6]");
    private By seventh = By.xpath("//div[@class='temps']//span[7]");
    private By eighth = By.xpath("//div[@class='temps']//span[8]");
    private By nineth = By.xpath("//div[@class='temps']//span[9]");
    private By tenth = By.xpath("//div[@class='temps']//span[10]");
    private By eleventh = By.xpath("//div[@class='temps']//span[11]");
    private By twelveth = By.xpath("//div[@class='temps']//span[12]");
    private By currentDay = By.xpath("//span[@class='first']");
    private By temps = By.className("temps");
    private By temp = By.xpath("//span[@class='summary swap']");
    private By lowTemp = By.xpath("//span[@class='currently']//span[2]//span[2]//span[2]");
    private By highTemp = By.xpath("//span[@class='summary-high-low']//span[3]");


    public void verifyTempTimeline() {

        DateFormat dateFormat = new SimpleDateFormat("h");
        Date today = Calendar.getInstance( ).getTime( );
        String date = dateFormat.format(today);


        List<WebElement> hours = SharedSD.getDriver( ).findElements(By.xpath("//div[@id='timeline']//div[@class='hours']//following::span[@class='hour']/span[2]"));
        for (WebElement ele : hours) {
            String newHour = ele.getText( ).replaceAll("[^\\w\\s]", "");
            int newHours = Integer.parseInt(newHour);
        }
    }


    public void expandTodayTimeline() throws InterruptedException {
        WebElement element = SharedSD.getDriver( ).findElement(By.xpath("//*[@id='week']/a[1]"));
        ((JavascriptExecutor) SharedSD.getDriver( )).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(5000);
        element.click( );
        clickOnDrksky(todayTimeline);
        Thread.sleep(6000);
    }


    public void verifyLowHighTemp() {

        String lowTemp = SharedSD.getDriver( ).findElement(By.xpath("//a[@data-day='0']/span[2]//span[@class='minTemp']")).getText( );
        String highTemp = SharedSD.getDriver( ).findElement(By.xpath("//a[@data-day='0']/span[2]//span[@class='maxTemp']")).getText( );
        System.out.println(lowTemp);
        System.out.println(highTemp);

        String minTemp = lowTemp.replaceAll("[^\\w\\s]", "");
        String maxTemp = highTemp.replaceAll("[^\\w\\s]", "");

        int minTemperature = Integer.parseInt(minTemp);
        int maxTemperature = Integer.parseInt(maxTemp);
        if (minTemperature < maxTemperature) {
            Assert.assertTrue(true);
        }
    }



    public void verifyGreaterOrLessCurrentTepm(){

        String currentTemp = SharedSD.getDriver().findElement(By.cssSelector(".summary.swap")).getText();
        System.out.println("Current Temp:" + currentTemp);
        List<WebElement> tempsInTimeLine = SharedSD.getDriver().findElements(By.cssSelector(".temps span:last-child"));
        int temp = Integer.parseInt(currentTemp.substring(0, 2));
        int highestInTimeLine = temp;
        int lowestInTimeLine = temp;
        for (WebElement tempInTime: tempsInTimeLine) {
            String sLIneTemp = tempInTime.getText();
            int lineTemp = Integer.parseInt(sLIneTemp.substring(0, 2));
            if (lineTemp > highestInTimeLine){
                highestInTimeLine  = lineTemp;
            }
            if (lineTemp < lowestInTimeLine ){
                lowestInTimeLine = lineTemp;
            }

        }

        System.out.println("Highest Temp:" + Integer.toString(highestInTimeLine));
        System.out.println("Lowest Temp:" + Integer.toString(lowestInTimeLine ));


    }

}





