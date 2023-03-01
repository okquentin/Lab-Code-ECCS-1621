package com.example.mp1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Name: MainActivity
 * Date: 2/14/23
 * Author: Quentin Osterhage
 * Description: The main code for the app, with calls to functions defined in custom class
 */

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
        final TextView valueWas = findViewById(R.id.valueWas);
        final TextView revealSecret = findViewById(R.id.revealSecret);

        final int[] turn = {0};
        final int[] game = {0};

        // Actions to be performed once the "RANDOM" button is pressed.
        randomButton.setOnClickListener(v -> {

            // Calls the setSecretValue method and sets the turn to zero.
            rmv.setSecretValue();
            turn[0] = 0;

            // Display the turn as zero, prompt for a new guess
            String turnString = String.valueOf(turn[0]);
            turnNum.setText(turnString + ":");
            guessValue.setText("Guess Here");

        }); // end of setOnClickListener.

        // Actions to be performed once the "GUESS!" button is pressed.
        guessButton.setOnClickListener(v -> {
            String secretVal = rmv.getSecretValue();
            String playerGuess = guessValue.getText().toString();
            // Check to make sure player inputs a 4 character guess, if the guess is valid then the turn count is incremented.
            if (playerGuess.length() == 4) {
                    turn[0]++;

                    // Calls both "moo" count methods.
                    int MOO = rmv.getBigMooCount(guessValue.getText().toString());
                    int moo = rmv.getLittleMooCount(guessValue.getText().toString());

                    // Initializing and concatenating a string to show 'MOO!" and "moo." (based on MOO/moo count function returns).
                    StringBuilder mooString = new StringBuilder();
                    for (int i = 0; i < MOO; i++) {
                        mooString.append(" MOO! ");
                    }
                    for (int i = 0; i < moo; i++) {
                        mooString.append(" moo. ");
                    }

                    // Setting the mooText TextView to the concatenated string of "MOO!"'s and/or "moo."'s.
                    mooText.setText(mooString.toString());

                    // Setting the mooText TextView to "all you hear are cowbells" in the case of no moo's.
                    if (moo == 0 && MOO == 0) mooText.setText("All you hear are cowbells...");

                    // Setting the current turn count to a string to be displayed in the app.
                    String turnString = String.valueOf(turn[0]);
                    turnNum.setText(turnString + ":");

                    // Calls guess correctness check method, displays results with custom messages.
                    boolean isCorrect = rmv.isCorrectGuess(guessValue.getText().toString());
                    if (isCorrect) {
                        correct.setText("LaurieMOO!!!");
                        revealSecret.setText(secretVal);
                        game[0]++;
                        turn[0] = 0;

                    } else if (turn[0] >= 10) {
                        correct.setText("Boo hoo -- no LaurieMOO.");
                        valueWas.setText("The secret was:");
                        revealSecret.setText(secretVal);
                        game[0]++;
                        turn[0] = 0;
                    }

                    // Check to terminate the Game
                    if(game[0] > 0){
                        mooText.setText("Please generate a new value");
                        guessValue.setText("Please generate a new value");
                    }
                }
                else {
                    // Displays an error when the length of an input guess != 4
                    guessValue.setText("Error");
                    mooText.setText("Please enter a valid guess.");
                    if(turn[0] >= 0)
                        turn[0]--;

                    // Check to terminate the game
                    if(game[0] > 0){
                        mooText.setText("Game Over.");
                        guessValue.setText("Game Over.");
                    }
                }

            // Check to ensure that a value is generated before guessing can begin.
            if (Integer.parseInt(rmv.getSecretValue()) == 0 && game[0] == 0) {
                guessValue.setText("Error");
                mooText.setText("Please generate a random value.");
                if(turn[0] >= 0)
                    turn[0]--;
            }

        }); // end of setOnClickListener
    } // end of onCreate
} // end of MainActivity
