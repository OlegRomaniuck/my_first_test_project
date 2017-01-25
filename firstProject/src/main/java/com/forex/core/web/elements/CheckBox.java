package com.invest.core.web.elements;

import com.invest.core.util.Util_Logger;
import com.invest.core.web.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CheckBox extends WebComponent<CheckBox> {

    private By byElement;

    public CheckBox(WebDriver driver, By findByMethod) {
        super(driver, findByMethod);
        byElement = findByMethod;
    }

    public CheckBox activate() {

        WebElement checkBox = getWebElement();
        if(!checkBox.isSelected()){
            ((JavascriptExecutor)driver).executeScript("arguments[0].checked = true;", checkBox);
        }
        Util_Logger.Log.info("Activated!");
        return this;
    }

    public CheckBox unActivate() {

        WebElement checkBox = getWebElement();
        if(checkBox.isSelected()){
            ((JavascriptExecutor)driver).executeScript("arguments[0].checked = false;", checkBox);
        }
        Util_Logger.Log.info("Dis activated!");
        return this;
    }

}
