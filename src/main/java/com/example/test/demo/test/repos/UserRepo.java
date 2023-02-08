package com.example.test.demo.test.repos;

import com.example.test.demo.test.entitys.TtUser;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public interface UserRepo extends R2dbcRepository<TtUser,Long> {


}
