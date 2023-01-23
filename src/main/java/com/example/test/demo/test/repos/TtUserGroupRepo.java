package com.example.test.demo.test.repos;

import com.example.test.demo.test.entitys.TtUserGroup;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TtUserGroupRepo  extends ReactiveCrudRepository<TtUserGroup,Integer> {
}
