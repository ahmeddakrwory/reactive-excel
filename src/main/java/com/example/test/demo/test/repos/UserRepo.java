package com.example.test.demo.test.repos;

import com.example.test.demo.test.entitys.TtUser;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends ReactiveCrudRepository<TtUser,Long> {
}
