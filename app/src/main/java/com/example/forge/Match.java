package com.example.forge;

public class Match {

    private String user1;
    private String user2;
    private String recordID;

    public Match (String user1, String user2, String recordID) {
        this.user1 = user1;
        this.user2 = user2;
        this.recordID = recordID;
    }

    public Match () {

    }

    public String getRecordID() {
        return recordID;
    }

    public void setRecordID(String recordID) {
        this.recordID = recordID;
    }

    public String getUser1() {
        return user1;
    }

    public void setUser1(String user1) {
        this.user1 = user1;
    }

    public String getUser2() {
        return user2;
    }

    public void setUser2(String user2) {
        this.user2 = user2;
    }
}
