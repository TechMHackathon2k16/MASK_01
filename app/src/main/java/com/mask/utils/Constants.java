package com.mask.utils;

/**
 * Created by mukeshyadav on 05/06/16.
 */
public class Constants {

    /*Web Service Url */
    public static final String BASE_URL = "localhost/ComplaintResolutionSystem/complaint_resolution_system/";

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

    public static final String KUSER = "user";
    public static final String KNAME = "name";

}
