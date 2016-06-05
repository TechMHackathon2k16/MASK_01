package com.mask.model;

import java.util.Date;

/**
 * Created by mukeshyadav on 05/06/16.
 */
public class ComplaintModel {

    int complaintId;
    int userId;
    String complaintDetails;
    int deptID;
    int complaintStatus;
    int readByUser;
    int readByModartor;
    int readByEmployee;

    public int getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(int complaintId) {
        this.complaintId = complaintId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getComplaintDetails() {
        return complaintDetails;
    }

    public void setComplaintDetails(String complaintDetails) {
        this.complaintDetails = complaintDetails;
    }

    public int getDeptID() {
        return deptID;
    }

    public void setDeptID(int deptID) {
        this.deptID = deptID;
    }

    public int getComplaintStatus() {
        return complaintStatus;
    }

    public void setComplaintStatus(int complaintStatus) {
        this.complaintStatus = complaintStatus;
    }

    public int getReadByUser() {
        return readByUser;
    }

    public void setReadByUser(int readByUser) {
        this.readByUser = readByUser;
    }

    public int getReadByModartor() {
        return readByModartor;
    }

    public void setReadByModartor(int readByModartor) {
        this.readByModartor = readByModartor;
    }

    public int getReadByEmployee() {
        return readByEmployee;
    }

    public void setReadByEmployee(int readByEmployee) {
        this.readByEmployee = readByEmployee;
    }

    public Date getComplaintDate() {
        return complaintDate;
    }

    public void setComplaintDate(Date complaintDate) {
        this.complaintDate = complaintDate;
    }

    public Date getComplaintEstDate() {
        return complaintEstDate;
    }

    public void setComplaintEstDate(Date complaintEstDate) {
        this.complaintEstDate = complaintEstDate;
    }

    public Date getComplaintResDate() {
        return complaintResDate;
    }

    public void setComplaintResDate(Date complaintResDate) {
        this.complaintResDate = complaintResDate;
    }

    public String getComplaintAddress() {
        return complaintAddress;
    }

    public void setComplaintAddress(String complaintAddress) {
        this.complaintAddress = complaintAddress;
    }

    public int getAssignEmpId() {
        return assignEmpId;
    }

    public void setAssignEmpId(int assignEmpId) {
        this.assignEmpId = assignEmpId;
    }

    Date complaintDate;
    Date complaintEstDate;
    Date complaintResDate;
    String complaintAddress;
    int assignEmpId;

}
