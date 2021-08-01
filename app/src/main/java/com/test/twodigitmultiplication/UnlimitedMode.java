package com.test.twodigitmultiplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class UnlimitedMode extends AppCompatActivity {

    private Button btn_quit, btn_next;
    TextView textView1, textView2, textView3, textView4;
    int question_no = 1;

    Random random = new Random();
    int num_1 = random.nextInt(100 - 11) + 11;
    int num_2 = random.nextInt(100 - 11) + 11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unlimited_mode);

        textView1 = findViewById(R.id.textView28);
        textView2 = findViewById(R.id.textView26);
        textView3 = findViewById(R.id.textView27);

        textView4 = findViewById(R.id.editTextNumber5);

        textView1.setText("1 )");
        textView2.setText(Integer.toString(num_1));
        textView3.setText("x  " + Integer.toString(num_2));

        btn_next = findViewById(R.id.button9);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int real_mul = num_1 * num_2;
                String value = textView4.getText().toString();

                if(TextUtils.isEmpty(value)){
                    Toast.makeText(getApplicationContext(), "This field cannot be empty !", Toast.LENGTH_SHORT).show();
                }
                else if (real_mul != Integer.parseInt(value)){
                    Toast.makeText(getApplicationContext(), "Wrong! Try Again", Toast.LENGTH_SHORT).show();
                }
                else {
                    question_no++;
                    textView1.setText(question_no + " )");

                    num_1 = random.nextInt(100 - 11) + 11;
                    num_2 = random.nextInt(100 - 11) + 11;
                    textView2.setText(Integer.toString(num_1));
                    textView3.setText("x  " + Integer.toString(num_2));
                    textView4.setText("");
                }

            }
        });

        btn_quit = findViewById(R.id.button10);
        btn_quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}