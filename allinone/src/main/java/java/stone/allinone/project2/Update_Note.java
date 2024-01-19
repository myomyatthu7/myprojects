package java.stone.allinone.project2;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.stone.allinone.R;
import java.stone.allinone.ToastMsg;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Update_Note extends AppCompatActivity {
    EditText etTitle1,etDec1;
    Button btnUpdate,btnDelete;
    String id,title,des;
    NoteDbAdapter noteDbAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_note);
        etTitle1 = findViewById(R.id.etTitle1);
        etDec1 = findViewById(R.id.etDescription1);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        noteDbAdapter = new NoteDbAdapter(Update_Note.this);
        getAndSetData();
        btnUpdate.setOnClickListener(v -> {
            confirmDialogUpdate();
        });
        btnDelete.setOnClickListener(v ->{
            confirmDialogDelete();
        });
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            if (title.isEmpty()) {
                actionBar.setTitle("Update Note");
            } else {
                actionBar.setTitle("Update "+title);
            }
        }
    }

    public void confirmDialogUpdate() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Update_Note.this);
        builder.setTitle("Update "+title);
        builder.setMessage("Are you sure to update "+title+"?");
        builder.setPositiveButton("Yes", (dialog, which) -> {
            noteDbAdapter.dbOpen();
            title = etTitle1.getText().toString();
            des = etDec1.getText().toString();
            String dateTime = getCurrentDateTime();
            noteDbAdapter.dbOpen();
            int result = noteDbAdapter.updateData(id,title,des,dateTime);
            noteDbAdapter.dbClose();
            if (result<1) {
                ToastMsg.toastMsg(getApplicationContext(),"Fail to Update");
            } else {
                ToastMsg.toastMsg(getApplicationContext(),"Update Successfully");
                ToastMsg.toastMsg(getApplicationContext(),id+" , "+title+" , "+des+" , "+dateTime);
            }
            finish();
        });
        builder.setNegativeButton("No",((dialog, which) -> {
        }));
        builder.create().show();
    }

    public void confirmDialogDelete() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Update_Note.this);
        builder.setTitle("Delete "+title);
        builder.setMessage("Are you sure to delete "+title+"?");
        builder.setPositiveButton("Yes", (dialog, which) -> {
            noteDbAdapter.dbOpen();
            int result = noteDbAdapter.deleteData(id);
            noteDbAdapter.dbClose();
            if (result<1) {
                ToastMsg.toastMsg(getApplicationContext(),"Fail to Delete");
            } else {
                ToastMsg.toastMsg(getApplicationContext(),"Delete Successfully");
            }
            finish();
        });
        builder.setNegativeButton("No",((dialog, which) -> {
        }));
        builder.create().show();
    }

    private void getAndSetData() {
        if (getIntent().hasExtra("id") && getIntent().hasExtra("title") &&
                getIntent().hasExtra("des") ){
            id = getIntent().getStringExtra("id");
            title = getIntent().getStringExtra("title");
            des = getIntent().getStringExtra("des");

            etTitle1.setText(title);
            etDec1.setText(des);
        } else {
            ToastMsg.toastMsg(getApplicationContext(),"No Data");
        }
    }
    public String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy \t hh:mm:ss");
        return sdf.format(Calendar.getInstance().getTime());
    }
}
