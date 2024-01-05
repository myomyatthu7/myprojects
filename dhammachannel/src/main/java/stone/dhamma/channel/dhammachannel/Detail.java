package stone.dhamma.channel.dhammachannel;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Detail extends AppCompatActivity implements View.OnClickListener {
    private TextView tvDetailTitle,tvDetailDesc;

    private Button btnIncrease,btnDecrease,btnDecrease_l,btnRotate,btnPlay,btnPause,btnmyan;
    private int size = 20;
    private boolean rotate = false;
    private boolean translate = false;
    private MediaPlayer mp;
    private int uri,myanpyan;
//    FragmentTransaction ft;
    private FragmentManager fm;

    private RelativeLayout rOut_mp;
    private ScrollView scrollViewFrg;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.detail_dhamma);
         tvDetailDesc = findViewById(R.id.tvDetailDesc);
         tvDetailTitle = findViewById(R.id.tvDetailTitle);
         btnRotate = findViewById(R.id.btnRotate);
        btnIncrease = findViewById(R.id.btnIncrease);
        btnDecrease = findViewById(R.id.btnDecrease);
        btnDecrease_l = findViewById(R.id.btnDecrease_l);
        btnPlay = findViewById(R.id.btnPlay);
        btnPause = findViewById(R.id.btnPause);
        btnmyan = findViewById(R.id.btnmyan);
        rOut_mp = findViewById(R.id.rOut_mp);
        scrollViewFrg = findViewById(R.id.scrollViewFrg);
        Bundle bd = getIntent().getExtras();
        if (bd != null) {
            tvDetailTitle.setText(bd.getString("Title"));
            tvDetailDesc.setText(bd.getInt("Desc"));
            uri = bd.getInt("Uri");
            myanpyan = bd.getInt("Translate");
        }
        btnIncrease.setOnClickListener(this);
        btnDecrease.setOnClickListener(this);
        btnDecrease_l.setOnClickListener(this);
        btnRotate.setOnClickListener(this);
        btnPlay.setOnClickListener(this);
        btnPause.setOnClickListener(this);
        btnmyan.setOnClickListener(this);

        mp = MediaPlayer.create(Detail.this,uri);

        Frg_MyanPyan fmp = new Frg_MyanPyan();
        fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.rOut_mp,fmp,"F");
        ft.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mp.stop();
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btnIncrease) {
            size += 1;
            btnDecrease.setVisibility(View.VISIBLE);
            btnDecrease_l.setVisibility(View.INVISIBLE);
            tvDetailDesc.setTextSize(size);
            Frg_MyanPyan fmp = (Frg_MyanPyan) fm.findFragmentByTag("F");
            if (fmp != null) {
                fmp.textSize(size);
            }
        } else if (v.getId() == R.id.btnDecrease){
            if (size <= 9) {
                btnDecrease.setVisibility(View.INVISIBLE);
                btnDecrease_l.setVisibility(View.VISIBLE);
            } else {
                Frg_MyanPyan fmp = (Frg_MyanPyan) fm.findFragmentByTag("F");
                size -= 1;
                tvDetailDesc.setTextSize(size);
                if (fmp != null) {
                    fmp.textSize(size);
                }
            }
        } else if (v.getId() == R.id.btnRotate) {
            rotate = !rotate;
            if (rotate) {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            } else {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            }
        } else if (v.getId() == R.id.btnPlay) {
            mp.start();
            btnPause.setVisibility(View.VISIBLE);
            btnPlay.setVisibility(View.INVISIBLE);
        } else if (v.getId() == R.id.btnPause) {
            mp.pause();
            btnPause.setVisibility(View.INVISIBLE);
            btnPlay.setVisibility(View.VISIBLE);
        } else if (v.getId() == R.id.btnmyan) {
            translate = !translate;
            if (translate) {
                btnmyan.setText("ပါဠိ");
                Frg_MyanPyan fmp = (Frg_MyanPyan) fm.findFragmentByTag("F");
                if (fmp != null) {
                    fmp.textChange(myanpyan);
                }
                scrollViewFrg.setVisibility(View.VISIBLE);
                tvDetailDesc.setVisibility(View.INVISIBLE);
            } else {
                btnmyan.setText("မြန်မာပြန်");
                scrollViewFrg.setVisibility(View.INVISIBLE);
                tvDetailDesc.setVisibility(View.VISIBLE);
            }
        }
    }
}
