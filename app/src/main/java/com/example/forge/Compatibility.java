package com.example.forge;
import java.util.*;
public class Compatibility {

    public Compatibility(){

    }

    //need...
    //1. the users mbti result
    //2. core values
    //3. hobbies and interests
    //4. what they feel the offer most
    //5. what they value most
    //6. most dominant trait
    public float checkCompatibility(User userA, User userB){
        float compatibilityScore = 0;
        //max amount allowed to select
        int totalCoreValues = 3;
        //max amount allowed to select
        int totalHobbiesInterests = 6;

        String[][] compatibleMBTI = {
                {"ENTJ", "ENTP", "INTJ", "INTP", "ESTJ", "ESFJ", "ISTJ", "ISFJ", "ENFJ", "ENFP", "INFJ", "INFP", "ESTP", "ESFP", "ISTP", "ISFP"},
                {"INFP", "ISTJ", "ESFP", "ENTJ", "INTP", "ISFP", "ENTP", "ENFP", "ISTP", "ISFJ", "ESTP", "ENTJ", "INFJ", "INTJ", "ENFJ", "ESFJ"},
                {"ENTP", "ENTJ", "ENTJ", "ESTJ", "ISTJ", "ESFJ", "ESTJ", "ESTJ", "ISFP", "ISFP", "INTJ", "ENFJ", "ISFJ", "ESTJ", "ESTP", "ENTJ"},
                {"INTJ", "INTP", "INFJ", "ENTP", "ESFP", "ISFJ", "ESFP", "ESTP", "INFP", "INFJ", "ENFP", "ISTP", "ISTP", "ISTJ", "INFP", "ENFP"},
        };


        //find whether the mbti personality types are compatible, based off the array we created
        for(int col = 0; col < 16; col++){
            if (compatibleMBTI[0][col].equals(userA.getPersonalityType())){
                for(int row = 0; row < 4; row++){
                    if (compatibleMBTI[row][col].equals(userB.getPersonalityType())){
                        compatibilityScore += 0.3;
                        System.out.println("mbti");
                        //escape the inner for loop
                        break;
                    }
                }
                //escape the for loop
                break;
            }
        }


        //FIND OVERLAPPING CORE VALUES
        //convert core values string to array
        String valuesStringA = userA.getCoreValues();
        String valuesStringB = userB.getCoreValues();

        int length = valuesStringA.length();
        String[] coreValuesA = new String[length/3];
        String[] coreValuesB = new String[length/3];
        String valueA = "";
        String valueB = "";

        int index = 0;
        for(int j = 0; j<length; j++){
            valueA += valuesStringA.charAt(j);
            valueB += valuesStringB.charAt(j);
            if((j+1)%3 == 0){
                coreValuesA[index] = valueA;
                coreValuesB[index] = valueB;
                index++;
                valueA = "";
                valueB = "";
            }
        }



        //convert arrays to sets
        Set<String> coreA = new HashSet<String>(Arrays.asList(coreValuesA));
        Set<String> coreB = new HashSet<String>(Arrays.asList(coreValuesB));
        //find intersection
        coreA.retainAll(coreB);
        String[] valuesOverlap = coreA.toArray(new String[coreA.size()]);

        int sizeOfIntersection = valuesOverlap.length;
        if (sizeOfIntersection > 1) {
            System.out.println("coreValues");
        }
        //update compatibility score based on proportion of same core values
        compatibilityScore += (sizeOfIntersection/totalCoreValues)*0.2;


        //FIND OVERLAPPING HOBBIES AND INTERESTS
        //convert hobbies and interests string to array
        String interestsStringA = userA.getHobbiesInterests();
        String interestsStringB = userB.getHobbiesInterests();

        //users required to pick the same amount, so can just take length for one
        int len = interestsStringA.length();
        String[] hobIntA = new String[len/3];
        String[] hobIntB = new String[len/3];
        String hobbiesIntA = "";
        String hobbiesIntB = "";

        int i = 0;
        for(int j = 0; j<len; j++){
            hobbiesIntA += interestsStringA.charAt(j);
            hobbiesIntB += interestsStringB.charAt(j);
            if((j+1)%3 == 0){
                hobIntA[i] = hobbiesIntA;
                hobIntB[i] = hobbiesIntB;
                i++;
                hobbiesIntA = "";
                hobbiesIntB = "";
            }
        }


        //convert arrays to sets
        Set<String> setA = new HashSet<String>(Arrays.asList(hobIntA));
        Set<String> setB = new HashSet<String>(Arrays.asList(hobIntB));

        //find intersection
        setA.retainAll(setB);
        String[] interestsOverlap = setA.toArray(new String[setA.size()]);

        int intersectionSize = interestsOverlap.length;
        if (intersectionSize > 1) {
            System.out.println("hobbies");
        }
        //update compatibility score based on proportion of same hobbies and interests
        compatibilityScore += (intersectionSize/totalHobbiesInterests)*0.2;


        //IF WHAT THE USERS OFFER MOST IN A FRIENDSHIP OR VALUES MOST IN A FRIENDSHIP IS COMPATIBLE
        //...UPDATE COMPATIBLITY SCORE ACCORDINGLY.
        if (userA.getValueMost().equals(userB.getOfferMost()) || userB.getValueMost().equals(userA.getOfferMost())){
            compatibilityScore += 0.2;
            System.out.println("offer");
        }
        else if (userA.getValueMost().equals(userB.getValueMost()) || userA.getOfferMost().equals(userB.getOfferMost())){
            compatibilityScore += 0.1;
            System.out.println("value");
        }

        String[] types = {"E", "I", "S", "N", "T", "F", "J", "P"};

        //FIND THE OPPOSITE TRAIT FOR USER A, BY TRAVERSING THE TYPES ARRAY
        String oppositeTrait = "";
        for(int x = 0; x < 8; x++){
            if (types[x].equals(userA.getDominantTrait())){
                if (x%2 == 0){
                    oppositeTrait = types[x+1];
                }
                else{
                    oppositeTrait = types[x-1];
                }
                break;
            }
        }


        //if the users have complementary dominant traits, this increases the compatibilityScore
        if (userB.getDominantTrait().equals(oppositeTrait)){
            compatibilityScore += 0.1;
            System.out.println("dominant");
        }



        return compatibilityScore;
    }

}