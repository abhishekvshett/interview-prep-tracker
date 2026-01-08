
package com.interviewtracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.interviewtracker.dto.ApplicationRequest;
import com.interviewtracker.entity.Application;
import com.interviewtracker.entity.ApplicationStatus;
import com.interviewtracker.entity.User;
import com.interviewtracker.exception.UserNotFoundException;
import com.interviewtracker.repository.ApplicationRepository;
import com.interviewtracker.repository.UserRepository;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final UserRepository userRepository;

    public ApplicationService(ApplicationRepository applicationRepository,
                              UserRepository userRepository) {
        this.applicationRepository = applicationRepository;
        this.userRepository = userRepository;
    }

    public Application addApplication(Long userId, ApplicationRequest request) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        ApplicationStatus status = request.getStatus() != null
                ? request.getStatus()
                : ApplicationStatus.APPLIED;

        Application application = new Application(
                request.getCompanyName(),
                request.getRole(),
                status,
                user
        );

        return applicationRepository.save(application);
    }

    public List<Application> getApplicationsForUser(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));


        return applicationRepository.findByUser(user);
    }
}
