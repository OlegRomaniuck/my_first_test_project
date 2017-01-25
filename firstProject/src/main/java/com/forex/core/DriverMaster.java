package com.invest.core;

import com.invest.core.util.Util_Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Tester3 on 30.09.2015.
 */
public class DriverMaster {

    private DriverMaster() {

    }

    public static WebDriver getDriver(String driverKey) {
        BrowserType browser = BrowserType.get(driverKey);
        WebDriver driver;
        switch (browser) {
            case FIREFOX:
                DesiredCapabilities capability = DesiredCapabilities.firefox();
                ProfilesIni profile = new ProfilesIni();
                String profileName = "profileToolsQA";
                FirefoxProfile ffProfile = profile.getProfile(profileName);
                if (ffProfile == null) {
                    ffProfile = new FirefoxProfile();
                    Util_Logger.info("Profile " + profileName + " for Firefox was NOT FOUND on you computer. Set up default profile");
                } else {
                    Util_Logger.info("Profile " + profileName + " for Firefox was found on you computer. Set up this profile");
                }
                    capability.setCapability(FirefoxDriver.PROFILE, ffProfile);
                capability.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
                driver = new FirefoxDriver(capability);
                Util_Logger.info("Created webDriver for Firefox browser");
                break;
            case CHROME:
                driver = new ChromeDriver();
                break;
            default:
                driver = new FirefoxDriver();
                break;
        }
        return driver;
    }
}
