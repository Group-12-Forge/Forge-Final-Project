package com.example.forge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Hobbies extends AppCompatActivity{
    int selectionCount = 1;

    String selectedInterest = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hobbies);

        TextView Sports = findViewById(R.id.sports);
        Button footballBtn = findViewById(R.id.football);
        Button cricketBtn = findViewById(R.id.cricket);
        Button hockeyBtn = findViewById(R.id.hockey);
        Button badmintonBtn = findViewById(R.id.badminton);
        Button swimmingBtn = findViewById(R.id.swimming);
        Button rugbyBtn = findViewById(R.id.rugby);
        Button basketballBtn = findViewById(R.id.basketball);
        Button tennisBtn = findViewById(R.id.tennis);

        TextView Music = findViewById(R.id.music);
        Button rockBtn = findViewById(R.id.rock);
        Button rnbBtn = findViewById(R.id.rnb);
        Button hip_hopBtn = findViewById(R.id.hip_hop);
        Button popBtn = findViewById(R.id.pop);
        Button countryBtn = findViewById(R.id.country);
        Button indieBtn = findViewById(R.id.indie);
        Button classicalBtn = findViewById(R.id.classical);
        Button jazzBtn = findViewById(R.id.jazz);

        TextView Food = findViewById(R.id.food);
        Button italianBtn = findViewById(R.id.italian);
        Button chineseBtn = findViewById(R.id.chinese);
        Button indianBtn = findViewById(R.id.indian);
        Button japaneseBtn = findViewById(R.id.japanese);
        Button thaiBtn = findViewById(R.id.thai);
        Button mexicanBtn = findViewById(R.id.mexican);
        Button americanBtn = findViewById(R.id.american);
        Button turkishBtn = findViewById(R.id.turkish);

        TextView Movies = findViewById(R.id.movies);
        Button dramaBtn = findViewById(R.id.drama);
        Button horrorBtn = findViewById(R.id.horror);
        Button romanceBtn = findViewById(R.id.romance);
        Button musicalsBtn = findViewById(R.id.musicals);
        Button comedyBtn = findViewById(R.id.comedy);
        Button scifiBtn = findViewById(R.id.scifi);
        Button actionBtn = findViewById(R.id.action);
        Button thrillerBtn = findViewById(R.id.thriller);

        int sports = 0x1F3C6;
        int football = 0x26BD;
        int cricket = 0x1F3CF;
        int hockey = 0x1F3D1;
        int badminton = 0x1F3F8;
        int swimming = 0x1F3CA;
        int rugby = 0x1F3C9;
        int basketball = 0x1F3C0;
        int tennis = 0x1F3BE;

        int music = 0x1F3B5;
        int rock = 0x1F3B8;
        int rnb = 0x1F3A4;
        int hip_hop = 0x1F399;
        int pop = 0x1F3B6;
        int country = 0x1FA95;
        int indie = 0x1F3B9;
        int classical = 0x1F3BB;
        int jazz = 0x1F3B7;

        int food = 0x1F374;
        int italian = 0x1F35D;
        int chinese = 0x1F35C;
        int indian = 0x1F372;
        int japanese = 0x1F363;
        int mexican = 0x1F32E;
        int thai = 0x1F35B;
        int american = 0x1F354;
        int turkish = 0x1F959;

        int movies = 0x1F3A5;
        int drama = 0x1F3AD;
        int horror = 0x2620;
        int romance = 0x1F49E;
        int musicals = 0x1F3BC;
        int comedy = 0x1F3AA;
        int sci_fi = 0x1F47D;
        int action = 0x1F3AC;
        int thriller = 0x1F9B9;

        String trophy = getEmoji(sports);
        String ball = getEmoji(football);
        String bat = getEmoji(cricket);
        String stick = getEmoji(hockey);
        String racket = getEmoji(badminton);
        String swim = getEmoji(swimming);
        String Rugby = getEmoji(rugby);
        String basket = getEmoji(basketball);
        String ten = getEmoji(tennis);

        String note = getEmoji(music);
        String drums = getEmoji(rock);
        String mic = getEmoji(rnb);
        String hip = getEmoji(hip_hop);
        String Pop = getEmoji(pop);
        String banjo = getEmoji(country);
        String piano = getEmoji(indie);
        String violin = getEmoji(classical);
        String sax = getEmoji(jazz);

        String cutlery = getEmoji(food);
        String spaghetti = getEmoji(italian);
        String bowl = getEmoji(chinese);
        String plate = getEmoji(indian);
        String sushi = getEmoji(japanese);
        String taco = getEmoji(mexican);
        String Thai = getEmoji(thai);
        String burger = getEmoji(american);
        String flatbread = getEmoji(turkish);

        String camera = getEmoji(movies);
        String arts = getEmoji(drama);
        String skull = getEmoji(horror);
        String heart = getEmoji(romance);
        String Musical = getEmoji(musicals);
        String tent = getEmoji(comedy);
        String alien = getEmoji(sci_fi);
        String Action = getEmoji(action);
        String villain = getEmoji(thriller);

        String text = "Sports"+trophy;
        String f = "Football"+ball;
        String c = "Cricket"+bat;
        String h = "Hockey"+stick;
        String b = "Badminton"+racket;
        String s = "Swimming"+swim;
        String r = "Rugby"+Rugby;
        String b1 = "Basketball"+basket;
        String t = "Tennis"+ten;

        String text2 = "Music"+note;
        String r2 = "Rock"+drums;
        String m = "RnB"+mic;
        String h2 = "Hip-Hop"+hip;
        String p = "Pop"+Pop;
        String c2 = "Country"+banjo;
        String i = "Indie"+piano;
        String c3 = "Classical"+violin;
        String j = "Jazz"+sax;

        String text3 = "Food"+cutlery;
        String i2 = "Italian"+spaghetti;
        String c4 = "Chinese"+bowl;
        String i3 = "Indian"+plate;
        String j2 = "Japanese"+sushi;
        String m2 = "Mexican"+taco;
        String t2 = "Thai"+Thai;
        String a = "American"+burger;
        String t3 = "Turkish"+flatbread;

        String text4 = "Movies"+camera;
        String d = "Drama"+arts;
        String h3 = "Horror"+skull;
        String r3 = "Romance"+heart;
        String m3 = "Musicals"+Musical;
        String c5 = "Comedy"+tent;
        String s2 = "Sci-Fi"+alien;
        String a2 = "Action"+Action;
        String t4 = "Thriller"+villain;

        Sports.setText(text);
        footballBtn.setText(f);
        cricketBtn.setText(c);
        hockeyBtn.setText(h);
        badmintonBtn.setText(b);
        swimmingBtn.setText(s);
        rugbyBtn.setText(r);
        basketballBtn.setText(b1);
        tennisBtn.setText(t);

        Music.setText(text2);
        rockBtn.setText(r2);
        rnbBtn.setText(m);
        hip_hopBtn.setText(h2);
        popBtn.setText(p);
        countryBtn.setText(c2);
        indieBtn.setText(i);
        classicalBtn.setText(c3);
        jazzBtn.setText(j);

        Food.setText(text3);
        italianBtn.setText(i2);
        chineseBtn.setText(c4);
        indianBtn.setText(i3);
        japaneseBtn.setText(j2);
        thaiBtn.setText(m2);
        mexicanBtn.setText(t2);
        americanBtn.setText(a);
        turkishBtn.setText(t3);

        Movies.setText(text4);
        dramaBtn.setText(d);
        horrorBtn.setText(h3);
        romanceBtn.setText(r3);
        musicalsBtn.setText(m3);
        comedyBtn.setText(c5);
        scifiBtn.setText(s2);
        actionBtn.setText(a2);
        thrillerBtn.setText(t4);

        footballBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (selectionCount <= 6){
                    footballBtn.setSelected(!footballBtn.isSelected());

                    if (footballBtn.isSelected()){
                        selectionCount += 1;
                        selectedInterest = selectedInterest+"FTB";


                    } else {
                        selectionCount -= 1;
                    }
                } else{
                    Toast.makeText(Hobbies.this, "Please only pick 6 interests", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cricketBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (selectionCount <= 6){
                    cricketBtn.setSelected(!cricketBtn.isSelected());

                    if (cricketBtn.isSelected()){
                        selectionCount += 1;
                        selectedInterest = selectedInterest+"CRK";
                    } else {
                        selectionCount -= 1;
                    }
                } else{
                    Toast.makeText(Hobbies.this, "Please only pick 6 interests", Toast.LENGTH_SHORT).show();
                }
            }
        });
        hockeyBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (selectionCount <= 6){
                    hockeyBtn.setSelected(!hockeyBtn.isSelected());

                    if (hockeyBtn.isSelected()){
                        selectionCount += 1;
                        selectedInterest = selectedInterest+"HOC";
                    } else {
                        selectionCount -= 1;
                    }
                } else{
                    Toast.makeText(Hobbies.this, "Please only pick 6 interests", Toast.LENGTH_SHORT).show();
                }

            }
        });
        badmintonBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                if (selectionCount <= 6){
                    badmintonBtn.setSelected(!badmintonBtn.isSelected());

                    if (badmintonBtn.isSelected()){
                        selectionCount += 1;
                        selectedInterest = selectedInterest+"BAD";
                    } else {
                        selectionCount -= 1;
                    }
                } else{
                    Toast.makeText(Hobbies.this, "Please only pick 6 interests", Toast.LENGTH_SHORT).show();
                }

            }
        });
        swimmingBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                if (selectionCount <= 6){
                    swimmingBtn.setSelected(!swimmingBtn.isSelected());

                    if (swimmingBtn.isSelected()){
                        selectionCount += 1;
                        selectedInterest = selectedInterest+"SWI";
                    } else {
                        selectionCount -= 1;
                    }
                } else{
                    Toast.makeText(Hobbies.this, "Please only pick 6 interests", Toast.LENGTH_SHORT).show();
                }

            }
        });
        rugbyBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                if (selectionCount <= 6){
                    rugbyBtn.setSelected(!rugbyBtn.isSelected());

                    if (rugbyBtn.isSelected()){
                        selectionCount += 1;
                        selectedInterest = selectedInterest+"RUG";
                    } else {
                        selectionCount -= 1;
                    }
                } else{
                    Toast.makeText(Hobbies.this, "Please only pick 6 interests", Toast.LENGTH_SHORT).show();
                }

            }
        });
        basketballBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                if (selectionCount <= 6){
                    basketballBtn.setSelected(!basketballBtn.isSelected());

                    if (basketballBtn.isSelected()){
                        selectionCount += 1;
                        selectedInterest = selectedInterest+"BAS";
                    } else {
                        selectionCount -= 1;
                    }
                } else{
                    Toast.makeText(Hobbies.this, "Please only pick 6 interests", Toast.LENGTH_SHORT).show();
                }
            }
        });
        tennisBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                if (selectionCount <= 6) {
                    tennisBtn.setSelected(!tennisBtn.isSelected());

                    if (tennisBtn.isSelected()) {
                        selectionCount += 1;
                        selectedInterest = selectedInterest+"TEN";
                    } else {
                        selectionCount -= 1;
                    }
                } else{
                    Toast.makeText(Hobbies.this, "Please only pick 6 interests", Toast.LENGTH_SHORT).show();
                }
            }
        });
        rockBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                if (selectionCount <= 6){
                    rockBtn.setSelected(!rockBtn.isSelected());

                    if (rockBtn.isSelected()){
                        selectionCount += 1;
                        selectedInterest = selectedInterest+"ROC";
                    } else {
                        selectionCount -= 1;
                    }
                } else{
                    Toast.makeText(Hobbies.this, "Please only pick 6 interests", Toast.LENGTH_SHORT).show();
                }
            }
        });
        rnbBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                if (selectionCount <= 6){
                    rnbBtn.setSelected(!rnbBtn.isSelected());

                    if (rnbBtn.isSelected()){
                        selectionCount += 1;
                        selectedInterest = selectedInterest+"RNB";
                    } else {
                        selectionCount -= 1;
                    }
                } else{
                    Toast.makeText(Hobbies.this, "Please only pick 6 interests", Toast.LENGTH_SHORT).show();
                }
            }
        });

        hip_hopBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                if (selectionCount <= 6){
                    hip_hopBtn.setSelected(!hip_hopBtn.isSelected());

                    if (hip_hopBtn.isSelected()){
                        selectionCount += 1;
                        selectedInterest = selectedInterest+"HIP";
                    } else {
                        selectionCount -= 1;
                    }
                } else{
                    Toast.makeText(Hobbies.this, "Please only pick 6 interests", Toast.LENGTH_SHORT).show();
                }
            }
        });
        popBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                if (selectionCount <= 6){
                    popBtn.setSelected(!popBtn.isSelected());

                    if (popBtn.isSelected()){
                        selectionCount += 1;
                        selectedInterest = selectedInterest+"POP";
                    } else {
                        selectionCount -= 1;
                    }
                } else{
                    Toast.makeText(Hobbies.this, "Please only pick 6 interests", Toast.LENGTH_SHORT).show();
                }
            }
        });

        countryBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                if (selectionCount <= 6){
                    countryBtn.setSelected(!countryBtn.isSelected());

                    if (countryBtn.isSelected()){
                        selectionCount += 1;
                        selectedInterest = selectedInterest+"COU";
                    } else {
                        selectionCount -= 1;
                    }
                } else{
                    Toast.makeText(Hobbies.this, "Please only pick 6 interests", Toast.LENGTH_SHORT).show();
                }
            }
        });

        indieBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                if (selectionCount <= 6){
                    indieBtn.setSelected(!indieBtn.isSelected());

                    if (indieBtn.isSelected()){
                        selectionCount += 1;
                        selectedInterest = selectedInterest+"INI";
                    } else {
                        selectionCount -= 1;
                    }
                } else{
                    Toast.makeText(Hobbies.this, "Please only pick 6 interests", Toast.LENGTH_SHORT).show();
                }
            }
        });

        classicalBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                if (selectionCount <= 6){
                    classicalBtn.setSelected(!classicalBtn.isSelected());

                    if (classicalBtn.isSelected()){
                        selectionCount += 1;
                        selectedInterest = selectedInterest+"CLA";
                    } else {
                        selectionCount -= 1;
                    }
                } else{
                    Toast.makeText(Hobbies.this, "Please only pick 6 interests", Toast.LENGTH_SHORT).show();
                }
            }
        });

        jazzBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                if (selectionCount <= 6){
                    jazzBtn.setSelected(!jazzBtn.isSelected());

                    if (jazzBtn.isSelected()){
                        selectionCount += 1;
                        selectedInterest = selectedInterest+"JAZ";
                    } else {
                        selectionCount -= 1;
                    }
                } else{
                    Toast.makeText(Hobbies.this, "Please only pick 6 interests", Toast.LENGTH_SHORT).show();
                }
            }
        });

        italianBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                if (selectionCount <= 6){
                    italianBtn.setSelected(!italianBtn.isSelected());

                    if (italianBtn.isSelected()){
                        selectionCount += 1;
                        selectedInterest = selectedInterest+"ITA";
                    } else {
                        selectionCount -= 1;
                    }
                } else{
                    Toast.makeText(Hobbies.this, "Please only pick 6 interests", Toast.LENGTH_SHORT).show();
                }
            }
        });

        chineseBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){


                if (selectionCount <= 6){
                    chineseBtn.setSelected(!chineseBtn.isSelected());

                    if (chineseBtn.isSelected()){
                        selectionCount += 1;
                        selectedInterest = selectedInterest+"CHI";
                    } else {
                        selectionCount -= 1;
                    }
                } else{
                    Toast.makeText(Hobbies.this, "Please only pick 6 interests", Toast.LENGTH_SHORT).show();
                }
            }
        });

        indianBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                if (selectionCount <= 6){
                    indianBtn.setSelected(!indianBtn.isSelected());

                    if (indianBtn.isSelected()){
                        selectionCount += 1;
                        selectedInterest = selectedInterest+"IND";
                    } else {
                        selectionCount -= 1;
                    }
                } else{
                    Toast.makeText(Hobbies.this, "Please only pick 6 interests", Toast.LENGTH_SHORT).show();
                }
            }
        });

        japaneseBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                if (selectionCount <= 6){
                    japaneseBtn.setSelected(!japaneseBtn.isSelected());

                    if (japaneseBtn.isSelected()){
                        selectionCount += 1;
                        selectedInterest = selectedInterest+"JAP";
                    } else {
                        selectionCount -= 1;
                    }
                } else{
                    Toast.makeText(Hobbies.this, "Please only pick 6 interests", Toast.LENGTH_SHORT).show();
                }
            }
        });

        thaiBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                if (selectionCount <= 6){
                    thaiBtn.setSelected(!thaiBtn.isSelected());

                    if (thaiBtn.isSelected()){
                        selectionCount += 1;
                        selectedInterest = selectedInterest+"THA";
                    } else {
                        selectionCount -= 1;
                    }
                } else{
                    Toast.makeText(Hobbies.this, "Please only pick 6 interests", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mexicanBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                if (selectionCount <= 6){
                    mexicanBtn.setSelected(!mexicanBtn.isSelected());

                    if (mexicanBtn.isSelected()){
                        selectionCount += 1;
                        selectedInterest = selectedInterest+"MEX";
                    } else {
                        selectionCount -= 1;
                    }
                } else{
                    Toast.makeText(Hobbies.this, "Please only pick 6 interests", Toast.LENGTH_SHORT).show();
                }
            }
        });

        americanBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (selectionCount <= 6){
                    americanBtn.setSelected(!mexicanBtn.isSelected());

                    if (americanBtn.isSelected()){
                        selectionCount += 1;
                        selectedInterest = selectedInterest+"USA";
                    } else {
                        selectionCount -= 1;
                    }
                } else{
                    Toast.makeText(Hobbies.this, "Please only pick 6 interests", Toast.LENGTH_SHORT).show();
                }
            }
        });

        turkishBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                if (selectionCount <= 6){
                    turkishBtn.setSelected(!turkishBtn.isSelected());

                    if (turkishBtn.isSelected()){
                        selectionCount += 1;
                        selectedInterest = selectedInterest+"TUR";
                    } else {
                        selectionCount -= 1;
                    }
                } else{
                    Toast.makeText(Hobbies.this, "Please only pick 6 interests", Toast.LENGTH_SHORT).show();
                }
            }
        });

        dramaBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                if (selectionCount <= 6){
                    dramaBtn.setSelected(!dramaBtn.isSelected());

                    if (dramaBtn.isSelected()){
                        selectionCount += 1;
                        selectedInterest = selectedInterest+"DRA";
                    } else {
                        selectionCount -= 1;
                    }
                } else{
                    Toast.makeText(Hobbies.this, "Please only pick 6 interests", Toast.LENGTH_SHORT).show();
                }
            }
        });

        horrorBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                if (selectionCount <= 6){
                    horrorBtn.setSelected(!horrorBtn.isSelected());

                    if (horrorBtn.isSelected()){
                        selectionCount += 1;
                        selectedInterest = selectedInterest+"HOR";
                    } else {
                        selectionCount -= 1;
                    }
                } else{
                    Toast.makeText(Hobbies.this, "Please only pick 6 interests", Toast.LENGTH_SHORT).show();
                }
            }
        });

        romanceBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                if (selectionCount <= 6){
                    romanceBtn.setSelected(!romanceBtn.isSelected());

                    if (romanceBtn.isSelected()){
                        selectionCount += 1;
                        selectedInterest = selectedInterest+"ROM";
                    } else {
                        selectionCount -= 1;
                    }
                } else{
                    Toast.makeText(Hobbies.this, "Please only pick 6 interests", Toast.LENGTH_SHORT).show();
                }
            }
        });

        musicalsBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                if (selectionCount <= 6){
                    musicalsBtn.setSelected(!musicalsBtn.isSelected());

                    if (musicalsBtn.isSelected()){
                        selectionCount += 1;
                        selectedInterest = selectedInterest+"MUS";
                    } else {
                        selectionCount -= 1;
                    }
                } else{
                    Toast.makeText(Hobbies.this, "Please only pick 6 interests", Toast.LENGTH_SHORT).show();
                }
            }
        });

        comedyBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                if (selectionCount <= 6){
                    comedyBtn.setSelected(!comedyBtn.isSelected());

                    if (comedyBtn.isSelected()){
                        selectionCount += 1;
                        selectedInterest = selectedInterest+"COM";
                    } else {
                        selectionCount -= 1;
                    }
                } else{
                    Toast.makeText(Hobbies.this, "Please only pick 6 interests", Toast.LENGTH_SHORT).show();
                }
            }
        });

        scifiBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                if (selectionCount <= 6){
                    scifiBtn.setSelected(!scifiBtn.isSelected());

                    if (scifiBtn.isSelected()){
                        selectionCount += 1;
                        selectedInterest = selectedInterest+"SCI";
                    } else {
                        selectionCount -= 1;
                    }
                } else{
                    Toast.makeText(Hobbies.this, "Please only pick 6 interests", Toast.LENGTH_SHORT).show();
                }
            }
        });

        actionBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                if (selectionCount <= 6){
                    actionBtn.setSelected(!actionBtn.isSelected());

                    if (actionBtn.isSelected()){
                        selectionCount += 1;
                        selectedInterest = selectedInterest+"ACT";
                    } else {
                        selectionCount -= 1;
                    }
                } else{
                    Toast.makeText(Hobbies.this, "Please only pick 6 interests", Toast.LENGTH_SHORT).show();
                }
            }
        });

        thrillerBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                if (selectionCount <= 6){
                    thrillerBtn.setSelected(!thrillerBtn.isSelected());

                    if (thrillerBtn.isSelected()){
                        selectionCount += 1;
                        selectedInterest = selectedInterest+"THR";
                    } else {
                        selectionCount -= 1;
                    }
                } else{
                    Toast.makeText(Hobbies.this, "Please only pick 6 interests", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button next = findViewById(R.id.nextButton);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                System.out.println(selectedInterest);

                FirebaseAuth mAuth = FirebaseAuth.getInstance();
                FirebaseUser firebaseUser = mAuth.getCurrentUser();
                assert firebaseUser != null;
                String userid = firebaseUser.getUid();
                DatabaseReference databaseReference = FirebaseDatabase.getInstance("https://forge-9e1e5-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Users");
                databaseReference.child(userid).child("hobbiesInterests").setValue(selectedInterest);
                openCoreValues();
            }
        });
    }

    private void openCoreValues() {
        Intent intent = new Intent(Hobbies.this, CoreValues.class);
        startActivity(intent);
    }

    public String getEmoji(int uni){
        return new String(Character.toChars(uni));
    }

}