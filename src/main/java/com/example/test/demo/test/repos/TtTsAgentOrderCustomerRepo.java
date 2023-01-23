package com.example.test.demo.test.repos;

import com.example.test.demo.test.entitys.TtTsAgentOrderCustomer;
import com.example.test.demo.test.entitys.TtTsAgentOrderCustomerId;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TtTsAgentOrderCustomerRepo  extends ReactiveCrudRepository<TtTsAgentOrderCustomer, TtTsAgentOrderCustomerId> {
}
