package com.mask.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.mask.HomeActivity;
import com.mask.R;
import com.mask.model.ComplaintModel;
import com.mask.model.EmployeeModel;
import com.mask.network.WebServices;
import com.mask.utils.Constants;
import com.mask.utils.Utilities;

import org.w3c.dom.Text;

public class ComplaintDetailActivity extends AppCompatActivity {

    private int complaintId;
    private TextView txtViewComplaint;
    private TextView txtViewStatus;
    private Button btnAssignedEmployee, btnChangeStatus, btnAssignEmployee;

    private ComplaintDetailTask mAuthTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_detail);

        complaintId = getIntent().getIntExtra("complaintId", -1);

        if (complaintId == -1)
            finish();

        txtViewComplaint = (TextView) findViewById(R.id.txtviewComplainDetails);
        txtViewStatus = (TextView)findViewById(R.id.txtviewStatus);
        btnAssignedEmployee = (Button) findViewById(R.id.btnEmpAssigned);
        btnAssignEmployee = (Button) findViewById(R.id.btnAssign);
        btnChangeStatus = (Button) findViewById(R.id.btnChangeStatus);

        int type = Utilities.getUserType();

        switch (type) {
            case Constants.USER:
                btnAssignEmployee.setVisibility(TextView.GONE);
                break;
            case Constants.EMPLOYEE:
                btnAssignEmployee.setVisibility(View.GONE);
                btnAssignedEmployee.setVisibility(View.GONE);
                break;
            case Constants.MODERATOR:
                btnChangeStatus.setVisibility(View.GONE);
                break;
        }

        mAuthTask = new ComplaintDetailTask();
        mAuthTask.execute();
    }


    public class ComplaintDetailTask extends AsyncTask<Void, Void, ComplaintModel> {

        private ProgressDialog pd;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd = new ProgressDialog(ComplaintDetailActivity.this);
            pd.setTitle("Please Wait...");
            pd.show();
        }

        @Override
        protected ComplaintModel doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.

            WebServices webServices = new WebServices(ComplaintDetailActivity.this);

            ComplaintModel success = webServices.getComplaintDetails(complaintId);

            // TODO: register the new account here.
            return success;
        }

        @Override
        protected void onPostExecute(final ComplaintModel userModel) {
            mAuthTask = null;

            if (userModel != null) {
                if (userModel.getComplaintStatus() == Constants.NEW ) {
                    btnAssignedEmployee.setVisibility(View.GONE);
                }
                txtViewStatus.setText(Utilities.getStatusString(userModel.getComplaintStatus()));
                txtViewComplaint.setText(userModel.getComplaintDetails());
            } else {
                Toast.makeText(ComplaintDetailActivity.this, "Something went wrong", Toast.LENGTH_LONG).show();
            }
        }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
            pd.dismiss();
        }
    }
}
