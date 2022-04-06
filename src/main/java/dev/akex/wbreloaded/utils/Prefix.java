package dev.akex.wbreloaded.utils;

import dev.akex.wbreloaded.Wbreloaded;

public class Prefix {
    public static String prefix() {
        return Color.translate(Wbreloaded.getInstance().getConfig().getString("prefix"));
    }
}
