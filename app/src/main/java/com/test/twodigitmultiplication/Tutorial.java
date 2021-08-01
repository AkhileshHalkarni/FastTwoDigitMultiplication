package com.test.twodigitmultiplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Tutorial extends AppCompatActivity {

    TextView textView1, textView2, textView3, textView4, textView5, textView_info;
    EditText editText1;
    private Button btn;
    Random random = new Random();
    int num_1 = random.nextInt(10 - 1) + 1;
    int num_2 = random.nextInt(10 - 1) + 1;
    int num_3 = random.nextInt(10 - 1) + 1;
    int num_4 = random.nextInt(10 - 1) + 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        textView1 = findViewById(R.id.textView21);
        textView2 = findViewById(R.id.textView22);
        textView3 = findViewById(R.id.textView24);
        textView4 = findViewById(R.id.textView23);
        textView5 = findViewById(R.id.textView25);
        textView_info = findViewById(R.id.textView30);

        textView1.setText("1 )");
        textView2.setText(Integer.toString(num_1));
        textView3.setText(Integer.toString(num_2));
        textView4.setText("x  " + Integer.toString(num_3));
        textView5.setText(Integer.toString(num_4));
        textView_info.setText(Integer.toString(num_2) + " x " + Integer.toString(num_4) + " = ?");

        editText1 = findViewById(R.id.editTextNumber6);

        btn = findViewById(R.id.button8);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int real_value = num_2 * num_4;
                String your_value = editText1.getText().toString();
                if(TextUtils.isEmpty(your_value)) {
                    Toast.makeText(getApplicationContext(), "Cannot be empty !", Toast.LENGTH_SHORT).show();
                }
                else if(Integer.parseInt(your_value) == real_value) {
                    Intent intent = new Intent(getApplicationContext(), Step2.class);
                    intent.putExtra("num_1", Integer.toString(num_1));
                    intent.putExtra("num_2", Integer.toString(num_2));
                    intent.putExtra("num_3", Integer.toString(num_3));
                    intent.putExtra("num_4", Integer.toString(num_4));
                    intent.putExtra("unit_place",Integer.toString(num_2 * num_4));
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Wrong answer !", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}