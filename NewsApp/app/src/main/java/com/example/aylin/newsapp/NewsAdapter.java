package com.example.aylin.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class NewsAdapter extends ArrayAdapter<News> {

    public NewsAdapter(Context c, ArrayList<News> news){
        super(c, 0, news);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_main, parent, false);
        }

        News currentNews = getItem(position);
        TextView newsTitle = listItemView.findViewById(R.id.title);

        assert  currentNews != null;
        newsTitle.setText(currentNews.getmTitle());

        TextView newsCategory = listItemView.findViewById(R.id.category);
        newsCategory.setText(currentNews.getmCategory());

        TextView newsAuthor = listItemView.findViewById(R.id.author);
        newsAuthor.setText(currentNews.getmAuthor());

        TextView newsDate = listItemView.findViewById(R.id.date);
        newsDate.setText(currentNews.getmDate());

        SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy'T'HH:mm:ss", Locale.ENGLISH);
        SimpleDateFormat formatDate2 = new SimpleDateFormat("EE dd MMM yyyy", Locale.ENGLISH);

        try {
            Date date = formatDate.parse(currentNews.getmDate());

            String date2 = formatDate2.format(date);
            newsDate.setText(date2);
        }catch (ParseException e){
            e.printStackTrace();
        }


        return listItemView;
    }
}
