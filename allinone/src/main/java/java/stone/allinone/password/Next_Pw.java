package java.stone.allinone.password;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.stone.allinone.R;
import java.stone.allinone.ToastMsg;
import java.stone.allinone.project2.NoteDbAdapter;

public class Next_Pw extends AppCompatActivity implements View.OnClickListener {
    EditText etOldPw,etNewPw1,etNewPw2;
    Button changePw,deletPw;
    PwDataAdapter pwDataAdapter;
    String oldPwData;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next_ps);
        etOldPw = findViewById(R.id.etOldPw);
        etNewPw1 = findViewById(R.id.etNewPw1);
        etNewPw2 = findViewById(R.id.etNewPw2);
        changePw = findViewById(R.id.changePw);
        deletPw = findViewById(R.id.deletePw);
        changePw.setOnClickListener(this);
        deletPw.setOnClickListener(this);
        pwDataAdapter = new PwDataAdapter(Next_Pw.this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        pwDataAdapter.dbOpen();
        oldPwData = pwDataAdapter.dataQuery().trim();
        pwDataAdapter.dbClose();
        if (oldPwData.isEmpty()) {
            //etOldPw.setText("0000007");
            etOldPw.setVisibility(View.INVISIBLE);
            deletPw.setVisibility(View.INVISIBLE);
        } else {
            etOldPw.setVisibility(View.VISIBLE);
            deletPw.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        String oldPw = etOldPw.getText().toString().trim();
        String newPw1 = etNewPw1.getText().toString().trim();
        String newPw2 = etNewPw2.getText().toString().trim();
        if(v.getId() == R.id.changePw) {
            if (oldPw.contentEquals(oldPwData)) {
                if (newPw1.contentEquals(newPw2)) {
                    pwDataAdapter.dbOpen();
                    if(oldPwData.isEmpty()) {
                        long addPw = pwDataAdapter.dataInsert(newPw1);
                        if (addPw <0) {
                            ToastMsg.toastMsg(getApplicationContext(),"Add Password Fail");
                        } else {
                            ToastMsg.toastMsg(getApplicationContext(),"Add Password Successful "+newPw1);
                        }
                    } else {
                        int changePw = pwDataAdapter.dataUpdate(oldPwData,newPw1);
                        if (changePw <0) {
                            ToastMsg.toastMsg(getApplicationContext(),"Update Fail");
                        } else {
                            ToastMsg.toastMsg(getApplicationContext(),"Update Successfully "+newPw1);
                        }
                    }
                    pwDataAdapter.dbClose();
                } else {
                    ToastMsg.toastMsg(getApplicationContext(),"Confirm pw not the same! "+newPw1);
                }
            } else {
                ToastMsg.toastMsg(getApplicationContext(),"Old Pw is not correct "+oldPw+" : "+oldPwData);
            }
        } else if (v.getId() == R.id.deletePw) {
            if (oldPw.contentEquals(oldPwData)) {
                pwDataAdapter.dbOpen();
                pwDataAdapter.dataDeletePw();
                pwDataAdapter.dbClose();
                ToastMsg.toastMsg(getApplicationContext(),"Delete Successful!");
                finish();
            } else if (oldPw.isEmpty()){
                 ToastMsg.toastMsg(getApplicationContext(),"Please add Old Pw!");
            } else {
                ToastMsg.toastMsg(getApplicationContext(),"Old Pw isn't correct!");
            }
        }
    }
}
