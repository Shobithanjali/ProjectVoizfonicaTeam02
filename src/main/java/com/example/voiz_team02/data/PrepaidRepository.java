package com.example.voiz_team02.data;

import com.example.voiz_team02.model.PrepaidPlans;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PrepaidRepository extends MongoRepository<PrepaidPlans, String> {
    List<PrepaidPlans> findAllById(String id);
}
