package com.example.voiz_team02.data;


import com.example.voiz_team02.model.regstration;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Regstrationrepo extends MongoRepository<regstration,String> {
}
