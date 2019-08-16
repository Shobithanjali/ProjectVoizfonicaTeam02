package com.example.voiz_team02.data;


import com.example.voiz_team02.model.regstration;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface Regstrationrepo extends MongoRepository<regstration,String> {

}
