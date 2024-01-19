package java.stone.allinone.frgment;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.stone.allinone.MyHelperAdapter;
import java.stone.allinone.R;
import java.stone.allinone.SQLiteHelperAdapter;
import java.stone.allinone.ToastMsg;


public class SubFrg extends Fragment implements View.OnClickListener, SearchView.OnQueryTextListener {
    View v;
    //MyHelperAdapter myHelper;
    SQLiteHelperAdapter sqLiteHelperAdapter;
    //TextView tvStuCode,tvStuName,tvStuCity,tvStuId;
    EditText etStuCode,etStuName,etStuCity,etStuId;
    Button btnInsert,btnQuery,btnUpdate,btnDelete;
    SearchView dbSearch;
    String searchText = "";

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_sub_frg, container, false);
        // Inflate the layout for this fragment
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etStuCode = v.findViewById(R.id.etStuCode);
        etStuName = v.findViewById(R.id.etStuName);
        etStuCity = v.findViewById(R.id.etStuCity);
        etStuId = v.findViewById(R.id.etId);
        btnInsert = v.findViewById(R.id.btnInsert);
        btnQuery = v.findViewById(R.id.btnQuery);
        btnUpdate = v.findViewById(R.id.btnUpdate);
        btnDelete = v.findViewById(R.id.btnDelete);
        dbSearch = v.findViewById(R.id.dbSearch);
        btnInsert.setOnClickListener(this);
        btnQuery.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        //myHelper = new MyHelperAdapter(getContext());
        sqLiteHelperAdapter = new SQLiteHelperAdapter(getContext());
        dbSearch.setOnQueryTextListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btnInsert) {
            startInset();
        } else if (id == R.id.btnQuery) {
            startQuery();
        } else if (id == R.id.btnUpdate) {
            startUpdate();
        } else if (id == R.id.btnDelete) {
            startDelete();
        }
    }
    private void startInset() {
//        String name = etStuName.getText().toString();
//        String code = etStuCode.getText().toString();
//        String city = etStuCity.getText().toString();
//        sqLiteHelperAdapter.dbOpen();
//        Long id = sqLiteHelperAdapter.dataInsert(name,code,city);
//        if (id<0) {
//            ToastMsg.toastMsg(getContext(),"Something wrong!");
//        } else {
//            ToastMsg.toastMsg(getContext(),"Success!");
//        }
//        sqLiteHelperAdapter.dbClose();

        String name = etStuName.getText().toString();
        String code = etStuCode.getText().toString();
        String city = etStuCity.getText().toString();
        sqLiteHelperAdapter.dbOpen();
        long id = sqLiteHelperAdapter.dataInsert(name,code,city);
        sqLiteHelperAdapter.dbClose();
        if (id<0) {
            ToastMsg.toastMsg(getContext(),"Something wrong!");
        } else {
            ToastMsg.toastMsg(getContext(),"Success!");
        }
    }
    private void startQuery() {
//        sqLiteHelperAdapter.dbOpen();
//        String info = sqLiteHelperAdapter.dataQuery();
//        ToastMsg.toastMsg(getContext(),info);
//        sqLiteHelperAdapter.dbClose();
        //String name = etStuName.getText().toString();
        sqLiteHelperAdapter.dbOpen();
        if (searchText.isEmpty()) {
            ToastMsg.toastMsg(getContext(),"Insert Text");
        } else {
            String info = sqLiteHelperAdapter.dataQuery(searchText);
            if (info.isEmpty()) {
                ToastMsg.toastMsg(getContext(),"No Found");
            } else {
                ToastMsg.toastMsg(getContext(),info);
                dbSearch.setQuery("",true);
            }
        }
        sqLiteHelperAdapter.dbClose();
    }

    private void startDelete() {
        sqLiteHelperAdapter.dbOpen();
        int row = sqLiteHelperAdapter.dataDelete(searchText);
        sqLiteHelperAdapter.dbClose();
        ToastMsg.toastMsg(getContext(),"Row "+row+" is affected");
    }

    private void startUpdate() {
        String name = etStuName.getText().toString();
        String code = etStuCode.getText().toString();
        String city = etStuCity.getText().toString();
        sqLiteHelperAdapter.dbOpen();
        if (searchText.isEmpty() || name.isEmpty()) {
            ToastMsg.toastMsg(getContext(),"Insert OldText and New Text");
            //ToastMsg.toastMsg(getContext(),name);
            //ToastMsg.toastMsg(getContext(),searchText);
        } else {
            int row = sqLiteHelperAdapter.dataUpdate(searchText,name,code,city);
            ToastMsg.toastMsg(getContext(),"Row "+row+" is affected!");
            //ToastMsg.toastMsg(getContext(),"No empty");
        }
        sqLiteHelperAdapter.dbClose();

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        searchText = newText;
        return true;
    }
}