package com.interviewtracker.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interviewtracker.dto.TopicRequest;
import com.interviewtracker.dto.TopicResponse;
import com.interviewtracker.entity.Topic;
import com.interviewtracker.service.TopicService;

@RestController
@RequestMapping("/api/users/{userId}/topics")
public class TopicController {

    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @PostMapping
public ResponseEntity<TopicResponse> addTopic(
        @PathVariable Long userId,
        @RequestBody TopicRequest request) {

    Topic topic = topicService.addTopic(userId, request);

    TopicResponse response = new TopicResponse(
            topic.getId(),
            topic.getName(),
            topic.getStatus()
    );

    return ResponseEntity.ok(response);
}

@GetMapping
public ResponseEntity<List<TopicResponse>> getTopics(
        @PathVariable Long userId) {

    List<TopicResponse> responses =
            topicService.getTopicsForUser(userId)
                    .stream()
                    .map(topic -> new TopicResponse(
                            topic.getId(),
                            topic.getName(),
                            topic.getStatus()))
                    .toList();

    return ResponseEntity.ok(responses);
}

}

