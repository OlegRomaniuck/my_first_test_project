package com.invest.core.util;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.invest.core.BaseClass;
import com.invest.core.util.Util_FileReader_To_String;
import com.invest.core.util.Util_Logger;
import com.invest.core.web.webrequest.HttpRequest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.internal.TestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Map;

/**
 * Created by Tester on 09.03.2016.
 */
public class IInvokedListenerSeverity implements IInvokedMethodListener {

    private static String urlToScreenshotCloud = "";
    private String cloud_name = "";
    private String api_key = "";
    private String api_secret = "";

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        String SEVERITY = "";
        if (testResult.getStatus() == TestResult.FAILURE) {
            Util_Logger.info("Test RESULT - FAILURE");
            if (Arrays.asList(method.getTestMethod().getGroups()).contains("High")) {
                SEVERITY = "HIGH";
            } else if (Arrays.asList(method.getTestMethod().getGroups()).contains("Medium")) {
                SEVERITY = "MEDIUM";
            } else {
                SEVERITY = "LOW";
            }
            Util_Logger.info("Trying to send report in Vtiger with severity bug - " + SEVERITY);
            String title = method.getTestMethod().getMethodName();
            if(BaseClass.driver != null) {
                try {
                    takeScreenShot(title);
                } catch (Exception e) {
                    Util_Logger.info("Something wrong with taking exception - " + e.getMessage() );
                }
            }
            String testRusltAndLog = new Util_FileReader_To_String().fileReaderToStringConverter(testResult.getThrowable().fillInStackTrace().toString());
            new HttpRequest().sendPostWithParameter(title, SEVERITY, testRusltAndLog + "\n" + urlToScreenshotCloud);
        }
    }

    public void takeScreenShot(String name) throws Exception{
        String FolderForScreenShot = "ScreenShot";
        String time = new SimpleDateFormat("dd.MM.yyyy" + "_" + "HH.mm.SS").format(new java.util.Date());
        Util_Logger.info("Making ScreenShot right now!");
        File ScreenShot = ((TakesScreenshot) BaseClass.driver).getScreenshotAs(OutputType.FILE);
        String path = name + "_Time_" + time + "_.png";
        try {
            File file = new File(FolderForScreenShot, path);
            FileUtils.copyFile(ScreenShot, file);
            Util_Logger.info("Screenshot was saved on path - " + FolderForScreenShot + "\\" + path);
            urlToScreenshotCloud = pushScreenshotOnTheCloud(file);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (WebDriverException we) {
            Util_Logger.info("Can't get Screen Shot");
        }
    }

    public String pushScreenshotOnTheCloud(File file) {
        Util_Logger.info("Connecting to cloudinary (Cloud screenshots API)");
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloud_name,
                "api_key", api_key,
                "api_secret", api_secret));
        Map uploadResult = null;
        try {
            uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
            Util_Logger.info("Upload Screenshot: " + file + "with data connection: " + cloud_name + ", " + api_key + ", " + api_secret);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String urlToImgCloud = null;
        if (uploadResult != null) {
            urlToImgCloud = (String) uploadResult.get("url");
        }
        Util_Logger.info("Path in web to screenshot - " + urlToImgCloud);
        return urlToImgCloud;
    }
}
