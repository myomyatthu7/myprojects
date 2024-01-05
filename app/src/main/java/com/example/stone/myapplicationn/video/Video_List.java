package com.example.stone.myapplicationn.video;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.stone.myapplicationn.R;

import java.util.Locale;

public class Video_List extends AppCompatActivity implements View.OnScrollChangeListener, AbsListView.OnScrollListener {
    ListView lv;
    String[] ary;

    int[] aryVideo = {R.raw.one, R.raw.two, R.raw.three, R.raw.four, R.raw.five
            , R.raw.six, R.raw.seven, R.raw.eight, R.raw.nine, R.raw.ten
            , R.raw.eleven, R.raw.twelve, R.raw.thirteen, R.raw.fourteen, R.raw.fifteen,
            R.raw.sixteen, R.raw.seventeen, R.raw.eighteen, R.raw.nineteen, R.raw.twelve};

    int videoPath = 0;
    TextToSpeech tts;
    //ProgressBar pb;
    ProgressDialog pd;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_list);
        lv = findViewById(R.id.lvPlay);
        ary = getResources().getStringArray(R.array.videos);
        //lv.setAdapter(new ArrayAdapter<String>(Video_List.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, ary));
        lv.setOnItemClickListener(new Stone());
        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.US);
                }
            }
        });
        lv.setOnScrollListener(this);
        //pb = new ProgressBar(Video_List.this);
        //pb.setIndeterminate(false);
        pd = new ProgressDialog(Video_List.this);
        pd.setMessage("Wait a few minutes");
        pd.setIndeterminate(false);
    }

    @Override
    public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        //Toast.makeText(this, "Down;"+String.valueOf(scrollState), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        int var = 0;
        if (var > firstVisibleItem) {
            Toast.makeText(this, "Down;"+firstVisibleItem, Toast.LENGTH_SHORT).show();
            pd.show();
        } else if (var < firstVisibleItem) {
            Toast.makeText(this, "Up;"+firstVisibleItem, Toast.LENGTH_SHORT).show();
        }
        var = firstVisibleItem;
        //Toast.makeText(this, "firstVisibleItem;"+firstVisibleItem, Toast.LENGTH_SHORT).show();
    }

    public class Stone implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            tts.speak(ary[position],TextToSpeech.QUEUE_FLUSH, null);
            //Toast.makeText(Video_List.this, String.valueOf(getPosition()), Toast.LENGTH_SHORT).show();
            String filePath = "android.resource://com.example.stone.myapplicationn/";
            try {
                    videoPath = aryVideo[position];
            } catch (Exception exception) {
                exception.printStackTrace();
            } finally {
                startIntent(filePath+videoPath);
            }
        }
        private void startIntent(String filePath) {
            if (videoPath == 0) {
                Toast.makeText(Video_List.this,"No Video yet!",Toast.LENGTH_SHORT).show();
            } else {
                Intent i = new Intent(Video_List.this,Video_Play.class);
                Bundle bd = new Bundle();
                bd.putString("engVideo",filePath);
                i.putExtras(bd);
                startActivity(i);
            }

        }
    }

}
