package com.example.nitjamshedpurarchives12;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

public class homepage extends AppCompatActivity
{
    ImageView loginButton,signUPButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        loginButton=findViewById(R.id.loginButton);
        signUPButton=findViewById(R.id.signUpButton);
        loginButton.setAlpha(0f);
        signUPButton.setAlpha(0f);
        loginButton.animate().alpha(1f).setDuration(1000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run()
            { signUPButton.animate().alpha(1f).setDuration(2000);

            }
        } ,1000);



    }

    public void loginClicked(View view)
{
    Intent LoginIntent=new Intent(this,login.class);
    startActivity(LoginIntent);




}

    public void signupClicked(View view)
    {
        Intent LoginIntent=new Intent(this,signup.class);
        startActivity(LoginIntent);




    }
}