package com.invest.core.web;

import com.invest.core.util.Util_Logger;
import org.openqa.selenium.*;

/**
 * Created by Tester3 on 30.09.2015.
 */
public abstract class WebComponent<T extends WebComponent<T>> extends Component<T> {

    protected final By findByMethod;

    public WebComponent(WebDriver driver, By findByMethod) {
        super(driver);
        this.findByMethod = findByMethod;
    }

   protected WebElement getWebElement() {
        return driver.findElement(findByMethod);
    }

    @Override
    public boolean isAvailable() {
        try {
            boolean avaliable = getWebElement().isDisplayed() && getWebElement() != null;
            if(avaliable){
                return true;
            } else{
                Util_Logger.info("Element is NOT! Available - return false - " + getWebElement());
                return false;
            }
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            Util_Logger.info("Exception No SuchElement! Element is not Available - return false");
            return false;
        }
    }

    public void click() {
        getWebElement().click();
    }

    public String getText() {
        if (this.isAvailable()) {
            return getWebElement().getText();
        }
        throw new NoSuchElementException("Not Found elements for get Text from it");
    }
}
