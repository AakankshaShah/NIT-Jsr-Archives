package com.example.nitjamshedpurarchives12;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText loginEmail,loginPassword;
    Button login;
    String loginEmailString,loginPasswordString;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        loginEmail=findViewById(R.id.loginEmail);
        loginPassword=findViewById(R.id.loginPassword);
        login=findViewById(R.id.Login);
        loginEmailString=loginEmail.getText().toString();
        loginPasswordString=loginPassword.getText().toString();

        mAuthListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth)
            {
                if(firebaseAuth.getCurrentUser()!=null)

                Toast.makeText(login.this,"Already Logged",Toast.LENGTH_SHORT).show();
                Intent loggedInt=new Intent(login.this,LoginscreenActivity.class);

                startActivity(loggedInt);
            }
        };



    }
    @Override
    public void onStart()
    {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        mAuth.addAuthStateListener(mAuthListener);
        //updateUI(currentUser);
    }

    public void loginClicked(View view) {
        loginEmailString=loginEmail.getText().toString();
        loginPasswordString=loginPassword.getText().toString();
        if (loginPasswordString.isEmpty() && loginEmailString.isEmpty())
        {
Toast.makeText(login.this,"Enter valid email and pasword",Toast.LENGTH_SHORT).show();
        } else
            {
            mAuth.signInWithEmailAndPassword(loginEmailString, loginPasswordString)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Toast.makeText(login.this, "Authentication Success",
                                        Toast.LENGTH_SHORT).show();
                                FirebaseUser user = mAuth.getCurrentUser();
                                Intent loggedInt=new Intent(login.this,LoginscreenActivity.class);

                                startActivity(loggedInt);
                                //updateUI(user);
                            } else {
                                // If sign in fails, display a message to the user.

                                Toast.makeText(login.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                                //updateUI(null);
                            }

                            // ...
                        }
                    });


        }
    }




}