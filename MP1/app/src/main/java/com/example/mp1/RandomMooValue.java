package com.example.mp1;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomMooValue {

    // Variables
    private int secretVal = 0;
    private int min = 0000;
    private int max = 9999;

    // Methods
    public boolean setSecretValue(){
        Random rand = new Random();
        secretVal = rand.nextInt(9999);
        return true;
    }

    public boolean setSecretValue(String n){
        if(n.length() > 4){return false;}

        else {
            secretVal = Integer.parseInt(n);
            return true;
            }
    }

    public String getSecretValue(){
        String n = "" + secretVal;
        while(n.length()<4) {n = '0'+n;}
        return n;
    }

    public int getBigMooCount(String guess){
        int MOO = 0;
        String n = getSecretValue();

        for(int i = 0; i < 4; i++){
            if(guess.charAt(i) ==  n.charAt(i)){MOO++;}
        }

        return MOO;
    }

    public int getLittleMooCount(String guess){
        int moo = 0;
        String n = getSecretValue();

        for(int i = 0; i < 4; i++){
            if(guess.charAt(0) ==  n.charAt(i)){moo++;}
            if(guess.charAt(1) ==  n.charAt(i)){moo++;}
            if(guess.charAt(2) ==  n.charAt(i)){moo++;}
            if(guess.charAt(3) ==  n.charAt(i)){moo++;}
            if(guess.charAt(i) ==  n.charAt(i)){moo--;}
        }

        return moo;
    }

    public boolean isCorrectGuess(String guess){
        String n = getSecretValue();
        if(guess.equals(n)){return true;}
        else{return false;}
    }

}
