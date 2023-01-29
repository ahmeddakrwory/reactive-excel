package com.example.test.demo.test.repos;

import com.example.test.demo.test.entitys.VvUserLockedItr;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VvUserLockedItrRrpo extends ReactiveCrudRepository<VvUserLockedItr,Integer> {
}
