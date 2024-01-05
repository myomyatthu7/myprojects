package java.stone.allinone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Data_Tran extends AppCompatActivity {
    Button btnNext;
    TextView tvReturnResult;
    EditText etInput;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_tran);
        btnNext = findViewById(R.id.btnNext);
        tvReturnResult = findViewById(R.id.tvReturnResult);
        etInput = findViewById(R.id.etInput);
        btnNext.setOnClickListener(new btnListener());
        Bundle bd = getIntent().getExtras();
        if (bd != null) {
            String rGpResult = bd.getString("rGpResult");
            tvReturnResult.setText(rGpResult);
        }
    }

    private class btnListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String input = etInput.getText().toString();
            if (input.isEmpty()) {
                ToastMsg.toastMsg(Data_Tran.this,"Insert Words");
            } else {
                Intent iNext = new Intent(Data_Tran.this,Data_Result.class);
                Bundle bundle = new Bundle();
                bundle.putString("result",input);
                iNext.putExtras(bundle);
                startActivity(iNext);
            }
        }
    }
}
