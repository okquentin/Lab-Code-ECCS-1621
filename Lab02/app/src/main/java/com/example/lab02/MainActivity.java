package com.example.lab02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;


import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    boolean round = false;
    int size = 0;
    double area = 0.0;
    double costPerSquareInch = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.buttonNext);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                final TextView display = (TextView) findViewById(R.id.textView2);
                // Respond to button click
                if (size == 0) {
                    display.setText("HELP HELP - THIS DOES NOT WORK");
                }
                if (size == 1) {
                    if (round == true) {
                        area = 4 * 4 * Math.PI;
                    } else {
                        area = 8 * 8;
                    }
                    costPerSquareInch = 8.99 / area;
                }
                if (size == 2) {
                    if (round == true) {
                        area = 5 * 5 * Math.PI;
                    } else {
                        area = 10 * 10;
                    }
                    costPerSquareInch = 18.99 / area;
                }
                if (size == 3) {
                    if (round == true) {
                        area = 6 * 6 * Math.PI;
                    } else {
                        area = 12 * 12;
                    }
                    costPerSquareInch = 11.99 / area;
                }
                display.setText("Area of Pizza = " + area + "\n Cost Per Square Inch = " + costPerSquareInch);
            }
        });
    }
    public void onCheckboxClicked(View view){
        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()){
            case R.id.checkbox_round:
                if(checked)
                    round = true;
                break;
            case R.id.checkbox_square:
                if(checked)
                    round = false;
                break;
        }
    }
    public void onRadioButtonClicked(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()){
            case R.id.radio_small:
                if(checked){size = 1;}
                    break;
            case R.id.radio_medium:
                if(checked){size = 2;}
                    break;
            case R.id.radio_large:
                if(checked){size = 3;}
                    break;
        } // end of switch
    } //end of radio method
} // end of main

