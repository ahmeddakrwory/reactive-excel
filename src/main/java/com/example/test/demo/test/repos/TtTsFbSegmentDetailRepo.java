package com.example.test.demo.test.repos;

import com.example.test.demo.test.entitys.TtTsFbSegmentDetail;
import com.example.test.demo.test.entitys.TtTsFbSegmentDetailId;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TtTsFbSegmentDetailRepo extends ReactiveCrudRepository<TtTsFbSegmentDetail, TtTsFbSegmentDetailId> {
}
