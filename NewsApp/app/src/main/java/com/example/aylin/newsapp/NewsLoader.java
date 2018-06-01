package com.example.aylin.newsapp;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

public class NewsLoader extends AsyncTaskLoader<List<News>> {

    private String mUrl;

    public NewsLoader(Context context, String url){
        super(context);
        this.mUrl = url;
    }

    @Override
    protected void onStartLoading(){
        forceLoad();
    }

    @Override
    public List<News> loadInBackground() {
        if (mUrl == null)
            return null;

        List<News> news = null;
        news = QueryUtils.fetchNewsData(mUrl);

        return news;
    }

}
