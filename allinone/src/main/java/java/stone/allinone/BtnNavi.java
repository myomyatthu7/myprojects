package java.stone.allinone;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

import java.stone.allinone.frgment.MusicFrg;
import java.stone.allinone.frgment.SettingFrg;
import java.stone.allinone.frgment.SubFrg;
import java.stone.allinone.frgment.homefrg;

public class BtnNavi extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {
    BottomNavigationView navigationView;
    FrameLayout frameLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.btn_navi);
        navigationView = findViewById(R.id.btnNavi);
        frameLayout = findViewById(R.id.frameOut);
        navigationView.setOnItemSelectedListener(this);
        replaceFrg(new homefrg());
    }
    public void replaceFrg(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameOut,fragment);
        ft.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int i = item.getItemId();
        if (i==R.id.home1) {
            replaceFrg(new homefrg());
        } else if (i==R.id.sub) {
            replaceFrg(new SubFrg());
        } else if (i==R.id.music) {
            replaceFrg(new MusicFrg());
        } else if (i==R.id.setting) {
            replaceFrg(new SettingFrg());
        }
        return true;
    }
}
