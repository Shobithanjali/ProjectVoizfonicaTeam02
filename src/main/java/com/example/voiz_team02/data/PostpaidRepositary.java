package com.example.voiz_team02.data;

import com.example.voiz_team02.model.PostpaidPlan;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostpaidRepositary  extends MongoRepository<PostpaidPlan,String>{
    List<PostpaidPlan> findAllById(String Id);
}
