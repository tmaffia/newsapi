package com.thomasmaffia.newsapi;


import com.thomasmaffia.newsapi.objects.Language;
import com.thomasmaffia.newsapi.request.NewsAPIRequest;

/**
 * Created by java on 1/9/17.
 */
public class Client {
    private final String apiKey;

    public Client(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getArticles(final String source, final String sort) {
        NewsAPIRequest request = new NewsAPIRequest(apiKey);
        return request.getArticles(source);
    }

    public String getSources(final Language language) {
        NewsAPIRequest request = new NewsAPIRequest(apiKey);
        return request.getSources(language);
    }

    public String getApiKey() {
        return apiKey;
    }
}
