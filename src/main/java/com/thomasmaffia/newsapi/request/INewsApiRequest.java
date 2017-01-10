package com.thomasmaffia.newsapi.request;

import com.thomasmaffia.newsapi.objects.*;

/**
 * Created by tmaffia on 1/10/17.
 */
public interface INewsApiRequest {

    String getArticles(final String source);
    String getArticles(final String source, final SortingMethod sortingMethod);

    String getSources();
    String getSources(final NewsCategory newsCategory);
    String getSources(final Language language);
    String getSources(final Country country);
    String getSources(final NewsCategory newsCategory, final Language language);
    String getSources(final NewsCategory newsCategory, final Country country);
    String getSources(final Language language, final Country country);
    String getSources(final NewsCategory newsCategory, final Language language, final Country country);
}
