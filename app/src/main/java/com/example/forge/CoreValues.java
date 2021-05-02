package com.example.forge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.prefs.Preferences;

public class CoreValues extends AppCompatActivity {

    int checkedCount = 0;
    String value = "";
    String offer = "";
    String selectedCoreValues = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_core_values);

        CheckBox driveCheckBox = (CheckBox) findViewById(R.id.driveCheckBox);
        CheckBox honestyCheckBox = (CheckBox) findViewById(R.id.honestyCheckBox);
        CheckBox communicationCheckBox = (CheckBox) findViewById(R.id.communicationCheckBox);
        CheckBox loyaltyCheckBox = (CheckBox) findViewById(R.id.loyaltyCheckBox);
        CheckBox empathyCheckBox = (CheckBox) findViewById(R.id.empathyCheckBox);
        CheckBox reliabilityCheckBox = (CheckBox) findViewById(R.id.reliabilityCheckBox);
        CheckBox openCheckBox = (CheckBox) findViewById(R.id.openCheckBox);
        CheckBox humourCheckBox = (CheckBox) findViewById(R.id.humourCheckBox);
        CheckBox independenceCheckBox = (CheckBox) findViewById(R.id.independenceCheckBox);
        CheckBox creativityCheckBox = (CheckBox) findViewById(R.id.creativityCheckBox);

        Spinner value_spinner = (Spinner)findViewById(R.id.spinner1);
        Spinner offer_spinner = (Spinner)findViewById(R.id.spinner2);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(CoreValues.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.names));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        value_spinner.setAdapter(adapter);
        offer_spinner.setAdapter(adapter);

        driveCheckBox.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox) v).isChecked();

                if (checked == true && checkedCount<3){
                    checkedCount += 1;
                    selectedCoreValues = selectedCoreValues + "DRI";
                }
                else if(checked == true && checkedCount==3){
                    driveCheckBox.setChecked(false);
                }
                else{
                    checkedCount -= 1;
                }

            }

        });

        honestyCheckBox.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox) v).isChecked();

                if (checked == true && checkedCount<3){
                    checkedCount += 1;
                    selectedCoreValues = selectedCoreValues + "HON";
                }
                else if(checked == true && checkedCount==3){
                    honestyCheckBox.setChecked(false);
                }
                else{
                    checkedCount -= 1;
                }

            }

        });

        communicationCheckBox.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox) v).isChecked();

                if (checked == true && checkedCount<3){
                    checkedCount += 1;
                    selectedCoreValues = selectedCoreValues + "CON";
                }
                else if(checked == true && checkedCount==3){
                    communicationCheckBox.setChecked(false);
                }
                else{
                    checkedCount -= 1;
                }
            }
        });

        loyaltyCheckBox.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox) v).isChecked();

                if (checked == true && checkedCount<3){
                    checkedCount += 1;
                    selectedCoreValues = selectedCoreValues + "LOY";
                }
                else if(checked == true && checkedCount==3){
                    loyaltyCheckBox.setChecked(false);
                }
                else{
                    checkedCount -= 1;
                }
            }
        });

        empathyCheckBox.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox) v).isChecked();

                if (checked == true && checkedCount<3){
                    checkedCount += 1;
                    selectedCoreValues = selectedCoreValues + "EMP";
                }
                else if(checked == true && checkedCount==3){
                    empathyCheckBox.setChecked(false);
                }
                else{
                    checkedCount -= 1;
                }
            }
        });

        reliabilityCheckBox.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox) v).isChecked();

                if (checked == true && checkedCount<3){
                    checkedCount += 1;
                    selectedCoreValues = selectedCoreValues + "REL";
                }
                else if(checked == true && checkedCount==3){
                    reliabilityCheckBox.setChecked(false);
                }
                else{
                    checkedCount -= 1;
                }
            }
        });

        openCheckBox.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox) v).isChecked();

                if (checked == true && checkedCount<3){
                    checkedCount += 1;
                    selectedCoreValues = selectedCoreValues + "OPE";
                }
                else if(checked == true && checkedCount==3){
                    openCheckBox.setChecked(false);
                }
                else{
                    checkedCount -= 1;
                }
            }
        });

        humourCheckBox.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox) v).isChecked();

                if (checked == true && checkedCount<3){
                    checkedCount += 1;
                    selectedCoreValues = selectedCoreValues + "HUM";
                }
                else if(checked == true && checkedCount==3){
                    humourCheckBox.setChecked(false);
                }
                else{
                    checkedCount -= 1;
                }
            }
        });

        independenceCheckBox.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox) v).isChecked();

                if (checked == true && checkedCount<3){
                    checkedCount += 1;
                    selectedCoreValues = selectedCoreValues + "OWN";
                }
                else if(checked == true && checkedCount==3){
                    independenceCheckBox.setChecked(false);
                }
                else{
                    checkedCount -= 1;
                }
            }
        });

        creativityCheckBox.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox) v).isChecked();

                if (checked == true && checkedCount<3){
                    checkedCount += 1;
                    selectedCoreValues = selectedCoreValues + "CRE";
                }
                else if(checked == true && checkedCount==3){
                    creativityCheckBox.setChecked(false);
                }
                else{
                    checkedCount -= 1;
                }
            }
        });


        Button next = findViewById(R.id.nextButton);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(value_spinner != null){
                    value = value_spinner.getSelectedItem().toString();
                }
                if(offer_spinner != null){
                    offer = offer_spinner.getSelectedItem().toString();
                }

                FirebaseAuth mAuth = FirebaseAuth.getInstance();
                FirebaseUser firebaseUser = mAuth.getCurrentUser();
                assert firebaseUser != null;
                String userid = firebaseUser.getUid();
                DatabaseReference databaseReference = FirebaseDatabase.getInstance("https://forge-9e1e5-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Users");
                databaseReference.child(userid).child("valueMost").setValue(value);

                databaseReference.child(userid).child("offerMost").setValue(offer);

                databaseReference.child(userid).child("coreValues").setValue(selectedCoreValues);

                openMainScreen();
            }
        });
    }

    private void openMainScreen() {
        Toast.makeText(CoreValues.this, "Account Complete", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(CoreValues.this, MainScreen.class);
        startActivity(intent);
    }
}