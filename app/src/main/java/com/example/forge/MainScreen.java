package com.example.forge;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainScreen extends AppCompatActivity {
    ImageButton chatBtn, matchesBtn;

    CircleImageView profile_image;
    ImageView profile_pic;
    TextView username;

    FirebaseUser firebaseUser;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        profile_image = findViewById(R.id.profile_image);
        profile_pic = findViewById(R.id.profile_pic);
        username = findViewById(R.id.username);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        if (firebaseUser != null) {
            reference = FirebaseDatabase.getInstance("https://forge-9e1e5-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Users").child(firebaseUser.getUid());

            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    User user = dataSnapshot.getValue(User.class);
                    if (user != null) {
                        username.setText(user.getUsername());
                        if (user.getImageURL().equals("default")) {
                            profile_image.setImageResource(R.drawable.ic_baseline_android_24);
                            profile_pic.setImageResource(R.drawable.ic_baseline_android_24);
                        } else if (user.getImageURL().equals("dolphin")) {
                            profile_image.setImageResource(R.drawable.profile1);
                            profile_pic.setImageResource(R.drawable.profile1);
                        } else if (user.getImageURL().equals("crocodile")) {
                            profile_image.setImageResource(R.drawable.profile2);
                            profile_pic.setImageResource(R.drawable.profile2);
                        } else if (user.getImageURL().equals("koala")) {
                            profile_image.setImageResource(R.drawable.profile3);
                            profile_pic.setImageResource(R.drawable.profile3);
                        } else if (user.getImageURL().equals("peacock")) {
                            profile_image.setImageResource(R.drawable.profile4);
                            profile_pic.setImageResource(R.drawable.profile4);
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

        chatBtn = findViewById(R.id.chatBtn);
        chatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChats();
            }
        });

        matchesBtn = findViewById(R.id.matchesBtn);
        matchesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMatches();
            }
        });

        ImageButton reportBtn = (ImageButton) findViewById(R.id.reportBtn);
        reportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainScreen.this, popup.class));
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case  R.id.logout:
                FirebaseAuth.getInstance().signOut();
                // change this code because your app will crash
                startActivity(new Intent(MainScreen.this, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                return true;
        }

        return false;
    }

    private void openMatches() {
        Intent intent = new Intent(MainScreen.this, Matches.class);
        startActivity(intent);
    }

    private void openChats() {
        Intent intent = new Intent (MainScreen.this, DisplayChats.class);
        startActivity(intent);
    }


}