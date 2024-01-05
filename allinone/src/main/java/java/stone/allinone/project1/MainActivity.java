package java.stone.allinone.project1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.Toast;

import java.stone.allinone.R;
import java.stone.allinone.ToastMsg;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    RecyclerView recyclerView;
    SearchView searchView;
    MyAdapter myAdapter;
    DataClass dataClass;
    List<DataClass> dataList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        searchView = findViewById(R.id.search);

        searchView.setOnQueryTextListener(this);

        dataList = new ArrayList<>();
        dataClass = new DataClass(R.drawable.java,R.string.date,"Date Picker","Java");
        dataList.add(dataClass);
        dataClass = new DataClass(R.drawable.kotlin,R.string.camera,"Camera","Kotlin");
        dataList.add(dataClass);
        dataClass = new DataClass(R.drawable.javascript,R.string.recyclerview,"RecyclerView","Javascript");
        dataList.add(dataClass);
        dataClass = new DataClass(R.drawable.mysql,R.string.edit,"Edit Text","MySql");
        dataList.add(dataClass);
        dataClass = new DataClass(R.drawable.html_5,R.string.rating,"Rating Bar","Html 5");
        dataList.add(dataClass);
        myAdapter = new MyAdapter(dataList,MainActivity.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        searchText(newText);
        return true;
    }

    private void searchText(String newText) {
        List<DataClass> searchList = new ArrayList<>();
        for (DataClass data : dataList) {
            if (data.getDataTitle().toLowerCase().contains(newText.toLowerCase())) {
                searchList.add(data);
            }
        }
        if (searchList.isEmpty()) {
            ToastMsg.toastMsg(this,"Not Found");
        } else {
            myAdapter.setSearchList(searchList);
        }
    }
    //    RecyclerView recyclerView;
//    SearchView searchView;
//    List<DataClass> dataList;
//    MyAdapter adapter;
//    DataClass androidData;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        recyclerView = findViewById(R.id.recyclerView);
//        searchView = findViewById(R.id.search);
//
//        //searchView.clearFocus();
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                searchList(newText);
//                return true;
//            }
//        });
//
//        //GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, 1);
//
//        dataList = new ArrayList<>();
//
//        androidData = new DataClass("Camera", R.string.camera, "Java", R.drawable.java);
//        dataList.add(androidData);
//
//        androidData = new DataClass("RecyclerView", R.string.recyclerview, "Kotlin", R.drawable.kotlin);
//        dataList.add(androidData);
//
//        androidData = new DataClass("Date Picker", R.string.date, "Java", R.drawable.javascript);
//        dataList.add(androidData);
//
//        androidData = new DataClass("EditText", R.string.edit, "Kotlin", R.drawable.mysql);
//        dataList.add(androidData);
//
//        androidData = new DataClass("Rating Bar", R.string.rating, "Java", R.drawable.html_5);
//        dataList.add(androidData);
//
//        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
//        adapter = new MyAdapter(MainActivity.this, dataList);
//        recyclerView.setAdapter(adapter);
//    }
//
//    private void searchList(String text){
//        List<DataClass> dataSearchList = new ArrayList<>();
//        for (DataClass data : dataList){
//            if (data.getDataTitle().toLowerCase().contains(text.toLowerCase())) {
//                dataSearchList.add(data);
//            }
//        }
//        if (dataSearchList.isEmpty()){
//            Toast.makeText(this, "Not Found", Toast.LENGTH_SHORT).show();
//        } else {
//            adapter.setSearchList(dataSearchList);
//        }
//    }
}
