package com.example.latihan_praktikum_7.ui;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.example.latihan_praktikum_7.R;
import com.example.latihan_praktikum_7.ui.home.HomeFragment;
import com.example.latihan_praktikum_7.ui.konten.KontenFragment;
import com.example.latihan_praktikum_7.ui.saya.SayaFragment;
import com.example.latihan_praktikum_7.ui.setting.SettingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        loadFragment(new HomeFragment());
        bottomNavigationView.setOnItemSelectedListener(item -> {
            Log.d("MainActivity", "Item selected: " + item.getItemId());
            Fragment selectedFragment = null;
            if (item.getItemId() == R.id.nav_home) {
                selectedFragment = new HomeFragment();
            } else if (item.getItemId() == R.id.nav_konten) {
                selectedFragment = new KontenFragment();
            } else if (item.getItemId() == R.id.nav_saya) {
                selectedFragment = new SayaFragment();
            } else if (item.getItemId() == R.id.nav_setting) {
                selectedFragment = new SettingFragment();
            }
            if (selectedFragment != null) {
                loadFragment(selectedFragment);
                return true;
            }
            return false;
        });
    }

    private void loadFragment(Fragment fragment) {
        Log.d("MainActivity", "Loading fragment: " + fragment.getClass().getSimpleName());  // Debug log
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container_fragment, fragment);
        transaction.commit();
    }
}

