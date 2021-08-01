package com.test.twodigitmultiplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import java.lang.annotation.Repeatable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Start extends AppCompatActivity {

    private Button button;
    TextView textView1, textView2, textView3, textView4;
    int points = 0, btn_counter = 0;

    Random random = new Random();
    int num_1 = random.nextInt(100-11)+11;
    int num_2 = random.nextInt(100-11)+11;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        textView1 = findViewById(R.id.textView10);
        textView2 = findViewById(R.id.textView7);
        textView3 = findViewById(R.id.textView8);
        textView4 = findViewById(R.id.editTextNumber2);

        button = findViewById(R.id.button4);

        String value = getIntent().getStringExtra("value");
        int n = Integer.parseInt(value);

        textView1.setText("1 )");
        textView2.setText(Integer.toString(num_1));
        textView3.setText("x  " + Integer.toString(num_2));

        LocalDateTime time_obj1 = LocalDateTime.now();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int usr_val = 0;
                btn_counter++;
                String extract = textView4.getText().toString();

                if(!(TextUtils.isEmpty(extract))){
                    usr_val = Integer.parseInt(extract);
                }

                int mul_val = num_1 * num_2;
                if(usr_val == mul_val)
                    points++;
                if(btn_counter < n) {
                    num_1 = random.nextInt(100 - 11) + 11;
                    num_2 = random.nextInt(100 - 11) + 11;
                    textView1.setText(Integer.toString(btn_counter + 1) + " )");
                    textView2.setText(Integer.toString(num_1));
                    textView3.setText("x  " + Integer.toString(num_2));
                    textView4.setText("");
                }
                else {
                    button.setText("Get Result");
                    int color = Color.argb(255, 76, 175, 80);
                    button.setBackgroundColor(color);

                    LocalDateTime time_obj2 = LocalDateTime.now();

                    DateTimeFormatter format = DateTimeFormatter.ofPattern("hh:mm:ss a");
                    String time_1 = time_obj1.format(format);
                    String time_2 = time_obj2.format(format);

                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(Start.this, GetResult.class);
                            intent.putExtra("points", Integer.toString(points));
                            intent.putExtra("time_1", time_1);
                            intent.putExtra("time_2", time_2);
                            intent.putExtra("total_n", value);
                            startActivity(intent);
                        }
                    });
                }

            }
        });

    }

}