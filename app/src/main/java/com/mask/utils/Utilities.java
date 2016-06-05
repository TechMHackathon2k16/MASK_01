package com.mask.utils;

import com.mask.model.EmployeeModel;
import com.mask.model.UserModel;

/**
 * Created by mukeshyadav on 05/06/16.
 */
public class Utilities {

    public static boolean isRegistered() {
        return true;
    }

    public static  int getUserType(){
        return 0;
    }

    public static void saveUserInfo(UserModel userModel) {

    }

    public static void saveEmployeeInfo(EmployeeModel userModel) {

    }

    public static String getStatusString(int status) {
        switch(status) {
            case Constants.NEW:
                return "New";
            case Constants.AASIGNED:
                return "Assigned";
            case Constants.RESOLVING:
                return "Resolving";
            case Constants.RESOLVED:
                return "Resolved";
            case Constants.COMPLETED:
                return "Completed";
        }
        return null;
    }
}
