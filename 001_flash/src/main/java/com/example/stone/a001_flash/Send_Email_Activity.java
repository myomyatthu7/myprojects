package com.example.stone.a001_flash;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Send_Email_Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_email_activity);
        EditText etEmail = findViewById(R.id.etEmail);
        EditText etSubject = findViewById(R.id.etSubject);
        EditText etMsg = findViewById(R.id.etMessage);
        EditText etCC = findViewById(R.id.etCC);
        EditText etBCC = findViewById(R.id.etBCC);
        Button btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(v -> {
           String subject = etSubject.getText().toString();
           String msg = etMsg.getText().toString();
           //String []mail = mails(etEmail);
           String []cc = mails(etCC);
           String []bcc = mails(etBCC);
           Intent i = new Intent(Intent.ACTION_SEND);
           i.putExtra(Intent.EXTRA_EMAIL,mails(etEmail));
           i.putExtra(Intent.EXTRA_CC,cc);
           i.putExtra(Intent.EXTRA_BCC,bcc);
           i.putExtra(Intent.EXTRA_SUBJECT,subject);
           i.putExtra(Intent.EXTRA_TEXT,msg);
            i.setType("plain/text");
           Intent ch = Intent.createChooser(i,"Choose Email!");

           startActivity(ch);
        });
//        btnSend.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (v.getId() == R.id.btnSend); {
//                    //mails(etEmail);
//                    String subject = etSubject.getText().toString();
//                    String msg = etMsg.getText().toString();
//                    Intent intentMails = new Intent(Intent.ACTION_SEND);
//                    intentMails.putExtra(Intent.EXTRA_EMAIL,mails(etEmail));
//                    intentMails.putExtra(Intent.EXTRA_CC,mails(etCC));
//                    intentMails.putExtra(Intent.EXTRA_BCC,mails(etBCC));
//                    intentMails.putExtra(Intent.EXTRA_SUBJECT,subject);
//                    intentMails.putExtra(Intent.EXTRA_TEXT,msg);
//                    intentMails.setType("plain/text");
//                    Intent chooser = Intent.createChooser(intentMails,"Choose Mail App for Send!");
//                    startActivity(chooser);
//
//                }
//            }
//        });
    }
//    private String[] mails(EditText editText) {
//        String mail = editText.getText().toString().toLowerCase();
//        return mail.split(",");
//    }


    private String[] mails(EditText editText) {
        String str = editText.getText().toString().toLowerCase();
        return str.split(",");
    }
}
