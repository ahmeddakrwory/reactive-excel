package com.example.test.demo.test.repos;

import com.example.test.demo.test.entitys.RvPnrimportHistory;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;

@Repository
@Transactional
public interface
RvPnrimportHistoryRepo extends R2dbcRepository<RvPnrimportHistory,String> {
   Flux<RvPnrimportHistory> findAllByOrgname(String orgname) ;
}
