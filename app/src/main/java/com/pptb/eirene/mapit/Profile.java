package com.pptb.eirene.mapit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Profile extends AppCompatActivity {

    private EditText userName, userPassword, userEmail, userAge;
    private Button regButton;
    private TextView userLogin;
    private ImageView userProfilePicture;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setupUIViews();


        firebaseAuth = FirebaseAuth.getInstance();
    }

    private void Logout(){
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(Profile.this, Login.class));
    }

    private void About(){
        startActivity(new Intent(Profile.this, About.class));
    }

    private void Profile(){
        startActivity(new Intent(Profile.this, Profile.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    private void setupUIViews(){
        userName = findViewById(R.id.mitUsername);
        userPassword = findViewById(R.id.mitLoginPassword);
        userEmail = findViewById(R.id.mitEmail);
        regButton = findViewById(R.id.btnUpdateProfile);
        userLogin = findViewById(R.id.mitLogin);
        userAge = findViewById(R.id.mitAge);
        userProfilePicture = findViewById(R.id.mitProfilePicture);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case  R.id.logoutMenu:{
                Logout();
            }
            break;
            case R.id.aboutMenu:{
                About();
            }
            break;
            case R.id.profileMenu:{
                Profile();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}

