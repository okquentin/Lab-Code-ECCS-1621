package com.example.mp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    RandomMooValue rmv = new RandomMooValue();

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


        randomButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {rmv.setSecretValue();}
        });



        guessButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                rmv.setSecretValue(secretValue.getText().toString());
                int MOO = rmv.getBigMooCount(guessValue.getText().toString());
                int moo = rmv.getLittleMooCount(guessValue.getText().toString());
                String MOOString = "" + MOO;
                String mooString = "" + moo;
                boolean isCorrect = rmv.isCorrectGuess(guessValue.getText().toString());
                String correctText = String.valueOf(isCorrect);
                bigCount.setText(MOOString);
                littleCount.setText(mooString);
                correct.setText(correctText);

            }
        });

    }
}
