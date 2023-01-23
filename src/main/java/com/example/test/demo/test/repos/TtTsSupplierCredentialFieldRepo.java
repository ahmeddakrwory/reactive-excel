package com.example.test.demo.test.repos;

import com.example.test.demo.test.entitys.TtTsSupplierCredentialField;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TtTsSupplierCredentialFieldRepo extends ReactiveCrudRepository<TtTsSupplierCredentialField,Integer> {
}
