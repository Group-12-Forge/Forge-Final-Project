package com.example.forge;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.forge.Adapter.MessageAdapter;
import com.example.forge.Adapter.UserAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.*;


//TODO: send updated compatibility file and user class to the rest of the group
//TODO: update user class tp include getBio()


public class Matches extends AppCompatActivity {
    //global variables

    int userIndex = 0;
    boolean computed = false;

    User currentUser;
    User thisUser;
    ArrayList<User> potentialMatches;
    //TODO: send matches to database, so Gurpreet can use for chat
    //TODO: how I imagine that working it gets replaced with the matches arrayList every time ...
    //TODO: this page is loaded, the matches arrayList in the database is overwritten by this more current one
    ArrayList<User> matches;

    ArrayList<User> allUsers;
    int totalUsers = 0;

    Button next;
    TextView noMatches;

    ImageView profilePicture;
    Button matchButton, unmatchButton;
    TextView username;
    TextView mbti;
    TextView bio;

    FirebaseUser fuser;
    DatabaseReference reference;
    String userid;
    String matchedPersonID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matches);

        potentialMatches = new ArrayList<User>();
        matches = new ArrayList<User>();
        allUsers = new ArrayList<User>();

        //TODO: call the database, take whatever is matches for the current user...
        //TODO: this will be fill the matches array list

        fuser = FirebaseAuth.getInstance().getCurrentUser();
        userid = fuser.getUid();

        reference = FirebaseDatabase.getInstance("https://forge-9e1e5-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Matches");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                matches.clear();
                for (DataSnapshot databaseSnapshot : snapshot.getChildren()) {
                    Match match = databaseSnapshot.getValue(Match.class);
                    User user = databaseSnapshot.getValue(User.class);
                    if (fuser != null) {
                        if (match != null && userid != null) {
                            if (match.getUser1().equals(userid)) {
                                matchedPersonID = match.getUser2();
                                System.out.println("Matched");
                            } else if (match.getUser2().equals(userid)) {
                                matchedPersonID = match.getUser1();
                            }
                            if (user != null) {
                                if (matchedPersonID.equals(user.getId())) {
                                    matches.add(user);
                                    Toast.makeText(Matches.this, "Match has been added", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }
                }
                // messageAdapter = new MessageAdapter(MessageActivity.this, mchat, imageurl);
                //recyclerView.setAdapter(messageAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        noMatches = (TextView) findViewById(R.id.textView3);

        profilePicture = (ImageView) findViewById(R.id.profilePicture);
        matchButton = (Button) findViewById(R.id.matchButton);
        unmatchButton = (Button) findViewById(R.id.unmatchButton);
        username = (TextView) findViewById(R.id.username);
        mbti = (TextView) findViewById(R.id.mbti);
        bio = (TextView) findViewById(R.id.bio);
        next = (Button) findViewById(R.id.nextButton);


        //Created some users to test with - will have to get all of this from the database
        //TODO: get users from the database
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference reference = FirebaseDatabase.getInstance("https://forge-9e1e5-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Users");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //allUsers.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    User user = snapshot.getValue(User.class);
                    //System.out.println("User id = " + firebaseUser.getUid());
                    //System.out.println("User id = " + user.getId());
                    if (user != null) {
                        if (user.getId().equals(firebaseUser.getUid())) {
                            //allUsers.add(user);
                            thisUser = user;
                            currentUser = thisUser;
                        }
                    }
                }

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    User user = snapshot.getValue(User.class);
                    //System.out.println("User id = " + firebaseUser.getUid());
                    //System.out.println("User id = " + user.getId());
                    if (user != null) {
                        if (!user.getId().equals(firebaseUser.getUid())) {
                            //allUsers.add(user);
                            loadMatches(user);
                            //System.out.println(user.getUsername());
                            //System.out.println(user.getHobbiesInterests());
                            System.out.println("User added");
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        System.out.println(allUsers + "####################################################");


        totalUsers = allUsers.size();
        System.out.println(totalUsers + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        //call loadMatches() function


        if (matches.contains(currentUser) == false) {
            //matchButton.setVisibility(ImageView.VISIBLE);
            matchButton.setText("Match");
        } else {
            //matchButton.setVisibility(ImageView.INVISIBLE);
            matchButton.setText("Unmatch");
        }

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //display next user in potential matches
                if (userIndex < potentialMatches.size() - 1) {
                    userIndex += 1;
                }

                //reset userIndex to 0 if gone through all matches
                else {
                    userIndex = 0;
                }
                //call presentNextMatch(); to display next potential match
                presentNextMatch();

                if (matches.contains(currentUser) == false) {
                    matchButton.setText("Match");
                } else {

                    matchButton.setText("Unmatch");
                }
            }
        });

        matchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //add current user to match arrayList
                //if current user not in matches array
                if (matches.contains(currentUser) == false) {
                    matches.add(currentUser);
                    DatabaseReference reference = FirebaseDatabase.getInstance("https://forge-9e1e5-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Matches");
                    HashMap<String, Object> hashMap = new HashMap<>();
                    FirebaseAuth mAuth = FirebaseAuth.getInstance();
                    FirebaseUser firebaseUser = mAuth.getCurrentUser();
                    assert firebaseUser != null;
                    String userid = firebaseUser.getUid();
                    String recordID = reference.push().getKey();
                    hashMap.put("user1", userid);
                    hashMap.put("user2", currentUser.getId());
                    hashMap.put("recordID", recordID);
                    reference.child(recordID).setValue(hashMap);
                    //matchID.add(currentUser.getId());
                    //matchButton.setVisibility(ImageView.INVISIBLE);
                    //matchButton.setText("Unmatch");
                }
            }
        });

        unmatchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                matches.remove(currentUser);
                FirebaseAuth mAuth = FirebaseAuth.getInstance();
                FirebaseUser firebaseUser = mAuth.getCurrentUser();
                assert firebaseUser != null;
                String userid = firebaseUser.getUid();
                DatabaseReference reference = FirebaseDatabase.getInstance("https://forge-9e1e5-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Matches");
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot databaseSnapshot : snapshot.getChildren()) {
                            Match match = databaseSnapshot.getValue(Match.class);
                            if (match != null) {
                                if (match.getUser1().equals(userid) && match.getUser2().equals(currentUser.getId()) || match.getUser1().equals(currentUser.getId()) && match.getUser2().equals(userid)) {
                                    reference.child(match.getRecordID()).child("user1").removeValue();
                                    reference.child(match.getRecordID()).child("recordID").removeValue();
                                    reference.child(match.getRecordID()).child("user2").removeValue();
                                    System.out.println("Match removed********************************");
                                }
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                //remove from matches arrayList
            }

        });
    }


    public void loadMatches(User userB) {


        float compatibilityScore = 0;
        Compatibility comp = new Compatibility();

        System.out.println(allUsers.size() + "????????????????????????????????????????????????????????????????????");
        compatibilityScore = comp.checkCompatibility(thisUser, userB);
        //System.out.println(userB.getHobbiesInterests() + "+++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(userB.getPersonalityType() + "+++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(userB.getOfferMost() + "+++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(userB.getValueMost() + "+++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(userB.getDominantTrait() + "+++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("£££££££££££££££££££££££££££££££££££££££");
        System.out.println(thisUser.getPersonalityType() + "+++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(thisUser.getOfferMost() + "+++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(thisUser.getValueMost() + "+++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(thisUser.getDominantTrait() + "+++++++++++++++++++++++++++++++++++++++++++++");
        if (compatibilityScore >= 0.6) {
            potentialMatches.add(userB);
        }
        System.out.println(compatibilityScore + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        //set computed to true so this section isn't computed again again


        System.out.println(potentialMatches.size() + "--------------------------------------------------------------------------------------------------------------");

        //if there are actually potential matches
        presentNextMatch();


    }

    public void presentNextMatch(){
        if(potentialMatches.size()>0){
            //hide no matches
            noMatches.setVisibility(TextView.INVISIBLE);

            User match = potentialMatches.get(userIndex);
            //store the current user being displayed
            currentUser = match;
            String image = match.getImageURL();

            String profileImage = match.getImageURL();
            if(profileImage.equals("dolphin")) {
                profilePicture.setImageResource(R.drawable.profile1);
            }

            else if (profileImage.equals("crocodile")){
                profilePicture.setImageResource(R.drawable.profile2);
            }

            else if (profileImage.equals("koala")){
                profilePicture.setImageResource(R.drawable.profile3);
            }

            else if (profileImage.equals("peacock")){
                profilePicture.setImageResource(R.drawable.profile4);
            }

            //profile 4
            else {
                profilePicture.setImageResource(R.drawable.ic_baseline_android_24);
            }

            username.setText(match.getUsername());
            mbti.setText(match.getPersonalityType());
            bio.setText(match.getBio());


        }

        //the current user has no potential matches
        else{
            //hide all elements
            //display no matches textView only

            profilePicture.setVisibility(ImageView.INVISIBLE);
            next.setVisibility(ImageView.INVISIBLE);
            matchButton.setVisibility(ImageView.INVISIBLE);
            username.setVisibility(ImageView.INVISIBLE);
            mbti.setVisibility(ImageView.INVISIBLE);
            bio.setVisibility(ImageView.INVISIBLE);

        }
    }


}