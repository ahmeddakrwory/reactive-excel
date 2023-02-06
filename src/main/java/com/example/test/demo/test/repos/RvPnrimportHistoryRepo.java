package com.example.test.demo.test.repos;

import com.example.test.demo.test.entitys.RvPnrimportHistory;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface
RvPnrimportHistoryRepo extends ReactiveCrudRepository<RvPnrimportHistory,String> {
//    Flux<RvPnrimportHistory>findRvPnrimportHistoriesByOrgname(String orgname);
}
