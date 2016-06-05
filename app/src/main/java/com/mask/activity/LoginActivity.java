package com.mask.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mask.R;

import static com.mask.R.*;

public class LoginActivity extends AppCompatActivity {

    private Button userButton;
    private Button employeeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_login);

        userButton = (Button) findViewById(id.btnUserLogin);
        employeeButton = (Button) findViewById(id.btnEmployeeLogin);

        userButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(LoginActivity.this, UserLoginActivity.class);
                startActivity(loginIntent);
                finish();
            }
        });

        employeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(LoginActivity.this, EmployeeLoginActivity.class);
                startActivity(loginIntent);
                finish();
            }
        });

    }
}
