package com.handavid.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import com.google.gson.Gson;


public class MainActivity extends AppCompatActivity {
    Button start, leader;
    EditText name1;
    SharedPreferences sharedpreferences;
    Leaderboard board = new Leaderboard();
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

    }
    private void moveToQuiz(){
        board.name=name1.getText().toString();
        board.score=0;
        Gson gson = new Gson();
        String json = gson.toJson(board);
        sharedpreferences = getSharedPreferences("Settings", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(board.name, json);
        editor.commit();
        Intent intent = new Intent(MainActivity.this,quiz.class);
        intent.putExtra("hi",board.name);
        startActivity(intent);
    }
    private void moveToQuiz2(){
        Intent intent = new Intent(MainActivity.this,Leaderboard_Stat.class);
        startActivity(intent);
    }
}
