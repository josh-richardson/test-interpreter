package com.joshuarichardson;

import java.util.regex.Pattern;

/**
 * Created by Joshua on 20/09/2016.
 */
public class Utils {
    public static boolean isNumeric(String in) {
        return in.length() > 0 && !in.chars().filter(x -> !Character.isDigit(x)).findAny().isPresent();
    }

    public static boolean isSpace(String in) {
        return in.length() > 0 && !in.chars().filter(x -> !Character.isSpaceChar(x)).findAny().isPresent();
    }

    public static boolean isAlphaNumeric(String in) {
        return in.length() > 0 && !Pattern.compile("[^a-zA-Z0-9]").matcher(in).find();
    }

    public static boolean isAlpha(String in) {
        return in.length() > 0 && !Pattern.compile("[^a-zA-Z]").matcher(in).find();
    }

}
