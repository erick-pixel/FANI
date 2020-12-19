package com.example.fani.model;

import java.util.ArrayList;
import com.google.gson.annotations.SerializedName;

public class RootNarutoModel{

    @SerializedName("request_hash")
    private String requestHash;

    @SerializedName("last_page")
    private Integer lastPage;

    @SerializedName("request_cached")
    private Boolean requestCached;

    @SerializedName("request_cache_expiry")
    private Integer requestCacheExpiry;

    @SerializedName("results")
    private ArrayList<ResultsItem> results;

    public void setRequestHash(String requestHash){
        this.requestHash = requestHash;
    }

    public String getRequestHash(){
        return requestHash;
    }

    public void setLastPage(Integer lastPage){
        this.lastPage = lastPage;
    }

    public Integer getLastPage(){
        return lastPage;
    }

    public void setRequestCached(Boolean requestCached){
        this.requestCached = requestCached;
    }

    public boolean isRequestCached(){
        return requestCached;
    }

    public void setRequestCacheExpiry(Integer requestCacheExpiry){
        this.requestCacheExpiry = requestCacheExpiry;
    }

    public Integer getRequestCacheExpiry(){
        return requestCacheExpiry;
    }

    public void setResults(ArrayList<ResultsItem> results){
        this.results = results;
    }

    public ArrayList<ResultsItem> getResults(){
        return results;
    }
}