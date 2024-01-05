package com.java.stone.layout_inflater;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Contact extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String [] aryName,aryNum;
//    TextView tvName,tvNum;
//    ImageButton ibPhCall,ibMsg;
    Custom_Contact contact;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact);
        ListView lvContact;
        aryName = getResources().getStringArray(R.array.names);
        aryNum = getResources().getStringArray(R.array.numbers);
        lvContact = findViewById(R.id.lvContact);
        contact = new Custom_Contact(Contact.this,aryName,aryNum);
        lvContact.setAdapter(contact);
        lvContact.setOnItemClickListener(this);
//        tvName = findViewById(R.id.tvName);
//        tvNum = findViewById(R.id.tvNum);
//        ibPhCall = findViewById(R.id.ibPhCall);
//        ibMsg = findViewById(R.id.ibMsg);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,String.valueOf(position), Toast.LENGTH_SHORT).show();
    }
}
