package com.example.test.demo.test.repos;

import com.example.test.demo.test.entitys.TtTsFbInvoiceDetail;
import com.example.test.demo.test.entitys.TtTsFbInvoiceDetailId;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TtTsFbInvoiceDetailRepos extends ReactiveCrudRepository<TtTsFbInvoiceDetail, TtTsFbInvoiceDetailId> {
}
