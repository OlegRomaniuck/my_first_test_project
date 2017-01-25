package com.invest.core.web.elements;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Tester3 on 10.03.2016.
 */
public class ListSomeElements {
    List<String> list_text = new ArrayList<>();
    protected WebDriver driver;
    protected final By findByMethod;

    public ListSomeElements(WebDriver driver, By by) {
        this.driver = driver;
        this.findByMethod = by;

    }

    public List<WebElement> getListElementsFluent() {


        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(10, TimeUnit.SECONDS)
                .pollingEvery(500, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);

        return wait.until(new Function<WebDriver, List<WebElement>>() {
            public List<WebElement> apply(WebDriver webDriver) {
                return driver.findElements(findByMethod);
            }
        });
    }

    public List<WebElement> getListElementsWait() {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(findByMethod)));
        return driver.findElements(findByMethod);
    }

    public List<String> getTextFromListElement() {
        List<WebElement> elemnt_list = getListElementsWait();

        for (WebElement ele : elemnt_list) {

            list_text.add(ele.getText().replaceAll("\\n", " "));
        }
        return list_text;
    }

}
