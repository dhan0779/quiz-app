package com.handavid.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class quiz extends AppCompatActivity {
    TextView questions;
    String[] qArray=new String[]{"1","2","3","4","5"};
    int qNumber = 1;
    Button ans1,ans2,ans3,ans4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        ans1=findViewById(R.id.clickButton);
        ans2=findViewById(R.id.clickButton2);
        ans3=findViewById(R.id.clickButton3);
        ans4=findViewById(R.id.clickButton4);
        questions=findViewById(R.id.textBox);
        questions.setText(qArray[qNumber-1]);
        ans1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(qNumber == 1){

                }
                else{

                }
            }
        });
        ans2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

            }
        });
        ans3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

            }
        });
        ans4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

            }
        });

    }
}
