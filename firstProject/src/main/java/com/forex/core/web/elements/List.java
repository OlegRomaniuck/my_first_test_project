package com.invest.core.web.elements;

import com.invest.core.web.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class List extends WebComponent<List> {

    public List(WebDriver driver, By findByMethod) {
        super(driver, findByMethod);
    }

    // You should create element by xpath with ending <ul> element

    public List chooseByPosition(int position){
        WebDriverWait wait= new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(getWebElement()));
        java.util.List<WebElement> list = getWebElement().findElements(By.xpath("./li"));

        WebElement element = list.get(position - 1);
        Actions act = new Actions(driver);
        act.moveToElement(element).click(element).build().perform();
        return this;
    }

    public String getTextByPosition(int randomNumberCountry) {
        WebDriverWait wait= new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(getWebElement()));
        java.util.List<WebElement> list = getWebElement().findElements(By.xpath("./li"));
        WebElement element = list.get(randomNumberCountry);
        return element.getText();
    }
}
