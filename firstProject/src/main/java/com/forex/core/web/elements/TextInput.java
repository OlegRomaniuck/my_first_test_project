package com.invest.core.web.elements;

import com.invest.core.util.Util_Logger;
import com.invest.core.web.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Tester3 on 30.09.2015.
 */
public class TextInput extends WebComponent<TextInput> {

    public TextInput(WebDriver driver, By findByMethod) {
        super(driver, findByMethod);
    }

    public TextInput inputText(String text) {

        waitInput();
        getWebElement().sendKeys(text);
        Util_Logger.Log.info("Input: \'" + text + "\' in this field");
        return this;
    }

    public TextInput inputTextByAction(String text) {
        //wait varoius text input
        waitInput();
        Actions builder = new Actions(driver);
        builder.moveToElement(getWebElement()).click(getWebElement());
        builder.sendKeys(getWebElement(), text).build().perform();
        Util_Logger.Log.info("Input: \'" + text + "\' in this field");
        return this;
    }

    public TextInput clearInput() {
        waitInput();
        getWebElement().clear();
        Util_Logger.Log.info("Clear Field");
        return this;
    }

    private void waitInput() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(getWebElement()));
        } catch (TimeoutException exept) {
            System.out.println("Expetion in input " + exept.getStackTrace());
        }

    }

    public String getTextContentFromInput() {
        waitInput();
        return getWebElement().getAttribute("textContent");
    }

    public String getValueFromInput() {
        waitInput();
        return getWebElement().getAttribute("value");
    }

    public void sendKeys(CharSequence... keysToSend){
        getWebElement().sendKeys(keysToSend);
    }


}


