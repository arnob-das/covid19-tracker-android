package com.arnobdas.covid19_tracker_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView mywebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mywebview = (WebView) findViewById(R.id.WebViewId);
        mywebview.loadUrl("https://cutt.ly/gbSzGqG");

        mywebview.setWebViewClient(new WebViewClient());

    }
}
