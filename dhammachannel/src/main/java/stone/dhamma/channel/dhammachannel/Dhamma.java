package stone.dhamma.channel.dhammachannel;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Dhamma extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private RecyclerView recyclerView;
    private TextView tvNoData;
    private List<MyData> dataList;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dhamma);
        SearchView searchView = findViewById(R.id.search);
        recyclerView = findViewById(R.id.recyclerview);
        tvNoData = findViewById(R.id.tvNoData);
        searchView.setOnQueryTextListener(this);

        dataList = new ArrayList<>();
        MyData myData = new MyData("ပရိတ်နိဒါန်း", R.string.nidan, R.raw.nidan, R.string.nidan_translate);
        dataList.add(myData);
        myData = new MyData("မင်္ဂလသုတ်",R.string.mingala,R.raw.mingala,R.string.mingala_translate);
        dataList.add(myData);
        myData = new MyData("ရတနာသုတ်",R.string.yatana,R.raw.yatana,R.string.yatana_translate);
        dataList.add(myData);
        myData = new MyData("မေတ္တသုတ်",R.string.myitta,R.raw.myitta,R.string.myitta_translate);
        dataList.add(myData);
        myData = new MyData("ခန္ဓသုတ်",R.string.khanda,R.raw.khanda,R.string.khanda_translate);
        dataList.add(myData);
        myData = new MyData("မောရသုတ်",R.string.mawya,R.raw.mawya,R.string.mawya_translate);
        dataList.add(myData);
        myData = new MyData("ဝဋ္ဋသုတ်",R.string.witta,R.raw.witta,R.string.witta_translate);
        dataList.add(myData);
        myData = new MyData("ဓဇဂ္ဂသုတ်",R.string.dazinga,R.raw.dazinga,R.string.dazinga_translate);
        dataList.add(myData);
        myData = new MyData("အာဋာနာဋိယသုတ်",R.string.arhtrnar,R.raw.arhtrnar,R.string.arhtrnar_translate);
        dataList.add(myData);
        myData = new MyData("အင်္ဂုလိမာလသုတ်",R.string.ingule,R.raw.ingule,R.string.ingule_translate);
        dataList.add(myData);
        myData = new MyData("ဗောဇ္ဈင်္ဂသုတ်",R.string.bawzinga,R.raw.bawzinga,R.string.bawzinga_translate);
        dataList.add(myData);
        myData = new MyData("ပုဗ္ဗဏှသုတ်",R.string.potebanna,R.raw.potebanna,R.string.potebanna_translate);
        dataList.add(myData);
        myAdapter = new MyAdapter(dataList,Dhamma.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(Dhamma.this));
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
        List<MyData> searchList = new ArrayList<>();
        for (MyData data : dataList) {
            if (data.getTitle().contains(newText)) {
                searchList.add(data);
            }
            myAdapter = new MyAdapter(searchList,Dhamma.this);
            recyclerView.setAdapter(myAdapter);
        }
        if (searchList.isEmpty()) {
            //Toast.makeText(Dhamma.this,"Not Found Data",Toast.LENGTH_SHORT).show();
            tvNoData.setVisibility(View.VISIBLE);
//            recyclerView.setVisibility(View.INVISIBLE);
        } else {
//            recyclerView.setVisibility(View.VISIBLE);
            tvNoData.setVisibility(View.INVISIBLE);
            //myAdapter.setSearchList(searchList);

        }
    }
}
