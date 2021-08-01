package com.test.twodigitmultiplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Step4 extends AppCompatActivity {

    TextView textView1, textView2, textView3, textView4, textView5;
    EditText editText1, editText2, editText3, editText4;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step4);

        String num_1 = getIntent().getStringExtra("num_1");
        String num_2 = getIntent().getStringExtra("num_2");
        String num_3 = getIntent().getStringExtra("num_3");
        String num_4 = getIntent().getStringExtra("num_4");
        String units_place = getIntent().getStringExtra("units_place");
        String tens_place = getIntent().getStringExtra("tens_place");
        String hundreds_place = getIntent().getStringExtra("hundreds_place");

        textView1 = findViewById(R.id.textView49);
        textView2 = findViewById(R.id.textView50);
        textView3 = findViewById(R.id.textView51);
        textView4 = findViewById(R.id.textView53);
        textView5 = findViewById(R.id.textView52);

        editText1 = findViewById(R.id.editTextNumber13);
        editText2 = findViewById(R.id.editTextNumber14);
        editText3 = findViewById(R.id.editTextNumber15);

        textView1.setText("1 )");
        textView2.setText(num_1);
        textView3.setText(num_2);
        textView4.setText("x  " + num_3);
        textView5.setText(num_4);

        editText1.setText(hundreds_place);
        editText2.setText(tens_place);
        editText3.setText(units_place);

        editText4 = findViewById(R.id.editTextNumber16);

        btn = findViewById(R.id.button13);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String your_value = editText4.getText().toString();
                String num_one = num_1 + num_2;
                String num_two = num_3 + num_4;
                int real_value = Integer.parseInt(num_one) * Integer.parseInt(num_two);

                if(TextUtils.isEmpty(your_value)){
                    Toast.makeText(getApplicationContext(), "Cannot be empty !", Toast.LENGTH_SHORT).show();
                }
                else if (real_value == Integer.parseInt(your_value)){
                    Toast.makeText(getApplicationContext(), "Success !", Toast.LENGTH_SHORT).show();

                    int color = Color.argb(255, 76, 175, 80);
                    btn.setBackgroundColor(color);
                    btn.setText("Solve Another");

                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getApplicationContext(), Tutorial.class);
                            startActivity(intent);
                        }
                    });
                }
                else{
                    Toast.makeText(getApplicationContext(), "Wrong Answer !", Toast.LENGTH_SHORT).show();
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