package com.interviewtracker.dto;

import com.interviewtracker.entity.ApplicationStatus;

public class ApplicationResponse {

    private Long id;
    private String companyName;
    private String role;
    private ApplicationStatus status;

    public ApplicationResponse(Long id, String companyName, String role, ApplicationStatus status) {
        this.id = id;
        this.companyName = companyName;
        this.role = role;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getRole() {
        return role;
    }

    public ApplicationStatus getStatus() {
        return status;
    }
}
