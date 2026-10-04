package com.example.midterm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private TextView tvName, tvEmail, tvGender;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvName = findViewById(R.id.tvName);
        tvEmail = findViewById(R.id.tvEmail);
        tvGender = findViewById(R.id.tvGender);
        btnBack = findViewById(R.id.btnBack);

        Intent intent = getIntent();
        if (intent != null) {
            String name = intent.getStringExtra("USER_NAMsE");
            String email = intent.getStringExtra("USER_EMAIL");
            String gender = intent.getStringExtra("USER_GENDER");

            tvName.setText(": " + (name != null ? name : "N/A"));
            tvEmail.setText(": " + (email != null ? email : "N/A"));
            tvGender.setText(": " + (gender != null ? gender : "N/A"));
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}