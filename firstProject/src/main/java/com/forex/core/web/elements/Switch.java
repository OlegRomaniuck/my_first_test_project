package com.invest.core.web.elements;

import com.invest.core.util.Util_Logger;
import com.invest.core.web.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * Created by Tester3 on 30.09.2015.
 */
public class Switch extends WebComponent<Switch> {

    private String byElement;

    public Switch(WebDriver driver, String findByMethod) {
        super(driver, By.cssSelector(findByMethod));
        byElement = findByMethod;

    }
    public Switch (WebDriver driver, By findBy){
        super(driver, findBy);

    }


    public boolean getAttributeChecked() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String checked = jse.executeScript("return Ext.ComponentQuery.query('" + byElement + "')[0].checked").toString();
        Util_Logger.info("Found attribute checked in this button - " + checked);
        return !checked.equals("false");
    }

    public boolean getAttributeChecked1() {
        String script = "return window.getComputedStyle(document.querySelector('#info-prof-email .chBox'),':before').getPropertyValue('content')";
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String content = (String) js.executeScript(script);

        Util_Logger.info("Found attribute checked in this button - " + content );
        return !content.equals("OFF");
    }




}
