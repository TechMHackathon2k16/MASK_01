package com.mask.model;

/**
 * Created by mukeshyadav on 05/06/16.
 */
public class EmployeeModel {

    int empID;
    int deptId;
    String empName;
    long empContact;

    public long getEmpContact() {
        return empContact;
    }

    public void setEmpContact(long empContact) {
        this.empContact = empContact;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }


}
