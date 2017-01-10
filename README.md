# newsapi
Java Library for accessing newsapi.org

# Basic Usage

``` java
NewsApiClient client = new NewsApiClient("YOUR_API_KEY");
List<Articles> articles = client.getArticles("techcrunch", "popular");
```

Powered by [News API](https://newsapi.org)
