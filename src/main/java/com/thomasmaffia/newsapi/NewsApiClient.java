package com.thomasmaffia.newsapi;


import com.thomasmaffia.newsapi.objects.Language;
import com.thomasmaffia.newsapi.objects.SortingMethod;
import com.thomasmaffia.newsapi.request.INewsApiRequest;
import com.thomasmaffia.newsapi.request.NewsApiRequest;

/**
 * Created by java on 1/9/17.
 */
public class NewsApiClient {
    private final String apiKey;

    public NewsApiClient(String apiKey) {
        this.apiKey = apiKey;
    }


    public String getArticles(final String source) {
        INewsApiRequest request = new NewsApiRequest(apiKey);
        return request.getArticles(source);
    }

    public String getArticles(final String source, final SortingMethod sort) {
        INewsApiRequest request = new NewsApiRequest(apiKey);
        return  request.getArticles(source, sort);
    }

    public String getSources(final Language language) {
        INewsApiRequest request = new NewsApiRequest(apiKey);
        return request.getSources(language);
    }

    public String getApiKey() {
        return apiKey;
    }
}
