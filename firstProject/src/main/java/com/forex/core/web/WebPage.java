package com.invest.core.web;

import org.openqa.selenium.WebDriver;

/**
 * Created by Tester3 on 30.09.2015.
 */
public abstract class WebPage <T extends WebPage<T>> extends Component<T>  {
    public WebPage(WebDriver driver ){
        super(driver);
    }
    public abstract T load();
    public T loadAndWaitUntilAvailable(){
        load();
        waitUntilAvailable();
        return waitUntilAvailable();
    }
}
