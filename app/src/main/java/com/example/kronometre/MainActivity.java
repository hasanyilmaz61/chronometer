package com.example.kronometre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    int nummer;
    Runnable runnable;
    Handler handler;
    Button button;
    Button button3;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.textview);
        button=findViewById(R.id.button);
        button3=findViewById(R.id.button3);
        button2=findViewById(R.id.button2);
        nummer=0;

        button3.setVisibility(View.INVISIBLE);


    }

    public  void button(View view){
        button2.setEnabled(false);
        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                textView.setText("Timer:"+nummer);
                nummer++;
                textView.setText("Timer:"+nummer);
                handler.postDelayed(runnable,1000);

            }
        };
        handler.post(runnable);
        button.setVisibility(View.INVISIBLE);
        button3.setVisibility(View.VISIBLE);




    }
    public void  button2 (View view){


        handler.removeCallbacks(runnable);
        nummer=0;
        textView.setText("Timer:"+nummer);
    }


    public void  button3 (View view){
        button.setVisibility(View.VISIBLE);
        button3.setVisibility(View.INVISIBLE);
        button2.setEnabled(true);

        handler.removeCallbacks(runnable);
        textView.setText("Timer:"+nummer);

    }



}