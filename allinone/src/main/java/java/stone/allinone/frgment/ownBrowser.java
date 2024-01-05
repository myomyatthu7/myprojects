package java.stone.allinone.frgment;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ownBrowser extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }
}
