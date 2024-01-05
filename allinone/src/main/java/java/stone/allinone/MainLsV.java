package java.stone.allinone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.stone.allinone.project1.MainActivity;

public class MainLsV extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String []ary;
    ListView lv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mn_lsv);
        lv = findViewById(R.id.mn_lv);
        ary = getResources().getStringArray(R.array.mn_lv);
        ArrayAdapter<String>adapter = new ArrayAdapter<>(MainLsV.this,
                R.layout.mn_tv,ary);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0) {
            Intent iDataTran = new Intent(MainLsV.this,Data_Tran.class);
            startActivity(iDataTran);
        } else if (position == 1) {
            Intent iRdmPic = new Intent(MainLsV.this,Rdm_Pic.class);
            startActivity(iRdmPic);
        } else if (position == 2) {
            Intent iDic = new Intent(MainLsV.this,MyTabHost.class);
            startActivity(iDic);
        } else if (position == 3) {
            Intent iRecy = new Intent(MainLsV.this,MyRecycle.class);
            startActivity(iRecy);
        } else if (position == 4) {
            Intent iInf = new Intent(MainLsV.this,MyInflater.class);
            startActivity(iInf);
        } else if (position == 5) {
            Intent intRec = new Intent(MainLsV.this, MainActivity.class);
            startActivity(intRec);
        } else if (position == 6) {
            Intent intLayoutKJava = new Intent(MainLsV.this, rOut_Jv.class);
            startActivity(intLayoutKJava);
        } else if (position == 7) {
            Intent intBtnNavi = new Intent(MainLsV.this, BtnNavi.class);
            startActivity(intBtnNavi);
        }
    }
}
