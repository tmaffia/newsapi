package com.thomasmaffia.newsapi.request;

import com.thomasmaffia.newsapi.objects.Country;
import com.thomasmaffia.newsapi.objects.Language;
import com.thomasmaffia.newsapi.objects.NewsCategory;
import com.thomasmaffia.newsapi.objects.SortingMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by tmaffia on 1/9/17.
 */
public class NewsApiRequest implements INewsApiRequest {
    private static final Logger logger = LoggerFactory.getLogger(NewsApiRequest.class);
    private static final String ARTICLES_URL = "https://newsapi.org/v1/articles";
    private static final String SOURCES_URL = "https://newsapi.org/v1/sources";
    private static final String USER_AGENT = "Mozilla/5.0";
    private HttpURLConnection connection = null;
    private final String apiKey;

    public NewsApiRequest(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getArticles(final String source) {
        String finalUrl = ARTICLES_URL + "?source=" + source;
        return execute(finalUrl);
    }

    public String getArticles(String source, SortingMethod sortingMethod) {
        return null;
    }

    public String getSources() {
        return null;
    }

    public String getSources(NewsCategory newsCategory) {
        return null;
    }

    public String getSources(final Language language) {
        String finalUrl = SOURCES_URL + "?language=" + language.getLanguageCode();
        return execute(finalUrl);
    }

    public String getSources(Country country) {
        return null;
    }

    public String getSources(NewsCategory newsCategory, Language language) {
        return null;
    }

    public String getSources(NewsCategory newsCategory, Country country) {
        return null;
    }

    public String getSources(Language language, Country country) {
        return null;
    }

    public String getSources(NewsCategory newsCategory, Language language, Country country) {
        return null;
    }

    private String execute(final String urlString) {
        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", USER_AGENT);
            connection.setRequestProperty("X-Api-Key", apiKey);
            int responseCode = connection.getResponseCode();

            logger.debug("Request at URL: " + urlString);
            logger.debug("Reponse Code: " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();

        } catch (MalformedURLException e) {
            logger.error("Malformed URL: " + urlString);
            logger.error(e.toString());
        } catch (IOException e) {
            logger.error("IOException while opening URL Connection");
            logger.error(e.toString());
        }
        return null;
    }
}
