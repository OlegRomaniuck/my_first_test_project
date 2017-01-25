package com.invest.core.web.pages;

import com.invest.core.util.Util_Logger;
import com.invest.core.web.WebPage;
import com.invest.core.web.elements.Lable;
import com.invest.core.web.elements.ListSomeElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class TechnicalAnalysis extends WebPage<TechnicalAnalysis> {

    private static final String Page_Url = "https://";

    public TechnicalAnalysis(WebDriver driver) {
        super(driver);
    }

    @Override
    public TechnicalAnalysis load() {
        driver.get(Page_Url);
        Util_Logger.showUrl(Page_Url);
        return this.waitUntilAvailable();

    }

    @Override
    public boolean isAvailable() {
        Util_Logger.showUrl(Page_Url);
        Util_Logger.showUrl("Check that all elements present on the page!");
        return analysisCurrencyFilterIsAvailable() && LabelGeneralTitle().isAvailable();
    }

    public Lable LabelGeneralTitle() {
        Util_Logger.Log.info("Trying to find Label title h1 Technical Analysis");
        return new Lable(driver, By.xpath("//div[starts-with(@id, 'analysis-panel-')]//h1"));
    }

    public boolean analysisCurrencyFilterIsAvailable() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[starts-with(@id, 'analysis-currency-filter-')]/div[starts-with(@id, 'form-')]")));
        return driver.findElement(By.xpath("//div[starts-with(@id, 'analysis-currency-filter-')]/div[starts-with(@id, 'form-')]")).isDisplayed();
    }

}