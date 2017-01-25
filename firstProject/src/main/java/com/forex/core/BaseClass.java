package com.invest.core;

import com.invest.core.util.Util_FileReader_To_String;
import com.invest.core.util.Util_Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static com.invest.core.DriverMaster.getDriver;


public class BaseClass {

    public static WebDriver driver;

    @BeforeSuite
    @Parameters({"browser"})
    public void setUp(@Optional("firefox") String browser) {
        Util_Logger.startTestSuite();


        driver = getDriver(browser);
        Util_Logger.info("START WEB BROWSER");


        driver.manage().window().setSize(new Dimension(1400, 1000));

    }


    @BeforeClass
    public void StartLogger(){
        String className = this.getClass().getName();
        Util_Logger.startTest("START TEST > " + className );

    }

    @AfterClass
    public void CleanLoger(){
        Util_Logger.startTest("CLEAN LOGGER");
        new Util_FileReader_To_String().cleanLogger();
    }

    @AfterSuite
    public void tearDown() {
        driver.manage().deleteAllCookies();
        Util_Logger.info("QUITE FROM BROWSER");
        driver.quit();
    }

}
