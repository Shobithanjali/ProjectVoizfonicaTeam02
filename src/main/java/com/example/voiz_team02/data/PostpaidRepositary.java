package com.example.voiz_team02.data;

import com.example.voiz_team02.model.Postpaidplan;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostpaidRepositary  extends MongoRepository<Postpaidplan,String>{
}
