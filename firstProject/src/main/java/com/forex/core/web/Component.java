package com.invest.core.web;

import org.openqa.selenium.WebDriver;


/**
 * Created by Tester3 on 30.09.2015.
 */
public abstract class Component<T extends Component<T>> {


    public abstract boolean isAvailable();

    protected WebDriver driver;

    public Component(WebDriver driver) {
        this.driver = driver;
    }

    public T waitUntilAvailable() {

        return new Wait<T>().forComponent((T) this).toBeAvailable();
    }
}
