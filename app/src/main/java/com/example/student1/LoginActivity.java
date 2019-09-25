package com.example.student1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.student1.MainActivity;
import com.example.student1.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText name;
    private EditText word;
    private Button btn1;
    private Button btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.et_username);
        word = findViewById(R.id.et_password);
        Button btn1 = findViewById(R.id.btn_login);
        Button btn2 = findViewById(R.id.btn_exit);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

        String username = readPrfs();
        if (username != null) {
            name.setText(username);
        }

    }


    @Override
    public void onClick(View v) {

        String username = name.getText().toString();
        String password = word.getText().toString();

        if ("qqq".equals(username) && "111".equals(password)) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(LoginActivity.this, "用户名或密码错误", Toast.LENGTH_LONG).show();
        }
    }

    private String readPrfs() {
        return null;
    }
}