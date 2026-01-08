package com.interviewtracker.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interviewtracker.dto.ApplicationRequest;
import com.interviewtracker.dto.ApplicationResponse;
import com.interviewtracker.entity.Application;
import com.interviewtracker.service.ApplicationService;

@RestController
@RequestMapping("/api/users/{userId}/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping
public ResponseEntity<ApplicationResponse> addApplication(
        @PathVariable Long userId,
        @RequestBody ApplicationRequest request) {

    Application application = applicationService.addApplication(userId, request);

    ApplicationResponse response = new ApplicationResponse(
            application.getId(),
            application.getCompanyName(),
            application.getRole(),
            application.getStatus()
    );

    return ResponseEntity.ok(response);
}

@GetMapping
public ResponseEntity<List<ApplicationResponse>> getApplications(
        @PathVariable Long userId) {

    List<ApplicationResponse> responses =
            applicationService.getApplicationsForUser(userId)
                    .stream()
                    .map(app -> new ApplicationResponse(
                            app.getId(),
                            app.getCompanyName(),
                            app.getRole(),
                            app.getStatus()))
                    .toList();

    return ResponseEntity.ok(responses);
}

}

