package com.example.stone.myapplicationn.activitylifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.stone.myapplicationn.R;
import com.example.stone.myapplicationn.RandomPicker;
import com.example.stone.myapplicationn.video.Video_List;

public class ActivityLifeCycle extends Activity implements View.OnClickListener {

    int count = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        Log.i("stone","onCreate is working!I");
        Log.d("stone","onCreate is working!D");
        Log.e("stone","onCreate is working!E");
        Log.v("stone","onCreate is working!V");
        Log.w("stone","onCreate is working!W");

        Button btOne,btTwo,btThree,btnVideo;
        btOne = findViewById(R.id.btOne);
        btTwo = findViewById(R.id.btTwo);
        btThree = findViewById(R.id.btThree);
        btnVideo = findViewById(R.id.btnVideo);
        btOne.setOnClickListener(this);
        btTwo.setOnClickListener(this);
        btThree.setOnClickListener(this);
        btnVideo.setOnClickListener(this);

    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//       // BigToast("onStart is Starting!");
//        Log.i("stone","onStart is working!I");
//        Log.d("stone","onStart is working!D");
//        Log.e("stone","onStart is working!E");
//        Log.v("stone","onStart is working!V");
//        Log.w("stone","onStart is working!W");
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//       // BigToast("onResume is Starting!");
//      //  count++;
//        Log.i("stone","onResume is working!I");
//        Log.d("stone","onResume is working!D");
//        Log.e("stone","onResume is working!E");
//        Log.v("stone","onResume is working!V");
//        Log.w("stone","onResume is working!W");
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//       // BigToast("onPause is Starting!");
//        Log.i("stone","onPause is working!I");
//        Log.d("stone","onPause is working!D");
//        Log.e("stone","onPause is working!E");
//        Log.v("stone","onPause is working!V");
//        Log.w("stone","onPause is working!W");
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//       // BigToast("onStop is Starting!");
//        Log.i("stone","onStop is working!I");
//        Log.d("stone","onStop is working!D");
//        Log.e("stone","onStop is working!E");
//        Log.v("stone","onStop is working!V");
//        Log.w("stone","onStop is working!W");
//    }
//
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//      //  BigToast("onRestart is Starting!");
//        Log.i("stone","onRestart is working!I");
//        Log.d("stone","onRestart is working!D");
//        Log.e("stone","onRestart is working!E");
//        Log.v("stone","onRestart is working!V");
//        Log.w("stone","onRestart is working!W");
//    }
//
//    @Override
//    protected void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//        //BigToast("onSaveInstanceState is Starting!");
//       // outState.putInt("count",count);
//        Log.i("stone","onSaveInstanceState is working!I");
//        Log.d("stone","onSaveInstanceState is working!D");
//        Log.e("stone","onSaveInstanceState is working!E");
//        Log.v("stone","onSaveInstanceState is working!V");
//        Log.w("stone","onSaveInstanceState is working!W");
//    }
//
//    @Override
//    public void onStateNotSaved() {
//        super.onStateNotSaved();
//       // BigToast("onStateNotSaved is Starting!");
//        Log.i("stone","onStateNotSaved is working!I");
//        Log.d("stone","onStateNotSaved is working!D");
//        Log.e("stone","onStateNotSaved is working!E");
//        Log.v("stone","onStateNotSaved is working!V");
//        Log.w("stone","onStateNotSaved is working!W");
//    }
//
//    @Override
//    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        //BigToast("onRestoreInstanceState1 is Starting!");
//       // count = savedInstanceState.getInt("count");
//       // BigToast(String.valueOf(count));
//        Log.i("stone","onRestoreInstanceState is working!I");
//        Log.d("stone","onRestoreInstanceState is working!D");
//        Log.e("stone","onRestoreInstanceState is working!E");
//        Log.v("stone","onRestoreInstanceState is working!V");
//        Log.w("stone","onRestoreInstanceState is working!W");
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        //BigToast("onDestroy is Starting!");
//        Log.i("stone","onDestroy is working!I");
//        Log.d("stone","onDestroy is working!D");
//        Log.e("stone","onDestroy is working!E");
//        Log.v("stone","onDestroy is working!V");
//        Log.w("stone","onDestroy is working!W");
//    }

//    @Override
//    public void onConfigurationChanged(@NonNull Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//        if (newConfig.orientation == 1) {
//            BigToast("Portrait");
//        } else if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            BigToast("Landscape");
//        }
//    }

    public void BigToast(String text) {
        Toast toast = Toast.makeText( getApplicationContext(), text, Toast.LENGTH_SHORT);
//        LinearLayout linearLayout = (LinearLayout) toast.getView();
//        TextView tv= null;
//        if (linearLayout != null) {
//            Log.d("holalaho","Linear");
//            tv = (TextView) linearLayout.getChildAt(0);
//        } else{
//            Log.d("logsss","Linears");
//        }
//        if (tv != null) {
//            Log.d("holalaho","setTextSize");
//            tv.setTextSize(30);
//        } else {
//            Log.d("logsss","setTextSizes");
//        }
//        if (tv != null) {
//            Log.d("holalaho","setGravity");
//            tv.setGravity(Gravity.CENTER);
//        } else {
//            Log.d("logsss","setGravitys");
//        }
        toast.show();
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btOne) {
            Intent i = new Intent(ActivityLifeCycle.this,ActivityLifeCycleNext.class);
            startActivity(i);
        } else if (v.getId() == R.id.btTwo) {
            finish();
        } else if (v.getId() == R.id.btThree) {
            Intent ii = new Intent(ActivityLifeCycle.this, RandomPicker.class);
            startActivity(ii);
        } else if (v.getId() == R.id.btnVideo) {
            Intent iii = new Intent(ActivityLifeCycle.this, Video_List.class);
            startActivity(iii);
        }
    }
}
