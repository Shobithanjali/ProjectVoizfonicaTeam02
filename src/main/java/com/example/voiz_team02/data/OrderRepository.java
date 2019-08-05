package com.example.voiz_team02.data;

import com.example.voiz_team02.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}
