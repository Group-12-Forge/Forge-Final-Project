package com.example.forge;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.forge.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class VerifyEmail extends AppCompatActivity {

    TextView txt_email, txt_status;
    private Button button;
    Button btn_send, btn_refresh;
    Boolean verified = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_email);

        txt_email = (TextView)findViewById(R.id.txt_email);
        txt_status = (TextView)findViewById(R.id.status_text);

        btn_refresh = (Button)findViewById(R.id.refresh);
        btn_send = (Button)findViewById(R.id.send_email);

        setInfo();
        //Set event
        FirebaseAuth.getInstance().getCurrentUser()
                .sendEmailVerification();

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_send.setEnabled(false);

                FirebaseAuth.getInstance().getCurrentUser()
                        .sendEmailVerification()
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                btn_send.setEnabled(true);

                                if (task.isSuccessful())

                                    Toast.makeText(VerifyEmail.this, "Verification email sent to:  "+FirebaseAuth.getInstance().getCurrentUser().getEmail(), Toast.LENGTH_SHORT).show();
                                else
                                    Toast.makeText(VerifyEmail.this, "Failed to send verification email", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

        btn_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().getCurrentUser()
                        .reload()
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                setInfo();
                            }
                        });
            }
        });
        button = (Button)findViewById(R.id.ToVerify);

        ///while (verified == false){
   /*     FirebaseUser use = FirebaseAuth.getInstance().getCurrentUser();
        if(use.isEmailVerified() == true) {

            startActivity(new Intent(MainActivity.this, PreMbti.class));
        }
*/
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseUser use = FirebaseAuth.getInstance().getCurrentUser();
                if(use.isEmailVerified() == true)
                    startActivity(new Intent(VerifyEmail.this, UserDetails.class));
                else
                    Toast.makeText(VerifyEmail.this, "Email has not been verified, press re-send to send a verification link to : " +FirebaseAuth.getInstance().getCurrentUser().getEmail(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setInfo() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        txt_email.setText(new StringBuilder("EMAIL : ").append(user.getEmail()));
        txt_status.setText(new StringBuilder("STATUS : ").append(String.valueOf(user.isEmailVerified())));
    }


}