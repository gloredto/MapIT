package com.pptb.eirene.mapit;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UpdateProfile extends AppCompatActivity {

    private EditText updateName, updateBornWhere, updateBornWhen, updateAge;
    private Button saveUpdate;
    private ImageView profilePicture;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        setupUIViews();

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase =FirebaseDatabase.getInstance();

        final DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                UserProfile userProfile = dataSnapshot.getValue(UserProfile.class);
                updateName.setText(userProfile.getUserName());
                updateBornWhere.setText(userProfile.getUserBornWhere());
                updateBornWhen.setText(userProfile.getUserBornWhen());
                updateAge.setText(userProfile.getUserAge());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateProfile.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();
            }
        });

        saveUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = updateName.getText().toString();
                String bornwhere = updateBornWhere.getText().toString();
                String bornwhen = updateBornWhen.getText().toString();
                String age = updateAge.getText().toString();

                UserProfile userProfile = new UserProfile(name, bornwhere, bornwhen, age);

                databaseReference.setValue(userProfile);

                finish();
            }
        });

    }


    private void setupUIViews(){
        updateName = findViewById(R.id.mitUsernameUpdate);
        updateBornWhen = findViewById(R.id.mitBornWhenUpdate);
        updateBornWhere = findViewById(R.id.mitBornWhereUpdate);
        saveUpdate = findViewById(R.id.btnSaveUpdate);
        updateAge = findViewById(R.id.mitAgeUpdate);
        profilePicture = findViewById(R.id.mitPictureProfile);


    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
        }
        return super.onContextItemSelected(item);
    }
}
