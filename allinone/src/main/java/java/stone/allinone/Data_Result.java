package java.stone.allinone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Data_Result extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {
    TextView tvResult,rGpResult;
    RadioGroup rGp;
    RadioButton rbJava,rbKotlin,rbPhp,rbPython;
    Button btnBack;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_result);
        tvResult = findViewById(R.id.tvResult);
        rGpResult = findViewById(R.id.rGpResult);
        rGp = findViewById(R.id.rGp);
        rbJava = findViewById(R.id.rbJava);
        rbKotlin = findViewById(R.id.rbKotlin);
        rbPhp = findViewById(R.id.rbPhp);
        rbPython = findViewById(R.id.rbPython);
        btnBack = findViewById(R.id.btnBack);
        Bundle bundle = getIntent().getExtras();
        // intent = new Intent();
        if (bundle != null) {
            String result = bundle.getString("result");
            //intent.getStringExtra(result);
            tvResult.setText(result);
        }
        rGp.setOnCheckedChangeListener(this);
        btnBack.setOnClickListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.rbJava) {
            rGpResult.setText(rbJava.getText().toString());
        } else if (checkedId == R.id.rbKotlin) {
            rGpResult.setText(rbKotlin.getText().toString());
        } else if (checkedId == R.id.rbPhp) {
            rGpResult.setText(rbPhp.getText().toString());
        }else if (checkedId == R.id.rbPython) {
            rGpResult.setText(rbPython.getText().toString());
        }
    }

    @Override
    public void onClick(View v) {
        if (rGpResult.getText().toString().contentEquals("Result")) {
           ToastMsg.toastMsg(Data_Result.this,"Choose Language");
        } else {
            Intent iBack = new Intent(Data_Result.this, Data_Tran.class);
            Bundle bd = new Bundle();
            bd.putString("rGpResult",rGpResult.getText().toString());
            iBack.putExtras(bd);
            startActivity(iBack);
            finish();
        }
    }
}
