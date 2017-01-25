package com.invest.core.web.pages;

import com.invest.core.util.Util_Logger;
import com.invest.core.web.WebPage;
import com.invest.core.web.elements.ListSomeElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class Blog extends WebPage<Blog> {

    private static final String Page_Url = "forex-blog.html";

    public Blog(WebDriver driver) {
        super(driver);

    }

    @Override
    public Blog load() {
        driver.get(Page_Url);
        Util_Logger.showUrl(Page_Url);
        return this.waitUntilAvailable();

    }

    @Override
    public boolean isAvailable() {
        Util_Logger.showUrl(Page_Url);
        Util_Logger.showUrl("Check that all elements present on the page!");
        return blogsIsAvailable();
    }

    public boolean blogsIsAvailable() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[starts-with(@id, 'blog-panel-')]/div[starts-with(@id, 'blog-list-')]")));
        List<WebElement> blogs = new ListSomeElements(driver, By.xpath("//div[starts-with(@id, 'blog-panel-')]/div[starts-with(@id, 'blog-list-')]/div[1]/div/div[@class='blogItem']")).getListElementsFluent();
        if (blogs.size() < 1) {
            Util_Logger.info("Blogs are not available");
            return false;
        }
        Util_Logger.info("Blogs are available");
        return true;
    }


}