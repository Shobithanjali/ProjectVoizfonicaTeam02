package com.example.voiz_team02.data;


import com.example.voiz_team02.model.Complaints;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ComplaintsRepository extends MongoRepository<Complaints,String>{

}
