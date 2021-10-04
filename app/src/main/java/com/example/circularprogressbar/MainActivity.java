package com.example.circularprogressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    Handler handler;
    Runnable runnable;
    Timer timer;
    Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar=findViewById(R.id.progressBar1);
        progressBar.setVisibility(View.GONE);
        start = findViewById(R.id.startButton);

        start.setOnClickListener(view -> {
            progressBar.setVisibility(View.VISIBLE);
            handler = new Handler();

            runnable= () -> {
                progressBar.setVisibility(View.GONE);
                timer.cancel();
            };

            timer=new Timer();

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.post(runnable);
                }
            }, 10000, 1000);
        });

//        handler = new Handler();
//
//        runnable=new Runnable(){
//
//            @Override
//            public void run() {
//                progressBar.setVisibility(View.GONE);
//                timer.cancel();
//            }
//        };
//
//        timer=new Timer();
//
//        timer.schedule(new TimerTask() {
//                           @Override
//                           public void run() {
//                                handler.post(runnable);
//                           }
//                       }, 10000, 1000);
    }
}