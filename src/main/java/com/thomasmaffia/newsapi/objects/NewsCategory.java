package com.thomasmaffia.newsapi.objects;

/**
 * Created by tmaffia on 1/10/17.
 */
public enum NewsCategory {
    BUSINESS("business"),
    ENTERTAINMENT("entertainment"),
    GAMING("gaming"),
    GENERAL("general"),
    MUSIC("music"),
    SCIENCE_NATURE("science-and-nature"),
    SPORT("sport"),
    TECHNOLOGY("technology");

    private final String categoryId;

    NewsCategory(final String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryId() {
        return categoryId;
    }
}
