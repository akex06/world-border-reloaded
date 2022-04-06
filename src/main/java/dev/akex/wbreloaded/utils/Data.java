package dev.akex.wbreloaded.utils;

import dev.akex.wbreloaded.Wbreloaded;

public class Data {
    public static boolean isInt(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }

    public static boolean isLong(String input) {
        try {
            Long.parseLong(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static Long toLong(String input) {
        return Long.parseLong(input);
    }

    public static String lang() {
        return Wbreloaded.getInstance().getConfig().getString("language");
    }
}
