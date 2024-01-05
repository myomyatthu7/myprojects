package java.stone.allinone;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;

public class Dtny_Ls extends ListActivity {
    String [] ary = {"java","kotlin","Sql","Firebase"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_host);
        getListView();
        ArrayAdapter<String>adapter = new ArrayAdapter<>(Dtny_Ls.this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,ary);
        setListAdapter(adapter);
    }
}
