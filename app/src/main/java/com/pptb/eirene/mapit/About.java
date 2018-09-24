package com.pptb.eirene.mapit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class About extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private TextView githubLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        githubLink = (TextView)findViewById(R.id.mitGithub);

        githubLink.setText(
                Html.fromHtml(
                        "<a href=\"https://github.com/gloredto/MapIT\">github.com/gloredto/MapIT</a> "));
        githubLink.setMovementMethod(LinkMovementMethod.getInstance());

        firebaseAuth = FirebaseAuth.getInstance();
    }

    private void Logout(){
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(About.this, Login.class));
    }

    private void About(){
        startActivity(new Intent(About.this, About.class));
    }

    private void Profile(){
        startActivity(new Intent(About.this, Profile.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
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

