package com.example.test.demo.test.repos;

import com.example.test.demo.test.entitys.TtOrganization;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrgannizationRepo  extends ReactiveCrudRepository<TtOrganization,Integer> {
}
