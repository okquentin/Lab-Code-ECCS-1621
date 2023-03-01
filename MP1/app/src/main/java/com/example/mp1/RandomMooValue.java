package com.example.mp1;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Name: RandomMooValue
 * Date: 2/14/23
 * Author: Quentin Osterhage
 * Description:
 */

public class RandomMooValue {

    // Variables
    private int secretVal = 0;
    private int min = 0000;
    private int max = 9999;

    /**
     * setSecretValue
     * Sets the private int 'secretVal' into a randomly generated integer between 0 and 9999.
     * @return boolean result - always returns true
     */
    public boolean setSecretValue(){
        Random rand = new Random();
        secretVal = rand.nextInt(9999);
        return true;
    }

    /**
     * setSecretValue
     * Turns the private int 'secretVal' into a formatted string and returns it to the user, with error checking
     * @param n String - the player input for setting the secret value manually
     * @return boolean result - false when length of 'n' is greater than 4, else false
     */
    public boolean setSecretValue(String n){
        if(n.length() > 4){return false;}

        else {
            secretVal = Integer.parseInt(n);
            return true;
            }
    }

    /**
     * getSecretValue
     * Turns the private int 'secretVal' into a formatted string and returns it to the user
     * @return string n - the formatted string of 'secretVal'
     */
    public String getSecretValue(){
        String n = "" + secretVal;
        while(n.length() < 4) {n = '0'+n;}
        return n;
    }

    /**
     * getLittleMooCount
     * Checks every element of the 'guess' string to the 'secret' value string
     * @param guess String - the guess input by the player
     * @return int MOO - the count of correctly guessed numbers in the right place
     */
    public int getBigMooCount(String guess){
        int MOO = 0;

        String n = getSecretValue();

        for(int i = 0; i < 4; i++){
            if(guess.charAt(i) ==  n.charAt(i)){MOO++;}
        }
        return MOO;
    }

    /**
     * getLittleMooCount
     * Checks every element of the 'guess' string to the 'secret' value string
     * @param guess string - the guess input by the player
     * @return int moo - the count of correctly guessed numbers (not in the right place)
     */
    public int getLittleMooCount(String guess){
        int moo = 0;
        String n = getSecretValue();

        for(int i = 0; i < 4; i++){
            if(guess.charAt(i) ==  n.charAt(i)){moo--; if(moo<1){moo++;} continue;}
            if(guess.charAt(0) ==  n.charAt(i)){moo++; continue;}
            if(guess.charAt(1) ==  n.charAt(i)){moo++; continue;}
            if(guess.charAt(2) ==  n.charAt(i)){moo++; continue;}
            if(guess.charAt(3) ==  n.charAt(i)){moo++; continue;}
            if(moo < 0){moo ++;}
        }
        if(moo < 0){moo = 0;}
        return moo;
    }

    /**
     * isCorrectGuess
     * Checks whether the string input by the player is the same as the secret value
     * @param guess String - the string input by the player
     * @return boolean result - true if the strings are equal, false otherwise
     */
    public boolean isCorrectGuess(String guess){
        String n = getSecretValue();
        if(guess.equals(n)){return true;}
        else{return false;}
    }

}

