package com.example.midterm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.midterm.MainActivity2;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etEmail;
    private RadioGroup rgGender;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        rgGender = findViewById(R.id.rgGender);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                int selectedGenderId = rgGender.getCheckedRadioButtonId();

                if (name.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter your name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (email.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter your email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (selectedGenderId == -1) {
                    Toast.makeText(MainActivity.this, "Please select a gender", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton selectedRadioButton = findViewById(selectedGenderId);
                String gender = selectedRadioButton.getText().toString();

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("USER_NAMsE", name);
                intent.putExtra("USER_EMAIL", email);
                intent.putExtra("USER_GENDER", gender);
                startActivity(intent);
            }
        });
    }
}