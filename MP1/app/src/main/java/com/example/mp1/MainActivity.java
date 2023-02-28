package com.example.mp1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {

    RandomMooValue rmv = new RandomMooValue();

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Variables
        final Button randomButton = findViewById(R.id.random);
        final Button guessButton = findViewById(R.id.guess);
        final EditText guessValue = findViewById(R.id.editTextGuessValue);
        final TextView mooText = findViewById(R.id.mooText);
        final TextView correct = findViewById(R.id.correctGuess);
        final TextView turnNum = findViewById(R.id.turnNum);
        final int[] turn = {0};

        // Actions to be performed once the "RANDOM" button is pressed
        randomButton.setOnClickListener(v -> {
            final String[] secretVal = {""};
            rmv.setSecretValue();
            secretVal[0] = rmv.getSecretValue();
        }); // end of setOnClickListener

        // Actions to be performed once the "GUESS!" button is pressed
        guessButton.setOnClickListener(v -> {

            // Check to make sure player inputs a 4 character guess, if the guess is valid then the turn count is incremented
            String playerGuess = guessValue.getText().toString();
            if (playerGuess.length() == 4){turn[0]++;}
            else{guessValue.setText("Error");}

            // Calls both "moo" count functions
            int MOO = rmv.getBigMooCount(guessValue.getText().toString());
            int moo = rmv.getLittleMooCount(guessValue.getText().toString());

            // Initializing and concatenating a string to show 'MOO!" and "moo." (based on MOO/moo count function returns)
            String mooString = "";
            for(int i = 0; i < MOO; i++){
                mooString += " MOO! ";
            }
            for(int i = 0; i < moo; i++){
                mooString += " moo. ";
            }

            // Setting the mooText TextView to the concatenated string of "MOO!"'s and/or "moo."'s
            mooText.setText(mooString);

            // Setting the current turn count to a string to be displayed in the app
            String turnString = String.valueOf(turn[0]);
            turnNum.setText(turnString + ":");

            // Calls guess correctness check method, displays status (Yes/No)
            boolean isCorrect = rmv.isCorrectGuess(guessValue.getText().toString());
            if(isCorrect){
                correct.setText("LaurieMOO!!!");
            }
            else if(turn[0] >=10){
                correct.setText("Boo hoo -- no LaurieMOO.");
            }
        }); // end of setOnClickListener

    } // end of onCreate
} // end of MainActivity
