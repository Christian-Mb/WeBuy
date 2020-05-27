package com.example.webuy.core.utils;

import java.text.Normalizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringsUtils {

    public static String normalize(String stringToNormalize) {
        if (stringToNormalize == null) {
            return null;
        }
        return Normalizer.normalize(stringToNormalize, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "").toLowerCase();
    }

    public static String[] splitDistanceValueAndLastUnit(String text) {
        if (text == null) {
            return null;
        }

        String pattern = "([0-9,. ]+)([a-z]+)";

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(text);
        if (m.find()) {
            String[] strings = new String[2];
            if (m.groupCount() == 2) {
                strings[0] = m.group(1);
                strings[1] = m.group(2);
                return strings;
            } else {
                return text.split(pattern);
            }
        }
        return text.split(pattern);
    }


    public static String[] splitDurationValueAndUnit(String text) {
        if (text == null) {
            return null;
        }
        String[] split = text.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");

        String[] result = new String[2];
        if (split.length > 4) {
            result = null;
        } else if (split.length == 4) {
            result[0] = split[0] + split[1] + split[2];
            result[1] = split[3];
        } else if (split.length == 3) {
            result[0] = split[0] + split[1];
            result[1] = split[2];
        } else if (split.length == 2) {
            result[0] = split[0];
            result[1] = split[1];
        } else if (split.length == 1) {
            result[0] = split[0];
            result[1] = "";
        } else if (split.length == 0) {
            result = null;
        }
        return result;
    }
}
