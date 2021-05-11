package com.arnobdas.covid19_tracker_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView mywebview;
    SwipeRefreshLayout swip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swip = (SwipeRefreshLayout)findViewById(R.id.swip);
        swip.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                load();
            }
        });

        load();

    }

    public void load(){
        mywebview = (WebView) findViewById(R.id.WebViewId);
        mywebview.loadUrl("https://covid19-tracker-arnob.netlify.app//");

        WebSettings myWebviewSettings =mywebview.getSettings();
        myWebviewSettings.setJavaScriptEnabled(true);
        myWebviewSettings.setBuiltInZoomControls(false);
        myWebviewSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        myWebviewSettings.setDomStorageEnabled(true);

        mywebview.setWebViewClient(new WebViewClient(){


        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            mywebview.loadUrl("file:///android_assets/index.html");
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            swip.setRefreshing(false);
        }
        }
        );
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
