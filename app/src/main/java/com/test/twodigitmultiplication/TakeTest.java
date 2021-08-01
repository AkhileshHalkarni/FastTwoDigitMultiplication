package com.test.twodigitmultiplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TakeTest extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_test);

        button = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                function();
            }
        });

    }
    public void function(){
        TextView textView = findViewById(R.id.editTextNumber);
        String value = textView.getText().toString();
        if(TextUtils.isEmpty(value))
            Toast.makeText(getApplicationContext(), "Number field cannot be empty !", Toast.LENGTH_SHORT).show();
        else {
            int n = Integer.parseInt(value);
            if(n > 25){
                Toast.makeText(getApplicationContext(), "That's way too many problems for one sitting !", Toast.LENGTH_SHORT).show();
            }
            else{
                Intent intent = new Intent(this, Start.class);
                intent.putExtra("value", value);
                startActivity(intent);
            }
        }

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, Types.class);
        startActivity(intent);
    }
}