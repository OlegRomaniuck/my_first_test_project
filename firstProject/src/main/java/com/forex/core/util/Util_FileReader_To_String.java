package com.invest.core.util;

import org.apache.commons.io.IOUtils;

import java.io.*;


public class Util_FileReader_To_String {


    public String fileReaderToStringConverter(String cause) {
        String targetFileStr = null;

        FileInputStream fisTargetFile = null;
        try {
            fisTargetFile = new FileInputStream(new File("./src/test/resources/logs/loggingTiger.log"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
        try {
            targetFileStr = IOUtils.toString(fisTargetFile, "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                System.out.println("close resources");
                fisTargetFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return targetFileStr + "\n And REASON : \n" + cause;
    }


    public void cleanLogger() {

        PrintWriter pw = null;
        try {
            pw = new PrintWriter("./src/test/resources/logs/loggingTiger.log");
            pw.print("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {

            pw.close();
        }

    }
}
