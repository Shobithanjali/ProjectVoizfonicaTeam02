package com.example.voiz_team02.data;

import com.example.voiz_team02.model.PrepaidPlans;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PrepaidRepository extends MongoRepository<PrepaidPlans, String> {
}
