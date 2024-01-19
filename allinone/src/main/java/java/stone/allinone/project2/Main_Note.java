package java.stone.allinone.project2;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.stone.allinone.R;
import java.stone.allinone.ToastMsg;
import java.stone.allinone.library.Custm_List;
import java.util.ArrayList;

public class Main_Note extends AppCompatActivity {
    NoteDbAdapter noteDbAdapter;
    ArrayList <String> id,title,desc,dateTime;
    RecyclerView note_list;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_note);
        ToastMsg.toastMsg(getApplicationContext(),"On create");
        Button btnAdd = findViewById(R.id.btnAdd);
        note_list = findViewById(R.id.note_list);
        noteDbAdapter = new NoteDbAdapter(Main_Note.this);
        btnAdd.setOnClickListener(v -> {
            Intent intent = new Intent(Main_Note.this, Add_Note.class);
            startActivity(intent);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(Main_Note.this);
        inflater.inflate(R.menu.note_menu,menu);
        MenuItem item = menu.findItem(R.id.deleteAll);
        item.setTitle("Delete All ("+note_list.getChildCount()+")");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.deleteAll) {
            noteDbAdapter.dbOpen();
            if (note_list.getChildCount()==0) {
                ToastMsg.toastMsg(getApplicationContext(),"No Data to delete");
                String msg = noteDbAdapter.queryData();
                //ToastMsg.toastMsg(getApplicationContext(),msg);
                if (msg.isEmpty()) {
                    ToastMsg.toastMsg(getApplicationContext(),"no data");
                } else {
                    ToastMsg.toastMsg(getApplicationContext(),"data");
                }
            } else {
                String msg = noteDbAdapter.queryData();
                ToastMsg.toastMsg(getApplicationContext(),msg);
                confirmDialogDeleteAll();
            }
            noteDbAdapter.dbClose();
        }
        return super.onOptionsItemSelected(item);
    }
    public void confirmDialogDeleteAll() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Main_Note.this);
        builder.setTitle("Delete All!");
        builder.setMessage("Are you sure to delete all?");
        builder.setPositiveButton("Yes", (dialog, which) -> {
            noteDbAdapter.dbOpen();
            noteDbAdapter.deleteAllData();
            noteDbAdapter.dbClose();
            ToastMsg.toastMsg(getApplicationContext(),"Delete All Data");
            onResume();
        });
        builder.setNegativeButton("No",((dialog, which) -> {
        }));
        builder.create().show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        ToastMsg.toastMsg(getApplicationContext(),"On Resume");
        id = new ArrayList<>();
        title = new ArrayList<>();
        desc = new ArrayList<>();
        dateTime = new ArrayList<>();
        storeDataInArray();
        CustomNoteAdapter customNoteAdapter = new CustomNoteAdapter(Main_Note.this,
                id,title,desc,dateTime
        );
        note_list.setLayoutManager(new LinearLayoutManager(Main_Note.this));
        note_list.setAdapter(customNoteAdapter);
        StringBuilder sb = new StringBuilder();
        for (String data : title) {
            sb.append(data).append("\n");
        }
        ToastMsg.toastMsg(getApplicationContext(),sb.toString());
    }

    private void storeDataInArray() {
        noteDbAdapter.dbOpen();
        Cursor cursor = noteDbAdapter.readAllData();
        //int indexId = cursor.getColumnIndex();
        if (cursor.getColumnCount() == 0) {
            ToastMsg.toastMsg(getApplicationContext(),"No Data");
        } else {
            while (cursor.moveToNext()) {
                id.add(cursor.getString(0));
                title.add(cursor.getString(1));
                desc.add(cursor.getString(2));
                dateTime.add(cursor.getString(3));
            }
        }
        noteDbAdapter.dbClose();
    }
}
