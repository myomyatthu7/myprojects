package com.example.stone.a002_calculator;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.Preference;
import android.text.Layout;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.stone.a002_calculator.frame_layout.Frame_Layout;
import com.example.stone.a002_calculator.list.MyListView;
import com.example.stone.a002_calculator.list.MyListView1;
import com.example.stone.a002_calculator.mylibrary.BigToastMsg;

public class Main_Activity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout lOut;
    private Button btn;
    private TextView tv;
    private MediaPlayer mp;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lOut = new LinearLayout(this);
        btn = new Button(this);
        tv = new TextView(this);
        LinearLayout.LayoutParams dimension = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        LinearLayout.LayoutParams vDimension = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        lOut.setLayoutParams(dimension);
        tv.setLayoutParams(vDimension);
        btn.setLayoutParams(vDimension);
        String  tvStr = "Hello World";
        String  btnStr = "Next";
        tv.setText(tvStr);
        btn.setText(btnStr);
        lOut.addView(tv);
        lOut.addView(btn);
        lOut.setOrientation(LinearLayout.VERTICAL);
        // setContentView(lOut);
        setContentView(R.layout.activity_button_design);
        Button btnCalculator = findViewById(R.id.btnCalculator);
        Button btnCyc = findViewById(R.id.btnCycle);
        Button btnROutInJava = findViewById(R.id.btnROutInJava);
        Button btnCheckBoxToggle = findViewById(R.id.btnCheckBoxToggle);
        Button btnFrame_Design = findViewById(R.id.btnFrame_design);
        Button btnList = findViewById(R.id.btnList);
        Button btnDictionary = findViewById(R.id.btnDictionary);
        btnCalculator.setOnClickListener(this);
        btnCyc.setOnClickListener(this);
        btnROutInJava.setOnClickListener(this);
        btnCheckBoxToggle.setOnClickListener(this);
        btnFrame_Design.setOnClickListener(this);
        btn.setOnClickListener(this);
        btnList.setOnClickListener(this);
        btnDictionary.setOnClickListener(this);
        mp = MediaPlayer.create(Main_Activity.this,R.raw.perfect);
        //mp.start();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnCalculator) {
            Intent iCal = new Intent(Main_Activity.this,Calculator.class);
            startActivity(iCal);
        } else if (v.getId() == R.id.btnCycle) {
            Intent iCyc = new Intent(Main_Activity.this,Cycle_Activity1.class);
            startActivity(iCyc);
        } else if (v.getId() == R.id.btnROutInJava) {
            Intent iROutInJava = new Intent(Main_Activity.this,RelativeLayout_InJava.class);
            startActivity(iROutInJava);
        } else if (v.getId() == R.id.btnCheckBoxToggle) {
            Intent iCheckBox = new Intent(Main_Activity.this,Custom_CheckBox1.class);
            startActivity(iCheckBox);
        } else if (v.getId() == R.id.btnFrame_design) {
            Intent iFrameDesign = new Intent(Main_Activity.this,Frame_Layout.class);
            startActivity(iFrameDesign);
        } else if (v.getId() == R.id.btnList) {
            Intent iList = new Intent(Main_Activity.this, MyListView1.class);
            startActivity(iList);
        } else if (v.getId() == R.id.btnDictionary) {
            Intent iList = new Intent(Main_Activity.this, Dictionary.class);
            startActivity(iList);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = new MenuInflater(getApplicationContext());
        menuInflater.inflate(R.menu.main_menu,menu);
       // return  true;
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.muAbout) {
            BigToastMsg.bigToastMsg(getApplicationContext(),"About");
        } else if (item.getItemId()==R.id.muPreference) {
            BigToastMsg.bigToastMsg(getApplicationContext(),"Preference");
            Intent iPref = new Intent(Main_Activity.this, Preference.class);
            startActivity(iPref);
        } else if (item.getItemId()==R.id.muExit) {
            BigToastMsg.bigToastMsg(getApplicationContext(),"Exit");
            mp.pause();
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    // မရ
//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        MenuInflater menuInflater = new MenuInflater(getApplicationContext());
//        menuInflater.inflate(R.menu.main_menu,menu);
//        super.onCreateContextMenu(menu, v, menuInfo);
//    }

    // မရ
//    @Override
//    public boolean onContextItemSelected(@NonNull MenuItem item) {
//        if (item.getItemId()==R.id.muAbout) {
//            BigToastMsg.bigToastMsg(getApplicationContext(),"About");
//        } else if (item.getItemId()==R.id.muPreference) {
//            BigToastMsg.bigToastMsg(getApplicationContext(),"Preference");
//        } else if (item.getItemId()==R.id.muExit) {
//            BigToastMsg.bigToastMsg(getApplicationContext(),"Exit");
//            finish();
//        }
//        return super.onContextItemSelected(item);
//    }
}
