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

    }

    public void load(){
        mywebview = (WebView) findViewById(R.id.WebViewId);
        mywebview.loadUrl("https://covid19-tracker-arnob.netlify.app//");

        WebSettings myWebviewSettings =mywebview.getSettings();
        myWebviewSettings.setJavaScriptEnabled(true);
        myWebviewSettings.setBuiltInZoomControls(false);
        myWebviewSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        myWebviewSettings.setDomStorageEnabled(true);

        mywebview.setWebViewClient(new WebViewClient());
    }

    @Override
    public void onBackPressed() {
        if (mywebview.canGoBack()){
            mywebview.goBack();
        }
        else {
            finish();
        }
    }
}
