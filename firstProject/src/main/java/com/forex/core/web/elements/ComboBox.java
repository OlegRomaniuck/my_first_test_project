package com.invest.core.web.elements;

import com.invest.core.web.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ComboBox extends WebComponent<ComboBox> {

    public ComboBox(WebDriver driver, By findByMethod) {
        super(driver, findByMethod);
    }
}
