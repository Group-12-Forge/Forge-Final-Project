package com.example.forge;

public class User {

    public String id;
    public String email;
    private String name;
    private String username;
    private String imageURL;

    //added below in
    private String personalityType;
    private String coreValues;
    private String hobbiesInterests;
    private String dominantTrait;
    private String valueMost;
    private String offerMost;


    //changed the first line
    public User(String id, String email, String name, String username, String imageURL, String personalityType, String coreValues, String hobbiesInterests, String dominantTrait, String valueMost, String offerMost) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.username = username;
        this.imageURL = imageURL;


        //added in
        this.personalityType = personalityType;
        this.coreValues = coreValues;
        this.hobbiesInterests = hobbiesInterests;
        this.dominantTrait = dominantTrait;
        this.valueMost = valueMost;
        this.offerMost = offerMost;

    }

    public User() {

    }

    //added more getter and setter methods
    public String getPersonalityType(){
        return personalityType;
    }

    public void setPersonalityType(){
        this.personalityType = personalityType;
    }

    public String getCoreValues(){
        return coreValues;
    }

    public void setCoreValues(){
        this.coreValues = coreValues;
    }

    public String getHobbiesInterests(){
        return hobbiesInterests;
    }

    public void setHobbiesInterests(){
        this.hobbiesInterests = hobbiesInterests;
    }

    public String getDominantTrait(){
        return dominantTrait;
    }

    public void setDominantTrait(){
        this.dominantTrait = dominantTrait;
    }

    public String getValueMost(){
        return valueMost;
    }

    public void setValueMost(){
        this.valueMost = valueMost;
    }

    public String getOfferMost(){
        return offerMost;
    }

    public void setOfferMost(){
        this.offerMost = offerMost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
