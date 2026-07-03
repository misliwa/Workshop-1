package pl.coderslab.constants;

import java.time.format.DateTimeFormatter;

public class FormatConstants {
    public static String APP_DATE_FORMAT_AS_STRING = "yyyy-MM-dd";

    public static DateTimeFormatter APP_DATE_FORMAT = DateTimeFormatter.ofPattern(APP_DATE_FORMAT_AS_STRING);
}
