package com.example.stone.a001_flash;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class PhoneCall_Activity extends AppCompatActivity implements View.OnClickListener {

    EditText etPhoneCall;
    Button btnPhoneCall,btnCheckBill;

    int PERMISSION_CODE = 10;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phone_call_activity);

        etPhoneCall = findViewById(R.id.etPhoneCall);
        btnPhoneCall = findViewById(R.id.btnPhoneCall);
        btnCheckBill = findViewById(R.id.btnCheckBill);

        btnCheckBill.setOnClickListener(this);
        btnPhoneCall.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.S)
    @Override
    public void onClick(View v) {
//        Boolean request = true;
//        if (v.getId()==R.id.btnPhoneCall) {
//            if (ActivityCompat.checkSelfPermission(PhoneCall_Activity.this,
//                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
//            {
//                    ActivityCompat.requestPermissions(PhoneCall_Activity.this,
//                            new String[]{Manifest.permission.CALL_PHONE},PERMISSION_CODE);
//            } else {
//                Intent iPhoneCall = new Intent(Intent.ACTION_CALL);
//                String strPhoneCall = etPhoneCall.getText().toString().trim();
//                iPhoneCall.setData(Uri.parse("tel:"+strPhoneCall));
//                startActivity(iPhoneCall);
//            }
//        }

//        if (v.getId() == R.id.btnPhoneCall || v.getId() == R.id.btnCheckBill) {
//            if (ActivityCompat.checkSelfPermission(PhoneCall_Activity.this,Manifest.permission.CALL_PHONE) !=
//                PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(PhoneCall_Activity.this,
//                    new String[]{Manifest.permission.CALL_PHONE},PERMISSION_CODE);
//        }  else if (v.getId() == R.id.btnPhoneCall) {
//                phoneCall();
//            } else if (v.getId() == R.id.btnCheckBill){
//                checkBill();
//            }
//        }

        if (v.getId() == R.id.btnPhoneCall| v.getId() == R.id.btnCheckBill) {
            if (ActivityCompat.checkSelfPermission(PhoneCall_Activity.this,
                    Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(PhoneCall_Activity.this,
                        new String[]{Manifest.permission.CALL_PHONE},PERMISSION_CODE);
            } else if (v.getId() == R.id.btnPhoneCall) {
                phoneCall();
            } else if (v.getId() == R.id.btnCheckBill) {
                checkBill();
            }
        }
    }

    private void checkBill() {
        Intent icBill = new Intent(Intent.ACTION_CALL);
        String hash = Uri.encode("#");
        String checkBill = "*124"+hash;
        icBill.setData(Uri.parse("tel:"+checkBill));
        startActivity(icBill);
    }

    private void phoneCall() {
        Intent ipCall = new Intent(Intent.ACTION_CALL);
        String no = etPhoneCall.getText().toString().trim();
        if (no.startsWith("09")) {
            ipCall.setData(Uri.parse("tel:"+no));
        } else {
            ipCall.setData(Uri.parse("tel:"+"09"+no));
        }
        startActivity(ipCall);
    }


//    private void checkBill() {
//        Intent iCheckBill = new Intent(Intent.ACTION_CALL);
//            String strCheckBill = Uri.encode("#");
//            String strCheckBills = "*124"+strCheckBill;
//            iCheckBill.setData(Uri.parse("tel:"+strCheckBills));
//            startActivity(iCheckBill);
//    }

//    private void phoneCall() {
//        Intent iPhoneCall = new Intent(Intent.ACTION_CALL);
//        String strPhoneCall = etPhoneCall.getText().toString().trim();
//        iPhoneCall.setData(Uri.parse("tel:"+strPhoneCall));
//        startActivity(iPhoneCall);
//    }

//    public void requestPermission1(Context context) {
//        if (ActivityCompat.checkSelfPermission(context,Manifest.permission.CALL_PHONE) ==
//                PackageManager.PERMISSION_DENIED) {
//            ActivityCompat.requestPermissions((Activity) context,
//                    new String[]{Manifest.permission.CALL_PHONE,Manifest.permission.READ_EXTERNAL_STORAGE},PERMISSION_CODE);
//        } else {
//            Intent iPhoneCall = new Intent(Intent.ACTION_CALL);
//            String strPhoneCall = etPhoneCall.getText().toString().trim();
//            iPhoneCall.setData(Uri.parse("tel:"+strPhoneCall));
//            startActivity(iPhoneCall);
//        }
//    }
//    public void requestPermission2(Context context) {
//        if (ActivityCompat.checkSelfPermission(context,Manifest.permission.CALL_PHONE)!=
//                PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions((Activity) context,
//                    new String[]{Manifest.permission.CALL_PHONE},PERMISSION_CODE);
//        } else {
//            Intent iCheckBill = new Intent(Intent.ACTION_CALL);
//            String strCheckBill = Uri.encode("#");
//            String strCheckBills = "*124"+strCheckBill;
//            iCheckBill.setData(Uri.parse("tel:"+strCheckBills));
//            startActivity(iCheckBill);
//        }
//    }


//    private void requestPermission1(Context context) {
//        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_DENIED) {
//            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.CALL_PHONE},PERMISSION_CODE);
//        } else {
//            Intent iPhoneCall = new Intent(Intent.ACTION_CALL);
//            String strPhoneCall = etPhoneCall.getText().toString().trim();
//            iPhoneCall.setData(Uri.parse("tel:"+strPhoneCall));
//            startActivity(iPhoneCall);
//        }
//    }
//
//    private void requestPermission2(Context context) {
//        if (ActivityCompat.checkSelfPermission(context,Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions((Activity) context,new String[]{Manifest.permission.CALL_PHONE},PERMISSION_CODE);
//        } else {
//            Intent iCheckBill = new Intent(Intent.ACTION_CALL);
//            String strEncode = Uri.encode("#");
//            String strCheckBill = "*124"+strEncode;
//            iCheckBill.setData(Uri.parse("tel:"+strCheckBill));
//            startActivity(iCheckBill);
//        }
//    }
}