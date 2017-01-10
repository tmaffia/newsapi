package com.thomasmaffia.newsapi.objects;

/**
 * Created by tmaffia on 1/10/17.
 */
public enum SortingMethod {
    TOP("top"),
    LATEST("latest"),
    POPULAR("popular");

    private final String method;

    SortingMethod(final String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }
}
