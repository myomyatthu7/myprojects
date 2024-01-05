package com.example.stone.a002_calculator;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.stone.a002_calculator.list.MyCustomDictionaryList;
import com.example.stone.a002_calculator.list.MyCustomDictionaryList1;
import com.example.stone.a002_calculator.list.MyCustomList;
import com.example.stone.a002_calculator.list.MyCustomList1;
import com.example.stone.a002_calculator.mylibrary.BigToastMsg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Locale;

public class Dictionary extends AppCompatActivity implements TextWatcher, AdapterView.OnItemClickListener {
    StringBuilder stringBuilder = new StringBuilder();
    EditText etSearch;
    String []ary;
    ListView listView;
    MyCustomDictionaryList myCustomDictionaryList;
    MyCustomDictionaryList1 myCustomDictionaryList1;
    TextToSpeech tts;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);
        listView = findViewById(R.id.tvText);
        ary = setText().split("\n");
        tts = new TextToSpeech(getApplicationContext(),status ->  {
                if (status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.US);
                }
        });
        myCustomDictionaryList1 = new MyCustomDictionaryList1(getApplicationContext(),ary);
        listView.setAdapter(myCustomDictionaryList1);
        etSearch = findViewById(R.id.etSearch);
        etSearch.addTextChangedListener(this);
        listView.setOnItemClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //BigToastMsg.bigToastMsg(getApplicationContext(),String.valueOf(myCustomDictionaryList1.getItem(position)));
        //BigToastMsg.bigToastMsg(getApplicationContext(),String.valueOf(listView.getItemAtPosition(position)));
        //BigToastMsg.bigToastMsg(getApplicationContext(),String.valueOf(ary[position]));
        String[] engOnly = ary[position].split("-");
        String eng = engOnly[0];
        //BigToastMsg.bigToastMsg(getApplicationContext(),String.valueOf(eng));
        tts.speak(eng,TextToSpeech.QUEUE_FLUSH,null);
    }

//    @Override
//    protected void onPause() {
//        if (tts != null) {
//            tts.stop();
//            tts.shutdown();
//        }
//        super.onPause();
//    }

    private String setText() {
        AssetManager assetManager = getAssets();
        try {
            InputStream is = assetManager.open("dictionary.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = br.readLine())!=null) {
                stringBuilder.append(line+"\n");
            }
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        ArrayList<String> searchAry = new ArrayList<>();
        for (int i =0;i<ary.length;i++) {
            if (ary[i].contains(s.toString())) {
                searchAry.add(ary[i]);
            }
        }
        myCustomDictionaryList = new MyCustomDictionaryList(getApplicationContext(),searchAry);
        listView.setAdapter(myCustomDictionaryList);
    }

    @Override
    public void afterTextChanged(Editable s) {

    }


}
