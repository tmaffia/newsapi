package com.thomasmaffia.newsapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.thomasmaffia.newsapi.config.Config;
import com.thomasmaffia.newsapi.objects.Country;
import com.thomasmaffia.newsapi.objects.Language;
import com.thomasmaffia.newsapi.objects.NewsCategory;
import com.thomasmaffia.newsapi.objects.SortingMethod;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by tmaffia on 1/9/17.
 */
public class ClientTest {
    private String apiKey;
    private String source;
    private SortingMethod sortingMethod;
    private NewsCategory newsCategory;
    private Language language;
    private Country country;

    public ClientTest() {
    }

    @Before
    public void setup() {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            Config config = mapper.readValue(
                    Thread.currentThread().getContextClassLoader().getResource("config.yaml"),
                    Config.class);
            this.apiKey = config.getApiKey();
            this.source = config.getSource();
            this.sortingMethod = matchSortingMethod(config.getSortingMethod());
            this.newsCategory = matchCategory(config.getNewsCategory());
            this.language = matchLanguage(config.getLanguage());
            this.country = matchCountry(config.getCountry());
        } catch (IOException e) {
            System.out.println("Failed to get Config file for API Key");
            e.printStackTrace();
        }
    }

    // Defaults to latest
    private SortingMethod matchSortingMethod(final String sortingMethod) {
        for (SortingMethod method : SortingMethod.values()) {
            if (method.getMethod().equals(sortingMethod)) {
                return method;
            }
        }
        return SortingMethod.LATEST;
    }

    // Defaults to science and nature
    private NewsCategory matchCategory(final String categoryId) {
        for (NewsCategory category : NewsCategory.values()) {
            if (category.getCategoryId().equals(categoryId)) {
                return category;
            }
        }
        return NewsCategory.SCIENCE_NATURE;
    }

    // Defaults to English
    private Language matchLanguage(final String languageCode) {
        for (Language lang : Language.values()) {
            if (lang.getLanguageCode().equals(languageCode)) {
                return lang;
            }
        }
        return Language.ENGLISH;
    }

    // Defaults to United States
    private Country matchCountry(final String countryCode) {
        for (Country country : Country.values()) {
            if (country.getCountryCode().equals(countryCode)) {
                return country;
            }
        }
        return Country.UNITED_STATES;
    }

    @Test
    public void test_getArticles() {
        Client client = new Client(apiKey);
        String result = client.getArticles(source, "");
        Assert.assertNotNull(result);
        System.out.println(result);
    }

    @Test
    public void test_getSources() {
        Client client = new Client(apiKey);
        String result = client.getSources(language);
        Assert.assertNotNull(result);
        System.out.println(result);
    }
}
