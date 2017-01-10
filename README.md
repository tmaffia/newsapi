# News Api
Java Library for accessing newsapi.org

### NOTE: Unstable, in development



## Getting the library
clone and package as a jar dependency in your project. Remote repository support coming soon.

## Basic Usage
``` java
NewsApiClient client = new NewsApiClient("YOUR_API_KEY");
List<Source> sources = client.getSources("en", "us");
List<Article> articles = client.getArticles("techcrunch", "popular");
```

Powered by [News API](https://newsapi.org)
