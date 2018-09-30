package com.pptb.eirene.mapit;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Profile extends AppCompatActivity {

    private TextView profileName, profileBornWhere, profileBornWhen, profileAge;
    private Button profileUpdate, changePassword;
    private ImageView profilePicture;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setupUIViews();


        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase =FirebaseDatabase.getInstance();

        DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                UserProfile userProfile = dataSnapshot.getValue(UserProfile.class);
                profileName.setText("Name : " + userProfile.getUserName());
                profileBornWhere.setText("Place of Birth  : " +userProfile.getUserBornWhere());
                profileBornWhen.setText("Date of Birth : " +userProfile.getUserBornWhen());
                profileAge.setText("Age : " +userProfile.getUserAge());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Profile.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();
            }
        });

        profileUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Profile.this, UpdateProfile.class));
            }
        });

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
        profileName = findViewById(R.id.mitUsernameUpdate);
        profileBornWhen = findViewById(R.id.mitBornWhenUpdate);
        profileBornWhere = findViewById(R.id.mitBornWhereUpdate);
        profileUpdate = findViewById(R.id.btnProfileUpdate);
        profileAge = findViewById(R.id.mitAgeUpdate);
        profilePicture = findViewById(R.id.mitPictureProfile);
        changePassword = findViewById(R.id.btnChangePassword);


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

