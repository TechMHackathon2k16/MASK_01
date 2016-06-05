package com.mask.utils;

/**
 * Created by mukeshyadav on 05/06/16.
 */
public class Constants {

    /*Web Service Url */
    public static final String BASE_URL = "localhost/ComplaintResolutionSystem/complaint_resolution_system/";

    /* User Types */

    public static final int USER = 0;
    public static final int MODERATOR = 1;
    public static final int EMPLOYEE = 2;

    /* Status Code */

    public static final int NEW = 001;
    public static final int AASIGNED = 101;
    public static final int RESOLVING = 201;
    public static final int RESOLVED = 301;
    public static final int COMPLETED = 401;

    /* Complaint type */

    public static final int COMPLAINT_USER_PENDING = 0;
    public static final int COMPLAINT_USER_APPROVED = 1;

    public static final int COMPLAINT_EMP_NEW = 0;
    public static final int COMPLAINT_EMP_RESOLVING = 1;
    public static final int COMPLAINT_EMP_RESOLVED =2;

    public static final int COMPLAINT_MOD_NEW = 0;
    public static final int COMPLAINT_MOD_ASSIGNED = 1;
    public static final int COMPLAINT_MOD_COMPLETED = 2;

    /* WebService Key */

    public static final String KSUCCESS = "success";
    public static final String KUSER_ID = "user_id";
    public static final String KUSER_TYPE = "user_type";
    public static final String KCOMPLAINT = "complaint";
    public static final String KDEPARTMENT = "dept_id";
    public static final String KADDRESS = "address";
    public static final String KCONTACT = "contact";
    public static final String KCOMPLAINT_TYPE = "complaint_type";
    public static final String KCOMPLAINT_ID = "complaint_id";
    public static final String KSTATUS = "status";
    public static final String KDATE = "date";

    // Extra for WebService Result

    public static final String RUSER = "user";
    public static final String RSUCCESS = "success";

    public static final String RCOMPLAINTID = "complaint_id"";
    public static final String RUSERID = "user_id";
    public static final String RCOMPLAINTDETAILS = "complaint_details";
    public static final String RDEPTTID = "dept_id";
    public static final String RCOMPLAINTSTATUS = "complaint_status":
    public static final String RREADBYUSER = "readby_user";
    public static final String RREADBYMODERATOR = "readby_moderator";
    public static final String RREADBYEMP = "readby_emp";
    public static final String RCOMAPLINTDATE = "complaint_date";
    public static final String RCOMPLAINTESTDATE = "complaint_est_date";
    public static final String RCOMAPLINTRESDATE = "complaint_res_date";
    public static final String RCOMPLAINTADD = "complaint_add";
    public static final String RASSIGNEMPID = "assign_emp_id";

    public static final String REMPID = "emp_id";
    public static final String RDEPTID = "dept_id";
    public static final String REMPNAME = "emp_name";
    public static final String REMPCONTACT = "emp_contact";

    public static final String RUSERID = "user_id";
    public static final String RUSERNAME = "user_name";
    public static final String RUSERCONTACT = "user_contact";
    public static final String RUSERADDRESS = "user_add";





}
