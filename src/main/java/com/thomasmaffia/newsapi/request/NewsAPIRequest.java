package com.thomasmaffia.newsapi.request;

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
public class NewsAPIRequest {
    private static final Logger logger = LoggerFactory.getLogger(NewsAPIRequest.class);
    private static final String ARTICLES_URL = "https://newsapi.org/v1/articles";
    private static final String SOURCES_URL = "https://newsapi.org/v1/sources";
    private static final String USER_AGENT = "Mozilla/5.0";
    private HttpURLConnection connection = null;
    private final String apiKey;

    public NewsAPIRequest(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getArticles(final String newsSources) {
        String finalUrl = ARTICLES_URL
                + "?source=" + newsSources + "&apiKey=" + apiKey;
        return execute(finalUrl);
    }

    private String execute(final String urlString) {
        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", USER_AGENT);
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