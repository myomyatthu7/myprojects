package com.example.stone.learning;

import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
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

public class Custom_Table_Layout extends AppCompatActivity implements View.OnClickListener {
    TableLayout customTableLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cutom_table_layout);
        customTableLayout = findViewById(R.id.customTableLayout);
        fileReading();
    }
//    private void fileReading() {
//        AssetManager asm = Custom_Table_Layout.this.getAssets();
//        try {
//            InputStream ips = asm.open("note.txt");
//            BufferedReader br = new BufferedReader(new InputStreamReader(ips));
//            String line;
//            while ((line = br.readLine()) != null) {
//                String[] ary = line.split(" ");
//                if (ary.length % 2 == 0) {
//                    createTableRow(ary);
//                } else {
//                    // Handle odd-length array if needed
//                }
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private void createTableRow(String[] rowData) {
//        TableRow tRow = new TableRow(Custom_Table_Layout.this);
//        tRow.setLayoutParams(new TableLayout.LayoutParams(
//                TableLayout.LayoutParams.MATCH_PARENT,
//                TableLayout.LayoutParams.WRAP_CONTENT));
//
//        for (int i = 0; i < rowData.length; i += 2) {
//            String one = rowData[i];
//            String two = (i + 1 < rowData.length) ? rowData[i + 1] : "";
//            createTable(tRow, one, two);
//        }
//
//        customTableLayout.addView(tRow);
//    }
//
//    private void createTable(TableRow tableRow, String one, String two) {
//        TextView textView1 = new TextView(Custom_Table_Layout.this);
//        TextView textView2 = new TextView(Custom_Table_Layout.this);
//
//        // Set properties for textView1 and textView2 as needed
//        textView1.setText(one);
//        textView2.setText(two);
//
//        tableRow.addView(textView1);
//        tableRow.addView(textView2);
//    }


    private void fileReading() {
        //int z = 0;
        StringBuilder sb = new StringBuilder();
        AssetManager asm = Custom_Table_Layout.this.getAssets();
        try {
            InputStream ips = asm.open("note.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(ips));
            String line;
            while ((line = br.readLine()) != null) {
                //String[] ary = line.split(" ");
                sb.append(line);
            }
            String[] ary = sb.toString().split(" ");
            for (int i=0;i<ary.length;i++) {
                if (i%2!=0) {
                    int t = i-1;
                    createTable(ary[t],ary[i],t,i);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createTable(String one, String two,int z,int y) {
        TableRow.LayoutParams paramOne = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams paramTwo = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT);
        TableRow tableRow = new TableRow(Custom_Table_Layout.this);
        TextView tvOne = new TextView(Custom_Table_Layout.this);
        TextView tvTwo = new TextView(Custom_Table_Layout.this);
        tvOne.setLayoutParams(paramOne);
        tvTwo.setLayoutParams(paramTwo);
        tableRow.addView(tvOne,paramOne);
        tableRow.addView(tvTwo,paramTwo);
        tvOne.setText(one);
        tvTwo.setText(two);
        tvOne.setGravity(Gravity.CENTER);
        tvTwo.setGravity(Gravity.CENTER);
        tvOne.setHeight(185);
        tvTwo.setHeight(185);
        tvOne.setTextSize(25);
        tvTwo.setTextSize(25);
        paramOne.setMargins(8,4,2,2);
        paramTwo.setMargins(2,4,8,2);
        tvOne.setBackgroundColor(Color.GRAY);
        tvTwo.setBackgroundColor(Color.GRAY);
        tvOne.setId(z);
        tvTwo.setId(y);
        customTableLayout.addView(tableRow);
        tvOne.setOnClickListener(this);
        tvTwo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        TextView tv = (TextView) v;
        Toast.makeText(this, tv.getText().toString()+":"+ v.getId(), Toast.LENGTH_SHORT).show();
    }
}
