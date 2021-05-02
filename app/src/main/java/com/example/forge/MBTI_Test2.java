package com.example.forge;

import android.content.Intent;
import android.os.Bundle;

import com.example.forge.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MBTI_Test2 extends AppCompatActivity {

    private Button button2;
    private Button test;
    int TF = 0;
    int JP = 0;
    String personality_type;
    Boolean intro = false, extro = false, sens = false, intu = false, feel = false, think = false, judge = false, perc = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mbti_test2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle("Page 2");

        Intent intent = getIntent();
        int IE = intent.getIntExtra("IEvalue", 0);
        int SN = intent.getIntExtra("SNvalue", 0);

        button2 = (Button)findViewById(R.id.finish);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((IE == 0) || (SN == 0) || (JP == 0) || (TF == 0)){
                    Toast.makeText(MBTI_Test2.this, "Error, not all questions complete", Toast.LENGTH_SHORT).show();
                }else {
                    personality_type = personality_types(IE, SN, JP, TF);
                    Intent intent = new Intent(MBTI_Test2.this, MBTI_Results.class);
                    intent.putExtra("IEvalue", IE);
                    intent.putExtra("SNvalue", SN);
                    intent.putExtra("JPvalue", JP);
                    intent.putExtra("TFvalue", TF);
                    intent.putExtra("personality_code", personality_type);
                    startActivity(intent);
                }
            }
        });
    }

    private String personality_types(int ie, int sn, int tf, int jp) {
        String personality_code;
        if (ie > 0) {
            personality_code = "E";
        } else {
            personality_code = "I";
        }
        if (sn > 0) {
            personality_code = personality_code + "S";
        } else {
            personality_code = personality_code + "N";
        }
        if (tf > 0) {
            personality_code = personality_code + "T";
        } else {
            personality_code = personality_code + "F";
        }
        if (jp > 0) {
            personality_code = personality_code + "J";
        } else {
            personality_code = personality_code + "P";
        }
        return personality_code;
    }


    public void Q7clicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.Q7_SA:
                if (checked) {
                    TF -= 3;
                }
                break;
            case R.id.Q7_A:
                if (checked) {
                    TF -= 1;
                }
                break;
            case R.id.Q7_D:
                if (checked) {
                    TF += 1;
                }
                break;
            case R.id.Q7_SD:
                if (checked) {
                    TF += 3;
                }
                break;
        }
    }

    public void Q8clicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            case R.id.Q8_SA:
                if (checked){
                    TF -= 3;
                }
                break;
            case R.id.Q8_A:
                if(checked){
                    TF -= 1;
                }
                break;
            case R.id.Q8_D:
                if (checked){
                    TF += 1;
                }
                break;
            case R.id.Q8_SD:
                if (checked) {
                    TF += 3;
                }
                break;
        }
    }


    public void Q9clicked(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.Q9_SA:
                if (checked) {
                    TF += 3;
                }
                break;
            case R.id.Q9_A:
                if (checked) {
                    TF += 1;
                }
                break;
            case R.id.Q9_D:
                if (checked) {
                    TF -= 1;
                }
                break;
            case R.id.Q9_SD:
                if (checked) {
                    TF -= 3;
                }
                break;
        }
    }

    public void Q10clicked(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.Q10_SA:
                if (checked) {
                    JP += 3;
                }
                break;
            case R.id.Q10_A:
                if (checked) {
                    JP += 1;
                }
                break;
            case R.id.Q10_D:
                if (checked) {
                    JP -= 1;
                }
                break;
            case R.id.Q10_SD:
                if (checked) {
                    JP -= 3;
                }
                break;
        }
    }

    public void Q11clicked(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.Q11_SA:
                if (checked) {
                    JP -= 3;
                }
                break;
            case R.id.Q11_A:
                if (checked) {
                    JP -= 1;
                }
                break;
            case R.id.Q11_D:
                if (checked) {
                    JP += 1;
                }
                break;
            case R.id.Q11_SD:
                if (checked) {
                    JP += 3;
                }
                break;
        }
    }

    public void Q12clicked(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.Q12_SA:
                if (checked) {
                    JP += 3;
                }
                break;
            case R.id.Q12_A:
                if (checked) {
                    JP += 1;
                }
                break;
            case R.id.Q12_D:
                if (checked) {
                    JP -= 1;
                }
                break;
            case R.id.Q12_SD:
                if (checked) {
                    JP -= 3;
                }
                break;
        }
    }
}