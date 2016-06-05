package com.mask.activity;

import android.app.ProgressDialog;
import android.database.DataSetObserver;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.mask.R;
import com.mask.model.ComplaintModel;
import com.mask.network.WebServices;
import com.mask.utils.Constants;
import com.mask.utils.Utilities;

import java.util.ArrayList;
import java.util.List;

public class UpdateStatusActivity extends AppCompatActivity {

    private Spinner statusSpinner;
    private TextView complaintData;
    private Button btnChangeStatus;
    private int complaintId;
    private String selectedStatus;

    private UpdateStatusTask mAuthTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_status);

        String complaint = getIntent().getStringExtra("complaint");
        complaintId = getIntent().getIntExtra("comid", 0);

        statusSpinner = (Spinner) findViewById(R.id.spinner);
        complaintData = (TextView) findViewById(R.id.textViewComplaint);
        btnChangeStatus = (Button) findViewById(R.id.btnChangeStatus);

        int type = Utilities.getUserType();
        List<String> data = new ArrayList<>();
        switch (type) {
            case Constants.USER:
                data.add("Completed");
                break;
            case Constants.EMPLOYEE:
                data.add("Resolving");
                data.add("Resolved");
                break;
        }

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        statusSpinner.setAdapter(dataAdapter);

        if (type == Constants.MODERATOR) {
            statusSpinner.setVisibility(View.GONE);
            btnChangeStatus.setVisibility(View.GONE);
        }

        complaintData.setText(complaint);

        btnChangeStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedStatus = (String)statusSpinner.getSelectedItem();
                mAuthTask = new UpdateStatusTask();
                mAuthTask.execute();
            }
        });

    }

    public class UpdateStatusTask extends AsyncTask<Void, Void, Boolean> {

        private ProgressDialog pd;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd = new ProgressDialog(UpdateStatusActivity.this);
            pd.setTitle("Please Wait...");
            pd.show();
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.

            WebServices webServices = new WebServices(UpdateStatusActivity.this);

            int statusId = 0;

            if ("Completed".equals(selectedStatus)) {
                statusId = 401;
            } else if ("Resolving".equals(selectedStatus)) {
                statusId = 201;
            } else if ("Resolved".equals(selectedStatus)) {
                statusId = 301;
            }

            boolean success = webServices.statusUpdate(complaintId, statusId);

            // TODO: register the new account here.
            return success;
        }

        @Override
        protected void onPostExecute(final Boolean userModel) {
            mAuthTask = null;

            if (userModel) {
                Toast.makeText(UpdateStatusActivity.this, "Updated Successfully...", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(UpdateStatusActivity.this, "Something went wrong", Toast.LENGTH_LONG).show();
            }
        }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
            pd.dismiss();
        }
    }

}
