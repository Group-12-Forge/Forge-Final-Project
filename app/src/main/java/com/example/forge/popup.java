package com.example.forge;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class popup extends Activity {

    String report;
    Button saveBtn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.6));

        EditText writeReport = findViewById(R.id.writeReport);
        saveBtn = (Button) findViewById(R.id.saveBtn);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (writeReport != null) {
                    report = writeReport.getText().toString();
                }
                if (!report.equals("")) {
                    saveData(report);
                    Toast.makeText(popup.this,"Report Sent", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(popup.this,"You can't send an empty report!", Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(popup.this, MainScreen.class);
                startActivity(intent);
            }
        });
    }

    public void saveData (String report) {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = mAuth.getCurrentUser();
        if (firebaseUser != null) {
            String userid = firebaseUser.getUid();
            DatabaseReference databaseReference = FirebaseDatabase.getInstance("https://forge-9e1e5-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Reports");
            databaseReference.child(userid).setValue(report);
        }
    }
}
