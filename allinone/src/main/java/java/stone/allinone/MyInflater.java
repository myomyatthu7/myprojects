package java.stone.allinone;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.stone.allinone.R;

public class MyInflater extends AppCompatActivity {
    RelativeLayout rOut,rOut1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rout);
        rOut = findViewById(R.id.rOut);
        rOut1 = new RelativeLayout(MyInflater.this);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
        );
        rOut1.setLayoutParams(params);
        rOut1.setBackgroundColor(Color.GREEN);
        LayoutInflater inflater = getLayoutInflater();
        View v = inflater.inflate(R.layout.tv,rOut1,false);
        rOut.addView(v);
    }
}
