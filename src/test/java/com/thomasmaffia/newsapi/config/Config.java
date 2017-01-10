package com.thomasmaffia.newsapi.config;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by tmaffia on 1/10/17.
 */
public class Config {

    @JsonProperty
    private String apiKey;

    public Config() {
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
