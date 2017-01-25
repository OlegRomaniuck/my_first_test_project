package com.invest.core.web.tools;

import com.invest.core.util.Util_Logger;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class ToolRobotTypeKeys {

    public static void uploadFileByPath(String path) {
        Util_Logger.Log.info("Save path to file in clipboard - " + path);
        StringSelection stringSelection = new StringSelection(path);
        // add our path to img in clipboard
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        try {
            Util_Logger.Log.info("Create robot clicker");
            Robot robot = new Robot();
            robot.delay(1000);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);  // press ctrl + 'V' (sent path to input form)
            Util_Logger.Log.info("Command: Ctrl + 'V' pressed");
            Thread.sleep(1000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER); // press enter
            Util_Logger.Log.info("Command: Enter pressed");
            Thread.sleep(2000);
            robot.delay(1000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER); // press enter again
            Util_Logger.Log.info("Command: Enter again pressed");
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER); // press enter again
            Util_Logger.Log.info("Command: Enter again pressed");
            robot.delay(1000);
            Thread.sleep(5000);
        } catch (AWTException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void pasteSomething(String text){
        StringSelection stringSelection = new StringSelection(text);
        // add our path to img in clipboard
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        try {
            Util_Logger.Log.info("Create robot clicker");
            Robot robot = new Robot();
            robot.delay(1000);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);  // press ctrl + 'V' (sent path to input form)
            Util_Logger.Log.info("Command: Ctrl + 'V' pressed");
            Thread.sleep(1000);
        } catch (AWTException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void chooseFromListByCount(int randomNumberCountry) {
        try {
            Util_Logger.Log.info("Create robot clicker");
            Robot robot = new Robot();
            robot.delay(1000);
            for (int i = 0; i < randomNumberCountry; i++) {
                robot.keyPress(KeyEvent.VK_DOWN);
                Thread.sleep(200);
            }
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            Util_Logger.Log.info("Command: ENTER pressed");
            Thread.sleep(3000);
        } catch (AWTException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
