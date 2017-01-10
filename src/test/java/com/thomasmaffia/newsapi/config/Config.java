package com.thomasmaffia.newsapi.config;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by tmaffia on 1/10/17.
 */
public class Config {

    @JsonProperty
    private String apiKey;

    @JsonProperty
    private String source;

    @JsonProperty
    private String sortingMethod;

    @JsonProperty
    private String newsCategory;

    @JsonProperty
    private String language;

    @JsonProperty
    private String country;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSortingMethod() {
        return sortingMethod;
    }

    public void setSortingMethod(String sortingMethod) {
        this.sortingMethod = sortingMethod;
    }

    public String getNewsCategory() {
        return newsCategory;
    }

    public void setNewsCategory(String newsCategory) {
        this.newsCategory = newsCategory;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
