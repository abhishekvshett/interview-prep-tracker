package com.interviewtracker.dto;

import com.interviewtracker.entity.ApplicationStatus;

public class ApplicationRequest {

    private String companyName;
    private String role;
    private ApplicationStatus status;

    public String getCompanyName() {
        return companyName;
    }

    public String getRole() {
        return role;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }
}
