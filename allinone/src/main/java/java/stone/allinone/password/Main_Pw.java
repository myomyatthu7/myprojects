package java.stone.allinone.password;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.stone.allinone.R;
import java.stone.allinone.ToastMsg;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main_Pw extends AppCompatActivity {
    EditText etPs;
    Button btnLogin;
    PwDataAdapter pwDataAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_ps);
        etPs = findViewById(R.id.etPs);
        btnLogin = findViewById(R.id.btnLogin);
        pwDataAdapter = new PwDataAdapter(Main_Pw.this);
        //pwDataAdapter.dataInsert(etPs.getText().toString());
        ToastMsg.toastMsg(getApplicationContext(),getCurrentDateTime());
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pw = etPs.getText().toString();
                Toast.makeText(Main_Pw.this, "CLick", Toast.LENGTH_SHORT).show();
                pwDataAdapter.dbOpen();
                String data = pwDataAdapter.dataQuery().trim();
                ToastMsg.toastMsg(getApplicationContext(),data);
                pwDataAdapter.dbClose();
                if (pw.contentEquals("12345") || pw.contains(data)) {
                    Intent intent = new Intent(Main_Pw.this, Next_Pw.class);
                    startActivity(intent);
                }
            }
        });
    }
    public String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("ss");
        return sdf.format(Calendar.getInstance().getTime());
    }
}
