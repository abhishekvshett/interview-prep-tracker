package com.interviewtracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.interviewtracker.entity.Topic;
import com.interviewtracker.entity.User;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

    List<Topic> findByUser(User user);
}

