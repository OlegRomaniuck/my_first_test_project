package com.invest.core.web.elements;

import com.invest.core.util.Util_Logger;
import com.invest.core.web.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Tester3 on 30.09.2015.
 */
public class Button extends WebComponent<Button> {

    private By byElement;

    public Button(WebDriver driver, By findByMethod) {
        super(driver, findByMethod);
        byElement = findByMethod;
    }

    public Button clickOn() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(byElement));
        wait.until(ExpectedConditions.visibilityOf(getWebElement()));
        getWebElement().click();
        Util_Logger.info("Click on the button");
        return this;
    }

    public Button clickByAction() {
        Actions actions = new Actions(driver);
        actions.moveToElement(getWebElement()).click().build().perform();
        Util_Logger.info("Click on the button by Action");
        return this;
    }

    public void sendKeys(CharSequence... keysToSend){
        getWebElement().sendKeys(keysToSend);
    }
}