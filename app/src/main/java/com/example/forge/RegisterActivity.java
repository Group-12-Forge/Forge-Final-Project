package com.example.forge;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {
    EditText nameEt, usernameEt, emailEt, passEt, confirm_pass, dobEt;
    Button register_btn;
    CheckBox checkBox;
    ProgressBar progressBar;
    FirebaseAuth mAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nameEt = findViewById(R.id.Name);
        usernameEt = findViewById(R.id.username);
        emailEt = findViewById(R.id.register_email_et);
        passEt = findViewById(R.id.register_password_et);
        confirm_pass = findViewById(R.id.register_confirmpassword_et);
        checkBox = findViewById(R.id.register_checkbox);
        register_btn = (Button) findViewById(R.id.signup_to_login);
        progressBar = findViewById(R.id.progressbar_register);
        mAuth = FirebaseAuth.getInstance();

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    passEt.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    confirm_pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    passEt.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    confirm_pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        databaseReference = FirebaseDatabase.getInstance("https://forge-9e1e5-default-rtdb.europe-west1.firebasedatabase.app/").getReference().child("Users");

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //openAccountSetUp();
                String name = nameEt.getText().toString();
                String username = usernameEt.getText().toString();
                String email = emailEt.getText().toString();
                String pass = passEt.getText().toString();
                String confirm_password = confirm_pass.getText().toString();
                /*DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("name", name);
                hashMap.put("username", username);
                reference.child("Users").push().setValue(hashMap);*/

                /*rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Users");

                reference.setValue("hallo");*/

                /*firebaseDatabase = FirebaseDatabase.getInstance();
                databaseReference = firebaseDatabase.getReference("Users");
                user = new User(email, name, username, null);
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        databaseReference.setValue(user);
                        Toast.makeText(RegisterActivity.this, "Data added", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(RegisterActivity.this, "Failed to add data"+error, Toast.LENGTH_SHORT).show();
                    }
                });*/


                if (!TextUtils.isEmpty(name) || !TextUtils.isEmpty(username) || !TextUtils.isEmpty(email) || !TextUtils.isEmpty(pass) || !TextUtils.isEmpty(confirm_password)) {
                    if (pass.equals(confirm_password)) {
                        progressBar.setVisibility(View.VISIBLE);

                        mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    DatabaseReference reference = FirebaseDatabase.getInstance("https://forge-9e1e5-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Users");
                                    HashMap<String, Object> hashMap = new HashMap<>();
                                    FirebaseUser firebaseUser = mAuth.getCurrentUser();
                                    assert firebaseUser != null;
                                    String userid = firebaseUser.getUid();
                                    System.out.println(userid);
                                    hashMap.put("id", userid);
                                    hashMap.put("email", email);
                                    hashMap.put("name", name);
                                    hashMap.put("username", username);
                                    hashMap.put("imageURL", "default");
                                    hashMap.put("personalityType", "");
                                    hashMap.put("coreValues", "");
                                    hashMap.put("hobbiesInterests", "");
                                    hashMap.put("dominantTrait", "");
                                    hashMap.put("valueMost", "");
                                    hashMap.put("offerMost", "");

                                    reference.child(userid).setValue(hashMap);

                                    Toast.makeText(RegisterActivity.this, "Data inserted", Toast.LENGTH_SHORT).show();
                                    openVerification();
                                    progressBar.setVisibility(View.INVISIBLE);

                                } else {
                                    String error = task.getException().getMessage();
                                    Toast.makeText(RegisterActivity.this, "Error :"+error, Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    } else {
                        progressBar.setVisibility(View.INVISIBLE);
                        Toast.makeText(RegisterActivity.this, "Password does not match", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(RegisterActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }


    private void openVerification() {
        Intent intent = new Intent(this, VerifyEmail.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            openVerification();
        }
    }
}