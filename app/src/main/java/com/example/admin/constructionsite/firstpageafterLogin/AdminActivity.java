package com.example.admin.constructionsite.firstpageafterLogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.admin.constructionsite.ArrayListOfObjects;
import com.example.admin.constructionsite.R;
import com.example.admin.constructionsite.secondpagepofadmin.SiteObject;
import com.example.admin.constructionsite.secondpagepofadmin.pagewillbefloodedwithpipeline;

import java.util.ArrayList;

public class AdminActivity extends AppCompatActivity {

    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specificforadminnow);

        final ArrayList<firstpage> words = new ArrayList<>();
        words.add(new firstpage("Pipeline"));
        words.add(new firstpage("Water Tank"));
        words.add(new firstpage("Road Pavement"));
        words.add(new firstpage("Building"));
        firstpageadapter adapter = new firstpageadapter(this, words, R.color.pink_200);
        GridView gridView = findViewById(R.id.firstopening);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                firstpage k1 = words.get(position);

                switch (k1.getTitle()) {
                    case "Pipeline": {
                        ArrayListOfObjects.pipeline.add(new SiteObject("Pipeline", "Ganesh", "Miraj", "Kore"));
                        ArrayListOfObjects.pipeline.add(new SiteObject("Pipeline", "Erica", "Sangli", "Patil"));
                        ArrayListOfObjects.pipeline.add(new SiteObject("Pipeline", "Grand Hayat", "Mumbai", "Mohite"));
                        startActivity(new Intent(AdminActivity.this, pagewillbefloodedwithpipeline.class));
                    }
                }


            }
        });

        dl =  findViewById(R.id.activity_main);
        t = new ActionBarDrawerToggle(this, dl, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nv =  findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.addsite:
                        Toast.makeText(AdminActivity.this, "SITE ADDED", Toast.LENGTH_SHORT).show();
                    case R.id.deletesite:
                        Toast.makeText(AdminActivity.this, "SITE DELETED", Toast.LENGTH_SHORT).show();
                    case R.id.locate:
                        Toast.makeText(AdminActivity.this, "LOCATING USER", Toast.LENGTH_SHORT).show();
                    default:
                        return true;
                }


            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }
}



