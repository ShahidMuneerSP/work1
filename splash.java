package com.example.myapplication.task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.myapplication.R;
import com.example.myapplication.work1.MainActivity1;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler obj=new Handler();
        obj.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(getApplicationContext(), MainActivity1.class);
                startActivity(intent);
            }
        },5000);

    }


}