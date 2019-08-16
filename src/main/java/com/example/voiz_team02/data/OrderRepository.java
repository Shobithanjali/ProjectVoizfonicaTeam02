package com.example.voiz_team02.data;

import com.example.voiz_team02.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {

    List<Order> findAllByuserId(String id);
}
