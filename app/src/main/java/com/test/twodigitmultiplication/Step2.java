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

public class Step2 extends AppCompatActivity {

    TextView textView, textView1, textView2, textView3, textView4, textView_info;
    EditText editText1, editText2;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step2);

        String num_1 = getIntent().getStringExtra("num_1");
        String num_2 = getIntent().getStringExtra("num_2");
        String num_3 = getIntent().getStringExtra("num_3");
        String num_4 = getIntent().getStringExtra("num_4");
        String unit_place = getIntent().getStringExtra("unit_place");

        textView = findViewById(R.id.textView35);
        textView1 = findViewById(R.id.textView36);
        textView2 = findViewById(R.id.textView37);
        textView3 = findViewById(R.id.textView38);
        textView4 = findViewById(R.id.textView39);
        textView_info = findViewById(R.id.textView40);

        textView.setText("1 )");
        textView1.setText(num_1);
        textView2.setText(num_2);
        textView3.setText("x  " + num_3);
        textView4.setText(num_4);
        textView_info.setText(num_1 + " x " + num_4 + "\n   +\n" + num_2 + " x " + num_3 + " = ?");

        editText1 = findViewById(R.id.editTextNumber9);
        editText1.setText(unit_place);

        editText2 = findViewById(R.id.editTextNumber8);

        btn = findViewById(R.id.button11);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int real_value = Integer.parseInt(num_1) * Integer.parseInt(num_4) + Integer.parseInt(num_2) * Integer.parseInt(num_3);
                String your_value = editText2.getText().toString();

                if(TextUtils.isEmpty(your_value)) {
                    Toast.makeText(getApplicationContext(), "Cannot be empty !", Toast.LENGTH_SHORT).show();
                }
                else if(real_value == Integer.parseInt(your_value)) {
                    Intent intent = new Intent(getApplicationContext(), Step3.class);
                    intent.putExtra("num_1", num_1);
                    intent.putExtra("num_2", num_2);
                    intent.putExtra("num_3", num_3);
                    intent.putExtra("num_4", num_4);
                    intent.putExtra("units_place", unit_place);
                    intent.putExtra("tens_place", editText2.getText().toString());
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Wrong Answer !", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}