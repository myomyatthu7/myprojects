package com.example.stone.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.stone.fragment.library.ToastMessage;

public class Frg_Tran extends AppCompatActivity implements View.OnClickListener {
    FragmentManager fm;
    //FragmentTransaction ft;
    FragmentTransaction ftr;
    Button btnAdd,btnRemove,btnReplace,btnDetach,btnAttach;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frg_tran);
        setUi();
       // ToastMessage.toastMsg(getApplicationContext(),"Activity: onCreate !");
    }

    private void setUi() {
        btnAdd = findViewById(R.id.btnAddFrg);
        btnRemove = findViewById(R.id.btnRemoveFrg);
        btnReplace = findViewById(R.id.btnReplaceFrg);
        btnDetach = findViewById(R.id.btnDetachFrg);
        btnAttach = findViewById(R.id.btnAttachFrg);
        btnAdd.setOnClickListener(this);
        btnRemove.setOnClickListener(this);
        btnReplace.setOnClickListener(this);
        btnDetach.setOnClickListener(this);
        btnAttach.setOnClickListener(this);
        fm = getSupportFragmentManager();
        //ft = fm.beginTransaction();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAddFrg) {
            Frg_One_Tr fot = new Frg_One_Tr();
            ftr = fm.beginTransaction();
            ftr.add(R.id.frgHolder, fot, "FOne");
            ftr.commit();
        } else if (v.getId() == R.id.btnRemoveFrg) {
            Frg_One_Tr fot = (Frg_One_Tr) fm.findFragmentByTag("FOne");
            Frg_Two_Tr ftt = (Frg_Two_Tr) fm.findFragmentByTag("FTwo");
            ftr = fm.beginTransaction();
            if (fot != null) {
                ftr.remove(fot);
                //ft.commit();
            } else if (ftt != null) {
                ftr.remove(ftt);
                // ft.commit();
            } else {
                ToastMessage.toastMsg(getApplicationContext(), "No Fragment To Remove");
            }
            ftr.commit();
        } else if (v.getId() == R.id.btnReplaceFrg) {
            Frg_Two_Tr ftt = new Frg_Two_Tr();
            ftr = fm.beginTransaction();
            ftr.replace(R.id.frgHolder, ftt, "FTwo");
            ftr.commit();
        } else if (v.getId() == R.id.btnDetachFrg) {
            Frg_One_Tr fot = (Frg_One_Tr) fm.findFragmentByTag("FOne");
            ftr = fm.beginTransaction();
            if (fot != null) {
                ftr.detach(fot);
            } else {
                ToastMessage.toastMsg(getApplicationContext(), "No Fragment To Detach");
            }
            ftr.commit();
        } else if (v.getId() == R.id.btnAttachFrg) {
            Frg_One_Tr fot = (Frg_One_Tr) fm.findFragmentByTag("FOne");
            ftr = fm.beginTransaction();
            if (fot != null) {
                ftr.attach(fot);
            } else {
                ToastMessage.toastMsg(getApplicationContext(), "No Fragment To Attach");
            }
            ftr.commit();
        }
    }

//    void loadFrg(androidx.fragment.app.Fragment fragment) {
//             idae;
//    }
    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        ToastMessage.toastMsg(getApplicationContext(),"Activity: onAttachFragment !");
    }

    @Override
    protected void onStart() {
        super.onStart();
        ToastMessage.toastMsg(getApplicationContext(),"Activity: onStart !");
    }

    @Override
    protected void onResume() {
        super.onResume();
        ToastMessage.toastMsg(getApplicationContext(),"Activity: onResume !");
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        ToastMessage.toastMsg(getApplicationContext(),"Activity: onResumeFragments !");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        ToastMessage.toastMsg(getApplicationContext(),"Activity: onPostResume !");
    }

    @Override
    protected void onPause() {
        super.onPause();
        ToastMessage.toastMsg(getApplicationContext(),"Activity: onPause !");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        ToastMessage.toastMsg(getApplicationContext(),"Activity: onSaveInstanceState !");
    }

    @Override
    protected void onStop() {
        super.onStop();
        ToastMessage.toastMsg(getApplicationContext(),"Activity: onStop !");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        ToastMessage.toastMsg(getApplicationContext(),"Activity: onRestart !");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        ToastMessage.toastMsg(getApplicationContext(),"Activity: onRestoreInstanceState !");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ToastMessage.toastMsg(getApplicationContext(),"Activity: onDestroy !");
    }

//    public void addFrg(View v) {
//        fm = getSupportFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//        Frg_One_Tr fot = new Frg_One_Tr();
//        ft.add(R.id.frgHolder,fot,"fOne");
//        ft.commit();
//    }
//    public void removeFrg(View v) {
//        Frg_One_Tr fot = (Frg_One_Tr) fm.findFragmentByTag("fOne");
//        Frg_Two_Tr ftt = (Frg_Two_Tr) fm.findFragmentByTag("ROne");
//        FragmentTransaction ft = fm.beginTransaction();
//        if (fot != null) {
//            ft.remove(fot);
//        } else if ( ftt != null) {
//            ft.remove(ftt);
//        } else {
//            Toast.makeText(this, "No Frg(Remove)", Toast.LENGTH_SHORT).show();
//        }
//        ft.commit();
//    }
//    public void replaceTwo(View v) {
//        Frg_Two_Tr ftt = new Frg_Two_Tr();
//        FragmentTransaction ft = fm.beginTransaction();
//        ft.replace(R.id.frgHolder,ftt,"ROne");
//        ft.commit();
//    }
//    public void detachOne(View v) {
//        Frg_One_Tr fot = (Frg_One_Tr) fm.findFragmentByTag("fOne");
//        FragmentTransaction ft = fm.beginTransaction();
//        if (fot != null) {
//            ft.detach(fot);
//            ft.commit();
//        } else {
//            Toast.makeText(this,"No Frg(detach)",Toast.LENGTH_SHORT).show();
//        }
//
//    }
//    public void attachOne(View v) {
//        Frg_One_Tr fot = (Frg_One_Tr) fm.findFragmentByTag("fOne");
//        FragmentTransaction ft = fm.beginTransaction();
//        if (fot != null) {
//            ft.attach(fot);
//            ft.commit();
//        } else {
//            Toast.makeText(this,"No Frg(attach)",Toast.LENGTH_SHORT).show();
//        }
//    }

}
