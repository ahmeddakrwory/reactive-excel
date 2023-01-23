package com.example.test.demo.test.repos;

import com.example.test.demo.test.entitys.TtTsTransaction;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TtTsTransactionRepo  extends ReactiveCrudRepository<TtTsTransaction,Integer> {
}
