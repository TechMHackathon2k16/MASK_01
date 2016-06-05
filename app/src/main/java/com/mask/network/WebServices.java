package com.mask.network;

import android.content.Context;

import com.mask.model.ComplaintModel;
import com.mask.model.EmployeeModel;
import com.mask.model.UserModel;
import com.mask.utils.Constants;
import com.mask.utils.JSONParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
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

        String params=null;
        try {
            params = Constants.KUSER_ID+"="+ URLEncoder.encode(String.valueOf(aadhaar),"UTF-8")+
                    "&"+Constants.KUSER_TYPE+"="+ URLEncoder.encode("0","UTF-8")+"&";
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        JSONObject json = webServiceManager.sendHttpRequest(Constants.BASE_URL, params);
        return JSONParser.getUserModel(json);
    }

    public EmployeeModel loginEmployee(String empId, String name) {
        String params=null;
        try {
            params = Constants.KUSER_ID+"="+ URLEncoder.encode(String.valueOf(empId),"UTF-8")+
                    "&"+Constants.KUSER_TYPE+"="+ URLEncoder.encode("1","UTF-8")+"&";
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        JSONObject json = webServiceManager.sendHttpRequest(Constants.BASE_URL, params);
        return JSONParser.getEmployeeModel(json);
    }

    public boolean submitComplaint(String complaint, int department, String userId, String address) {
        String params=null;
        try {
            params = Constants.KCOMPLAINT+"="+ URLEncoder.encode(complaint,"UTF-8")+
                    "&"+Constants.KDEPARTMENT+"="+ URLEncoder.encode(String.valueOf(department),"UTF-8")+
                    "&"+Constants.KUSER_ID+"="+ URLEncoder.encode(String.valueOf(userId),"UTF-8")+
                    "&"+Constants.KADDRESS+"="+ URLEncoder.encode(address,"UTF-8")+"&";
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        JSONObject json = webServiceManager.sendHttpRequest(Constants.BASE_URL, params);
        int success = 0;
        try {
            success = json.getInt("success");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (success == 1) {
            return true;
        }
        return false;
    }

    public boolean updateContact(String userId, String contact) {
        String params=null;
        try {
            params = Constants.KUSER_ID+"="+ URLEncoder.encode(userId,"UTF-8")+
                    "&"+Constants.KCONTACT+"="+ URLEncoder.encode(contact,"UTF-8")+"&";
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        JSONObject json = webServiceManager.sendHttpRequest(Constants.BASE_URL, params);
        int success = 0;
        try {
            success = json.getInt("success");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (success == 1) {
            return true;
        }
        return false;
    }

    public List<ComplaintModel> userComplaint(String userId, int type){
        String params=null;
        try {
            params = Constants.KUSER_ID+"="+ URLEncoder.encode(userId,"UTF-8")+
                    "&"+Constants.KCOMPLAINT_TYPE+"="+ URLEncoder.encode(String.valueOf(type),"UTF-8")+"&";
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        JSONObject json = webServiceManager.sendHttpRequest(Constants.BASE_URL, params);
        int success = 0;
        try {
            success = json.getInt("success");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (success == 1) {
            List<ComplaintModel> complaintsList = new ArrayList<>();
            JSONArray complaints;
            try {
                complaints = json.getJSONArray("complaints");
                for (int i=0; i< complaints.length(); i++) {
                    JSONObject complaintJSON = complaints.getJSONObject(i);
                    complaintsList.add(JSONParser.getComplaintModel(complaintJSON));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return complaintsList;
        }
        return null;
    }

    public boolean statusUpdate(int complaintId, int status) {
        String params=null;
        try {
            params = Constants.KCOMPLAINT_ID+"="+ URLEncoder.encode(String.valueOf(complaintId),"UTF-8")+
                    "&"+Constants.KSTATUS+"="+ URLEncoder.encode(String.valueOf(status),"UTF-8")+"&";
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        JSONObject json = webServiceManager.sendHttpRequest(Constants.BASE_URL, params);
        int success = 0;
        try {
            success = json.getInt("success");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (success == 1) {
            return true;
        }
        return false;
    }

    public EmployeeModel getEmployeeDetails(int employeeId) {
        String params=null;
        try {
            params = Constants.KUSER_ID+"="+ URLEncoder.encode(String.valueOf(employeeId),"UTF-8")+"&";
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        JSONObject json = webServiceManager.sendHttpRequest(Constants.BASE_URL, params);
        int success = 0;
        try {
            success = json.getInt("success");
            if (success == 1) {
                return JSONParser.getEmployeeModel(json);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ComplaintModel> moderatorComplaints(int employeeId, int type) {
        String params=null;
        try {
            params = Constants.KUSER_ID+"="+ URLEncoder.encode(String.valueOf(employeeId),"UTF-8")+
                    "&"+Constants.KCOMPLAINT_TYPE+"="+ URLEncoder.encode(String.valueOf(type),"UTF-8")+"&";
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        JSONObject json = webServiceManager.sendHttpRequest(Constants.BASE_URL, params);
        int success = 0;
        try {
            success = json.getInt("success");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (success == 1) {
            List<ComplaintModel> complaintsList = new ArrayList<>();
            JSONArray complaints;
            try {
                complaints = json.getJSONArray("complaints");
                for (int i=0; i< complaints.length(); i++) {
                    JSONObject complaintJSON = complaints.getJSONObject(i);
                    complaintsList.add(JSONParser.getComplaintModel(complaintJSON));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return complaintsList;
        }
        return null;
    }

    public ComplaintModel getComplaintDetails(int complaintId){
        String params=null;
        try {
            params = Constants.KUSER_ID+"="+ URLEncoder.encode(String.valueOf(complaintId),"UTF-8")+"&";
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        JSONObject json = webServiceManager.sendHttpRequest(Constants.BASE_URL, params);
        int success = 0;
        try {
            success = json.getInt("success");
            if (success == 1) {
                return JSONParser.getComplaintModel(json);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean assignEmployee(int complaintId, int employeeId, String date) {
        String params=null;
        try {
            params = Constants.KCOMPLAINT_ID+"="+ URLEncoder.encode(String.valueOf(complaintId),"UTF-8")+
                    "&"+Constants.KUSER_ID+"="+ URLEncoder.encode(String.valueOf(employeeId),"UTF-8")+
                    "&"+Constants.KDATE+"="+ URLEncoder.encode(date,"UTF-8")+"&";
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        JSONObject json = webServiceManager.sendHttpRequest(Constants.BASE_URL, params);
        int success = 0;
        try {
            success = json.getInt("success");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (success == 1) {
            return true;
        }
        return false;
    }

    public List<ComplaintModel> employeeComplaints(int employeeId, int type) {
        String params=null;
        try {
            params = Constants.KUSER_ID+"="+ URLEncoder.encode(String.valueOf(employeeId),"UTF-8")+
                    "&"+Constants.KCOMPLAINT_TYPE+"="+ URLEncoder.encode(String.valueOf(type),"UTF-8")+"&";
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        JSONObject json = webServiceManager.sendHttpRequest(Constants.BASE_URL, params);
        int success = 0;
        try {
            success = json.getInt("success");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (success == 1) {
            List<ComplaintModel> complaintsList = new ArrayList<>();
            JSONArray complaints;
            try {
                complaints = json.getJSONArray("complaints");
                for (int i=0; i< complaints.length(); i++) {
                    JSONObject complaintJSON = complaints.getJSONObject(i);
                    complaintsList.add(JSONParser.getComplaintModel(complaintJSON));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return complaintsList;
        }
        return null;
    }

}
