package com.example.nitjamshedpurarchives12;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Handler;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
{
    ImageView nitjsrlogo;

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nitjsrlogo=findViewById(R.id.nitjsrlogo);
        //nitjsrlogo.setAlpha(0f);
        nitjsrlogo.setAlpha(1f);
        nitjsrlogo.animate().scaleXBy(1.105f).scaleYBy(1.105f).setDuration(3000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run()
            { Intent homepageIntent =new Intent(MainActivity.this,homepage.class);
                startActivity(homepageIntent);


            }
        } ,3250);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


}