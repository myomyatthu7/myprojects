package com.example.stone.learning;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.stone.learning.custom_list.My_Custom_Dictionary_List;
import com.example.stone.learning.custom_list.My_Custom_List;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;

public class Dictionary extends AppCompatActivity implements TextWatcher, AdapterView.OnItemClickListener {
    ListView lvDictionary;

    String [] aryDic;
    My_Custom_Dictionary_List myCustomDictionaryList;
    TextToSpeech tts;

    ArrayList<String>wordsAryList= new ArrayList<>();
    ArrayList<String>phoneticAryList= new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dictionary);
        lvDictionary = findViewById(R.id.lvDictionary);
        EditText etSearch = findViewById(R.id.etSearch);

        // Aunt - အိမ် - /aɪn/
        aryDic = readFile().split("\n");
        //Collections.addAll(orgAry, aryDic);

        for (String s : aryDic) {
            String [] ary = s.split("/");
            String words = ary[0]+"="+ary[1];
            String phonetic = ary[2];
            wordsAryList.add(words);
            phoneticAryList.add(phonetic);
        }

//        for (int w =0;w<aryDic.length;w++) {
//            orgAry.add(aryDic[w]);
//        }
        //myCustomList = new My_Custom_List(getApplicationContext(),orgAry);

        myCustomDictionaryList = new My_Custom_Dictionary_List(getApplicationContext(),wordsAryList,phoneticAryList);
        //lvDictionary.setAdapter(myCustomDictionaryList);
        lvDictionary.setAdapter(myCustomDictionaryList);
        etSearch.addTextChangedListener(this);
        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.US);
                }
            }
        });
        lvDictionary.setOnItemClickListener(this);
        lvDictionary.setOnItemClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String[] ary = String.valueOf(lvDictionary.getItemAtPosition(position)).split("=");
        String eng = ary[0];
        //Toast.makeText(this, String.valueOf(lvDictionary.getSelectedItemPosition()), Toast.LENGTH_SHORT).show(); မရ
        //Toast.makeText(this, String.valueOf(lvDictionary.getCheckedItemPosition()), Toast.LENGTH_SHORT).show(); မရ
        //Toast.makeText(this, String.valueOf(myCustomDictionaryList.getItem(position)), Toast.LENGTH_SHORT).show(); search ကဟာပဲရ
//        String ary = String.valueOf(lvDictionary.getItemAtPosition(position));
//        String eng =ary.substring(0,ary.indexOf("-"));
        //Toast.makeText(this, String.valueOf(lvDictionary.getItemAtPosition(position)), Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, eng, Toast.LENGTH_SHORT).show();
        tts.speak(eng,TextToSpeech.QUEUE_FLUSH,null);
    }
    private String readFile() {
        StringBuilder stringBuilderDic = new StringBuilder();
        AssetManager assetManager = getAssets();
        try {
            InputStream is = assetManager.open("dictionary.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = br.readLine())!=null) {
                stringBuilderDic.append(line+"\n");
            }
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilderDic.toString();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        //String search = etSearch.getText().toString();
        ArrayList<String>searchWords = new ArrayList<>();
        ArrayList<String>searchPhonetic = new ArrayList<>();
        for (String value: aryDic) {
            if (value.contains(s.toString())) {
                String []ary = value.split("/");
                searchWords.add(ary[0]+"="+ary[1]);
                searchPhonetic.add(ary[2]);
            }
        }

//        ArrayList<String>searchMyaAry = new ArrayList<>();
//        for (String value : aryDic) {
//            if (value.contains(s.toString().toLowerCase())) {
//                searchMyaAry.add(value);
//            }
//        }
        myCustomDictionaryList = new My_Custom_Dictionary_List(getApplicationContext(),searchWords,searchPhonetic);
        lvDictionary.setAdapter(myCustomDictionaryList);
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
