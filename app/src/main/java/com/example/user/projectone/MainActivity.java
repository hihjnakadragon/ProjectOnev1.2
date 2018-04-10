package com.example.user.projectone;

import android.content.Intent;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    NavigationView mNavigationView;
    DrawerLayout mDrawerLayout;
    FragmentManager manager;
    FloatingActionButton floatingActionButton;
    TextView textviewadd,textviewtoday,textviewnow,textviewicon,textviewcolour;
    private ActionBarDrawerToggle mToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        floatingActionButton=findViewById(R.id.floatone);
        mNavigationView=findViewById(R.id.navi);
        mDrawerLayout=findViewById(R.id.drawer);
        mToggle= new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditFragment editFragment=new EditFragment();
                FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.Content,editFragment);
                ft.commit();
            }
        });
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                xulichonmenu(item);
                return false;
            }
        });


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    void xulichonmenu(MenuItem item){
        int id=item.getItemId();
        Fragment fragment = null;
        Class classfragment = null;
        if(id == R.id.ngay)
            classfragment = CvtuanFragment.class;
        try{
            fragment = (Fragment)classfragment.newInstance();
            FragmentManager fmanager = getSupportFragmentManager();
            fmanager.beginTransaction()
                    .replace(R.id.Content,fragment)
                    .commit();

            item.setCheckable(true);
            setTitle(item.getTitle());
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }catch (Exception e){

        }

    }

}
