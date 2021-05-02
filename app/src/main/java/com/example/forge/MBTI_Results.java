package com.example.forge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MBTI_Results extends AppCompatActivity {

    private Button next;

    TextView type;
    TextView traitText;
    TextView Mtrait;
    String trait;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mbti_results);

        type = (TextView) findViewById(R.id.result);
        Mtrait = (TextView) findViewById(R.id.MainTrait);
        traitText = (TextView) findViewById(R.id.MainTraitText);
        Intent intent = getIntent();

        String Personality = intent.getStringExtra("personality_code");
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = mAuth.getCurrentUser();
        assert firebaseUser != null;
        String userid = firebaseUser.getUid();
        DatabaseReference databaseReference = FirebaseDatabase.getInstance("https://forge-9e1e5-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Users");
        databaseReference.child(userid).child("personalityType").setValue(Personality);
        type.setText(Personality);

        int ie = intent.getIntExtra("IEvalue", 0);
        int sn = intent.getIntExtra("SNvalue", 0);
        int jp = intent.getIntExtra("JPvalue", 0);
        int tf = intent.getIntExtra("TFvalue", 0);


        Mtrait.setText(max_trait(ie, sn, tf, jp));



        next = (Button)findViewById(R.id.mainPage);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String text = String.valueOf(ie) + String.valueOf(sn) + String.valueOf(jp) + String.valueOf(tf);
                //Toast.makeText(MBTI_Results.this, text, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MBTI_Results.this, Hobbies.class);
                startActivity(intent);
            }
        });



    }
    /*
        private void max_trait(int IE, int SN, int TF, int JP){
            String max = "";
            if ((IE*IE) > (SN*SN)) {
                if ((IE * IE) > (JP * JP)) {
                    if ((IE * IE) > (TF * TF)) {
                        if (IE > 0) {
                            max = "Extroversion(E).";
                            traitText.setText("Your most promminent traint shows that you prefeer: ");
                            Mtrait.setText(max);
                        } else {
                            max = "Introversion(I).";
                            traitText.setText("Your most promminent traint shows that you prefeer: ");
                            Mtrait.setText(max);
                        }
                    } else {
                        if (TF > 0) {
                            max = "Making thought based decisions(T).";
                            traitText.setText("Your most promminent traint shows that you prefeer: ");
                            Mtrait.setText(max);
                        } else {
                            max = "Making decisions based on Feeling(F).";
                            traitText.setText("Your most promminent traint shows that you prefeer: ");
                            Mtrait.setText(max);
                        }
                    }
                } else {
                    if (JP > TF) {
                        if (JP > 0) {
                            max = "Sticking to a plan and Judging (J) situations before they arise.";
                            traitText.setText("Your most promminent traint shows that you prefeer: ");
                            Mtrait.setText(max);
                        } else {
                            max = "Seeing what situations arise and dealing with them as you Perceive(P) them at the time.";
                            traitText.setText("Your most promminent traint shows that you prefeer: ");
                            Mtrait.setText(max);
                        }
                    } else {
                        if (TF > 0) {
                            max = "Making thought based decisions(T).";
                            traitText.setText("Your most promminent traint shows that you prefeer: ");
                            Mtrait.setText(max);
                        } else {
                            max = "Making decisions based on Feeling(F).";
                            traitText.setText("Your most promminent traint shows that you prefeer: ");
                            Mtrait.setText(max);
                        }
                    }
                }
            }else{
                if ((SN*SN)>(JP*JP)){
                    if ((SN*SN)>(TF*TF)){
                        if(SN > 0){
                            max = "Processing information based on what you can physically Sense(S) before you.";
                            traitText.setText("Your most promminent traint shows that you prefeer: ");
                            Mtrait.setText(max);
                        }else{
                            max = "Processing information based on your Intuition(N) and things that are not physically presented before you.";
                            traitText.setText("Your most promminent traint shows that you prefeer: ");
                            Mtrait.setText(max);
                        }
                    }else{
                        if ((JP*JP) > (TF*TF)){
                            if (JP > 0) {
                                max = "Sticking to a plan and Judging (J) situations before they arise.";
                                traitText.setText("Your most promminent traint shows that you prefeer: ");
                                Mtrait.setText(max);
                            } else {
                                max = "Seeing what situations arise and dealing with them as you Perceive(P) them at the time.";
                                traitText.setText("Your most promminent traint shows that you prefeer: ");
                                Mtrait.setText(max);
                            }
                        }else{
                            if (TF > 0) {
                                max = "Making thought based decisions(T).";
                                traitText.setText("Your most promminent traint shows that you prefeer: ");
                                Mtrait.setText(max);
                            } else {
                                max = "Making decisions based on Feeling(F).";
                                traitText.setText("Your most promminent traint shows that you prefeer: ");
                                Mtrait.setText(max);
                            }
                        }
                    }
                }
            }

        }
    */
    private String max_trait(int IE, int TF, int SN, int JP){
        String dominant = "";
        String dominantTrait = "";
        String[] type = {"I", "E", "F", "T", "N", "S", "P", "J"};
        int[] scores = {IE, TF, SN, JP};
        String[] types = {"Are an Introvert(I). This means that you rarely interact with people outside of your established social group.",
                "Are an Extrovert(E). This means that you enjoy branching out and interacting with people who you may not have met before.",
                "Are someone who will make a decision based on the Feelings(F) of you and others. You will always think about how your decision will effect those around you.",
                "Are someone who will make a decision based on the facts before you, Thinking(T) about, and analysing the situation, before making a logical decision.",
                "Are someone who will pay attention to the meanings behind information, and follow you Intuition(N) when processing information.",
                "Are someone who will pay attention to information that you can Sense(S). This means that you take things as the are presented to you in the physical world.",
                "Are someone who is flexible and able to adapt to situations as you Perceive(P) them. You like to take things as they come.",
                "Are someone who will Judge(J) a situation before it has arose. This means that you like to remain organised and have a planned, orderly way of life."};
        int[] scoresSquared = {0,0,0,0};

        //fill the array with squared scores
        for(int i = 0; i < 4; i++){
            scoresSquared[i] = scores[i]*scores[i];
        }

        //find max
        int max = scoresSquared[0];
        int maxIndex = 0;

        boolean noDominant = false;
        for (int i = 1; i < 4; i++){
            if (scoresSquared[i] > max){
                max = scoresSquared[i];
                maxIndex = i;

                noDominant = false;
            }

            else if (scoresSquared[maxIndex] == max){
                noDominant = true;

            }
        }

        if (noDominant == false){
            //if the original score was negative -> suggests a particular trait
            if(scores[maxIndex] < 0){
                dominant = types[(maxIndex*2)];
                dominantTrait = type[(maxIndex*2)];
            }

            //else the original score was positive
            else{
                dominant = types[(maxIndex*2) + 1];
                dominantTrait = type[(maxIndex*2) + 1];
            }
        }

        //if there is no dominant trait, none should be returned
        else {
            dominant = "Have no dominant trait.";
            dominantTrait = "None";
        }
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = mAuth.getCurrentUser();
        assert firebaseUser != null;
        String userid = firebaseUser.getUid();
        DatabaseReference databaseReference = FirebaseDatabase.getInstance("https://forge-9e1e5-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Users");
        databaseReference.child(userid).child("dominantTrait").setValue(dominantTrait);
        Toast.makeText(MBTI_Results.this, "Data inserted", Toast.LENGTH_SHORT).show();

        return dominant;

    }
}