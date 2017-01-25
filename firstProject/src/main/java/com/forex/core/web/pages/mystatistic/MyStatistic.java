package com.invest.core.web.pages.mystatistic;

import com.invest.core.model.Traider;
import com.invest.core.util.Util_Logger;
import com.invest.core.web.WebPage;
import com.invest.core.web.elements.ListSomeElements;
import com.invest.core.web.pages.PopUps.TradersPopUpPage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class MyStatistic extends WebPage<MyStatistic> {

    private static final String URL_MYSTATISTIC = "https:/en/vbv.html";

    public MyStatistic(WebDriver driver) {
        super(driver);
    }

    @Override
    public MyStatistic load() {
        driver.get(URL_MYSTATISTIC);
        Util_Logger.showUrl(URL_MYSTATISTIC);
        return this;
    }

    @Override
    public boolean isAvailable() {
        Util_Logger.showUrl(URL_MYSTATISTIC);
        return gridIsAvailable();
    }

    public boolean gridIsAvailable() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[starts-with(@id,'statistic-notification')]//div[@class='x-grid-item-container']")));
        List<WebElement> gridMyForecast_element = new ListSomeElements(driver, By.xpath("//div[starts-with(@id,'statistic-notification')]//div[@class='x-grid-item-container']/table")).getListElementsFluent();
        if (gridMyForecast_element.size() < 1) {
            Util_Logger.info("Grid for my statistic is not available");
            return false;
        }
        Util_Logger.info("Grid my statistic is available");
        return true;
    }

    public Traider getFirstTraiderInGrid() {
        Util_Logger.Log.info("Trying to get first trader in grid statistic");
        WebElement firstTraiderInGrid = driver.findElement(By.xpath("//div[starts-with(@id,'statistic-notification')]//div[@class='x-grid-item-container']/table[1]"));

        int myBalanceInt;
        // Если вложений в трейдера нету - то колонка My balance будет пустая (соответственно локатор NoSuchElementException) -> присваиваем баланс 0
        try {
            String myBalance = firstTraiderInGrid.findElement(By.xpath("./tbody/tr[1]//span[@class='value_small']")).getText();
            myBalanceInt = Integer.parseInt(myBalance.replaceAll("[^\\d.]", ""));
        } catch (NoSuchElementException e) {
            myBalanceInt = 0;
        }
        String name = firstTraiderInGrid.findElement(By.xpath("./tbody/tr[1]//span[@class='name_trader']")).getText();
        int numberAccount = Integer.parseInt(firstTraiderInGrid.findElement(By.xpath("./tbody/tr[1]//div[@class='value_container']/a")).getText());
        Util_Logger.Log.info("Found data about first trader in grid - Name: " + name + ", numberAccount: " + numberAccount + ", My Invested money: " + myBalanceInt);
        return new Traider(name, numberAccount, myBalanceInt);
    }

    public TradersPopUpPage openTraderByNameInActualGrid(String name) {
        Util_Logger.Log.info("Trying open Trader by name - " + name);
        List<WebElement> list = driver.findElements(By.xpath("//div[starts-with(@id,'statistic-notification')]//span[@class='name_trader']/.."));
        for (WebElement el : list) {
            if (el.getText().equals(name)) {
                Util_Logger.Log.info("Found this trader, trying click on him");
                Actions act = new Actions(driver);
                act.moveToElement(el.findElement(By.xpath("./img"))).click(el.findElement(By.xpath("./img"))).build().perform();
                Util_Logger.Log.info("Clicked on the trader, wait for Trader PopUm page");
                return new TradersPopUpPage(driver).waitUntilAvailable();
            }
        }
        throw new NoSuchElementException("Not found trader in the Grid - " + name);
    }
}
