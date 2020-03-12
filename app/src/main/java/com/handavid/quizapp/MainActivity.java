package com.handavid.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    Button start, leader;
    EditText name1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start=findViewById(R.id.start);
        name1=findViewById(R.id.names);
        leader=findViewById(R.id.leaderboard);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToQuiz();
            }
        });
        leader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToQuiz2();
            }
        });
        Leaderboard board = new Leaderboard();
        board.name=name1.getText().toString();
        board.score=0;
        //Gson gson = new Gson();

    }
    private void moveToQuiz(){
        Intent intent = new Intent(MainActivity.this,quiz.class);
        startActivity(intent);
    }
    private void moveToQuiz2(){
        Intent intent = new Intent(MainActivity.this,Leaderboard_Stat.class);
        startActivity(intent);
    }
}
