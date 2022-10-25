package ru.isupden.lab2.util;

public class DataValidator {
    public static boolean validateX(String coord) {
        return validateCoord(parseCoord(coord), -5, 3);
    }

    public static boolean validateY(String coord) {
        return validateCoord(parseCoord(coord), -5, 3);
    }

    public static boolean validateR(String coord) {
        return validateCoord(parseCoord(coord), 1, 4);
    }

    private static Double parseCoord(String coord) {
        try {
            return Double.parseDouble(coord);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private static boolean validateCoord(Double coord, int min, int max) {
        return coord != null && min < coord && coord < max;
    }
}
