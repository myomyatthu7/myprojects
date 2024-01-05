package java.stone.allinone;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TableLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.stone.allinone.library.Custm_List;
import java.util.ArrayList;
import java.util.Locale;

public class MyTabHost extends AppCompatActivity implements AdapterView.OnItemClickListener, TabHost.OnTabChangeListener {
    TabHost tabHost;
    Custm_List custmList;

    StringBuilder sb;
    ArrayList<String> arrayListWord = new ArrayList<>();
    ArrayList<String> arrayListPho = new ArrayList<>();

    ArrayList<String>searchWords = new ArrayList<>();
    String [] array;
    TextToSpeech tts;
    ListView lvDic;
    String tabChange="One";
    //ArrayList<String>arrayLists = new ArrayList<>();
    TableLayout tableOut;
    MyDictionary myDictionary;
    FragmentManager fm;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_host);

        tabHost = findViewById(R.id.tHost);
        tabHost.setup();

        TabHost.TabSpec spec = tabHost.newTabSpec("One");
        spec.setContent(R.id.linear1);
        spec.setIndicator("MyDictionary");
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("Two");
        spec.setContent(R.id.linear2);
        spec.setIndicator("Common Word");
        tabHost.addTab(spec);


        lvDic = findViewById(R.id.lvDic);
        lvDic.setOnItemClickListener(this);

        tableOut = findViewById(R.id.tbCom);
        Com_Word cw = new Com_Word();
        cw.readFiles(MyTabHost.this,tableOut);

        myDictionary = new MyDictionary(MyTabHost.this,lvDic);
        myDictionary.showDic();

        tabHost.setOnTabChangedListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        tts = new TextToSpeech(MyTabHost.this, status -> {
            if (status != TextToSpeech.ERROR) {
                tts.setLanguage(Locale.US);
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        tts.speak(myDictionary.itemClicked(position),TextToSpeech.QUEUE_FLUSH,null);
        if (position == 1) {
            fm = getSupportFragmentManager();
            Dic_Frg df = new Dic_Frg();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.lout_dic_frg,df,"Frg");
            ft.commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getDelegate().getMenuInflater();
        inflater.inflate(R.menu.actionbar_menu,menu);
        myDictionary.createMenu(menu,tabChange);
//        MenuItem mItem = menu.findItem(R.id.search);
//        SearchView searchView = (SearchView) mItem.getActionView();
//        if (searchView != null) {
//            searchView.setQueryHint("Search Here");
//            searchView.setOnQueryTextListener( new SearchView.OnQueryTextListener() {
//                @Override
//                public boolean onQueryTextSubmit(String query) {
//                    return false;
//                }
//
//                @Override
//                public boolean onQueryTextChange(String newText) {
//                    myDictionary.searchText(newText,tabChange);
//                    return true;
//                }
//            });
//        }

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public void onTabChanged(String tabId) {
        //ToastMsg.toastMsg(this,tabId);
        tabChange = tabId;
    }
}
