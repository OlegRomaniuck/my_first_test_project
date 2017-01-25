package com.invest.core.util;

import org.apache.log4j.Logger;

/**
 * Created by Tester3 on 14.03.2016.
 */
public class Util_Logger {


    // Initialize Log4j logs
    public final static Logger Log = Logger.getLogger("fileCon");


    // This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite
    public static void startTestCase(String sTestCaseName) {
        Log.info("*******************************************");
        Log.info(">>>>>>>>>>>>>>>>>>>>>>" + sTestCaseName + "<<<<<<<<<<<<<<<<<<<<<<");
        Log.info("*****************************************");
    }

    //This is to print log for the ending of the test case
    public static void endTestCase() {
        Log.info("XXXXXXXXXXXXXXXXXXXXXXX             " + "-FINISH TEST CASE-" + "             XXXXXXXXXXXXXXXXXXXXXX");
    }

    public static void startTestSuite() {
        Log.info("");
        Log.info("/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\");
        Log.info("");
    }
    public static void startTest(String sTestName) {

        Log.info("****************************************");
        Log.info(">>>>>>>>>>>>>>>>>>>>>>" + sTestName + "<<<<<<<<<<<<<<<<<<<<<<");
        Log.info("****************************************");

    }

    public static void showUrl(String url){

        Log.info(">>>>>>>>>  WE PRESENT ON THIS URL:>>>> "+url+  "  <<<<<<<<<<<<<<<<<<<<<<<<<");
    }

    // Need to create these methods, so that they can be called
    public static void info(String message) {
        Log.info(message);
    }

    public static void warn(String message) {
        Log.warn(">>>>>" + message + "<<<<<");
    }

    public static void error(String message) {
        Log.error("!!!!!!!!!!!!!!!!!!ERROR!!!!!!!!!!!!!!!!!! " + message + " !!!!!!!!!!!!!!!!!!ERROR!!!!!!!!!!!!!!!!!!");
    }

    public static void fatal(String message) {
        Log.fatal("!!!!!!!!!!!!!!!<><><>FATAL<><><>!!!!!!!!!!!!!!! " + message + " !!!!!!!!!!!!!!!<><><>FATAL<><><>!!!!!!!!!!!!!!!");
    }

    public static void debug(String message) {
        Log.debug(message);
    }

}
