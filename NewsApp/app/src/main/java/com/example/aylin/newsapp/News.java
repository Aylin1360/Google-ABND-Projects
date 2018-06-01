package com.example.aylin.newsapp;

public class News {

    private String mTitle;
    private String mCategory;
    private String mAuthor;
    private String mDate;
    private String mUrl;

    public News(String title, String category, String author, String date, String url) {
        this.mTitle = title;
        this.mCategory = category;
        this.mAuthor = author;
        this.mDate = date;
        this.mUrl = url;
    }


    public String getmTitle() {
        return mTitle;
    }

    public String getmCategory() {
        return mCategory;
    }

    public String getmAuthor() {
        return mAuthor;
    }

    public String getmDate() {
        return mDate;
    }

    public String getmUrl() {
        return mUrl;
    }
}
