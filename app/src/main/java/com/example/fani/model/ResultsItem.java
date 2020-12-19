package com.example.fani.model;

import com.google.gson.annotations.SerializedName;

public class ResultsItem{

    @SerializedName("end_date")
    private String endDate;

    @SerializedName("image_url")
    private String imageUrl;

    @SerializedName("mal_id")
    private Integer malId;

    @SerializedName("synopsis")
    private String synopsis;

    @SerializedName("title")
    private String title;

    @SerializedName("type")
    private String type;

    @SerializedName("url")
    private String url;

    @SerializedName("rated")
    private String rated;

    @SerializedName("score")
    private Double score;

    @SerializedName("members")
    private Integer members;

    @SerializedName("airing")
    private Boolean airing;

    @SerializedName("episodes")
    private Integer episodes;

    @SerializedName("start_date")
    private String startDate;

    public void setEndDate(String endDate){
        this.endDate = endDate;
    }

    public String getEndDate(){
        return endDate;
    }

    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }

    public String getImageUrl(){
        return imageUrl;
    }

    public void setMalId(Integer malId){
        this.malId = malId;
    }

    public Integer getMalId(){
        return malId;
    }

    public void setSynopsis(String synopsis){
        this.synopsis = synopsis;
    }

    public String getSynopsis(){
        return synopsis;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public String getUrl(){
        return url;
    }

    public void setRated(String rated){
        this.rated = rated;
    }

    public String getRated(){
        return rated;
    }

    public void setScore(Double score){
        this.score = score;
    }

    public Double getScore(){
        return score;
    }

    public void setMembers(Integer members){
        this.members = members;
    }

    public Integer getMembers(){
        return members;
    }

    public void setAiring(Boolean airing){
        this.airing = airing;
    }

    public boolean isAiring(){
        return airing;
    }

    public void setEpisodes(Integer episodes){
        this.episodes = episodes;
    }

    public Integer getEpisodes(){
        return episodes;
    }

    public void setStartDate(String startDate){
        this.startDate = startDate;
    }

    public String getStartDate(){
        return startDate;
    }
}