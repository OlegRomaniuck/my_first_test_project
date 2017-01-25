package com.invest.core.web.elements;

import com.invest.core.util.Util_Logger;
import com.invest.core.web.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Tester3 on 09.03.2016.
 */
public class Hint extends WebComponent<Hint> {
    public Hint(WebDriver driver, By findByMethod) {
        super(driver, findByMethod);
    }


public  String getValueOfHint(){

    WebElement valueHint= getWebElement().findElement(By.xpath("./following-sibling::*"));
    Util_Logger.info("Value are :  "+ valueHint.getText());
    return valueHint.getText();

}


}
