package com.example.firstactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewDemo extends AppCompatActivity {
    WebView webView;
    ProgressDialog pd;
    private static final String url="https://beginnersbook.com/";
  //  private static final String url1="https://developer.android.com/guide";
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_demo);
        webView = findViewById(R.id.webview);
        pd=new ProgressDialog(this);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.loadUrl(url);
      //  webView.loadUrl(url1);
        webView.setWebViewClient(new Browser());
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress < 100)
                {
                    pd.show();
                }
                else
                {
                    pd.dismiss();
                }
            }

        });
    }
    private class Browser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            webView.loadUrl(String.valueOf(request.getUrl()));
            return true;
        }
    }
    @Override
    public void onBackPressed() {
        if (webView!=null && webView.canGoBack())
        {
            webView.goBack();
        }
        else
        super.onBackPressed();
    }
}