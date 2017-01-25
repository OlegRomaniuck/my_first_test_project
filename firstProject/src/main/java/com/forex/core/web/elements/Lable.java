package com.invest.core.web.elements;

import com.invest.core.util.Util_Logger;
import com.invest.core.web.WebComponent;
import com.invest.core.web.customwait.CustomWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Lable extends WebComponent<Lable> {

    public Lable(WebDriver driver, By findByMethod) {
        super(driver, findByMethod);
    }

    @Override
    public String getText() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(getWebElement()));
        String text = super.getText();
        Util_Logger.Log.info("Found this label - " + text);
        return text;
    }

    public String getTextByAttribute() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(getWebElement()));
        String text = getWebElement().getAttribute("value");
        Util_Logger.Log.info("Found this label - " + text);
        return text;
    }
}
