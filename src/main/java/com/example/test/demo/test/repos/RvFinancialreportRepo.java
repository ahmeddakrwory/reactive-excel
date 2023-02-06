package com.example.test.demo.test.repos;

import com.example.test.demo.test.entitys.RvFinancialreport;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RvFinancialreportRepo extends ReactiveCrudRepository<RvFinancialreport,String> {
}
