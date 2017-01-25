package com.invest.core.web.pages;

import com.invest.core.util.Util_Logger;
import com.invest.core.web.WebPage;

import org.openqa.selenium.WebDriver;

public class AboutService extends WebPage<AboutService> {

    private static final String Page_Url = "https:/manu.html";

    public AboutService(WebDriver driver) {
        super(driver);

    }

    @Override
    public AboutService load() {
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


}