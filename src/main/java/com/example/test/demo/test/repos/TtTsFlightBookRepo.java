package com.example.test.demo.test.repos;

import com.example.test.demo.test.entitys.TtTsFlightBook;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TtTsFlightBookRepo extends ReactiveCrudRepository<TtTsFlightBook,Integer> {
}
