package com.mask.network;

import android.content.Context;

import com.mask.model.ComplaintModel;
import com.mask.model.EmployeeModel;
import com.mask.model.UserModel;

import java.util.List;

/**
 * Created by mukeshyadav on 05/06/16.
 */
public class WebServices {
    WebServiceManager webServiceManager;

    public WebServices(Context context){
        webServiceManager = new WebServiceManager(context);
    }

    public UserModel loginUser(String aadhaar, String name) {
        return null;
    }

    public EmployeeModel loginEmployee(String empId, String name) {
        return null;
    }

    public boolean submitComplaint(String complaint, int department, String userId, String address) {
        return true;
    }

    public boolean updateContact(String userId, String contact) {
        return true;
    }

    public List<ComplaintModel> userComplaint(String userId, int type){
        return null;
    }

    public boolean statusUpdate(int complaintId, int status) {
        return true;
    }

    public EmployeeModel getEmployeeDetails(int employeeId) {
        return null;
    }

    public List<ComplaintModel> moderatorComplaints(int employeeId, int type) {
        return null;
    }

    public ComplaintModel getComplaintDetails(int complaintId){
        return null;
    }

    public boolean assignEmployee(int complaintId, int employeeId, String date) {
        return true;
    }

    public List<ComplaintModel> employeeComplaints(int employeeId, int type) {
        return null;
    }

}
