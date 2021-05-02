package com.example.forge;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MBTI_Test1 extends AppCompatActivity {
    //private Button button;

    int IE = 0;
    int SN = 0;


    //String IorE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mbti_test1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle("MBTI Test");

        Button button = (Button)findViewById(R.id.next);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MBTI_Test1.this, MBTI_Test2.class);

                intent.putExtra("IEvalue", IE);
                intent.putExtra("SNvalue", SN);

                startActivity(intent);

            }
        });
    }

    public void Q1clicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            case R.id.Q1_SA:
                if (checked){
                    IE += 3;
                }
                break;
            case R.id.Q1_A:
                if(checked){
                    IE += 1;
                }
                break;
            case R.id.Q1_D:
                if (checked){
                    IE -= 1;
                }
                break;
            case R.id.Q1_SD:
                if (checked) {
                    IE -= 3;
                }
                break;
        }
    }

    public void Q2clicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            case R.id.Q2_SA:
                if (checked){
                    IE -= 3;
                }
                break;
            case R.id.Q2_A:
                if(checked){
                    IE -= 1;
                }
                break;
            case R.id.Q2_D:
                if (checked){
                    IE += 1;
                }
                break;
            case R.id.Q2_SD:
                if (checked) {
                    IE += 3;
                }
                break;
        }
    }

    public void Q3clicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            case R.id.Q3_SA:
                if (checked){
                    IE += 3;
                }
                break;
            case R.id.Q3_A:
                if(checked){
                    IE += 1;
                }
                break;
            case R.id.Q3_D:
                if (checked){
                    IE -= 1;
                }
                break;
            case R.id.Q3_SD:
                if (checked) {
                    IE -= 3;
                }
                break;
        }
    }

    public void Q4clicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            case R.id.Q4_SA:
                if (checked){
                    SN += 3;
                }
                break;
            case R.id.Q4_A:
                if(checked){
                    SN += 1;
                }
                break;
            case R.id.Q4_D:
                if (checked){
                    SN -= 1;
                }
                break;
            case R.id.Q4_SD:
                if (checked) {
                    SN -= 3;
                }
                break;
        }
    }

    public void Q5clicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            case R.id.Q5_SA:
                if (checked){
                    SN -= 3;
                }
                break;
            case R.id.Q5_A:
                if(checked){
                    SN -= 1;
                }
                break;
            case R.id.Q5_D:
                if (checked){
                    SN += 1;
                }
                break;
            case R.id.Q5_SD:
                if (checked) {
                    SN += 3;
                }
                break;
        }
    }

    public void Q6clicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            case R.id.Q6_SA:
                if (checked){
                    SN -= 3;
                }
                break;
            case R.id.Q6_A:
                if(checked){
                    SN -= 1;
                }
                break;
            case R.id.Q6_D:
                if (checked){
                    SN += 1;
                }
                break;
            case R.id.Q6_SD:
                if (checked) {
                    SN += 3;
                }
                break;
        }
    }
}
