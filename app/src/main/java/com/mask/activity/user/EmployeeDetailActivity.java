package com.mask.activity.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.mask.R;

public class EmployeeDetailActivity extends AppCompatActivity {

    TextView name, contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_detail);
        name = (TextView)findViewById(R.id.txtviewempName);
        contact = (TextView)findViewById(R.id.txtviewempContact);

    }
}
