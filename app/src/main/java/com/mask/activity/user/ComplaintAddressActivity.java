package com.mask.activity.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.mask.R;

public class ComplaintAddressActivity extends AppCompatActivity {

    EditText address, HNo, street, landmark;
    Button submit ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_address);
        address = (EditText)findViewById(R.id.editTextAddress);
        HNo = (EditText)findViewById(R.id.editTextHNO);
        street = (EditText)findViewById(R.id.editTextStreet);
        landmark = (EditText)findViewById(R.id.editTextLandMark);
        submit = (Button) findViewById(R.id.buttonsbm);

    }
}
