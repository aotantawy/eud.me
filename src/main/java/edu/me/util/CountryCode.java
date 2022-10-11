package edu.me.util;

import java.util.Arrays;
import java.util.Locale;

public final class CountryCode {
    private static final String[] countryISOCodes = Locale.getISOCountries();

    public static boolean isIsoCountryCode(String isoCountryCode) {
        return Arrays.asList(countryISOCodes).contains(isoCountryCode);
    }
}
