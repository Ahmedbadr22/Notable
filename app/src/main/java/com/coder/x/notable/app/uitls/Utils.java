package com.coder.x.notable.app.uitls;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utils {

    public static String getCurrentLocalDate() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return localDate.format(formatter);
    }
}
