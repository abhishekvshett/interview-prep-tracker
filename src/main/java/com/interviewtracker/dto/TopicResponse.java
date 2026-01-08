package com.interviewtracker.dto;

import com.interviewtracker.entity.TopicStatus;

public class TopicResponse {

    private Long id;
    private String name;
    private TopicStatus status;

    public TopicResponse(Long id, String name, TopicStatus status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public TopicStatus getStatus() {
        return status;
    }
}
