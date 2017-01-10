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
}
