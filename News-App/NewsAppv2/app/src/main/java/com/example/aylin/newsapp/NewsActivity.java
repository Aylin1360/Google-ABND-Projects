package com.example.aylin.newsapp;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<News>>{

    private static final String REQUEST_URL = "https://content.guardianapis.com/search?order-by=newest&show-tags=contributor&page-size=15&q=politics&api-key=801cbc55-3f8d-4d27-8aab-af10b1c7631d";
    private  static final int LOADER_ID = 0;
    private NewsAdapter newsAdapter;
    private TextView mEmptyStateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_list);

        ListView newsList = findViewById(R.id.list);

        mEmptyStateTextView = findViewById(R.id.blank);
        newsList.setEmptyView(mEmptyStateTextView);

        newsAdapter = new NewsAdapter(this, new ArrayList<News>());
        newsList.setAdapter(newsAdapter);

        newsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                News clicked = newsAdapter.getItem(i);

                assert clicked != null;
                Uri uri = Uri.parse(clicked.getmUrl());

                Intent website = new Intent(Intent.ACTION_VIEW, uri);

                PackageManager packageManager = getPackageManager();
                List<ResolveInfo> resolveInfos = packageManager.queryIntentActivities(website, packageManager.MATCH_DEFAULT_ONLY);

                if(resolveInfos.size() > 0){
                    startActivity(website);
                }else {
                    Toast.makeText(NewsActivity.this,"Download a browser", Toast.LENGTH_LONG).show();
                }
            }
        });

        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);

        assert  connectivityManager != null;
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

       if(networkInfo!= null && networkInfo.isConnected()){
           LoaderManager loaderManager = getLoaderManager();
           loaderManager.initLoader(LOADER_ID, null, this);
       }else{
           View progress = findViewById(R.id.progress);
           progress.setVisibility(View.GONE);

           Toast.makeText(NewsActivity.this,"No internet connection", Toast.LENGTH_LONG).show();
       }
    }

   @Override
   public Loader<List<News>> onCreateLoader(int id, Bundle args){
       SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);

       // getString retrieves a String value from the preferences. The second parameter is the default value for this preference.
       String minPage = sharedPrefs.getString(
               getString(R.string.settings_min_page_key),
               getString(R.string.settings_min_page_default));

       String orderBy  = sharedPrefs.getString(
               getString(R.string.settings_order_by_key),
               getString(R.string.settings_order_by_default)
       );

       // parse breaks apart the URI string that's passed into its parameter
       Uri baseUri = Uri.parse(REQUEST_URL);

       // buildUpon prepares the baseUri that we just parsed so we can add query parameters to it
       Uri.Builder uriBuilder = baseUri.buildUpon();

       // Append query parameter and its value. For example, the `format=geojson`
       uriBuilder.appendQueryParameter("format", "json");
       uriBuilder.appendQueryParameter("page", minPage);
       uriBuilder.appendQueryParameter("order-by", "newest");
       //uriBuilder.appendQueryParameter("order-by", orderBy);

       // Return the completed uri `http://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&limit=10&minmag=minMagnitude&orderby=time
       return new NewsLoader(this, uriBuilder.toString());
   }

    @Override
    public void onLoadFinished(Loader<List<News>> loader, List<News> news) {
        // Hide loading indicator because the data has been loaded
        View loadingIndicator = findViewById(R.id.progress);
        loadingIndicator.setVisibility(View.GONE);

        // Clear the adapter of previous news data
        newsAdapter.clear();

        // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
        // data set. This will trigger the ListView to update.
        if (news != null && !news.isEmpty()) {
            newsAdapter.addAll(news);

            if(news.isEmpty()){
                String messageUser = "No news found";
                warning(messageUser);
            }
        }
    }

    @Override
    public void onLoaderReset(Loader<List<News>> loader) {
        // Loader reset, so we can clear out our existing data.
        newsAdapter.clear();
    }

    private void warning(String messageToUser)
    {
        View prog = findViewById(R.id.progress);
        prog.setVisibility(View.GONE);

        mEmptyStateTextView.setVisibility(View.VISIBLE);
        mEmptyStateTextView.setText(messageToUser);
    }

    @Override
    // This method initialize the contents of the Activity's options menu.
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the Options Menu we specified in XML
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent settingsIntent = new Intent(this, SettingsActivity.class);
            startActivity(settingsIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
