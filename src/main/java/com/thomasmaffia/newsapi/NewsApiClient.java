package com.thomasmaffia.newsapi;


import com.thomasmaffia.newsapi.objects.Country;
import com.thomasmaffia.newsapi.objects.Language;
import com.thomasmaffia.newsapi.objects.NewsCategory;
import com.thomasmaffia.newsapi.objects.SortingMethod;
import com.thomasmaffia.newsapi.request.INewsApiRequest;
import com.thomasmaffia.newsapi.request.NewsApiRequest;

/**
 * Created by tmaffia on 1/9/17.
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

    public String getSources() {
        INewsApiRequest request = new NewsApiRequest(apiKey);
        return request.getSources();
    }

    public String getSources(final NewsCategory newsCategory) {
        INewsApiRequest request = new NewsApiRequest(apiKey);
        return request.getSources(newsCategory);
    }

    public String getSources(final Language language) {
        INewsApiRequest request = new NewsApiRequest(apiKey);
        return request.getSources(language);
    }

    public String getSources(final Country country) {
        INewsApiRequest request = new NewsApiRequest(apiKey);
        return request.getSources(country);
    }

    public String getApiKey() {
        return apiKey;
    }
}
