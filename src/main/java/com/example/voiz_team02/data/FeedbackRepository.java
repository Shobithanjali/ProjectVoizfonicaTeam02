package com.example.voiz_team02.data;


import com.example.voiz_team02.model.Feedback;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FeedbackRepository extends MongoRepository<Feedback, String> {
}
