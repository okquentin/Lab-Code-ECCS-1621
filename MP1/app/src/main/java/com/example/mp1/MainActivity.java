package com.example.mp1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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
        final EditText secretValue = findViewById(R.id.editTextSecretValue);
        final EditText guessValue = findViewById(R.id.editTextGuessValue);
        final TextView bigCount = findViewById(R.id.bigMooCount);
        final TextView littleCount = findViewById(R.id.littleMooCount);
        final TextView correct = findViewById(R.id.correctGuess);

        // Actions to be performed once the "RANDOM" button is pressed
        randomButton.setOnClickListener(v -> {
            final String[] secretVal = {""};
            rmv.setSecretValue();
            secretVal[0] = rmv.getSecretValue();
            secretValue.setText(secretVal[0]);
        }); // end of setOnClickListener

        // Actions to be performed once the "GUESS!" button is pressed
        guessButton.setOnClickListener(v -> {

            // Temp variables for error checking
            final String[] secretVal = {""};
            final boolean[] validValue = {false};

            // Method call to set secret value
            rmv.setSecretValue(secretValue.getText().toString());
            secretVal[0] = rmv.getSecretValue();
            secretValue.setText(secretVal[0]);

            // Check to make sure player inputs a 4 character guess
            String playerGuess = guessValue.getText().toString();
            if (playerGuess.length() != 4){guessValue.setText("Error");}

            // Calls both "moo" count functions, displays results
            int MOO = rmv.getBigMooCount(guessValue.getText().toString());
            int moo = rmv.getLittleMooCount(guessValue.getText().toString());
            String MOOString = "" + MOO;
            String mooString = "" + moo;
            bigCount.setText(MOOString);
            littleCount.setText(mooString);

            // Calls guess correctness check method, displays status (Yes/No)
            boolean isCorrect = rmv.isCorrectGuess(guessValue.getText().toString());
            if(isCorrect){correct.setText("Yes!");}
            else{correct.setText("No.");}
        }); // end of setOnClickListener

    } // end of onCreate
} // end of MainActivity
