package com.invest.core.web.customwait;

import com.google.common.base.Function;
import com.invest.core.util.Util_Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Tester3 on 07.03.2016.
 */
public class CustomWaits {

    private static final int DEFAULT_TIMEOUT = 4;

    public static final int DEFAULT_TIMEOUTS = 40000;
    public static final int DEFAULT_RETRY_DELAY = 10000;

    public ExpectedCondition<Boolean> customWaitElementDisappear(final WebDriver driver, final By locator, int timeoutSeconds) {


        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return !(driver.findElement(locator).isDisplayed());
                } catch (NoSuchElementException e) {
                    // Returns true because the element is not present in DOM. The
                    // try block checks if the element is present but is invisible.
                    return true;
                } catch (StaleElementReferenceException e) {
                    // Returns true because stale element reference implies that element
                    // is no longer visible.
                    return true;
                }
            }

        };
    }

    public void waitUntilWindowsClosefinal(WebDriver driver, int timeoutSeconds) throws org.openqa.selenium.NoSuchWindowException, TimeoutException {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(timeoutSeconds, TimeUnit.SECONDS)
                .pollingEvery(500, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);


        wait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return (d.getWindowHandles().size() == 1);
            }
        });


    }

    public boolean waitForElToBeRemove(WebDriver driver, final By by) {
        try {
            driver.manage().timeouts()
                    .implicitlyWait(0, TimeUnit.SECONDS);

            WebDriverWait wait = new WebDriverWait(driver,
                    DEFAULT_TIMEOUT);

            boolean present = wait
                    .ignoring(StaleElementReferenceException.class)
                    .ignoring(NoSuchElementException.class)
                    .until(ExpectedConditions.invisibilityOfElementLocated(by));

            return present;
        } catch (Exception e) {
            return false;
        } finally {
            driver.manage().timeouts()
                    .implicitlyWait(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        }
    }

    public WebElement customFindElement(final WebDriver driver, final By locator, int timeoutSeconds) throws org.openqa.selenium.TimeoutException {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(timeoutSeconds, TimeUnit.SECONDS)
                .pollingEvery(500, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);

        return wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver webDriver) {
                return driver.findElement(locator);
            }
        });
    }


    public WebElement waitUntilAvalible(final WebDriver driver, final By locator, int timeoutSeconds) {


        WebElement elemnt = new CustomWaits().customFindElement(driver, locator, timeoutSeconds);


        int timePassed = 0;
        while (timePassed < DEFAULT_TIMEOUTS) {
            if ((elemnt.isDisplayed()) && (elemnt != null)) {
                Util_Logger.info("element is visible and present ");
                return elemnt;
            }
            timePassed = timePassed + delay();
        }
        if (!(elemnt.isDisplayed()) || elemnt == null) {
            Util_Logger.info("element is not visible or present ");
            throw new TimeoutException("Timed out after " + DEFAULT_TIMEOUT + " waiting for component    " + this.getClass().getSimpleName());
        }
        return elemnt;
    }

    public void threadSleep(long milsec) {
        try {
            Util_Logger.info("Custom wait " + milsec + " milsec");
            Thread.sleep(milsec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private int delay() {
        try {
            Thread.sleep(DEFAULT_RETRY_DELAY);
            return DEFAULT_RETRY_DELAY;
        } catch (InterruptedException e) {

            throw new RuntimeException();
        }

    }

}

