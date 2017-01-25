package com.invest.core.web.pages;

import com.invest.core.util.Util_Logger;
import com.invest.core.web.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class EconomicCalendar extends WebPage<EconomicCalendar> {

    private static final String Page_Url = "/ru/economi.html";

    public EconomicCalendar(WebDriver driver) {
        super(driver);
    }

    @Override
    public EconomicCalendar load() {
        driver.get(Page_Url);
        Util_Logger.showUrl(Page_Url);
        return this.waitUntilAvailable();

    }

    @Override
    public boolean isAvailable() {
        Util_Logger.showUrl(Page_Url);
        Util_Logger.showUrl("Check that all elements present on the page!");
        return true;
    }

    public boolean economicCalendarIsAvailable(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='inlineblock']")));
        return driver.findElement(By.xpath("//div[@class='inlineblock']")).isDisplayed();
    }


}