package java.stone.allinone.project1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.stone.allinone.R;
import java.stone.allinone.ToastMsg;

public class DetailActivity extends AppCompatActivity {
    TextView detailTitle,detailDesc;
    ImageView detailImage;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        detailImage = findViewById(R.id.detailImage);
        detailTitle = findViewById(R.id.detailTitle);
        detailDesc = findViewById(R.id.detailDesc);

        Bundle bd = getIntent().getExtras();
        if (bd != null) {
            detailTitle.setText(bd.getString("Title"));
            detailDesc.setText(bd.getInt("Desc"));
            detailImage.setImageResource(bd.getInt("Image"));
        }

    }

    //    TextView detailDesc, detailTitle;
//    ImageView detailImage;
//
//    Button btnPlus,btnMinus;
//    int size = 15;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_detail);
//
//        detailDesc = findViewById(R.id.detailDesc);
//        detailTitle = findViewById(R.id.detailTitle);
//        detailImage = findViewById(R.id.detailImage);
//        btnPlus = findViewById(R.id.btnPlus);
//        btnMinus = findViewById(R.id.btnMinus);
//        btnPlus.setOnClickListener(this);
//        btnMinus.setOnClickListener(this);
//
//        Bundle bundle = getIntent().getExtras();
//        if (bundle != null){
//            detailDesc.setText(bundle.getInt("Desc"));
//            detailImage.setImageResource(bundle.getInt("Image"));
//            detailTitle.setText(bundle.getString("Title"));
//        }
//    }
//
//@Override
//public void onClick(View v) {
//        if (v.getId() == R.id.btnPlus) {
//            size += 2;
//            detailDesc.setTextSize(size);
//        } else if (v.getId() == R.id.btnMinus) {
//            if (size <= 11 ) {
//                ToastMsg.toastMsg(DetailActivity.this,"Min Limit!");
//            } else {
//                size -= 2;
//                detailDesc.setTextSize(size);
//            }
//        }
//    }
}
