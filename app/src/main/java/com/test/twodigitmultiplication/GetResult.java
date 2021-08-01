package com.test.twodigitmultiplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GetResult extends AppCompatActivity {

    TextView textView1, textView2, textView3, textView4, textView5;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_result);

        String points = getIntent().getStringExtra("points");
        String time_1 = getIntent().getStringExtra("time_1");
        String time_2 = getIntent().getStringExtra("time_2");
        String total_n = getIntent().getStringExtra("total_n");

        textView1 = findViewById(R.id.textView6);
        textView2 = findViewById(R.id.textView11);
        textView3 = findViewById(R.id.textView12);

        textView4 = findViewById(R.id.textView16);

        textView5 = findViewById(R.id.textView20);

        button = findViewById(R.id.button7);

        int you_got = Integer.parseInt(points);
        int out_of = Integer.parseInt(total_n);
        if(you_got == 0){
            textView5.setTextSize(18);
            textView5.setText("If struggling, consider taking the tutorial !");
            button.setVisibility(View.VISIBLE);
            int color = Color.argb(185, 255, 0 , 0);
            textView4.setBackgroundColor(color);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), Tutorial.class);
                    startActivity(intent);
                }
            });
        }
        else if(you_got == out_of){
            textView5.setText("Congratulations !");
            int color = Color.argb(185, 0, 255, 0);
            textView4.setBackgroundColor(color);
        }
        else if(you_got > out_of/2){
            textView5.setText("Good !");
            int color = Color.argb(185, 255, 255, 0);
            textView4.setBackgroundColor(color);
        }
        else {
            textView5.setText("Work Harder !");
            int color = Color.argb(185, 255, 87, 34);
            textView4.setBackgroundColor(color);
        }

        textView1.setText(points + " points out of " + total_n);
        textView2.setText(time_1);
        textView3.setText(time_2);

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(GetResult.this, TakeTest.class);
        startActivity(intent);
    }
}