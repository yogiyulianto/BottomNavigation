package com.bringin.iak.learnbottomnavigatioinbar;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Fragment menu1Fragment = new Menu1kFragment();
    Fragment menu2Fragment = new Menu2Fragment();
    Fragment menu3Fragment = new Menu3Fragment();
    FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.menu1:
                        setMenuFragment(menu1Fragment);
                        break;

                    case R.id.menu2:
                        setMenuFragment(menu2Fragment);
                        break;

                    case R.id.menu3:
                        setMenuFragment (menu3Fragment);
                        break;

                }


                return true;
            }
        });
    }

    public void setMenuFragment(Fragment fragment){
        fragmentManager.beginTransaction()
                .replace(R.id.container_layout,fragment)
                .commit();
    }
}
