package com.handavid.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.widget.LinearLayout.LayoutParams;

import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Map;

public class Leaderboard_Stat extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard__stat);
        LinearLayout cLayout = findViewById(R.id.lb_stat);
        sharedpreferences = getSharedPreferences("Settings", Context.MODE_PRIVATE);
        android.widget.LinearLayout.LayoutParams lparams = new LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        Map<String,?> keys = sharedpreferences.getAll();
        for(Map.Entry<String,?> entry : keys.entrySet()){
            TextView tv=new TextView(this);
            //tv.setLayoutParams(lparams);
            tv.setText(entry.getValue()+"\n" );
            cLayout.addView(tv);
            System.out.println(entry.getKey() + ": " + entry.getValue().toString());
        }
    }
}
