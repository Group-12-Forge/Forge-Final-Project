package com.example.forge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserDetails extends AppCompatActivity {

    String imageSelection = "default";
    ImageButton profile1;
    ImageButton profile2;
    ImageButton profile3;
    ImageButton profile4;

    String bio;
    EditText bioInput;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        bioInput = (EditText) findViewById(R.id.bio);
        button = (Button) findViewById(R.id.button);
        profile1 = (ImageButton) findViewById(R.id.dolphin);
        profile2 = (ImageButton) findViewById(R.id.crocodile);
        profile3 = (ImageButton) findViewById(R.id.koala);
        profile4 = (ImageButton) findViewById(R.id.peacock);

        profile1.setImageResource(R.drawable.profile1);
        profile2.setImageResource(R.drawable.profile2);
        profile3.setImageResource(R.drawable.profile3);
        profile4.setImageResource(R.drawable.profile4);

        //String imageurl = "default";

        profile1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: send image selection to database
                imageSelection = "dolphin";
                Toast.makeText(UserDetails.this, "Dolphin selected", Toast.LENGTH_SHORT).show();
            }
        });

        profile2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageSelection = "crocodile";
                Toast.makeText(UserDetails.this, "Crocodile selected", Toast.LENGTH_SHORT).show();
            }
        });

        profile3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageSelection = "koala";
                Toast.makeText(UserDetails.this, "Koala selected", Toast.LENGTH_SHORT).show();
            }
        });

        profile4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageSelection = "peacock";
                Toast.makeText(UserDetails.this, "Peacock selected", Toast.LENGTH_SHORT).show();
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bio = bioInput.getText().toString();

                FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
                if (firebaseUser != null) {
                    DatabaseReference databaseReference = FirebaseDatabase.getInstance("https://forge-9e1e5-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Users");
                    String userid = firebaseUser.getUid();
                    databaseReference.child(userid).child("imageURL").setValue(imageSelection);
                    databaseReference.child(userid).child("bio").setValue(bio);
                }
                openPreMBTI();

                //send this bio to database
            }
        });
    }

    private void openPreMBTI() {
        Intent intent = new Intent(UserDetails.this, PreMBTI.class);
        startActivity(intent);
    }
}
