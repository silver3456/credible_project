package com.usa.web.utils;

import java.time.LocalDate;

public class StringRandomGenerator {

    public static String generateEmail() {
        String firstName = "Alex";
        String dayOfMonth = String.valueOf(LocalDate.now().getDayOfMonth());
        long timeStamp = System.currentTimeMillis();
        return String.format("%s_%s_%s@credible.com", firstName, dayOfMonth, timeStamp);
    }

}
