package com.invest.core.web.elements;

import com.invest.core.web.Component;
import com.invest.core.web.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Tester3 on 26.10.2015.
 */
public class SomeData  extends WebComponent<SomeData>{


    public SomeData(WebDriver driver, By findByMethod) {
        super(driver, findByMethod);
    }


}