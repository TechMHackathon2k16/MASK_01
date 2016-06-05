package com.mask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mask.activity.LoginActivity;
import com.mask.utils.Utilities;

public class DecisionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decision);
        decide();
    }

    private void decide() {
        if(Utilities.isRegistered()){
            Intent homeIntent = new Intent(this, HomeActivity.class);
            startActivity(homeIntent);
            finish();
        } else {
            Intent loginIntent = new Intent(this, LoginActivity.class);
            startActivity(loginIntent);
            finish();
        }
    }

}
