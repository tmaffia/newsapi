package com.thomasmaffia.newsapi.objects;

/**
 * Created by tmaffia on 1/10/17.
 */
public enum Country {
    AUSTRALIA("au"),
    GERMANY("de"),
    UNITED_KINGDOM("gb"),
    INDIA("in"),
    ITALY("it"),
    UNITED_STATES("us");

    private final String countryCode;

    Country(final String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return countryCode;
    }
}
