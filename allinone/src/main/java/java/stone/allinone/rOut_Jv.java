package java.stone.allinone;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class rOut_Jv extends AppCompatActivity implements View.OnClickListener {
    RelativeLayout rOut,relativeLayout;
    TextView tvOne;
    Button btnOne;
    RelativeLayout.LayoutParams tvOneParam,btnOneParam;
    int btnId = 1,tvId = 2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(
//                WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN
//        );
        setContentView(R.layout.r_out);
        rOut = findViewById(R.id.rOut);
        setUpUi();
        registerForContextMenu(tvOne);
        btnOne.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_java,menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_java,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    private void setUpUi() {
        relativeLayout = new RelativeLayout(rOut_Jv.this);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT
        );
        relativeLayout.setLayoutParams(params);
        relativeLayout.setBackgroundColor(Color.CYAN);
        rOut.addView(relativeLayout,params);
        createTextView();
        createButton();
        relativeLayout.addView(tvOne,tvOneParam);
        relativeLayout.addView(btnOne,btnOneParam);
    }

    private void createButton() {
        tvOne = new TextView(rOut_Jv.this);
        tvOneParam = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        tvOne.setLayoutParams(btnOneParam);
        tvOne.setText("TextView One");
        tvOne.setTextSize(25);
        tvOne.setId(tvId);
    }

    private void createTextView() {
        btnOne = new Button(rOut_Jv.this);
        btnOneParam = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        btnOne.setLayoutParams(btnOneParam);
        btnOneParam.addRule(RelativeLayout.BELOW,tvId);
        btnOne.setText("Button One");
        btnOne.setTextSize(25);
        btnOne.setId(btnId);
    }

    @Override
    public void onClick(View v) {
        ToastMsg.toastMsg(getApplicationContext(),"Hello");
        PopupMenu popupMenu = new PopupMenu(rOut_Jv.this,btnOne);
        popupMenu.getMenuInflater().inflate(R.menu.menu_java, popupMenu.getMenu());
        popupMenu.show();
    }
}
