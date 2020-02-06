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
    Button ansButton1, ansButton2,ansButton3,ansButton4;
    EditText responseText;
    EditText response2Text;
    TextView displayText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ansButton1=findViewById(R.id.clickButton);
        ansButton2=findViewById(R.id.clickButton2);
        ansButton3=findViewById(R.id.clickButton3);
        ansButton4=findViewById(R.id.clickButton4);
        responseText=findViewById(R.id.responseEditText);
        response2Text=findViewById(R.id.response2EditText);
        displayText=findViewById(R.id.textBox);
        ansButton1.setOnClickListener(new View.OnClickListener(){
            //@Override
            int a=0;
            public void onClick(View view){
                a=a+1;
                displayText.setText("You clicked this button "+a+" times");
                view.setBackgroundColor(Color.GREEN);
            }
        });
        ansButton2.setOnClickListener(new View.OnClickListener(){
            //@Override
            int b=0;
            public void onClick(View view){
                b=b+1;
                displayText.setText("You clicked this button "+b+" times");
                view.setBackgroundColor(Color.RED);
            }
        });
        ansButton3.setOnClickListener(new View.OnClickListener(){
            //@Override
            int c=0;
            public void onClick(View view){
                c=c+1;
                displayText.setText("You clicked this button "+c+" times");
                view.setBackgroundColor(Color.BLUE);
            }
        });
        ansButton4.setOnClickListener(new View.OnClickListener(){
            //@Override
            int d=0;
            public void onClick(View view){
                d=d+1;
                displayText.setText("You clicked this button "+d+" times");
                view.setBackgroundColor(Color.YELLOW);
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
