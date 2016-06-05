package com.mask.activity.moderator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;

import com.mask.R;

public class AssignComplaintActivity extends AppCompatActivity {

    Spinner spin ;
    Button assign;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign_complaint);
        spin = (Spinner)findViewById(R.id.spinner2);
        assign = (Button)findViewById(R.id.btnAssign);
    }
}
