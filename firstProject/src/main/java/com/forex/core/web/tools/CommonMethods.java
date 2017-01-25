package com.invest.core.web.tools;

import java.text.DecimalFormat;
import java.util.Random;

public class CommonMethods {

    public static String getRandomString(final int length) {
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = (char) (r.nextInt(25) + 97);
            sb.append(c);
        }
        return sb.toString();
    }

    public static String getRandomNumber() {

        Random rand = new Random();
        int num1 = rand.nextInt(7) + 1;
        int num2 = rand.nextInt(7) + 1;
        int num3 = (rand.nextInt(7) + 1) * 100 + (rand.nextInt(8) * 10) + rand.nextInt(8);
        int num4 = rand.nextInt(743);
        int num5 = rand.nextInt(10000);

        DecimalFormat df1 = new DecimalFormat("0");
        DecimalFormat df3 = new DecimalFormat("000"); // 3 zeros
        DecimalFormat df4 = new DecimalFormat("0000"); // 4 zeros

        String phoneNumber = df1.format(num1) + df1.format(num2) + df3.format(num3) + df3.format(num4) + df4.format(num5);

        return phoneNumber;
    }

    public static String getOnlyNumbersFromString(String text){
        return text.replaceAll("[^\\d]", "");
    }

}
