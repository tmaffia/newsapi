package com.thomasmaffia.newsapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.thomasmaffia.newsapi.config.Config;
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
        } catch (IOException e) {
            System.out.println("Failed to get Config file for API Key");
            e.printStackTrace();
        }
    }

    @Test
    public void test_getArticles() {
        Client client = new Client(apiKey);
        String result = client.getArticles(source, "");
        Assert.assertNotNull(result);
        System.out.print(result);
    }
}
