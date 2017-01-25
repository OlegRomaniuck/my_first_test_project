package com.invest.core.web.elements;

import com.invest.core.web.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Tester3 on 01.10.2015.
 */
public class ElementArrow extends WebComponent<ElementArrow> {
    public ElementArrow(WebDriver driver, By findByMethod) {
        super(driver, findByMethod);
    }
}
