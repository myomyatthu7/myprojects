package java.stone.allinone.project2;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.stone.allinone.MyHelperAdapter;
import java.stone.allinone.R;
import java.stone.allinone.ToastMsg;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Add_Note extends AppCompatActivity implements View.OnClickListener {
    NoteDbAdapter noteDbAdapter;
    Button btnSave;
    EditText etTitle,etDes;
    String title,des;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_note);
        btnSave = findViewById(R.id.btnSave);
        etTitle = findViewById(R.id.etTitle);
        etDes = findViewById(R.id.etDescription);

        final RelativeLayout rootView = findViewById(R.id.add_rout);

        btnSave.setOnClickListener(this);
        noteDbAdapter = new NoteDbAdapter(Add_Note.this);

        rootView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                Rect r = new Rect();
                rootView.getWindowVisibleDisplayFrame(r);
                //int screenHeight = rootView.getHeight();
                //int keypadHeight = screenHeight - r.bottom;
                // Adjust your views based on the keypadHeight if needed
                return true;
            }
        });
    }
    @Override
    public void onClick(View v) {
        int id = v.getId();
        if ( id== R.id.btnSave) {
            title = etTitle.getText().toString();
            des = etDes.getText().toString();
            String dateTime = getCurrentDateTime();
            noteDbAdapter.dbOpen();
            long row = noteDbAdapter.insertData(title,des,dateTime);
            noteDbAdapter.dbClose();
            if (row<0) {
                ToastMsg.toastMsg(getApplicationContext(),"Error!");
            } else {
                ToastMsg.toastMsg(getApplicationContext(),"Add Successfully");
            }
        }
    }
    public String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy \t hh:mm:ss");
        return sdf.format(Calendar.getInstance().getTime());
    }
}
