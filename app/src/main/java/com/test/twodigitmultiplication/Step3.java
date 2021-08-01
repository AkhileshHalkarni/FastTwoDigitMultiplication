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

public class Step3 extends AppCompatActivity {

    TextView textView1, textView2, textView3, textView4, textView5, textView6;
    EditText editText1, editText2, editText3;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step3);

        String num_1 = getIntent().getStringExtra("num_1");
        String num_2 = getIntent().getStringExtra("num_2");
        String num_3 = getIntent().getStringExtra("num_3");
        String num_4 = getIntent().getStringExtra("num_4");
        String units_place = getIntent().getStringExtra("units_place");
        String tens_place = getIntent().getStringExtra("tens_place");

        textView1 = findViewById(R.id.textView42);
        textView2 = findViewById(R.id.textView43);
        textView3 = findViewById(R.id.textView44);
        textView4 = findViewById(R.id.textView46);
        textView5 = findViewById(R.id.textView45);
        textView6 = findViewById(R.id.textView47);

        editText1 = findViewById(R.id.editTextNumber10);
        editText2 = findViewById(R.id.editTextNumber11);
        editText3 = findViewById(R.id.editTextNumber12);

        textView1.setText("1 )");
        textView2.setText(num_1);
        textView3.setText(num_2);
        textView4.setText("x  " + num_3);
        textView5.setText(num_4);

        textView6.setText(Integer.parseInt(num_1) + " x " + Integer.parseInt(num_3) + " = ?");

        editText2.setText(tens_place);
        editText3.setText(units_place);

        btn = findViewById(R.id.button12);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hundreds_place = editText1.getText().toString();
                int real_value = Integer.parseInt(num_1) * Integer.parseInt(num_3);

                if(TextUtils.isEmpty(hundreds_place)){
                    Toast.makeText(getApplicationContext(), "Cannot be empty !", Toast.LENGTH_SHORT).show();
                }
                else if (real_value == Integer.parseInt(hundreds_place)){
                    Intent intent = new Intent(getApplicationContext(), Step4.class);
                    intent.putExtra("num_1", num_1);
                    intent.putExtra("num_2", num_2);
                    intent.putExtra("num_3", num_3);
                    intent.putExtra("num_4", num_4);
                    intent.putExtra("units_place", units_place);
                    intent.putExtra("tens_place", tens_place);
                    intent.putExtra("hundreds_place", hundreds_place);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Wrong Answer !", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}