package com.thomasmaffia.newsapi.objects;

/**
 * Created by tmaffia on 1/10/17.
 */
public enum Language {
    ENGLISH("en"),
    GERMAN("de"),
    FRENCH("fr");

    private String languageCode;

    Language(final String languageCode) {
        this.languageCode = languageCode;
    }

    public String getLanguageCode() {
        return languageCode;
    }
}
