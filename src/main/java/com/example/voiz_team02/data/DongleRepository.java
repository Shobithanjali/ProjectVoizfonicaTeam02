package com.example.voiz_team02.data;

import com.example.voiz_team02.model.DonglePlans;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DongleRepository extends MongoRepository<DonglePlans, String> {

    List<DonglePlans> findAllById(String id);
}
