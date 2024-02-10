package com.example.mychatgpt;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    Window window;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    MaterialToolbar toolbar;
    FrameLayout frameLayout;
    ImageView imageView;
    FloatingActionButton floatingActionButton;
    View headerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerLayout);
        toolbar = findViewById(R.id.material_toolber);
        navigationView = findViewById(R.id.navigationView);
        frameLayout = findViewById(R.id.frameLayout);


        // header image and button introduce ------------------------
        headerView = navigationView.getHeaderView(0);
        imageView = headerView.findViewById(R.id.imageView);
        floatingActionButton = headerView.findViewById(R.id.closeDrawer);

        floatingActionButton.setOnClickListener(v->{
            drawerLayout.closeDrawer(GravityCompat.START);
        });


        Picasso.get().load("https://square.github.io/picasso/static/sample.png").into(imageView);


        // default fragment add ==========================================
        fragmentReplace(new homeFragment());


         window = MainActivity.this.getWindow();
        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        // finally change the color
        window.setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.yellow));



        // Drawer layout Open and close = ====================================
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                MainActivity.this,drawerLayout,toolbar,R.string.DrawerOpen,R.string.DrawerClose);

        drawerLayout.addDrawerListener(toggle);


        // navigation item selected ======================================
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //how to select item ---------------------------------------
                if (item.getItemId()==R.id.share){
                    fragmentReplace(new homeFragment());
                    Toast.makeText(MainActivity.this, "dashBord", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                }if (item.getItemId() == R.id.dashbord){
                    Toast.makeText(MainActivity.this, "dashBord", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                return true;
            }
        });


        // app ber or tool ber icon select and click =======================================================
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                // how to select and work --------------------------
                if (item.getItemId() == R.id.theme){
                    fragmentReplace(new homeFragment());
                    Toast.makeText(MainActivity.this, "Theme", Toast.LENGTH_SHORT).show();
                } else if (item.getItemId() == R.id.dashBord) {
                    Toast.makeText(MainActivity.this, "dashBord", Toast.LENGTH_SHORT).show();
                }


                return false;
            }
        });


    }

    // fragment replace ----------------------------------
    private void fragmentReplace(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }



}