package com.example.test.demo.test.repos;

import com.example.test.demo.test.entitys.CancellationDetail;
import com.example.test.demo.test.entitys.CancellationDetailId;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CancellationDetailRepo  extends ReactiveCrudRepository<CancellationDetail, CancellationDetailId> {
}
