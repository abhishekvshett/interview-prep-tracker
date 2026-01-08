package com.interviewtracker.dto;

import com.interviewtracker.entity.TopicStatus;

public class TopicRequest {

    private String name;
    private TopicStatus status;

    public String getName() {
        return name;
    }

    public TopicStatus getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(TopicStatus status) {
        this.status = status;
    }
}
