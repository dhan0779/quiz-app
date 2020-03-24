package com.handavid.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.gson.Gson;


public class quiz extends AppCompatActivity {
    TextView questions;
    String[] qArray=new String[]{"Mercury is the...","Jupiter, Saturn, Uranus, and Neptune are commonly known as...",
                                 "What planet is nicknamed the ‘Red Planet’?","What is the third planet from the Sun?",
                                 "What is the seventh planet from the Sun?",""};
    String[][] ansArray=new String[][]{{"Smallest planet in our Solar System","Hottest planet in our Solar System","Closest planet in our Solar System.","All of the Above"},
                                       {"The 4 Giants","The Gas Giants","The Beasts","The O.G's"},
                                {"Mercury","Venus","Jupiter","Mars"},{"Mars","Earth","Pluto","Potato"},
                                    {"Neptune","Pluto","Uranus","Saturn"},{"","","",""}};
    //a,b,d,b,c
    int qNumber = 1;
    int correctAns = 0;
    Button ans1,ans2,ans3,ans4;
    SharedPreferences sharedpreferences;
    Leaderboard brd = new Leaderboard();
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
        ans1.setText(ansArray[qNumber-1][0]);
        ans2.setText(ansArray[qNumber-1][1]);
        ans3.setText(ansArray[qNumber-1][2]);
        ans4.setText(ansArray[qNumber-1][3]);
        ans1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(qNumber == 1)
                    correctAns++;
                if(qNumber >= 5) {
                    moveToQuiz3();
                }
                qNumber++;
                questions.setText(qArray[qNumber-1]);
                ans1.setText(ansArray[qNumber-1][0]);
                ans2.setText(ansArray[qNumber-1][1]);
                ans3.setText(ansArray[qNumber-1][2]);
                ans4.setText(ansArray[qNumber-1][3]);
                ans1.getBackground().clearColorFilter();
            }
        });
        ans2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(qNumber == 2 || qNumber== 4)
                    correctAns++;
                if(qNumber >= 5) {
                    moveToQuiz3();
                }
                qNumber++;
                questions.setText(qArray[qNumber-1]);
                ans1.setText(ansArray[qNumber-1][0]);
                ans2.setText(ansArray[qNumber-1][1]);
                ans3.setText(ansArray[qNumber-1][2]);
                ans4.setText(ansArray[qNumber-1][3]);
                ans2.getBackground().clearColorFilter();
            }
        });
        ans3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(qNumber == 3)
                    correctAns++;
                if(qNumber >= 5) {
                    moveToQuiz3();
                }
                qNumber++;
                questions.setText(qArray[qNumber-1]);
                ans1.setText(ansArray[qNumber-1][0]);
                ans2.setText(ansArray[qNumber-1][1]);
                ans3.setText(ansArray[qNumber-1][2]);
                ans4.setText(ansArray[qNumber-1][3]);
                ans3.getBackground().clearColorFilter();
            }
        });
        ans4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(qNumber == 5) {
                    correctAns++;
                    moveToQuiz3();
                }
                qNumber++;
                questions.setText(qArray[qNumber-1]);
                ans1.setText(ansArray[qNumber-1][0]);
                ans2.setText(ansArray[qNumber-1][1]);
                ans3.setText(ansArray[qNumber-1][2]);
                ans4.setText(ansArray[qNumber-1][3]);
                ans4.getBackground().clearColorFilter();
            }
        });
    }
    private void moveToQuiz3(){
        sharedpreferences = getSharedPreferences("Settings", Context.MODE_PRIVATE);
        Bundle extras = getIntent().getExtras();
        String key = extras.getString("hi");
        String json = sharedpreferences.getString(key, "none");
        Gson gson = new Gson();
        brd = gson.fromJson(json, Leaderboard.class);
        brd.score=correctAns;
        json = gson.toJson(brd);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(brd.name, json);
        editor.commit();
        Intent intent = new Intent(quiz.this,MainActivity.class);
        startActivity(intent);
    }
}
