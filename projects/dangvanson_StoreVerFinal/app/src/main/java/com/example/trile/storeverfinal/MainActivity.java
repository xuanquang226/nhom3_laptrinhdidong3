package com.example.trile.storeverfinal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.trile.storeverfinal.HoangNhatSon.Java.ListFragment;
import com.example.trile.storeverfinal.LeMinhTri.Java.HomeFragment;
import com.example.trile.storeverfinal.NguyenThanhCong.Java.UserFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    HomeFragment fragment1 = new HomeFragment();
                    android.support.v4.app.FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction1.replace(R.id.content,fragment1,"Fragment");
                    fragmentTransaction1.commit();
                    return true;
                case R.id.navigation_dashboard:
                    ListFragment fragment2 = new ListFragment();
                    android.support.v4.app.FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction2.replace(R.id.content,fragment2,"Fragment");
                    fragmentTransaction2.commit();
                    return true;
                case R.id.navigation_notifications:
                    UserFragment fragment3 = new UserFragment();
                    android.support.v4.app.FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction3.replace(R.id.content,fragment3,"Fragment");
                    fragmentTransaction3.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        // HIỂN THỊ TRANG ĐẦU TIÊN MẶC ĐỊNH
        HomeFragment fragment1 = new HomeFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
        fragmentTransaction1.replace(R.id.content,fragment1,"Fragment");
        fragmentTransaction1.commit();
    }

}
