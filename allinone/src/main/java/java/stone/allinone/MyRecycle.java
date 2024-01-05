package java.stone.allinone;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MyRecycle extends AppCompatActivity implements View.OnClickListener {

    RecyclerView rcv;
    MyAdapter myAdapter;
    List<MyModel>list = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle);
        rcv = findViewById(R.id.rcv);
        MyModel m1 = new MyModel(R.drawable.ajax,"Java","java@gmail.com");
        MyModel m2 = new MyModel(R.drawable.c,"C","java@gmail.com");
        MyModel m3 = new MyModel(R.drawable.c_plus_plus,"C++","java@gmail.com");
        MyModel m4 = new MyModel(R.drawable.css,"CSS","java@gmail.com");
        MyModel m5 = new MyModel(R.drawable.css_3,"CSS_3","java@gmail.com");
        MyModel m6 = new MyModel(R.drawable.flutter,"flutter","java@gmail.com");
        MyModel m7 = new MyModel(R.drawable.html,"html","java@gmail.com");
        MyModel m8 = new MyModel(R.drawable.html_5,"html_5","java@gmail.com");
        MyModel m9 = new MyModel(R.drawable.java,"Java","java@gmail.com");
        MyModel m10 = new MyModel(R.drawable.javascript,"Javascript","java@gmail.com");
        MyModel m11 = new MyModel(R.drawable.kotlin,"Kotlin","java@gmail.com");
        MyModel m12 = new MyModel(R.drawable.mysql,"Mysql","java@gmail.com");
        MyModel m13 = new MyModel(R.drawable.php,"PHP","java@gmail.com");
        MyModel m14 = new MyModel(R.drawable.ruby,"Ruby","java@gmail.com");
        list.add(m1);
        list.add(m2);
        list.add(m3);
        list.add(m4);
        list.add(m4);
        list.add(m5);
        list.add(m6);
        list.add(m7);
        list.add(m8);
        list.add(m9);
        list.add(m10);
        list.add(m11);
        list.add(m12);
        list.add(m13);
        list.add(m14);
        myAdapter = new MyAdapter(list);
        rcv.setLayoutManager(new LinearLayoutManager(MyRecycle.this));
        rcv.setAdapter(myAdapter);
        rcv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        ToastMsg.toastMsg(MyRecycle.this,String.valueOf(v));
    }
}
