package com.example.stone.learning;

import android.content.res.AssetManager;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Common_Words extends AppCompatActivity {
    TableLayout table_common_word;
    StringBuilder sb = new StringBuilder();
    ArrayList<String>arrayList= new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_word_table);
        table_common_word = findViewById(R.id.table_common_words);
        fileReading();
    }

    private void fileReading() {
        AssetManager am = getAssets();
        try {
            InputStream is = am.open("common_words.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line= br.readLine())!= null) {
                //arrayList.add(line);
                sb.append(line);
            }
                String [] ary = sb.toString().split(" ");
                for (int i =0;i<ary.length;i++) {
//                    String word = arrayList.get(i);
//                    createTable(word);
                    if (i%2 != 0) {
                        int j = i-1;
                        createTable(ary[j],ary[i]);
                    }
                }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            Toast.makeText(getApplicationContext(),arrayList.toString(),Toast.LENGTH_SHORT).show();
        }
    }

    private void createTable(String word,String words) {
        TableRow.LayoutParams params = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT);
        TextView tvCommon_word = new TextView(Common_Words.this);
        TextView tvCommon_words = new TextView(Common_Words.this);
        TableRow tableRow = new TableRow(Common_Words.this);
        tvCommon_word.setLayoutParams(params);
        tvCommon_words.setLayoutParams(params);
        tvCommon_word.setText(word);
        tvCommon_words.setText(words);
        tvCommon_word.setTextSize(25);
        tvCommon_words.setTextSize(25);
        tvCommon_word.setHeight(270);
        tvCommon_words.setHeight(270);
        tvCommon_word.setBackgroundColor(Color.GRAY);
        tvCommon_words.setBackgroundColor(Color.GRAY);
        params.setMargins(3,3,3,3);
        tvCommon_word.setGravity(Gravity.CENTER);
        tvCommon_words.setGravity(Gravity.CENTER);
        tableRow.addView(tvCommon_word,params);
        tableRow.addView(tvCommon_words,params);
        table_common_word.addView(tableRow);
    }
}
