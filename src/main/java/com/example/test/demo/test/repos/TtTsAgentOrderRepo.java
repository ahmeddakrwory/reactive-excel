package com.example.test.demo.test.repos;

import com.example.test.demo.test.entitys.TtTsAgentOrder;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TtTsAgentOrderRepo extends ReactiveCrudRepository<TtTsAgentOrder,Integer> {
}
