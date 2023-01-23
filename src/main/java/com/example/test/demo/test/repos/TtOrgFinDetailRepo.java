package com.example.test.demo.test.repos;

import com.example.test.demo.test.entitys.TtOrgFinDetail;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TtOrgFinDetailRepo extends ReactiveCrudRepository<TtOrgFinDetail,String> {
}
