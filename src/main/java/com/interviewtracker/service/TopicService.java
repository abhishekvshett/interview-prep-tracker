package com.interviewtracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.interviewtracker.dto.TopicRequest;
import com.interviewtracker.entity.Topic;
import com.interviewtracker.entity.TopicStatus;
import com.interviewtracker.entity.User;
import com.interviewtracker.exception.UserNotFoundException;
import com.interviewtracker.repository.TopicRepository;
import com.interviewtracker.repository.UserRepository;

@Service
public class TopicService {

    private final TopicRepository topicRepository;
    private final UserRepository userRepository;

    public TopicService(TopicRepository topicRepository,
                        UserRepository userRepository) {
        this.topicRepository = topicRepository;
        this.userRepository = userRepository;
    }

    public Topic addTopic(Long userId, TopicRequest request) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));


        TopicStatus status = request.getStatus() != null
                ? request.getStatus()
                : TopicStatus.NOT_STARTED;

        Topic topic = new Topic(
                request.getName(),
                status,
                user
        );

        return topicRepository.save(topic);
    }

    public List<Topic> getTopicsForUser(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        return topicRepository.findByUser(user);
    }
}