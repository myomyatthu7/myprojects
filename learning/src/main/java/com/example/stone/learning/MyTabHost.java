package com.example.stone.learning;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MyTabHost extends Activity implements AdapterView.OnItemClickListener, View.OnClickListener {
    TabHost tabHost;
    ListView lvApp;
    ArrayList<String>appAryList = new ArrayList<>();
    Button btnNewTab;
    ArrayList<String>num = new ArrayList<String >();
    int z = 1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.taphost);
        tabHost = findViewById(R.id.tHost);
        tabHost.setup();


        TabHost.TabSpec tSpec = tabHost.newTabSpec("One");
        tSpec.setContent(R.id.tab1);
        tSpec.setIndicator("App");
        tabHost.addTab(tSpec);

        tSpec = tabHost.newTabSpec("Two");
        tSpec.setContent(R.id.tab2);
        tSpec.setIndicator("Widget");
        tabHost.addTab(tSpec);

        tSpec = tabHost.newTabSpec("Three");
        tSpec.setContent(R.id.tab3);
        tSpec.setIndicator("Home");
        tabHost.addTab(tSpec);

        View vApp = tabHost.getTabWidget().getChildAt(0);
        View vWidget = tabHost.getTabWidget().getChildAt(1);
        View vHome = tabHost.getTabWidget().getChildAt(2);
            vHome.setBackgroundColor(Color.GRAY);
            vWidget.setBackgroundColor(Color.GRAY);
            vApp.setBackgroundColor(getResources().getColor(R.color.start_light_blue));

        tabHost.setOnTabChangedListener(tabId -> {
            String dd = String.valueOf(z);
            //Toast.makeText(this, String.valueOf(tabId), Toast.LENGTH_SHORT).show();
                if (tabId.contentEquals("One")) {
                    vHome.setBackgroundColor(Color.GRAY);
                    vWidget.setBackgroundColor(Color.GRAY);
                    vApp.setBackgroundColor(getResources().getColor(R.color.start_light_blue));
                } else if (tabId.contentEquals("Two")) {
                    vApp.setBackgroundColor(Color.GRAY);
                    vHome.setBackgroundColor(Color.GRAY);
                    vWidget.setBackgroundColor(getResources().getColor(R.color.center_light_purple));
                } else if (tabId.contentEquals("Three")) {
                    vApp.setBackgroundColor(Color.GRAY);
                    vWidget.setBackgroundColor(Color.GRAY);
                    vHome.setBackgroundColor(getResources().getColor(R.color.end_light_blue));
                } else if (tabId.contains(dd)) {
                    Toast.makeText(this, "One", Toast.LENGTH_SHORT).show();
                }
        });
        lvApp = findViewById(R.id.lvApp);
        getAllApplication();
        lvApp.setOnItemClickListener(this);
        btnNewTab = findViewById(R.id.btnNewTap);
        btnNewTab.setOnClickListener(this);
    }

//    private void getAllApplication() {
//        PackageManager pm = getPackageManager();
//        Intent intent = new Intent(Intent.ACTION_MAIN);
//        intent.addCategory(Intent.CATEGORY_LAUNCHER);
//        List<ResolveInfo> appList = pm.queryIntentActivities(intent,PackageManager.PERMISSION_GRANTED);
//        for (ResolveInfo info :appList) {
//            appAryList.add(info.activityInfo.applicationInfo.loadLabel(pm).toString());
//        }
//        lvApp.setAdapter(new ArrayAdapter<>(MyTabHost.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,appAryList));
//    }
    private void getAllApplication() {
        PackageManager pm = getPackageManager();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        //intent.setAction(Intent.ACTION_MAIN);
        List<ResolveInfo>appList = pm.queryIntentActivities(intent,PackageManager.PERMISSION_GRANTED);
        for (ResolveInfo info : appList) {
            appAryList.add(info.activityInfo.applicationInfo.loadLabel(pm).toString());
        }
        lvApp.setAdapter(new ArrayAdapter<>(MyTabHost.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,appAryList));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Vibrator vbr = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vbr.vibrate(100);
        Toast.makeText(this, String.valueOf(appAryList.get(position)), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        TextView tvHello = new TextView(MyTabHost.this);
        TabHost.TabSpec tabSpec = tabHost.newTabSpec(String.valueOf(z));
        //num.add(String.valueOf(z));
        z++;
        //Toast.makeText(this, String.valueOf(num), Toast.LENGTH_SHORT).show();
        tabSpec.setIndicator("Add New");
//        tabSpec.setContent(new TabHost.TabContentFactory() {
//            @Override
//            public View createTabContent(String tag) {
//                tvHello.setText("Hello");
//                return tvHello;
//            }
//        });
        tabSpec.setContent(new TabHost.TabContentFactory() {
            @Override
            public View createTabContent(String tag) {
                return tvHello;
            }
        });

        tabHost.addTab(tabSpec);
        View view = tabHost.getTabWidget().getChildAt(z);
        view.setBackgroundColor(Color.GRAY);
    }
}






