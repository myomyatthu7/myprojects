package java.stone.allinone.frgment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

import java.stone.allinone.R;


public class homefrg extends Fragment implements View.OnClickListener {

    View v;
    EditText etSearch;
    WebView webView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_homefrg, container, false);
         webView = v.findViewById(R.id.webView);
        Button goBack = v.findViewById(R.id.goBack);
        Button goforward = v.findViewById(R.id.goforward);
        Button refresh = v.findViewById(R.id.refresh);
        Button clearHistory = v.findViewById(R.id.clearHistory);
        etSearch = v.findViewById(R.id.eTextSearch);
        Button search = v.findViewById(R.id.search);
        goBack.setOnClickListener(this);
        goforward.setOnClickListener(this);
        refresh.setOnClickListener(this);
        clearHistory.setOnClickListener(this);
        search.setOnClickListener(this);
        webView.setWebViewClient(new ownBrowser());
        webView.getSettings().setJavaScriptEnabled(true); // to set javascript (Youtude)
        webView.getSettings().setLoadWithOverviewMode(true); // to load in over view mode
        webView.getSettings().setUseWideViewPort(true); // to set the view port
       // webView.loadUrl("https://www.google.com/");
        return v;
    }

    @Override
    public void onClick(View v) {
        String text = etSearch.getText().toString().toLowerCase();
        if (v.getId() == R.id.search) {
            if (text.isEmpty()) {} else
                //String url = text;
                webView.loadUrl("https://"+text+".com");
        } else if (v.getId() == R.id.goBack)
            if (webView.canGoBack()) webView.goBack();
          else if (v.getId() == R.id.goforward)
            if (webView.canGoForward()) webView.goForward();
          else if (v.getId() == R.id.refresh)
            webView.reload();
          else if (v.getId() == R.id.clearHistory) {
              webView.clearHistory();
        }
    }
}