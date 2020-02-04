package com.handavid.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button submitButton, colorButton;
    EditText responseText;
    EditText response2Text;
    TextView displayText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submitButton=findViewById(R.id.clickButton);
        colorButton=findViewById(R.id.clickButton2);
        responseText=findViewById(R.id.responseEditText);
        response2Text=findViewById(R.id.response2EditText);
        displayText=findViewById(R.id.textBox);
        submitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                System.out.println("Hello mom");
                Log.i("testButton","Hi dad! "+responseText.getText().toString());
                displayText.setText("Hi "+ responseText.getText().toString());
            }
        });
        colorButton.setOnClickListener(new View.OnClickListener(){
            //@Override
            int a=0;
            public void onClick(View view){
                a=a+1;
                displayText.setText("You clicked this button "+a+" times");
                view.setBackgroundColor(Color.GREEN);
            }
        });
        responseText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    if(responseText.getText().toString().equals("Hello TJ")){
                        displayText.setText("TJ Rocks!");
                        responseText.setText("");
                        responseText.setHint("That's a good name");
                    }
                }
            }
        });
    }
}
