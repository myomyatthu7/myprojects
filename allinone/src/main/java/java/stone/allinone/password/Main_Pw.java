package java.stone.allinone.password;

import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.stone.allinone.R;

public class Main_Ps extends AppCompatActivity {
    EditText etPs;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_ps);
        etPs = findViewById(R.id.etPs);
        
    }
}
